package Grudzien.Lotto;

public class zad3Lotto {

    public static void zad3Start (){
        System.out.println("Gra w Lotto, do wygrania możliwe kwoty (ustawione w zależnośći od ilości zgadniętych cyfr)");
        System.out.println(LottoGra.pokazMozliweNagrody());
        System.out.println("*******************");

        System.out.println( LottoGra.zagraj() );
    }





}
