package model.domain;

public class Slb extends Persoon {
	private int id_slb;
	
	public Slb(String email, String wachtwoord, String voornaam, String achternaam, int id_slb) {
		super(email, wachtwoord, voornaam, achternaam);
		this.id_slb = id_slb;
	}

	public int getSlb_id() {
		return id_slb;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_slb;
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
		Slb other = (Slb) obj;
		if (id_slb != other.id_slb)
			return false;
		return true;
	}
}
