package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpelerTest {
    private Speler speler;

    @Test(expected = DomainException.class)
    public void speler_gooi_exception_als_naam_null(){
        speler = new Speler(null);
    }

    @Test(expected = DomainException.class)
    public void speler_gooi_exception_als_naam_leeg(){
        speler = new Speler("  ");
    }

    @Test
    public void maak_speler_met_gegeven_naam(){
        speler = new Speler("banaan");
        assertEquals("banaan", speler.getNaam());
    }

    @Test(expected = DomainException.class)
    public void speler_equals_gooit_exception_geef_null_als_speler_null(){
        speler = new Speler("kenzo");
        speler.equals(null);
    }

    @Test
    public void speler_geeft_false_als_spelers_niet_equal_zijn(){
        speler = new Speler("kenzo");
        Speler s2 = new Speler("banaan");

        assertFalse(speler.equals(s2));
    }

    @Test
    public void speler_geeft_true_als_spelers_niet_equal_zijn(){
        speler = new Speler("kenzo");
        Speler s2 = new Speler("kenzo");

        assertTrue(speler.equals(s2));
    }
}
