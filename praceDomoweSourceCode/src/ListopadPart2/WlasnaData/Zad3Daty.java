package ListopadPart2.WlasnaData;

import java.time.MonthDay;

public class Zad3Daty {
            //dokładnie takie zadanie z datami było już wcześniej wśród zadań domowych

    public static void zad3Start() {
        MojaData[] allDaty = podajDaty();
        System.out.println("  ");

        allDaty[4].pokazDateA();
        System.out.println(" ");
        allDaty[4].pokazDateB();
        System.out.println(" ");
        allDaty[4].pokazDateC();
        System.out.println(" ");
        allDaty[5].pokazDateC();


    }

    public static void zad4Start(){
        Wydarzenie[] allEvents = podajWydarzeniaOdTychDat( podajDaty() );

        System.out.println(" ");
        for (Wydarzenie event:allEvents) {
            System.out.println(event.dajOpis());
        }

        System.out.println("**********************");
        System.out.println(allEvents[0].nazwaWydarzenia + " wydarzyło się " + allEvents[0].ileLatOdTeraz() + " lat temu");
        System.out.println(allEvents[0].nazwaWydarzenia + " wydarzyło się " + allEvents[0].ileDniOdTeraz() + " dni temu");
        System.out.println(allEvents[0].nazwaWydarzenia + " wydarzyło się " + allEvents[0].ileMiesiecyOdTeraz() + " miesięcy temu");
        System.out.println(allEvents[1].nazwaWydarzenia + " wydarzyło się " + allEvents[1].ileLatOdTeraz() + " lat temu");
        System.out.println(allEvents[1].nazwaWydarzenia + " wydarzyło się " + allEvents[1].ileDniOdTeraz() + " dni temu");
        System.out.println(allEvents[2].nazwaWydarzenia + " wydarzyło się " + allEvents[2].ileMiesiecyOdTeraz() + " miesięcy temu");
        System.out.println(allEvents[6].nazwaWydarzenia + " wydarzyło się " + allEvents[6].ileLatOdTeraz() + " lat temu");
        System.out.println(allEvents[6].nazwaWydarzenia + " wydarzyło się " + allEvents[6].ileDniOdTeraz() + " dni temu");
        System.out.println(allEvents[6].nazwaWydarzenia + " wydarzyło się " + allEvents[6].ileMiesiecyOdTeraz() + " miesięcy temu");

        //System.out.println("********** \n");
        //System.out.println(MonthDay.now().getDayOfMonth());

    }

    private static Wydarzenie[] podajWydarzeniaOdTychDat(MojaData[] podajDaty) {
        Wydarzenie Grunwa = new Wydarzenie( podajDaty[0], "Bitwa pod Grunwaldem" );
        Wydarzenie Rzymupad = new Wydarzenie(podajDaty[1], "Upadek Cesarstwa Zachodniorzymskiego" );
        Wydarzenie magPowrot = new Wydarzenie( podajDaty[2], "Powrót załogi Ferdynanda Magellana z I podróży dookoła świata" );
        Wydarzenie magStart = new Wydarzenie( podajDaty[3], "Rozpoczęcie I podróży dookoła świata przez Ferdynanda Magellana" );
        Wydarzenie BizUpad = new Wydarzenie(podajDaty[4], "Upadek Cesarstwa Bizantyjskiego" );
        Wydarzenie LuthTez = new Wydarzenie( podajDaty[5], "Wywieszenie listy 95 tez przez Martina Ludera (pisane czasem jako Luthera)" );
        Wydarzenie wydarzTest = new Wydarzenie( podajDaty[6], "Test kiedy to było (16.3.2019)" );

        return new Wydarzenie[] {Grunwa, Rzymupad, magPowrot, magStart, BizUpad, LuthTez, wydarzTest};
    }


    private static MojaData[] podajDaty() {
        MojaData bitwaGrunwald = new MojaData( (byte)15 , (byte)7 ,1410);
        MojaData upadekRzymu = new MojaData( (byte)4 , (byte)9 ,476);
        MojaData powrotZalogiMagellanaZOplynieciaSwiata = new MojaData( (byte)6 , (byte)9 ,1522);
        MojaData startMagellanOplyniecieSwiata = new MojaData( (byte)10 , (byte)8 ,1519);       //1235 Pierwsze zjednoczenie Księstwa Litewskiego przez Mendoga
                                                                                                    //1009 Pierwsza Wzmianka o Litwie jako ziemi podzielonej między wiele Księstw
        MojaData upadekBizantium = new MojaData( (byte)29 , (byte)5 ,1453);
        MojaData wywieszenieTezLuthera = new MojaData( (byte)31 , (byte)10 ,1517);
        MojaData dataTest = new MojaData( (byte)16 , (byte)3 ,2019);


        return new MojaData[] {bitwaGrunwald, upadekRzymu, powrotZalogiMagellanaZOplynieciaSwiata, startMagellanOplyniecieSwiata, upadekBizantium, wywieszenieTezLuthera, dataTest};
    }


}
