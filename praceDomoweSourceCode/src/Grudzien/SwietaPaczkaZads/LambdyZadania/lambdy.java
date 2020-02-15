package Grudzien.SwietaPaczkaZads.LambdyZadania;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lambdy {


    public static void lambdyZadStart(){
        System.out.println("Zadania Lambdy \n*********************\n");
        //ZadaniaPierwszeLambdy();
        //zad2Autor.zad2Start();
        //System.out.println(zad3IloscDodzListy(Arrays.asList(12, 13, 5, 7, -4, 3, -7, 9, 13, -2, 1) )  );
        zadsBook.zad4Start();
        zadsBook.zad5Start();
        zadsBook.zad6Start();
        zadsBook.zad7DodatkoweStart();
        zadsBook.zad8DodatkoweStart();

    }

    public static long zad3IloscDodzListy ( List<Integer> liczby){
        final Long[] wynik = {0L};
        return liczby.stream().mapToLong( (t) -> (t > 0 ) ? ( 1 ) : ( 0 ) ).sum() ;
    }


    public static void ZadaniaPierwszeLambdy(){
        System.out.println("Zwroc pierwszy indeks wystapienia podanego znaku w tekscie ");
        String takiTekst = dajTekst();

        System.out.println("Wpisz jaki znak chcesz znaleźć: ");
        char takiZnak = dajZnak();

        System.out.println("W podanym tekście, znak ten po raz pierwszy występuje na miejscu: " + gdziePierwszeWystap( takiZnak, takiTekst ) )  ;
        System.out.println("W podanym tekście, znak ten po raz pierwszy występuje na miejscu: " + lambdaPierwszeWystap( takiZnak, takiTekst, 0 ) );

    }

    private static int lambdaPierwszeWystap(char takiZnak, String takiTekst, int ind) {
        return ( takiTekst.charAt(ind) == takiZnak ) ? ( ind ) : ( lambdaPierwszeWystap(takiZnak, takiTekst, ++ind ) );
    }

    private static OptionalInt gdziePierwszeWystap(char takiZnak, String takiTekst) {
        Pattern tego = Pattern.compile( String.valueOf(takiZnak) );
        Matcher szukaj = tego.matcher( takiTekst );
        if ( szukaj.find() ){
            return OptionalInt.of( takiTekst.indexOf( szukaj.group() ) );
        }else {
            throw new UnsupportedOperationException("W tekście nie ma takiego znaku ");
        }
    }

    private static char dajZnak() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.next().charAt(0);
    }

    private static String dajTekst(){
        return " * Zaimplementuj poniższe metody z użyciem wyrażeń lambda i/lub klas Stream oraz Optional.\n" +
                "Grosza daj wiedźminowi \n Sakiewką potrząśnij,\n" +
                " sakiewką potrząśnij (woo-hoo-oo)\n" +
                " Grosza daj wiedźminowi \n Sakiewką potrząśnij [ZWROTKA/VERSE] \n" +
                "Lecz chwycił biały wilk, Za morderczy róg\n" +
                " Co tylu już przed nim, Obalił był z nóg \n" +
                "Elfy cisną precz, Aż na górski szczyt \n" +
                "Daleko od od ludzi\n" +
                "Gdzie miejsce ich\n" +
                "Choć oberwał sam\n" +
                "Zmiażdżył bestii kark\n" +
                "Ten obrońca ludzkości\n" +
                "Toastu jest wart\n" +
                "Oto moja pieśń\n" +
                "To wasz bohater jest\n" +
                "On wrogów pokona\n" +
                "Nalejcie mu więc " +
                "     * Funkcja zwraca pierwszy indeks pod którym\n" +
                "     * określony znak znajduje się w podanym Stringu.\n" +
                "     */\n" +
                "    public OptionalInt indexOf(String string, char c) {\n" +
                "        throw new UnsupportedOperationException(\"Not implemented yet\");\n" +
                "    }" ;
    }






}
