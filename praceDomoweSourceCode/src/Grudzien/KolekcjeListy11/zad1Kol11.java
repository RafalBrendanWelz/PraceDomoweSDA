package Grudzien.KolekcjeListy11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class zad1Kol11 {


    public static void zad1Start(){
        List<Integer> podstLista = new ArrayList<>();

        while (podstLista.size()< 5 ){
            podstLista.add( dajLiczbe() );
        }

        while (podstLista.size()<10 && podstLista.size() > 4 ){
            podstLista.add( losLiczbe() );
        }

        System.out.println(podstLista);

        System.out.println("\n///////////////////\n");
        for (Integer lb: podstLista) {
            System.out.println(lb);
        }

    }

    public static int dajLiczbe(){
        Scanner wczyt = new Scanner(System.in);
        System.out.println("Wpisz Liczbę: ");
        while (!wczyt.hasNextInt() ){
            wczyt.next();
        }
        return wczyt.nextInt();
    }

    public static int losLiczbe(){
        Random maszynaLosujaca = new Random();
        return maszynaLosujaca.nextInt(1000);
    }



}
