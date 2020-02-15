package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie2;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

class Poczekalnia {
    private List<Klient> kolejka = new LinkedList<>();

    public void dodajKlienta(String imie, boolean czyPriorytet ) throws InterruptedException {
        kolejka.add(new Klient(imie, LocalTime.now(), czyPriorytet) );
        Thread.sleep(500);
    }

    public Klient nastepny ( ){
        this.kolejka.sort( Klient::compareTo );
        Klient wybrany = kolejka.get(0);
        kolejka.remove( kolejka.get(0));
        return wybrany;
    }

    public void wypiszKlientow(){
        this.kolejka.sort( Klient::compareTo );
        System.out.println("Aktualnie Czekający klienci:\n");
        this.kolejka.forEach( System.out::println );
        System.out.println(" ");
    }



}
