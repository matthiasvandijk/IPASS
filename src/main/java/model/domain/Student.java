package model.domain;

public class Student extends Persoon {
	private int id_student;
	private Slb slber;
	
	public Student(String email, String wachtwoord, String voornaam, String achternaam, Slb slber, int id_student) {
		super(email, wachtwoord, voornaam, achternaam);
		this.slber = slber;
		this.id_student = id_student;
	}

	public Slb getSlber() {
		return slber;
	}

	public int getId_student() {
		return id_student;
	}
	
}
