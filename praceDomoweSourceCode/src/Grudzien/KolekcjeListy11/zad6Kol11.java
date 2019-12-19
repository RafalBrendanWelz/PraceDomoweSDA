package Grudzien.KolekcjeListy11;

import java.util.ArrayList;
import java.util.List;

public class zad6Kol11 {

    public static void main(String[] args) {
        //start aplikacji z dziennikiem i studentami
        zad6Dziennik jedDziennik = new zad6Dziennik("Dziennik Rocznika 1 Kierunku GryiZabawy");


        jedDziennik.dodajStudenta( dajStudenci().get(4) , dajStudenci().get(5) , dajStudenci().get(0) );

        for (zad6Student stud: dajStudenci()) {
            jedDziennik.dodajStudenta( stud );
        }

        System.out.println( jedDziennik.getListaStudentow() );
        System.out.println("\n************\nSortowanie");
        jedDziennik.posortujListe();
        System.out.println(jedDziennik.getListaStudentow());
        System.out.println("\n**************\nZ Płcią wypisanie\n");
        System.out.println(jedDziennik.podajTekstStudPlusPlec());

    }

    public static List<zad6Student> dajStudenci(){
        List<zad6Student> wynik = new ArrayList<>();
        wynik.add(new zad6Student(123, "Jan", "Kowalski", zad6Student.Plec.Mezczyzna) );
        wynik.add(new zad6Student(11, "Harry", "Garncarz", zad6Student.Plec.Mezczyzna) );
        wynik.add(new zad6Student(66, "Roger", "Roger Roger", zad6Student.Plec.Mezczyzna) );
        wynik.add(new zad6Student(785, "Katarzyna", "Urszulowiczarównoskialeńskogariczońskarowicz", zad6Student.Plec.Kobieta) );
        wynik.add(new zad6Student(45, "Basia", "Przebrzydlo", zad6Student.Plec.Nijaka) );
        wynik.add(new zad6Student(43, "Małgosia", "Nowak", zad6Student.Plec.Kobieta) );
        wynik.add(new zad6Student(13, "Alicja", "Madness", zad6Student.Plec.Kobieta) );
        wynik.add(new zad6Student(20, "Daria", "Skrzyniecka", zad6Student.Plec.Kobieta) );

        return wynik;
    }


}
