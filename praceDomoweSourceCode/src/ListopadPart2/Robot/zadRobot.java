package ListopadPart2.Robot;

public class zadRobot {
    static int odleglosc = 50;

    public static void zad7Start() {
        Robot Jantos = new Robot("Jantos XS-3000");
        PanelSterujacyRobotem moveJantos = new PanelSterujacyRobotem(Jantos);

        singleTurn( moveJantos );

    }

    private static void singleTurn(PanelSterujacyRobotem gracz) {
        rysujUIRobota( gracz );
        rysujRobota( gracz );
        for (int i = 0; i < 56; i++) {
            System.out.print( '█' );
        }
        System.out.println("X");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
        gracz.Akcje();
    }

    protected static void rysujRobota(PanelSterujacyRobotem gracz) {
        System.out.println(" \n");
        if (gracz.body.pozycja[4]==Pozycja.P0){
            System.out.print(" \n \n");
        }else if(gracz.body.pozycja[4]==Pozycja.P1){
            System.out.print(" \n");
        }else {
            System.out.print(" ");
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 0; j <= odleglosc; j++) {
                System.out.print(" ");
            }
            if (i==1){
                if (gracz.body.pozycja[0]==Pozycja.P0){
                    System.out.print(" o");
                }else if (gracz.body.pozycja[0]==Pozycja.P1){
                    System.out.print("_o");
                }else if (gracz.body.pozycja[0]==Pozycja.P2){
                    System.out.print((char)92 + "o");
                }

                if (gracz.body.pozycja[1]==Pozycja.P0){
                    System.out.println(" ");
                }else if (gracz.body.pozycja[1]==Pozycja.P1){
                    System.out.println("_");
                }else if (gracz.body.pozycja[1]==Pozycja.P2){
                    System.out.println("/");
                }

            }else if (i==2){
                if (gracz.body.pozycja[0]==Pozycja.P0){
                    System.out.print("/||");
                }else {
                    System.out.print(" ||");
                }

                if (gracz.body.pozycja[1]==Pozycja.P0){
                    System.out.println((char)92);
                }else {
                    System.out.println(" ");
                }

            }else {
                if (gracz.body.pozycja[2]==Pozycja.P0){
                    System.out.print(" |");
                }else if (gracz.body.pozycja[2]==Pozycja.P1){
                    System.out.print(" /");
                }else if (gracz.body.pozycja[2]==Pozycja.P2){
                    System.out.print("/");
                }

                if (gracz.body.pozycja[3]==Pozycja.P0){
                    System.out.println("|");
                }else if (gracz.body.pozycja[3]==Pozycja.P1){
                    System.out.println((char)92);
                }else if (gracz.body.pozycja[3]==Pozycja.P2){
                    System.out.println(" " + (char)92);
                }
            }
        }

    }

    protected static void rysujUIRobota(PanelSterujacyRobotem gracz) {
        if (gracz.body.isCzyON()){
            System.out.println("Twój Robot: " + gracz.body.getNazwa() + " jest włączony");
        }else {
            System.out.println("Twój Robot: " + gracz.body.getNazwa() + " jest WYłączony");
        }
        System.out.println("Bateria: " + gracz.body.getProcentBaterii() );
    }


}
