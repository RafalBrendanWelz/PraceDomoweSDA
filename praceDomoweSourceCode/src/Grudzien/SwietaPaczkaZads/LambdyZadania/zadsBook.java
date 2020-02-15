package Grudzien.SwietaPaczkaZads.LambdyZadania;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

class zadsBook {

    static void zad4Start(){
        System.out.println("Zadanie 4 z ksiazkami i wypisem autorow ");
        Book[] ksiazki = dajKsiazki();

        System.out.println( wszyscyAutorzy(ksiazki) );

    }

    static void zad5Start(){
        System.out.println("\n\nZadanie 5 z wypisem słów z tytułów ");
        Book[] ksiazki = dajKsiazki();

        System.out.println( zwrocTytulRazemMale(ksiazki) );

    }

    static void zad6Start(){
        System.out.println("\n\nZadanie 6 z mapą tytułów ");
        Book[] ksiazki = dajKsiazki();

        System.out.println( dajMapeTytulow(ksiazki).keySet() );

    }

    static void zad7DodatkoweStart(){
        System.out.println("\n\nZadanie 7 z mapą autorów ");

        System.out.println( dajMapeAutorow( Arrays.asList(dajKsiazki()) ) );
    }

    static void zad8DodatkoweStart(){
        System.out.println("\n\nZadanie 8 daje książkę z największą ilością edycji ");
        List<Book> ksiazki = new ArrayList<>( Arrays.asList(dajKsiazki()) ) ;
        System.out.println(ksiazki.get(0).getIloscEdycji() + " " + ksiazki.get(0) );
        System.out.println(ksiazki.get(1).getIloscEdycji() + " " + ksiazki.get(1) );
        System.out.println(ksiazki.get(2).getIloscEdycji() + " " + ksiazki.get(2) );
        System.out.println(ksiazki.get(3).getIloscEdycji() + " " + ksiazki.get(3) );

        Book najw = znajdzNajwEdycji( ksiazki );
        System.out.println( najw + " ma " + ksiazki.get( ksiazki.indexOf(najw) ).getIloscEdycji() + " edycji" );

    }

    private static Book znajdzNajwEdycji(List<Book> ksiazki){
        ksiazki.sort( Book::compareTo );
        Set<Book> ksiazkiSort = new TreeSet<>(ksiazki);

        return ksiazki.get(0);
    }

    private static Map<String, Set<Book> > dajMapeAutorow(List<Book> ksiazki) {
        Map<String, Set<Book>> wynik = new LinkedHashMap<>();

        ksiazki.stream().forEach( (t) -> {
            String autor = t.getAutor();
            if ( wynik.keySet().contains(autor) ){
                wynik.get( autor ).add( t );
            }else {
                wynik.put( autor, new LinkedHashSet<Book>( ) );
                wynik.get( autor ).add(t);
            }
        } );

        return wynik;
    }

    private static Map<String, Book> dajMapeTytulow(Book[] ksiazki) {
        Map<String, Book> wynik = new LinkedHashMap<>();

        Arrays.stream(ksiazki).forEach( (t) -> {
            String tytul = t.getTytul();
            tytul = tytul.replaceAll("[_.;{}\\[\\]=+*/-<>?!@#$%^&()|\u0007894561230]"," ");
            wynik.put( tytul, t );
        } );

        return wynik;
    }


    private static Set<String> zwrocTytulRazemMale (Book... ksiazki ){
        Set<String> wynik = new LinkedHashSet<>();

        Arrays.stream(ksiazki).forEach( (t) -> {
            String tytul = t.getTytul().toLowerCase();
            tytul = tytul.replaceAll("[_.;{}\\[\\]=+*/-<>?!@#$%^&()|\u0007894561230]"," ");
            wynik.add( tytul );
        } );

        return wynik;
    }


    private static List<String> wszyscyAutorzy (Book... ksiazki ){
        List<String> autorzy = new LinkedList<>();

        Arrays.stream(ksiazki).forEach( (t) -> {
            if (!autorzy.contains(t.getAutor()) ) {
                autorzy.add(t.getAutor());
            }
        } );

        autorzy.sort( String::compareTo );
        return autorzy ;
    }

    private static Book[] dajKsiazki (){
        Book pierw = new Book ("Costam", "Wyspiański");
        Book dru = new Book ("Zemsta_Bogów_Olimpu", "Kronos");
        Book trz = new Book ("Praca_Magisterska_do_bani", "Kowalewski");
        Book czw = new Book ("Costam", "Gorczyk");
        Book pia = new Book ("Bajki_dla_Dzieci", "Tuwim");
        Book sze = new Book ("Władca_Pierścieni_Drużyna_Pierścienia", "Tolkien J.R.R");
        Book siem = new Book ("Władca_Pierścieni_Dwie_Wieże", "Tolkien J.R.R");
        Book wos = new Book ("Władca_Pierścieni_Powrót_Króla", "Tolkien J.R.R");
        Book dziew = new Book ("Chłopi", "Sienkiewicz H");
        Book dzies = new Book ("Pan_Tadeusz", "Mickiewicz A");
        Book adinsat = new Book ("Gotowanie dla Ubogich", "Rakowski");
        Book dwiesat = new Book ("Costam2", "Wyspiański");
        Book trisat = new Book ("DiskWorld_Series", "Pratchet T");
        Book cztysat = new Book ("DiskWorld_Series2", "Pratchet T");
        Book piatsat = new Book ("DiskWorld_Series3", "Pratchet T");
        Book szestsat = new Book ("Dr.Zeuss", "Reul");
        Book siemsat = new Book ("Call of the Cthulhu", "Lovecraft H.P");
        Book wosisat = new Book ("Wiedźmin_Krew_Elfów", "Sapkowski");
        Book dziesat = new Book ("Wiedźmin_Czas_Pogardy", "Sapkowski");

        return new Book[] {pierw, dru, trz, czw, pia, sze, siem, wos, dziew, dzies, adinsat, dwiesat, trisat, cztysat, piatsat, szestsat, siemsat, wosisat, dziesat };
    }



}
