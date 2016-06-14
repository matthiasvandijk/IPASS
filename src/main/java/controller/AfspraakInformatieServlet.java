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
import model.domain.Slb;

public class AfspraakInformatieServlet extends HttpServlet {
	private static final long serialVersionUID = -2134360385556259476L;
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
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_informatie.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check: Heeft afspraak een student koppeling?
		if (afspraak.getStudent() == null) {
			req.setAttribute("error","Afspraak bevat geen student.");
			RequestDispatcher rd =req.getRequestDispatcher("/afspraak_informatie.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		//Check: juiste slber?
		Slb slb = (Slb) req.getSession().getAttribute("user");
		
		if (!slb.equals(afspraak.getSlber())) {
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
		req.setAttribute("studentnaam", afspraak.getStudent().getVolledigeNaam());
		req.setAttribute("onderwerp", afspraak.getOnderwerp());
		
		RequestDispatcher rd =req.getRequestDispatcher("/afspraak_informatie.jsp");            
		rd.forward(req, resp);
		return;
		
		
		
	}
}
