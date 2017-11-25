package domain;

import db.SpelersLijst;

import java.util.ArrayList;

public class SpelerController {
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

    public void getSpelers(){
        for(Speler s : spelersLijst.getSpelers()){
            System.out.print(s.getNaam() + " - ");
        }
    }
}
