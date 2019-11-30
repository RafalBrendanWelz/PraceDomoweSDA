package ListopadPart2.Zamowienia;

public class ZadZamowienia {

    public static void zad5Start() {
        Zamowienie pierwsze = tworzZamowienie();

        System.out.println(" ");
        System.out.println(pierwsze.obliczWartość() );

    }

    private static Zamowienie tworzZamowienie() {
        Zamowienie tworzone = new Zamowienie(9);
        tworzone.dodajPozycje(new Pozycja(typTowaru.BULKA,2) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.CIASTKA,2) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.MLEKO,10) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.SER,1) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.SZYNKA,3) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.RYBY,78) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.BANAN,1) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.JABLKO,6) );
        tworzone.dodajPozycje(new Pozycja(typTowaru.BANAN,2) );

        return tworzone;
    }




}
