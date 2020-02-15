package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie3;

import java.util.List;
import java.util.Scanner;

class Main {
    private static final int maxZnak = 200;

    public static void main(String[] args) {
        Dyspozytornia takaOto = new Dyspozytornia( "Centrum 911 Województwo Pomorskie" );
        obslugaDyspozytorii( takaOto );

    }

    private static void obslugaDyspozytorii(Dyspozytornia takaOto) {
        System.out.println("Centrum obsługi Dyspozytorium: " + takaOto.getNazwa() );
        System.out.println("Wciśnij 0 aby zakończyć pracę...");
        System.out.println("Wciśnij 1 aby przyjąć zgłoszenie...");
        System.out.println("Wciśnij 2 aby wypisać 5 najnowszych zgłoszeń...");
        System.out.println("Wciśnij 3 aby wypisać x najnowszych zgłoszeń...");
        System.out.println("Wciśnij 4 aby wypisać all zgłoszeń podanego typu...");
        System.out.println("Wciśnij 5 aby zatwierdzić wykonanie aktualnego zgłoszenia...");
        wybor( dajZnak(), takaOto );
    }

    private static void wybor(char dajZnak, Dyspozytornia takaOto) {
        switch ( dajZnak ){
            case '0':{
                break;
            } case '1':{
                wpiszZgloszenie( takaOto );
                obslugaDyspozytorii( takaOto );
                break;
            } case '2':{
                wypiszAktualne ( takaOto, 5 );
                obslugaDyspozytorii( takaOto );
                break;
            } case '3':{
                wypiszAktualne ( takaOto, dajInt() );
                obslugaDyspozytorii( takaOto );
                break;
            } case '4':{
                System.out.println("Wpisz jakiego typu zgłoszenia chcesz wyświetlić: ");
                System.out.println("0 = Po Karetkę, 1 = Po Policję, 2 = Po Straż Pożarną, 3 = Zgłoszenie Wypadku, wpisanie cokolwiek innego = Inne ");

                char wybranyTyp = dajZnak();
                typZgloszenia jakieZgloszenie = typZgloszenia.INNE;
                for (int i = 0; i < typZgloszenia.values().length; i++) {
                    if ( wybranyTyp == typZgloszenia.values()[i].getByWybrac() ){
                        jakieZgloszenie = typZgloszenia.values()[i];
                        break;
                    }
                }

                wypiszAktualneZTypu( takaOto, jakieZgloszenie );
                obslugaDyspozytorii( takaOto );
                break;
            } case '5':{
                takaOto.wykonajPierwsze();
                obslugaDyspozytorii( takaOto );
                break;
            } default:{
                wybor( dajZnak(), takaOto);
            }
        }
    }

    private static void wypiszAktualneZTypu(Dyspozytornia takaOto, typZgloszenia tego) {
        List<Zgloszenie> aktualne = takaOto.dajZgloszeniaTypu( tego );
        System.out.println(aktualne);
    }

    private static void wypiszAktualne(Dyspozytornia takaOto, int i) {
        List<Zgloszenie> aktualne = takaOto.dajAktualne(i);
        System.out.println(aktualne);
    }

    private static void wpiszZgloszenie(Dyspozytornia takaOto) {
        System.out.println("By dodac zgloszenie wybierz typ zgłoszenia: ");
        System.out.println("0 = Po Karetkę, 1 = Po Policję, 2 = Po Straż Pożarną, 3 = Zgłoszenie Wypadku, wpisanie cokolwiek innego = Inne ");

        char wybranyTyp = dajZnak();
        typZgloszenia jakieZgloszenie = typZgloszenia.INNE;
        for (int i = 0; i < typZgloszenia.values().length; i++) {
            if ( wybranyTyp == typZgloszenia.values()[i].getByWybrac() ){
                jakieZgloszenie = typZgloszenia.values()[i];
                break;
            }
        }

        System.out.println("Następnie wpisz treść zgłoszenia (do " + maxZnak + " znaków i do końca linii)");
        String tresc = dajTekst( maxZnak );

        System.out.println("Teraz Wybierz z listy Miasto w którym doszło do sytuacji z danego zgłoszenia, lub pomin wciskając n ");
        miejsceZglosz toMiasto = null;
        String wybor = "";
        Scanner przeglListy = new Scanner( System.in );
        int i = 1;
        String cyfry = "0123456789";

        while ( !wybor.equals("n") && toMiasto == null ){
            if ( i < 0 || i > miejsceZglosz.values().length-1){
                System.out.println("Indeksy miast są w zakresie <0," + (miejsceZglosz.values().length-1) + ">");
                i = 1;
            }
            System.out.println("Wpisz v by wybrac " + miejsceZglosz.values()[i].getMiasto() + " ,wpisz liczbę 0-" + (miejsceZglosz.values().length-1) + " by wybrać inne miasto o danym id, lub wpisz 'n' by pominąć wybór" );
            wybor = przeglListy.next();

            if ( wybor.equals("v") ){
                toMiasto = miejsceZglosz.values()[i];
            }else if ( cyfry.contains(wybor) ) {
                i = Integer.parseInt(wybor);
            }else if ( wybor.equals("n") ){
                toMiasto = miejsceZglosz.BRAK;
            }
        }

        System.out.println("Wpisz na jaki adres w podanym mieście jest to zgłoszenie (do " + maxZnak + " znaków i do końca linii) ");
        String adres = dajTekst(maxZnak);

        takaOto.dodajZgloszenie(jakieZgloszenie, tresc, adres, toMiasto);
    }

    private static int dajInt() {
        Scanner podaj = new Scanner(System.in);
        while ( !podaj.hasNextInt() ){
            podaj.next();
        }
        return podaj.nextInt();
    }

    private static String dajTekst(int ileMaxZnak) {
        Scanner podaj = new Scanner(System.in);
        String wynik = podaj.nextLine();
        StringBuilder zbierzZnaki = new StringBuilder();

        for (int i = 0; i < ileMaxZnak && i < wynik.length() ; i++) {
            zbierzZnaki.append(wynik.charAt(i) );
        }
        return zbierzZnaki.toString();
    }

    private static char dajZnak() {
        Scanner podaj = new Scanner(System.in);
        return podaj.next().charAt(0);
    }






}
