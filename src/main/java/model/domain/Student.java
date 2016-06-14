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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_student;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id_student != other.id_student)
			return false;
		return true;
	}
	
	
}
