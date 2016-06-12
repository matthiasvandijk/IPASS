package model.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Afspraak {
	private int id_afspraak;
	private Calendar datum;
	private Date begintijd;
	private Date eindtijd;
	private String locatie;
	private String onderwerp;
	private Slb slber;
	private Student student;
	
	public Afspraak(int id_afspraak, String datum, String begintijd, String eindtijd, 
			String locatie,  Slb slber) throws ParseException {
		
		this.id_afspraak = id_afspraak;
		
		//String 'datum' to Calendar 'datum'.
		Calendar cal = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cal.setTime(sdf.parse(datum));
		
		this.datum = cal;
		
		//String begintijd/eindtijd to Date 'datebegintijd/dateeindtijd'.
		SimpleDateFormat sdf_tijd = new SimpleDateFormat("HH:mm");
		Date datebegintijd = sdf_tijd.parse(begintijd);
		this.begintijd = datebegintijd;
		
		Date dateeindtijd = sdf_tijd.parse(eindtijd);
		this.eindtijd = dateeindtijd;
		
		this.locatie = locatie;
		this.onderwerp = null;
		this.slber = slber;
		this.student = null;
		
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId_afspraak() {
		return id_afspraak;
	}

	public Calendar getDatum() {
		return datum;
	}

	public Date getBegintijd() {
		return begintijd;
	}

	public Date getEindtijd() {
		return eindtijd;
	}

	public String getLocatie() {
		return locatie;
	}

	public Slb getSlber() {
		return slber;
	}
	
	
}
