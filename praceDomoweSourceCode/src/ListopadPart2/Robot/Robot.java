package ListopadPart2.Robot;

public class Robot {
    private int procentBaterii;
    private String nazwa;
    private boolean czyON;
    protected Pozycja[] pozycja = new Pozycja[5];       //[0] lewareka [1] prawareka [2] lewanoga [3] prawanoga [4] skok

    public int getProcentBaterii() {
        return procentBaterii;
    }
    public String getNazwa() {
        return nazwa;
    }
    public boolean isCzyON() {
        return czyON;
    }

    public Robot(String nazwa) {
        this.procentBaterii = 100;
        this.nazwa = nazwa;
        this.czyON = true;

        for (int i = 0; i < 5; i++) {
            pozycja[i] = Pozycja.P0;
        }
    }

    public void naladujRobota(){
        if (!this.czyON && this.procentBaterii <=70){
            this.procentBaterii += 30;
        }else if (!this.czyON){
            this.procentBaterii = 100;
        }

    }

    public void wlaczRobota(){
        this.czyON = true;
    }

    public void wylaczRobota(){
        this.czyON = false;
    }

    public void ruch( RuchRobota jakiRuch ){
        if (this.czyON && this.procentBaterii > jakiRuch.wymogiBaterii){
            this.procentBaterii -= jakiRuch.wymogiBaterii;
            wykonajRuch(jakiRuch);

        }else if (this.czyON && this.procentBaterii == jakiRuch.wymogiBaterii){
            this.procentBaterii -= jakiRuch.wymogiBaterii;
            this.czyON = false;
            wykonajRuch(jakiRuch);

        }else {
            System.out.println("NIE MOŻE WYKONAC RUCHU, SPRÓBUJ DOŁADOWAC LUB WŁĄCZYĆ");
        }

    }

    private void wykonajRuch (RuchRobota jakiRuch){
        if (jakiRuch == RuchRobota.RUCH_REKA_LEWA){
            ruchLewaR();
        }else if (jakiRuch == RuchRobota.RUCH_REKA_PRAWA){
            ruchPrawaR();
        }else if (jakiRuch == RuchRobota.KROK_LEWA){
            ruchLewaN();
        }else if (jakiRuch == RuchRobota.KROK_PRAWA){
            ruchPrawaN();
        }else {
            ruchSkok();
        }
    }

    private void ruchSkok() {
        if (this.pozycja[4] == Pozycja.P2){
            this.pozycja[4] = Pozycja.P0;
        }else {
            this.pozycja[4] = Pozycja.values()[this.pozycja[4].poz+1];
        }
    }

    private void ruchPrawaN() {
        if (this.pozycja[3] == Pozycja.P2){
            this.pozycja[3] = Pozycja.P0;
            zadRobot.odleglosc++;
        }else {
            this.pozycja[3] = Pozycja.values()[this.pozycja[3].poz+1];
        }
    }

    private void ruchLewaN() {
        if (this.pozycja[2] == Pozycja.P2){
            this.pozycja[2] = Pozycja.P0;
            zadRobot.odleglosc--;
        }else {
            this.pozycja[2] = Pozycja.values()[this.pozycja[2].poz+1];
        }
    }

    private void ruchPrawaR() {
        if (this.pozycja[1] == Pozycja.P2){
            this.pozycja[1] = Pozycja.P0;
        }else {
            this.pozycja[1] = Pozycja.values()[this.pozycja[1].poz+1];
        }
    }

    private void ruchLewaR() {
        if (this.pozycja[0] == Pozycja.P2){
            this.pozycja[0] = Pozycja.P0;
        }else {
            this.pozycja[0] = Pozycja.values()[this.pozycja[0].poz+1];
        }
    }









}
