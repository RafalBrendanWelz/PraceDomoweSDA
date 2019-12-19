package Grudzien.KolekcjeListy11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zad6Dziennik {
    private String nazwaGrupyDziennika;
    private List<zad6Student> listaStudentow = new ArrayList<>();

    public String getNazwaGrupyDziennika() {
        return nazwaGrupyDziennika;
    }
    public List<zad6Student> getListaStudentow() {
        return listaStudentow;
    }
    public String podajTekstStudPlusPlec() {
        StringBuilder wynik = new StringBuilder();
        for (zad6Student stud: this.listaStudentow) {
            wynik.append(stud + stud.getTakaPlec().toString() + " , " );
        }

        return wynik.toString();
    }


    public zad6Dziennik(String nazwaDziennika) {
        this.nazwaGrupyDziennika = nazwaDziennika;
    }

    public void dodajStudenta( zad6Student... tych ){
        this.listaStudentow.addAll(Arrays.asList(tych) );
    }

    public void usunStudenta ( zad6Student... tych ){
        for (zad6Student stud: this.listaStudentow) {
            for (zad6Student zTym: tych) {
                if ( stud.equals(zTym) ){
                    this.listaStudentow.remove(stud);
                    break;
                }
            }

        }
    }

    public void usunStudenta ( String... zTymiNumerami ){
        for (zad6Student stud: this.listaStudentow) {
            for (String zTym: zTymiNumerami) {
                if ( stud.getNr_Indeksu() == Integer.parseInt( zTym ) ){
                    this.listaStudentow.remove(stud);
                    break;
                }
            }

        }
    }

    public List<zad6Student> wybierzIDajStudenta(String... zTymNumerami ){
        List<zad6Student> wybrani = new ArrayList<>();

        for (zad6Student stud: this.listaStudentow) {
            for (String tego: zTymNumerami) {

                if ( stud.getNr_Indeksu() == Integer.parseInt( tego ) ){
                    wybrani.add( stud );
                }
            }
        }
        return wybrani;
    }

    public double podajSredniaStudenta (String zTymNumerem){

        for (zad6Student stud: this.listaStudentow) {
            if ( stud.getNr_Indeksu() == Integer.parseInt( zTymNumerem ) ){

                return stud.getListaOcen().stream().mapToDouble(t -> t).sum() ;
                //return stud.getListaOcen().stream().mapToDouble(Double::doubleValue).sum() ;
            }
        }
        return 0;
    }

    public List<zad6Student> podajZagrozonych (){
        List<zad6Student> toCiTutaj = new ArrayList<>();

        for (zad6Student stud: this.listaStudentow) {

            if (podajSredniaStudenta( Integer.toString( stud.getNr_Indeksu()) ) < 2  ){
                toCiTutaj.add(stud);
            }
        }

        return toCiTutaj;
    }

    public void posortujListe(){
        this.listaStudentow.sort(zad6Student::compareTo);
    }

    public void dodajLubUsunOcenyStud(zad6Student temuStudentowi, boolean czyDodacjeslifalsetoUsunac, double... teOceny ){
        for (zad6Student stud: this.listaStudentow) {
            if (stud.getNr_Indeksu() == temuStudentowi.getNr_Indeksu() ){
                List<Double> ocenyJego = new ArrayList<>(stud.getListaOcen());
                for (double ocena: teOceny) {
                    if ( czyDodacjeslifalsetoUsunac ){
                        ocenyJego.add( ocena );
                    }else {
                        ocenyJego.remove( ocena );
                    }

                }
                stud.setListaOcen( ocenyJego );
                break;
            }
        }

    }







}
