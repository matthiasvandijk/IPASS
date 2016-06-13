package model.domain;

import java.text.ParseException;
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
	
	public Afspraak(int id_afspraak, Calendar datum, Date begintijd, Date eindtijd, 
			String locatie, String onderwerp,  Slb slber, Student student) throws ParseException {
		
		this.id_afspraak = id_afspraak;
		this.datum = datum;
		this.begintijd = begintijd;
		this.eindtijd = eindtijd;
		this.locatie = locatie;
		this.onderwerp = onderwerp;
		this.slber = slber;
		this.student = student;
		
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
