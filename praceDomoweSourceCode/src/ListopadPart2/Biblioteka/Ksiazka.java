package ListopadPart2.Biblioteka;

public class Ksiazka extends Egzemplarz{

    public Ksiazka(Autor pisarzAutor, String tytul, int iloscStron) {
        super(pisarzAutor, tytul, iloscStron);
    }

    public Ksiazka(Autor pisarzAutor, Autor drugiAutor, String tytul, int iloscStron) {
        super(pisarzAutor, drugiAutor, tytul, iloscStron);
    }

    @Override
    protected String jakiTytul() {
        return this.tytul.toLowerCase().trim();
    }


}
