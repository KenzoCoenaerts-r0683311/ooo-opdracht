package db;

import domain.Speler;

import java.util.ArrayList;

public class SpelersLijst {
	private ArrayList<Speler> spelersLijst;

	public SpelersLijst() {
		spelersLijst = new ArrayList<Speler>();
	}

	public ArrayList<Speler> getSpelers() {
		return this.spelersLijst;
	}

	public void addSpeler(Speler nieuweSpeler) {
		spelersLijst.add(nieuweSpeler);
	}

    public boolean beschikbareSpeler(Speler nieuweSpeler) {
        for (Speler speler : this.getSpelers()) {
            if (speler.equals(nieuweSpeler)){
                return false;
            }
        }

        return true;
    }
}
