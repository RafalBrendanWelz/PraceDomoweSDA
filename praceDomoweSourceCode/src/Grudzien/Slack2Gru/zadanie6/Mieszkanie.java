package Grudzien.Slack2Gru.zadanie6;


public class Mieszkanie {
    private double powierzchnia;
    private double cenaZaMetr;
    private int ilePokoj;
    private int ileLaz;
    private double[] powierzPokoj;
    private kierPolozGlSciany polozDoSlonca;

    public Mieszkanie(double powierz, double cenaZaMetr, int ilePokoj, int ileLaz, double[] powierzPokoj, kierPolozGlSciany polozDoSlonca) {
        this.powierzchnia = powierz;
        this.cenaZaMetr = cenaZaMetr;
        this.ilePokoj = ilePokoj;
        this.ileLaz = ileLaz;
        this.powierzPokoj = powierzPokoj;
        this.polozDoSlonca = polozDoSlonca;

    }

    public double obliczBrutto(){
        return this.cenaZaMetrBrutto() * this.getPowierzchnia() ;
    }

    public double obliczNetto(){
        return this.getCenaZaMetr() * this.getPowierzchnia();
    }

    private double cenaZaMetrBrutto(){
        return this.getCenaZaMetr() * 1.15;  //zakładam podatki, skłądki, ubezp itp. jako 15%
    }


    protected double getPowierzchnia() {
        return powierzchnia;
    }
    protected double getCenaZaMetr() {
        return cenaZaMetr;
    }
    protected int getIlePokoj() {
        return ilePokoj;
    }
    protected int getIleLaz() {
        return ileLaz;
    }
    protected double[] getPowierzPokoj() {
        return powierzPokoj;
    }
    protected kierPolozGlSciany getPolozDoSlonca() {
        return polozDoSlonca;
    }





}
