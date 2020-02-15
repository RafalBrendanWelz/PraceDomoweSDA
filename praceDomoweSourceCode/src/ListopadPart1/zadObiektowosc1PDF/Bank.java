package ListopadPart1.zadObiektowosc1PDF;

public class Bank {
    String nazwaBank;
    RachunekBankowy[] konta;


    protected Bank(String nazwaBank, int iloscKont){
        this.nazwaBank = nazwaBank;
        this.konta = new RachunekBankowy[iloscKont];
    }

    protected void  wykonajPrzelew(String numKontoZ, String numKontoDo, double kwota){      //to do czy ma pieniądze (stanKonta > 0 ) i tylko wtedy przelew

        for (int i = 0; i < konta.length; i++) {
            if (konta[i].getNumerKonta().equals(numKontoZ)){
                konta[i].przelewOutWyplata(kwota);

                System.out.print("Przelew " + kwota + "zł wypłacony z konta " + konta[i].getNumerKonta() );
                System.out.println(" właściciela " + konta[i].getImie() + konta[i].getNazwisko() );
            }

            if (konta[i].getNumerKonta().equals(numKontoDo)){
                konta[i].wplataPrzelewem(kwota);

                System.out.print("Przelew " + kwota + "zł trafił na konto " + konta[i].getNumerKonta() );
                System.out.println(" właściciela " + konta[i].getImie() + konta[i].getNazwisko() );
            }
        }


    }


}
