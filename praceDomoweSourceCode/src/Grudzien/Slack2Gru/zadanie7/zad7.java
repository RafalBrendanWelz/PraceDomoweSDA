package Grudzien.Slack2Gru.zadanie7;

public class zad7 {

    public static void zad7Start(){
        PojazdInfo[] auta = dajAuta();
        Autostrada dluga = new Autostrada();

        for (int i = 0; i < auta.length/2; i++) {
            dluga.wjazdNewAuta( auta[i] );
        }
        System.out.println("**********************\n");

        dluga.wyjazdAuta( auta[1].getNumerRejestrac() );
        for (int i = 0; i < 3; i++) {
            dluga.spyPojazdzAutostrady( auta[i].getNumerRejestrac() );
        }
        dluga.wyjazdAuta( auta[0].getNumerRejestrac() );

        System.out.println("**********************\n");
        for (int i = 0; i < 7; i++) {
            Autostrada.trocheCzasuUplynelo();
        }
        System.out.println(" obecny czas to " + dluga.opiszCzas());

        System.out.println("**********************\n");
        dluga.wyjazdAuta( auta[4].getNumerRejestrac() );
        for (int i = 0; i < auta.length; i++) {
            dluga.wjazdNewAuta( auta[i] );
        }
        dluga.spyPojazdzAutostrady( auta[4].getNumerRejestrac() );
        dluga.spyPojazdzAutostrady( auta[5].getNumerRejestrac() );
        dluga.wyjazdAuta( auta[3].getNumerRejestrac() );
        dluga.wyjazdAuta( auta[4].getNumerRejestrac() );
        dluga.wyjazdAuta( auta[5].getNumerRejestrac() );
        dluga.wyjazdAuta( auta[6].getNumerRejestrac() );

        System.out.println("**********************\n");
        dluga.wjazdNewAuta( auta[4] );
        for (int i = 0; i < 15; i++) {
            Autostrada.trocheCzasuUplynelo();
        }
        System.out.println(" obecny czas to " + dluga.opiszCzas());
        for (int i = 0; i < auta.length; i++) {
            dluga.wyjazdAuta( auta[i].getNumerRejestrac() );
        }


    }

    private static PojazdInfo[] dajAuta() {
        PojazdInfo pierwszy = new PojazdInfo("HK012456", TypPojazdu.SAMOCHOD);
        PojazdInfo toyCo = new PojazdInfo("LS120333", TypPojazdu.SAMOCHOD);
        PojazdInfo subImpr = new PojazdInfo("LS775643", TypPojazdu.SAMOCHOD);
        PojazdInfo subImpr2 = new PojazdInfo("RO447123", TypPojazdu.SAMOCHOD);
        PojazdInfo Fiacik = new PojazdInfo("HK444002", TypPojazdu.SAMOCHOD);
        PojazdInfo bigBuck = new PojazdInfo("HK010006", TypPojazdu.CIEZAROWKA);
        PojazdInfo truki = new PojazdInfo("HK111111", TypPojazdu.CIEZAROWKA);
        PojazdInfo madTruck = new PojazdInfo("LA771551", TypPojazdu.CIEZAROWKA);
        PojazdInfo qwerty = new PojazdInfo("NY333444", TypPojazdu.CIEZAROWKA);
        PojazdInfo maly = new PojazdInfo("LA666012", TypPojazdu.MOTOCYKL);
        PojazdInfo skuter = new PojazdInfo("NY765999", TypPojazdu.MOTOCYKL);

        return new PojazdInfo[] {pierwszy, toyCo, subImpr, subImpr2, Fiacik, bigBuck, truki, madTruck, qwerty, maly, skuter};
    }


}
