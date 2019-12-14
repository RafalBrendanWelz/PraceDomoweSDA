package Grudzien.Slack2Gru.zadanie1;

abstract class PojazdySilnikowe implements IWłączalny, IWyłączalny{
    private boolean czySilnikOn;

    @Override
    public boolean czyWłączony(){
        return czySilnikOn;
    }

    @Override
    public void włącz(){
       czySilnikOn = true;
    }

    @Override
    public void wyłącz(){
        czySilnikOn = false;
    }



}
