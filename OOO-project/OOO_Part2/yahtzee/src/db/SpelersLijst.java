package db;

import domain.Speler;

import java.util.ArrayList;

public class SpelersLijst {
	private ArrayList<Speler> spelersLijst;

	public SpelersLijst() {
		spelersLijst = new ArrayList<Speler>();
	}

    public Speler getSpeler(int currentSpeler) {
        return spelersLijst.get(currentSpeler);
    }

	public ArrayList<Speler> getSpelers() {
		return this.spelersLijst;
	}

	public void addSpeler(Speler nieuweSpeler) {
	    if(nieuweSpeler == null){
            throw new DbException();
        }

		spelersLijst.add(nieuweSpeler);
	}

    public boolean beschikbareSpeler(Speler nieuweSpeler) {
        if(nieuweSpeler == null){
            throw new DbException();
        }

        for (Speler speler : this.getSpelers()) {
            if (speler.equals(nieuweSpeler)){
                return false;
            }
        }

        return true;
    }
}
