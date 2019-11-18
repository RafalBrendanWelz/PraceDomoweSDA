package ListopadPart1;

public class CzasData {
    byte dzien;
    byte miesiac;
    int rok;

    private String przedEra = "";
    private static String[] allMiesiace = new String[] {"Sty", "Lut", "Mar", "Kwi", "Maj", "Cze", "Lip", "Sie", "Wrz", "Paz", "Lis", "Gru"};

    protected CzasData(byte dzien, byte miesiac, int rok){
        if (dzien>31) {
            this.dzien = 31;
        }else if (dzien<=0){
            this.dzien = 1;
        }else {
            this.dzien = dzien;
        }

        if (miesiac>12) {
            this.miesiac = 12;
        }else if(miesiac<=0) {
            this.miesiac = 1;
        }else {
            this.miesiac = miesiac;
        }

        if (rok==0){
            this.rok = 1;
        }else if (rok<0){
            this.rok = rok;
            this.przedEra = "BC";
        }else {
            this.rok = rok;
        }
    }

    protected void wyswietlA (){
        System.out.println(this.dzien + "." + this.miesiac + "." + this.rok + this.przedEra);
    }

    protected void wyswietlB (){
        if (this.dzien<10){
            System.out.println("0" + this.dzien + "." + this.miesiac + "." + this.rok + this.przedEra);
        }else {
            System.out.println(this.dzien + "." + this.miesiac + "." + this.rok + this.przedEra);
        }
    }

    protected void wyswietlC (){
        System.out.println(this.dzien + "." + allMiesiace[this.miesiac-1] + "." + this.rok + this.przedEra);
    }


}
