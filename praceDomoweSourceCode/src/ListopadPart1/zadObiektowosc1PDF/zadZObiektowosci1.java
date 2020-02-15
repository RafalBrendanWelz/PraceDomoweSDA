package ListopadPart1.zadObiektowosc1PDF;

public class zadZObiektowosci1 {

    public static void main(String[] args) {
        //zadania z obiektowości.pdf    - stąd zadania
        //zad1();
        //zad2();
        zad3();
        
    }

    private static void zad3() {
        RachunekBankowy[] wszystkieKonta = new RachunekBankowy[4];

        wszystkieKonta[0] = new RachunekBankowy(456789, "Arek", "Kożuchowski");
        wszystkieKonta[1] = new RachunekBankowy(157843, "Kelmar", "Andrusin");
        wszystkieKonta[2] = new RachunekBankowy(224822, "Rogerson", "Smith");
        wszystkieKonta[3] = new RachunekBankowy(455189, "Jan", "Kowalusyjewowskójczyk");

        Bank pierwszy = new Bank("Pierwszy",4);
        for (int i = 0; i < 4; i++) {
            pierwszy.konta[i] = wszystkieKonta[i];
        }



        for (int i = 0; i < wszystkieKonta.length; i++) {
            pierwszy.konta[i].wplataPrzelewem(450.20);
        }
        wszystkieKonta[2].wplataPrzelewem(800);
        wszystkieKonta[3].wplataPrzelewem(200.4);
        wszystkieKonta[1].wplataPrzelewem(1752.98);
        wszystkieKonta[0].wplataPrzelewem(20.5);

        for (int i = 0; i < wszystkieKonta.length; i++) {
            pierwszy.konta[i].rachunekInfo();
        }

        pierwszy.wykonajPrzelew("456789", "455189",500);
        pierwszy.wykonajPrzelew("157843", "455189",670.20);

        for (int i = 0; i < wszystkieKonta.length; i++) {
            pierwszy.konta[i].rachunekInfo();
        }


    }

    private static void zad2() {
        Samochód[] auta = new Samochód[6];

        auta[0] = new Samochód(2,210);  //typ: 0=maluch 1=toyCoroll 2=subImprez 3=hondaCiv 4=RenoThal
        auta[1] = new Samochód(1,190);
        auta[2] = new Samochód(0,110);
        auta[3] = new Samochód(3,170);
        auta[4] = new Samochód(4,165);
        auta[5] = new Samochód(3,186);


        for (int i = 0; i < auta.length; i++) {
            for (int j = 0; j < 5; j++) {
                auta[i].przyspieszO5km();
            }
        }
        for (int i = 0; i < auta.length; i++) {
            auta[i].autoInfo();
        }
        System.out.println("****************** \n");


        for (int i = 0; i < auta.length; i++) {
            for (int j = 0; j < 9; j++) {
                auta[i].przyspieszO5km();
            }
        }
        for (int i = 0; i < auta.length; i++) {
            auta[i].autoInfo();
        }
        System.out.println("****************** \n");


        for (int i = 0; i < auta.length; i++) {
            for (int j = 0; j < 11; j++) {
                auta[i].przyspieszO5km();
            }
        }
        for (int i = 0; i < auta.length; i++) {
            auta[i].autoInfo();
        }
        System.out.println("****************** \n");


        for (int i = 0; i < auta.length; i++) {
            for (int j = 0; j < 13; j++) {
                auta[i].przyspieszO5km();
            }
        }
        for (int i = 0; i < auta.length; i++) {
            auta[i].autoInfo();
        }
        System.out.println("****************** \n");

    }

    private static void zad1() {
        SalaLekcyjna[] sale = new SalaLekcyjna[6];

        sale[0] = new SalaLekcyjna("Matematyczna",4);
        sale[1] = new SalaLekcyjna("Historyczna",276);
        sale[2] = new SalaLekcyjna("Język.Polski",302);
        sale[3] = new SalaLekcyjna("Język.Angielski",111);
        sale[4] = new SalaLekcyjna("Matematyczna",305);
        sale[5] = new SalaLekcyjna("Fizyczna",16);

        for (int i = 0; i < sale.length; i++) {
            sale[i].wypiszDaneSali();
        }



    }
}
