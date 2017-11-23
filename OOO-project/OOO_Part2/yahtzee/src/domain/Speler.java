package domain;

public class Speler {

	private String naam;
	
	public Speler(String naam) {
		this.setNaam(naam);
	}
	
	public String getNaam() {
		return naam;
	}
	
	private void setNaam(String naam) {
		if(naam == null || naam.trim().isEmpty()){
			throw new DomainException("Geef een naam in.");
		}
		this.naam = naam;
	}

}
