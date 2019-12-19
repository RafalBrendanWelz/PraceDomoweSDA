package Grudzien.KolekcjeListy11;

import java.util.ArrayList;
import java.util.List;

public class zad5Kol11 {

    public static void zad5Main(){
        List<zad5Student> studenci = dajStudentow();

        System.out.println(studenci + "\n");
        for (zad5Student ele: studenci) {
            System.out.print(ele.getImie()+ele.getNazwisko() + " " + ele.getTakaPlec() + " \n");
        }
        System.out.println("\n********************\n");

        for (zad5Student ele: studenci) {
            if ( ele.getTakaPlec().equals(zad5Student.Plec.Kobieta) ){
                System.out.print(ele + " \n");
            }
        }
        System.out.println("\n********************\n");

        for (zad5Student ele: studenci) {
            if ( ele.getTakaPlec().equals(zad5Student.Plec.Mezczyzna) ){
                System.out.print(ele + " \n");
            }
        }
        System.out.println("\n********************\n");

        for (zad5Student ele: studenci) {
            System.out.print(ele.getNr_Indeksu() + " ");
        }

    }

    private static List<zad5Student> dajStudentow() {
        List<zad5Student> wynik = new ArrayList<>();
        wynik.add(new zad5Student(123, "Jan", "Kowalski", zad5Student.Plec.Mezczyzna) );
        wynik.add(new zad5Student(11, "Harry", "Garncarz", zad5Student.Plec.Mezczyzna) );
        wynik.add(new zad5Student(66, "Roger", "Roger Roger", zad5Student.Plec.Mezczyzna) );
        wynik.add(new zad5Student(785, "Katarzyna", "Ulszulowiczarównoskialeńskogariczońskarowicz", zad5Student.Plec.Kobieta) );
        wynik.add(new zad5Student(45, "Basia", "Przebrzydlo", zad5Student.Plec.Nijaka) );
        wynik.add(new zad5Student(43, "Małgosia", "Nowak", zad5Student.Plec.Kobieta) );
        wynik.add(new zad5Student(13, "Alicja", "Madness", zad5Student.Plec.Kobieta) );
        wynik.add(new zad5Student(20, "Daria", "Skrzyniecka", zad5Student.Plec.Kobieta) );

        return wynik;
    }


}
