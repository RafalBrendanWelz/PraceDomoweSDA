package PazdziernikPart1;

import java.sql.ClientInfoStatus;
import java.util.Scanner;

import static java.lang.Math.*;

public class petle {

    public static void main(String[] args) {
        //kolejne zadania z petlami z pliku petle.pdf:
        zadanie1switch();
        //zadanie2();
        //zadanie3();
        //zadanie4();
        //zadanie5();
        //zadanie6();         //update 18.10.2019 - dodanie drugiego sposobu
        //zadanie7();
        //zadanie8();
        //zadanie9();
        //zadanie10();
        //zadanie11();
        //zadanie12();
        //zadanie13();
        //zadanie14();
        //zadanie15();
        //zadanie16();
        //zadanie17();
        //zadanie18();
        //zadanie z podpunktu Zbiór:
        //zbior1oraz2();    //brak zabezpieczenia przed wpisywaniem tekstu
        zbior3();
        //zbior4();
        //zbior5oraz6();
        //zbior7oraz8();
        //zbior9();
        //zbior10oraz11();
        //zbior12();
        //zbior13();
        //zbior14();      //wersja na jedną pętlę sprawdzającą i wypisującą zamiast oddzielnego zaznaczania boolean pierwsza + zawiera wypisanie czasu wykonania Optymalizacja
        //zbior15();      //prosta wersja wypisuje równoczesnie z podawaniem
        //zbior15dlugX();     //przy zalozeniu ze na start podajesz jak dlugi bedzie ciag glowny



    }

    private static void zbior15dlugX() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Wpisz ciąg liczb X (ilosc X) a ja ci wyświetlę ciąg liczb o długości X-1");
        System.out.println("Posiadający największą sumę podliczb spośród wszystkich takich ciągów ");
        System.out.println("Czyli najpierw wpisz jak dużo liczb będziesz podawał: ");
        int ileLiczbmax = 1;
        int minimal = 1231415415;
        int Lminusowe = 0;
        while (!podajeliczby.hasNextInt()){
            System.out.println("To nie jest prawidłowa liczba!!");
            podajeliczby.next();
        }
        ileLiczbmax = podajeliczby.nextInt();

        if (ileLiczbmax>0) {
            int ciagX[] = new int[ileLiczbmax];

            System.out.println("Teraz uzupełnij ciąg o " + ileLiczbmax + " liczb: ");   //podanie ciągu wstępnego
            for (int i = 0; i < ileLiczbmax; i++) {
                while (!podajeliczby.hasNextInt()) {
                    System.out.println("To nie jest prawidłowa liczba!!");
                    podajeliczby.next();
                }
                ciagX[i] = podajeliczby.nextInt();
                if (ciagX[i]<0){
                    Lminusowe++;
                }
            }

            if (Lminusowe==0){
               Lminusowe=1;
            }
            int ciagMAX[] = new int[ileLiczbmax-Lminusowe];
            int skok = 0;
            int j = 0;


            for (int i = 0; i < ileLiczbmax; i++) {            //wypełnienie ciągu maksymalnego
                if (ciagX[i]>0 && j==ileLiczbmax-Lminusowe && ciagX[i]>minimal){

                    for (int k = 0; k < ileLiczbmax-Lminusowe; k++) {
                        if (ciagMAX[k]==minimal){
                            ciagMAX[k] = ciagX[i];
                            break;
                        }
                    }
                }else if (ciagX[i]>0 && j<ileLiczbmax-Lminusowe){
                    ciagMAX[j] = ciagX[i];
                    j++;
                    minimal = min(minimal,ciagX[i]);
                    System.out.print(j + " ");
                }



            }


            System.out.println("Twój ciąg jaki podałeś to: ");      //dla czytelności oryginalny ciąg
            for (int i = 0; i < ileLiczbmax; i++) {
                if (i==0){
                    System.out.print("{" + ciagX[i] + " , ");
                }else if (i==ileLiczbmax-1){
                    System.out.print(ciagX[i] + "}");
                }else {
                    System.out.print(ciagX[i] + " , ");
                }
            }
                                                                         // Finalna odpowiedź na zadanie
            System.out.println("\n Pomniejszy ciąg zawierający się w podanym przez ciebie ciągu o najwiekszej sumie to: ");
            for (int i = 0; i < ileLiczbmax-Lminusowe; i++) {
                if (i==0){
                        if (ciagMAX[i]==0){
                            System.out.print("{");
                        }else {
                            System.out.print("{" + ciagMAX[i] + " , ");
                        }
                }else if (i==ileLiczbmax-Lminusowe-1){
                    if (ciagMAX[i]==0){
                        System.out.print("}");
                    }else {
                        System.out.print(ciagMAX[i] + "}");
                    }
                }else if(ciagMAX[i]!=0){
                    System.out.print(ciagMAX[i] + " , ");
                }
            }

        }

