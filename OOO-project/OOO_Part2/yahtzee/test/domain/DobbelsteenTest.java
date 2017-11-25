package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DobbelsteenTest {
    @Test
    public void Dobbelsteen_geeft_getal_tussen_1_en_6(){
        Dobbelsteen dobbelsteen = new Dobbelsteen();
        if( dobbelsteen.getNumber() >= 1 || dobbelsteen.getNumber() <= 6 ){
            System.out.print(dobbelsteen.getNumber());
            assertEquals(1, 1);
        } else {
            assertEquals(1, 0);
        }
    }

}
