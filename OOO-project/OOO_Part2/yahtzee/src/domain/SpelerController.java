package domain;

import db.SpelersLijst;

import java.util.ArrayList;

public class SpelerController {
    private int currentSpeler = 0;
    private SpelersLijst spelersLijst;

    public SpelerController(){
        spelersLijst = new SpelersLijst();
    }

    public void createSpeler(String name){
        Speler speler = new Speler(name);

        if(spelersLijst.beschikbareSpeler(speler)) {
            spelersLijst.addSpeler(speler);
        } else {
            throw new DomainException("Deze naam is al in gebruik.");
        }
    }

    public String getNextSpeler(){
        Speler speler = spelersLijst.getSpeler(currentSpeler);
        currentSpeler++;
        return speler.getNaam();

    }

    public int getDice(int i ){
        return spelersLijst.getSpeler(currentSpeler - 1)
                           .getDobbelsteen(i);
    }

    public void rolDices(){
        spelersLijst.getSpeler(currentSpeler - 1)
                    .rolDobbelstenen();
    }
}
