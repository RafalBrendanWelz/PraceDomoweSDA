package ListopadPart1.zadObiektowosc1PDF;

public class SalaLekcyjna{
    private String nazwa;
    private int numerSali;

    protected SalaLekcyjna(String nazwa, int numer){
        this.numerSali = numer;
        this.nazwa = nazwa;
    }

    public void wypiszDaneSali(){
        System.out.println("Sala " + nazwa + " numer: " + numerSali);
    }



}
