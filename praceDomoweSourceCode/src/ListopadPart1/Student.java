package ListopadPart1;

public class Student {
    int nrIndeksu = 100000;     //6cyfrowy
    String imie;
    String nazwisko;
    String plec;  //k lub m
    String kierunekStudiow;
    boolean zaliczonySemestr;
    byte obecnySemestr;
    String stopien;

    private static String[] stopnieNauk = new String[]{"student", "inżynier", "Magister", "Magister asystent Naukowy", "Doktor"};
    //to mogłoby być w innej klasie bo nie jest cechą studenta

    protected Student(String imie, String nazwisko, String kierunekStudiow, byte ktoryStopien, byte obecnySemestr, boolean czyZaliczony, char plec){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kierunekStudiow = kierunekStudiow;
        this.stopien = stopnieNauk[ktoryStopien];
        this.obecnySemestr = obecnySemestr;
        this.zaliczonySemestr = czyZaliczony;

        if (plec=='m'){
            this.plec = "mężczyzna";
        }else if (plec=='k'){
            this.plec = "kobieta";
        }else {
            this.plec = "okropieństwo (inna)";
        }

        System.out.print("->Nowy student gotowy do boju... , ");
    }

    protected void pokazDane(){
        System.out.println("Student indeks nr. " + this.nrIndeksu);
        System.out.println(this.stopien + " " + this.imie + " " + this.nazwisko + " studiujący/a na kierunku " + this.kierunekStudiow + " na " + this.obecnySemestr + " semestrze");
        System.out.println("Płeć: " + this.plec);
        if (this.zaliczonySemestr){
            System.out.println("Obecny Semestr Zaliczony ");
        }else {
            System.out.println("Obecny Semestr NIEzaliczony");
        }

    }

    protected void przedstawSie(){
        System.out.println("Heyo Ello. Jestem " + this.imie + " " + this.nazwisko + " , Jestem " + this.plec + " i mój numer indeksu to: " + this.nrIndeksu);

        if (this.stopien.equals("student")){
            System.out.println("Jestem Zwycięscą");
        }else {
            System.out.println("Jestem " + this.stopien);
        }
    }




}