package ListopadPart2.KlasyFeudalne;

public class Town {
    private Citizen[] mieszkancy;
    private Citizen krol;
    String nazwaMasta;
    Krolestwa przynaleznosc;

    public Town(Citizen[] mieszkancy, String nazwaMasta, Krolestwa przynaleznosc) {
        this.mieszkancy = mieszkancy;
        this.nazwaMasta = nazwaMasta;
        this.krol = znajdzKrola( mieszkancy);
        this.przynaleznosc = przynaleznosc;
    }

    private Citizen znajdzKrola(Citizen[] mieszkancy) {
        for (Citizen mieszkaniec: mieszkancy) {
            if (mieszkaniec.klasa.equals("King")){
                return mieszkaniec;
            }
        }

        return null;
    }


    public void opiszMiasto(){
        String skrotowyOpisStanu;

        System.out.print("\nMiasto " + this.nazwaMasta);
        if (this.przynaleznosc == Krolestwa.LOKALNE){
            System.out.print(" to " + Krolestwa.LOKALNE.pelnaNazwa + "\n");
            System.out.println("Obecnym Gubernatorem jest: " + this.przynaleznosc.krol.przedstawSie() );
            skrotowyOpisStanu = "\nMiasto żyje sobie w spokoju i względnej radości. ";
        }else {
            System.out.print(" jest częścią państwa: " + this.przynaleznosc.pelnaNazwa + " \n");
            System.out.println("Obecnym królem jest: " + this.przynaleznosc.krol.przedstawSie() );
            skrotowyOpisStanu = "\nMiasto żyje sobie we względnym spokoju i radości wielmożnego króla. ";
        }

        System.out.println("Owe miasto ma " + this.mieszkancy.length + " mieszkańców. A oto i oni: ");
            wypiszLudziZMiasta( this.mieszkancy );
        System.out.println(" ");
            wypiszTychCoMogaGlosowac();
        System.out.println( skrotowyOpisStanu);
    }

    public int iluMozeGlosowac(){
        int ilu = 0;
        for (Citizen mieszkaniec : this.mieszkancy) {
            if (mieszkaniec.maPrawoGlosu) {
                ilu++;
            }
        }
        return ilu;
    }

    public Citizen[] ktoMozeGlosowac() {
        Citizen[] ktoMozeGlos = new Citizen[ this.iluMozeGlosowac() ];

        int ilu = 0;
        for (Citizen mieszkaniec : this.mieszkancy) {       //struktura foreach (typElementu elementTablicy : jakiejTablicyNazwa)
            if (mieszkaniec.maPrawoGlosu) {                                      //dla każdego takiego : z tej tablicy
                ktoMozeGlos[ilu] = mieszkaniec;
                ilu++;
            }
        }

        return ktoMozeGlos;
    }

    public void wypiszLudziZMiasta(Citizen[] grupa){
        int i = 0, prz = -1;
        Citizen poprzLudz = grupa[0];
        for (Citizen ludz : grupa) {
            i++; prz++;
            if (prz % 4 == 0 || !ludz.klasa.equals(poprzLudz.klasa)){
                System.out.println(" ");
                prz = 0;
            }
            System.out.print(i + ") " + ludz.przedstawSie() + ", ");

            poprzLudz = ludz;
        }
    }

    public void wypiszTychCoMogaGlosowac() {
        System.out.println("Mieszkańcy Miasta " + this.nazwaMasta + " Którzy mogą głosować to: ");
        wypiszLudziZMiasta( ktoMozeGlosowac() );
    }



}
