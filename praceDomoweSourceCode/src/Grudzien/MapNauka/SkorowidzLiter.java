package Grudzien.MapNauka;

import java.util.LinkedHashMap;
import java.util.Map;

public class SkorowidzLiter {
    private static Map<Character, Integer[]> indWystLiter;

    public static void zad6Start(){
        String tekst = ladujTekst();
        char[] literySprawdzane = ( jakieLiterySprawdzamy( 13, tekst ) );

        indWystLiter = okreslLitery( tekst.trim(), literySprawdzane ) ;
        System.out.println("\n******************");


        System.out.println(indWystLiter.keySet() );
        System.out.println(indWystLiter.size() );
        System.out.println( dajNapisWyniku() );

    }

    private static String dajNapisWyniku() {
        String toWyswietl = "";

        for (char klucz: indWystLiter.keySet()) {
            toWyswietl += ( klucz + " -> [" );
            int ileWyst = indWystLiter.get(klucz).length;

            for (int i = 0; i < ileWyst; i++) {
                if (i == ileWyst-1){
                    toWyswietl += ( indWystLiter.get(klucz)[i]);
                }else {
                    toWyswietl += ( indWystLiter.get(klucz)[i] + ", " );
                }
            }
            toWyswietl += ("]\n");
        }

        return toWyswietl;
    }

    private static Map<Character, Integer[]> okreslLitery(String tekst, char[] litery) {
        Map<Character, Integer[]> skorowLiter = new LinkedHashMap<>();
        int ileJestIch;

        for (char litera: litery) {
            Integer[] indeksy = new Integer[tekst.length()];
            ileJestIch = 0;

            for (int i = 0; i < tekst.length(); i++) {
                if (tekst.charAt(i) == litera){
                    indeksy[ileJestIch] = i;
                    ileJestIch++;
                }
            }

            Integer[] skrocDlugIndeksy = new Integer[ileJestIch];

            System.arraycopy(indeksy, 0, skrocDlugIndeksy, 0, ileJestIch);

            skorowLiter.put( litera , skrocDlugIndeksy );
        }

        return  skorowLiter ;
    }

    private static char[] jakieLiterySprawdzamy(int tyleLiter, String tenTekst) {
        char[] jakieLiterySprawdzamy = new char[tyleLiter];
        int ileMamy = 1;
        boolean czyZaKrotkiTekst = false;

       while ( ileMamy < tyleLiter ){
           for (int j = ileMamy-1; j < tenTekst.length(); j++) {
               for (int k = 0; k < tyleLiter; k++) {

                    if (tenTekst.charAt(j) == jakieLiterySprawdzamy[k]){
                        break;
                    }else if (k == ileMamy-1 && ( tenTekst.charAt(j) > 64 && tenTekst.charAt(j) < 91 || tenTekst.charAt(j) > 96 ) ){
                        jakieLiterySprawdzamy[ileMamy-1] = tenTekst.charAt(j);
                        ileMamy++;
                        break;
                    }
               }

               if (j == tenTekst.length()-1 && ileMamy < tyleLiter-1){
                   czyZaKrotkiTekst = true;
               }
           }

           if (czyZaKrotkiTekst){
               break;
           }
       }
       return jakieLiterySprawdzamy;
    }

    private static String ladujTekst() {
        return " Taki oto sroto Napisz program do zliczania wystąpień słów w tekście, w tym celu:\n" +
                "2.Dodaj metodę zliczWystapieniaSlow(String tekst):Map<String, Integer>\n" +
                "1.Metoda pobiera tekst\n" +
                "2.Następnie rozdziela go na wystąpienia słów\n" +
                "3.Tworzy mapę ‚słowo’ \uF0E0ilość wystąpień\n" +
                "4.Iteruje po wszystkich słowach w zadanym tekscie\n";
    }





}
