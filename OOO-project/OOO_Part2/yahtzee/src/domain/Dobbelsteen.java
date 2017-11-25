package domain;

import java.util.Random;

public class Dobbelsteen {
    private Random rand;

    public Dobbelsteen(){
        rand = new Random();
    }

    public int getNumber(){
        return rand.nextInt(6) + 1;
    }
}
