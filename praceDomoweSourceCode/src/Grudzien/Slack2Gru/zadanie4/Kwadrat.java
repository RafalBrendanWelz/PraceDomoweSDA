package Grudzien.Slack2Gru.zadanie4;

public class Kwadrat extends Prostokat{

    public Kwadrat(int bokA) {
        super(bokA, bokA);
    }


    @Override
    public void wypiszOpis() {
        System.out.println("Kwadrat o boku równym " + boki[0] + " ma obwód =" + obliczObwod() + " i ma pole =" + obliczPole());
    }




}
