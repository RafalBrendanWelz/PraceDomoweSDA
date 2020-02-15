package Grudzien.StringiWyrazReg;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
       // zad1i2();
       // zad3();
       // zad4();
       // zad5();
       // zad6();
        //zad7();
        //zad8();
        //zad9();
        //zad10();
        //zad11();
        //zad12();
        //zad13();
        zad14();

    }

    private static void zad14() {
        System.out.println("Program zaszyfruje twój tekst według kodu Cezara: ");
        System.out.println("*********************************************************************");
        System.out.println("Podaj Tekst:");
        String text = dajTekst();

        System.out.println("Podaj liczbę o ile będziesz przesuwał ");
        int przesun = dajInt();

        String alfab = "aąbcćdeęfghijklłmnńoóprsśtuwzźżxvAĄBCĆDEĘFGHIJKLŁMNOÓPRSŚTUWZŹŻXV0123456789.,;:";
        final char[] alfabetPodreczny = alfab.toCharArray();

        String zaszyfrowany = zacezaruj( text, przesun, alfabetPodreczny );
        System.out.println("Twój tekst zaszyfrowany to: ");
        System.out.println(zaszyfrowany);
    }

    private static String zacezaruj(String text, int przesun, char[] baseAlfab) {
        StringBuilder szyfr = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            for (int j = 0; j < baseAlfab.length; j++) {
                if (baseAlfab[j] == text.charAt(i) && j < baseAlfab.length-przesun && przesun > 0 ){
                    szyfr.append(baseAlfab[ j+przesun ]);
                    break;

                }else if ( baseAlfab[j] == text.charAt(i) && przesun > 0 ) {
                    int odPocz = przesun + j - baseAlfab.length;
                    szyfr.append(baseAlfab[odPocz]);
                    break;

                }else if (baseAlfab[j] == text.charAt(i) ){
                    int odPocz = j + przesun;
                    if (odPocz < 0){
                        szyfr.append(baseAlfab[baseAlfab.length + przesun]);
                    }else {
                        szyfr.append(baseAlfab[odPocz]);
                    }
                    break;

                }else if (j == baseAlfab.length-1) {
                    szyfr.append( text.charAt(i) );
                }
            }
        }

        return szyfr.toString();
    }


    private static int dajInt() {
        Scanner wpisz = new Scanner(System.in);
        while (!wpisz.hasNextInt() ){
            wpisz.next();
        }
        return wpisz.nextInt();
    }

    private static void zad13() {
        System.out.println("Program sprawdzi czy poprawnie wpisałeś nawiasy do wyrażenia arytmet: ");
        System.out.println("*********************************************************************");
        System.out.println("Podaj wyrażenie z nawiasami:");
        String text = dajTekst();

        StringBuilder tekstNoSpace = usunSpacje( text );
        String[] poprawioneNawiasy = poprawNawiasy ( tekstNoSpace.toString() );

        System.out.println("Poprawione wyrażenie: ");
        System.out.println(poprawioneNawiasy[1]);
        System.out.println("*********************");
        System.out.println(poprawioneNawiasy[0]);

    }

    private static String[] poprawNawiasy(String tekst) {
        int ileOtwier = 0, ileZamykaj = 0;
        StringBuilder poprawny = new StringBuilder();

        for (int i = 0; i < tekst.length(); i++) {
            if (i == 0 && tekst.charAt(0) != '(' ){
                poprawny.append('(');
                ileOtwier++;
            }

            poprawny.append(tekst.charAt(i) );

            if (tekst.charAt(i) == '('){
                ileOtwier++;
            }else if (tekst.charAt(i) == ')' ){
                ileZamykaj++;
            }else if ( i < tekst.length()-1 && ( tekst.charAt(i+1) == '/' || tekst.charAt(i+1) == '*' ) ){
                poprawny.append(')');
                ileZamykaj++;
            }else if ( i < tekst.length()-1 && tekst.charAt(i+1) == '-' && tekst.charAt(i) == '-'  ){
                poprawny.deleteCharAt( poprawny.length()-1 );
                poprawny.append(')');
                ileZamykaj++;
                poprawny.append('-');
                poprawny.append('(');
                ileOtwier++;
            }else if ( i < tekst.length()-1 && ( tekst.charAt(i) == '/' || tekst.charAt(i) == '*' ) && tekst.charAt(i+1) != '(' ){
                poprawny.append('(');
                ileOtwier++;
            }

            if ( i == tekst.length()-1 && tekst.charAt(tekst.length()-1) != ')' ){
                poprawny.append(')');
                ileZamykaj++;
            }
        }

        if (ileOtwier == ileZamykaj ) {
            return new String[] {"Wyrażenie ma poprawnie wpisane nawiasy", poprawny.toString() };
        }else {
            return new String[] {"Brak poprawności nawiasów, dostępna bliska do poprawności wersja ", poprawny.toString() };
        }
    }

    private static StringBuilder usunSpacje(String tekst) {
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < tekst.length() ; i++) {
            if (tekst.charAt(i) != ' '){
                wynik.append( tekst.charAt(i) );
            }
        }
        return wynik;
    }

    private static void zad12() {
        System.out.println("Program podany tekst od końca: ");
        System.out.println("*********************************************************************");
        System.out.println("Podaj tekst:");
        String text = dajTekst();

        StringBuilder odKonca = new StringBuilder();
        odKonca = odwrocZnaki( odKonca, text.length()-1, text);
        System.out.println( odKonca.toString() );
    }

    private static StringBuilder odwrocZnaki(StringBuilder odKonca, int ktoryZnak, String tenTekst) {
        odKonca.append( tenTekst.charAt( ktoryZnak ) );

        if ( ktoryZnak == 0 ){
            return odKonca;
        }else {
            return odwrocZnaki(odKonca, ktoryZnak-1, tenTekst);
        }
    }

    private static void zad11() {
        System.out.println("Program podany tekst od końca: ");
        System.out.println("*********************************************************************");
        System.out.println("Podaj tekst:");
        String text = dajTekst();

        StringBuilder odKonca = new StringBuilder();
        for (int i = text.length()-1 ; i >= 0; i--) {
            odKonca.append( text.charAt(i) );
        }

        System.out.println( odKonca.toString() );

    }

    private static void zad10() {
        System.out.println("Program wypiszę ile razy w podanym tekście występuje ostatni znak: ");
        System.out.println("*********************************************************************");
        System.out.println("Podaj tekst:");
        String text = dajTekst();

        StringBuilder ostZnak = new StringBuilder();
        ostZnak.append( text.charAt( text.length() -1 ) );
        Pattern tenZnak = Pattern.compile( ostZnak.toString() );

        int sumaWystap = 0;
        Matcher ileWtekcie = tenZnak.matcher( text );
        while ( ileWtekcie.find() ){
            sumaWystap++;
        }

        System.out.println("Ostatni znak z tekstu = " + ostZnak.toString() + " i występuje on " + sumaWystap + " razy");
    }

    private static void zad9() {
        System.out.println("Oto działający kalkulator");
        System.out.println("**************************");
        System.out.println( Kalkulator.infoplusStart() );


    }

    private static void zad8() {
        System.out.println("Program rozdzielający słowa w tekście i zliczający je. ");
        String text = prosbaOTekstPelna();
        System.out.println("********************");
        System.out.println("Słowa z twojego tekstu wraz z wystąpieniami to :\n");

        Pattern szukany = Pattern.compile("(\\w{2,}[ąćęóźżłńĄśĘŻŹÓŚĆŁŃ]*\\w* )|(\\w*[ąćęóźżłńĄśĘŻŹÓŚĆŁŃ]*\\w{2,} )");
        Matcher slowoWTekscie = szukany.matcher(text);
        Map<String, Integer> listaSlow = new TreeMap<>();

        while ( slowoWTekscie.find() ){
            if (listaSlow.containsKey( slowoWTekscie.group() ) ){
                listaSlow.replace(slowoWTekscie.group(), listaSlow.get(slowoWTekscie.group()), listaSlow.get(slowoWTekscie.group())+1 );
            }else {
                listaSlow.put(slowoWTekscie.group(), 1);
            }
        }

        System.out.println(listaSlow);


    }

    private static String prosbaOTekstPelna(){
        System.out.println("Podaj Tekst: ");
        return dajTekst();
    }

    private static void zad7() {
        System.out.println("Program zamieniające wielkości liter w tekście.");
        String text = prosbaOTekstPelna();
        System.out.println("********************");
        System.out.println("Twój tekst :\n");

        String[] znakiTekstu = text.split("");
        for (int i = 0; i < znakiTekstu.length; i++) {
            if (znakiTekstu[i].charAt(0) > 64 && znakiTekstu[i].charAt(0) < 91 ){
                znakiTekstu[i] = znakiTekstu[i].replace(znakiTekstu[i].charAt(0), (char)(znakiTekstu[i].charAt(0) + 32) );

            }else if ( znakiTekstu[i].charAt(0) > 96 && znakiTekstu[i].charAt(0) < 123 ){
                znakiTekstu[i] = znakiTekstu[i].replace(znakiTekstu[i].charAt(0), (char)(znakiTekstu[i].charAt(0) - 32) );
            }
        }

        StringBuilder zPowrotem = new StringBuilder();
        for (String taki: znakiTekstu) {
            zPowrotem.append(taki);
        }
        text = zPowrotem.toString();

        System.out.println(text);
    }

    private static void zad6() {
        System.out.println("Program zamieniające przecinki w tekście.");
        String text = prosbaOTekstPelna();
        System.out.println("********************");
        System.out.println("Twój tekst :\n");
        text = text.replaceAll(",", "makarena");
        System.out.println(text);

    }

    private static void zad5() {
        System.out.println("Program zliczający ilość liter w tekście.");
        String text = prosbaOTekstPelna();
        int sumaLiter = zliczajLitery( text, 0 );
        System.out.println("********************");
        System.out.println("Twój tekst ma: " + sumaLiter + " liter");

    }

    private static int zliczajLitery(String text, int ktory) {
        int suma = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > 96 && text.charAt(i) < 123){
                suma++;
            }

            if (text.charAt(i) > 64 && text.charAt(i) < 91){
                suma++;
            }
        }

        return suma;
    }

    private static void zad4() {
        System.out.println("Litery od 'a' do 'z' :");
        for (int i = 97; i < 123; i++) {
            System.out.print((char)i + " , " + (char)(i-32) + " , ");
        }

    }

    private static void zad3() {
        System.out.println("Wpisz tekst do sprawdzenia: ");
        String text = dajTekst();
        System.out.println("Wpisz co bedziesz wyszukiwał w tekscie : ");
        String szukaj = dajTekst();

        System.out.println("Czy twój tekst zawiera szukaną frazę " + szukaj + " : ");
        System.out.println("*******************");
        System.out.println( text.contains("ania") );
        System.out.println("Indeks pierwszego wystapienia frazy " + szukaj + " : ");
        System.out.println("*******************");
        System.out.println( text.toLowerCase().indexOf( szukaj ) );

    }

    private static void zad1i2() {
        System.out.println("Wpisz tekst do sprawdzenia: ");
        String text = dajTekst();
        System.out.println("Twój tekst to: " + text + " \n");
        zad1AdoF( text );
    }

    private static void zad1AdoF(String text) {
        System.out.println("Czy twój tekst zawiera \"ania\" : ");
        System.out.println("*******************");
        System.out.println( text.contains("ania") );

        System.out.println("Czy twój tekst rozpoczyna się od \"ania\" : ");
        System.out.println("*******************");
        System.out.println( text.startsWith("ania") );

        System.out.println("Czy twój tekst kończy się na \"ania\" : ");
        System.out.println("*******************");
        System.out.println( text.endsWith("ania") );

        System.out.println("Czy twój tekst equals \"ania\" : ");
        System.out.println("*******************");
        System.out.println( text.equals("ania") );

        System.out.println("Czy twój tekst zawiera \"ania\" niezależnie od wielkości liter : ");
        System.out.println("*******************");
        System.out.println( text.toLowerCase().contains("ania") );

        System.out.println("Indeks pierwszego wystapienia  \"ania\" to :");
        System.out.println("*******************");
        System.out.println( text.toLowerCase().indexOf("ania") );


    }

    private static String dajTekst() {
        Scanner wpisz = new Scanner(System.in);
        return wpisz.nextLine();
    }






}