        System.out.println("\n \n  Koniec Programu \n");
    }

    private static void zbior15() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Wpisz ciąg liczb X (dowolna ilosc) a ja ci wyświetlę ciąg liczb o długości X-1");
        System.out.println("Posiadający największą sumę podliczb spośród wszystkich takich ciągów ");
        System.out.println("Czyli najpierw podaj ciąg liczb - by zakończyć wpisywanie wpisz dowolny znak, tekst niebędący liczbą: ");
        int liczbazCiagu;
        int ktoraPetla = 0;

        while (podajeliczby.hasNextInt()){
            liczbazCiagu=podajeliczby.nextInt();
            if (ktoraPetla==0 && liczbazCiagu>0){
                System.out.println("Pomniejszy Ciąg z podanego przez ciebie o największej sumie to: ");
                System.out.print(liczbazCiagu + " ");
                ktoraPetla++;

            }else if (liczbazCiagu>0){
                System.out.print(liczbazCiagu + " ");
                ktoraPetla++;
            }

        }

        System.out.println("\n \n  Koniec Programu \n");
    }

    private static void zbior14() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Wczytaj X a wypiszę ci X początkowych liczb pierwszych");
        int liczbaX;

        while (!podajeliczby.hasNextInt()) {
            System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
            podajeliczby.next();
        }
        liczbaX = podajeliczby.nextInt();

        long startTime = System.currentTimeMillis();
        if (liczbaX > 0) {
            System.out.print("Wszystkie Liczby Pierwsze dodatnie do liczby " + liczbaX + " = ");
            for (int i = 0; i <= liczbaX; i++) {
                if (i == 1 || i == 2 || i == 0 || i == 3 || i == 5 || i == 7 || i == 11) {
                    System.out.print(i + " ");
                } else {
                    for (int j = 2; j < i/2; j++) {       //pierwsza wersja była dla (do j<i) na dole wyniki optymalizacji
                        if (i % j == 0) {
                            break;
                        } else if (j == (i/2) - 1) {
                            System.out.print(i + " , ");
                        }
                    }
                }
            }
        } else if (liczbaX < 0) {
            System.out.print("Wszystkie Liczby Pierwsze ujemne do liczby " + liczbaX + " = ");
            for (int i = 0; i >= liczbaX; i--) {
                if (i == -1 || i == -2 || i == 0 || i == -3 || i == -5 || i == -7 ) {
                    System.out.print(i + " ");
                } else {
                    for (int j = -2; j > i/2; j--) {
                        if (i % j == 0) {
                            break;
                        } else if (j == (i/2) + 1) {
                            System.out.print(i + " , ");
                        }
                    }
                }
            }
        } else System.out.print("Wszystkie liczby pierwsze do liczby zero = " + liczbaX);
        System.out.println("\n");


        //CZASOWE DANE DO OPTYMALIZACJI:
        //Czas wykonania do 1 000 000 przy pełnych obrotach (do i-1)      = 164.214 sekund = 2.74 min
        //Czas wykonania do 1 000 000 przy obrotach do połowy (do i/2)    = 87.891 sekund = 1.46 min    =1.86 razy szybciej (186.83% szybkości)
        //Czas wykonania do 1 000 000 -||- i z wykluczeniem l.pierw. do11 = 87.141 sekund = 1.45 min    =1.88 razy szybciej (188.45% szybkości)

        long endTime = System.currentTimeMillis();
        double czasWykonania = (double) (endTime - startTime) / 1000;
        System.out.println("\n \n  Koniec Programu: Czasy Wykonania " + czasWykonania + " sekund \n");
    }

    private static void zbior13() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 9 liczb większych od zera a ja wypiszę je wypisując duplikaty tylko raz: ");
        System.out.println("Duplikat - w podanym ciągu liczb, liczba która występuje więcej niż raz ");
        int liczbaA[] = {0,0,0,0,0,0,0,0,0};
        boolean duplikat[] = {false,false,false,false,false,false,false,false,false};

        for (int i = 0; i < liczbaA.length; i++) {
            while (!podajeliczby.hasNextInt()) {
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA[i] = podajeliczby.nextInt();
        }

        System.out.println("Podane przez ciebie liczby (wypisując duplikaty tylko raz) to: ");
        for (int i = 0; i < liczbaA.length; i++) {
            for (int j = i+1; j < liczbaA.length; j++) {
                if (liczbaA[i]==liczbaA[j]){
                    duplikat[i]=true;
                }
            }
            if (duplikat[i]==false){
                System.out.print(liczbaA[i] + " ");
            }
        }

        System.out.println("\n \n  Koniec Programu \n");
    }

    private static void zbior12() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 10 liczb większych od zera a ja wypiszę ich medianę: ");
        System.out.println("Mediana - Z podanego ciągu liczb jest liczb podaną w połowie (zajmującą pozycję środkową) ");
        int liczbaA[] = {0,0,0,0,0,0,0,0,0,0};
        boolean czyParzysta = true;
        float mediana;

        for (int i = 0; i < 10; i++) {
            while (!podajeliczby.hasNextInt()) {
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA[i] = podajeliczby.nextInt();

        }
        if (czyParzysta){
            mediana = (float) (liczbaA[(liczbaA.length+1)/2] + liczbaA[(liczbaA.length-1)/2]) /2;
            System.out.println("Medianą jest liczba: " + mediana + "\n*(nie ma miejsca środkowego, mediana występuje pomiędzy dwoma liczbami: " + liczbaA[(liczbaA.length-1)/2] + " " + liczbaA[(liczbaA.length+1)/2] + ")");
        }else {
            System.out.println("Medianą jest liczba: " + liczbaA[liczbaA.length/2]);
        }



        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior10oraz11() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podawaj liczby tak długo aż ich suma osiągnie 10: ");
        int liczbaA;
        int suma = 0;

        System.out.println("Suma obecnie wynosi: ");
        while (suma!=10){
            while (!podajeliczby.hasNextInt()){
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA = podajeliczby.nextInt();
            suma += liczbaA;
            System.out.print(suma + " ");
        }
        System.out.println("\n Brawo suma jest dziesięć");
        System.out.println("\n");


        System.out.println("Podawaj liczby tak długo aż ich suma osiągnie 0: ");
        while (!podajeliczby.hasNextInt()){
            System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
            podajeliczby.next();
        }
        suma = podajeliczby.nextInt();

        System.out.println("Suma obecnie wynosi: ");
        System.out.print(suma + " ");
        while (suma!=0){
            while (!podajeliczby.hasNextInt()){
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA = podajeliczby.nextInt();
            suma += liczbaA;
            System.out.print(suma + " ");
        }
        System.out.println("Brawo suma jest zero");

        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior9() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 5 liczb a wyliczę z nich średnią: ");
        float liczbaA;
        float ileLiczb = 0;
        float srednia = 0;
        float suma = 0;

        while (ileLiczb<5){
            while (!podajeliczby.hasNextInt()){
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA = podajeliczby.nextInt();
            suma += liczbaA;
            ileLiczb++;
        }

        if (suma==0){
            System.out.println("Z podanych pięciu liczb średnia wynosi: " + srednia);
        }else {
            srednia = (suma / ileLiczb);
            System.out.println("Z podanych 5 liczb średnia wynosi: " + srednia);
        }

        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior7oraz8() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 5 liczb większych od zera i 5 liczb mniejszych od 0 a ja wypiszę największą i najmniejszą z nich oraz ich sumę: ");
        int liczbaA;
        int minimal = 2147000000;
        int maksimal = -2147000000;
        int suma = 0;

        int plusowe = 0;
        int minusowe = 0;

        while (plusowe<5 || minusowe<5){
            while (!podajeliczby.hasNextInt()){
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA = podajeliczby.nextInt();

            if (liczbaA > 0) {
                if (plusowe<5){
                    maksimal = max(maksimal, liczbaA);
                    minimal = min(minimal, liczbaA);
                    suma = suma + liczbaA;
                    plusowe++;
                }else  {
                    System.out.println("Masz już wpisane " + plusowe + " liczb >0");
                }

            } else if (liczbaA<0) {
                if (minusowe<5) {
                    maksimal = max(maksimal, liczbaA);
                    minimal = min(minimal, liczbaA);
                    suma = suma + liczbaA;
                    minusowe++;
                }else  {
                    System.out.println("Masz już wpisane " + minusowe + " liczb <0");
                }

            }else {
                maksimal = max(maksimal, liczbaA);
                minimal = min(minimal, liczbaA);
            }
        }
        System.out.println("Suma podanych liczb wynosi: " + suma);
        System.out.println("Największa liczba z nich to: " + maksimal);
        System.out.println("Najmniejsza liczba z nich to: " + minimal);



        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior5oraz6() throws java.util.InputMismatchException{
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 5 liczb większych od zera a ja wypiszę największą i najmniejszą z nich: ");
        int liczbaA;
        int minimal = 2147000000;
        int maksimal = -2147000000;


        for (int i = 0; i < 5; ) {
            while (!podajeliczby.hasNextInt()) {
                System.out.println("Nie podałeś prawidłowej liczby ");  //test czy powtarza szukanie inta
                podajeliczby.next();
            }
            liczbaA = podajeliczby.nextInt();

            if (liczbaA > 0) {
                maksimal = max(maksimal, liczbaA);
                minimal = min(minimal, liczbaA);
                i++;
                //System.out.println(i);    //test czy przechodzi

            } else if (liczbaA <= 0) {
                maksimal = max(maksimal, liczbaA);
                minimal = min(minimal, liczbaA);

            }

        }
        System.out.println("Największa liczba z nich to: " + maksimal);
        System.out.println("Najmniejsza liczba z nich to: " + minimal);


        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior4() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj liczbę A a wykonam (silnia z A): ");
        System.out.println("lub wpisz 0 by zakończyć program: ");
        long liczbaA;
        long wynikSilni = 0;

        while (!podajeliczby.hasNextInt()){
            podajeliczby.next();
        }
        liczbaA = podajeliczby.nextInt();

        if(liczbaA>1){
            for (int i = 1; i < liczbaA; i++) {
                if (i == 1){
                    wynikSilni = i * (i+1);
                }else {
                    wynikSilni = wynikSilni * (i+1);
                }
            }
            System.out.println("Silnia z " + liczbaA + " = " + wynikSilni);

        }else if (liczbaA<-1){
            for (int i = -1; i > liczbaA; i--) {
                if (i == -1){
                    wynikSilni = i * (i-1);
                }else {
                    wynikSilni = wynikSilni * (i-1);
                }
            }
            System.out.println("Silnia z " + liczbaA + " = " + wynikSilni);

        }else if (liczbaA==0 || liczbaA ==1 || liczbaA ==-1){
            System.out.println("silnia z " + liczbaA + " = 1 ");
        }


        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior3() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj 2 liczby A i B a podniosę A do potęgi B: ");
        System.out.println("NIE OBSłUGUJEMY MINUSOWYCH LICZB ");
        long liczbaA;
        long liczbaB;
        long wynikPotegi = 1;


        while (!podajeliczby.hasNextInt()){
            podajeliczby.next();
        }
        liczbaA = podajeliczby.nextInt();
        if (liczbaA==0){
            liczbaA+=1;
            System.out.println("A nie moze być 0 więc działa na 1");
        }
        while (!podajeliczby.hasNextInt()){
            podajeliczby.next();
        }
        liczbaB = podajeliczby.nextInt();


        if (liczbaB <0){
            System.out.println("Nie obsługujemy minusowych podniesien do potegi");
        }else if (liczbaB >0) {
            for (int i = 0; i < liczbaB; i++) {

                wynikPotegi *= liczbaA;
            }
        }
        System.out.println("Liczba " + liczbaA + " do potęgi " + liczbaB + " = " + wynikPotegi);



        System.out.println("\n Koniec Programu \n");
    }

    private static void zbior1oraz2() {
        Scanner podajeliczby = new Scanner(System.in);
        int liczbaDana;
        int suma = 0;

        System.out.println("Podaj 5 liczb:");
        for (int i = 1; i <=5 ; i++) {
            liczbaDana = podajeliczby.nextInt();
            suma +=liczbaDana;
        }
        System.out.println("Suma pięciu kolejnych podanych przez ciebie liczb = " + suma);
        System.out.println("\n");

        System.out.println("Podaj x: ");
        System.out.println("A następnie podasz x liczb które zsumuje: ");
        int liczbaX;
        liczbaX = podajeliczby.nextInt();
        suma = 0;
        System.out.println("Teraz podaj 5 liczb ");
        for (int i = 1; i <=liczbaX ; i++) {
            liczbaDana = podajeliczby.nextInt();
            suma +=liczbaDana;
        }
        System.out.println("Suma " + liczbaX + " kolejnych podanych przez ciebie liczb = " + suma);
        System.out.println("\n");

        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie18() {
        Scanner podajeliczby = new Scanner(System.in);
        int maks = 1000;
        int min = 10;
        int liczbaDana;
        System.out.println("Podawaj liczbę tak długo aż trafisz na liczbę mieszczącą się w przedziale: min(random) do maks(random)");

        maks = (int) (maks * Math.random());
        min = (int) (min * Math.random());

        System.out.println("min " + min + " maks " + maks);
        do{
            liczbaDana=podajeliczby.nextInt();
        }while (liczbaDana<=min || liczbaDana>=maks);


        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie17() {
        Scanner podajeliczby = new Scanner(System.in);
        boolean punktA = false;
        boolean punktB = false;
        boolean punktC = false;
        boolean punktD = false;

        int ktoryTys = 0;
        int btys=1000;
        int cKolumn=-1;

        int drozmiara=1;
        int drozmiarb=1;
        int dkolumn=-1;
        for (int i = -1; i >=-1001; i--) {      //ta jedna pętla wykonuje 4 podpunkty a,b,c,d po zakończeniu poleceń każdego punktu jest on zamieniany na true
                                                //ignorowany w kolejnych wykonaniach petli, a licznik i jest resetowany dla kolejnego punktu
            if (i>=-1000 && i<=-200 && punktA==false){
                System.out.println(i);
            }else if (i==-1001 && punktA==false){
                i=0;
                punktA=true;
                System.out.println("\nKoniec A ");


            }else if (punktA==true && punktB==false && i>=-1000 && ktoryTys<99){
                System.out.print(btys + " ");
                btys++;
            }else if (punktA==true && punktB==false && i==-1001 && ktoryTys<100){
                System.out.println("");
                ktoryTys++;
                i=0;
            }else if (punktA==true && punktB==false && i==-1001 && ktoryTys==100){
                System.out.println("\n Koniec B ");
                i=0;
                punktB = true;


            }else if (punktB==true && punktC==false && i>=-10){
                while (cKolumn>=-5){
                    System.out.print(i*cKolumn + " ");
                    cKolumn--;
                }
                System.out.println("");
                cKolumn=-1;
            }else if (punktB==true && punktC==false && i==-11){
                i=2;
                punktC=true;
                System.out.println("\n Koniec C ");


            }else if(punktC==true && punktD==false && i == 1){
                System.out.println("Podaj ilość wierszy (>0) :");
                drozmiara = podajeliczby.nextInt();
                System.out.println("Podaj ilość kolumn (>0) :");
                drozmiarb = podajeliczby.nextInt();
                i=0;
            }else if (punktC==true && punktD==false && i>=-drozmiara){
                while (dkolumn>=-drozmiarb){
                    System.out.print(dkolumn*i + " ");
                    dkolumn--;
                }
                System.out.println("");
                dkolumn=-1;
            }else if (punktC==true && punktD==false && i<-drozmiara){
                punktD = true;
                System.out.println("\n Koniec D ");
                break;
            }
        }

        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie16() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj tekst zmieszany z cyframi a wyszukam te cyfry i zsumuje je ");
        System.out.println("Lub wpisz 0 by zakończyć: ");

        String tekstDany = podajeliczby.nextLine();
        char[] cyfry = {'0','1','2','3','4','5','6','7','8','9'};
        int[] cyfrydododania = {0,1,2,3,4,5,6,7,8,9};

        if (tekstDany !="0"){
            int suma = 0;

            for (int i = 0; i < tekstDany.length(); i++) {
                for (int j = 0; j < cyfry.length; j++) {
                    if (tekstDany.charAt(i) == cyfry[j]){
                        suma += cyfrydododania[j];
                    }
                }
            }

            System.out.println("\nTwój tekst to: " + tekstDany);
            System.out.println("Suma cyfr z tego tekstu to: " + suma);
        }



        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie15() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Wpisz tekst a sprawdzę czy jest palindromem: ");
        System.out.println("Lub wpisz 0 by zakończyć: ");

        String tekstDany = podajeliczby.nextLine();

        if (tekstDany !="0"){
            char[] palindrom = tekstDany.toCharArray();
            char przenoszony;

            for (int i = 0; i < tekstDany.length()/2; i++) {
                przenoszony = palindrom[i];
                palindrom[i] = palindrom[palindrom.length-i-1];
                palindrom[palindrom.length-i-1] = przenoszony;
            }

            System.out.println("\nTwój tekst to: " + tekstDany);
            System.out.print("Twój Palindrom to: ");
            for (int i = 0; i < tekstDany.length(); i++) {
                System.out.print(palindrom[i]);
            }

            System.out.println("\n\n\n\nTwój specjalny zapis palindromu jako hasło to: " + palindrom.toString());
        }

        System.out.println(" Koniec Programu \n");
    }

    private static void zadanie14() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj Liczbę N a następnie wyświetlę ci tabliczkę mnożenia w której zaznaczone będą");
        System.out.println("te liczby które w parze są względnie pierwsze (zaznaczone +) a pozostałe będą (-) ");
        System.out.println("czyli Pary Względnie Pierwsze są + a te nie są -");
        System.out.println("Albo wpisz -13 by zakończyć pracę :");
        int liczbaN = podajeliczby.nextInt();

        boolean koniec = false;

        while (liczbaN > 50 || liczbaN < 0) {
            System.out.println("Try again: ");
            liczbaN = podajeliczby.nextInt();
            if (liczbaN == -13) {
                koniec = true;
                break;
            }
        }

        boolean tablica[][] = new boolean[liczbaN+1][liczbaN+1];       //ta tablica zawiera odpowiedzi czy liczby i+1 * j+1 są liczbami względnie pierwszymi
        //nww - najmniejsza wspólna wielokrotność                  //to znaczy czy ich największym wspólnym dzielnikiem jest 1
        //nwd - największy wspólny dzielnik                        //para liczb a i b jest względnie pierwszych wtedy gdy: ich nww = a*b
                                                                    //również prawdziwe tylko dla pary względnie pierwszej a i b jest że://ax + by = 1
                                                                    // Para liczb Pierwszych: nwd = 1
        //DO SPRAWDZANIA TABLICY - nwd=1                            //                        nww = a*b
                                                                    //                        ax + by = 1

        // Wykonanie szukania par liczb pierwszych poprzez Algorytm Euklidesa
        // Algorytm Euklidesa wyznacza nwd dwóch liczb
        // więc jeśli sprawdzi że nwd = 1 to true a w przeciwnym wypadku false

        if (koniec == false) {
            char[] alfabetoWyliczanie = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','w','z','x','y','v','q','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','W','Z','X','Y','V','Q'};
            int aspr = 0;
            int bspr = 0;

            for (int a = 0; a < liczbaN+1; a++) {
                for (int b = 0; b < liczbaN+1; b++) {
                    if (a != 0 && b != 0) {
                        aspr = a;
                        bspr = b;
                        while (true){
                            if (aspr>bspr){
                               aspr = aspr-bspr;
                            }else if(aspr<bspr){
                                bspr = bspr - aspr;
                            }else if (aspr==1){
                                tablica[a][b] = true;
                                break;
                            }else if (aspr!=1){
                                tablica[a][b] = false;
                                break;
                            }
                            }
                        }else tablica[a][b] = false;     //nie będzie wyświetlać tej linii o indeksach 0 0 tak czy siak
                }

            }

            System.out.println("Wypisywanie tablicy: \n");

            for (int a = 0; a < liczbaN+1; a++) {
                if (a != 0) {
                    for (int b = 0; b < liczbaN+1; b++) {
                        if (b != 0) {
                           if (tablica[a][b]){
                               if (a<10 && b==1) {
                                   System.out.print(" ");
                               }
                               System.out.print("+ ");
                               if (b>=10) {
                                   System.out.print(" ");
                               }
                           }else {
                               System.out.print("- ");
                               if (b>=10){
                                   System.out.print(" ");
                               }
                           }
                        } else {
                            System.out.print(a + " ");
                        }
                    }
                }else {
                    for (int b = 0; b < liczbaN+1; b++){
                        System.out.print(b + " ");
                    }
                }

                System.out.println(" ");
            }
        }

        System.out.println("\n Koniec Programu \n");
    }

    private static void zadanie13() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj liczbę 'N' (max 50) a ja wypiszę tabliczkę mnożenia rozmiarów NxN : ");
        int liczbaN = podajeliczby.nextInt();

        while (liczbaN>50 || liczbaN<0){
            System.out.println("Try again: ");
            liczbaN = podajeliczby.nextInt();
        }


        if (liczbaN==0){
            System.out.println("ROZMIAR 0x0 to brak tabliczki mnożenia");
        }
        else if(liczbaN>0){
            for (int i = 0; i <= liczbaN+1; i++) {  //i = wiersze
                if(i == 0 || i == liczbaN+1){
                    for (int j = 0; j <= (liczbaN*5)+1; j++) {
                        System.out.print("-");
                    }
                } else {
                    for (int j = 0; j <= liczbaN+1; j++) {  //j = kolumny
                        if (j == 0 || j == liczbaN+1){
                            System.out.print("|");
                        }else {
                            System.out.print(i*j);
                            for (int k = 4; k>0 ; k--) {
                                if ((i*j) < pow((double) 10, (double) k)){
                                    System.out.print(" ");
                                }
                            }
                        }
                    }
                }
                System.out.println(" ");
            }

        }


        System.out.println("\nKoniec Programu");
    }

    private static void zadanie12() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą a ja sprawdzę czy jest liczbą pierwszą: ");
        int liczbaN = podajeliczby.nextInt();
        int iloscdziel = 0;
        boolean pierwsza = true;

        if(liczbaN == 0){
            System.out.println("Liczba " + liczbaN + " Jest liczbą pierwszą bo to 0");
        }
        else if(liczbaN>0) {
            for (int i = 2; i < liczbaN; i++) {
                if (liczbaN % i == 0) {
                    pierwsza = false;
                }
            }
        }

        if (pierwsza == true){
            System.out.println("Liczba " + liczbaN + " jest liczbą pierwszą");
        }else System.out.println("Liczba " + liczbaN + " NIE jest liczbą pierwszą... NIE JEST");

        System.out.println("Koniec programu");
    }

    private static void zadanie11() {
        Scanner podajeliczby = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą a ja podam jej dzielniki, lub wpisz 0 by zakończyć: ");
        int liczbaN = podajeliczby.nextInt();
        int iloscdziel = 0;

        if (liczbaN == 0){
        }else if (liczbaN>0){
            for (int i = 1; i <= liczbaN; i++) {
              if (liczbaN%i == 0 && i==liczbaN)  {
                 System.out.print("oraz " + i + ".");
                 iloscdziel++;
              }else if(liczbaN%i == 0 && i==1){
                 System.out.print("Dzielniki " + liczbaN + " to: " + i + ", ");
                  iloscdziel++;
              }else if(liczbaN%i == 0) {
                 System.out.print(i + ", ");
                  iloscdziel++;
              }
            }
        }else {
            for (int i = -1; i >= liczbaN; i--) {
                if (liczbaN%i == 0 && i==liczbaN)  {
                    System.out.print("oraz " + i + ".");
                    iloscdziel++;
                }else if(liczbaN%i == 0 && i==1){
                    System.out.print("Dzielniki " + liczbaN + " to: " + i + ", ");
                    iloscdziel++;
                }else if(liczbaN%i == 0) {
                    System.out.print(i + ", ");
                    iloscdziel++;
                }
            }
        }
        System.out.println("\nTa liczba ma: " + iloscdziel + " dzielników");

        System.out.println("\nKoniec Programu");
    }

    private static void zadanie10() {
        Scanner podajeliczby = new Scanner(System.in);
        int wysokoscChoinki = -1;
        int szerokoscChoinki = 1;

        System.out.println("Podaj wysokość choinki, musi być > 0, lub wpisz -13 to bez choinki koniec");
        while (wysokoscChoinki <= 0){
            wysokoscChoinki = podajeliczby.nextInt();
            if (wysokoscChoinki == -13){
                break;
            }
        }

                        //choinka
        if (wysokoscChoinki > 0){
            for (int i = 1; i <= wysokoscChoinki; i++) {
                for (int j = 1; j <= wysokoscChoinki-i; j++) {
                    System.out.print(" ");
                }

                for (int j = 1; j <= szerokoscChoinki; j++) {
                    System.out.print("*");
                }
                System.out.println("");
                szerokoscChoinki +=2;
            }

            for (int i = 0; i < wysokoscChoinki+1 - (wysokoscChoinki/2); i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < (szerokoscChoinki/2)-2; i++) {
                if (wysokoscChoinki>6 || wysokoscChoinki == 3 || wysokoscChoinki == 5) {
                    System.out.print("-");
                }
            }
        }
        System.out.println("szerokość / wysokość = " + (double) szerokoscChoinki/wysokoscChoinki);
        System.out.println("wysokość / szerokość = " + (double) wysokoscChoinki/szerokoscChoinki);
        System.out.println("\n Koniec Choinki \n");
                        //choinka

                        //choinka się przewraca
        szerokoscChoinki = 1;
        for (int i = wysokoscChoinki; i > 0; i--) {
            for (int j = wysokoscChoinki; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = szerokoscChoinki; j > 0; j--) {
                System.out.print("*");
            }
                System.out.println("");
                szerokoscChoinki +=2;
            }

        for (int i = 0; i < wysokoscChoinki+1 - (wysokoscChoinki/2); i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < (szerokoscChoinki/2)-2; i++) {
            if (wysokoscChoinki>6 || wysokoscChoinki == 3 || wysokoscChoinki == 5) {
                System.out.print("-");
            }
        }
        System.out.println("\n Uwaga.. leci... \n");
                        //choinka się przewraca

                        //choinka rąbana na drewno
        int nieparzyste = -1;
        if (wysokoscChoinki % 2 != 0){
            nieparzyste++;
        }
        szerokoscChoinki = 1;
        for (int i = wysokoscChoinki; i > 0; i--) {
            for (int j = 1; j < i*0.5*i; j++) {
                System.out.print(" ");
            }

            for (int j = szerokoscChoinki; j > wysokoscChoinki/2-nieparzyste; j--) {
                System.out.print("*");
            }
            System.out.println("");
            szerokoscChoinki +=2;
        }

        for (int i = 0; i < wysokoscChoinki+1 - (wysokoscChoinki/2); i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < (szerokoscChoinki/2)-2; i++) {
            if (wysokoscChoinki>6 || wysokoscChoinki == 3 || wysokoscChoinki == 5) {
                System.out.print("-");
            }
        }
        System.out.println("\n Czapeczka \n");

    }

    private static void zadanie9() {
        Scanner podajeliczby = new Scanner(System.in);
        int zgadywanaLiczba = -1;

        int liczbaProb = 0;
        int wylosowanaLiczba = (int) (Math.random() * 100);
        //System.out.println(wylosowanaLiczba);     //cheating pokazuje jaką liczbę wylosował

        System.out.println("Komputer wylosował liczbę z zakresu od 1 do 100, zgadnij jaka to liczba? ");
        System.out.println("lub wypisz 0 by się poddać");

        while (true){
            zgadywanaLiczba = podajeliczby.nextInt();
            liczbaProb++;

            if (zgadywanaLiczba > wylosowanaLiczba){
                System.out.println("Za wysoka zgaduj dalej");
                if (zgadywanaLiczba - wylosowanaLiczba <= 13){
                    System.out.println("Jesteś całkiem blisko ale jednak za wysoko.. próbuj dalej");
                }

            }else if(zgadywanaLiczba < wylosowanaLiczba){
                System.out.println("Za niska zgaduj dalej");
                if (wylosowanaLiczba - zgadywanaLiczba <= 13){
                    System.out.println("Jesteś całkiem blisko ale jednak za nisko.. próbuj dalej");
                }

                if (zgadywanaLiczba == 0){
                    System.out.println("Może innym razem zgadniesz...");
                    System.out.println("\n Próbowałeś " + liczbaProb + " razy");
                    break;
                }

            }else if (zgadywanaLiczba == wylosowanaLiczba){
                System.out.println("Brawo zgadłeś, to była " + zgadywanaLiczba);
                System.out.println("\n Próbowałeś " + liczbaProb + " razy, ale trafiłeś");
                break;
            }

        }


    }

    private static void zadanie8() {    //wersja bez tablicy
        Scanner podajeliczby = new Scanner(System.in);
        int ileLiczbPodal = 0;

        int startowaLiczba = 0;
        int danaLiczba;
        int maksymalnaLiczba = 1;
        int minimalnaLiczba = -1;

        System.out.println("Z podanych teraz liczb funkcja wypisze największą, najmniejszą oraz ich sumę i średnią. Aby zakonczyć podawania wpisz 0");
        while(true) { //wczytuje liczby dopóki pojawi się 0
            if(ileLiczbPodal >1){
                danaLiczba = podajeliczby.nextInt();
                if(danaLiczba == 0){
                    break;
                }
                maksymalnaLiczba = max(danaLiczba,maksymalnaLiczba);
                minimalnaLiczba = min(danaLiczba,minimalnaLiczba);
            }else if(ileLiczbPodal == 1){
                danaLiczba = podajeliczby.nextInt();
                if(danaLiczba == 0){
                    maksymalnaLiczba = startowaLiczba;
                    minimalnaLiczba = startowaLiczba;
                    break;
                }
                maksymalnaLiczba = max(danaLiczba, startowaLiczba);
                minimalnaLiczba = min(danaLiczba, startowaLiczba);
            }else{
                startowaLiczba = podajeliczby.nextInt();
                if(startowaLiczba == 0){
                    break;
                }
            }
            ileLiczbPodal++;
        }

        //odpowiedz na zadanie 8:
        System.out.println("Minimalna liczba = " + minimalnaLiczba);
        System.out.println("Maksymalna liczba = " + maksymalnaLiczba);

        int suma = minimalnaLiczba + maksymalnaLiczba;
        System.out.println("Ich suma wynosi: " + suma);

        float srednia = (float) (minimalnaLiczba + maksymalnaLiczba)/2;
        System.out.println("średnia arytmetyczna największej i najmniejszej wynosi: " + srednia);
        System.out.println("\n");   //koniec odpowiedz zadanie8

        System.out.println("łącznie podałeś " + ileLiczbPodal + " liczb");
    }

    private static void zadanie7() {
        System.out.println("Podaj ilość liczb N, które będziesz obliczał");
        Scanner podajeliczby = new Scanner(System.in);
        int liczbaN = podajeliczby.nextInt();

       while (liczbaN < 0) { //just to get rid of exception when N is 0
            System.out.println("ERROR Liczba N musi być większa od 0");
            liczbaN = podajeliczby.nextInt();
        }

        System.out.println(" ");
        int kolejneliczby[] = new int[liczbaN]; //podanie wszystkich liczb
        for (int i = 0; i < liczbaN; i++) {
            kolejneliczby[i] = podajeliczby.nextInt();
        }

        int minimal;
        int maximal;

        for (int i = 0; i < kolejneliczby.length; i++) {    //posortowanie podanych liczb
            for (int j = 0; j < kolejneliczby.length-1; j++) {
                minimal = min(kolejneliczby[j],kolejneliczby[j+1]);
                maximal = max(kolejneliczby[j],kolejneliczby[j+1]);
                kolejneliczby[j] = minimal;
                kolejneliczby[j+1] = maximal;
            }
        }

        //odpowiedz na zadanie 7:
        System.out.println("Minimalna liczba = " + kolejneliczby[0]);
        System.out.println("Maksymalna liczba = " + kolejneliczby[liczbaN-1]);

        int suma = kolejneliczby[0] + kolejneliczby[liczbaN-1];
        System.out.println("Ich suma wynosi: " + suma);

        float srednia = (float) (kolejneliczby[liczbaN-1] + kolejneliczby[0])/2;
        System.out.println("średnia arytmetyczna największej i najmniejszej wynosi: " + srednia);
        System.out.println("\n");   //koniec odpowiedz zadanie7

        //dla sprawdzenia czy posortowane wyświetla tablicę
        for (int i = 0; i < kolejneliczby.length; i++) {
            System.out.print("poz" + i + ": " + kolejneliczby[i] + "   ");
        }

    }

    private static void zadanie6() {
        System.out.println("Podaj liczbę X, a zwrócę ci wszystkie potęgi dwójki od 0rowej do ostatniej mniejszej od X");
        Scanner podajeliczby = new Scanner(System.in);
        int liczbaX = podajeliczby.nextInt();
        final int wykladnik = 2;
        int maxPoteg = 0;

        System.out.println("Kolejne potęgi wykładnika (" + wykladnik + ") do ostatniej potęgi przed liczbą " + liczbaX);
        while( pow(wykladnik,maxPoteg) <= liczbaX) {
            System.out.print((int) pow(wykladnik,maxPoteg) + " ");
            maxPoteg +=1;
        }
        System.out.println("\nW powyższym ciągu najwyższa potęga to: " + (maxPoteg-1) + " potęga");
        System.out.println("\n");

        maxPoteg=0;

        System.out.println("Kolejne potęgi wykladnika (" + wykladnik + ") do ostatniej potęgi przed liczbą " + liczbaX);
        for (int i = 1; i <= liczbaX; i*=wykladnik) {
            System.out.print(i + " ");
            maxPoteg++;
        }
        System.out.println("\nW powyższym ciągu najwyższa potęga to: " + (maxPoteg-1) + " potęga");

        System.out.println("\n \n Koniec Programu \n");
    }

    private static void zadanie5() {
        System.out.println("Podaj dwie liczby, A oraz B gdzie B>A, a podam ci sumą ciągu liczb pomiędzy nimi występujących");
        Scanner podajeliczby = new Scanner(System.in);
        int liczbaA = podajeliczby.nextInt();
        int liczbaB = podajeliczby.nextInt();

        while (liczbaA > liczbaB) {
            System.out.println("ERROR Liczba A musi być mniejsza od liczby B");
            liczbaA = podajeliczby.nextInt();
            liczbaB = podajeliczby.nextInt();
        }
        int suma = 0;
        int suma2 = 0;

        for (int i = liczbaA; i <= liczbaB; i++) {
            suma += i;
        }
        System.out.println("Sumą ciągu liczb od A do B (włącznie) wynosi: " + suma + "\n");


        while(liczbaA<=liczbaB){
            suma2 += liczbaA;
            liczbaA++;
        }
        System.out.println("Sumą ciągu liczb od A do B (włącznie) wynosi: " + suma2 + "\n");

    }

    private static void zadanie4() {
        System.out.println("Podaj dwie liczby, odpowiednio początek i koniec zakresu");
        Scanner podajeliczby = new Scanner(System.in);
        int poczatekZakresu = podajeliczby.nextInt();
        int koniecZakresu = podajeliczby.nextInt();

        while (poczatekZakresu > koniecZakresu) {
            System.out.println("ERROR Początek zakresu musi być mniejszy od końca, wpisz te dwie dane jeszcze raz");
            poczatekZakresu = podajeliczby.nextInt();
            koniecZakresu = podajeliczby.nextInt();
        }

        while (poczatekZakresu < 0 || koniecZakresu < 0 ) {     //żeby pozbyć się błędu z negatywnymi indexami dla tablic intów
            System.out.println("ERROR Program działa tylko dla liczb dodatnich Początek i Koniec zakresu muszą być >0");
            poczatekZakresu = podajeliczby.nextInt();
            koniecZakresu = podajeliczby.nextInt();
        }

        //od razu przejdę do popunktu b jako że zawiera on a tylko z wieloma dzielnikami
        System.out.println("Podaj ile chcesz mieć dzielników do wypisania liczb z twojego zakresu przez dzielniki podzielnych: ");
        int ileDzielnik = podajeliczby.nextInt();
        while (ileDzielnik<0){
            System.out.println("Nie moze byc minusowa ilosc dzielników");
            ileDzielnik = podajeliczby.nextInt();
        }


        int[] wynikPodzielne = new int[koniecZakresu + 1];
        for (int i = 0; i < wynikPodzielne.length; i++) {
            wynikPodzielne[i] = 0;
        }

        int dzielnik[] = new int[ileDzielnik];
        System.out.println("Teraz po kolei podaj wszystkie te dzielniki: ");
        for (int i = 0; i < ileDzielnik; i++) {
            dzielnik[i] = podajeliczby.nextInt();
        }

        for (int i = poczatekZakresu; i <= koniecZakresu; i++) {
            for (int j = 0; j < ileDzielnik; j++) {
                if (i % dzielnik[j] == 0) {
                    wynikPodzielne[i] = i;
                } else {
                    wynikPodzielne[i] = 0;
                    break;
                }
            }
        }


        for (int i = 0; i < wynikPodzielne.length; i++) {
            if (wynikPodzielne[i] != 0) {
                System.out.println(i);
            }
        }
    }

    private static void zadanie3() {
        Scanner podajeliczby = new Scanner(System.in);
        int liczba = 1;
        System.out.println("Podaj nową liczbę by powtorzyć, lub podaj liczbę <0 by zakończyć");
        while (liczba >= 0)      {
            System.out.println("Hello World " + liczba);
            liczba = podajeliczby.nextInt();
        }
        System.out.println("Koniec programu bo liczba jest <= 0");
    }

    private static void zadanie2() {
        System.out.println("Wpisz ilość powtórzeń ");
        Scanner powtorzenia = new Scanner(System.in);
        int ilosc = powtorzenia.nextInt();

        for (int i = 1; i <= ilosc; i++) {
            System.out.println("Hello World");
        }

        System.out.println("\n");
        int j = 1;
        do{
            System.out.println("Hello World");
            j++;
        }while (j <= ilosc);


    }

    private static void zadanie1switch() {
        System.out.println("Wpisz liczbę odnoszącą się do podpunktu (0 = a, 1 = b, 2 = c....): ");
        Scanner podajPunkt = new Scanner(System.in);
        int podpunkt = podajPunkt.nextInt();

        System.out.println(" ");
        switch (podpunkt){      //przykład zrobienia tego z podpunktami lecz nie tak mieliśmy to zrobić więc powyżej jest drugi sposób
            case 0: //a
                for (int i = 0; i <= 100; i++) {
                    System.out.println(i);
                }
                break;
            case 1: //b
                for (int i = 1000; i <= 1020; i++) {
                    System.out.print(i + ", ");
                }
                break;
            case 2: //c
                for (int i = -30; i <= 1000; i +=5) {
                    System.out.println(i);
                }
                break;
            case 3: //d
                for (int i = 3; i <= 100; i +=3) {
                    System.out.println(i);
                }
                break;
            case 4: //e
                for (int i = 30; i <= 300; i++) {
                    if(i % 3 == 0 && i % 5 == 0){
                        System.out.println(i);
                    }
                }
                break;
            case 5: //f
                for (int i = -300; i <= 300; i +=2) {
                    System.out.print(i + ";");
                }
                break;
            case 6: //g
                for (int i = -100; i <= 100; i+=2) {
                    System.out.print(i + ";");
                }
                break;
            case 7: //h     //litery od a do z sprawdzić
                for (int i = 97; i <= 122; i++) {
                    System.out.println((char)i);
                }
                break;
            case 8: //i
                for (int i = 'A'; i <= 'Z'; i++) {      //to samo co od 65 do 90 //update 26 10 2019
                    System.out.println((char)i);
                }
                break;
            case 9: //j
                for (int i = 65; i <= 90; i+=2) {
                    System.out.println((char)i);
                }
                break;
            case 10: //k
                for (int i = 98; i <= 122; i++) {
                    if(i % 5 == 0){
                        System.out.println((char)i);
                    }
                }
                break;
            case 11: //l
                for (int i = 0; i <= 100; i++) {
                    System.out.println(i + ".   " + "Hello World");
                }
                break;
            default:
                System.out.println("\n");
        }

    }





}
