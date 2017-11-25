package domain;

import java.util.Random;

public class Dobbelsteen {
    public Dobbelsteen(){}

    public static int getNumber(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
