package ListopadPart2.KomunikacjaMiejska;

public class zad6Komunikacja {

    public static void zad6Start() {
        Zajezdnia tramwajowa = new Zajezdnia(RodzajeZajezdni.TRAMWAJOWA, "Maksia ", dodajTramwaje() );
        Zajezdnia autobusowa = new Zajezdnia(RodzajeZajezdni.TRAMWAJOWA, "Karamby", dodajAutobusy() );

        System.out.println(tramwajowa.opiszSie());
        System.out.println("**************************");
        System.out.println(autobusowa.opiszSie());

    }

    private static Pojazd[] dodajTramwaje() {
        Pojazd tramwaj1 = new Tramwaj(50, 2, 3);
        Pojazd tramwaj2 = new Tramwaj(80, 3,  2);
        Pojazd tramwaj3 = new Tramwaj(70, 4,  2);
        Pojazd tramwaj4 = new Tramwaj(60, 7,  3);
        Pojazd Maksio = new Tramwaj(40, 1,  1);

        return new Pojazd[] {tramwaj1, tramwaj2, tramwaj3, tramwaj4, Maksio};
    }

    private static Pojazd[] dodajAutobusy() {
        Pojazd autobusik = new Autobus(100, 11,  300.5);
        Pojazd autobusik2 = new Autobus(90, 5,  125);
        Pojazd autobusik3 = new Autobus(90, 6,  134.2);
        Pojazd Wyjec = new Autobus(70, 9,  144.3);
        Pojazd Karamba = new Autobus(150, 13,  148);

        return new Pojazd[] {autobusik, autobusik2, autobusik3, Wyjec, Karamba};
    }


}
