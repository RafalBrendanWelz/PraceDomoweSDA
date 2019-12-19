package Grudzien.KolekcjeListy11;

import java.util.List;

public class zad6Student implements Comparable{
    private int nr_Indeksu;
    private List<Double> listaOcen;
    private String imie;
    private String nazwisko;
    public enum Plec{Mezczyzna, Kobieta, Nijaka};
    private Plec takaPlec;

    public zad6Student(int nr_Indeksu, String imie, String nazwisko, Plec taka) {
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
    public List<Double> getListaOcen() {
        return listaOcen;
    }
    public void setListaOcen(List<Double> listaOcen) {
        this.listaOcen = listaOcen;
    }

    @Override
    public String toString(){
        return this.getImie() + "_" + this.getNazwisko() + " nr." + this.getNr_Indeksu();
    }

    @Override
    public boolean equals(Object tenPorownaj) {
        if (this == tenPorownaj) {
            return true;
        }
        if (tenPorownaj instanceof zad6Student) {
            zad6Student tenDrugi = (zad6Student) tenPorownaj;
            return this.nr_Indeksu == tenDrugi.nr_Indeksu;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if ( this.equals(o) ){
            return 0;
        }

        if (o instanceof zad6Student){
            zad6Student porowZTym = (zad6Student) o;

           if (this.getNr_Indeksu() > porowZTym.getNr_Indeksu() ){
               return 1;
           }else {
               return -1;
           }
        }

        return 0;
    }



}
