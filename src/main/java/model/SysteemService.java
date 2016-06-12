package model;

import model.domain.Slb;
import model.domain.Student;
import persistence.SlbDAO;
import persistence.StudentDAO;

public class SysteemService {
	private SlbDAO slbDAO = new SlbDAO();
	private StudentDAO studentDAO = new StudentDAO();
	
	public Slb getSlbByEmail(String email) {
		return slbDAO.findByEmail(email);
	}
	
	public Student getStudentByEmail(String email) {
		return studentDAO.findByEmail(email);
	}
	
}
