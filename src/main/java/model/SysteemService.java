package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.domain.Afspraak;
import model.domain.Slb;
import model.domain.Student;
import persistence.AfspraakDAO;
import persistence.SlbDAO;
import persistence.StudentDAO;

public class SysteemService {
	private SlbDAO slbDAO = new SlbDAO();
	private StudentDAO studentDAO = new StudentDAO();
	private AfspraakDAO afspraakDAO = new AfspraakDAO();
	
	public Slb getSlbByEmail(String email) {
		return slbDAO.findByEmail(email);
	}
	
	public Student getStudentByEmail(String email) {
		return studentDAO.findByEmail(email);
	}
	
	public Student getStudentById(int idStudent) {
		return studentDAO.findById(idStudent);
	}
	
	public String minToH_M(int t) { //Essential for 'createAfspraak'
		int u = (t / 60) % 24;  // calc aantal uur
		int m = t % 60;         // calc aantal min
		
		return String.format("%02d:%02d", u, m);
	}
	
	public List<Afspraak> getAfsprakenByWeekSlb(Slb slb, Calendar datum) throws ParseException {
		return afspraakDAO.getAfsprakenByWeekAndSlb(datum.get(Calendar.WEEK_OF_YEAR), datum.get(Calendar.YEAR), slb);
	}
	
	public boolean createAfspraak(Calendar datum, Date begintijd, Date eindtijd, String checkbox_split, int split, String locatie ,Slb slb) throws ParseException {
		
		long diff = eindtijd.getTime() - begintijd.getTime();
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
		
		if (afspraakDAO.openstellenMogelijkheid(datum, begintijd, eindtijd)) {
			if (checkbox_split != null) {
				//do split...
				int aantal_keer = (int) Math.floor(minutes / split);
				int begintijd_min = (int)  Math.floor(TimeUnit.MILLISECONDS.toMinutes(begintijd.getTime()) + 60); //Bug? getTime is always missing 60 min.
				int eindtijd_min = begintijd_min;
				
				SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm");
				
				for (int i = 0; i < aantal_keer; i++) {
					Date begintijd_calc = null;
					Date eindtijd_calc = null;
					if (i != (aantal_keer - 1)) {
						//Normale cyclus
						
						if (i != 0) {
							begintijd_min = begintijd_min + split;
						}
						eindtijd_min = begintijd_min + split;
						
						try {
							begintijd_calc = sdf_tijd.parse(this.minToH_M(begintijd_min));
							eindtijd_calc = sdf_tijd.parse(this.minToH_M(eindtijd_min));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} else {
						//Laatste keer loop
						begintijd_min = begintijd_min + split;
						eindtijd_min = begintijd_min + (int) (minutes - ((aantal_keer - 1) * split));
						
						try {
							begintijd_calc = sdf_tijd.parse(this.minToH_M(begintijd_min));
							eindtijd_calc = sdf_tijd.parse(this.minToH_M(eindtijd_min));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					//Create Afspraak (For loop)
					afspraakDAO.insert(datum, begintijd_calc, eindtijd_calc, locatie, slb);
				}
				return true;
				
			} else {
				//Create Afpsraak (No split)
				afspraakDAO.insert(datum, begintijd, eindtijd, locatie, slb);
				return true;
			}
		} else {
			return false;
		}
		
	}
	
}
