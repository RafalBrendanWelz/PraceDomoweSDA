package ListopadPart2.Biblioteka;

import java.util.Scanner;

public class Biblioteka {
    Egzemplarz[] allEgzemplarzy;

    protected String nazwaBiblio;
    protected String adres;
    protected int numerFilli;

    Biblioteka(Egzemplarz[] wszystkie, String adres, int numerFilli) {
        this.allEgzemplarzy = wszystkie;
        this.adres = adres;
        this.nazwaBiblio = "Biblioteka Publiczna w Gdańsku";
        this.numerFilli = numerFilli;
    }

    public Egzemplarz[] szukajZAll(jakWyszukiwac sposob, String zwrot){
        Egzemplarz[] pasujace = new Egzemplarz[this.allEgzemplarzy.length];
        int iloscWyszukana = 0;

        switch (sposob){
            case POAUTORZE:{
                for (int i = 0; i < this.allEgzemplarzy.length; i++) {
                    if (this.allEgzemplarzy[i].jakiAutor().contains(zwrot) ) {
                        pasujace[iloscWyszukana] = this.allEgzemplarzy[i];
                        iloscWyszukana++;
                    }
                }
                break;
            }
            case POTYTULE:{
                for (int i = 0; i < this.allEgzemplarzy.length; i++) {
                    if (this.allEgzemplarzy[i].jakiTytul().contains(zwrot)) {
                        pasujace[iloscWyszukana] = this.allEgzemplarzy[i];
                        iloscWyszukana++;
                    }
                }
                break;
            }
            case POAUTORZELUBTYTULE:{
                for (int i = 0; i < this.allEgzemplarzy.length; i++) {
                    if (this.allEgzemplarzy[i].jakiAutor().contains(zwrot) || this.allEgzemplarzy[i].jakiTytul().contains(zwrot)) {
                        pasujace[iloscWyszukana] = this.allEgzemplarzy[i];
                        iloscWyszukana++;
                    }
                }
                break;
            }

        }

        Egzemplarz[] wynik = new Egzemplarz[iloscWyszukana];
        for (int i = 0; i < wynik.length; i++) {
            wynik[i] = pasujace[i];
        }
        return wynik;
    }


    public Egzemplarz[] szukajPoTytule() {
        System.out.println("Wpisz tytuł którego szukasz ");
        String znajdzTyt = coSzukasz();

        return szukajZAll(jakWyszukiwac.POTYTULE, znajdzTyt);
    }

    public Egzemplarz[] szukajPoAutorze() {
        System.out.println("Wpisz autora którego szukasz ");
        String imieNazwAutor = coSzukasz();

        return szukajZAll(jakWyszukiwac.POAUTORZE, imieNazwAutor);
    }

    public Egzemplarz[] szukajPoAutorzeiTytule(){
        System.out.println("Wpisz frazę (autor,tytuł) której szukasz ");
        String fraza = coSzukasz();

        return szukajZAll(jakWyszukiwac.POAUTORZELUBTYTULE, fraza);
    }

    public Egzemplarz[] dodajEgzemplarz(Egzemplarz nowaKsiaga){
        Egzemplarz[] stareAll = allEgzemplarzy;
        allEgzemplarzy = new Egzemplarz[allEgzemplarzy.length+1];

        for (int i = 0; i < stareAll.length; i++) {
            allEgzemplarzy[i] = stareAll[i];
        }
        allEgzemplarzy[stareAll.length] = nowaKsiaga;

        return allEgzemplarzy;
    }


    private static String coSzukasz() {
        Scanner wpiszTekst = new Scanner(System.in);

        return wpiszTekst.nextLine().trim().toLowerCase();
    }


   public Egzemplarz[] wypozycz(Czlowiek kto, Egzemplarz[] wyszukane){
       Egzemplarz coWypozycza = wybor1z( wyszukane );


       if (coWypozycza == null){
           System.out.println(kto.imieNazwisDaj() + " przyszedł/a i nic nie wypożyczył.");
           return this.allEgzemplarzy;

       }else {
           Egzemplarz[] stareAll = this.allEgzemplarzy;
           this.allEgzemplarzy = new Egzemplarz[this.allEgzemplarzy.length-1];

           for (int i = 0; i < stareAll.length; i++) {
               if (i == stareAll.length-1 ){
                    break;
               }else if (stareAll[i] != coWypozycza ) {
                   this.allEgzemplarzy[i] = stareAll[i];
               }else {
                   this.allEgzemplarzy[i] = stareAll[stareAll.length-1];
               }
           }

           System.out.println(kto.imieNazwisDaj() + " wypożyczył książkę: " + coWypozycza.jakiTytul() + " autora " + coWypozycza.jakiAutor() );
           return allEgzemplarzy;
       }
    }

    private Egzemplarz wybor1z(Egzemplarz[] zCzegoWybor) {
        System.out.println("Wpisz numer by wybrać ksiązkę");
        przedstawWybory( zCzegoWybor );
        int ktora = scanerKtore();

        for (int i = 1; i < zCzegoWybor.length+1; i++) {
            if (i == ktora){
                return zCzegoWybor[i-1];
            }
        }

        return null;
    }

    private int scanerKtore() {
        Scanner wpiszCyfre = new Scanner(System.in);

       while (!wpiszCyfre.hasNextInt()){

           wpiszCyfre.next();
       }

       return wpiszCyfre.nextInt();
    }

    private void przedstawWybory(Egzemplarz[] zCzegoWybor) {
        for (int i = 1; i < zCzegoWybor.length+1; i++) {
            System.out.println("Wpisz " + i + " dla: " + zCzegoWybor[i-1].jakiTytul() );
        }
    }



}
