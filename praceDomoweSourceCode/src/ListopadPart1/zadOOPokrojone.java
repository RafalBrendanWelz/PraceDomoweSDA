package ListopadPart1;

import java.util.Scanner;

public class zadOOPokrojone {

    public static void main(String[] args) {
        //zadania z pliku zadania_oop_-_okrojone.txt
        //zad1do3();
        zad4();


    }

    private static void zad4() {
        CzasData urodzinDW = new CzasData( (byte) 11, (byte) 9,1963);
        CzasData urodzinMi = new CzasData( (byte) 1, (byte) 2,1961);
        CzasData urodzinKa = new CzasData( (byte) 16, (byte) 4,2000);
        CzasData urodzinDo = new CzasData( (byte) 4, (byte) 4,1989);
        CzasData urodzinMa = new CzasData( (byte) 28, (byte) 3,1987);


        CzasData urodzinMac = new CzasData( (byte) 12, (byte) 9,2001);
        CzasData urodzinJas = new CzasData( (byte) 29, (byte) 4,2002);
       
        CzasData urodzinDomin = new CzasData( (byte) 3, (byte) 12,1996);
     


        urodzinDo.wyswietlA();
        urodzinDo.wyswietlB();
        urodzinDo.wyswietlC();

        System.out.println("*************");

        urodzinMa.wyswietlA();
        urodzinMa.wyswietlB();
        urodzinMa.wyswietlC();

        System.out.println("*************");

        urodzinJas.wyswietlA();
        urodzinJas.wyswietlB();
        urodzinJas.wyswietlC();

    }

    private static void zad1do3() {
        Student kosa = new Student(podajNazwe(),podajNazwe(),podajNazwe(),podajByte(),podajByteSemestr(),czyTak(),plec());
        kreatorStudentaZad2();


    }

    //(String imie, String nazwisko, String kierunekStudiow, byte ktoryStopien, byte obecnySemestr, boolean czyZaliczony, char plec)
    private static void kreatorStudentaZad2() {
        Student alba = new Student(podajNazwe(),podajNazwe(),podajNazwe(),podajByte(),podajByteSemestr(),czyTak(),plec());
        alba.pokazDane();
        alba.przedstawSie();
    }

    private static char plec() {
        System.out.println("Wpisz 'm' jeśli płeć=facet lub 'k' jeśli płeć=kobieta lub 'p' jeśli inna:");
        Scanner wpisz = new Scanner(System.in);

        if (wpisz.next().charAt(0)=='k'){
            return 'k';
        }else if (wpisz.next().charAt(0)=='m'){
            return 'm';
        }else {
            return 'p';
        }
    }

    private static boolean czyTak() {
        System.out.println("Wpisz 1 jeśli zaliczył lub 0 jeśli nie ma jeszcze zaliczonego semestru: ");
        Scanner wpisz = new Scanner(System.in);

        while (!wpisz.hasNextByte()){
            wpisz.next();
        }
        if (wpisz.nextByte()!=1){
            return false;
        }else {
            return true;
        }
    }

    private static byte podajByteSemestr() {
        System.out.println("Wpisz na którym semestrze się znajduje (1 do 6)");
        Scanner wpisz = new Scanner(System.in);

        while (!wpisz.hasNextByte(6)){
            wpisz.next();
        }

        return wpisz.nextByte();
    }

    private static byte podajByte() {
        System.out.println("Wpisz który stopień naukowy obecnie posiada (od 0 do 4)");
        Scanner wpisz = new Scanner(System.in);

        while (!wpisz.hasNextByte(4)){
            wpisz.next();
        }

        return wpisz.nextByte();
    }

    private static String podajNazwe() {
        System.out.println("Wpisz imię, nazwisko i kierunek studiów");
        Scanner wpisz = new Scanner(System.in);

        return wpisz.next();
    }

}
