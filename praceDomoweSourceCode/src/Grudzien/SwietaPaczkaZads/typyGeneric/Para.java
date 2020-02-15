package Grudzien.SwietaPaczkaZads.typyGeneric;

class Para<T,U> {
    private T prawy;
    private U lewy;

    public T getPrawy() {
        return prawy;
    }
    public void setPrawy(T prawy) {
        this.prawy = prawy;
    }
    public U getLewy() {
        return lewy;
    }
    public void setLewy(U lewy) {
        this.lewy = lewy;
    }

    public Para(T prawy, U lewy) {
        this.prawy = prawy;
        this.lewy = lewy;
    }
    public Para(T tylkoPrawy){
        this.prawy = tylkoPrawy;
    }
    public Para(){

    }

    @Override
    public String toString(){
        return this.getPrawy().toString() + "  +  " + this.getLewy().toString();
    }


}
