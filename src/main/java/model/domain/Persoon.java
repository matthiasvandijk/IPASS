package model.domain;

public class Persoon {
	private String email;
	private String wachtwoord;
	private String voornaam;
	private String achternaam;
	
	public Persoon(String email, String wachtwoord, String voornaam, String achternaam) {
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
	}
	
	public String getEmail() {
		return email;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}
	
	public boolean verifyPassword(String wachtwoord) {
		return this.wachtwoord.equals(wachtwoord);
	}
}
