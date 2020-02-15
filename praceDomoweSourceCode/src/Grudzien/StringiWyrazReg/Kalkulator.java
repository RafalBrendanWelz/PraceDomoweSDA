package Grudzien.StringiWyrazReg;

import com.sun.jdi.Value;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Kalkulator {

    public static double infoplusStart(){
        System.out.println("Oto program Kalkulatorowy wersja 20.12.2019 ");
        System.out.println("Ten program przyjmuje dwie liczby oraz rodzaj działania \n" +
                "a następnie zwraca i wyświetla wynik");
        return start();
    }
    private static KalkOperacje wyborCoRobisz() {
        Scanner wpisz = new Scanner(System.in);

        while (true){
            char znak = wpisz.next().charAt(0);
            for (KalkOperacje taka : KalkOperacje.values()) {
                if (znak == taka.getZnak()){
                    return taka;
                }
            }
            System.out.println("Nieprawidłowy symbol, wpisz jeszcze raz");
        }
    }
    private static double dajDouble() {
        Scanner wpisz = new Scanner(System.in);
        while ( !wpisz.hasNextDouble() ){
            wpisz.next();
        }
        return wpisz.nextDouble();
    }

    public static double start(){
        System.out.println("Podaj Pierwszą liczbę (może być z przecinkiem) jako podstawę: ");
        double pier = dajDouble();
        System.out.println("Podaj symbol operacji: + - / * \n albo specjalne: r (reszta z dzielenia) ^ (do potęgi) % (ileś procent z) ");
        KalkOperacje znak = wyborCoRobisz();
        return dzialanieMain(pier, znak);
    }

    public static double start(double pier, KalkOperacje coRobic){
        return dzialanieMain(pier, coRobic);
    }

    private static double dzialanieMain(double pier, KalkOperacje coRobi){
        switch (coRobi ){
            case MNOZ:{
                System.out.println("Podaj drugą liczbę * (mnożnik) ile razy przemnożysz pierwszą: ");
                double sec = dajDouble();
                return (pier * sec);

            }case DODAJ:{
                System.out.println("Podaj drugą liczbę + o ile będziesz zwiększał: ");
                double sec = dajDouble();
                return (pier + sec);

            }case DZIEL:{
                System.out.println("Podaj drugą liczbę / (dzielnik) przez ile podzielisz tą pierwszą: ");
                double sec = dajDouble();
                return dziel(pier, sec);

            }case ODEJM:{
                System.out.println("Podaj drugą liczbę - o ile będziesz zmniejszał: ");
                double sec = dajDouble();
                return (pier - sec);

            }case DOPOTEG:{
                System.out.println("Podaj drugą liczbę ^ do której potęgi podnieść pierwszą: ");
                double sec = dajDouble();
                return Math.pow(pier, sec);

            }case PROCENTZ:{
                System.out.println("Podaj drugą liczbę % ile procent z pierwszej chcesz osiągnąć (* x%): ");
                double sec = dajDouble();
                return (pier * sec / 100);

            }case RESZTAZDZIEL:{
                System.out.println("Podaj drugą liczbę r (dzielnik) przez ile podzielisz ale pokażę ci tylko pozostałą resztę: ");
                double sec = dajDouble();
                return (pier % sec);

            } default: {
                System.out.println("Nie rozpoznana czynność zwracam wartośc początkową ");
                return pier;
            }
        }

    }

    private static double dziel(double pier, double sec) {
        if (sec == 0){
            throw new IllegalArgumentException("Nie można dzielić przez zero");
        }else {
            return (pier / sec);
        }
    }


}
