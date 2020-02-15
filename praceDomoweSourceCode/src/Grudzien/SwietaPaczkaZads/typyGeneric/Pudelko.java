package Grudzien.SwietaPaczkaZads.typyGeneric;

class Pudelko<T> {
    private T zawartosc;

    public Pudelko(T zawartosc) {
        this.zawartosc = zawartosc;
    }
    public Pudelko(){

    }

    public T getZawartosc() {
        return zawartosc;
    }
    public void setZawartosc(T zawartosc) {
        this.zawartosc = zawartosc;
    }

    public boolean czyPuste( ){
        return this.zawartosc == null;
    }

    @Override
    public String toString(){
        return (czyPuste()) ? ( "Pudełko jest Puste" ) : (this.getZawartosc().toString());
    }



}
