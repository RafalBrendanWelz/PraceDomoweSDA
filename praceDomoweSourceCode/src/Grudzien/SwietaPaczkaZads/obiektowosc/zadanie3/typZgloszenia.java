package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie3;

enum typZgloszenia {
    KARETKA('0', "Karetka"),
    POLICJA('1', "Policja"),
    STRAZ('2', "Straż Pożarna"),
    WYPADEK('3', "Wypadek Komunikacyjny"),
    INNE('4', "Inny");

    private char byWybrac;
    private String nazwa;

    public String getNazwa(){
        return this.nazwa;
    }
    public char getByWybrac() {
        return byWybrac;
    }
    typZgloszenia(char byWybrac, String nazwa) {
        this.byWybrac = byWybrac;
        this.nazwa = nazwa;
    }



}
