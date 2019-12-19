package Grudzien.KolekcjeListy11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class zad4Kol11 {

    public static void zad4Main(){
        List<String> listaTekstow = new ArrayList<>();
        wypelnijListeStringLosLiczba( listaTekstow, 100, 0, 101 );

        System.out.println(listaTekstow);
        double srednia = obliczSredniaListyTekst(listaTekstow);
        System.out.println("\nśrednia arytmetyczna liczb z listy wynosi: " + srednia );

        for (int i = 0; i < 5; i++) {
            usunWszystkieElemPowyzejLiczby(listaTekstow, srednia);
            System.out.println("Srednia wynosi " + srednia +"\n" + listaTekstow + " po usunięciu tych powyżej średniej");
            srednia = obliczSredniaListyTekst(listaTekstow);
        }


        String[] tablica = kopiaListyDoTablicy(listaTekstow);
        System.out.println("\n" + Arrays.toString(tablica));
    }

    private static String[] kopiaListyDoTablicy ( List<String> takaLista){
        String[] wynik = new String[takaLista.size()];
        int index = 0;

        for (String ele:takaLista) {
            if (ele != null){
                wynik[index] = ele;
                index++;
            }
        }

        return wynik;
    }


    private static void usunWszystkieElemPowyzejLiczby (List<String> lista, double liczba){
        int max = lista.size();

        for (int i = 0; i < max; i++) {
            if (Integer.parseInt(lista.get(i) ) > liczba){
                lista.remove( lista.get(i) );
                i--;
                max--;
            }
        }
    }

    private static double obliczSredniaListyTekst (List<String> lista){
        return (double) sumujListe(lista, 0) / lista.size();
    }

    private static int sumujListe (List<String> lista, int ktora){
        return (ktora == lista.size()-1 ) ? ( 0 ) : ( Integer.parseInt( lista.get(ktora) ) + sumujListe(lista, ++ktora) );
    }

    private static void wypelnijListeStringLosLiczba(List<String> lista, int ile, int minZakres, int maxZakres) {   //losuje ile liczb z zakres min-max
        Random losowanie = new Random();
        if (ile == 0){

        }else if (ile > 0){
            lista.add( String.valueOf(losowanie.nextInt(maxZakres - minZakres) + minZakres) );
            wypelnijListeStringLosLiczba(lista, ile-1, minZakres, maxZakres);
        }else {
            lista.add( String.valueOf(losowanie.nextInt(maxZakres - minZakres) + minZakres) );
            wypelnijListeStringLosLiczba(lista, ile+1, minZakres, maxZakres);
        }
    }


}
