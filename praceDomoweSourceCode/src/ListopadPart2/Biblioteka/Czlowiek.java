package ListopadPart2.Biblioteka;

public class Czlowiek {
    protected String imie;
    protected String nazwisko;

    Czlowiek(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;

    }

    String imieNazwisDaj(){
       return this.imie + " " + this.nazwisko;
    }


}
