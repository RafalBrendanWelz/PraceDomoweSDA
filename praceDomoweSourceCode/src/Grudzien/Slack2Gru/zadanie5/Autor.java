package Grudzien.Slack2Gru.zadanie5;

public class Autor {
    private String Imie;
    private String Nazwisko;

    public Autor(String imie, String nazwisko) {
        Imie = imie;
        Nazwisko = nazwisko;
    }

    public String getPrzedstaw() {
        return this.Imie + " " + this.Nazwisko;
    }

    public String getNazwisko() {
        return Nazwisko;
    }


}
