package Grudzien.Slack2Gru.zadanie6;


import java.util.Arrays;

public class Budynek {

    private Mieszkanie[] allMieszkania;
    private Osiedla osiedle;
    private int iloscOfert;
    private String adres;
    private int etapBudowy;
    private int planRokOddania;
    private int planKwartalOddania;
    private double dystansDoCentrum;

    public Budynek(Mieszkanie[] allMieszkania, Osiedla nazwaOsiedla, int ileMiesDoOddania, String adres ) {
        this.allMieszkania = allMieszkania;
        this.osiedle = nazwaOsiedla;
        this.adres = adres;
        this.planRokOddania = (ileMiesDoOddania / 12) + 2019;
        this.planKwartalOddania = ((ileMiesDoOddania % 12) /4) +1 ;

        if (this.planRokOddania - 2019 >3){
            this.etapBudowy = nazwaOsiedla.getEtapOsiedla() - 3 ;
        }else {
            this.etapBudowy = nazwaOsiedla.getEtapOsiedla() - (this.planRokOddania - 2019) ;
        }

        this.dystansDoCentrum = nazwaOsiedla.getSredniDystansDoCentrum() + MetodyLosujace.losDoublePercent();
        this.iloscOfert = allMieszkania.length;
    }

    public int getIloscOfert() {
        return iloscOfert;
    }
    public String getAdres() {
        return adres;
    }
    public double getDystansDoCentrum() {
        return dystansDoCentrum;
    }

    public double lacznaCenaBrutto(){
        return Arrays.stream(this.allMieszkania).mapToDouble(Mieszkanie::obliczBrutto).sum();
    }

    public double lacznaCenaNetto(){
        return Arrays.stream(this.allMieszkania).mapToDouble(Mieszkanie::obliczNetto).sum();
    }

    public void wypiszOpisBudynek(){
        System.out.println("Dom adres: " + this.adres + " osiedle: " + this.osiedle +
                " etapBudowy: " + this.etapBudowy + " data oddania: " + this.planRokOddania + "r. " + this.planKwartalOddania + " kwartał"
        + " będzie posiadał: " + this.iloscOfert + " mieszkań");
    }

    public void wypiszOpisBudPlusMieszkania(){
        System.out.print("Dom adres: " + this.adres + " osiedle: " + this.osiedle +
                " etapBudowy: " + this.etapBudowy + " data oddania: " + this.planRokOddania + "r. " + this.planKwartalOddania + " kwartał"
                + " będzie posiadał: " + this.iloscOfert + " mieszkań: ");
        Arrays.stream(this.allMieszkania).forEach(t -> System.out.println("   Mieszk o powierzchni: " + t.getPowierzchnia() +
                " ma " + t.getIleLaz() + " laz i " + t.getIlePokoj() + " pokoi, koszt kupna: " + t.obliczBrutto() + " zł Brutto" ) );
    }




}
