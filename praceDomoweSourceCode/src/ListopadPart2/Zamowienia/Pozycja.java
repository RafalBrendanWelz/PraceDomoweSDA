package ListopadPart2.Zamowienia;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Pozycja {
    typTowaru typ;
    int iloscSztuk;
    double wagaKG;

    final static String domyslnyNominalCeny = "zł";


    public Pozycja(typTowaru typ, int iloscSztuk) {
        this.typ = typ;
        this.iloscSztuk = iloscSztuk;

    }

    @Override
    public String toString() {
        DecimalFormat przecinki = new DecimalFormat("#.#####");
        przecinki.setRoundingMode(RoundingMode.HALF_UP);

        if (this.typ.czyZaKilo){
            return  this.typ.nazwa + " (" + this.typ.cena + domyslnyNominalCeny + ")     "
                    + przecinki.format( this.obliczIloscKG() ) + " kg.     " + przecinki.format( this.obliczWartosc() ) + domyslnyNominalCeny;
        }else {
            return  this.typ.nazwa + " (" + this.typ.cena + domyslnyNominalCeny + ")     "
                    + this.iloscSztuk + " szt.     " + przecinki.format( this.obliczWartosc() ) + domyslnyNominalCeny;
        }
    }

    private double obliczIloscKG(){
        return this.iloscSztuk * this.typ.wagaZaSztuke;
    }

    protected double obliczWartosc(){
        if (this.typ.czyZaKilo){
            return (this.iloscSztuk * this.typ.wagaZaSztuke) * this.typ.cena;
        }else {
            return this.iloscSztuk * this.typ.cena;
        }
    }


}
