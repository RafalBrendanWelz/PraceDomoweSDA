package ListopadPart2.Biblioteka;

public abstract class Egzemplarz {

    Autor pisarzAutor;
    Autor drugiAutor;
    String tytul;
    int iloscStron;

    public Egzemplarz(Autor pisarzAutor, String tytul, int iloscStron) {
        this.pisarzAutor = pisarzAutor;
        this.tytul = tytul;
        this.iloscStron = iloscStron;

    }

    public Egzemplarz(Autor pisarzAutor, Autor drugiAutor, String tytul, int iloscStron) {
        this.pisarzAutor = pisarzAutor;
        this.drugiAutor = drugiAutor;
        this.tytul = tytul;
        this.iloscStron = iloscStron;

    }

    protected abstract String jakiTytul();


    protected String jakiAutor(){

        if (drugiAutor == null){
            String zwroc = pisarzAutor.imie + " " + pisarzAutor.nazwisko;
            return zwroc.trim().toLowerCase();
        }else {
            String zwroc = pisarzAutor.imie + " " + pisarzAutor.nazwisko + " i " + drugiAutor.imie + " " + drugiAutor.nazwisko;
            return zwroc.trim().toLowerCase();
        }

    }






}
