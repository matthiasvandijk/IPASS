package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServiceProvider;
import model.SysteemService;
import model.domain.Afspraak;
import model.domain.Student;

public class StudentAfspraakInplannenServlet extends HttpServlet {
	private static final long serialVersionUID = -7070667818781612635L;
	private SysteemService sp = ServiceProvider.getService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String afspraakId_string = req.getParameter("aID");
		
		//Check: String naar ID
		int afspraakId;
		try {
			afspraakId = Integer.parseInt(afspraakId_string);
		  } catch (NumberFormatException e) {
			  resp.sendRedirect("student/");
			  return;
		 }
		
		Afspraak afspraak = null;
		try {
			afspraak = sp.getAfspraakById(afspraakId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Check: Afspraak niet gevonden?
		if (afspraak == null) {
			req.setAttribute("error","Afspraak niet gevonden.");
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_inplannen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check: Afspraak niet al bezet?
		if (afspraak.getStudent() != null) {
			req.setAttribute("error","Helaas, iemand anders heeft al deze afspraak ingepland. De afspraak is bezet.");
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_inplannen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check: juiste slber?
		Student student = (Student) req.getSession().getAttribute("user");
		
		if (!student.getSlber().equals(afspraak.getSlber())) {
			resp.sendRedirect("student/");
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("(EEE) dd-MM-yyyy");
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm");	
		
		req.setAttribute("datum", sdf.format(afspraak.getDatum().getTime()));
		req.setAttribute("begintijd", sdf_tijd.format(afspraak.getBegintijd()));
		req.setAttribute("eindtijd", sdf_tijd.format(afspraak.getEindtijd()));
		req.setAttribute("locatie", afspraak.getLocatie());
		req.setAttribute("afspraakId", afspraak.getId_afspraak());
		
		RequestDispatcher rd =req.getRequestDispatcher("/afspraak_inplannen.jsp");            
		rd.forward(req, resp);
		return;
		}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String afspraakId_string = req.getParameter("afspraakId");
		String onderwerp = req.getParameter("onderwerp");
		
		//Check: String naar ID
		int afspraakId;
		try {
			afspraakId = Integer.parseInt(afspraakId_string);
		  } catch (NumberFormatException e) {
			  resp.sendRedirect("student/");
			  return;
		 }
		
		Afspraak afspraak = null;
		try {
			afspraak = sp.getAfspraakById(afspraakId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Check: Afspraak niet gevonden?
		if (afspraak == null) {
			resp.sendRedirect("student/");
			return;
		}
		
		//Check: Afspraak niet al bezet?
		if (afspraak.getStudent() != null) {
			req.setAttribute("error","Helaas, iemand anders heeft al deze afspraak ingepland. De afspraak is bezet.");
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_inplannen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check: juiste slber?
		Student student = (Student) req.getSession().getAttribute("user");
		
		if (!student.getSlber().equals(afspraak.getSlber())) {
			resp.sendRedirect("student/");
			return;
		}
		
		if (sp.afspraakInplannen(student.getId_student(), afspraak.getId_afspraak(), onderwerp)) {
			req.setAttribute("success","Je hebt succesvol een afspraak ingepland.");
			RequestDispatcher rd =req.getRequestDispatcher("/studentdashboard.jsp");            
			rd.forward(req, resp);
			return;
		} else {
			req.setAttribute("error","Oops, er ging iets mis! Probeer het later nog eens. (Er is GEEN afspraak ingepland)");
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_inplannen.jsp");            
			rd.forward(req, resp);
			return;
		}
		
	}
}
