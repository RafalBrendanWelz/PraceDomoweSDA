package ListopadPart1.zadObiektowosc1PDF;

public class Bank {
    String nazwaBank;
    RachunekBankowy[] konta;

    protected Bank(String nazwaBank, int iloscKont){
        this.nazwaBank = nazwaBank;
        this.konta = new RachunekBankowy[iloscKont];
    }

    protected void  wykonajPrzelew(String numKontoZ, String numKontoDo, double kwota){

        for (int i = 0; i < konta.length; i++) {
            if (konta[i].numerKonta.equals(numKontoZ)){
                konta[i].przelewOutWyplata(kwota);
                System.out.println("Przelew " + kwota + "zł wypłacony z konta " + konta[i].numerKonta + " właściciela " + konta[i].imie + konta[i].nazwisko);
            }

            if (konta[i].numerKonta.equals(numKontoDo)){
                konta[i].wplataPrzelewem(kwota);
                System.out.println("Przelew " + kwota + "zł trafił na konto " + konta[i].numerKonta + " właściciela " + konta[i].imie + konta[i].nazwisko);
            }
        }


    }


}
