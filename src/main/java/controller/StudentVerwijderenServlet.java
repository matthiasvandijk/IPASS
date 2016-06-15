package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import model.ServiceProvider;
import model.SysteemService;
import model.domain.Slb;
import model.domain.Student;

public class StudentVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = -3931919736149176525L;
	private SysteemService sp = ServiceProvider.getService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studentEmail = req.getParameter("studentEmail");
		String type = req.getParameter("type");
		
		//Check voor invoer: Mag niet leeg/null zijn.
		if (studentEmail == "" || studentEmail == null) {
			req.setAttribute("errorStudentEmail","Dit veld is verplicht!");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check voor email domein: @student.hu.nl
		int index = studentEmail.indexOf('@');
		
		if (index <= 0) {
			req.setAttribute("errorStudentEmail","E-mail moet onderdeel zijn van het domein 'student.hu.nl'!");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		String email_domain = studentEmail.substring(index);
		if (!email_domain.equals("@student.hu.nl")) {
			req.setAttribute("errorStudentEmail","E-mail moet onderdeel zijn van het domein 'student.hu.nl'!");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		Student student = sp.getStudentByEmail(studentEmail);
		
		//Check voor het niet voorkomen van de email in de database.
		if (student == null) {
			req.setAttribute("errorStudentEmail","E-mail komt niet voor in onze database.");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		Slb slb = (Slb) req.getSession().getAttribute("user");
		
		//Check, is de student al gekoppeld met de SLBer?
		if (student.getSlber() == null) {
			req.setAttribute("errorStudentEmail","" + StringEscapeUtils.escapeXml11(student.getVolledigeNaam()) + " is niet aan uw account toegevoegd "
					+ "en kan daarom ook niet van uw account worden verwijderd.");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		if (!student.getSlber().equals(slb)) {
			req.setAttribute("errorStudentEmail","" + StringEscapeUtils.escapeXml11(student.getVolledigeNaam()) + " is niet aan uw account toegevoegd "
					+ "en kan daarom ook niet van uw account worden verwijderd.");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Naar bevestig scherm?
		if (type == null) {
			req.setAttribute("studentEmail",student.getEmail());
			req.setAttribute("studentNaam",student.getVolledigeNaam());
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen_bevestig.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Is al bevestigd:
		boolean result = sp.setStudentSlb(0, student.getId_student());
		
		//Check DB update gelukt?
		if (result == false) {
			req.setAttribute("errorStudentEmail","Oops, er is iets misgegaan! De student is niet verwijderd.");
			RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
			rd.forward(req, resp);
			return;
		} 
		
		//Alle checks voltooid:
		req.setAttribute("studentVerwijderd","" + StringEscapeUtils.escapeXml11(student.getVolledigeNaam()) + " is succesvol van uw account verwijderd!");
		RequestDispatcher rd =req.getRequestDispatcher("/student_verwijderen.jsp");            
		rd.forward(req, resp);
		return;
		
	}
}
