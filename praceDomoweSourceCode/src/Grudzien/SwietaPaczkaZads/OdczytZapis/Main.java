package Grudzien.SwietaPaczkaZads.OdczytZapis;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final File plikGl = new File("C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\praceDomoweSDA\\src\\Grudzien\\SwietaPaczkaZads\\OdczytZapis\\output_1.txt");

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //startHelloCheck( );
        //zad2StartCzyt3();
        //zad3StartLiczSlow();
        //zad1i2i3ZapisDoGL();

        //ZapisZadaniaAdv.zapisAdvStart(); //zad 4, 5, 6 i 7 zapis
        OdczytZadaniaAdv.odczytAdvStart(); //zad 4, 5, 6 i 7 czytaj

    }

    private static void zad1i2i3ZapisDoGL() throws IOException {
        FileWriter pisacz1 = new FileWriter( plikGl );
        String linia = "";

        System.out.println("Wpisuj kolejne linie tekstu, aby zakończyć wpisz quit ");
        while ( !linia.equals("quit\n") ){
            System.out.println("Wpisz pojedynczą linię do zapisania w pliku głównym ");
            linia = dajLinie() + "\n";

            if ( !linia.equals("quit\n") ){
                pisacz1.write(linia);
            }
        }
        pisacz1.close();

        czytajCalySimply( plikGl );
    }

    private static void czytajCalySimply ( File plikGl ) throws IOException {
        FileReader czytajacy = new FileReader( plikGl );
        //BufferedReader wskaznik = new BufferedReader( czytajacy );    //mało funkcji ma ta klasa do odczytu
        Scanner wskaznik2 = new Scanner( czytajacy );

        int i = 0;
        while ( wskaznik2.hasNextLine() ) {
            System.out.println(i + ": " + wskaznik2.nextLine() );
            i++;
        }

    }

    private static String dajLinie(){
        Scanner wpisz = new Scanner(System.in);
        return wpisz.nextLine();
    }

    private static void startHelloCheck() throws FileNotFoundException, IOException {
        FileReader czytacz1 = new FileReader( plikGl );
        Scanner czytaczScannerem = new Scanner( plikGl );

        BufferedReader testCzyta2 = new BufferedReader( czytacz1 ) ;
        System.out.println("*********************\nTest działania BufferedReadera: ");
        System.out.println(testCzyta2.readLine() );
        System.out.println(testCzyta2.readLine() );
        String[] linieZPlikgl = testCzyta2.lines().toArray(String[]::new);
        System.out.println( linieZPlikgl[5] );
        testCzyta2.close();

        String[] linieZScanerPlik = czytaczScannerem.toString().split("\n");
        System.out.println(linieZScanerPlik.length + " dlugosc tablicy linii ze scanera \n");

        System.out.println("\n*******************\nTest działania Scanner jako readFile: ");
        if (czytaczScannerem.nextLine().equals("Hello World!") ){
            System.out.println("Tak jest tu " + czytaczScannerem.nextLine() );
        }else {
            System.out.println("Nie ma Hello, pierwsza Linia to " + czytaczScannerem.nextLine() );
        }

        System.out.println( czytaczScannerem.nextLine() );
    }

    private static void zad2StartCzyt3( ) throws IOException {
        FileReader czytaczZad2 = new FileReader( plikGl );
        BufferedReader poszczLinia = new BufferedReader( czytaczZad2 );

        String pierwszLinia = poszczLinia.readLine();
        System.out.println(pierwszLinia.toUpperCase());
        System.out.println(pierwszLinia.toLowerCase());
        System.out.println(pierwszLinia.trim());
    }

    private static void zad3StartLiczSlow() throws IOException {
        FileReader czytaczZad2 = new FileReader( plikGl );
        Scanner scanPlik = new Scanner( plikGl );

        List<String> listaSlow = new LinkedList<>();
        int ileLinii = 0;
        while ( scanPlik.hasNext() ){
            String slowo = scanPlik.next();
            listaSlow.add(slowo );
        }
        System.out.println(listaSlow);
        System.out.println(listaSlow.size() );
        while (scanPlik.hasNextLine() ){
            ileLinii++;
            scanPlik.nextLine();
        }
        System.out.println(ileLinii);
    }





}
