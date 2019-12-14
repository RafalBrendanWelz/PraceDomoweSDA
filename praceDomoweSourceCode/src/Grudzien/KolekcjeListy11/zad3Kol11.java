package Grudzien.KolekcjeListy11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class zad3Kol11 {

    public static void zad3Main(){
        System.out.println("\n////////////////////////////\n");
        List<String> listaTekst = Arrays.asList("10030", "3004", "4000", "12355", "12222", "67888", "111200", "225355", "2222", "1111", "3546", "138751", "235912") ;
        List<String> takaFixListaForRemoving = new LinkedList<>(List.copyOf(listaTekst));


        System.out.println("indeks elementu 138751 = " + takaFixListaForRemoving.indexOf("138751"));
        System.out.println("jest tu 67888 ? " + takaFixListaForRemoving.contains("67888"));
        System.out.println("jest tu 67889 ? " + takaFixListaForRemoving.contains("67889"));


        System.out.println("\n////////////////////////////\n");
        takaFixListaForRemoving.remove("67888");
        takaFixListaForRemoving.remove("67889");


        System.out.println("jest tu 67888 ? " + takaFixListaForRemoving.contains("67888"));
        System.out.println("jest tu 67889 ? " + takaFixListaForRemoving.contains("67889"));


        System.out.println("\n////////////////////////////\n");
        System.out.println(takaFixListaForRemoving);
        System.out.println("**************************");
        for (String tekst: takaFixListaForRemoving) {
            System.out.println(tekst);
        }

    }




}
