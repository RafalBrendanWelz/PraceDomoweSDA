package Grudzien.SwietaPaczkaZads.LambdyZadania;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class zad2Autor {


    static void zad2Start(){
        BookRepository takaPaka = new BookRepository();
        massKsiazki ( takaPaka );
        System.out.println("Wpisz tytuł książki a przeszukam Repozytorium Książki i wynajdę ci Autora tej Książki");
        String szukanyTytul = dajTekst();
        System.out.println("Autor twojej książki: " + szukanyTytul + " to: " + znajdzAutora( szukanyTytul, takaPaka ) );

    }

    private static List<String> znajdzAutora(String szukanyTytul, BookRepository allKsiazki) {
        List<String> autorzyWynik = new LinkedList<>();
        if ( allKsiazki.getListaKsiag().values().contains( szukanyTytul ) ){

            for (String key : allKsiazki.getListaKsiag().keySet() ) {

                if ( allKsiazki.getListaKsiag().get(key).contains( szukanyTytul ) ){
                    autorzyWynik.add( key );
                }
            }

        }else {
            throw new UnsupportedOperationException("Wśród Książek nie ma takiej ") ;
        }
        return autorzyWynik;
    }

    private static String dajTekst() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.next();
    }


    private static void massKsiazki(BookRepository taka) {
        taka.dajKsiazki("Wyspiański:Costam");
        taka.dajKsiazki("Kronos:Zemsta_Bogów_Olimpu");
        taka.dajKsiazki("Kowalewski:Praca_Magisterska_do_bani");
        taka.dajKsiazki("Gorczyk:Costam");
        taka.dajKsiazki("Tuwim:Bajki_dla_Dzieci");
        taka.dajKsiazki("J.R.R Tolkien:Władca_Pierścieni_Drużyna_Pierścienia");
        taka.dajKsiazki("J.R.R Tolkien:Władca_Pierścieni_Dwie_Wieże");
        taka.dajKsiazki("J.R.R Tolkien:Władca_Pierścieni_Powrót_Króla");
        taka.dajKsiazki("H.Sienkiewicz:Chłopi");
        taka.dajKsiazki("A.Mickiewicz:Pan_Tadeusz");
        taka.dajKsiazki("Rakowski:Gotowanie dla Ubogich");
        taka.dajKsiazki("Wyspiański:Costam2");
        taka.dajKsiazki("T.Pratchet:DiskWorld_Series");
        taka.dajKsiazki("T.Pratchet:DiskWorld_Series2");
        taka.dajKsiazki("T.Pratchet:DiskWorld_Series3");
        taka.dajKsiazki("Reul:Dr.Zeuss");
        taka.dajKsiazki("H.P.Lovecraft:Call of the Cthulhu");
        taka.dajKsiazki("Sapkowski:Wiedźmin_Krew_Elfów");

    }


}
