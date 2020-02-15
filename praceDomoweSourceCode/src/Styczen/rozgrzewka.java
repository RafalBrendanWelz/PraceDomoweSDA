package Styczen;

import java.util.Set;
import java.util.TreeSet;

public class rozgrzewka {

    public static void main(String[] args) {
        zadZPosortowaniemCyfrZeString("304298312");

    }

    public static void zadZPosortowaniemCyfrZeString(String sameCyfry){
        Set<Integer> byPosortowac = new TreeSet<>();
        int[] wystapienia = new int[] {0,1,2,3,4,5,6,7,8,9};
        int[] startWyst = new int[]   {0,0,0,0,0,0,0,0,0,0};
        int[][] liczWystap = new int[][] {wystapienia, startWyst};      //dokończ zadanie z wykorzystaniem sortowania z ilością wystąpień

        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < sameCyfry.length(); i++) {
            byPosortowac.add( Integer.parseInt(sameCyfry.substring(i,i+1))  );
        }

        for (Integer ele: byPosortowac) {
            wynik.append(ele);
        }
        System.out.println(wynik);

    }


}
