package ListopadPart2.KomunikacjaMiejska;

public class Autobus extends Pojazd{
      private double zuzyciePaliw;

    public Autobus(int szybkoscMaksymalna, int numer, double zuzyciePaliw) {
        super(szybkoscMaksymalna, numer);
        this.zuzyciePaliw = zuzyciePaliw;

    }

    public String opiszSie(){
        return "Autobus nr." + this.numer + " zużył " + this.zuzyciePaliw + " L.paliwa w b.m., porusza się z speed max = " + this.szybkoscMaksymalna + " km/h \n";
    }

    protected double getZuzyciePaliw(){
        return zuzyciePaliw;
    }


}
