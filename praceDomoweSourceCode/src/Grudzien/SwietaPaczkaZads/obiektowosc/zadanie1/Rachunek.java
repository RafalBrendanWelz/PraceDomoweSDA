package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Rachunek {
    private List<Produkt> listaProduktow;
    private double total = 0.0;

    public List<Produkt> getListaProduktow() {
        return listaProduktow;
    }

    public Rachunek() {
        this.listaProduktow = new LinkedList<>();
    }

    public Rachunek(Produkt... takie) {
        this.listaProduktow = new LinkedList<>();
        this.listaProduktow.addAll(Arrays.asList(takie));
    }

    public void dodajProdukt ( Produkt ten){
        this.listaProduktow.add(ten);
    }

    public void wypiszRachunek(){
        for (Produkt ele: this.listaProduktow) {
            this.total+= ele.podajCeneBrutto();
            System.out.println(ele.getNazwaProdukt() + " " + ele.getCenaProdukt() + " zł netto. " + ele.podajCeneBrutto() + " brutto.   łącznie = " + total + " zł");
        }
    }

    public double podsumujNetto(){
        double nettoTotal = 0.0;
        return zsumujKwote(nettoTotal, 0, true);
    }

    public double podsumujBrutto(){
        double bruttoTotal = 0.0;
        return zsumujKwote(bruttoTotal, 0, false);
    }

    public double zwrocWartoscKwotePodatku(){
        double bruttoTotal = 0.0, nettoTotal = 0.0;
        return zsumujKwote(bruttoTotal, 0, false) - zsumujKwote(nettoTotal, 0, true);
    }

    private double zsumujKwote(double sumaCen, int ktore, boolean czyNetto){
        if (czyNetto){
            sumaCen+= this.listaProduktow.get(ktore).getCenaProdukt() ;
        }else {
            sumaCen+= this.listaProduktow.get(ktore).podajCeneBrutto() ;
        }
        return (ktore == this.listaProduktow.size()-1 ) ? (sumaCen ) : ( zsumujKwote(sumaCen, ++ktore, czyNetto) );
    }





}
