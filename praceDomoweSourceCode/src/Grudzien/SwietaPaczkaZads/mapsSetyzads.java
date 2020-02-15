package Grudzien.SwietaPaczkaZads;

import java.util.*;

public class mapsSetyzads {

    public static void setsZad8Start(){

        System.out.println("Zadanie z łączeniem nagłówków \n********************* ");
        zadanieZNaglowkami8();
    }

    public static void zadaniaDrobneSety(){
        System.out.println("Oto tworzenie setu bez duplikatów z generycznej listy ");
        List<Integer> takaLista = Arrays.asList(12, 13, 15, 17, 12, 15, 3, 3, 4, 9, 19, 10, 10, 12);
        Map<String, Integer> takaListBezDupli = dajMapeIlosciWystapienZ( Arrays.asList("ala","kacia","tor","tor", "ktoto","poczta","ala","kaczka","kaczka","tor") );
        System.out.println(takaListBezDupli);

    }

    public static void zadanieZNaglowkami8(){
        List<NaglowekHTTP> listaNagl = dajNaglStart();

        wyswietlListNagl(listaNagl);

        System.out.println("Teraz alfabetycznie: ");
        System.out.println(alfabetSort(listaNagl));

    }

    private static void wyswietlListNagl( List<NaglowekHTTP> taka){
        System.out.println("[");
        for (NaglowekHTTP ele: taka) {
            System.out.print(ele);
        }
        System.out.println("]");
    }

    private static List<NaglowekHTTP> dajNaglStart( ){
        List<NaglowekHTTP> listaNagl = new LinkedList<>();
        listaNagl.add(new NaglowekHTTP("abc",243));
        listaNagl.add(new NaglowekHTTP("abc",243));
        listaNagl.add(new NaglowekHTTP("kacper",444));
        listaNagl.add(new NaglowekHTTP("kacper",44));
        listaNagl.add(new NaglowekHTTP("tut",156));
        listaNagl.add(new NaglowekHTTP("tut",243));
        listaNagl.add(new NaglowekHTTP("tut",241));
        listaNagl.add(new NaglowekHTTP("kosa",100));
        listaNagl.add(new NaglowekHTTP("masakra",243));
        listaNagl.add(new NaglowekHTTP("tut",745));
        listaNagl.add(new NaglowekHTTP("gosc",363));
        listaNagl.add(new NaglowekHTTP("gosc",111));
        listaNagl.add(new NaglowekHTTP("masakra",111));
        listaNagl = laczenieNaglowkow( listaNagl );
        return listaNagl;
    }

    private static Map<String, List<Integer> > alfabetSort( List<NaglowekHTTP> toSort){
        Map<String, List<Integer> > naglowkiDoPosort = new TreeMap<>();

        for (NaglowekHTTP ele: toSort) {
            ele.getWartosc().sort(Integer::compareTo);
            naglowkiDoPosort.put(ele.getNazwa(), ele.getWartosc() );
        }

        return naglowkiDoPosort;
    }

    private static List<NaglowekHTTP> laczenieNaglowkow (List<NaglowekHTTP> tych ){
        List<NaglowekHTTP> wynik = new LinkedList<>();

        for (int i = 0; i < tych.size(); i++) {

            if ( i != tych.lastIndexOf(tych.get(i) ) ){
                List<Integer> wartosciTegoDupl = tych.get(i).getWartosc();
                tych.get( tych.lastIndexOf(tych.get(i) ) ).laczWartosc( wartosciTegoDupl );
            }else {
                wynik.add(tych.get(i) );
            }

        }

        return wynik;
    }

    private static  <T> Set<T> dajSameMnogieWyst(List<T> wartosc){
        //zwraca listę tych z wartosci które wyst. kilkakrotnie . Złożoność O(n)
        Set<T> wynik = new HashSet<>();
        if ( wartosc.isEmpty() ){
            throw new UnsupportedOperationException( "Lista jest pusta ");
        }else {

            for (T ele: wartosc) {
                if (wartosc.indexOf(ele) != wartosc.lastIndexOf(ele) ){
                    wynik.add(ele);
                }
            }
        }

        return wynik;
    }

    private static <T> Map<T, Integer> dajMapeIlosciWystapienZ(List<T> wartosci ){
        Map<T, Integer> wynik = new HashMap<>();
        if ( wartosci.isEmpty() ){
            throw new UnsupportedOperationException( "Lista jest pusta ");
        }else {

            for (T ele: wartosci) {
                if (wynik.containsKey( ele ) ){
                    wynik.replace(ele, wynik.get(ele), wynik.get(ele)+1 );
                }else {
                    wynik.put(ele, 1);
                }
            }
        }

        return wynik;
    }

    private static <T> Set<T> zbiorWspolnychWartosci ( List<T> pierwszej, List<T> drugiej){
        Set<T> wynik = new HashSet<>();

        if ( pierwszej.isEmpty() ){
            throw new UnsupportedOperationException( "Lista jest pusta ");
        }else {

            for (T ele: pierwszej) {
                if ( drugiej.contains(pierwszej) ){
                    wynik.add( ele );
                }
            }
        }

        return wynik;
    }






}
