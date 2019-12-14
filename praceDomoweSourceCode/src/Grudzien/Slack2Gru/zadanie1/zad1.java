package Grudzien.Slack2Gru.zadanie1;



public class zad1 {

    public static void zad1Start(){
        IOpenable[] otwieralneObiekty = dodajOtwieralne();
        SprzetElektryczny[] wlaczObiekty = dodajWlaczalne();

        IOtwieralny[] wejsciaDoPosiadlosci = rzutujNaOtwieralne( otwieralneObiekty );
        for (IOtwieralny taki: wejsciaDoPosiadlosci) {
            System.out.println(taki.czyOtwarty());
            taki.otwórz();
            System.out.println(taki.czyOtwarty());
        }


        System.out.println("******************************");
        for (SprzetElektryczny obiekt: wlaczObiekty) {
            System.out.println(obiekt.czyWłączony());
            obiekt.włącz();
            System.out.println(obiekt.czyWłączony());
        }

    }

    private static IOtwieralny[] rzutujNaOtwieralne(IOpenable[] otwieralne ) {
        IOtwieralny[] wynik = new IOtwieralny[otwieralne.length];
        int i = 0;
        for (IOpenable obiekt: otwieralne) {
            if (obiekt instanceof IOtwieralny){
                wynik[i] = (IOtwieralny) obiekt;
                i++;
            }
        }
        return wynik;
    }


    private static SprzetElektryczny[] dodajWlaczalne() {
        Alarm budzik = new Alarm();
        Alarm drugiBysNieZaspal = new Alarm();
        Alarm trzeciTakWRazieCzego = new Alarm();
        Czajnik zepsuty = new Czajnik();
        Czajnik firmowyLimit4KawyTygodniowo = new Czajnik();

        return new SprzetElektryczny[] {budzik, drugiBysNieZaspal, trzeciTakWRazieCzego, zepsuty, firmowyLimit4KawyTygodniowo};
    }

    private static IOpenable[] dodajOtwieralne() {
        Samochod pierwszeAuto = new Samochod();
        Brama ogrodowa = new Brama();
        Brama tylnia = new Brama();
        Drzwi frontowe = new Drzwi();
        Okno jedOkno = new Okno();
        Okno dwaOkno = new Okno();

        return new IOpenable[] {pierwszeAuto, ogrodowa, tylnia, frontowe, jedOkno, dwaOkno};
    }


}
