package Grudzien.SwietaPaczkaZads;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class czasData {

    public static void zadCzasData() throws InterruptedException {
        //zad1Start();
        //zad2Start();
        //zad3Start();
        //zad4Start();
        //zad5Start();
        zad6Start();

    }

    private static void zad6Start() {
        LocalTime startAplikac = LocalTime.now();
        System.out.println("Aplikacja Przepowie ci prawdopodobną datę twojej śmierci: ");
        System.out.println("Wpisz datę swoich urodzin ");
        LocalDate urodziny = dajDate();

        int[] skracanieZycia = zad6Pytania();
        LocalDate dataSmierc = urodziny.plusDays( 36500 - skracanieZycia[0]*364 );
        System.out.println(skracanieZycia[0]);

        System.out.println("Aplikacja Przewiduje że zginiesz w naturalny sposób następującego dnia");
        dataSmierc.format( DateTimeFormatter.ofPattern("dd:MM:yyyy") );
        System.out.println(dataSmierc);
        if (skracanieZycia[1] > 0){
            System.out.println("Ponadto masz szansę umrzeć na zawał serca w wieku: ");
            System.out.println("  " + ( urodziny.plusYears( skracanieZycia[1] ).getYear() - urodziny.getYear() )  + " lat, w " + urodziny.plusYears( skracanieZycia[1] )  );
        }
        if (skracanieZycia[2] > 0){
            System.out.println("Ponadto masz szansę umrzeć w wypadku samochodowym w wieku: ");
            System.out.println("  " + ( urodziny.plusYears( skracanieZycia[2] ).getYear() - urodziny.getYear() ) + " lat, w " + urodziny.plusYears( skracanieZycia[2] )  );
        }

        System.out.println("\nPonadto na szukaniu swojej daty śmierci aktualnie spędziłeś/aś: ");
        System.out.println("   " + Duration.between(startAplikac, LocalTime.now() ).getSeconds() + " sekund" );

    }

    private static int[] zad6Pytania() {
        int wynikSkr = 0;

        System.out.println("Wpisz 'm' jeśli jesteś mężczyzną, lub 'k' jeśli jesteś Kobietą");
        char plec = ustawPlec( dajChar() );
        switch ( plec ){
            case 'm':{
                wynikSkr += 8;
                break;
            } case 'k':{
                break;
            } default:{
                wynikSkr += 15;
            }
        }

        System.out.println("Czy palisz papierosy, jak tak to ile papierosów dziennie palisz? wpisz liczbę ");
        int ilePet = dajIlePetow();
        wynikSkr = wynikSkr + (int)( ilePet * 1.5 );

        System.out.println("Czy żyjesz w stresie, w skali od 0 do 10 jak duży stres na co dzień odczuwasz? ");
        byte stresPoziom = dajStresPoziom();
        int kiedyZaw = 0, ileRazTrue = 0;

        for (int i = 0; i <= stresPoziom; i++) {
            Random losZawal = new Random();
            int losLiczba = losZawal.nextInt(100);
            if (losLiczba > 90){
                ileRazTrue++;
                kiedyZaw = 60;
            }
        }
        kiedyZaw = kiedyZaw - (int)(ileRazTrue / 3);
        wynikSkr = wynikSkr + (int)(ileRazTrue * 2 / 3);

        System.out.println("Jak często przebywasz w okolicach ulic i samochodów? W skali od 0 (raz na miesiąc lub mniej) do 10 (pracuję jeżdżąc samochodem 8+ h dziennie) ");
        byte autaPoziom = dajStresPoziom();
        int kiedyWyp = 0;
        ileRazTrue = 0;

        for (int i = 0; i <= autaPoziom; i++) {
            Random losZawal = new Random();
            int losLiczba = losZawal.nextInt(100);
            if (losLiczba > 90){
                ileRazTrue++;
                kiedyWyp = 85;
            }
        }
        kiedyWyp = kiedyZaw - (ileRazTrue * 5);
        wynikSkr = wynikSkr + (int)(ileRazTrue * 4 / 5);

        return new int[] {wynikSkr, kiedyZaw, kiedyWyp};
    }

    private static byte dajStresPoziom() {
        Scanner wpisz = new Scanner(System.in);

        while ( !wpisz.hasNextByte(10) ){
            wpisz.next();
        }
        byte wynik = wpisz.nextByte();

        return wynik;
    }

    private static int dajIlePetow() {
        Scanner wpisz = new Scanner(System.in);

        while ( !wpisz.hasNextInt() ){
            wpisz.next();
        }
        int wynik = wpisz.nextInt();

        if ( wynik < 0 ){
            return 0;
        }else if ( wynik > 100){
            return 100;
        }else {
            return wynik;
        }
    }

    private static char ustawPlec( char plec ) {
        if (plec == 'k' || plec == 'm'){
            return plec;
        }else {
            return 'n';
        }
    }

    private static char dajChar() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.next().charAt(0);
    }

    private static void zad5Start() {
        System.out.println("Obliczę twój wiek na podstawie daty urodzin. ");
        LocalDate urodziny = dajDate();

        LocalDateTime urod = LocalDateTime.of(urodziny.getYear(), urodziny.getMonth(), urodziny.getDayOfMonth(), 0, 0);

        Period ileLat = Period.between( urodziny, LocalDate.now() );
        System.out.println("Masz " + ileLat.getYears() + " lat, " + ileLat.getMonths() + " miesięcy i " + ileLat.getDays() + " dni");

        Duration ileSek = Duration.between(urod, LocalDateTime.now() );
        System.out.println("Urodziłeś się " + ileSek.getSeconds() + " sekund temu. " );

    }

    private static void zad4Start() {
        System.out.println("Podam różnicę między dwoma datami: ");
        LocalDate dataPocz = dajDate();
        dataPocz.format( DateTimeFormatter.ofPattern("yyyy::MM::dd") );
        System.out.println(dataPocz);

        LocalDate dataKoniec = dajDate();
        dataKoniec.format( DateTimeFormatter.ofPattern("MM::yyyy::dd") );
        System.out.println(dataKoniec);

        Period roznica = Period.between(dataPocz, dataKoniec);
        System.out.println("Minęło pomiędzy nimi: " + roznica.getYears() + " lat, " + roznica.getMonths() + " miesięcy, " + roznica.getDays() + " dni");

    }

    private static void zad3Start() {
        System.out.println("Wyświetlam różnicę dwóch dat.");
        System.out.println("Wpisz datę rozpoczęcia: ");
        LocalDate dataPoczatek = dajDate();
        System.out.println("Wpisz datę zakończenia: ");
        LocalDate dataKoniec = dajDate();

        Period okresRoznicy = Period.between( dataPoczatek, dataKoniec );

        System.out.println( "Okres pomiędzy nimi to: " + okresRoznicy.getYears() + " lat " + okresRoznicy.getMonths() + " mies " + okresRoznicy.getDays() + " dni");
        System.out.println(okresRoznicy);
    }

    private static void zad2Start() {
        System.out.println("Podaj date rozpoczęcia dzialania planu: ");
        LocalDate dzien0Programu = dajDate();

        System.out.println("Czas na ostatnie przygotowania i testy: " + dzien0Programu.plusDays(-10) );
        System.out.println("Przewidywane czas kiedy będzie działał bezbłędnie (po poprawieniu błędów) " + dzien0Programu.plusDays(10) );
        System.out.println(dzien0Programu.lengthOfYear());

    }

    private static LocalDate dajDate() {
        Scanner wpisz = new Scanner(System.in);
        int[] data = new int[3];

        System.out.println("Wpisz który rok ");
        while (!wpisz.hasNextInt() ){
            wpisz.next();
        }
        data[2] = wpisz.nextInt();

        System.out.println("Wpisz który miesiąc (1 - 12)");
        while (!wpisz.hasNextInt() ){
            wpisz.next();
        }
        data[1] = wpisz.nextInt();
        if (data[1] < 1 || data[1] > 12){
            data[1] = 1;
        }

        LocalDate rokMiesPod = LocalDate.of(data[2], data[1], 1);
        System.out.println("Wpisz który dzień miesiąca (1 - 31) ");
        while (!wpisz.hasNextInt() ){
            wpisz.next();
        }
        data[0] = wpisz.nextInt();
        if (data[0] < 1 ){
            data[0] = 1;
        }else if ( data[0] > rokMiesPod.lengthOfMonth() ){
            data[0] = rokMiesPod.lengthOfMonth() ;
        }

        return LocalDate.of(data[2], data[1], data[0]) ;
    }


    private static void zad1Start() throws InterruptedException {
        LocalTime takiCzas = LocalTime.now();
        System.out.println(takiCzas);

        Thread.sleep(2000);
        LocalTime drugiCzas = LocalTime.now();
        System.out.println(drugiCzas);

        int roznWCzasie = drugiCzas.getSecond() - takiCzas.getSecond();
        System.out.print("Różnica w czasie wynosi: " + roznWCzasie + " s");

        System.out.println("To były testy teraz pętla od czasów: ");
        System.out.println("*************************************");
        System.out.println("Wpisz date by wypisać date \n time by wypisać obecny czas \n datetime by wypisać oba \n quit by zakończyć.");
        wypisujCzasDoQuit();

    }

    private static int wypisujCzasDoQuit() {
        String decyzja = dajTekst();

        switch (decyzja){
            case "datetime":{
                System.out.println(LocalDateTime.now());
                break;
            } case "time":{
                System.out.println(LocalTime.now());
                break;
            } case "date":{
                System.out.println(LocalDate.now());
                break;
            } case "quit":{
                return 0;
            }
        }
        return wypisujCzasDoQuit();
    }

    private static String dajTekst() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.next().toLowerCase().trim();
    }




}
