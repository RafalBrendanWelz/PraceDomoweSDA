package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie4;

import java.time.LocalDateTime;

class Wiadomosc implements Comparable{
    private String trescWiadom;
    private LocalDateTime dataOtrzymania;
    private String tytul;
    private static final int maxDlugTytul = 80;
    private boolean odczytana;

    public String getTrescWiadom() {
        return trescWiadom;
    }
    public void setTrescWiadom(String trescWiadom) {
        this.trescWiadom = trescWiadom;
    }
    public LocalDateTime getDataOtrzymania() {
        return dataOtrzymania;
    }
    public void setDataOtrzymania(LocalDateTime dataOtrzymania) {
        this.dataOtrzymania = dataOtrzymania;
    }
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    public void odczytales(){
        this.odczytana = true;
    }
    public boolean czyOdczytana() {
        return odczytana;
    }

    public Wiadomosc(String trescWiadom, LocalDateTime dataOtrzymania, String tytul) {
        this.trescWiadom = trescWiadom;
        this.dataOtrzymania = dataOtrzymania;
        this.odczytana = false;

        StringBuilder dajTytu = new StringBuilder();
        for (int i = 0; i < maxDlugTytul && i < tytul.length() ; i++) {
            dajTytu.append(tytul.charAt(i) );
        }
        this.tytul = dajTytu.toString();
    }


    @Override
    public int compareTo(Object o) {
        if (o == this){
            return 0;
        }

        if (o instanceof Wiadomosc){
            Wiadomosc druga = (Wiadomosc) o;
            if ( this.dataOtrzymania.isAfter(druga.dataOtrzymania) ){
                return 1;
            }else {
                return -1;
            }
        }

        return 0;
    }

    @Override
    public String toString (){
        return this.dataOtrzymania.getYear() + "." + this.dataOtrzymania.getMonthValue() + "." + this.dataOtrzymania.getDayOfMonth() + " " + this.dataOtrzymania.getHour()
                + ":" + this.dataOtrzymania.getMinute() + "." + this.dataOtrzymania.getSecond() + "  ->  " + this.tytul;
    }

    public String StringZTresc(){
        return this.dataOtrzymania.getYear() + "." + this.dataOtrzymania.getMonthValue() + "." + this.dataOtrzymania.getDayOfMonth() + " " + this.dataOtrzymania.getHour()
                + ":" + this.dataOtrzymania.getMinute() + "." + this.dataOtrzymania.getSecond() + "  ->  " + this.tytul + ": \n"
                + this.trescWiadom + " \n";
    }



}
