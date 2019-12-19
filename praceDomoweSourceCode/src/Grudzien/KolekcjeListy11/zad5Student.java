package Grudzien.KolekcjeListy11;

public class zad5Student {
    private int nr_Indeksu;
    private String imie;
    private String nazwisko;
    public enum Plec{Mezczyzna, Kobieta, Nijaka};
    private Plec takaPlec;

    public zad5Student(int nr_Indeksu, String imie, String nazwisko, Plec taka) {
        this.nr_Indeksu = nr_Indeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.takaPlec = taka;
    }


    public int getNr_Indeksu() {
        return nr_Indeksu;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public Plec getTakaPlec() {
        return takaPlec;
    }

    @Override
    public String toString(){
        return this.getImie() + " " + this.getNazwisko() + " nr." + this.getNr_Indeksu() + " jest " + this.getTakaPlec();
    }


}
