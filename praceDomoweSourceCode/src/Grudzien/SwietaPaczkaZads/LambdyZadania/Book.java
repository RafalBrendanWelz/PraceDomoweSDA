package Grudzien.SwietaPaczkaZads.LambdyZadania;

import java.util.Random;

class Book implements Comparable{
    private String tytul;
    private String autor;
    private int iloscEdycji;


    Book(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
        this.iloscEdycji = losEdycji();
    }

    private int losEdycji() {
        Random losuj = new Random();
        return losuj.nextInt(30);
    }

    public int getIloscEdycji() {
        return iloscEdycji;
    }
    String getTytul() {
        return tytul;
    }
    String getAutor() {
        return autor;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Book) {
            Book drugi = (Book) anObject;
            return this.autor.equals(drugi.autor) && this.tytul.equals(drugi.tytul);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getTytul();
    }

    @Override
    public int compareTo(Object o) {
        if ( o instanceof Book){
            Book druga = (Book) o ;
            if (this.iloscEdycji > druga.iloscEdycji){
                return -1;
            }else {
                return 1;
            }

        }else {
            return 0;
        }
    }



}
