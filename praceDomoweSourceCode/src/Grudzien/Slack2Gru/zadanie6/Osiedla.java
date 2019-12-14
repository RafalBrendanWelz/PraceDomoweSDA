package Grudzien.Slack2Gru.zadanie6;

public enum Osiedla {
    SLONECZNIKOWE( 1.5, 1 ),
    TAKIE( 2.5, 0 ),
    BURSZTYNOWE( 2.1, 3 ),
    GLOWNE( 0, 4 ),
    KARRNE( 1.1, 2 ),
    PAGORKOWE( 2.6, 1 ),
    MORSKIE( 1.3, 2 ),
    OLIWA( 4.5, 4 );

    private double sredniDystansDoCentrum;
    private int etapOsiedla;

    Osiedla(double dystansDoCentrum, int etapOsiedla) {
        this.sredniDystansDoCentrum = dystansDoCentrum;
        this.etapOsiedla = etapOsiedla;
    }

    public double getSredniDystansDoCentrum() {
        return sredniDystansDoCentrum;
    }
    public int getEtapOsiedla() {
        return etapOsiedla;
    }



}
