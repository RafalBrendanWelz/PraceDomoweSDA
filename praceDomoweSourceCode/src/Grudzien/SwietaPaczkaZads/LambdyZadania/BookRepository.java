package Grudzien.SwietaPaczkaZads.LambdyZadania;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class BookRepository {
    private Map<String, String> listaKsiag;

    Map<String, String> getListaKsiag() {
        return listaKsiag;
    }

    BookRepository() {
        this.listaKsiag = new LinkedHashMap<>();
    }

    void dajKsiazki(String autorTytul ) {
      if ( autorTytul.contains(":") ){
          String[] wejscie = autorTytul.split(":");
          String tytul = wejscie[1] ;
          String autor = wejscie[0] ;

          this.listaKsiag.put( autor, tytul );
      }else {
          throw new IllegalArgumentException("Tytuł i Autor książki muszą być podane w sposób [tytul:autor] z dwukropkiem pomiędzy");
      }
    }





}
