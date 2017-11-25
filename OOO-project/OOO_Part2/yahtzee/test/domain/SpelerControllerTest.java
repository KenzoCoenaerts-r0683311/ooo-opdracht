package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpelerControllerTest {
    SpelerController controller = new SpelerController();

    @Test(expected = DomainException.class)
    public void SpelerController_createSpeler_gooit_exception_als_speler_al_bestaat(){
        controller.createSpeler("kenzo");
        controller.createSpeler("kenzo");
    }

    @Test
    public void SpelerControoler_createSpeler_voeg_speler_toe(){
        controller.createSpeler("kenzo");
        controller.createSpeler("test");
        controller.createSpeler("12345");

        assertEquals("kenzo", controller.getNextSpeler());
        assertEquals("test", controller.getNextSpeler());
        assertEquals("12345", controller.getNextSpeler());
    }
}
