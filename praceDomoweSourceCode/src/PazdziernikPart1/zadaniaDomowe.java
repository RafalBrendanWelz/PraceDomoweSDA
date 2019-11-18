package PazdziernikPart1;

import java.util.Scanner;

public class zadaniaDomowe {

    public static void main(String[] args) {
        //zadania z pliku Zadania_domowe.txt
        //zadanie1();
        //zadanie2();
        //zadanie3();
        zadaniezeString();



    }

    private static void zadaniezeString() {
        System.out.println("Wpisz Polskie Imię a je zbadam");
        Scanner podajDane = new Scanner(System.in);

        String imie = podajDane.nextLine();
        imie = imie.trim();                     //By pozbyć się niepotrzebnych początkowych spacji

        String poSpacji;
        int ktoraSpacja = 0;

        String bezPierwszejLitery;

        if (imie.contains(" ")){
            for (int i = 0; i < imie.length(); i++) {
                if (imie.charAt(i)==' '){
                    ktoraSpacja=i;
                    break;
                }
            }
            poSpacji = imie.substring(ktoraSpacja);
            imie = imie.substring(0,ktoraSpacja);
            System.out.println(" ");
            System.out.println("Podane Imię = " + imie + "    Dodałeś do niego również tekst: " + poSpacji);

        }else {
            System.out.println("Podane Imię = " + imie);
        }


        System.out.print("Imie (prawdop.) ");     //B płeć    + D) inna metoda sprawdzenia ostatniej litery niż endsWith
        if (imie.charAt(imie.length()-1)=='a'){
            System.out.println("żeńskie.");
        }else {
            System.out.println("męskie.");
        }

        System.out.println("Twoje imię ma " + imie.length() + " liter");   //C ilość znaków
        if (imie.toUpperCase().charAt(0)==imie.charAt(0)){                  //C czy duża litera

        }else {
            bezPierwszejLitery = imie.substring(1);
            System.out.println("Napisałeś je z małej litery. Powinno być:  " + imie.trim().toUpperCase().charAt(0) + bezPierwszejLitery);
        }



        System.out.println("\n\n\n  Koniec Programu \n ");
    }

    private static void zadanie3() {
        System.out.println("Tablica 100 intów losowymi liczbami wypełniona a liczby jej w zakresie od 0 do 1000 występują, : ");
        System.out.println(" spośród liczb swoich posiada: \n");
        int[] tablicaLos = new int[100];

        int iloscDzielnik = 2;  //zawsze ma 2 dzielniki bo 1 i sama przez się

        for (int i = 0; i < 100; i++) {
            tablicaLos[i]=(int) (Math.random()*1000);
        }

        System.out.println("A+B+C: Takie oto liczby pierwsze: +mające 3 dzielniki:    +mające 4 dzielniki: \n");
        for (int i = 0; i < 100; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (tablicaLos[i] % j == 0) {
                    iloscDzielnik++;
                    if (iloscDzielnik == 5) {
                        break;
                    }
                }
            }

            switch (iloscDzielnik) {
                case 2: {
                    System.out.println(i + " =  " + tablicaLos[i] + "  liczba pierwsza ");
                    break;
                }
                case 3: {
                    System.out.println(i + " =  " + tablicaLos[i] + "  ma 3 dzielniki ");
                    break;
                }
                case 4: {
                    System.out.println(i + " =  " + tablicaLos[i] + "  ma 4 dzielniki ");
                    break;
                }
                default: {
                    System.out.println(i + " =  " + tablicaLos[i] + "  ma więcej niż 4 dzielniki  ");
                }
            }

            iloscDzielnik = 2;
        }

