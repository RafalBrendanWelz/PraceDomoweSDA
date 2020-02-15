package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie4;

import java.util.Map;
import java.util.TreeMap;

class Telefon {
    private Map<String, SkrzynkaOdbiorcza> kontakty;
    private String nazwaTelef;

    public Map<String, SkrzynkaOdbiorcza> getKontakty() {
        return kontakty;
    }
    public void setKontakty(Map<String, SkrzynkaOdbiorcza> kontakty) {
        this.kontakty = kontakty;
    }
    public String getNazwaTelef() {
        return nazwaTelef;
    }
    public void setNazwaTelef(String nazwaTelef) {
        this.nazwaTelef = nazwaTelef;
    }

    public Telefon(String nazwaTelef) {
        this.nazwaTelef = nazwaTelef;
        this.kontakty = new TreeMap<>();
    }

    public int ileNieprzecz(){
        int wynik = 0;
        for (String kont: this.kontakty.keySet() ) {
            wynik += this.kontakty.get(kont).getIleNieprzeczytane();
        }
        return wynik;
    }

    public void dodajWiadomosc( String nadawca, String tytul, String tresc ){
        String[] nazwiNumer = nadawca.split(" ");

        if (this.kontakty.containsKey(nazwiNumer[1]) ){
            this.kontakty.get(nazwiNumer[1]).maszWiadomosc( tytul, tresc);

        }else if (nazwiNumer[1].length() > 1) {
            this.kontakty.put(nazwiNumer[1], new SkrzynkaOdbiorcza( Integer.parseInt(nazwiNumer[0])) );
            this.kontakty.get(nazwiNumer[1]).maszWiadomosc( tytul, tresc);
        }else {
            this.kontakty.put(nazwiNumer[0], new SkrzynkaOdbiorcza( Integer.parseInt(nazwiNumer[0])) );
            this.kontakty.get(nazwiNumer[0]).maszWiadomosc( tytul, tresc);
        }
    }

    public void pokazWiadOd ( String nadawca ){
        if (this.kontakty.containsKey(nadawca) ){
            this.kontakty.get(nadawca).sprawdzAllWiadomosc( false );

        }else {
            System.out.println("Nie masz Takiego Nadawcy, Brak Wiadomości");
            System.out.println("Twoje kontakty: " + this.kontakty.keySet());
        }
    }

    public void pokazNieprzeczytaneWiad (){
        for (String kont: this.kontakty.keySet()) {
            System.out.println(kont + " :");
            this.kontakty.get(kont).sprawdzAllWiadomosc( true );
            System.out.println("---------------------- ");
        }
    }

    public Wiadomosc usunAktualOd ( String nadawca){
        if (this.kontakty.containsKey(nadawca) ){
            System.out.println("Usunięto wiadomość ze skrzynki odbiorczej " + nadawca);
            return this.kontakty.get(nadawca).usunWiadomosc();

        }else {
            System.out.println("Nie masz Takiego Nadawcy, Brak Wiadomości");
            System.out.println("Twoje kontakty: " + this.kontakty.keySet());
            return null;
        }
    }

    public Wiadomosc odczytaj ( String odTego, int taWiad){
        if ( this.kontakty.containsKey(odTego) ){
            return this.kontakty.get(odTego).odczytSMS( taWiad ) ;

        }else {
            System.out.println("Nie ma takiego Nadawcy, odczytuje od pierwszego nadawcy z listy");
            return this.kontakty.get( this.kontakty.keySet().iterator().next() ).odczytSMS( taWiad ) ;
        }
    }




}
