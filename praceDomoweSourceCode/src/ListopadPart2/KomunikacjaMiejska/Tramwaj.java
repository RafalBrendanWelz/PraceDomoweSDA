package ListopadPart2.KomunikacjaMiejska;

public class Tramwaj extends Pojazd{
      private int iloscWagonow;

    public Tramwaj(int szybkoscMaksymalna, int numer, int iloscWagonow) {
        super(szybkoscMaksymalna, numer);
        this.iloscWagonow = iloscWagonow;

    }

    public String opiszSie(){
        return "Tramwaj nr." + this.numer + " posiada " + this.iloscWagonow + " wagonów, porusza się z speed max = " + this.szybkoscMaksymalna + " km/h \n";
    }

    protected int getIloscWagonow(){
        return iloscWagonow;
    }


}
