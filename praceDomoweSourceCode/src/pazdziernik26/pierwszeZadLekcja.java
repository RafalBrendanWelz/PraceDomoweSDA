package pazdziernik26;

public class pierwszeZadLekcja {

    public static void main(String[] args) {
        int[] tablica1 = new int[] {1,3,5,10};

        System.out.println(tablica1[0]);
        System.out.println(tablica1[1]);

        System.out.println("\n");
        for (int i = 0; i < tablica1.length; i++) {
            System.out.print(tablica1[i] + " ");
        }

        System.out.println("\n");
        for (int i = 0; i < tablica1.length; i++) {
            if (i%2==0){
                System.out.print(tablica1[i] + " ");
            }

            if(tablica1[i]%2==0){
                System.out.print("parzysta " + tablica1[i] + " ");
            }
        }

        System.out.println("\n");
        for (int i = tablica1.length-1; i >= 0; i--) {
            System.out.print(tablica1[i] + " ");
        }

    }


}
