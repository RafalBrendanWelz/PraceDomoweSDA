package Grudzien.Slack2Gru.zadanie5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ksiazka {

    private String tytul;
    private long isbn;                                            //isbn - international standard book number - 13 cyfrowy unikalny identyfikator książki, po wydawcy, tytule i edycji
    private int rokWydania;
    private Autor[] autorzy = new Autor[3];
    private int iloscAutor;

    public Ksiazka(String tytul, int rokWydania) {
        this.tytul = tytul;
        this.isbn = losujDoisbn(tytul.length());
        this.iloscAutor = 0;
        this.rokWydania = rokWydania;
    }

    private static long losujDoisbn( int ileZTytulu){
        Random loteria = new Random();

        StringBuilder wynikLiczba = new StringBuilder();
        wynikLiczba.append(ileZTytulu );
        while (wynikLiczba.length() < 13 ){
            wynikLiczba.append( loteria.nextInt(10) );
        }

        return Long.parseLong( wynikLiczba.toString() ) ;
    }

    public void wypisz(){
        System.out.print("Książka " + this.tytul + " " + this.isbn + " została napisana przez ");
        for (Autor aut: autorzy) {
            try {
                System.out.print(aut.getPrzedstaw() + ", ");
            }catch (NullPointerException brak){

            }
        }
        System.out.println(" " + this.iloscAutor + " autorów.");
    }

    public void dodaj( Autor nowyAut ){
        try{
            autorzy[iloscAutor++] = nowyAut;
        }catch (ArrayIndexOutOfBoundsException ponadMax){
            System.out.println("Książka ma maksymalną ilość autorów");
        }
    }


    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public Autor[] getAutorzy() {
        return autorzy;
    }


}
