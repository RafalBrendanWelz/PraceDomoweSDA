package Grudzien.SwietaPaczkaZads.Wyjatki;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class Main {
    private static final Scanner wpisz = new Scanner(System.in);

    public static void main(String[] args) {
        //zad1();
        //zad2();
        //zad3();
        zad4();

    }

    private static void zad4() {
        System.out.println("Wpisz datę z przyszłości");
        LocalDate dataWpisana = wpiszDate();
        System.out.println(dataWpisana);
        if ( dataWpisana.isBefore(LocalDate.now()) ){
            System.out.println("To jest data z przeszłości!!... wpisz jeszcze raz");
            zad4();
        }

        LocalDateTime tamtaData = LocalDateTime.of(dataWpisana.getYear(), dataWpisana.getMonth(), dataWpisana.getDayOfMonth(), 0, 0);
        Duration ilePozostaloDni = Duration.between( LocalDateTime.now(), tamtaData );
        System.out.println("Pozostało " + ilePozostaloDni.getSeconds() / 60 + " minut do wskazanej daty");
    }
    private static LocalDate wpiszDate(){
        int rok = dajRok();
        int[] miesiacDzien;
        miesiacDzien = dajMiesiaciDzien(rok);

        return LocalDate.of(rok, miesiacDzien[0], miesiacDzien[1]);
    }
    private static int[] dajMiesiaciDzien(int rok){
        System.out.println("Podaj Miesiąc (1 do 12)");
        int miesiac = 0;
        while (miesiac < 1 || miesiac > 12){
            miesiac = dajInt();
        }
        System.out.println("Podaj Dzień (1 do maxDzienMiesiaca)");
        int dzien = 0;
        while (dzien < 1 || dzien > LocalDate.of(rok, miesiac, 5).lengthOfMonth() ){
            dzien = dajInt();
        }
        return new int[] {miesiac, dzien};
    }
    private static int dajRok() {
        System.out.println("Podaj Rok");
        return dajInt();
    }

    private static void zad3() {
        Person[] osoby = dajLudzi();

        Club gwazd = new Club("Gwiazdeczki");

        for (Person ci: osoby) {
            try {
                gwazd.wejdz(ci);
            }catch (NoAdultException e){
                e.printStackTrace();
            }
        }

    }
    private static Person[] dajLudzi(){
        Person tala = new Person("Tala", "Malszyńska", 22);
        Person daw = new Person("Tomasz", "Dawson", 24);
        Person rog = new Person("Andżela", "Rodżinson", 15);
        Person klo = new Person("Klopuc", "Kibelski", 28);
        Person tur = new Person("Elvis", "Turson", 30);

        return new Person[] {tala, daw, rog, klo, tur};
    }

    private static void zad2() {
        //zrobione przez nadpisanie na dzielenie do poprzedniego
        zad1();
    }

    private static void zad1() {
        System.out.println("Wpisz pierwszą liczbę którą będziesz dzielił: ");
        int liczbaGorn = dajInt();
        System.out.println("Wpisz drugą liczbę (dzielnik): ");
        int liczbaDoln = dajInt();

        double wynik = dzielenie(liczbaGorn, liczbaDoln);
        System.out.println(liczbaGorn + "/" + liczbaDoln + " = " + wynik);
    }
    private static double dzielenie(int liczbaGorn, int liczbaDoln) {
        try {
            if (liczbaDoln == 0){
                throw new Exception("CholeroException" ) ;
            }
            return liczbaGorn / liczbaDoln;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    private static int dajInt() {
        while (!wpisz.hasNextInt()){
            wpisz.next();
        }
        return wpisz.nextInt();
    }





}