        System.out.println("\n\n\n  Koniec Programu \n ");
    }

    private static void zadanie2() {
        System.out.println("Wpisz liczbę pięter od 2 do 10");
        Scanner podajDane = new Scanner(System.in);
        int liczbaPieter = 2;
        boolean dobraLiczba = false;

        final int pietraMax = 10;
        final int pietraMin = 2;


        while (!dobraLiczba){
            if (podajDane.hasNextInt()){
                liczbaPieter = podajDane.nextInt();

                if (liczbaPieter>=pietraMin && liczbaPieter<=pietraMax){
                    dobraLiczba=true;
                }else {
                    System.out.println("Liczba Pięter musi należeć do przedziału <2,10>");
                }
            }else {
                System.out.println("Liczba Pięter musi być liczbą z przedziału <2,10>");
                podajDane.next();
            }
        }

        System.out.println("Oto twój wieżowiec " + liczbaPieter + " Piętrowy: ");
        System.out.println("_____________"); //szerokość wieżowca = 13
        for (int i = -1; i <= (liczbaPieter*2)+1; i++) {   //wysokośc pietra = 2
            if (i%2==0){
                System.out.print("| |_| |_| |");
            }else if(i==-1) {
                System.out.print("|  _REG_  |");
            }else if(i==((liczbaPieter*2)+1)) {
                System.out.print("|   []    |");
            }else {
                System.out.print("|  _   _  |");
            }
            System.out.println("");
        }
        System.out.println("^^^^^^^^^^^^^#######");


        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie1() {
        System.out.println("Tablica 100 intów losowymi liczbami wypełniona a liczby jej w zakresie od 0 do 1000 występują, : ");
        System.out.println(" spośród liczb swoich posiada: ");
        int[] tablicaLos = new int[100];

        boolean liczbaPierwsza = false;
        int sumaNieparzystych = 0;
        int sumaPiatek = 0;

        for (int i = 0; i < 100; i++) {
            tablicaLos[i]=(int) (Math.random()*1000);
        }

        System.out.println("A: Takie oto liczby na pozycjach tablicy o numerach parzystych (0,2,4...) : ");
        System.out.print("{");
        for (int i = 0; i < 100; i+=2) {
            if (i==98){
                System.out.print(tablicaLos[i]+"}");
            }else {
                System.out.print(tablicaLos[i]+" ");
            }
        }
        System.out.println("\n");

        System.out.println("B: Takie oto liczby parzyste : ");
        System.out.print("{");
        for (int i = 0; i < 100; i++) {
            if (tablicaLos[i]%2==0){
                System.out.print(tablicaLos[i]+" ");
            }
        }
        System.out.println("} \n");

        System.out.println("C: Takie oto liczby podzielne równocześnie przez liczbę 2 oraz liczbę 3: ");
        System.out.print("{");
        for (int i = 0; i < 100; i++) {
            if (tablicaLos[i]%2==0 && tablicaLos[i]%3==0){
                System.out.print(tablicaLos[i]+" ");
            }
        }
        System.out.println("} \n");

        System.out.println("D: Takie oto liczby będące liczbami pierwszymi: ");
        System.out.print("{");
        for (int i = 0; i < 100; i++) {
            for (int j = 2; j < i/2; j++) {
               if (tablicaLos[i]%j==0){
                   liczbaPierwsza=false;
                   break;
               }else {
                   liczbaPierwsza=true;
               }

            }

            if (liczbaPierwsza){
                System.out.print(tablicaLos[i]+" ");
            }
            liczbaPierwsza=false;
        }
        System.out.println("} \n");


        System.out.println("E: Z wszystkich liczb owej tablicy suma liczb nieparzystych spośród wcześniej opisanych wszystkich liczb wynosi: ");
        for (int i = 0; i < 100; i++) {
            if (tablicaLos[i]%2!=0){
                sumaNieparzystych += tablicaLos[i];
            }
        }
        System.out.println(sumaNieparzystych);
        System.out.println("");

        System.out.println("F: A z wymienionych w powyżyszym i poprzednim punkcie wszystkich liczb owej tablicy suma tych podzielnych przez 5 z nich wynosi: ");
        for (int i = 0; i < 100; i++) {
            if (tablicaLos[i]%5==0){
                sumaPiatek += tablicaLos[i];
            }
        }
        System.out.println(sumaPiatek);
        System.out.println("\n");

        System.out.println("\n \n    Koniec Programu \n ");
    }


}
