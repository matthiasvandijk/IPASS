package persistence;

import model.domain.Slb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SlbDAO  extends BaseDAO {
	
	private List<Slb> selectSlbers(String query, ArrayList<Object> values) {
		List<Slb> results = new ArrayList<Slb>();
		
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
				int idSlb = dbResultSet.getInt("idSlb");
				String email = dbResultSet.getString("email");
				String wachtwoord = dbResultSet.getString("wachtwoord");
				String voornaam = dbResultSet.getString("voornaam");
				String achternaam = dbResultSet.getString("achternaam");
				
				Slb newStudent = new Slb(email, wachtwoord, voornaam, achternaam, idSlb);
				
				results.add(newStudent);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		if (results.isEmpty()) {
			return null;
		}
	
		return results;
	}
		

	public Slb findById(int idSlb) {
		ArrayList<Object> slbers = new ArrayList<>();
		slbers.add(idSlb);
		
		List<Slb> slb = selectSlbers("SELECT idSlb, email, wachtwoord, voornaam, achternaam FROM slb WHERE idSlb = ?", slbers);
		if (slb == null) {
			return null;
		}
		return slb.get(0);
	}
	

	public Slb findByEmail(String email) {
		ArrayList<Object> slbers = new ArrayList<>();
		slbers.add(email);
		List<Slb> slb = selectSlbers("SELECT idSlb, email, wachtwoord, voornaam, achternaam FROM slb WHERE email = ?", slbers);
		if (slb == null) {
			return null;
		}
		return slb.get(0);
	}
	
}
