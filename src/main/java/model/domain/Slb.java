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
}
