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
}
