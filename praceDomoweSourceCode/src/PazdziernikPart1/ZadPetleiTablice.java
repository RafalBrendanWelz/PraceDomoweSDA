package PazdziernikPart1;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.*;
import java.util.Scanner;

public class ZadPetleiTablice {

    public static void main(String[] args) throws InterruptedException {
        //zadanie1();
        //zadanie2();
        //zadanie3();
        //zadanie4();
        //zadanie5();
        //zadanie6();
        //zadanie7();
        //zadanie8();
        //zadanie9();
        //zadanie10();
        //zadanie11();
        //zadanie12();
        //zadanie13();
        //zadanie14();
        //zadanie15();
        //zadanie16 gra na oddzielnej klasie
        //zadanie17();



    }

    private static void zadanie17() {
        System.out.println("Podaj Pesel a ja sprawdzę jego poprawność: \n");
        Scanner podajLiczby = new Scanner(System.in);

        String pesel = "";
        boolean koniec = false;

        int[] cyfryPeselu = new int[] {0,0,0,0,0,0,0,0,0,0,0};  //tip 26.10.2019 dobrą praktyką jest dodawać new typ[] nawet jeśli inicjalizujesz z wymienianiem elementów
        char[] znakiPeselu;
        int sumaCyfrPesel = 0;

        while (!podajLiczby.hasNextLong()){
            System.out.println(pesel + " PESEL Niepoprawny. Pesel musi być liczbą ");
            podajLiczby.next();
        }
        pesel = podajLiczby.next();

        if (pesel.length()>11){
            System.out.println(pesel + " PESEL Niepoprawny. Pesel musi mieć 11-cyfr ");
            koniec = true;
        }

        if (!koniec){
            znakiPeselu = pesel.toCharArray();

            for (int i = 0; i < 4; i++) {
                if (i>=2){
                    cyfryPeselu[i]= Character.getNumericValue(znakiPeselu[i])*(i+(i+3));
                }else {
                    cyfryPeselu[i]= Character.getNumericValue(znakiPeselu[i])*(i+(i+1));
                }
            }
            for (int i = 0; i < 4; i++) {
                if (i>=2){
                    cyfryPeselu[i+4]= Character.getNumericValue(znakiPeselu[i+4])*(i+(i+3));
                }else {
                    cyfryPeselu[i+4]= Character.getNumericValue(znakiPeselu[i+4])*(i+(i+1));
                }
            }

            cyfryPeselu[8]= Character.getNumericValue(znakiPeselu[8]);
            cyfryPeselu[9]= Character.getNumericValue(znakiPeselu[9])*3;
            cyfryPeselu[10]= Character.getNumericValue(znakiPeselu[10]);

            for (int i = 0; i < 11; i++) {
                sumaCyfrPesel += cyfryPeselu[i];
            }

            if (sumaCyfrPesel%10==0){
                System.out.println(sumaCyfrPesel + " PESEL poprawny: Gratulacje");
            }
            else {
                System.out.println(sumaCyfrPesel + " PESEL niepoprawny: Suma cyfr peselu pomnożonych przez kolejne iloczyny według *(1.3.7.9.1.3.7.9.1.3.1) musi być podzielna przez 10");
            }

        }


        System.out.println("\n \n   Koniec Programu \n ");
    }

    private static void zadanie15() {
        System.out.println("Podaj dwie liczby a obliczę ich NWD \n");
        Scanner podajLiczby = new Scanner(System.in);

        int liczbaA = 5;
        int liczbaB = 5;
        int przedzielA;
        int przedzielB;


        int[] dzielnikiA;
        int wielkoscA = 1;
        int[] dzielnikiB;
        int wielkoscB = 1;

        int ktory = 0;
        int NDW = 0;
        int sprawdzana = 0;

        System.out.println("Podaj pierwszą Liczbę: "); //get A
        while (!podajLiczby.hasNextInt()){
            System.out.println("To nie jest poprawna liczba ");
            podajLiczby.next();
        }
        liczbaA = podajLiczby.nextInt();

        System.out.println("Podaj drugą Liczbę: ");     //get B
        while (!podajLiczby.hasNextInt()){
            System.out.println("To nie jest poprawna liczba ");
            podajLiczby.next();
        }
        liczbaB = podajLiczby.nextInt();

        przedzielA=liczbaA; //do wykonywania dzielenia na A i B bez pomniejszania ich by na koniec móc je wypisać
        przedzielB=liczbaB; //do wykonywania dzielenia na A i B bez pomniejszania ich by na koniec móc je wypisać


        for (int i = 0; pow(2,i)<liczbaA; i++) {    //max dzielników od A
                wielkoscA++;
        }
        System.out.println(wielkoscA);
        dzielnikiA = new int[wielkoscA];    //jaka duża tablica na dzieln

        for (int i = 0; pow(2,i)<liczbaB; i++) {  //max dzielników od B
            wielkoscB++;
        }
        System.out.println(wielkoscB);
        dzielnikiB = new int[wielkoscB];    //jaka duża tablica na dzieln



        System.out.println("Kolejne od min. dzielniki liczby " + liczbaA);
        for (int i = 2; i <= przedzielA; i++) {    //dodawaj kolejne dzielniki od najmniejszych dla a
            if (przedzielA % i == 0) {
                dzielnikiA[ktory]=i;
                System.out.println(i);
                przedzielA = przedzielA / i;
                ktory++;
                i=1;
            }
        }

        ktory = 0;
        System.out.println("Kolejne od min. dzielniki liczby " + liczbaB);
        for (int i = 2; i <= przedzielB; i++) {    //dodawaj kolejne dzielniki od najmniejszych dla a
            if (przedzielB % i == 0) {
                dzielnikiB[ktory]=i;
                System.out.println(i);
                przedzielB = przedzielB / i;
                ktory++;
                i=1;
            }
        }

        //System.out.println("teraz wyszukam NWD"); //test only
        for (int i = 0; i < dzielnikiA.length; i++) {
            for (int j = 0; j < dzielnikiB.length; j++) {
                if (dzielnikiA[i]==dzielnikiB[j] && dzielnikiA[i]!=0){
                    if (NDW==0){
                        NDW = dzielnikiA[i];
                        //System.out.println(NDW);  //test only
                        dzielnikiA[i]=0;
                        dzielnikiB[j]=0;
                        break;
                    }else {
                        sprawdzana = dzielnikiA[i];
                        NDW = NDW * sprawdzana;
                        //System.out.println(NDW);  //test only
                        dzielnikiA[i]=0;
                        dzielnikiB[j]=0;
                        break;
                    }
                }
            }
        }
        System.out.println("Największy Wspólny Dzielnik liczb: " + liczbaA + " " + liczbaB + " Wynosi = " + NDW);

        System.out.println("\n \n    Koniec Programu \n ");
    }

