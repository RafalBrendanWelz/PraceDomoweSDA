package Grudzien.Slack2Gru.zadanie1;

class Samochod extends PojazdySilnikowe implements IOtwieralny, IZamykalny{
    private boolean czyOtwartePrzejscie;

    @Override
    public void otwórz() {
        this.czyOtwartePrzejscie = true;
    }

    @Override
    public void zamknij() {
        this.czyOtwartePrzejscie = false;
    }

    @Override
    public boolean czyOtwarty() {
        return this.czyOtwartePrzejscie;
    }





}
