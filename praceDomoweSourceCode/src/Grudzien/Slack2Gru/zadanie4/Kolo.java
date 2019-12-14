package Grudzien.Slack2Gru.zadanie4;

public class Kolo implements IFigura{
    private static final double PI = 3.1456;
    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    @Override
    public double obliczPole() {
        return PI * this.promien * this.promien;
    }

    @Override
    public double obliczObwod() {
        return 2 * PI * this.promien;
    }

    @Override
    public void wypiszOpis() {
        System.out.println("Koło o promieniu równym: " + this.promien + "\n" + " ma obwód = " + obliczObwod() + " i pole = " + obliczPole() );
    }





}