    private static void zadanie14() {
        System.out.println("Wpisz dowolny tekst by rozpocząć tankowanie ");
        Scanner podaj = new Scanner(System.in);
        double iloscTankowania = 0;
        float zaplata = 0;

        final int cena = 5;
        final String walutaCeny = " zł";
        final String pojemnosc = " litr";
        float doTankuj = 0;

        float zakresMax = (float) 0.395;
        float zakresMin = (float) 0.010;
        String decyzja = "";

        decyzja = podaj.nextLine();
        for (int i = 1; true; i++) {
            System.out.println("Podaj 't' by dotankować lub 'n' by przerwać " );
            decyzja = podaj.nextLine();

            if (decyzja.equals("t")){

                doTankuj = (float) (Math.random());
                if (doTankuj>zakresMax){
                    doTankuj=zakresMax;
                }else if (doTankuj<zakresMin){
                    doTankuj=zakresMin;
                }
                iloscTankowania +=doTankuj;
                zaplata = zaplata + (cena * doTankuj);

                System.out.print("Zatankowano: ");
                System.out.printf("%.3f" , iloscTankowania);
                System.out.print(" " + pojemnosc + "\n");

                System.out.print("Do zapłaty masz: ");
                System.out.printf("%.2f" , zaplata);
                System.out.print(" " + walutaCeny + "\n");

            }else if (decyzja.equals("n")){
                break;
            }

        }

        System.out.println("\n \n Zakończono Tankowanie");

        System.out.print("Zatankowano łącznie: ");
        System.out.printf("%.4f" , iloscTankowania);
        System.out.print(" " + pojemnosc + "\n");

        System.out.print("Do zapłaty masz: ");
        System.out.printf("%.2f" , zaplata);
        System.out.print(" " + walutaCeny + "\n");
    }

    private static void zadanie13() {
        System.out.println("Ten program rysuje ci trójkąty \n");
        Scanner podajLiczby = new Scanner(System.in);

        int rozmiarPion = 8;

        System.out.println("Taki oto:");
        for (int i = 0; i < rozmiarPion; i++) {
            for (int j = 1; j <= i+1; j++) {
                System.out.print("# ");
            }
            System.out.println("");
        }

        System.out.println("\n Oraz Taki");
        for (int i = 0; i < rozmiarPion; i++) {
            for (int j = 1; j <= rozmiarPion-i; j++) {
                System.out.print("# ");
            }
            System.out.println("");
        }

        System.out.println("\n Taki również");
        for (int i = 0; i < rozmiarPion; i++) {
            for (int j = 0; j < 2*i; j++) {
                System.out.print(" ");
            }
            for (int j = rozmiarPion-i; j >0; j--) {
                System.out.print("# ");
            }
            System.out.println("");
        }

        System.out.println("\n I na koniec taki");
        for (int i = 0; i < rozmiarPion; i++) {
            for (int j = i*2; j < (rozmiarPion-1)*2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j<=i; j++) {
                System.out.print("# ");
            }

            System.out.println("");
        }

        System.out.println("\n \n Albo owe 4 na raz");
        for (int i = 0; i < rozmiarPion; i++) {
            for (int j = 1; j <= i+1; j++) {    //A
                System.out.print("# ");
            }
            for (int j = rozmiarPion; j >= i; j--) {
                System.out.print(" ");
            }

            for (int j = rozmiarPion; j >= i; j--) {  //B
                System.out.print(" ");
            }
            for (int j = rozmiarPion; j >i; j--) {
                System.out.print("# ");
            }
            for (int j = i*2; j >0; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i*2; j++) {   //C
                System.out.print(" ");
            }
            for (int j = 0; j < rozmiarPion-i; j++) {
                System.out.print("# ");
            }

            for (int j = 0; j < (rozmiarPion-i)*2; j++) {   //D
                System.out.print(" ");
            }
            for (int j = i; j >=0; j--) {
                System.out.print("# ");
            }

            System.out.println("");     //next line
        }
        System.out.println("      (A)                (B)               (C)               (D)");

        System.out.println("\n \n   Koniec Programu \n ");
    }

