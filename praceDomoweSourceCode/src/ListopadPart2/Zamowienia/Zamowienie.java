package ListopadPart2.Zamowienia;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Zamowienie {
    Pozycja[] pozycjeZamowienia;

    protected String nominalPlatnosci = "zł";
    private int maxRozmiar;

    public Zamowienie(int maxRozmiar) {
        this.pozycjeZamowienia = new Pozycja[maxRozmiar];
        this.maxRozmiar = maxRozmiar;
    }

    public Zamowienie() {
        this.pozycjeZamowienia = new Pozycja[10];

    }


    public Pozycja[] dodajPozycje( Pozycja nowaPoz){

        for (int i = 0; i < this.pozycjeZamowienia.length; i++) {
            if (this.pozycjeZamowienia[i] == null){
                this.pozycjeZamowienia[i] = nowaPoz;
                System.out.println("Dodano nową pozycję: " + nowaPoz.typ.nazwa + " " + nowaPoz.iloscSztuk);
                break;
            }

        }

        return this.pozycjeZamowienia;
    }

    public String obliczWartość(){
        double sumaCeny = 0;
        String rachuneczek = "Zamówienie na " + this.maxRozmiar + " produktów, wymienione poniżej \n";

        for (int i = 0; i < this.pozycjeZamowienia.length; i++) {
            if (this.pozycjeZamowienia[i] == null){
                rachuneczek += " \n";
            }else {
                rachuneczek += this.pozycjeZamowienia[i].toString() + " \n" ;

                sumaCeny +=  this.pozycjeZamowienia[i].obliczWartosc();
            }
        }
        DecimalFormat suma = new DecimalFormat("#.##");        // String.format("%.2f", sumaCeny) //sposób na wyświetlenie double sumaCeny z tylko 2 miejscami po przec (w sout)
        suma.setRoundingMode(RoundingMode.HALF_UP);

        rachuneczek += "Razem: " + suma.format(sumaCeny) + " " + Pozycja.domyslnyNominalCeny;

        return rachuneczek;
    }






}
