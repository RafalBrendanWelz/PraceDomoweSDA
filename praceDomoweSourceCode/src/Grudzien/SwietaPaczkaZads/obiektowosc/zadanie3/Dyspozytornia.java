package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie3;

import java.time.LocalTime;
import java.util.*;

class Dyspozytornia {
    private Map<String, Zgloszenie> przyjeteZgloszenia = new LinkedHashMap<>();
    private String nazwa;

    public Dyspozytornia(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
    public Map<String, Zgloszenie> getPrzyjeteZgloszenia() {
        return przyjeteZgloszenia;
    }

    public void dodajZgloszenie(typZgloszenia jakie, String tresc, String adres, miejsceZglosz miasto ){
        Zgloszenie takie = new Zgloszenie(jakie, tresc, miasto, adres, LocalTime.now() );
        przyjeteZgloszenia.put( takie.getID(), takie );
    }

    public void wykonajPierwsze( ){
        this.przyjeteZgloszenia.remove( this.przyjeteZgloszenia.keySet().iterator().next() );
    }

    public List<Zgloszenie> dajAktualne (int ile ){
        List<Zgloszenie> wynik = new LinkedList<>();
        Iterator<String> zListy = this.przyjeteZgloszenia.keySet().iterator();
        for (int i = 0; i < ile; i++) {
            if ( zListy.hasNext() ){
                wynik.add( this.przyjeteZgloszenia.get( zListy.next() ) );
            }
        }
        return wynik;
    }

    public List<Zgloszenie> dajZgloszeniaTypu ( typZgloszenia takiego){
        List<Zgloszenie> wynik = new LinkedList<>();

        this.przyjeteZgloszenia.values().forEach( (t) -> {
            if (t.getJakie().equals( takiego ) ){
                wynik.add(t);
            }
        } );

        return wynik;
    }





}
