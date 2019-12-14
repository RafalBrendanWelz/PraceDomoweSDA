package Grudzien.MapNauka;

import javax.swing.*;
import java.util.*;

public class MapaTest {

    public static void zad4Start(){ //zamiast main odniesienie tutaj
        Map<String , Integer> pierwszaMapa = startujBaze();
        System.out.println("******************************* \n");
        dzialaniaHashMap( pierwszaMapa );


        System.out.println("\n**************** HashMap \n \n");
        dzialaniaLinkedHashMap( pierwszaMapa );


        System.out.println("\n**************** LinkedHashMap \n \n");
        Map<String , Integer> pierTreeMap = new TreeMap<>();

        for (String element: pierwszaMapa.keySet() ) {
            pierTreeMap.put( element, pierwszaMapa.get( element ) );
        }

        System.out.println(pierTreeMap + " sout TreeMap() ");
        System.out.println(pierTreeMap.keySet() + " sout TreeMap.keySet() ");
        for (String klucz: pierTreeMap.keySet() ) {
            System.out.print(pierTreeMap.get( klucz ) + " , ");
        }
        System.out.println("\n**************** TreeMap \n \n");


    }

    private static void dzialaniaLinkedHashMap(Map<String, Integer> pierwszaMapa) {
        Map<String , Integer> pierwszaLinkedMapa = new LinkedHashMap();

        for (String element: pierwszaMapa.keySet() ) {
            pierwszaLinkedMapa.put( element, pierwszaMapa.get( element ) );
        }

        System.out.println(pierwszaLinkedMapa + " sout LinkedHashMap() ");
        System.out.println(pierwszaLinkedMapa.keySet() + " sout LinkedHashMap.keySet() ");
        for (String klucz: pierwszaLinkedMapa.keySet() ) {
            System.out.print(pierwszaLinkedMapa.get( klucz ) + " , ");
        }

    }

    private static void dzialaniaHashMap(Map<String, Integer> pierwszaMapa) {

        System.out.println(pierwszaMapa + " sout HashMap() ");
        System.out.println(pierwszaMapa.keySet() + " sout HashMap.keySet() ");  //przykład wypisania mapy przez metodę keySet (wypisuje same klucze)

        for (String pojedynczyKlucz: pierwszaMapa.keySet()) {   //przykład iterowania po kolejnych kluczach utworzenie listy kluczy z mapy
            System.out.print(pierwszaMapa.get( pojedynczyKlucz ) + " , ");  // plus wypisywanie wartości dla kluczy
        }
        System.out.println("\n****************\n");

        int i = 0;
        for (String klucz: pierwszaMapa.keySet() ) {        //przykład wypisywania wartości z HashMapy do pewnego momentu
            i++;
            if (i == (pierwszaMapa.size()/2) +1 ){
                System.out.print(pierwszaMapa.get( klucz ) + " ;");
                break;
            }else {
                System.out.print(pierwszaMapa.get( klucz ) + " , ");
            }
        }

    }

    private static Map<String, Integer> startujBaze() {
        Map<String , Integer> pierwszaMapa = new HashMap<>();

        pierwszaMapa.put("Ronin", 32);
        pierwszaMapa.put("Kostrzyń", 24);
        pierwszaMapa.put("Barbara", 30);
        pierwszaMapa.put("Kamila", 17);
        pierwszaMapa.put("Janusz", 35);
        pierwszaMapa.put("Dżon", 27);
        pierwszaMapa.put("Tusia", 62);
        pierwszaMapa.put("Oli", 124);


        return pierwszaMapa;
    }


}
