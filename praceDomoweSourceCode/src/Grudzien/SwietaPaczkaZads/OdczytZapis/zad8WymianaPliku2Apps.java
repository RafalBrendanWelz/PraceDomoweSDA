package Grudzien.SwietaPaczkaZads.OdczytZapis;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class zad8WymianaPliku2Apps {    //coś nie tak działa z odczytem bo jak rusza w tym samym momencie to potem niepoprawnie aktualizuje Plik i check sprawdzenie stary==aktualny
    private static File plikStart = new File( "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\praceDomoweSDA\\src\\Grudzien\\SwietaPaczkaZads\\OdczytZapis\\startPlikZad8.txt" );
    private static final Scanner wpisz = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        zad8Start();
    }

    public static void zad8Start() throws InterruptedException{
        Runnable wykonajOdczytApp = () -> {
            try {
                odczytujApp(plikStart);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };
        Runnable wykonajZapisApp = () -> {
            try {
                zapisujApp(plikStart);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };

        Thread zapisAPP = new Thread( wykonajZapisApp );
        zapisAPP.start();

        Thread odczytAPP = new Thread( wykonajOdczytApp );
        odczytAPP.start();
    }

    public static void zapisujApp( File tenPlik ) throws InterruptedException, IOException {
        String wpis = " ";
        int ileDoMaxWyk = 0;
        FileWriter wpisywacz = new FileWriter( tenPlik );

        while ( !wpis.equals("quit") && ileDoMaxWyk <= 1000 ){
            System.out.println("Wpisz nową linię");
            wpis = wpisz.nextLine();
            System.out.println("Dopisano.... " + wpis + " , na linii " + ++ileDoMaxWyk);
            wpisywacz.append(wpis);
            wpisywacz.append("\n");
        }
        wpisywacz.close();

    }

    private static void odczytujApp( File tenPlik ) throws InterruptedException, IOException {
        File stary = tenPlik;
        String wpis = " ";
        int ileDoMaxOdcz = 0;

        while ( !wpis.equals("quit") && ileDoMaxOdcz <= 120 ){
            Thread.sleep(4000);
            ileDoMaxOdcz++;
            czytajPowtarzane( stary, plikStart );
        }

    }

    private static void czytajPowtarzane(File staryPlik, File aktualny ) throws FileNotFoundException {
        if ( staryPlik.getTotalSpace() != aktualny.getTotalSpace() && staryPlik.lastModified() != aktualny.lastModified() ){
            int nrL = 0;
            BufferedReader czytacz = new BufferedReader( new FileReader( aktualny ) );
            List<String> linie = czytacz.lines().collect( Collectors.toList() );
            for (String ln: linie) {
                System.out.println(++nrL + ": " + ln);
            }

        }
    }



}
