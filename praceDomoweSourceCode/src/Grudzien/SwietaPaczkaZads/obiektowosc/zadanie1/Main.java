package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        List<Produkt> allProdukty = dajProdukty();
        Rachunek testRachun = new Rachunek(allProdukty.get(1), allProdukty.get(2) );
        System.out.println("\n Program Z Paragonem i produktami \n****************************\n");

        testRachun.dodajProdukt( new Produkt("Kalafior", 5.7, podatekProdukt.VAT5) );
        for (int i = 0; i < allProdukty.size()-2; i++) {
            Random los = new Random();
            for (int j = 0; j < los.nextInt(3); j++) {
                testRachun.dodajProdukt(allProdukty.get(i) );
            }
        }

        System.out.println("łączna cena Netto = " + testRachun.podsumujNetto() + " zł");
        System.out.println("łączna cena Brutto = " + testRachun.podsumujBrutto() + " zł");
        testRachun.wypiszRachunek();

    }

    private static List<Produkt> dajProdukty() {
        List<Produkt> wynik = new ArrayList<>();
        wynik.add(new Produkt("costam", 12.3, podatekProdukt.VAT8) );
        wynik.add(new Produkt("bulka", 0.1, podatekProdukt.VAT8) );
        wynik.add(new Produkt("chleb", 2.1, podatekProdukt.VAT5) );
        wynik.add(new Produkt("Jablko", 0.5, podatekProdukt.VAT8) );
        wynik.add(new Produkt("Wino", 26.4, podatekProdukt.VAT23) );
        wynik.add(new Produkt("Wino2", 27, podatekProdukt.VAT23) );
        wynik.add(new Produkt("Piwo", 7.5, podatekProdukt.VAT23) );
        wynik.add(new Produkt("Piwo2", 6.5, podatekProdukt.VAT23) );
        wynik.add(new Produkt("Wódka", 21.5, podatekProdukt.VAT23) );
        wynik.add(new Produkt("Sok Pomarańcz", 4.5, podatekProdukt.VAT8) );
        wynik.add(new Produkt("Plastikowe Talerzyki", 11, podatekProdukt.VAT8) );
        wynik.add(new Produkt("Ser", 10, podatekProdukt.VAT5) );
        wynik.add(new Produkt("Wędlina", 10, podatekProdukt.VAT5) );
        wynik.add(new Produkt("Mleko", 2.1, podatekProdukt.VAT5) );
        wynik.add(new Produkt("Gruszka", 0.4, podatekProdukt.VAT5) );
        wynik.add(new Produkt("Masło", 6, podatekProdukt.VAT8) );
        wynik.add(new Produkt("RefundowaneLeki", 15, podatekProdukt.NOVAT) );

        return wynik;
    }


}
