package Grudzien.Slack2Gru.zadanie7;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Autostrada {
    private List<PojazdInfo> obecnePojazdy;
    private static LocalDateTime obecnyCzas;


    public Autostrada() {
        obecnePojazdy = new ArrayList<>();
        obecnyCzas = LocalDateTime.of(0, 1, 1, 0, 0, 0);
    }

    public List<PojazdInfo> getObecnePojazdy() {
        return obecnePojazdy;
    }
    public String opiszCzas(){
        return obecnyCzas.toString();
    }

    public void wjazdNewAuta( PojazdInfo ktoWjezdza){
        if ( obecnePojazdy.contains( ktoWjezdza ) ){        //tu mógłby być specjalny, własny wyjątek zamiast tego ale poco
            System.out.println("Samochód z numerem rejestr: " + ktoWjezdza.getNumerRejestrac() + " jest już na autostradzie");
        }else {
            ktoWjezdza.setGodzWjazdu( obecnyCzas );
            this.obecnePojazdy.add( ktoWjezdza );
        }
        trocheCzasuUplynelo();
    }

    public void spyPojazdzAutostrady(String numer_rejestracyjny){
        obecnePojazdy.forEach(t -> {
            if ( t.getNumerRejestrac().equals(numer_rejestracyjny) ) {
                t.wypiszInfo();
                System.out.println(" obecnie jedzie po autostradzie");
            }
        } );
        trocheCzasuUplynelo();
    }

    public static void trocheCzasuUplynelo(){
        Random losujSekundy = new Random();
        obecnyCzas = obecnyCzas.plusSeconds( losujSekundy.nextInt(13 - 6) + 6 );
    }

    public void wyjazdAuta ( String numer_rejestracyjny){
        PojazdInfo tenUsunac = null;

        for (PojazdInfo t: obecnePojazdy) {
            if (t.getNumerRejestrac().equals( numer_rejestracyjny ) ){
                System.out.print("Samochód " + t.getJaki() + " " + t.getNumerRejestrac() + " wyjeżdża z autostrady. ");

                Duration ileJechal = Duration.between( t.getGodzWjazdu(), obecnyCzas );
                System.out.print("Jechał przez " + ileJechal + " minut/sekund");

                double koszt = ileJechal.toMinutes() * t.getJaki().oplataZaMinute ;
                System.out.println(" i musi zapłacić " + koszt + " zł");
                tenUsunac = t;
            }
        }

        try {
            obecnePojazdy.remove( tenUsunac );
        }catch (NullPointerException nieMa){
            System.out.println("Na autostradzie nie było takiego pojazdu z numerem " + numer_rejestracyjny);
        }
        trocheCzasuUplynelo();
    }




}
