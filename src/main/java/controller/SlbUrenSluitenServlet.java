package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import model.ServiceProvider;
import model.SysteemService;
import model.domain.Afspraak;
import model.domain.Slb;

public class SlbUrenSluitenServlet extends HttpServlet {
	private static final long serialVersionUID = 2244014373699174829L;
	private SysteemService sp = ServiceProvider.getService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uren = req.getParameter("uren");
		
		//Check: Parameter leeg of niet bestaand?
		if (uren == "" || uren == null) {
			req.setAttribute("errorUrenSluiten","Geen uren geselecteerd, kan niks sluiten.");
			RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		List<String> items = Arrays.asList(uren.split("\\s*;\\s*"));
		
		//Check: Alle IDs ook daadwerkelijk integers?
		ArrayList<Integer> urenIds = new ArrayList<Integer>();
		for (int i = 0; i < items.size(); i++) {
			int id = 0;
			try {
				id = Integer.parseInt(items.get(i));
			} catch(NumberFormatException e){
				req.setAttribute("errorUrenSluiten","Helaas ging hier iets fout. (Fout input formaat(UrenSluiten)).");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			urenIds.add(id);
		}
		
		Slb slb = (Slb) req.getSession().getAttribute("user");
		
		
		ArrayList<String> afspraak_informatie_list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd LLL");
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm");	
		
		//Checks voor alle afspraak Ids:
		for (int i = 0; i < urenIds.size(); i++) {
			Afspraak afspraak = null;
			try {
				afspraak = sp.getAfspraakById(urenIds.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Check: bestaat de afspraak?
			if (afspraak == null) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn niet gevonden.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			
			//Check: juiste SLBer?
			if (!afspraak.getSlber().equals(slb)) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn niet gekoppeld aan uw account.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			
			//Check: is de afspraak al ingepland?
			if (afspraak.getStudent() != null) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn al ingepland door een student. "
						+ "Een ingeplande afspraak kan (nog) niet worden gesloten.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			
			//Alle attributes toevoegen om de req af te handelen
			String toevoegen = StringEscapeUtils.escapeXml11(sdf.format(afspraak.getDatum().getTime())) + " | " + StringEscapeUtils.escapeXml11(sdf_tijd.format(afspraak.getBegintijd()))
			+ " - " + StringEscapeUtils.escapeXml11(sdf_tijd.format(afspraak.getEindtijd())) + " | (" + StringEscapeUtils.escapeXml11(afspraak.getLocatie()) + ")";
			afspraak_informatie_list.add(toevoegen);
		}
		
		//Alle checks zijn ok, kan forwarden:
		req.setAttribute("afspraken", afspraak_informatie_list);
		req.setAttribute("uren", uren);
		RequestDispatcher rd =req.getRequestDispatcher("/uren_sluiten.jsp");            
		rd.forward(req, resp);
		return;
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uren = req.getParameter("uren");

		//Check: Parameter leeg of niet bestaand?
		if (uren == "" || uren == null) {
			req.setAttribute("errorUrenSluiten","Geen uren geselecteerd, kan niks sluiten.");
			RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
			rd.forward(req, resp);
			return;
		}

		List<String> items = Arrays.asList(uren.split("\\s*;\\s*"));

		//Check: Alle IDs ook daadwerkelijk integers?
		ArrayList<Integer> urenIds = new ArrayList<Integer>();
		for (int i = 0; i < items.size(); i++) {
			int id = 0;
			try {
				id = Integer.parseInt(items.get(i));
			} catch(NumberFormatException e){
				req.setAttribute("errorUrenSluiten","Helaas ging hier iets fout. (Fout input formaat(UrenSluiten)).");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			urenIds.add(id);
		}

		Slb slb = (Slb) req.getSession().getAttribute("user");

		//List voor alle opgehaalde afspraken
		ArrayList<Afspraak> afspraken = new ArrayList<>();

		//Checks voor alle afspraak Ids:
		for (int i = 0; i < urenIds.size(); i++) {
			Afspraak afspraak = null;
			try {
				afspraak = sp.getAfspraakById(urenIds.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Check: bestaat de afspraak?
			if (afspraak == null) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn niet gevonden.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}

			//Check: juiste SLBer?
			if (!afspraak.getSlber().equals(slb)) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn niet gekoppeld aan uw account.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}

			//Check: is de afspraak al ingepland?
			if (afspraak.getStudent() != null) {
				req.setAttribute("errorUrenSluiten","Minimaal één van de geselecteerde afspraken is/zijn al ingepland door een student. "
						+ "Een ingeplande afspraak kan (nog) niet worden gesloten.");
				RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
				rd.forward(req, resp);
				return;
			}
			
			//Checks zijn ok: Afspraak toevoegen:
			afspraken.add(afspraak);
		}
		
		//Checks voltooid
		//Uren kunnen verwijderd worden.
		
		boolean allesGelukt = true;
		for (int i = 0; i < afspraken.size(); i++) {
			boolean gelukt = sp.afspraakVerwijderen(afspraken.get(i).getId_afspraak());
			if (allesGelukt) { //Zolang True:
				allesGelukt = gelukt; //Als gelukt False is, wordt allesGelukt niet meer aangepast.
			}
		}
		
		//Als niet alle afspraken zijn verwijderd:
		if (!allesGelukt) {
			req.setAttribute("errorUrenSluiten","Er is iets fout gegaan. Mogelijk zijn niet alle uren gesloten!");
			RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
			rd.forward(req, resp);
			return;
		}
		
		req.setAttribute("success","De geselecteerde uren zijn succesvol gesloten!");
		RequestDispatcher rd =req.getRequestDispatcher("/slbdashboard.jsp");            
		rd.forward(req, resp);
		return;
	}
}
