package Grudzien.SwietaPaczkaZads;

import java.util.LinkedList;
import java.util.List;

public class NaglowekHTTP {
    private String nazwa;
    private List<Integer> wartosc;

    public String getNazwa() {
        return nazwa;
    }
    public List<Integer> getWartosc() {
        return wartosc;
    }

    public NaglowekHTTP(String nazwa, int wartosc) {
        this.nazwa = nazwa.replaceAll(":", "");;
        this.wartosc = new LinkedList<>();
        this.wartosc.add( wartosc );
    }

    public void plus( int wartosc ){
        this.wartosc.add( wartosc );
    }

    public void laczWartosc ( List<Integer> dawajTe){

        for (Integer ele: dawajTe) {
            if ( !this.wartosc.contains(ele) ){
                this.plus(ele);
            }
        }
    }

    @Override
    public boolean equals(Object drugi ){
        if (drugi instanceof NaglowekHTTP){
            NaglowekHTTP porown = (NaglowekHTTP) drugi;
            return this.getNazwa().equals( porown.getNazwa() );

        }else {
            return false;
        }
    }


    @Override
    public String toString(){
        StringBuilder dopiszWartosci = new StringBuilder();
        for (Integer ele: this.wartosc) {

            if (this.wartosc.indexOf(ele) == this.wartosc.size()-1 ){
                dopiszWartosci.append(ele);
            }else {
                dopiszWartosci.append(ele).append(",");
            }
        }

        return this.nazwa+":"+dopiszWartosci+"\n";
    }









}
