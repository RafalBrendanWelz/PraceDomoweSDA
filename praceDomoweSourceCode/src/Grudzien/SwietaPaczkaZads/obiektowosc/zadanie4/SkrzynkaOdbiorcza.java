package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie4;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class SkrzynkaOdbiorcza {
    private Set<Wiadomosc> listaWiadomosci;
    private int ileNieprzeczytane;
    private int numer;

    public Set<Wiadomosc> getListaWiadomosci() {
        return listaWiadomosci;
    }
    public void setListaWiadomosci(Set<Wiadomosc> listaWiadomosci) {
        this.listaWiadomosci = listaWiadomosci;
    }
    public int getIleNieprzeczytane() {
        return ileNieprzeczytane;
    }

    public SkrzynkaOdbiorcza( int numer ) {
        this.listaWiadomosci = new TreeSet<>();
        this.ileNieprzeczytane = 0;
        this.numer = numer;
    }

    public void maszWiadomosc ( String tytul, String tresc){
        this.listaWiadomosci.add( new Wiadomosc(tresc, LocalDateTime.now(), tytul) );
        this.ileNieprzeczytane++ ;
    }

    public Wiadomosc usunWiadomosc ( ){
        Wiadomosc najnowsza = this.listaWiadomosci.iterator().next() ;
        if ( najnowsza == null ){
            System.out.println("Skrzynka Odbiorcza już jest pusta, Brak Wiadomości");
        }else {
            if ( !najnowsza.czyOdczytana() ){
                this.ileNieprzeczytane--;
            }
            listaWiadomosci.remove( najnowsza );
            System.out.println("Usunięto Wiadomość: " + najnowsza.getTytul() );
        }
        return najnowsza;
    }

    public void sprawdzAllWiadomosc(boolean tylkoNieodczytane){
        if ( tylkoNieodczytane ){
            for (Wiadomosc sms: this.listaWiadomosci) {
                if ( !sms.czyOdczytana() ){
                    System.out.println(sms);
                }
            }

        }else {
            for (Wiadomosc sms: this.listaWiadomosci) {
                System.out.println(sms);
            }
        }
    }

    public Wiadomosc odczytSMS( int tego ){
        if (tego >= this.listaWiadomosci.size() ){
            tego = this.listaWiadomosci.size()-1;
        }else if (tego < 0){
            tego = 0;
        }

        Iterator<Wiadomosc> poszukiwania = this.listaWiadomosci.iterator();
        for (int i = 0; i < tego; i++) {
           poszukiwania.next();
        }
        Wiadomosc wybrana = poszukiwania.next();
        if ( !wybrana.czyOdczytana() ){
            wybrana.odczytales();
            this.ileNieprzeczytane--;
        }
        return wybrana;
    }



}
