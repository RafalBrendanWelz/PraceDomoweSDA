package ListopadPart2.KlasyFeudalne;

public class LFamMember extends Citizen{    //Osoba z Rodziny Władczej nad jakimś królestwem/domeną
    Krolestwa domenaRodzinna;               //zastępuje Króla jako że król pasuje bardziej jako pozycja i dla danego królestwa może być tylko jeden
    HeirPosition pozycja;


    public LFamMember(String imie, char plec, Krolestwa domena, HeirPosition pozycja) {
        super(imie, false, plec);
        this.klasa = pozycja.nazwa;
        super.imie = imie;
        super.maPrawoGlosu = false;
        this.domenaRodzinna = domena;
        this.pozycja = pozycja;

        if (domena==Krolestwa.LOKALNE){
            if (pozycja==HeirPosition.GOVERNOR && plec == 'M') {
                this.domenaRodzinna.krol = this;
            }
        }else {
            if (pozycja==HeirPosition.KING && plec == 'M') {
                this.domenaRodzinna.krol = this;
            }
        }
    }





}
