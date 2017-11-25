package domain;

public class Speler {
	private String naam;
	private Dobbelsteen[] dobbelstenen;
	
	public Speler(String naam) {
		this.setNaam(naam);
        dobbelstenen = new Dobbelsteen[5];
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
	
	@Override
    	public boolean equals(Object o){
        if( o == null ){
            throw new DomainException();
        }

        Speler s = (Speler)o;
        return this.getNaam()
                   .equals(s.getNaam());

    }
}