    private static void zadanie12() {
        System.out.println("Podaj liczbę w zakresie od 1 do 20. A ja wyrysuję ci trójkąt prostokątny z liczb. \n");
        Scanner podajLiczby = new Scanner(System.in);

        char sprawdzany;
        int zakresMax = 20;
        int zakresMin = 1;
        int liczba = 5;

        int ktoraLiczb = 0;
        String dociagu = "0";

        for (int i = 1; i < 6; i++) {
            while (!podajLiczby.hasNextInt()){
                System.out.println("To nie jest liczba ");
                podajLiczby.next();
            }
            liczba = podajLiczby.nextInt();
            if (liczba>=1 && liczba<=20){
                break;
            }else {
                System.out.println("Liczba musi znajdować się w przedziale między 1 a 20 (włącznie)");
            }
        }

        if (liczba<1 || liczba>20){
            System.out.println("Dobra wystarczy tych prób twoja liczba jest 5");
            liczba=5;
        }

        for (int i = 0; i < liczba; i++) {
            for (int j = 1; j <= i+1; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }




        System.out.println("\n \n    Koniec Programu \n ");
    }

    private static void zadanie11() {
        System.out.println("Podaj, wpisz dwa zbiory liczbowe a wyświetlę ci zbiór wspólnych elementów 2 podanych zbiorów: \n");
        Scanner podajLiczby = new Scanner(System.in);
        String liczby1 = "";
        String liczby2 = "";

        char sprawdzany;
        int dlugoscCiagu = 0;
        int ktoraLiczb = 0;
        String dociagu = "0";


        System.out.println("Wprowadź PIERWSZY zbiór liczb podajająć kolejne liczby +[enter]. Podaj jakąkolwiek literę by zakończyć wprowadzanie.");
        for (int i = 0; podajLiczby.hasNextInt(); i++) {
            liczby1 += podajLiczby.nextInt() + ",";
            dlugoscCiagu++;
        }
        int[] zbiorA = new int[dlugoscCiagu];

        dlugoscCiagu=0;
        System.out.println("\n Wprowadź DRUGI zbiór liczb podajająć kolejne liczby +[enter]. Podaj jakąkolwiek literę by zakończyć wprowadzanie.");
        podajLiczby.next();
        for (int i = 0; podajLiczby.hasNextInt(); i++) {
            liczby2 += podajLiczby.nextInt() + ",";
            dlugoscCiagu++;
        }
        int[] zbiorB = new int[dlugoscCiagu];


        for (int i = 0; i < liczby1.length(); i++) { //wprowadz liczby z pierwszego podanego zbioru do tablicy "zbiorA"
            sprawdzany = liczby1.charAt(i);
            if (sprawdzany==',') {
                zbiorA[ktoraLiczb] = Integer.parseInt(dociagu);
                dociagu="";
                ktoraLiczb++;

            } else {
                dociagu+=sprawdzany;
            }

        }
        ktoraLiczb=0;
        dociagu="";

        for (int i = 0; i < liczby2.length(); i++) { //wprowadz liczby z drugiego podanego zbioru do tablicy "zbiorB"
            sprawdzany = liczby2.charAt(i);
            if (sprawdzany==',') {
                zbiorB[ktoraLiczb] = Integer.parseInt(dociagu);
                dociagu="";
                ktoraLiczb++;

            } else {
                dociagu+=sprawdzany;
            }

        }


        System.out.println("Twój zbiórA to: ");  //test wyświetlenie podanego ciagu liczbowego
        System.out.print("{");
        for (int i = 0; i < zbiorA.length; i++) {
            System.out.print(zbiorA[i] + " ");
        }
        System.out.print("} \n");

        System.out.println("Twój zbiórB to: ");  //test wyświetlenie podanego ciagu liczbowego
        System.out.print("{");
        for (int i = 0; i < zbiorB.length; i++) {
            System.out.print(zbiorB[i] + " ");
        }
        System.out.print("} \n");

        System.out.println("Zbiór elementów Wspólnych A i B to: ");  //ODPOWIEDZ zbiór elementów wspólnych
        System.out.print("{");
        for (int i = 0; i < zbiorA.length; i++) {

            for (int j = 0; j < zbiorB.length; j++) {
                if (zbiorA[i]==zbiorB[j]){
                    System.out.print(zbiorA[i] + " ");
                    break;
                }
            }

        }
        System.out.print("} \n");



        System.out.println("\n \n    Koniec Programu \n ");
    }

    private static void zadanie10() {
        System.out.println("Podaj ciąg liczb całkowitych odseparowanych przecinkiem (,) a wyświetle ci te liczby bez duplikatów ");
        Scanner podajLiczby = new Scanner(System.in);
        String tekstLiczb = "";

        char sprawdzany;
        int dlugoscCiagu = 1;
        int ktoraLiczb = 0;
        String dociagu = "0";
        String cyfry = "0123456789-";

        int sprawdzDuplik;

        tekstLiczb = podajLiczby.nextLine();

        for (int i = 0; i < tekstLiczb.length(); i++) { //ile jest tych liczb w linii tekstu
            sprawdzany = tekstLiczb.charAt(i);
            if (sprawdzany==',') {
                dlugoscCiagu++;
            }
        }
        int[] liczbyCalk = new int[dlugoscCiagu];       //deklaracja tablicy liczb całkowitych

        for (int i = 0; i < tekstLiczb.length(); i++) { //utworzenie ciągu liczbowego z podanej linii tekstu
            sprawdzany = tekstLiczb.charAt(i);

            if (sprawdzany==','){
                liczbyCalk[ktoraLiczb] = Integer.parseInt(dociagu);
                ktoraLiczb++;
                dociagu="";

            }else {
                for (int j = 0; j < cyfry.length(); j++) {
                    if (sprawdzany==cyfry.charAt(j)){
                        dociagu+=sprawdzany;
                        break;
                    }
                }
            }

            if (i==tekstLiczb.length()-1){
                liczbyCalk[dlugoscCiagu-1] = Integer.parseInt(dociagu);
            }


        }

        System.out.println("Twój ciąg liczbowy to: ");  //test wyświetlenie podanego ciagu liczbowego
        System.out.print("{");
        for (int i = 0; i < dlugoscCiagu; i++) {
            System.out.print(liczbyCalk[i] + " ");
        }
        System.out.print("} \n");

        System.out.println("Ciąg liczbowy wyświetlony bez duplikatów: ");  //wyswietlenie ciagu bez duplikatów ODPOWIEDŹ
        System.out.print("{");
        for (int i = 0; i < dlugoscCiagu; i++) {
            for (int j = dlugoscCiagu-1; j >= i; j--) {

                if (liczbyCalk[i] == liczbyCalk[j] && j!=i){
                    break;
                }else if (j==i){
                    System.out.print(liczbyCalk[i] + " ");
                }

            }
        }
        System.out.print("} \n");


        System.out.println("\n \n    Koniec Programu \n ");
    }

    private static void zadanie9() {
        System.out.println("Wypisuje wszystkie unikatowe liczby 3-cyfrowe stworzone tylko z cyfr 1,2,3,4: ");   //part1 wszystkie   //update -powtórki
        Scanner podajLiczby = new Scanner(System.in);

        System.out.println("\n Unikalne liczby 3-cyfrowe z 1,2,3,4: ");
        System.out.print("{");
        for (int i = 1; i < 5 ; i++) {

            for (int j = 1; j < 5; j++) {

                for (int k = 1; k < 5; k++) {
                    if (i!=j && i!=k && j!=k){      //update: żadna z CYFR nie może się powtarzać
                        System.out.print(i + "" + j + "" + k + " ");
                    }

                }
            }
        }
        System.out.print("} \n \n");



        System.out.println("Tu możesz stworzyć liczby 3-cyfrowe zbudowane z cyfr 1,2,3,4");   //part2 do tworzenia unikatowych liczb 3cyfr z 1,2,3,4
        int[] liczbyAllUnikat = new int[899];
        int cyfra1;
        int cyfra2;
        int cyfra3;

        System.out.println("Podaj cyfrę (1,2,3 lub 4) ");
        while (!podajLiczby.hasNextInt()){  //cyfra1
            System.out.println("To nie jest liczba");
            podajLiczby.next();
        }
        cyfra1=podajLiczby.nextInt();
        if (cyfra1<1){
            cyfra1=1;
        }else if (cyfra1>4){
            cyfra1=4;
        }

        System.out.println("Podaj cyfrę (1,2,3 lub 4) ");
        while (!podajLiczby.hasNextInt()){  //cyfra2
            System.out.println("To nie jest liczba");
            podajLiczby.next();
        }
        cyfra2=podajLiczby.nextInt();
        if (cyfra2<1){
            cyfra2=1;
        }else if (cyfra2>4){
            cyfra2=4;
        }

        System.out.println("Podaj cyfrę (1,2,3 lub 4) ");
        while (!podajLiczby.hasNextInt()){  //cyfra3
            System.out.println("To nie jest liczba");
            podajLiczby.next();
        }
        cyfra3=podajLiczby.nextInt();
        if (cyfra3<1){
            cyfra3=1;
        }else if (cyfra3>4){
            cyfra3=4;
        }

        System.out.println("Twoja unikatowa liczba zbudowana z 1,2,3,4 to: " + cyfra1 + "" + cyfra2 + "" + cyfra3);


        System.out.println("\n \n    Koniec Programu \n ");
    }

    private static void zadanie8() {
        System.out.println("Podaj ciąg liczb A posortuję je rosnąco oraz malejąco:   ");

        Scanner podajLiczby = new Scanner(System.in);
        String tekstLiczb = "";
        char sprawdzany;

        int dlugoscCiagu = 1;
        int ktoraLiczb = 0;
        String dociagu = "";

        String cyfry = "0123456789-";
        int minimal = 2147000000;
        int maksimal = -2147000000;

        System.out.println("Wpisz ciąg liczb w jednej linii poprzedzielane spacjami: \n");
        tekstLiczb=podajLiczby.nextLine();

        System.out.println("Koniec Ciągu: ");

        for (int i = 0; i <  tekstLiczb.length(); i++) {    //jak długi będzie ciąg
            sprawdzany = tekstLiczb.charAt(i);
            if (sprawdzany == ' '){
                dlugoscCiagu++;
            }
        }

        int[] ciagLiczb = new int[dlugoscCiagu+1];        //deklaracja jak długi jest ciąg od ilości spacji
        int[] ciagRosn = new int[dlugoscCiagu+1];         //deklaracja od razu pozostalych
        int[] ciagMalej = new int[dlugoscCiagu+1];        //odpowiedzi

        for (int i = 0; i < tekstLiczb.length(); i++) {     //rozdzielenie tekstu na ciag liczb
            sprawdzany = tekstLiczb.charAt(i);

            if (ktoraLiczb==dlugoscCiagu){
                ciagLiczb[ktoraLiczb] = Integer.parseInt(dociagu);
                break;
            }else   if (sprawdzany==' '){
                ciagLiczb[ktoraLiczb] = Integer.parseInt(dociagu);
                ktoraLiczb++;
                dociagu="0";

            }else{
                for (int j = 0; j < cyfry.length(); j++) {
                    if (sprawdzany == cyfry.charAt(j)){
                        dociagu += sprawdzany;
                        break;
                    }
                }
            }

        }   //powyzej tworzenie ciagu liczbowego

        System.out.println("Twój ciąg liczb to: "); //TEST SPRAWDZENIE CZY UTWORZYł się ciąg liczbowy
        System.out.print("{");
        for (int i = 0; i < dlugoscCiagu; i++) {
            if (i==dlugoscCiagu-1){
                System.out.print(ciagLiczb[i] + "}");
            }else {
                System.out.print(ciagLiczb[i] + " ");
            }
        }
        System.out.println("\n");

       /* for (int i = 0; i < dlugoscCiagu; i++) {    //SORTOWANIE CIAGU LICZBOWEGO
            for (int j = 0; j < dlugoscCiagu-2; j++) {
                if (j == 0) {
                    minimal = min(ciagLiczb[j], ciagLiczb[j+1]);
                    maksimal = max(ciagLiczb[j], ciagLiczb[j+1]);
                }else {
                    minimal = min(ciagLiczb[j], ciagLiczb[j+2]);
                    maksimal = max(ciagLiczb[j], ciagLiczb[j+2]);
                }

                ciagRosn[j] = minimal;
                ciagRosn[j+1] = maksimal;

                ciagMalej[j] = maksimal;
                ciagMalej[j+1] = minimal;

            }
        }*/

        for (int i = 0; i < dlugoscCiagu; i++) {
            ciagRosn[i]=ciagLiczb[i];
        }
        Arrays.sort(ciagRosn);
        for (int i = 0; i < dlugoscCiagu; i++) {
            ciagMalej[i] = ciagRosn[ciagRosn.length - i-1];
        }

        System.out.println("Twój ciąg liczb rosnąco to: "); //rosnaco
        System.out.print("{");
        for (int i = 0; i < dlugoscCiagu; i++) {
            if (i==dlugoscCiagu-1){
                System.out.print(ciagRosn[i] + "}");
            }else {
                System.out.print(ciagRosn[i] + " ");
            }
        }
        System.out.println("\n");

        System.out.println("Twój ciąg liczb malejący to: "); //malejaca
        System.out.print("{");
        for (int i = 0; i < dlugoscCiagu; i++) {
            if (i==dlugoscCiagu-1){
                System.out.print(ciagMalej[i] + "}");
            }else {
                System.out.print(ciagMalej[i] + " ");
            }
        }
        System.out.println("\n");

        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie7() {
        System.out.println("Wpisz dowolny tekst");
        System.out.println("A wypiszę ci ilość wystąpień liczb, znaków, spacji i liter: ");

        Scanner podajTekst = new Scanner(System.in);
        String tekst = "";
        int[] wystapienia = new int[4];     //ilości wystąpień gdzie 0-cyfry 1-litery 2-znaki 3-spacje
        char[] cyfry = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] litery = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        char[] znaki = {'+', '-', '*', '/', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '[', ']', '{', '}', ';', ':', '|', '.', '>', '<', '?', '`'};
        char spacje = ' ';
        // int minimal = 2147000000;
        // int maksimal = -2147000000;

        tekst = podajTekst.nextLine();
        char sprawdzany;

        System.out.println("Twój tekst to: ");
        System.out.println(" " + tekst + "\n");

        for (int i = 0; i < tekst.length(); i++) {          //liczenie wszystkich tych znaków poprzez dodawanie do wystąpień
            sprawdzany = tekst.charAt(i);
            if (tekst.charAt(i) == spacje) {
                wystapienia[3]++;
            } else {
                for (int j = 0; j < cyfry.length; j++) {       //wada lekki bałagan
                    if (sprawdzany == cyfry[j]) {
                        wystapienia[0]++;
                        break;

                    } else {
                        for (int k = 0; k < znaki.length; k++) {
                            if (sprawdzany == znaki[k]) {
                                wystapienia[2]++;
                                break;

                            } else {
                                for (int l = 0; l < litery.length; l++) {
                                    if (sprawdzany == litery[l]) {
                                        wystapienia[1]++;
                                        break;

                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        System.out.println("Ilość spacji w tekście wynosi: " + wystapienia[3]);
        System.out.println("Ilość znaków w tekście wynosi: " + wystapienia[2]/10);
        System.out.println("Ilość liter w tekście wynosi: " + wystapienia[1]/290);
        System.out.println("Ilość cyfer w tekście wynosi: " + wystapienia[0]);

        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie6() {
        System.out.println("Wpisz dowolny tekst");
        System.out.println("A wypiszę ci go od tyłu ");

        Scanner podajTekst = new Scanner(System.in);
        String tekst = "";
        String odwrotny = "";
        // int minimal = 2147000000;
        // int maksimal = -2147000000;

        tekst=podajTekst.nextLine();
        char[] zamiana = new char[tekst.length()];

        System.out.println("Twój tekst to: ");
        System.out.println(" " + tekst + "\n");
        System.out.println("Tekst Odwrotny do twojego to: ");

        for (int i = 0; i < tekst.length(); i++) {          //odwracanie tekstu poprzez pętle przestawiającą kolejne znaki w tekście na inne pozycje.
            zamiana[i] = tekst.charAt(tekst.length() - i - 1);
            if (i==0){
                System.out.print(" " + zamiana[i]);
            }else {
                System.out.print(zamiana[i]);
            }
        }
        System.out.print(" /. \n");

        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie5() {
        System.out.println("Podaj liczbę ");
        System.out.println("A wypiszę ci sumę cyfr w tej liczbie występujących ");

        Scanner podajLiczby = new Scanner(System.in);
        String liczba = "";
        int sumaCyfr = 0;
        String cyfry = "0123456789";
        // int minimal = 2147000000;
        // int maksimal = -2147000000;
        for (int i = 1; i <=1 ; i++) {          //Podawanie the liczba
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            liczba=podajLiczby.next();
        }
        System.out.println("Twoja Liczba " + liczba);   //The liczba

       /*String[] testSplitu = liczba.split("(?<=2)"); //Dzielenie tekstu według występującego znaku
        System.out.println(testSplitu[0]);*/

        System.out.println("Suma Cyfr: ");
        for (int i = 0; i < liczba.length(); i++) {
            if (i==liczba.length()-1){
                System.out.print(liczba.charAt(i) + " = ");
            }else {
                System.out.print(liczba.charAt(i) + " + ");
            }

            for (int j = 0; j < cyfry.length(); j++) {
                if (liczba.charAt(i)==cyfry.charAt(j)){
                    sumaCyfr += j;
                }
            }
        }
        System.out.println(sumaCyfr);



        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie4() {
        System.out.println("1 Podaj ile chcesz mieć dzielników (A) i A>0");
        System.out.println("2 Wypisz tyle (A) wybranych dzielników i dzielniki!=0");
        System.out.println("3 Podaj do której maks liczby chcesz żebym sprawdzał (N) i N>0");
        System.out.println(" a wypiszę ci wszystkie liczby do (N) które są podzielne przez wyżej wpisane dzielniki");

        Scanner podajLiczby = new Scanner(System.in);
        int ileDzieln = 1;
        int liczN = 1;
        // int minimal = 2147000000;
        // int maksimal = -2147000000;
        for (int i = 1; i <=1 ; i++) {          //podawania ilości dzielników
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            ileDzieln=podajLiczby.nextInt();

            if (ileDzieln<=0){
                System.out.println("Powiedziałem że ma być >0");
                i--;
            }
        }
        int[] dzielniki = new int[ileDzieln];          //tabela dzielników

        System.out.println("Teraz wypisz te " + ileDzieln + " dzielników: ");       //DZIELNIKI
        for (int i = 0; i <ileDzieln ; i++) {          //wypisywanie tych dzielnikó
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            dzielniki[i]=podajLiczby.nextInt();

            if (dzielniki[i]==0){
                System.out.println("Dzielnik nie może być zero bo przez nie nie podzielę");
                i--;
            }
        }

        System.out.println("Teraz wypisz ile liczb od 0 mamy sprawdzać: ");
        for (int i = 1; i <=1 ; i++) {          //podawanie maks (N) liczby ile liczb będzie do sprawdzania
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            liczN=podajLiczby.nextInt();        //ile liczb będzie sprawdzane

            if (liczN<=0){
                System.out.println("Powiedziałem że ma być >0");
                i--;
            }
        }
        int[][] wyniki = new int[liczN+1][ileDzieln];                     //deklaracja tabela wyników czyli podzielnych
        int ktoraCheck = 0;
        //int dzielniki jest[ileDzieln]

                //SPRAWDZANIE LICZB I PRZYPISYWANIE OSTATECZNE WYNIKÓW!!!
        for (int i = 0; i <= liczN; i++) {              //.length jest od liczN
            boolean wystep = false;
            for (int j = 0; j < dzielniki.length; j++) {        //.length jest od iledzielniki
                if (i%dzielniki[j] ==0){
                    wyniki[ktoraCheck][j]=i;
                    wystep=true;
                }
            }
            if (wystep) {
                ktoraCheck++;
            }
        }

        System.out.println("WYNIKI: LICZBY PODZIELNE ");
        for (int i = 0; i < dzielniki.length; i++) {
            System.out.println("Przez " + dzielniki[i] + " : ");

            for (int j = 0; j < ktoraCheck; j++) {
                if (wyniki[j][i]!=0 && j!=ktoraCheck-1 && j!=0){
                    System.out.print(wyniki[j][i] + " ");

                }else if (wyniki[0][i]!=0 && j==0){
                    System.out.print("{" + wyniki[j][i] + " ");

                }else if (wyniki[0][i]==0 && j==0) {
                    System.out.print("{");

                }else if (wyniki[j][i]==0 && j==ktoraCheck-1){
                    System.out.print("}");

                }else if (wyniki[j][i]!=0 && j==ktoraCheck-1) {
                    System.out.print(wyniki[j][i] + "}");
                }
            }

            System.out.println("\n");
        }


        System.out.println("\n \n \n    Koniec Programu \n ");
    }

    private static void zadanie3() {
        System.out.println("Wybierz liczbę >0:");
        System.out.println("A pokaże ci wszystkie liczby mniejsze od wybranej i do tego:");
        System.out.println(" -podzielne przez 2 A");
        System.out.println(" -podzielne przez 3 B");
        System.out.println(" -podzielne przez X C (gdzie x będziesz mógł wybrać, lecz nie 0)");

        Scanner podajLiczby = new Scanner(System.in);
        int liczba = 1;
        int liczX = 1;
       // int minimal = 2147000000;
       // int maksimal = -2147000000;
        for (int i = 1; i <=1 ; i++) {          //podawania pierwszej liczby A czyli do której liczby będą sprawdzane
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            liczba=podajLiczby.nextInt();

            if (liczba<=0){
                System.out.println("Powiedziałem że ma być >0");
                i--;
            }
        }
        int[] tablicaA = new int[liczba];
        int[] tablicaB = new int[liczba];
        int[] tablicaC = new int[liczba];

        System.out.println("Teraz podaj dzielnik X");
        for (int i = 1; i <=1 ; i++) {          //podawanie dzielnika X czyli przez co będą podzielne
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            liczX=podajLiczby.nextInt();

            if (liczX<=0){
                System.out.println("Powiedziałem że ma być >0");
                i--;
            }
        }

        int zapA = 0;
        int zapB = 0;
        int zapC = 0;
        for (int i = 1; i < liczba; i++) {
            if (i%2==0){
                tablicaA[zapA]=i;
                zapA++;
            }

            if (i%3==0){
                tablicaB[zapB]=i;
                zapB++;
            }

            if (i%liczX==0){
                tablicaC[zapC]=i;
                zapC++;
            }
        }

        System.out.println("Liczby do wybranej przez ciebie " + liczba + " Które są podzielne przez 2:");
        System.out.print("{");
        for (int i = 0; i < zapA; i++) {
            if (i==zapA-1){
                System.out.print(tablicaA[i] + "}");
            }else {
                System.out.print(tablicaA[i] + " ");
            }
        }

        System.out.println("\n \n Liczby do wybranej przez ciebie " + liczba + " Które są podzielne przez 3:");
        System.out.print("{");
        for (int i = 0; i < zapB; i++) {
            if (i==zapB-1){
                System.out.print(tablicaB[i] + "}");
            }else {
                System.out.print(tablicaB[i] + " ");
            }
        }

        System.out.println("\n \n Liczby do wybranej przez ciebie " + liczba + " Które są podzielne przez " + liczX + ":");
        System.out.print("{");
        for (int i = 0; i < zapC; i++) {
            if (i==zapC-1){
                System.out.print(tablicaC[i] + "}");
            }else {
                System.out.print(tablicaC[i] + " ");
            }
        }


        System.out.println("\n \n   Koniec Programu \n ");
    }

    private static void zadanie2() {
        System.out.println("Wypisz ile liczb chciałbyś dodać.");
        System.out.println("Następnie wyświetlę min,max,suma,med spośród nich");

        Scanner podajLiczby = new Scanner(System.in);
        int ileLiczb;

        int minimal = 2147000000;
        int maksimal = -2147000000;
        int suma = 0;
        float mediana = 0;

        while (!podajLiczby.hasNextInt()){
            System.out.println("Musi być to liczba");
            podajLiczby.next();
        }
        ileLiczb=podajLiczby.nextInt();
        int[] tablica1 = new int[ileLiczb];


        for (int i = 0; i < ileLiczb; i++) {
            while (!podajLiczby.hasNextInt()){
                System.out.println("Musi być to liczba");
                podajLiczby.next();
            }
            tablica1[i]=podajLiczby.nextInt();
            minimal = min(minimal,tablica1[i]);
            maksimal = max(maksimal,tablica1[i]);
            suma = suma + tablica1[i];
        }

        System.out.println("\n\n Wybrane przez ciebie liczby to: ");
        System.out.print("{");
        for (int i = 0; i < tablica1.length; i++) {
            if (i==tablica1.length-1){
                System.out.print(tablica1[i]);
            }else {
                System.out.print(tablica1[i] + " ");
            }
        }
        System.out.print("} \n");

        System.out.println("Ich suma wynosi = " + suma);
        System.out.println("Najmniejsza liczba z nich to = " + minimal);
        System.out.println("Największa liczba z nich to = " + maksimal);

        if (tablica1.length%2==0){
            mediana = (float) (tablica1[(tablica1.length-1)/2] + tablica1[(tablica1.length+1)/2]) /2;
            System.out.println("Mediana czyli wartość środkowa z tych liczb to " + mediana);
        }else {
            mediana = (float) tablica1[(tablica1.length/2)];
            System.out.println("Mediana czyli wartość środkowa z tych liczb to " + mediana);
        }


        System.out.println("\n \n   Koniec Programu \n");
    }

    private static void zadanie1() throws InterruptedException {
        //Gra w Lotto
        System.out.println("LOTTO");
        System.out.println("Wybierz 6 RÓŻNYCH liczb z ZAKRESU <1,39>: ");

        Scanner podajLiczby = new Scanner(System.in);
        int[] liczbyGracza = new int[6];
        int[] wylosowaneLiczby = new int[6];
        boolean powtorka = false;

        Random losow = new Random();        //do losowania potrzebne
        final int zakresMin = 1;
        final int zakresMax = 39;

        int trafione = 0;


        for (int i = 0; i < liczbyGracza.length; i++) {
            while (!podajLiczby.hasNextInt()){
                System.out.println("Muszą to być liczby z zakresu od 1 do 39 włącznie");
                podajLiczby.next();
            }
            liczbyGracza[i]=podajLiczby.nextInt();

            if (liczbyGracza[i]<zakresMin || liczbyGracza[i]>zakresMax){
                i--;
                System.out.println("Liczby muszą być z zakresu <1,39>");
            }else {
                for (int j = 0; j < i; j++) {
                    if (liczbyGracza[j]==liczbyGracza[i]){
                        System.out.println("Liczby nie mogą się powtarzać");
                        powtorka = true;
                        i--;
                        break;
                    }
                }
                if (!powtorka) {
                    System.out.println("Wybrałeś " + liczbyGracza[i]);
                }
            }
            powtorka = false;
        }

        System.out.println("\n\n Wybrane przez ciebie liczby to: ");
        System.out.print("{");
        for (int i = 0; i < liczbyGracza.length; i++) {
            if (i==5){
                System.out.print(liczbyGracza[i]);
            }else {
                System.out.print(liczbyGracza[i] + " ");
            }
        }
        System.out.print("} \n");


        for (int i = 0; i < wylosowaneLiczby.length; i++) {                 //losowanie 6 liczb bez powtórek do tablicy
            wylosowaneLiczby[i] = losow.nextInt(zakresMax-zakresMin)+zakresMin;

            for (int j = 0; j < i; j++) {
                if (wylosowaneLiczby[j]==wylosowaneLiczby[i]){
                    powtorka = true;
                    i--;
                    break;
                }
            }
            if (!powtorka) {
                System.out.println(i+1 + " wylosowana liczba wynosi:  " + wylosowaneLiczby[i]);
                Thread.sleep(2700);      //czekaj 3 sekundy                                     //METODOLOGIA POZWALAJĄCA NA PRZECZEKANIE TROCHĘ CZASU
            }

            powtorka = false;
        }

        System.out.println(" Wszystkie Wylosowane liczby to: ");
        System.out.print("{");
        for (int i = 0; i < wylosowaneLiczby.length; i++) {
            if (i==5){
                System.out.print(wylosowaneLiczby[i]);
            }else {
                System.out.print(wylosowaneLiczby[i] + " ");
            }
        }
        System.out.print("} \n \n");


        for (int i = 0; i < liczbyGracza.length; i++) {
            for (int j = 0; j < wylosowaneLiczby.length; j++) {
                if (liczbyGracza[i]==wylosowaneLiczby[j]){
                    trafione++;
                    break;
                }
            }
        }
        System.out.println("Brawo!!, Gratulacje, Zgadłeś aż " + trafione + " liczb, twoja nagroda to....");
        switch (trafione){
            case 0:{
                System.out.println("0$  oraz    0 samochodów     oraz    0 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 1:{
                System.out.println("1$  oraz    0 samochodów      oraz    0 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 2:{
                System.out.println("5$  oraz    0 samochodów      oraz    1 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 3:{
                System.out.println("20$  oraz    0 samochodów      oraz    1 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 4:{
                System.out.println("50$  oraz    0 samochodów     oraz    2 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 5:{
                System.out.println("500$  oraz    0 samochodów     oraz    2 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
            case 6:{
                System.out.println("500$  oraz    1 samochód      oraz    3 skrzyneczek ze słodkościami!! Gratulujemy \n");
                System.out.println("Nagrodę główną wylosował....    KTOŚ INNY, gratulujemy nieznanemy zwycięscy!");
                break;
            }
        }

        System.out.println("\n \n   Koniec Programu \n");
    }


}
