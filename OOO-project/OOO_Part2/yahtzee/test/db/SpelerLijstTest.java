package db;

import domain.Speler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpelerLijstTest {
    private SpelersLijst spelersLijst= new SpelersLijst();

    @Test(expected = DbException.class)
    public void SpelersLijst_addSpeler_gooit_exception_als_speler_null(){
        spelersLijst.addSpeler(null);
    }

    @Test
    public void SpelersLijst_addSpeler_voeg_speler_toe(){
        spelersLijst.addSpeler(new Speler("kenzo"));
        assertEquals("kenzo", spelersLijst.getSpelers()
                                                   .get(0)
                                                   .getNaam());
    }

    @Test(expected = DbException.class)
    public void SpelersLijst_beschikbareSpeler_gooit_exception_als_speler_null(){
        spelersLijst.beschikbareSpeler(null);
    }

    @Test
    public void SpelersLijst_geeft_false_waneer_speler_niet_beschikbaar(){
        Speler s = new Speler("kenzo");
        Speler s2 = new Speler("kenzo");

        spelersLijst.addSpeler(s);
        assertFalse(spelersLijst.beschikbareSpeler(s2));
    }

    @Test
    public void SpelersLijst_geeft_true_waneer_speler_beschikbaar(){
        Speler s = new Speler("kenzo");
        Speler s2 = new Speler("banaan");

        spelersLijst.addSpeler(s);
        assertTrue(spelersLijst.beschikbareSpeler(s2));
    }
}
