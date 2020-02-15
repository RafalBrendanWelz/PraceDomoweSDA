package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie3;

import java.time.LocalTime;

class Zgloszenie {
    private typZgloszenia jakie;
    private String trescZgloszenia;
    private LocalTime czasZgloszenia;
    private String miejsceZglosz;
    private String ID;

    public Zgloszenie(typZgloszenia jakie, String trescZgloszenia, miejsceZglosz miasto , String adres, LocalTime kiedy) {
        this.jakie = jakie;
        this.trescZgloszenia = trescZgloszenia;
        this.czasZgloszenia = kiedy;
        this.miejsceZglosz = miasto.getMiasto()+":"+adres;
        this.ID = String.valueOf(miasto.getNumerID()) + kiedy.getHour() + kiedy.getMinute() + kiedy.getSecond();
    }

    public typZgloszenia getJakie() {
        return jakie;
    }
    public String getTrescZgloszenia() {
        return trescZgloszenia;
    }
    public LocalTime getCzasZgloszenia() {
        return czasZgloszenia;
    }
    public String getMiejsceZglosz() {
        return miejsceZglosz;
    }
    public String getID() {
        return ID;
    }

    @Override
    public String toString(){
        return this.ID + " Zgłoszenie typu: " + this.getJakie().getNazwa() + " zgłoszone o " + this.czasZgloszenia + " w " + this.miejsceZglosz + " \n     " + this.trescZgloszenia + " \n\n" ;
    }





}
