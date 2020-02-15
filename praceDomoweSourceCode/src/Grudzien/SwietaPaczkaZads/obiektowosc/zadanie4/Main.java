package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie4;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Telefon zlom = new Telefon("012444678");
        startListaWiadomosci( zlom );
        obsWiadomosciTelefonu( zlom );

    }

    public static void startListaWiadomosci (Telefon tego) throws InterruptedException {
        tego.dodajWiadomosc( "015015777 Brat","Pozdrowienia z Peru", "Halo Halo jak się masz, tu u nas jest pięknie i superowo, szkoda że nie wyszło żebyś pojechał z nami, A co tam u ciebie? Mam nadzieję że w pracy już cię tak nie cisną i skończyli z tymi ciągłymi nadgodzinami?..."  );
        tego.dodajWiadomosc( "000000666 Rządowy","BRAK WPłATY NALEŻNYCH PIENIĘDZY BĘDZIE KARANA sMIERCIĄ", "Przypominamy o niezapłaconych składce na towarzystwo miłośników Jedynej Służnej i Aktualnie Rządzącej Partii");
        Thread.sleep(300);
        tego.dodajWiadomosc( "144774034 Jacko", "Gdzie JESTEss Cwelu", "Czekam już pół godziny.. Co tak Długo!!");
        tego.dodajWiadomosc( "144774034 Jacko", "Czekam", "Gdzie jesteś");
        Thread.sleep(1500);
        tego.dodajWiadomosc("754033044 Monika","Z NAMI KONIECCC", "NIE CHCĘ CIĘ ZNAC!!! NIE ODZTYWAJ SIĘ DO MNIE JUŻ NIGDT WIECEJ... NIHDY CI NIE WYBACzEE");
        Thread.sleep(400);
        tego.dodajWiadomosc("754033044 Monika","brak tematu", "Czyli nawet nic nie odpiszeeaw??!!");
        Thread.sleep(1300);
        tego.dodajWiadomosc("744012452 Szef", "Dodatkowe Godziny", "Witam, przepraszam za pisanie o tak późnej porze ale firma pilnie potrzebuje żeby wykonać obecne zlecenie do pojutrze i w imieniu firmy miałbym prośbę czy mógłbyś zostać jutro po pracy na kilka-naście godzin nadgodzin");
        Thread.sleep(100);
        tego.dodajWiadomosc("845045112 Mama", "Czwartek Urodziny", "SYnku proszę cię pamiętaj że w najbliższy czwartek są urodziny wujka Zdzisława i bardzo byśmy wszyscy chieli żebyś przyjechał.. Proszę nie spóźnij się tym razem");
        Thread.sleep(3000);
        tego.dodajWiadomosc("666666666 o","SUPER PROMOCJA!!", "Już teraz jeśli tylko wyślesz SMS na numer 666 to dostaniesz los na JEDYNĄ SZANSĘ NA ZAKUP SAMOCHODU OPEL ASTRA rocznik2002 W SUPER PRZECENIE -5% ceny");
        tego.dodajWiadomosc("666666666 o","SUPER PROMOCJA2!!", "Już teraz jeśli tylko wyślesz SMS na numer 666 to dostaniesz los na JEDYNĄ SZANSĘ NA ZAKUP SAMOCHODU OPEL ASTRA rocznik2002 W SUPER PRZECENIE -5% ceny");
        Thread.sleep(1100);
        tego.dodajWiadomosc("345065312 KowalMieszk","Spóźnienie z Opłatą", "Proszę o uregulowanie zaległej zapłaty za prąd (350 zł), termin zapłaty był tydzień temu i to jest już czwarty raz w tym roku jak się pan spóźnia, jeśli się to nie poprawi to będę musiał" +
                " zaprzestać wynajmowania panu mieszkania. Liczę na szybką odpowiedź i życzę miłego dnia. Józef Stanisław Kowalski - Właściciel Mieszkania ");


    }


    public static void obsWiadomosciTelefonu ( Telefon tego ){
        System.out.println("Witamy W wiadomosciach ");
        System.out.println("Masz " + tego.ileNieprzecz() + " nieprzeczytanych wiadomości" );
        System.out.println("***************************************************************");
        System.out.println("Wpisz 1 by zobaczyć nieprzeczytane wiadomości ");
        System.out.println("Wpisz 2 by zobaczyć wiadomości od wybranego nadawcy ");
        System.out.println("Wpisz 3 by usunąć i przeczytać najnowszą wiadomośc od wybranego nadawcy ");
        System.out.println("Wpisz 4 by usunąć najnowszą wiadomośc od wybranego nadawcy ");
        System.out.println("Wpisz 5 by odczytac wybrana wiadomosc od wybranego nadawcy ");
        System.out.println("Wpisz 0 by wyłączyć aplikacje wiadomości ");
        char coRobi = dajZnak();
        wybor( coRobi, tego );
    }

    private static void wybor(char dajZnak, Telefon ten) {
        switch ( dajZnak ){
            case '0':{
                break;
            } case '1':{
                ten.pokazNieprzeczytaneWiad();
                obsWiadomosciTelefonu( ten );
                break;
            } case '2':{
                zobaczWiadOdNadaw( ten );
                obsWiadomosciTelefonu( ten );
                break;
            } case '3':{
                System.out.println( usunAktualWiadOdNadawc(ten) );
                obsWiadomosciTelefonu( ten );
                break;
            } case '4':{
                usunAktualWiadOdNadawc(ten);
                obsWiadomosciTelefonu( ten );
                break;
            } case '5':{
                System.out.println(przeczytajOdNadawc(ten));
                obsWiadomosciTelefonu( ten );
                break;
            } default:{
                wybor( dajZnak(), ten);
            }
        }
    }

    private static String przeczytajOdNadawc( Telefon ten ){
        String nadawc = dajNadawce();
        System.out.println("Wpisz którą wiadomość chcesz Odczytać ");
        int ktora = dajInt();

        Wiadomosc wybrana = ten.odczytaj( nadawc, ktora );
        if ( wybrana == null ){
            return "Brak Wiadomości";
        }else {
            return wybrana.StringZTresc();
        }
    }

    private static String usunAktualWiadOdNadawc( Telefon ten ){
        String nadawc = dajNadawce();

        Wiadomosc wybrana =  ten.usunAktualOd( nadawc );
        if ( wybrana == null ){
            return "";
        }else {
            return wybrana.StringZTresc();
        }
    }

    private static void zobaczWiadOdNadaw( Telefon ten ){
        String nadawc = dajNadawce();

        ten.pokazWiadOd( nadawc );
    }

    private static char dajZnak() {
        Scanner podaj = new Scanner(System.in);
        return podaj.next().charAt(0);
    }

    private static int dajInt() {
        Scanner podaj = new Scanner(System.in);
        while ( !podaj.hasNextInt() ){
            podaj.next();
        }
        return podaj.nextInt();
    }

    private static String dajNadawce() {
        Scanner podaj = new Scanner(System.in);
        System.out.println("Wpisz nazwę nadawcy (kontakt): ");
        return podaj.next();
    }




}
