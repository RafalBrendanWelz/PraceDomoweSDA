package Grudzien.KolekcjeListy11;

import java.util.ArrayList;
import java.util.List;

public class zad2Kol11 {


    public static void zad2Main(){
        List<Integer> kolejnaListaInt = new ArrayList<>();

        while (kolejnaListaInt.size() <10 ){
            kolejnaListaInt.add( zad1Kol11.losLiczbe() );
        }
        System.out.println(kolejnaListaInt);
        System.out.println("\n//////////////////////////////////\n");

        System.out.println("Suma liczb z listy KolejnaListaInt = " + kolejnaListaInt.stream().mapToInt(Integer::intValue).sum() );
        double sredniaLity = (double)( kolejnaListaInt.stream().mapToInt(Integer::intValue).sum() ) / kolejnaListaInt.size();
        System.out.println("Srednia liczb z listy KolejnaListaInt = " + sredniaLity);


        System.out.println("\n//////////////////////////////////\n");
        List<Integer> kopiaListy = new ArrayList<>(List.copyOf(kolejnaListaInt));
        kopiaListy.sort( Integer::compareTo );
        System.out.println(kopiaListy);

        System.out.println("Mediana z listy to: " + ( kopiaListy.get( (kopiaListy.size() / 2 ) - 1) + kopiaListy.get( kopiaListy.size() / 2 ) ) /2  );        //mediana
        System.out.println("Max wartość = " + kopiaListy.get(kopiaListy.size()-1 ) + " Min wartość = " + kopiaListy.get( 0 )  );

        System.out.println("\n//////////////////////////////////\n");
        System.out.println("Maksymalna i Minimalna Wartość, znalezienie bez sortowania");

        int[] max = new int[] {-99999, 0 } ;
        int[] min = new int[] {99999, 0 } ;

        for (Integer lb: kolejnaListaInt) {
            max[0] = Math.max( max[0], lb );
            min[0] = Math.min( min[0], lb );
        }
        for (int i = 0; i < kolejnaListaInt.size(); i++) {
            if (kolejnaListaInt.get(i) == max[0] ){
                max[1] = i;
            }else if (kolejnaListaInt.get(i) == min[0] ){
                min[1] = i;
            }
        }
        System.out.println(kolejnaListaInt);
        System.out.println("Max wartość = " + max[0] + " i jest to: " + max[1] + " liczba. Min wartość = " + min[0] + " i jest to: " + min[1] + " liczba (indeks) ");

        System.out.println("\n//////////////////////////////////\n");
        System.out.println("Indeksy max i min bez drugiej Pętli znalezione");
        max[1] = kolejnaListaInt.indexOf(max[0]);
        min[1] = kolejnaListaInt.indexOf(min[0]);
        System.out.println("Max wartość = " + max[0] + " i jest to: " + max[1] + " liczba. Min wartość = " + min[0] + " i jest to: " + min[1] + " liczba (indeks) ");


    }





}
