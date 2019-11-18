package PazdziernikPart1;

import java.util.Scanner;

public class podstawy {
    private static int wzrost = 0;
    private static int waga = 0;
    private static int wiek = 0;
    private static int[] gostek = {160, 120, 60};

    private static double dochod = 0.0;
    private static double wysPodatek = 0.0;
    private static int kwotawolna = 3000;


    public static void main(String[] args) {
        wzrost =  gostek[0];
        waga = gostek[1];
        wiek =  gostek[2];


        if (wzrost < 150 && wzrost > 220) {
            System.out.println("Nie możesz wejść na kolejkę - nieodpowiedni wzrost");
            System.out.println(wzrost);
        } else if(waga > 180 ){
            System.out.println("Nie możesz wejść na kolejkę - za gruby");
            System.out.println(waga);
        } else if(wiek < 10){
            System.out.println("Nie możesz wejść na kolejkę - jesteś za młody");
            System.out.println(wiek);
        } else if(wiek > 80) {
            System.out.println("Nie możesz wejść na kolejkę - jesteś za stary");
            System.out.println(wiek);
        } else {
            System.out.println("Możesz wejść na kolejkę");
            System.out.println(wzrost + " " + wiek + " " + waga);
        }

        podatek();
        przywitanie();
    }

    private static void przywitanie() {
        String imie = "";
        String nazwisko = "";

        System.out.println("Wpisz swoje imie: ");
        Scanner dajimie = new Scanner(System.in);
        imie = dajimie.next();

        System.out.println("Wpisz swoje nazwisko: ");
        Scanner dajnazwisko = new Scanner(System.in);
        nazwisko = dajnazwisko.next();

        if(imie.equals("Ania") && nazwisko.equals("Szefowa")){
            System.out.println("Siema Szefowa");
        }else {
            System.out.println("Witaj " + imie + " " + nazwisko);
        }

    }

    private static void podatek() {
        System.out.println("\n Podaj swój dochód żeby obliczyć podatek: ");
        Scanner podajDochod = new Scanner(System.in);
        dochod = podajDochod.nextDouble();


        if(dochod > 85528){
            wysPodatek = 14839.02 + ((dochod - 85528)*32/100);
        }else if(dochod > kwotawolna && (dochod * 18 / 100 - 556.02) > 0){
            wysPodatek = dochod * 18 / 100 - 556.02;
        }else if(dochod <= kwotawolna){
            System.out.println("Dochód poniżej kwoty wolnej od podatku");
        }else{
            System.out.println("Dochód jest powyżej kwoty wolnej od podatku lecz i tak jest zbyt niski by podatek był >0");
            System.out.println(wysPodatek = dochod * 18 / 100 - 556.02);
        }

        System.out.println("Twój podatek wynosi: " + wysPodatek);

    }




}
