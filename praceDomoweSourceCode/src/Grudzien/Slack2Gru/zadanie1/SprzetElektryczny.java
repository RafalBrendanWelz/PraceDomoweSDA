package Grudzien.Slack2Gru.zadanie1;

public abstract class SprzetElektryczny implements IWłączalny, IWyłączalny{
    private boolean czyOn;

    @Override
    public boolean czyWłączony(){
        return czyOn;
    }

    @Override
    public void włącz(){
        czyOn = true;
    }

    @Override
    public void wyłącz(){
        czyOn = false;
    }


}
