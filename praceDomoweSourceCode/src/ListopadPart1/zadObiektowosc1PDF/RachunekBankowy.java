package ListopadPart1.zadObiektowosc1PDF;

public class RachunekBankowy {
    private String numerKonta;
    private double iloscSrodkow;
    private String imie;
    private String nazwisko;
    private int idKonta;

    static int kontaIlosDoID = 0;


    public int getIdKonta() {
        return idKonta;
    }

    String getNumerKonta() {
        return numerKonta;
    }

    private double getIloscSrodkow() {
        return iloscSrodkow;
    }

    String getImie() {
        return imie;
    }

    String getNazwisko() {
        return nazwisko;
    }



    RachunekBankowy(int numerKonta, String imie, String nazwisko){
        this.iloscSrodkow = 0;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKonta = Integer.toString(numerKonta);
        this.idKonta = kontaIlosDoID;

        kontaIlosDoID++;
    }

    void rachunekInfo(){
        System.out.println("Konto bankowe numer: " + getNumerKonta());
        System.out.println("Właściciel: " + getImie() + " " + getNazwisko());
        System.out.println("Stan: " + getIloscSrodkow() + " zł");
        System.out.println("********************** \n");
    }

    void wplataPrzelewem(double kwota){                     //to do czy ma pieniądze (stanKonta > 0 ) i tylko wtedy przelew
        this.iloscSrodkow += kwota;
    }

    void przelewOutWyplata(double kwota){
        this.iloscSrodkow -= kwota;
    }



}
