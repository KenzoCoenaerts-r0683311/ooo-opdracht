package domain;

import java.util.ArrayList;

public class SpelersLijst {
	private ArrayList<Speler> spelersLijst;

	public SpelersLijst() {
		spelersLijst = new ArrayList<Speler>();
	}

	public ArrayList<Speler> getSpelers() {
		return spelersLijst;
	}

	public void addSpeler(Speler nieuweSpeler) {
		beschikbareSpeler(nieuweSpeler.getNaam());
		spelersLijst.add(nieuweSpeler);
	}

	public void beschikbareSpeler(String nieuweSpeler) {
		for (Speler speler : this.getSpelers()) {
			if (speler.getNaam().equals(nieuweSpeler)) {
				throw new DomainException("Deze naam is al in gebruik.");
			}
		}
	}

}
