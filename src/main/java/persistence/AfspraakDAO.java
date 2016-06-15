package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.domain.Afspraak;
import model.domain.Slb;
import model.domain.Student;

public class AfspraakDAO extends BaseDAO {
	private StudentDAO studentDAO = new StudentDAO();
	private SlbDAO slbDAO = new SlbDAO();

	private List<Afspraak> selectAfspraken(String query, ArrayList<Object> values) throws ParseException {
		List<Afspraak> results = new ArrayList<Afspraak>();
		
		try (Connection con = super.getConnection()) {
			java.sql.PreparedStatement ps = con.prepareStatement(query);
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) instanceof String) {
					ps.setString((i + 1), (String) values.get(i));
				} else if (values.get(i) instanceof Integer) {
					ps.setInt((i + 1), (Integer) values.get(i));
				}
			}

			ResultSet dbResultSet = ps.executeQuery();
			
			while (dbResultSet.next()) {
				int idAfspraak = dbResultSet.getInt("idAfspraak");
				int idSlb = dbResultSet.getInt("idSlb");
				
				Calendar datum = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String datum_db = dbResultSet.getString("datum");
				datum.setTime(sdf.parse(datum_db));
				
				
				SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm:ss");
				Date begintijd = null;
				Date eindtijd = null;
				
				String begintijd_db = dbResultSet.getString("begintijd");
				String eindtijd_db = dbResultSet.getString("eindtijd");
				
				begintijd = sdf_tijd.parse(begintijd_db);
				eindtijd = sdf_tijd.parse(eindtijd_db);
				
				
				String locatie = dbResultSet.getString("locatie");
				String onderwerp = dbResultSet.getString("onderwerp");
				int idStudent = dbResultSet.getInt("idStudent");
				
				Slb slber = (Slb) slbDAO.findById(idSlb);
				Student student = (Student) studentDAO.findById(idStudent);
				
				
				Afspraak newAfspraak = new Afspraak(idAfspraak, datum, begintijd, eindtijd, locatie, onderwerp, slber, student);
				
				results.add(newAfspraak);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		if (results.isEmpty()) {
			return null;
		}
	
		return results;
	}
	
	public Afspraak findById(int afspraakId) throws ParseException {
		ArrayList<Object> afspraken = new ArrayList<>();
		afspraken.add(afspraakId);
		
		List<Afspraak> afspraak = selectAfspraken("SELECT * FROM Afspraak WHERE idAfspraak = ?", afspraken);
		if (afspraak == null) {
			return null;
		}
		return afspraak.get(0);
	}
	
	public boolean afspraakVerwijderen(int afspraakId) {
		boolean result = false;
		String query = "DELETE FROM Afspraak WHERE idAfspraak=?;";
		
		try (Connection con = super.getConnection()) {
			java.sql.PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, afspraakId);

			if (ps.executeUpdate() == 1) { // 1 row updated!
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public boolean afspraakInplannen(int afspraakId, String onderwerp, int studentId) {
		boolean result = false;
		String query = "UPDATE Afspraak SET onderwerp=?, idStudent=? WHERE idAfspraak=?;";
		
		try (Connection con = super.getConnection()) {
			java.sql.PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, onderwerp);
			ps.setInt(2, studentId);
			ps.setInt(3, afspraakId);

			if (ps.executeUpdate() == 1) { // 1 row updated!
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public boolean openstellenMogelijkheid(Calendar datum, Date begintijd, Date eindtijd, Slb slb) throws ParseException {
		Boolean result = false;
		String query = "SELECT * FROM Afspraak WHERE idSlb=? AND datum= ? AND ((? = begintijd) or (? = eindtijd) "
				+ "or (begintijd >? AND begintijd < ?) or (eindtijd > ? AND eindtijd < ?));";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm:ss");
		
		String datum_db = sdf.format(datum.getTime());
		String begintijd_db = sdf_tijd.format(begintijd);
		String eindtijd_db = sdf_tijd.format(eindtijd);
		
		ArrayList<Object> data = new ArrayList<>();
		data.add(slb.getSlb_id());
		data.add(datum_db);
		data.add(begintijd_db);
		data.add(eindtijd_db);
		data.add(begintijd_db);
		data.add(eindtijd_db);
		data.add(begintijd_db);
		data.add(eindtijd_db);
		
		if (selectAfspraken(query, data) == null) {
			return true;
		}
		
		return result;
	}
	
	public List<Afspraak> getAfsprakenByWeekAndSlb(int week, int jaar, Slb slb) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar datum = Calendar.getInstance();
		datum.setWeekDate(jaar, week, Calendar.MONDAY);
		String maandag = sdf.format(datum.getTime());
		
		datum.setWeekDate(jaar, week, Calendar.SATURDAY);
		String zaterdag = sdf.format(datum.getTime());
		
		String query = "SELECT * FROM Afspraak WHERE datum BETWEEN CAST(? AS DATE) "
				+ "AND CAST(? AS DATE) AND idSlb=? order by datum, begintijd asc;";
		
		ArrayList<Object> data = new ArrayList<>();
		data.add(maandag);
		data.add(zaterdag);
		data.add(slb.getSlb_id());
		
		return selectAfspraken(query, data);
	}
	
	public boolean insert(Calendar datum, Date begintijd, Date eindtijd, String locatie ,Slb slb) {
		Boolean result = false;
		String query = "INSERT INTO Afspraak (`idSlb`, `datum`, `begintijd`, `eindtijd`, `locatie`, `onderwerp`, `idStudent`)"
				+ " VALUES (?, ?, ?, ?, ?, NULL, NULL);";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm:ss");
		
		String datum_db = sdf.format(datum.getTime());
		String begintijd_db = sdf_tijd.format(begintijd);
		String eindtijd_db = sdf_tijd.format(eindtijd);
		
		try (Connection con = super.getConnection()) {
			java.sql.PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, slb.getSlb_id());
			ps.setString(2, datum_db);
			ps.setString(3, begintijd_db);
			ps.setString(4, eindtijd_db);
			ps.setString(5, locatie);
			
			if (ps.executeUpdate() == 1) { // 1 row updated!
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
}
