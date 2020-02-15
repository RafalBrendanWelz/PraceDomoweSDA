package Grudzien.SwietaPaczkaZads.typyGeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //zad1Test();
        // zad2Test();
        //zad3();
        //zad4();
        //zad6();
        zad7();

    }

    private static void zad7(){     //? wypisanie z [[...],[...]...]
        List<Integer> lista1 = Arrays.asList(123, 12, 213, 6, 9);
        List<Integer> lista2 = Arrays.asList(13, 136, 913);
        List<Integer> lista3 = Arrays.asList(9);
        List<Integer> lista4 = Arrays.asList(1, 2, 3, 4, 7);

        System.out.println(laczListy(lista1, lista2, lista3, lista4, 5) );
    }

    private static <T> List<T> laczListy(T... listy){
        List<T> wynik = new ArrayList<>();

        for (T ts : listy) {
            wynik.add(ts);
        }

        return wynik;
    }

    private static void zad6(){
        int b = 123000;
        double cos = 13.5;

        piszWartTotal(b);
        System.out.println(" ");
        piszWartTotal(cos);
    }

    private static <T extends Number> void piszWartTotal( T liczba){
        if (liczba instanceof Double){
            System.out.println( liczba.doubleValue() );
            System.out.println( liczba.doubleValue() * -1 );
            System.out.println( 1 / liczba.doubleValue() );
        }else {
            System.out.println( liczba.longValue() );
            System.out.println( liczba.longValue() * -1 );
            System.out.println( (1 / liczba.doubleValue()) );
        }
    }

    private static void zad5(){
        //zrobione przez dorobienie na zadaniu z kursu
    }

    private static void zad3() {
        Para[] zestawPierw = dajStart();
        System.out.println(zestawPierw.length);
        zestawPierw = zwrocNiepuste( zestawPierw );

        System.out.println(zestawPierw.length);
        for (int i = 0; i < zestawPierw.length; i++) {
            System.out.println(zestawPierw[i]);
        }

    }

    private static void zad4(){
        int a = 2312;
        int b = 344;
        short c = 12;
        short d = 5;
        double e = 2.3;

        System.out.println(dodajGenericNumb(a, b));
        System.out.println(dodajGenericNumb(a, c));
        System.out.println(dodajGenericNumb(c, d));
        System.out.println(dodajGenericNumb(e, b));
    }

    private static <T extends Number> double dodajGenericNumb (T numer1, T numer2) {
        return (numer1.doubleValue() + numer2.doubleValue());
    }

    private static Para[] zwrocNiepuste(Para[] zTych ){
        Para[] niepuste = new Para[zTych.length];
        int j = 0;
        for (int i = 0; i < zTych.length; i++) {
            if (zTych[i].getLewy() != null && zTych[i].getPrawy() != null ){
                niepuste[j++] = zTych[i];
            }
        }

        Para[] wynik = Arrays.copyOf(niepuste, j);

        return wynik;
    }

    private static Para[] dajStart(){
        Para pierw = new Para(new Student(), new Samochod() );
        Para drug = new Para(new Student("Kowalski"), new Samochod("Fiat") );
        Para trzec = new Para(new Student("Kaminska"), new Samochod("Skoda") );
        Para czter = new Para(new Student("Terwill"), new Samochod() );
        Para piat = new Para(new Student("Lowiren"), new Samochod("Skoda") );
        Para pusta = new Para();
        Para onlyone = new Para(new Student("Lowiren"));
        Para zakoch1 = new Para("Marek", "Ala");
        Para zakoch2 = new Para("Kornel", "Liza");
        Para zakochOne = new Para("Michał");

        return new Para[] {pierw, drug, trzec, czter, piat, pusta, onlyone, zakoch1, zakoch2, zakochOne };
    }

    private static void zad2Test() {
        Pudelko<String> zTekstem = new Pudelko<>( "Terefere" );
        Pudelko<Integer> zLiczba = new Pudelko<>( 12 );
        Pudelko<Double> zPI = new Pudelko<>( 3.1456 );

        writeTO( zLiczba );
        writeTO( zTekstem );
    }

    private static void zad1Test(){
        String costam = "Cosie tu sa ";
        writeTO( costam );

        int jakis = 6;
        writeTO(jakis);

        double PI = 3.1456;
        writeTO(PI);
    }

    private static <T> void writeTO ( T to ){
        try{
            for (int i = 0; i < 11; i++) {
                System.out.println( to.toString() );
            }

        }catch (UnsupportedOperationException e ){
            e.printStackTrace();
        }
    }




}
