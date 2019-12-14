package Grudzien.Slack2Gru.zadanie6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zad6 {

    public static void zad6Start(){
        Deweloper pierwsz = new Deweloper("Takiszewski", dajListeBudynkow(), 10000, 7.5);
        pierwsz.wypiszOfertyBudynk();
        System.out.println("\n****************************\n");
        pierwsz.wypiszOfertyMieszkan();

    }

    private static List<Budynek> dajListeBudynkow() {
       Budynek bomba = new Budynek(dajMieszkania1(), Osiedla.BURSZTYNOWE, 45, "Brzyszcz, Bursztyna Grodzkiego 23");
       Budynek karamba = new Budynek(dajMieszkania1(), Osiedla.BURSZTYNOWE, 37, "Brzyszcz, Bursztyna Grodzkiego 22");
       Budynek trzeci = new Budynek(dajMieszkania1(), Osiedla.BURSZTYNOWE, 19, "Brzyszcz, Bursztyna Grodzkiego 21");

       List<Budynek> lista = new ArrayList<>(Arrays.asList(bomba, karamba, trzeci) );
       return lista;
    }



    private static Mieszkanie[] dajMieszkania1() {
        Mieszkanie pierw = new Mieszkanie(40, 150, 3, 1, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie drug = new Mieszkanie(40, 150, 3, 1, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie trz = new Mieszkanie(40, 190, 3, 1, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie czt = new Mieszkanie(50, 150, 4, 1, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie piat = new Mieszkanie(50, 160, 3, 2, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie sze = new Mieszkanie(50, 160, 4, 2, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie siem = new Mieszkanie(60, 160, 5, 2, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);
        Mieszkanie wos = new Mieszkanie(60, 210, 4, 2, new double[] {2,3,4,5,6}, kierPolozGlSciany.EAST);

        return new Mieszkanie[] {pierw, drug, trz, czt, piat, sze, siem, wos};
    }



}
