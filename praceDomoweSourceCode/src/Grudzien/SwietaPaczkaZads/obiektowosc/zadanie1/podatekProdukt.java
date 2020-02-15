package Grudzien.SwietaPaczkaZads.obiektowosc.zadanie1;

enum podatekProdukt {
    VAT8(1.08),
    VAT23(1.23),
    VAT5(1.05),
    NOVAT(1);

    private double przelicznikProcent;

    podatekProdukt(double przelicznikProcent) {
        this.przelicznikProcent = przelicznikProcent;
    }

    public double getPrzelicznikProcent() {
        return przelicznikProcent;
    }






}
