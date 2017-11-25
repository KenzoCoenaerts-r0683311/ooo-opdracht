package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DobbelsteenTest {
    @Test
    public void Dobbelsteen_geeft_getal_tussen_1_en_6(){
        int num = Dobbelsteen.getNumber();
        if( num >= 1 && num <= 6 ){
            assertEquals(1, 1);
        } else {
            assertEquals(1, 0);
        }
    }

}
