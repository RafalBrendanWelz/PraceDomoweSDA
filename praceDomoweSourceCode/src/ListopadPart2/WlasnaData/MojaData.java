package ListopadPart2.WlasnaData;

public class MojaData {
    private byte dzien;
    private byte miesiacNum;
    private int rok;

    public MojaData(byte dzien, byte miesiac, int rok) {
        this.rok = rok;

        if (miesiac < 1){
            this.rok = this.rok - (miesiac / -12) -1;
            this.miesiacNum = (byte) (12 + (miesiac % 12) );

        }else if (miesiac > 12){
            this.rok = this.rok + (miesiac / 12);
            this.miesiacNum = (byte) (miesiac % 12);

        }else {
            this.miesiacNum = miesiac;
        }


        if (dzien <= 0){
            this.dzien = 1;

        }else if (dzien > Miesiace.values()[miesiac-1].maxDni){
            this.dzien = (byte) Miesiace.values()[miesiac-1].maxDni;

            if (Miesiace.values()[miesiac-1] == Miesiace.LUT && (this.rok - 2012) % 4 == 0){    //luty co 4 lata +1 dzien
                this.dzien = 29;
            }
        }else {
            this.dzien = dzien;
        }

    }

    public void pokazDateA(){
        System.out.println(this.dzien + "." + this.miesiacNum + "." + this.rok);
    }

    public void pokazDateB(){
        if (this.dzien<10){
            System.out.print("0" + this.dzien + ".");
        }else {
            System.out.print(this.dzien + ".");
        }

        if (this.miesiacNum<10){
            System.out.println("0" + this.miesiacNum + "." + this.rok);
        }else {
            System.out.println(this.miesiacNum + "." + this.rok);
        }
    }

    public void pokazDateC(){
        System.out.println(this.dzien + "." + getMiesiac() + "." + this.rok);
    }


    protected byte getDzien() {
        return dzien;
    }

    protected byte getMiesiacNum() {
        return miesiacNum;
    }

    protected String getMiesiac() {
        return Miesiace.values()[miesiacNum-1].dajNazweMiesiac();
    }

    protected int getRok() {
        return rok;
    }



}
