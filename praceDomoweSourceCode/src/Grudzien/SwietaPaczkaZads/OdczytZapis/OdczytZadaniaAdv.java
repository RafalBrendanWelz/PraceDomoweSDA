package Grudzien.SwietaPaczkaZads.OdczytZapis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OdczytZadaniaAdv {
    private static final File plikForm
            = new File( "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\praceDomoweSDA\\src\\Grudzien\\SwietaPaczkaZads\\OdczytZapis\\output_form.txt" );

    public static void odczytAdvStart() throws IOException {
        //zads4FormCzyt();    //+ zad5
        //zads6Statystyki();
        zad7wyszukajSlowa();


    }

    private static void zad7wyszukajSlowa() throws IOException {
        File jakiPlik = new File( podajSciezke() );
        System.out.println("Wpisz wyszukiwane słowo dla podanego pliku: " );

        String slowo = new Scanner(System.in).next();
        if ( jakiPlik.isFile() ){
            System.out.println("Twoje słowo: " + slowo + " w podanym pliku występuje " + zliczIleTychSlow( slowo, jakiPlik ) + " razy");
        }else {
            System.out.println("Podana ścieżka: " +  jakiPlik.getPath() +" -> jest nieprawidłowa... nie ma takiego pliku");
        }

    }

    private static int zliczIleTychSlow(String tychSlow, File wTymPliku ) throws IOException {
        String zawartosc = odczytajCalySimply( wTymPliku );

        Pattern slowo = Pattern.compile( tychSlow );
        Matcher tuZnajdz = slowo.matcher(zawartosc);

        int ile = 0;
        while ( tuZnajdz.find() ){
            ile++;
            System.out.println(ile);
        }

        return ile;
    }

    private static String odczytajCalySimply(File wTymPliku) throws FileNotFoundException {
        Scanner cotuJest = new Scanner( wTymPliku );

        StringBuilder tresc = new StringBuilder();
        while ( cotuJest.hasNextLine() ){
            tresc.append( cotuJest.nextLine() );
        }
        return tresc.toString();
    }

    private static String podajSciezke() {
        Scanner wpisz = new Scanner(System.in);
        System.out.println("Wpisz pełną ścieżkę do pliku ");

        return wpisz.nextLine();
    }

    private static void zads4FormCzyt() throws FileNotFoundException {
        List<Formularz> wczytane = zczytajFormularze();

        wczytane.forEach(System.out::println);  //zadanie 4
        System.out.println( wczytane.size() );  //zadanie 5 ilość formularzy: wykomentuj linię jedną powyżej
    }

    private static List<Formularz> zczytajFormularze() throws FileNotFoundException {
        FileReader plikDoczytania = new FileReader( plikForm );
        Scanner czytacz = new Scanner( plikDoczytania );
        List<Formularz> wczytane = new LinkedList<>();

        while ( czytacz.hasNextLine() ){
            String linia = czytacz.nextLine();
            if ( linia.length() > 60 ){
                wczytane.add( zczytajLin( linia ) );
            }
        }

        return wczytane;
    }

    private static void zads6Statystyki() throws FileNotFoundException {
        List<Formularz> wczytane = zczytajFormularze();

        StatystykaFormularzy nowaStat = new StatystykaFormularzy();

        nowaStat = zliczStatystyki(nowaStat, wczytane );

        wyswietlStatystyke( nowaStat );
    }

    private static void wyswietlStatystyke(StatystykaFormularzy stat) {
        System.out.println("Statystyka formularzy:\n " +
                "Ilość wypełnionych = " + (stat.ilosci[0] + stat.ilosci[1]) + " ,przez Mężczyzn = " + stat.ilosci[1] + " ,przez Kobiety = " + stat.ilosci[0] );
        System.out.println("Z formularzy średnia wieku wynosi: " + stat.sredniaWieku + " lat średnio ogólna");
        System.out.println("                                   " + stat.srednieMezczyzn[0] + " średnia wieku mężczyzn");
        System.out.println("                                   " + stat.srednieKobiet[0] + " średnia wieku kobiet");
        System.out.println("\nU Mężczyzn:\n" +
                "          -średnia wzrostu wynosi = " + stat.srednieMezczyzn[1] + " cm \n" +
                "          -średnia zarobków wynosi = " + stat.srednieMezczyzn[2] + " zł" );
        System.out.println("U Kobiet:\n" +
                "          -średnia wzrostu wynosi = " + stat.srednieKobiet[1] + " cm" );
        System.out.println("\n Proporcjonalnie: " + stat.proporcjePlci[0] + " % formularzy wypełniły Kobiety \n" +
                "               " + stat.proporcjePlci[1] + " % formularzy wypełnili Mężczyźni ");
        System.out.println("\n A Proporcje Wykształcenia wśród wypełniających formularze są następujące :");
        for (int i = 0; i < Wyksztalcenie.values().length ; i++) {
            System.out.println( stat.podzialProporcjiWykszt[i] + " % " + Wyksztalcenie.values()[i].getNazwa() + " ");
        }

    }

    private static StatystykaFormularzy zliczStatystyki(StatystykaFormularzy statystyka, List<Formularz> wczytane) {

        for (Formularz form: wczytane) {
            statystyka.sredniaWieku += form.getWiek();
            if ( form.isMale() ){
                statystyka.ilosci[1]++;
                statystyka.srednieMezczyzn[0] += form.getWiek();
                statystyka.srednieMezczyzn[1] += form.getWzrost();
                statystyka.srednieMezczyzn[2] += form.getWysokoscZarobki();
            }else {
                statystyka.ilosci[0]++;
                statystyka.srednieKobiet[0] += form.getWiek();
                statystyka.srednieKobiet[1] += form.getWzrost();
            }

            for (int i = 0; i < Wyksztalcenie.values().length ; i++) {
                if ( Wyksztalcenie.values()[i] == form.getTakie() ){
                    statystyka.podzialProporcjiWykszt[i]++;
                    break;
                }
            }
        }

        statystyka.srednieMezczyzn[0] = statystyka.srednieMezczyzn[0] / statystyka.ilosci[1] ;
        statystyka.srednieMezczyzn[1] =  statystyka.srednieMezczyzn[1] / statystyka.ilosci[1] ;
        statystyka.srednieMezczyzn[2] =  statystyka.srednieMezczyzn[2] / statystyka.ilosci[1];
        statystyka.sredniaWieku = statystyka.sredniaWieku / (statystyka.ilosci[0] + statystyka.ilosci[1]);
        statystyka.srednieKobiet[0] = statystyka.srednieKobiet[0] / statystyka.ilosci[0] ;
        statystyka.srednieKobiet[1] =  statystyka.srednieKobiet[1] / statystyka.ilosci[0] ;
        statystyka.proporcjePlci[0] = (statystyka.ilosci[0] * 100 / (statystyka.ilosci[0] + statystyka.ilosci[1]) );
        statystyka.proporcjePlci[1] = (statystyka.ilosci[1] * 100 / (statystyka.ilosci[0] + statystyka.ilosci[1]) );

        for (int i = 0; i < statystyka.podzialProporcjiWykszt.length ; i++) {
            statystyka.podzialProporcjiWykszt[i] = (statystyka.podzialProporcjiWykszt[i]  * 100 / (statystyka.ilosci[0] + statystyka.ilosci[1]) );
        }

        return statystyka;
    }


    private static Formularz zczytajLin(String line) {
        String[] bezStart = line.split(":");
        String id = bezStart[0].split("\\.")[1];  //weird out of bound
        int numer = Integer.parseInt( id );

        String[] reszta = bezStart[1].trim().split(" ");

        boolean czyMale ;
        if ( reszta[0].split("=")[1].equals("Male") ){
            czyMale = true;
        }else {
            czyMale = false;
        }

        int wiek = Integer.parseInt( reszta[1].split("=")[1] );
        double wzrost = Double.parseDouble( reszta[2].split("=")[1] );


        if ( czyMale ){
            int zarobki = Integer.parseInt( reszta[3].split("=")[1] );
            Wyksztalcenie maTakie = Wyksztalcenie.BRAK;
            for (int i = 0; i < Wyksztalcenie.values().length; i++) {
                if ( Wyksztalcenie.values()[i].getNazwa().equals(  reszta[4].split("=")[1] )  ){
                    maTakie = Wyksztalcenie.values()[i];
                    break;
                }
            }

            byte zadowolenie = (byte) Integer.parseInt( reszta[5].split("=")[1] );
            System.out.println("Zczytano Formularz nr. " + numer + " male");
            return new Formularz( wiek, wzrost, czyMale, zarobki, maTakie, zadowolenie );

        }else {
            Wyksztalcenie maTakie = Wyksztalcenie.BRAK;
            for (int i = 0; i < Wyksztalcenie.values().length; i++) {
                if ( Wyksztalcenie.values()[i].getNazwa().equals(  reszta[3].split("=")[1] )  ){
                    maTakie = Wyksztalcenie.values()[i];
                    break;
                }
            }

            byte zadowolenie = (byte) Integer.parseInt( reszta[4].split("=")[1] );
            System.out.println("Zczytano Formularz nr. " + numer + " female");
            return new Formularz( wiek, wzrost, czyMale, maTakie, zadowolenie );
        }

    }




}
