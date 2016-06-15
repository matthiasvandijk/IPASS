package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import model.ServiceProvider;
import model.SysteemService;
import model.domain.Afspraak;
import model.domain.Slb;
import model.domain.Student;

public class StudentRoosterServlet extends HttpServlet {
	private static final long serialVersionUID = -6130414436416833725L;
	private SysteemService sp = ServiceProvider.getService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		Calendar datum = Calendar.getInstance();
		
		
		if (type.equals("anders")) {
			String web_week = req.getParameter("web_week");
			int web_week_int;
			try {
				web_week_int = Integer.parseInt(web_week);
			} catch(NumberFormatException e){
				//Parsing fails:
				web_week_int = datum.get(Calendar.WEEK_OF_YEAR);
		    }
			datum.setWeekDate(datum.get(Calendar.YEAR), web_week_int, Calendar.MONDAY);
		}
		
		Student student = (Student) req.getSession().getAttribute("user");
		Slb slb = student.getSlber();
		
		ArrayList<Afspraak> afspraken = null;
		try {
			afspraken = (ArrayList<Afspraak>) sp.getAfsprakenByWeekSlbforStudent(slb, datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int week = datum.get(Calendar.WEEK_OF_YEAR);
		ArrayList<Calendar> weekdata = new ArrayList<>();
		
		Calendar maandag = Calendar.getInstance();
		maandag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.MONDAY);
		weekdata.add(maandag);
		
		Calendar dinsdag = Calendar.getInstance();
		dinsdag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.TUESDAY);
		weekdata.add(dinsdag);
		
		Calendar woensdag = Calendar.getInstance();
		woensdag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.WEDNESDAY);
		weekdata.add(woensdag);
		
		Calendar donderdag = Calendar.getInstance();
		donderdag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.THURSDAY);
		weekdata.add(donderdag);
		
		Calendar vrijdag = Calendar.getInstance();
		vrijdag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.FRIDAY);
		weekdata.add(vrijdag);
		
		Calendar zaterdag = Calendar.getInstance();
		zaterdag.setWeekDate(datum.get(Calendar.YEAR), week, Calendar.SATURDAY);
		weekdata.add(zaterdag);
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM");
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm");	
		
		for (int y = 0; y < weekdata.size(); y++) {
			JsonObjectBuilder job_dates = Json.createObjectBuilder();
			job_dates.add("datum", StringEscapeUtils.escapeXml11(sdf.format(weekdata.get(y).getTime())));
			
			JsonArrayBuilder jab_blok = Json.createArrayBuilder();
			JsonObjectBuilder job_afspraken = Json.createObjectBuilder();
			
			if (afspraken != null) {
				for (int i = 0; i < afspraken.size(); i++) {
					
					if (afspraken.get(i).sameDate(weekdata.get(y))) {
						job_afspraken.add("idAfspraak", afspraken.get(i).getId_afspraak());
						job_afspraken.add("begintijd", StringEscapeUtils.escapeXml11(sdf_tijd.format(afspraken.get(i).getBegintijd())));
						job_afspraken.add("eindtijd", StringEscapeUtils.escapeXml11(sdf_tijd.format(afspraken.get(i).getEindtijd())));
						job_afspraken.add("locatie", StringEscapeUtils.escapeXml11(afspraken.get(i).getLocatie()));
						
						if (afspraken.get(i).getStudent() == null) {
							job_afspraken.addNull("studentnaam");
						} else if (afspraken.get(i).getStudent().equals(student)) {
							job_afspraken.add("studentnaam", StringEscapeUtils.escapeXml11(afspraken.get(i).getStudent().getVolledigeNaam()));
						} else {
							job_afspraken.add("studentnaam", "BEZET");
						}
						jab_blok.add(job_afspraken);
					}
					
				}
				
			}
			job_dates.add("blok", jab_blok);
			jab.add(job_dates);
			
		}
		//Add current week.
		JsonObjectBuilder job_week = Json.createObjectBuilder();
		job_week.add("week", week);
		jab.add(job_week);
		
		String json = jab.build().toString();
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}

}
