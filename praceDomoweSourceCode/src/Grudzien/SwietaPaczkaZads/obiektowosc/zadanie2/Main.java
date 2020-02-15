package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {


    public static void main(String[] args) throws InterruptedException {
        Poczekalnia okulista = new Poczekalnia();
        okulista.dodajKlienta("Marek", false);
        okulista.dodajKlienta("Basia", false);
        okulista.dodajKlienta("Kuros", true);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );

        okulista.dodajKlienta("Maniek", false);
        okulista.dodajKlienta("Kamila", true);
        okulista.dodajKlienta("Teresa", false);
        okulista.dodajKlienta("Annie", false);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        Thread.sleep(2800);

        okulista.wypiszKlientow();
        okulista.dodajKlienta("Katarzyna", true);
        okulista.dodajKlienta("Tragedia", true);
        okulista.dodajKlienta("Tuwim", false);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );

        okulista.dodajKlienta("Kapi", false);
        okulista.dodajKlienta("Kornelia", true);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );

        okulista.dodajKlienta("Minie", false);
        okulista.dodajKlienta("Weiliss", false);
        Thread.sleep(2000);
        okulista.dodajKlienta("Marek", false);
        okulista.dodajKlienta("Tristana", false);
        okulista.dodajKlienta("Basia", false);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        Thread.sleep(2000);
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        okulista.dodajKlienta("Kuros", true);
        okulista.dodajKlienta("Maniek", false);
        okulista.dodajKlienta("Przemek", false);
        okulista.dodajKlienta("Kamila", true);
        okulista.dodajKlienta("Harry", true);
        okulista.dodajKlienta("Marek", false);
        Thread.sleep(1000);
        okulista.dodajKlienta("Basia", false);
        okulista.dodajKlienta("Karolina", false);
        okulista.dodajKlienta("Zosia", false);
        okulista.dodajKlienta("Maksymilian", true);
        okulista.wypiszKlientow();
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );
        System.out.println( okulista.nastepny() + " został\\a wezwany\\na " );

    }



}
