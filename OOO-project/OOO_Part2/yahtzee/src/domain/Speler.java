package domain;

public class Speler {
	private String naam;
	private int[] dobbelstenen = new int[5];
	
	public Speler(String naam) {
		this.setNaam(naam);
		this.rolDobbelstenen();
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

    public int getDobbelsteen(int getDices){
	    if(getDices < 0){
	        throw new DomainException();
        }

        return this.dobbelstenen[getDices];
    }

    public void rolDobbelstenen(){
        for( int i = 0; i < 5; i++ ){
            dobbelstenen[i] = Dobbelsteen.getNumber();
        }
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
