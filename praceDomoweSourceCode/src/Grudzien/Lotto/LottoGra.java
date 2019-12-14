package Grudzien.Lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoGra {
    private static final int ileLiczb = 6;
    private static final int[] nagrody = dajNagrody();

    private static int[] dajNagrody(){
        int[] tyleNagrod = new int[ileLiczb+1];
        tyleNagrod[0] = 0;
        tyleNagrod[1] = 0;

        for (int i = 2; i <= ileLiczb; i++) {
            tyleNagrod[i] = i*i*i*i*i + tyleNagrod[i-1]*4 + 10*(i-2) - ileLiczb*5;
        }
        return tyleNagrod;
    }

    public static String pokazMozliweNagrody(){
        String jakieNagrody = "";

        for (int i = 0; i <= ileLiczb; i++) {
            jakieNagrody += nagrody[i] + " ; ";
        }

        return jakieNagrody;
    }

    public static String zagraj(){
        System.out.println("Rozpocząłeś grę w lotto, wybierz 6 liczb w zakresie 1-49 :");
        Set<Integer> wybrane = new HashSet();
        for (int i = 0; i < ileLiczb; i++) {
            wybrane.add( wybierzLiczbe( i ) );
        }

        System.out.println("*****************");
        System.out.println("Twoje cyfry to " + wybrane);
        System.out.println("Przeprowadzam losowanie: ");
        System.out.println("....");

        return zwrocWynik( wynik ( wybrane , losuj() ) ) ;
    }

    private static String zwrocWynik(Set[] wynik) {
        if (wynik[0].size() > 0){
            return "Loteria wylosowała następujące liczby:   \n"
                    + wynik[1] +
                    " \nSpośród nich udało ci się zgadnąć następujące:   \n" +
                    wynik[0] + " \n " +
                    "Gratulacje zgadłeś " + wynik[0].size() + " liczb i wygrałeś " + nagrody[ wynik[0].size() ] + " zł";
        }else {
            return "Loteria wylosowała następujące liczby: \n " +
                     wynik[1] +
                    "\nTym razem nie udało ci się nic zgadnąć ";
        }

    }

    private static Set[] wynik(Set<Integer> wybrane, Set<Integer> wylosowane) {
        Set<Integer> zgadniete = new HashSet<>();

        for (int liczba: wybrane) {
            if ( wylosowane.contains( liczba ) ){
               zgadniete.add( liczba );
            }
        }

        return new Set[] { zgadniete, wylosowane };
    }

    private static Set<Integer> losuj() {
        Random losowe = new Random();
        Set<Integer> wylosowane = new HashSet<>();

        while ( wylosowane.size() < ileLiczb ){
            wylosowane.add( losowe.nextInt(49 - 1) + 1 ) ;
        }
        return wylosowane;
    }

    private static int wybierzLiczbe(int i){
        Scanner wybieramy = new Scanner(System.in);

        System.out.println("Podaj " + (int) (i+1) + " liczbę");
        int wynik = 0;
        while ( wynik <1 || wynik > 49  ) {

            while ( !wybieramy.hasNextInt() ){
                wybieramy.next();
            }
            wynik = wybieramy.nextInt();
        }

        return wynik;
    }







}
