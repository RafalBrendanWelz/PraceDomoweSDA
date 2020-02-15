package Grudzien.SwietaPaczkaZads.Wyszukiwania;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner wpisz = new Scanner(System.in);
    private static final int[] tablica = new int[] {1,4,5,70,3,6,2,0,13,9,7,32,120,67,61};

    public static void main(String[] args) {
       zad1i2Searche();
       zad3();

    }

    private static void zad1i2Searche(){
        zad1LinearSearch( );
        zad2BinarySearch( );
    }

    private static void zad3(){
        System.out.println("Oto lista Integerów ");
        List<Integer> lista = tablIntDoListyIntSort( tablica );

        System.out.println("Wpisz wartość int a wyszukam ją z tablicy i zwrócę indeks");
        int wartosc = dajInt();

        Optional<Integer> wynik = znajdzWartoscWLiscie(wartosc, lista);
        if (wynik.isPresent()){
            System.out.println("Twoja wartość: " + wartosc + " jest na miejscu " + wynik );
        }else {
            System.out.println("Nie ma w tablicy twojej wartości");
        }
    }

    private static Optional<Integer> znajdzWartoscWLiscie ( int wartosc, List<Integer> lista ){
        return Optional.of(lista.indexOf(wartosc));
    }

    private static void zad2BinarySearch() {//?? jak to ten binary search jeszcze nie działa gdy brak elementu
        System.out.println("Oto Tablica Int");
        int[] sortTabl = tablIntDoSortDoTablInt( tablica );

        System.out.println("Wpisz wartość int a wyszukam ją z tablicy i zwrócę indeks");
        int wartosc = dajInt();

        int wynik = znajdzBinarnie(sortTabl, wartosc, 0, tablica.length);
        if ( wynik == -1){
            System.out.println("Nie ma w tablicy twojej wartości");
        }else {
            System.out.println("Twoja wartość: " + wartosc + " jest na miejscu " + wynik );
        }
    }
    private static int znajdzBinarnie(int[] allWart , int wartosc, int min, int max) {
        int sprawdzane = allWart[((max-min) /2) + min];

        if (sprawdzane == wartosc){
            return ((max-min) /2) + min;
        }

        if (max <= min){
            return -1;
        }else if ( sprawdzane < wartosc ){
            int przesuniecie = ((max-min) /2)  +1;
            return znajdzBinarnie(allWart, wartosc, min + przesuniecie, max);

        }else {
            int przesuniecie = ((max-min) /2)  +1;
            return znajdzBinarnie(allWart, wartosc, min, max - przesuniecie);
        }
    }

    private static void zad1LinearSearch() {
        System.out.println("Oto Tablica Int");
        List<Integer> tabl = Arrays.stream(tablica).boxed().collect(Collectors.toList() );
        System.out.println(tabl);

        System.out.println("Wpisz wartość int a wyszukam ją z tablicy i zwrócę indeks");
        int wartosc = dajInt();

        int wynik = znajdzGdzieElement(tablica, wartosc, 0);
        if ( wynik == -1){
            System.out.println("Nie ma w tablicy twojej wartości");
        }else {
            System.out.println("Twoja wartość: " + wartosc + " jest na miejscu " + wynik );
        }
    }
    private static int znajdzGdzieElement(int[] tablica, int wartosc, int gdzieJestem ){
        return ( tablica[gdzieJestem] == wartosc ) ? (gdzieJestem) :
                (gdzieJestem < tablica.length-1 ) ? (znajdzGdzieElement(tablica, wartosc, ++gdzieJestem) ) : ( -1 );
    }

    private static int dajInt() {
        while (!wpisz.hasNextInt()){
            wpisz.next();
        }
        return wpisz.nextInt();
    }
    private static int[] tablIntDoSortDoTablInt(int[] tabl  ){
        List<Integer> listaSortWartosc = Arrays.stream(tabl).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(listaSortWartosc);

        int[] wynik = new int[listaSortWartosc.size()];
        for (int i = 0; i < listaSortWartosc.size(); i++) {
            wynik[i] = listaSortWartosc.get(i);
        }

        return wynik;
    }
    private static List<Integer> tablIntDoListyIntSort(int[] tabl  ){
        List<Integer> wynik = Arrays.stream(tabl).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(wynik);
        return wynik;
    }



}
