package ListopadPart2.WlasnaData;

public enum Miesiace {
    STY("Styczeń", 31, (byte)1),
    LUT("Luty", 28, (byte)2), //29 w 2012
    MAR("Marzec", 31, (byte)3),
    KWI("Kwiecień", 30, (byte)4),
    MAJ("Maj", 31, (byte)5),
    CZE("Czerwiec", 30, (byte)6),
    LIP("Lipiec", 31, (byte)7),
    SIE("Sierpień", 31, (byte)8),
    WRZ("Wrzesień", 30, (byte)9),
    PAZ("Październik", 31, (byte)10),
    LIS("Listopad", 30, (byte)11),
    GRU("Grudzień", 31, (byte)12);

    private String pelnaNazwa;
    public int maxDni;
    protected byte ktoryMiesiac;

    Miesiace(String pelnaNazwa, int maxDni, byte ktoryMiesiac) {
        this.pelnaNazwa = pelnaNazwa;
        this.maxDni = maxDni;
        this.ktoryMiesiac = ktoryMiesiac;
    }

    protected String dajNazweMiesiac(){
        return this.pelnaNazwa;
    }



}
