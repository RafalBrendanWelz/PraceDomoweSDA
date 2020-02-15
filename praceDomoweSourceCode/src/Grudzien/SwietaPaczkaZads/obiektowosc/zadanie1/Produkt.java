package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie1;

class Produkt {

    private String nazwaProdukt;
    private double cenaProdukt;        //Netto - czyli bez dodania podatku
    private podatekProdukt jakiPodat;

    public String getNazwaProdukt() {
        return nazwaProdukt;
    }
    public void setNazwaProdukt(String nazwaProdukt) {
        this.nazwaProdukt = nazwaProdukt;
    }
    public double getCenaProdukt() {
        return cenaProdukt;
    }
    public void setCenaProdukt(double cenaProdukt) {
        this.cenaProdukt = cenaProdukt;
    }
    public podatekProdukt getJakiPodat() {
        return jakiPodat;
    }
    public void setJakiPodat(podatekProdukt jakiPodat) {
        this.jakiPodat = jakiPodat;
    }

    public Produkt(String nazwaProdukt, double cenaProdukt, podatekProdukt jakiPodat) {
        this.nazwaProdukt = nazwaProdukt;
        this.cenaProdukt = cenaProdukt;
        this.jakiPodat = jakiPodat;
    }

    public double podajCeneBrutto(){
        return this.cenaProdukt * this.jakiPodat.getPrzelicznikProcent();
    }








}
