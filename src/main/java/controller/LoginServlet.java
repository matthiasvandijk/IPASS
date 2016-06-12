package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServiceProvider;
import model.SysteemService;
import model.domain.Slb;
import model.domain.Student;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -173319121081412032L;
	private SysteemService sp = ServiceProvider.getService();


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("login_email");
		String wachtwoord = req.getParameter("login_password");
		
		int index = email.indexOf('@');
		String email_domain = email.substring(index);
		
		if (email_domain.equals("@student.hu.nl")) {
			//Email van een student.
			
			Student student = sp.getStudentByEmail(email);
			if (student != null && student.verifyPassword(wachtwoord)) {
				req.getSession().setAttribute("user", student);
				Cookie c = new Cookie("email", email);
				resp.addCookie(c);
				resp.sendRedirect("student/");
				return;
			} 
			
		} else if (email_domain.equals("@hu.nl")) {
			//Email van een docent (SLBer).
			
			Slb slber = sp.getSlbByEmail(email);
			if (slber != null && slber.verifyPassword(wachtwoord)) {
				req.getSession().setAttribute("user", slber);
				Cookie c = new Cookie("email", email);
				resp.addCookie(c);
				resp.sendRedirect("slb/");
				return;
			} 
			
		} else {
			//Domein is niet van de HU afkomstig.
		}
		
		//Email of Wachtwoord onjuist:
		
		System.out.println(email + wachtwoord);

		resp.sendRedirect(req.getContextPath() + "/"); 
	}
}
