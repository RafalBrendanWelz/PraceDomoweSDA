package ListopadPart2.Biblioteka;

public class Czasopismo extends Egzemplarz{

    private String podTytul;
    private int numerwydania;

    public Czasopismo(Autor pisarzAutor, String tytul, int iloscStron, String podTytul, int numerwydania) {
        super(pisarzAutor, tytul, iloscStron);
        this.podTytul = podTytul;
        this.numerwydania = numerwydania;
    }

    public Czasopismo(Autor pisarzAutor, Autor drugiAutor, String tytul, int iloscStron, String podTytul, int numerwydania) {
        super(pisarzAutor, drugiAutor, tytul, iloscStron);
        this.podTytul = podTytul;
        this.numerwydania = numerwydania;
    }

    @Override
    protected String jakiTytul() {
        String zwroc = this.tytul + ":" + this.podTytul;

        return zwroc.toLowerCase().trim();
    }





}
