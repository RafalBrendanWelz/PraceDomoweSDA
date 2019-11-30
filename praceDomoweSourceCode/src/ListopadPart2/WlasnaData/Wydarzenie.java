package ListopadPart2.WlasnaData;

public class Wydarzenie {
    private MojaData dataWydarzenia;
    protected String nazwaWydarzenia;

    public Wydarzenie(MojaData dataWydarzenia, String nazwaWydarzenia) {
        this.dataWydarzenia = dataWydarzenia;
        this.nazwaWydarzenia = nazwaWydarzenia;

    }

    public String dajOpis(){
        return this.nazwaWydarzenia + " wydarzyło się " + this.dataWydarzenia.getDzien() + " " + this.dataWydarzenia.getMiesiac() + " " + this.dataWydarzenia.getRok() + " roku";
    }

    public int ileLatOdTeraz(){
        int wynik = this.dataWydarzenia.getRok() - java.time.Year.now().getValue() ;

        if (wynik < 0){
            wynik *= -1;
        }

        return wynik;
    }

    public int ileMiesiecyOdTeraz(){
        int wynik =  this.dataWydarzenia.getMiesiacNum() - java.time.YearMonth.now().getMonthValue();

        if (wynik < 0){
            wynik *= -1;
        }

        return (ileLatOdTeraz()*12) + wynik;
    }

    public int ileDniOdTeraz(){
        int wynik = this.dataWydarzenia.getDzien() - java.time.MonthDay.now().getDayOfMonth();

        if (wynik < 0){
            wynik *= -1;
        }

        return (ileLatOdTeraz()*365) + (ileMiesiecyOdTeraz()*365/12) + wynik;
    }




}
