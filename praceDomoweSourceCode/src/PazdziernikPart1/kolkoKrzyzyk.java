package PazdziernikPart1;

import java.util.Scanner;

public class kolkoKrzyzyk {

    public static void main(String[] args) throws InterruptedException {

        circleCross();


    }

    private static void circleCross() throws InterruptedException {
        //Wesja Kółka i Krzyżyk na konsole na 3x3
        Scanner podajDane = new Scanner(System.in);

        byte[] czyjePole = {0,0,0,0,0,0,0,0,0,0,2}; //0 = niczyje, 1 = gracz, 2 = komputer

        char znakGracz = 'o'; // ten będzie zamieniany przez wybór gracza
        char znakKomp = 'x'; // ten jest przeciwny

        boolean koniecGry = false;

        byte wyborPole;
        byte AIfocus = 9;
        byte AIrandPole = 1;

        System.out.println("Gra w Kółko i Krzyżyk");
        System.out.println("Wybierz czy grasz kółkami - wpisz 'o' ");
        System.out.println("Czy też krzyżykami - wpisz 'x' ");
        String coWybral = podajDane.next();
        while (!coWybral.equals("o") && !coWybral.equals("x")){
            System.out.println("Wpisz 'o dla kółek lub 'x' dla krzyżyków. ");
            coWybral = podajDane.next();
        }

        if (coWybral.equals("x")){
            znakGracz = coWybral.charAt(0);      //jeśli gracz wybierze odwrotnie niż default
            znakKomp = 'o';
        }


        System.out.println("Gra Rozpoczęta, grasz jako " + znakGracz + " : ");
        while (!koniecGry){     //Ta pętla to cała gra                              //MAIN GAME

            System.out.println("Wpisz numer pola byt postawić na nim swój znak: "); //Wyświetl i aktualizuj planszę
            System.out.println("------------------------------");
            for (int i = 0; i < 7; i+=3) {
                for (int j = 0; j < 3; j++) {
                    if (czyjePole[i+j]==1){                           //w czyje 1 = gracz 2 = komputer
                        System.out.print(znakGracz + "   |   ");
                    }else if (czyjePole[i+j]==2){
                        System.out.print(znakKomp + "   |   ");
                    }else {
                        System.out.print(i+j + "   |   ");
                    }

                }
                System.out.println("\n------------------------------");
            }       //WYSWIETLA PLANSZE

            wyborPole = 10; //RUCH GRACZA
            while (!podajDane.hasNextInt() && czyjePole[wyborPole]!=2) {        //Postaw kolejny znak (szuka inta)
                System.out.println("Wybierz Pole wpisując jego numer: ");
                podajDane.next();
            }
            wyborPole = podajDane.nextByte();

            czyjePole[wyborPole] = 1;       //bo 1 jest dla gracza a 2 dla komp


            //PONOWNE WYśWIETLENIE PLANSZY
            System.out.println("\n ------------------------------");
            for (int i = 0; i < 7; i+=3) {
                for (int j = 0; j < 3; j++) {
                    if (czyjePole[i+j]==1){                           //w czyje 1 = gracz 2 = komputer
                        System.out.print(znakGracz + "   |   ");
                    }else if (czyjePole[i+j]==2){
                        System.out.print(znakKomp + "   |   ");
                    }else {
                        System.out.print(i+j + "   |   ");
                    }

                }
                System.out.println("\n------------------------------");
            }       //WYSWIETLA PLANSZE


            koniecGry=true;                                 // Czy są jeszcze pola wolne?
            for (int i = 0; i < czyjePole.length; i++) {    //sprawdzenie czy jest jeszcze jakieś puste pole
                if (czyjePole[i]==0){
                    koniecGry=false;
                    break;
                }
            }

            if (!koniecGry){        //tu ruch komputera     //COMPUTER AI
                System.out.println("Ruch Komputera...");
                Thread.sleep(1600);      //czekaj 1.5 sekundy

                for (int i = 0; i <7; i+=3) {       //sprawdz poziom
                    if (czyjePole[i+2]==0 && czyjePole[i]==czyjePole[i+1] && czyjePole[i+1]!=0){
                            AIfocus = (byte) (i+2);
                            break;
                    }else if (czyjePole[i]==0 && czyjePole[i+1]==czyjePole[i+2] && czyjePole[i+2]!=0){
                            AIfocus = (byte) (i);
                            break;
                    }else if (czyjePole[i+1]==0 && czyjePole[i]==czyjePole[i+2] && czyjePole[i+2]!=0){
                            AIfocus = (byte) (i+1);
                            break;
                    }
                }
                for (int i = 0; i < 3; i++) {       //sprawdz pion
                    if (czyjePole[i+3]==0 && czyjePole[i]==czyjePole[i+6] && czyjePole[i+6]!=0){
                        AIfocus = (byte) (i+3);
                        break;
                    }else if (czyjePole[i]==0 && czyjePole[i+3]==czyjePole[i+6] && czyjePole[i+6]!=0){
                        AIfocus = (byte) (i);
                        break;
                    }else if (czyjePole[i+6]==0 && czyjePole[i]==czyjePole[i+3] && czyjePole[i+3]!=0){
                        AIfocus = (byte) (i+6);
                        break;
                    }
                }

                if (czyjePole[0]==0 && czyjePole[4]==czyjePole[8] && czyjePole[8]!=0) {     //sprawdz skosy
                    AIfocus = (byte) (0);
                }else if (czyjePole[8]==0 && czyjePole[4]==czyjePole[0] && czyjePole[0]!=0) {
                    AIfocus = (byte) (8);
                }else if (czyjePole[4]==0 && czyjePole[0]==czyjePole[8] && czyjePole[8]!=0) {
                    AIfocus = (byte) (4);

                }else if (czyjePole[2]==0 && czyjePole[4]==czyjePole[6] && czyjePole[6]!=0) {
                    AIfocus = (byte) (2);
                }else if (czyjePole[6]==0 && czyjePole[4]==czyjePole[2] && czyjePole[2]!=0) {
                    AIfocus = (byte) (6);
                }else if (czyjePole[4]==0 && czyjePole[6]==czyjePole[2] && czyjePole[2]!=0) {
                    AIfocus = (byte) (4);
                }
                //Do teraz zastanawia sie nad dobrym ruchem

                if (AIfocus<9){
                    czyjePole[AIfocus]=2;       //2 dla komputera

                }else {
                    AIrandPole = (byte) (Math.random() * 10);
                    while (AIrandPole >8 && czyjePole[AIrandPole]!=1 || AIrandPole<0 ){
                        AIrandPole = (byte) (Math.random() * 10);
                    }
                    czyjePole[AIrandPole]=2;     //2 dla komputera

                }
            }   //KONIEC AI COMPUTER


            for (int i = 0; i < 7; i+=3) {        //sprawdzenie czy ktos wygrał (kto wygrał)   //check poziom

                if (czyjePole[i]==czyjePole[i+1] && czyjePole[i+1]==czyjePole[i+2] && czyjePole[i]!=0){        //check poziom

                    if (czyjePole[i]==1){         //1 = gracz, 2 = komp  w czyje
                        System.out.println("Wygrały " + znakGracz + " Brawo Zwyciężyłeś ");
                    }else {
                        System.out.println("Wygrały " + znakKomp + " Zwyciężył Komputer ");
                    }
                    koniecGry=true;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {       //check pion

                if (czyjePole[j]==czyjePole[j+3] && czyjePole[j]==czyjePole[j+6] && czyjePole[j]!=0){  //check pion

                    if (czyjePole[j]==1){         //1 = gracz, 2 = komp  w czyje
                        System.out.println("Wygrały " + znakGracz + " Brawo Zwyciężyłeś ");
                    }else {
                        System.out.println("Wygrały " + znakKomp + " Zwyciężył Komputer ");
                    }
                    koniecGry=true;
                    break;

                }
            }
            if (czyjePole[0]==czyjePole[4] &&czyjePole[0]==czyjePole[8] && czyjePole[4]!=0 || czyjePole[2]==czyjePole[4] && czyjePole[4]==czyjePole[6] && czyjePole[4]!=0){  //check Przekątne czy win
                                                                                        //check Przekątne czy win
                if (czyjePole[4]==1){         //1 = gracz, 2 = komp  w czyje
                    System.out.println("Wygrały " + znakGracz + " Brawo Zwyciężyłeś ");
                }else {
                    System.out.println("Wygrały " + znakKomp + " Zwyciężył Komputer ");
                }
                koniecGry=true;

            }

            if (!koniecGry) {
                koniecGry = true;                                 // Czy są jeszcze pola wolne?
                for (int i = 0; i < czyjePole.length; i++) {    //sprawdzenie czy jest jeszcze jakieś puste pole
                    if (czyjePole[i] == 0) {
                        koniecGry = false;
                        break;
                    }
                }
            }

            if (!koniecGry) {
                System.out.println("\n \n \n Kolejna Runda \n");
            }
        }


        System.out.println("Koniec Gry");
    }


}
