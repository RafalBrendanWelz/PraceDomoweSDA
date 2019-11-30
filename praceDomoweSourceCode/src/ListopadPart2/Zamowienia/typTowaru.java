package ListopadPart2.Zamowienia;

public enum typTowaru {
    CHLEB("Chleb", 1.8, false, 0),
    BULKA("Bułki", 0.3, false, 0),
    SZYNKA("Szynka", 5.8, false, 0),
    MLEKO("Mleko 2lkartonik", 2.8, false, 0),
    JAJA("Jaja 10karton", 2, false, 0),
    KEFIR("Kefir 1lkartonik", 3, false, 0),
    SER("Ser 10dk", 2.8, false, 0),
    JABLKO("Jabłka", 6.5, true, 0.2),
    GRUSZKA("Gruszki", 8, true, 0.18),
    BANAN("Banany", 8.1, true, 0.19),
    MARCH("Marchew", 4.2, true, 0.15),
    PIWO("Piwo 1lbutelka", 6, false, 0),
    WODA("Woda 1lbutelka", 0.3, false, 0),
    SOK("Sok 2lkartonik", 3.8, false, 0),
    PEPSI("Pepsi 2lbutelka", 3.99, false, 0),
    RYBY("Ryby", 6.7, true, 0.6),
    CIASTKA("Paczka Ciastek", 2.99, false, 0);

    String nazwa;
    double cena;
    boolean czyZaKilo;
    double wagaZaSztuke;


    typTowaru(String nazwa, double cena, boolean czyZaKilo, double wagaZaSztuke) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.czyZaKilo = czyZaKilo;
        this.wagaZaSztuke = wagaZaSztuke;

    }





}
