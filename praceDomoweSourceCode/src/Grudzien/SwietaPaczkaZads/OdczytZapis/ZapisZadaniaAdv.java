package Grudzien.SwietaPaczkaZads.OdczytZapis;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class ZapisZadaniaAdv {

    public static void zapisAdvStart() throws IOException {
        //zad4Start();
        zad5Start();

    }

    private static void zad4Start() {
        System.out.println("Wpisz sciezke do pliku a ja sprawdze go. ");
        String sciezka = dajTekst();

        StringBuilder info = new StringBuilder();
        try {
            File nowyPlik = new File(sciezka);
            if ( nowyPlik.isFile() ) {
               info.append("Plik ");

            }else if( nowyPlik.isDirectory() ){
               info.append("Folder ");

            }else {
                throw new NoSuchFileException ("Plik/folder nie istnieje. ") ;
            }
            info.append( nowyPlik.getTotalSpace() ).append(" ").append( nowyPlik.lastModified() ).append("  ;Można Czytać=").append( nowyPlik.canRead() ).append("  ;Można Pisać=").append( nowyPlik.canWrite() ) ;

        } catch (NoSuchFileException err){
            err.printStackTrace();
        }

        System.out.println( info.toString() );

    }

    private static void zad5Start() throws IOException {
        System.out.println("Witamy w formularzach, wypełnij wszystkie potrzebne formularze przez odpowiadanie na pytania. ");
        List<Formularz> potrzebne = dajFormularze();

        Formularz.zapiszDoPlik( potrzebne );


    }

    private static List<Formularz> dajFormularze() {
        List<Formularz> wynik = new LinkedList<>();
        int ileJest = 0;
        boolean kolejny = true;

        while ( kolejny ){
            wynik.add( pytania() );
            ileJest++;
            System.out.println("Czy wypełnić kolejny formularz czy zakończyć na obecnych (" + ileJest + ") " );
            kolejny = czyKolejny( dajScan() );
        }

        return wynik;
    }

    private static boolean czyKolejny(Scanner wpisz) {
        String coWpis = wpisz.next();
        while ( !coWpis.equals("0") && !coWpis.equals("1") && !coWpis.trim().toLowerCase().equals("true") && !coWpis.trim().toLowerCase().equals("false") ){
            System.out.println("Niezrozumiała decyzja, wpisz jeszcze raz. (0, 1, false albo true)");
            coWpis = wpisz.next();
        }
        return (coWpis.equals("1") || coWpis.trim().toLowerCase().equals("true") );
    }

    private static Formularz pytania() {
        System.out.println("Jaka jest twoja płeć? (wpisz 0 dla male, 1 dla female)");
        boolean czyMale = dajPlec( dajScan() );
        int wiek, zarobki;
        double wzrost;          Wyksztalcenie mamTakie;         byte zadowolenie;

        if ( czyMale ){
            System.out.println("Jaki jest twój wiek? ");
            wiek = dajInt( dajScan() );
            System.out.println("Jaki jest twój wzrost? ");
            wzrost = dajDouble( dajScan() );
            System.out.println("Ile zarabiasz? ");
            zarobki = dajInt( dajScan() );
            System.out.println("Jakie masz wykształcenie? (wybierz z poniższych) ");
            mamTakie = dajWyksztalcenie( dajScan() );
            System.out.println("Podaj poziom swojego zadowolenia z życia od 0 do 100?");
            zadowolenie = dajZadowolenie( dajScan() );
            return new Formularz( wiek, wzrost, czyMale, zarobki, mamTakie, zadowolenie );

        }else {
            System.out.println("W którym roku się urodziłaś? ");
            wiek = ( LocalDate.now().getYear() - dajInt(dajScan()) ) ;
            System.out.println("Jaki jest twój wzrost? ");
            wzrost = dajDouble( dajScan() );
            System.out.println("Jakie masz wykształcenie? (wybierz z poniższych) ");
            mamTakie = dajWyksztalcenie( dajScan() );
            System.out.println("Podaj poziom swojego zadowolenia z życia od 0 do 100?");
            zadowolenie = dajZadowolenie( dajScan() );
            return new Formularz( wiek, wzrost, czyMale, mamTakie, zadowolenie );
        }

    }

    private static byte dajZadowolenie(Scanner wpisz) {
        while ( !wpisz.hasNextByte() ){
            wpisz.next();
        }
        byte wynik = wpisz.nextByte();

        if (wynik < 0 ){
            return 0;
        }else if (wynik > 100){
            return 100;
        }else {
            return wynik;
        }
    }

    private static Wyksztalcenie dajWyksztalcenie(Scanner dajScan) {
        System.out.println("1 - brak, 2 - podstawowe, 3 - srednie, 4 - zawodowe, 5 - zawodowe + średnie, 6 - Licencjackie, 7 - zawodowe + Wyższe, 8 - Magisterskie i Ponad :");
        int coWybr = dajInt( dajScan );
        if (coWybr < 1){
            coWybr = 1;
        }else if (coWybr > 8){
            coWybr = 8;
        }

        return Wyksztalcenie.values()[coWybr-1];
    }

    private static boolean dajPlec(Scanner wpisz) {
        String coWpis = wpisz.next();
        while ( !coWpis.equals("0") && !coWpis.equals("1") && !coWpis.trim().toLowerCase().equals("male") && !coWpis.trim().toLowerCase().equals("female") ){
            System.out.println("Niezrozumiała płeć, wpisz jeszcze raz.");
            coWpis = wpisz.next();
        }
        return (coWpis.equals("0") || coWpis.trim().toLowerCase().equals("male") );
    }

    private static double dajDouble(Scanner wpisz) {
        while ( !wpisz.hasNextDouble() ){
            wpisz.next();
        }
        return wpisz.nextDouble();
    }

    private static Scanner dajScan(){
        return new Scanner(System.in);
    }

    private static int dajInt( Scanner wpisz ) {
        while ( !wpisz.hasNextInt() ){
            wpisz.next();
        }
        return wpisz.nextInt();
    }


    private static String dajTekst(){
        Scanner wpisz = new Scanner(System.in);
        return wpisz.nextLine();
    }


}
