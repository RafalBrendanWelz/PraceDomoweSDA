package ListopadPart2.KlasyFeudalne;

public abstract class Citizen {
    String imie;
    String klasa;
    boolean maPrawoGlosu;
    char plec;

    public Citizen(String imie, boolean maPrawoGlosu, char plec) {
        this.imie = imie;
        this.maPrawoGlosu = maPrawoGlosu;
        this.plec = plec;
    }

    public String przedstawSie(){
        return this.klasa.toUpperCase() + ": " + this.imie + " " ;
    }




}
