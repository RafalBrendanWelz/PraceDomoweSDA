package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie3;

enum miejsceZglosz {
    BRAK("Brak Danych", 0),
    GDAN("Gdańsk",10),
    WEJHER("Wejherowo",11),
    SOPOT("Sopot",12),
    GDYNIA("Gdynia",13),
    PRUSZCZ("Pruszcz Gdański",14),
    RUMIA("Rumia",15),
    WLADYSL("Władysławowo",16),
    HEL("Hel",17),
    WARSZ("Warszawa",18),
    TORUN("Toruń",19),
    KOSCIERZ("Kościerzyna",20),
    POZNAN("Poznań",21);

    private String miasto;
    private int numerID;

    miejsceZglosz(String miasto, int numerID) {
        this.miasto = miasto;
        this.numerID = numerID;
    }

    public String getMiasto() {
        return miasto;
    }
    public int getNumerID() {
        return this.numerID;
    }





}
