package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Klient implements Comparable{
    private String imie;
    private LocalTime czasPrzybycia;
    private boolean priorytetowy;

    public String getImie() {
        return imie;
    }
    public LocalTime getCzasPrzybycia() {
        return czasPrzybycia;
    }
    public boolean isPriorytetowy() {
        return priorytetowy;
    }

    public Klient(String imie, LocalTime czasPrzybycia, boolean priorytetowy) {
        this.imie = imie;
        this.czasPrzybycia = czasPrzybycia;
        this.priorytetowy = priorytetowy;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        if ( this.priorytetowy ){
            return this.imie + " " + this.czasPrzybycia.format( dtf ) + " P " ;
        }else {
            return this.imie + " " + this.czasPrzybycia.format( dtf ) + "   " ;
        }
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof Klient){
            Klient drugi = (Klient) o;
            LocalTime czasPierw = (this.priorytetowy) ? (this.czasPrzybycia.minusSeconds(10)) : (this.czasPrzybycia);
            LocalTime czasDrug = (drugi.priorytetowy) ? (drugi.czasPrzybycia.minusSeconds(10)) : (drugi.czasPrzybycia);
            return (czasPierw.isAfter(czasDrug) ) ? (1) : (-1);
        }
        return 0;
    }




}
