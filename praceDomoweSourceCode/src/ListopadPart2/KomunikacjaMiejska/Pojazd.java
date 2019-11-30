package ListopadPart2.KomunikacjaMiejska;

public abstract class Pojazd {
        protected int szybkoscMaksymalna;   // km/h
        protected int numer;
        protected Zajezdnia homeZajezdnia;

    public Pojazd(int szybkoscMaksymalna, int numer) {
        this.szybkoscMaksymalna = szybkoscMaksymalna;
        this.numer = numer;

    }

    public abstract String opiszSie();



}
