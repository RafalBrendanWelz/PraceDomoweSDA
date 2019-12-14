package Grudzien.Slack2Gru.zadanie5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class zad5 {
    private static Scanner decyzje = new Scanner(System.in);
    private static Ksiazka[] allKsiazki;

    public static void zad5Start(){
        allKsiazki = dajKsiazki( );

        wybierzKsiazke(allKsiazki);

    }

    private static Ksiazka[] dajKsiazki() {
        Ksiazka taka = new Ksiazka("Toronto", 1998);
        Ksiazka smaka = new Ksiazka("Druga Dodana Książka ,która będzie przekazana do tablicy allKsiazki (tak jak pozostałe), w Historii tego Programu, zapisana dla pobicia rekordu najdłuższego tytułu książki", 7);
        Ksiazka tomk = new Ksiazka("Przygody Tomka Sayera", 1785);
        Ksiazka karamba = new Ksiazka("Carmageddon Quide Book", 2000);
        Ksiazka chlop = new Ksiazka("Chłopi", 1770);
        Ksiazka wad = new Ksiazka("Kapucynka o Poranku", 1948);
        Ksiazka asf = new Ksiazka("Kolos", 1947);
        Ksiazka afwv = new Ksiazka("Lotnicy", 1904);
        Ksiazka de2r2 = new Ksiazka("Harry Potter and the Chamber of Secrets", 1995);
        Ksiazka ar2d3 = new Ksiazka("Uguauqwie", 2012);

        return new Ksiazka[] {taka, smaka, tomk, karamba, chlop, wad, asf, afwv, de2r2 ,ar2d3};
    }

    private static void wybierzKsiazke( Ksiazka[] ztych ){
        System.out.println("Wpisz Numer Książki by ją wybrać: ");
        for (int i = 0; i < ztych.length; i++) {
            System.out.println("Wpisz " + i + " dla " + ztych[i].getTytul() );
        }
        int decyd = podajInt();
        try {
            dzialanie( ztych[decyd] );

        }catch (ArrayIndexOutOfBoundsException ponadmax){
            dzialanie( ztych[0] );
        }
    }

    private static void dzialanie(Ksiazka taka) {
        System.out.println("Wybrałeś: ");
        taka.wypisz();
        System.out.println("Wpisz co chcesz zrobić: [wypisz , dodaj (dodaj autora) , zmien (wybierz inna książke) , cokolwiek Innego by wyjść ]");
        wyboryOKsiazkach jakaDecyzja;

        try {
            jakaDecyzja = wyboryOKsiazkach.valueOf(  decyzje.next() );
        }catch ( IllegalArgumentException brakEnum ){
            jakaDecyzja = wyboryOKsiazkach.quit;
        }

        coRobisz( taka, jakaDecyzja );
    }

    private static Autor dajAutora (){
        System.out.println("Podaj imię i nazwisko Autora po enterach");
        return new Autor( decyzje.next(), decyzje.next() );
    }


    private static void coRobisz (Ksiazka taka, wyboryOKsiazkach to){
        switch (to){
            case quit:{
                break;
            }case dodaj:{
                taka.dodaj( dajAutora() );
                dzialanie( taka );
                break;
            }case wypisz:{
                dzialanie( taka );
                break;
            }case wybierz:{
                wybierzKsiazke( allKsiazki );
                break;
            }
        }
    }


    private static int podajInt() {
        while (!decyzje.hasNextInt() ){
            decyzje.next();
        }
        return decyzje.nextInt();
    }


}
