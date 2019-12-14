package Grudzien.Slack2Gru.zadanie4;

public class Prostokat extends Wielokat{

    public Prostokat(int bokA, int bokB) {
        this.boki[0] = bokA;
        this.boki[1] = bokB;
        this.boki[2] = bokA;
        this.boki[3] = bokB;
    }


    @Override
    public double obliczPole() {
        return boki[0] * boki[1];
    }

    @Override
    public void wypiszOpis() {
        System.out.println("Prostokąt o bokach równych " + boki[0] + "x2 i " + boki[1] + "x2 ma obwód =" + obliczObwod() + " i ma pole =" + obliczPole());
    }




}
