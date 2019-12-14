package Grudzien.Slack2Gru.zadanie1;

abstract class PrzejsciaWMurach extends Mury implements IOpenable{
    protected boolean czyOtwartePrzejscie;


    @Override
    public boolean czyOtwarty() {
        return czyOtwartePrzejscie;
    }


}
