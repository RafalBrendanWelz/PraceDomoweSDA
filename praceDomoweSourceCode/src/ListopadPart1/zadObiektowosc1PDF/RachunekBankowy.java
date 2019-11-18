package ListopadPart1.zadObiektowosc1PDF;

public class RachunekBankowy {
    String numerKonta;
    double iloscSrodkow;
    String imie;
    String nazwisko;
    int idKonta;

    static int iloscKont = 0;

    protected String getNumerKonta() {
        return numerKonta;
    }

    protected double getIloscSrodkow() {
        return iloscSrodkow;
    }

    protected String getImie() {
        return imie;
    }

    protected String getNazwisko() {
        return nazwisko;
    }

    protected int getIloscKont() {
        return iloscKont;
    }


    protected RachunekBankowy(int numerKonta, String imie, String nazwisko){
        this.iloscSrodkow = 0;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKonta = Integer.toString(numerKonta);
        this.idKonta = iloscKont;

        iloscKont++;
    }

    protected void rachunekInfo(){
        System.out.println("Konto bankowe numer: " + getNumerKonta());
        System.out.println("Właściciel: " + getImie() + " " + getNazwisko());
        System.out.println("Stan: " + getIloscSrodkow() + " zł");
        System.out.println("********************** \n");
    }

    protected void wplataPrzelewem (double kwota){
        this.iloscSrodkow += kwota;
    }

    protected void przelewOutWyplata (double kwota){
        this.iloscSrodkow -= kwota;
    }



}
