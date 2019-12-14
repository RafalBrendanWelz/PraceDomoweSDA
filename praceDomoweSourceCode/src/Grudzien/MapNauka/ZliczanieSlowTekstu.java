package Grudzien.MapNauka;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ZliczanieSlowTekstu {
    private static String tekst;

    public static void zad5Start(){
        tekst = ladujTekst();
        Map<String, Integer> wystSlow = zliczajSlowa( tekst.trim() );
        System.out.println("\n******************");

        System.out.println(wystSlow);
        System.out.println(wystSlow.size());
        System.out.println("\n****************\n");

        Map<String, Integer> wystRosnaco = dajWedlugWystapienMaxdoMin( wystSlow );
        System.out.println( wystRosnaco );
        System.out.println( wystRosnaco.size() );
    }

    private static Map<String, Integer> dajWedlugWystapienMaxdoMin ( Map<String, Integer> doKonwersji ){
        Map<String, Integer> wynik = new LinkedHashMap<>();
        int maxWystap = 0;

        for (String klucz: doKonwersji.keySet() ) {
            maxWystap = Math.max( maxWystap, doKonwersji.get(klucz) );
        }

        for (int i = maxWystap; i > 0 ; i--) {
            Map<String, Integer> pomocAlfabetycznie = new TreeMap<>();

            for (String klucz : doKonwersji.keySet()) {
                if (doKonwersji.get(klucz) == i) {
                    pomocAlfabetycznie.put(klucz, doKonwersji.get( klucz ) );
                    //wynik.put(klucz, doKonwersji.get( klucz ) );
                }
            }

            wynik.putAll( pomocAlfabetycznie );
        }

        return wynik;
    }

    private static String ladujTekst() {
        return " Taki oto sroto Napisz program do zliczania wystąpień słów w tekście, w tym celu:\n" +
                "2.Dodaj metodę zliczWystapieniaSlow(String tekst):Map<String, Integer>\n" +
                "1.Metoda pobiera tekst\n" +
                "2.Następnie rozdziela go na wystąpienia słów\n" +
                "3.Tworzy mapę ‚słowo’ \uF0E0ilość wystąpień\n" +
                "4.Iteruje po wszystkich słowach w zadanym tekscie\n" +
                "5.Dla każdego słowa wyciąga ilość zliczonych słów z mapy i dorzuca kolejne wystąpienie\n" +
                "3.Program wyświetla wszystkie odkryte słowa wraz z ich liczebnością\n" +
                "4.* Program wyświetla wszystkie odkryte słowa wraz z ich liczebnością\nw kolejności od najczęściej występującego do najrzadziej występującego \n" +
                "i do tego sroto damy w tym tekście słowo <napisz> sześć razy: napisz napisz napisz napisz i również <ktoto> osiem razy: ktoto ktoto ktoto ktoto ktoto ktoto ktoto.";
    }

    private static Map<String, Integer> zliczajSlowa(String tekst){     //ostatniego wyrazu ,z jakiegoś powodu nie sprawdza, jeśli tekst kończy się samą spacją pomimo że w środku tekstu
        Map<String, Integer> mapaWynik = new LinkedHashMap<>();                 //wykrywa spacje i dzieli ze względu na nie
        String slowo = "";

        for (int i = 0; i < tekst.length(); i++) {

            if ( tekst.charAt(i) == '\uF0E0' || (tekst.charAt(i) > 0 && tekst.charAt(i) < 65 ) || tekst.charAt(i) == 96 || tekst.charAt(i) == 239
                    || tekst.charAt(i) == '‚' || tekst.charAt(i) == '’' || tekst.charAt(i) == ' '){

                if (slowo.length()>0 && mapaWynik.containsKey(slowo) ){
                    mapaWynik.replace( slowo, mapaWynik.get(slowo) + 1 );
                }else if (slowo.length()>0 ){
                    mapaWynik.put( slowo.trim().toLowerCase(), 1 );
                }

                slowo = "";
            }else {
                slowo += tekst.charAt(i);
            }
        }

        return mapaWynik;
    }



}
