package Grudzien.SwietaPaczkaZads.OdczytZapis;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Formularz {
    private int wiek;
    private double wzrost;  //w cm
    private boolean IsMale;
    private int wysokoscZarobki;    //w zł
    private Wyksztalcenie takie;
    private byte zadowolenieZZycia;   //from 0 to 100

    private static final File plikZapisuFormularzy
            = new File( "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\praceDomoweSDA\\src\\Grudzien\\SwietaPaczkaZads\\OdczytZapis\\output_form.txt" );
    private static int iloscWypelnionych = 0;

    public int getWiek() {
        return wiek;
    }
    public double getWzrost() {
        return wzrost;
    }
    public boolean isMale() {
        return IsMale;
    }
    public int getWysokoscZarobki() {
        return wysokoscZarobki;
    }
    public Wyksztalcenie getTakie() {
        return takie;
    }
    public byte getzadowolenieZZycia() {
        return zadowolenieZZycia;
    }

    public Formularz(int wiek, double wzrost, boolean isMale, int wysokoscZarobki, Wyksztalcenie takie, byte zadowolenieZZycia) {
        this.wiek = wiek;
        this.wzrost = wzrost;
        IsMale = isMale;
        this.wysokoscZarobki = wysokoscZarobki;
        this.takie = takie;
        this.zadowolenieZZycia = zadowolenieZZycia;
    }

    public Formularz(int wiek, double wzrost, boolean isMale, Wyksztalcenie takie, byte zadowolenieZZycia) {    //oddzielne dla Kobiet
        this.wiek = wiek;
        this.wzrost = wzrost;
        IsMale = isMale;
        this.takie = takie;
        this.zadowolenieZZycia = zadowolenieZZycia;
    }


    public static void zapiszDoPlik( List<Formularz> wszystkie ) throws IOException {
        FileWriter wpiszDoPliku = new FileWriter( plikZapisuFormularzy );

        for (Formularz te: wszystkie) {
            iloscWypelnionych++;
            wpiszDoPliku.append( dajFormeZapis (te ) );
            System.out.println("Zapisano formularz " + iloscWypelnionych);
        }
        wpiszDoPliku.close();
    }

    private static String dajFormeZapis( Formularz tego ){
        String plec;
        if ( tego.isMale() ){
            plec="Male";
            return "nr." + iloscWypelnionych + ": Płeć=" + plec + " Wiek=" + tego.wiek + " Wzrost=" + tego.wzrost + " Zarobki=" + tego.wysokoscZarobki +
                    " Wykształcenie=" + tego.getTakie().getNazwa() + " Zadowolenie(0do100)=" + tego.zadowolenieZZycia + "\n";
        }else {
            plec="Female";
            return "nr." + iloscWypelnionych + ": Płeć=" + plec + " Wiek=" + tego.wiek + " Wzrost=" + tego.wzrost +
                    " Wykształcenie=" + tego.getTakie().getNazwa() + " Zadowolenie(0do100)=" + tego.zadowolenieZZycia + "\n";
        }
    }

    @Override
    public String toString( ){
        String plec;
        if ( this.isMale() ){
            plec="Male";
            return "Płeć = " + plec + "; Wiek = " + this.wiek + "; Wzrost = " + this.wzrost + "; Zarobki = " + this.wysokoscZarobki +
                    "; Wykształcenie = " + this.getTakie().getNazwa() + "; Zadowolenie(0do100) = " + this.zadowolenieZZycia;
        }else {
            plec="Female";
            return "Płeć = " + plec + "; Wiek = " + this.wiek + "; Wzrost = " + this.wzrost +
                    "; Wykształcenie = " + this.getTakie().getNazwa() + "; Zadowolenie(0do100) = " + this.zadowolenieZZycia;
        }
    }





}
