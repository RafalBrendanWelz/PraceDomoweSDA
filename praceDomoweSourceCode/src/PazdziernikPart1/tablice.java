package PazdziernikPart1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;

public class tablice {
    public static void main(String[] args) {
        //kolejne zadania z petlami z pliku tablice.pdf:
        //zadanie1();
        //zadanie2();     //update na zajeciach 2 sposob
        zadanie3();

    }

    private static void zadanie3() {
        System.out.println("Podaj dowolną liczbę całkowitą a konwertuję ją na zapis w kodzie binarnym: ");
        int liczbaCalk = 0;
        int reszta = 0;
        boolean[] bitowaKonw = new boolean[32];         //przechowuje kod binarny poprzez true = 1 false = 0
        int jakDlugiBinar = 1;
        int podzielona = 0;

        Scanner podajLiczbe = new Scanner(System.in);
        while (!podajLiczbe.hasNextInt()){                  //textproofed
            System.out.println("To nie jest liczba całkowita ");
            podajLiczbe.next();
        }
        liczbaCalk = podajLiczbe.nextInt();                 //Liczba Decimal to be converted


        while (pow(2,jakDlugiBinar)<=liczbaCalk){   //określenie jak długa liczba i ile będzie w niej 0 i 1
            jakDlugiBinar++;
        }
        for (int i = 0; i < bitowaKonw.length; i++) {   //konwersja decimal to binary i zapisywanie do tablicy boolean od tyłu by łatwo wyświetlać
            if (i==0){
                reszta = liczbaCalk%2;
                podzielona = liczbaCalk/2;
            } else {
                reszta = podzielona % 2;
                podzielona = podzielona / 2;
            }

            if (podzielona > 0 && reszta == 1) {
                bitowaKonw[jakDlugiBinar-i-1] = true;

            } else if (podzielona > 0 && reszta == 0) {
                bitowaKonw[jakDlugiBinar-i-1] = false;

            } else if (podzielona == 0 && reszta == 1) {
                bitowaKonw[jakDlugiBinar-i-1] = true;
                break;
            } else if (podzielona == 0 && reszta == 0) {
                bitowaKonw[jakDlugiBinar-i-1] = false;
                break;
            }
        }

        System.out.print("\n Liczba " + liczbaCalk + " zapisana w systemie binarnym = ");
        for (int i = 0; i < jakDlugiBinar; i++) {
            if (bitowaKonw[i]){
                System.out.print("1");
            }else {
                System.out.print("0");
            }
        }

        System.out.println("\n \n Koniec Programu \n");
    }

