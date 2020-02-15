package Grudzien.SwietaPaczkaZads.Rekurencja;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println( zad1Siln(9));
        System.out.println( zad2TablSum(new int[]{12, 5, 3, 2}) );
        System.out.println( zad3Odwroc("Dyscyplina") );
        System.out.println( zad4NWW(4, 5, 1, 2, 6));

        System.out.println("\nZadanie Specjalne\n*********************");
        Set<String> kombinacje = zad5kombinacjeZnak("12345");
        System.out.println( kombinacje );
        System.out.println( kombinacje.size() );

    }

    private static long zad1Siln( int silnia ){
        return silnia( silnia, 1, 1L);
    }
    private static long silnia(int ile, int gdzieJest, long wynik ){
        return ( ile <= 0 ) ? (1) : ( gdzieJest == ile ) ? ( wynik ) : ( silnia(ile, ++gdzieJest, wynik * gdzieJest ) );
    }

    private static int zad2TablSum( int[] tablica  ){
        return sumuj( tablica.length-1, tablica, tablica[ tablica.length-1 ] );
    }
    private static int sumuj (int gdzie, int[] tablica, int wynik ){
        return (gdzie == 0 ) ? ( wynik ) : sumuj(--gdzie, tablica, wynik+=tablica[gdzie] );
    }

    private static String zad3Odwroc ( String tekst ){
        return odwrocWyraz( tekst, 1, new StringBuilder() );
    }
    private static String odwrocWyraz( String wyraz, int gdzie, StringBuilder nowyWyraz ){
       if ( gdzie == wyraz.length()+1 ){
           return nowyWyraz.toString();
       }else {
           nowyWyraz.append( wyraz.charAt( wyraz.length()-gdzie ) );
           return odwrocWyraz( wyraz, ++gdzie, nowyWyraz );
       }
    }

    private static int zad4NWW ( int... liczby ){
        if ( liczby.length > 2 ){
            int a = liczby[0];
            liczby = Arrays.copyOfRange(liczby, 1, liczby.length);

            return przygotNWW(a, liczby  );

        }else if ( liczby.length == 1){
            System.out.println(" Podałeś tylko jedną liczbę! " + liczby[0] + " tylko jedna liczba!" );
            return 1;
        }else {
            return obliczNWW(liczby[0], liczby[1] );
        }
    }
    private static int przygotNWW( int a, int... liczby){
        if ( liczby.length > 2 ){
            int b = liczby[0];
            liczby = Arrays.copyOfRange(liczby, 1, liczby.length);

            return obliczNWW(a, przygotNWW(b, liczby )   );

        }else if ( liczby.length == 1){
            return obliczNWW(a, liczby[0] );

        }else {
            int b = liczby[0];

            return  obliczNWW(a, przygotNWW(b, liczby[1] )   );
        }
    }
    private static int obliczNWW(int a, int b ){    //min wspólna wielokrotność
        return a * b / NWDEuklides(a, b);
    }
    private static int NWDEuklides(int a, int b ){    //max wspólny dzielnik
        if ( a > b ){
            return NWDEuklides( a-b, b );
        }else if ( b > a){
            return NWDEuklides( b, b-a );
        }else {
            return a;
        }
    }

    private static Set<String> zad5kombinacjeZnak( String tekst ){      //tu brakuje dodatkowych kombinacji
        String slowoRozneZnaki = przygotujSlowo( tekst );

        Set<String> allKombinacje = new LinkedHashSet<>();
        allKombinacje = dawajKombinacje( slowoRozneZnaki, allKombinacje,0, 0 );

        return allKombinacje;
    }
    private static String przygotujSlowo(String tekst) {
        StringBuilder buduj = new StringBuilder();

        //skrót dodania tekstu do listy znaków przez dostęp do stream znaków (chars()) i kolektowanie poniżej
        Set<Character> bezDuplik = tekst.chars().mapToObj( (c) -> (char) c).collect(Collectors.toCollection(LinkedHashSet::new) );
        System.out.println(bezDuplik);

        for (char znak: bezDuplik ) {
            if ( znak != ' ' ){
                buduj.append( znak );
            }
        }
        return buduj.toString();
    }

    private static Set<String> dawajKombinacje( String slowo, Set<String> tutajDaw, int ktZnak, int przesuniecie ){       //nie zlicza wszystkich mozl opcji
        String slowDoZmian = slowo;                                                                                         //popraw na sposób na koniec + w srodku tez na koniec wszystkie...

        if (przesuniecie > 0){
            StringBuilder coDodac = new StringBuilder();
            for (int j = 1 ; j < slowo.length(); j++) {
                coDodac.append(slowDoZmian.charAt(j) );
            }
            coDodac.append( slowDoZmian.charAt(0) );
            slowDoZmian = coDodac.toString();

        }else if ( przesuniecie < 0){
            przesuniecie = 0;
        }

        for (int i = ktZnak; i < slowo.length(); i++) {
            StringBuilder coDodac = new StringBuilder();

            for (int j = 0; j < slowo.length(); j++) {
                if ( j == i ){
                    coDodac.append( slowDoZmian.charAt(ktZnak) );
                }else if (j == ktZnak){
                    coDodac.append( slowDoZmian.charAt(i) );
                }else {
                    coDodac.append( slowDoZmian.charAt(j) );
                }
            }
            tutajDaw.add( coDodac.toString() );
            System.out.print( coDodac.toString() + " ; " );
        }


        if ( ktZnak == slowo.length()-1 && przesuniecie < slowo.length()-1 ){
            System.out.println(" +pr ");
            return dawajKombinacje(slowDoZmian, tutajDaw, 0, ++przesuniecie);

        }else if (ktZnak < slowo.length()-1 ) {
            System.out.println(" +kt ");
            return dawajKombinacje(slowDoZmian, tutajDaw, ++ktZnak, przesuniecie);

        }else if ( ktZnak == slowo.length()-1 && przesuniecie == slowo.length()-1 ){
            System.out.println(" \n end ");
            return tutajDaw;
        }else {
            throw new IndexOutOfBoundsException();
        }

    }



}
