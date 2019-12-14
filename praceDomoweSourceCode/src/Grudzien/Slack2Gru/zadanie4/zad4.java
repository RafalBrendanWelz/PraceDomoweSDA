package Grudzien.Slack2Gru.zadanie4;

import java.util.Scanner;

public class zad4 {

    public static void zad4Start(){
        System.out.println( Math.sqrt(4) );

        IFigura Uzytkownika = kreatorFigury();

        menuObliczenStart ( Uzytkownika );



    }

    private static void menuObliczenStart(IFigura uzytkownika) {
        System.out.println("Witamy w menu obliczeń. Twoją figurą jest: ");
        uzytkownika.wypiszOpis();
        dzialanie( uzytkownika );
    }

    private static void dzialanie(IFigura uzytkownika) {
        System.out.println("Wpisz 1 by obliczyć pole;\n 2 by obliczyć obwód;\n 3 by wypisać opis;\n 0 by zakończyć działanie\n");
        int decyzja = dajInta();
        switch (decyzja){
            case 0:{
                break;
            }case 1:{
                System.out.print("Pole wynosi: ");
                System.out.println(uzytkownika.obliczPole());
                dzialanie( uzytkownika );
                break;
            }case 2:{
                System.out.print("Obwód wynosi: ");
                System.out.println(uzytkownika.obliczObwod());
                dzialanie( uzytkownika );
                break;

            }case 3:{
                uzytkownika.wypiszOpis();
                dzialanie( uzytkownika );
                break;

            } default:{
                System.out.println("wpisałeś niepoprawną wartość");
                dzialanie( uzytkownika );
                break;
            }
        }

    }


    private static IFigura kreatorFigury() {
        System.out.println("Witamy w kreatorze figury, żeby stworzyć nową figurę wypełnij poniższe pola");
        System.out.println("Jaki ma być kształt Figury:\n " +
                "Do wyboru, prostokat, trojkat, kwadrat, kolo");
        ksztaltyFigur jakiKszta = podajKsztalt();

        switch ( jakiKszta ){
            case KOLO:{
                return miaryKola();
            }case KWADRAT:{
                return new Kwadrat( dajInta() );
            }case TROJKAT:{
                return miaryTrojkat();
            }default: {
                return miaryProstokat();
            }
        }

    }

    private static IFigura miaryProstokat() {
        System.out.println("Podaj Dlugosc boków prostokąta, bokA: ");
        int bokA = dajInta();
        System.out.println("Teraz, bokB: ");
        int bokB = dajInta();
        return new Prostokat( bokA, bokB);
    }

    private static IFigura miaryTrojkat() {
        System.out.println("Podaj Dlugosc boków Trójkąta, bokA: ");
        int bokA = dajInta();
        System.out.println("Teraz, bokB: ");
        int bokB = dajInta();
        System.out.println("i jeszcze, bokC: ");
        int bokC = dajInta();
        return new Trojkat( bokA, bokB, bokC );
    }

    private static IFigura miaryKola() {
        System.out.println("Podaj Dlugosc promienia");
        double promien = dajDouble();
        return new Kolo( promien );
    }

    private static int dajInta() {
        Scanner wczyt = new Scanner(System.in);
        while ( !wczyt.hasNextInt()){
            System.out.println("Promień musi być liczbą całkowitą");
            wczyt.next();
        }
        return wczyt.nextInt();
    }

    private static double dajDouble() {
        Scanner wczyt = new Scanner(System.in);
        while ( !wczyt.hasNextDouble()){
            System.out.println("Promień musi być liczbą (może być z przecinkiem) ");
            wczyt.next();
        }
        return wczyt.nextDouble();
    }

    private static ksztaltyFigur podajKsztalt() {
        Scanner dajString = new Scanner(System.in);
        String decyzja = dajString.next();

        String[] nazwyKsztalt = new String[] {ksztaltyFigur.KOLO.nazwa, ksztaltyFigur.KWADRAT.nazwa, ksztaltyFigur.TROJKAT.nazwa, ksztaltyFigur.PROSTOKAT.nazwa};

        for (String nazwa: nazwyKsztalt) {
            if (decyzja.contains(nazwa) ){
                return ksztaltyFigur.valueOf(nazwa.toUpperCase());
            }

        }

        System.out.println("Niepoprawny kształt, więc wybrano prostokąt");
        return ksztaltyFigur.PROSTOKAT;
    }








}