    private static void zadanie2() {
        int[] tablica1 = new int[20];   //tablica 20 losowanych elementów na której wszystkie operacje
        final int przedPlus = 10;
        final int przedMinus = 1;
        Random losow = new Random();

        boolean[] duplikaty = new boolean[20];
        for (int i = 0; i < duplikaty.length; i++) {        //do sprawdzania czy duplikat i nie wypisywania x razy że coś jest iles razy
            duplikaty[i] = false;                           //do pierwszego sposobu
        }
        int iloscWystapien = 0;


        System.out.println("Twoja Tablica: ");
        System.out.print("{");
        for (int i = 0; i < tablica1.length; i++) {
            tablica1[i] = losow.nextInt(przedPlus - przedMinus) + przedMinus;       //plus 1 w bound trzeba dodać by łącznie z max
            System.out.print(tablica1[i] + " ");
        }
        System.out.print("} +\n");

       /* Arrays.sort(tablica1);  //odwołanie do metody ze standardu Javy sortującej tablicę;
        System.out.println("\n Tablica posortowana rosnąco:");      //F
        System.out.print("{");
        for (int i = 0; i < tablica1.length; i++) { //G
            System.out.print(tablica1[i] + " ");
        }
        System.out.print("} \n");*/ //część w tym komentarzu dla testów do lepszej czytelności czy powtórzenia się zgadzają

        System.out.println("\n Wystąpienia poszczególnych wartości w tablicy: ");
        for (int i = 0; i < tablica1.length; i++) {
            for (int j = 0; j < tablica1.length; j++) {
                if (i==j && !duplikaty[i]) {
                    iloscWystapien++;
                }else if(i!=j && tablica1[i]==tablica1[j] && !duplikaty[i]){
                    iloscWystapien++;
                    duplikaty[j] = true;
                }
            }
            if (iloscWystapien>0){
                System.out.println(tablica1[i] + " : " + iloscWystapien + " powtórzeń");
            }

            iloscWystapien=0;
        }

        System.out.println("\n Teraz Za pomocą drugiego sposobu z podrzędną tablicą");
        int[] tablicaWystapien = new int[10];     //drugi sposób poprzez wykorzystanie drugiej tablicy ile występuje liczb

        for (int i = 0; i < tablica1.length; i++) {
            tablicaWystapien[tablica1[i]] += 1;
        }

        for (int i = 0; i < tablicaWystapien.length; i++) {
            System.out.println(i + " występuje  " + tablicaWystapien[i] + "  razy w tablicy losowych");
        }                                           //koniec drugiego sposobu do porównań poprzez 2 tablicę posiadającą ile razy występuje liczba indeks
        System.out.println("\n \n");

        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie1() {
        int tablica1[] = new int[10];   //tablica 10 elementów na której wszystkie operacje
        final int przedPlus = 10;
        final int przedMinus = -10;
        int wartosc;
        Random losow = new Random();                                                //funkcja Random z standardu metod java sprzed 1.7
        int minimal = 2000000000;
        int maximal = -2000000000;
        float srednia = 0;
        int suma = 0;
        int wiekszeSrednia = 0;
        int mniejszeSrednia = 0;

        System.out.println("Oto wylosowana tablica dziesięciu elementów: \n");
        System.out.print("{");
        for (int i = 0; i < tablica1.length; i++) {
            wartosc = losow.nextInt(przedPlus-przedMinus+1) + przedMinus;       //bound oznacza zakres z którego losuje, plus 1 po to by było łącznie z maX standard <0,max)
            tablica1[i] = wartosc;               //A
            System.out.print(tablica1[i] + " ");        //B
            minimal = min(tablica1[i],minimal);
            maximal = max(tablica1[i],maximal);
            suma+=tablica1[i];
        }
        System.out.println("}");
        System.out.println("Najmniejszy element z tablicy = " + minimal);            //C
        System.out.println("Największy element z tablicy = " + maximal + "\n");            //C

        srednia = (float) suma/tablica1.length;
        System.out.println("Średnia arytmetyczna z elementów tablicy = " + srednia);    //D

        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i]>srednia){
                wiekszeSrednia++;
            }else if (tablica1[i]<srednia){
                mniejszeSrednia++;
            }
        }
        System.out.println("W podanej tablicy jest | " + wiekszeSrednia + " | Elementów większych niż średnia tablicy");   //E
        System.out.println("W podanej tablicy jest | " + mniejszeSrednia + " | Elementów mniejszych niż średnia tablicy"); //E

        System.out.println("\n Tablica odwrotnej kolejności do twojej:");      //F
        System.out.print("{");
        for (int i = 1; i <= tablica1.length; i++) {
            System.out.print(tablica1[tablica1.length-i] + " ");
        }
        System.out.print("} \n");


        //Arrays. - metodologia Java praca na tablicach.
        Arrays.sort(tablica1);  //odwołanie do metody ze standardu Javy sortującej tablicę;
        System.out.println("\n Tablica posortowana rosnąco:");      //F
        System.out.print("{");
        for (int i = 0; i < tablica1.length; i++) { //G
            System.out.print(tablica1[i] + " ");
        }
        System.out.print("} \n");
        if (tablica1.length % 2 == 0) {
            int mediana = (tablica1[tablica1.length / 2] + tablica1[(tablica1.length - 1) / 2]) / 2;
            System.out.println("Mediana z posortowanej tablicy = | " + mediana + " |");
        } else {
            System.out.println("Mediana z posortowanej tablicy = | " + tablica1[(tablica1.length / 2) + 1] + " |");
        }



    }


}
