package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.Student;

public class StudentDAO  extends BaseDAO {
	private SlbDAO slbDAO = new SlbDAO();
	
	private List<Student> selectStudenten(String query, ArrayList<Object> values) {
		List<Student> results = new ArrayList<Student>();
		
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
				
				int idStudent = dbResultSet.getInt("idStudent");
				String email = dbResultSet.getString("email");
				String wachtwoord = dbResultSet.getString("wachtwoord");
				String voornaam = dbResultSet.getString("voornaam");
				String achternaam = dbResultSet.getString("achternaam");
				int idSlb = dbResultSet.getInt("idSlb");
				
				Student newStudent = new Student(email, wachtwoord, voornaam, achternaam, slbDAO.findById(idSlb), idStudent);
				
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
	
	public List<Student> findAllBySlb(int idSlb) {
		ArrayList<Object> slbers = new ArrayList<>();
		slbers.add(idSlb);
		return selectStudenten("SELECT idStudent, email, wachtwoord, voornaam, achternaam, idSlb FROM Student WHERE idSlb = ?", slbers);
	}
	
	public Student findById(int idStudent) {
		ArrayList<Object> studenten = new ArrayList<>();
		studenten.add(idStudent);
		
		List<Student> student = selectStudenten("SELECT idStudent, email, wachtwoord, voornaam, achternaam, idSlb FROM Student WHERE idStudent = ?", studenten);
		if (student == null) {
			return null;
		}
		return student.get(0);
	}
	
	public Student findByEmail(String email) {
		ArrayList<Object> studenten = new ArrayList<>();
		studenten.add(email);
		
		List<Student> student = selectStudenten("SELECT idStudent, email, wachtwoord, voornaam, achternaam, idSlb FROM Student WHERE email = ?", studenten);
		if (student == null) {
			return null;
		}
		return student.get(0);
	}	
	
	public Boolean veranderSlb(int idSlb, int idStudent) {
		Boolean result = false;
		String query = "UPDATE Student SET idSlb=? WHERE idStudent=?";
		
		try (Connection con = super.getConnection()) {
			java.sql.PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, idSlb);
			ps.setInt(2, idStudent);
			
			if (ps.executeUpdate() == 1) { // 1 row updated!
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
}