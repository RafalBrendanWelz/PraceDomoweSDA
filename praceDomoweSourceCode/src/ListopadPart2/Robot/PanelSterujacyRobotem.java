package ListopadPart2.Robot;

import ListopadPart2.KlasyFeudalne.Peasant;

import java.util.Scanner;

public class PanelSterujacyRobotem {
    protected Robot body;
    private static char wybranaKonczyna = '0';

    public PanelSterujacyRobotem(Robot kimSteruje) {
        this.body = kimSteruje;
    }

    private void nowyRuch(){
        zadRobot.rysujUIRobota( this );
        zadRobot.rysujRobota( this );
        for (int i = 0; i < 56; i++) {
            System.out.print( '█' );
        }
        System.out.println("X");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
        Akcje();
    }


    public void Akcje(){
        char wybor;

        System.out.println("Sterujesz robotem " + body.getNazwa() + " co chcesz zrobić:?");
        System.out.println("Wpisz z by naładować o 30%");
        System.out.println("Wpisz x by włączyć / wyłączyć");
        System.out.println("Wpisz q by zakończyć program");

        if (wybranaKonczyna == '0'){
            System.out.println("Wpisz 1 by wybrac ruch ręką");
            System.out.println("Wpisz 2 by wybrac ruch nogą");
            wybor = scannerWyb();
            zrobRuch( wybor, 0);

        }else if (wybranaKonczyna == '1'){  //reka
            System.out.println("Wpisz 2 by wybrac ruch nogą");
            System.out.println("Wpisz a by ruszyc Lewa reka");
            System.out.println("Wpisz d by ruszyc Prawą ręką");
            wybor = scannerWyb();
            zrobRuch( wybor, 1);

        }else if (wybranaKonczyna == '2'){  //noga
            System.out.println("Wpisz 1 by wybrac ruch ręką");
            System.out.println("Wpisz a by ruszyc Lewą nogą");
            System.out.println("Wpisz d by ruszyc Prawą nogą");
            System.out.println("Wpisz w by Skoczyc do góry");
            wybor = scannerWyb();
            zrobRuch( wybor, 2);

        }

    }

    private void zrobRuch( char wybor, int jakieOpcje) {
        if (wybor == 'z'){
            body.naladujRobota();
        }else if (wybor == 'x'){
            if (body.isCzyON()){
                body.wylaczRobota();
            }else {
                body.wlaczRobota();
            }
        }else{
            switch (jakieOpcje){
                case 0:{
                    if (wybor == '1') {    //reka
                       wybranaKonczyna = '1';
                    }else if (wybor == '2') {   //noga
                        wybranaKonczyna = '2';
                    }
                    break;

                } case 1:{
                    if (wybor == '2') {
                        wybranaKonczyna = '2';
                    }else if (wybor == 'a') {
                       body.ruch(RuchRobota.RUCH_REKA_LEWA);
                    }else if (wybor == 'd') {
                        body.ruch(RuchRobota.RUCH_REKA_PRAWA);
                    }
                    break;
                } case 2:{
                    if (wybor == '1') {
                        wybranaKonczyna = '1';
                    }else if (wybor == 'a') {
                        body.ruch(RuchRobota.KROK_LEWA);
                    }else if (wybor == 'd') {
                        body.ruch(RuchRobota.KROK_PRAWA);
                    }else if (wybor == 'w') {
                        body.ruch(RuchRobota.SKOK);
                    }
                    break;
                }
            }
        }

        if (wybor != 'q'){
            nowyRuch();
        }
    }


    private static char scannerWyb() {
        Scanner decyduj = new Scanner(System.in);
        char coZdec = decyduj.next().charAt(0);

        if (coZdec > 65 && coZdec < 90 ){
            coZdec += 32;
        }else if (coZdec == 64){
            coZdec = 50;
        }else if (coZdec == 33) {
            coZdec = 49;
        }

        return coZdec;
    }


}
