package Grudzien.Slack2Gru.zadanie1;

public class Okno extends PrzejsciaWMurach implements IOtwieralny, IZamykalny{


    @Override
    public void otwórz() {
        this.czyOtwartePrzejscie = true;
    }

    @Override
    public void zamknij() {
        this.czyOtwartePrzejscie = false;
    }




}
