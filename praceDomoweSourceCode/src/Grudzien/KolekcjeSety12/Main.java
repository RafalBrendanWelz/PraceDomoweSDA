package Grudzien.KolekcjeSety12;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //zad1();
        //zad2();
        //zad3();
        //zadanie_1();
        zadanie_1B();

    }

    private static void zadanie_1B() {
        System.out.println("Rozpiszę ci unikalne słowa z podanego tekstu");
        System.out.println("Podaj Tekst");
        String tekst = dajTekst();

        String[] ciagZnakow = tekst.split(" ");
        Map<String, Long> unikalne = new LinkedHashMap<>();

        for (int i = 0; i < ciagZnakow.length; i++) {
            for (int j = 0; j < ciagZnakow.length; j++) {
                if ( ciagZnakow[i].equals(ciagZnakow[j]) && i!=j ){

                    if (unikalne.containsKey(ciagZnakow[i]) ){
                        unikalne.put( ciagZnakow[i], unikalne.get(ciagZnakow[i])+1L );
                        break;
                    }

                }else if (j == ciagZnakow.length-1){
                    unikalne.put( ciagZnakow[i], 1L );
                }
            }
        }

        System.out.println(unikalne);

    }

    private static void zadanie_1() {
        System.out.println("Rozpiszę ci unikalne litery z podanego tekstu");
        System.out.println("Podaj Tekst");
        String tekst = dajTekst();

        String[] ciagZnakow = tekst.split("") ;
        List<Character> unikalne = new LinkedList<>();

        for (int i = 0; i < ciagZnakow.length; i++) {
            for (int j = 0; j < ciagZnakow.length; j++) {
                if ( ciagZnakow[i].charAt(0) == ciagZnakow[j].charAt(0) && i!=j){
                    break;
                }else if (j == ciagZnakow.length-1){
                    unikalne.add( ciagZnakow[i].charAt(0) );
                }
            }
        }

        System.out.println("\nA oto unikalne litery z twojego tekstu \n****************");
        System.out.println(unikalne);
    }

    private static void zad3() {
        Set<ParaLiczb> zbiorPar = new HashSet<>();
        zbiorPar.add( new ParaLiczb(1,2) );
        zbiorPar.add( new ParaLiczb(2,9) );
        zbiorPar.add( new ParaLiczb(4,7) );
        zbiorPar.add( new ParaLiczb(4,8) );
        zbiorPar.add( new ParaLiczb(5,3) );
        zbiorPar.add( new ParaLiczb(-5,4) );
        zbiorPar.add( new ParaLiczb(1,1) );
        zbiorPar.add( new ParaLiczb(1,-6) );
        zbiorPar.add( new ParaLiczb(-13,-2) );

        System.out.println(zbiorPar);
    }

    private static void zad2() {
        System.out.println("Sprawdzam czy są litery duplikaty");
        System.out.println("Podaj Tekst");
        String tekst = dajTekst();

        if ( czyMaDuplLiter(tekst) ){
            System.out.println("Twój tekst posiada DUPLIKATY liter");
        }else {
            System.out.println("Twój tekst ma każdej litery tylko po jeden raz");
        }
    }

    private static boolean czyMaDuplLiter(String tekst) {
        Map<Character, Integer> wystepLiter = new LinkedHashMap<>();

        for (int i = 0; i < tekst.length(); i++) {
            if ( wystepLiter.containsKey(tekst.charAt(i)) ){
                wystepLiter.replace(tekst.charAt(i), wystepLiter.get(tekst.charAt(i)) + 1 );
                return true;
            }else {
                wystepLiter.put(tekst.charAt(i), 1);
            }
        }

        return false;
    }


    private static String dajTekst() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.nextLine();
    }

    private static void zad1() {
        Set<Integer> setDoZadan = new HashSet<>(Arrays.asList(10,12,10,3,4,12,12,300,12,40,55) );

        zad1AiB(setDoZadan);
        setDoZadan.remove(10);
        setDoZadan.remove(12);
        System.out.println("\nPo usunięciu dwóch elementów \n**********************");
        zad1AiB(setDoZadan);

        Set<Integer> treeSet = new TreeSet<>( setDoZadan );
        System.out.println("\nA teraz został zmieniony na treeSet \n*********************");
        zad1AiB(treeSet);

    }

    private static void zad1AiB(Set<Integer> naTym ){
        System.out.println("Set ma " + naTym.size() + " elementów");
        for (Integer el: naTym) {
            System.out.print(el + " ");
        }
        System.out.println("\n***************");
        System.out.println(naTym);
    }














}
