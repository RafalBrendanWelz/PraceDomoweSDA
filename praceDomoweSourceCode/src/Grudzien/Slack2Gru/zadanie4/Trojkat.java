package Grudzien.Slack2Gru.zadanie4;

public class Trojkat implements IFigura{
    private int bokA;
    private int bokB;
    private int bokC;

    public Trojkat(int bokA, int bokB, int bokC) {
        this.bokA = bokA;
        this.bokB = bokB;
        this.bokC = bokC;
    }

    @Override
    public double obliczPole() {    //P=p(p−a)(p−b)(p−c)−−−−−−−−−−−−−−−−−√
        double obwod = obliczObwod();

        return Math.sqrt( obwod * (obwod - this.bokA) * (obwod - this.bokB) * (obwod - this.bokC) )  ;
    }

    @Override
    public double obliczObwod() {
        return bokC + bokB + bokA;
    }

    @Override
    public void wypiszOpis() {
        System.out.println("Trójkąt o bokach wynoszących: " + bokA + " " + bokB + " " + bokC + "\n"
                            + " ma obwód = " + obliczObwod() + " i pole = " + obliczPole() );
    }




}
