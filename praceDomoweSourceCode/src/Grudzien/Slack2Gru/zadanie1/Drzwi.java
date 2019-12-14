package Grudzien.Slack2Gru.zadanie1;

public class Drzwi extends PrzejsciaWMurach implements IOtwieralny, IZamykalny{


    @Override
    public void otwórz() {
        this.czyOtwartePrzejscie = true;
    }

    @Override
    public void zamknij() {
        this.czyOtwartePrzejscie = false;
    }




}
