package Grudzien.Slack2Gru.zadanie6;

import java.util.Random;

public class MetodyLosujace {
    private static Random mainLosuj = new Random();

    public static double losDoublePercent() {
        return  (double) (mainLosuj.nextInt(99 - 10 )+10 ) / (double) (100) ;
    }



}
