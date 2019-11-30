package ListopadPart2.KomunikacjaMiejska;

import ListopadPart2.Biblioteka.Autor;

public class Zajezdnia {
    RodzajeZajezdni jaka;
    private String nazwa;
    private Pojazd[] wlasnePojazdy;
    private double zuzyciePaliwaAutobus;    //w litrach

    public Zajezdnia(RodzajeZajezdni jaka, String nazwa, Pojazd[] wlasnePojazdy) {
        this.jaka = jaka;
        this.nazwa = nazwa;
        this.wlasnePojazdy = wlasnePojazdy;

        for (Pojazd swojPoj:wlasnePojazdy) {
            swojPoj.homeZajezdnia = this;
        }

    }

    public  String opiszSie(){
        String opis = "Zajezdnia " + this.jaka.toString().toLowerCase() + " " + this.nazwa + " posiada następujące pojazdy: \n";
        double sumaPaliwZuzyc = 0;
        int sumaWagonow = 0;

        for (Pojazd pojazd: this.wlasnePojazdy) {
            opis += pojazd.opiszSie();

           if (pojazd instanceof Autobus){
               Autobus toJeAutobus = (Autobus) pojazd;
               sumaPaliwZuzyc += toJeAutobus.getZuzyciePaliw();

           }else if (pojazd instanceof Tramwaj){
               Tramwaj toJeTramwaj = (Tramwaj) pojazd;
               sumaWagonow += toJeTramwaj.getIloscWagonow();
           }

        }

        if (sumaPaliwZuzyc>0){
            opis += "W bieżącym miesiącu wszystkie autobusy zużyły łącznie " + sumaPaliwZuzyc + " litrów paliwa \n";

        }else if (sumaWagonow>0){
            opis += "Wszystkie Tramwaje posiadają łącznie " + sumaWagonow + " wagonów \n";

        }

        return opis;
    }




}
