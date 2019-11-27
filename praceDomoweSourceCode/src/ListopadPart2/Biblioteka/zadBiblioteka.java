package ListopadPart2.Biblioteka;

public class zadBiblioteka {

    public static void glowne() {
        Autor[] wielcyPisarze = dodajListaWielcyPisarze();
        Autor[] wielcyNaukoPisarze = dodajListaWielcyNaukoPis();

        Biblioteka pierwsza = new Biblioteka( wypelnijBiblioteke(wielcyPisarze, wielcyNaukoPisarze) , "Gdańsk ul. Costamowskiego 32/12", 3);
        System.out.println(pierwsza.allEgzemplarzy.length);


        Egzemplarz[] wyszukane = pierwsza.szukajPoTytule();
        pokazZbior(wyszukane);

        pierwsza.wypozycz(new Czlowiek("Jan", "Nowak"), wyszukane);

        wyszukane = pierwsza.szukajPoAutorzeiTytule();
        pierwsza.wypozycz(wielcyPisarze[4], wyszukane);

        pokazZbior(wyszukane);
        pierwsza.dodajEgzemplarz(new Ksiazka(wielcyNaukoPisarze[3], "Kolejna Ksiazka", 275) );
        pierwsza.dodajEgzemplarz(new Ksiazka(wielcyNaukoPisarze[3], "Taka oto Książka", 279) );


        wyszukane = pierwsza.szukajPoAutorzeiTytule();
        pierwsza.wypozycz(wielcyPisarze[4], wyszukane);


    }


    private static Autor[] dodajListaWielcyNaukoPis() {
        Autor eins = new Autor("Albert", "Einstein");
        Autor nic = new Autor("Friedrich", "Nietsche");
        Autor prat = new Autor("Terry", "Pratchet");
        Autor edins = new Autor("Thomas", "Edinson");
        Autor kop = new Autor("Mikołaj", "Kopernik");

        return new Autor[] {eins, nic, prat, edins, kop};
    }

    private static Autor[] dodajListaWielcyPisarze() {
        Autor tolk = new Autor("John Ronald Reul", "Tolkienn");
        Autor bradb = new Autor("Ray", "Bradbury");
        Autor lcraft = new Autor("H.P", "Lovecraft");
        Autor sienk = new Autor("Henryk ", "Sienkiewicz");
        Autor another = new Autor("Jeremy Ted", "Anotherson");

        return new Autor[] {tolk, bradb, lcraft, sienk, another};
    }

    private static Egzemplarz[] wypelnijBiblioteke(Autor[] poec, Autor[] scis) {
        //startowe książki
        Egzemplarz ksieg1 = new Ksiazka(new Autor("Jan", "Kowalski"), "Księga 1 jakaśTam", 234);
        Egzemplarz koperObrot = new Czasopismo(scis[4], "O obrotach sfer niebieskich ", 34, "Podstawy", 4);
        Egzemplarz sienk1 = new Czasopismo(poec[3], "Nowele ", 7, "Latarnik", 14);
        Egzemplarz sienk2 = new Czasopismo(poec[3], "Nowele ", 8, "Stary Sługa", 2);
        Egzemplarz sienk3 = new Czasopismo(poec[3], "Nowele ", 11, "Sachem", 18);
        Egzemplarz sienk4 = new Ksiazka(poec[3], "Krzyżacy ", 295);
        Egzemplarz sienk5 = new Czasopismo(poec[3], "Nowele ", 11, "Janko Muzykant", 7);
        Egzemplarz sienk6 = new Ksiazka(poec[3], "Ogniem i Mieczem ", 295);
        Egzemplarz sienk7 = new Ksiazka(poec[3], "Pan Wołodyjowski ", 295);
        Egzemplarz hobbi = new Ksiazka(poec[0], "Hobbit: Czyli tam i z powrotem", 263);
        Egzemplarz lotr1 = new Ksiazka(poec[0], "Władca Pierścieni: Drużyna Pierścienia", 395);
        Egzemplarz lotr2 = new Ksiazka(poec[0], "Władca Pierścieni: Dwie Wieże", 410);
        Egzemplarz lotr3 = new Ksiazka(poec[0], "Władca Pierścieni: Powrót Króla", 490);
        Egzemplarz silmar = new Ksiazka(poec[0], "Silmarillion", 890);
        Egzemplarz bury1 = new Ksiazka(poec[1], "Kroniki Marsjańskie", 212);
        Egzemplarz lov1 = new Czasopismo(poec[2], "Opowieści Lovecrafta", 13, "Unspeakable Evilness", 20);
        Egzemplarz lov2 = new Czasopismo(poec[2], "Opowieści Lovecrafta", 21, "Color of Madness", 13);
        Egzemplarz lov3 = new Czasopismo(poec[2], "Opowieści Lovecrafta", 31, "Call of Cthulhu", 9);
        Egzemplarz ksieg2 = new Ksiazka(poec[4], "Książka Anothersona", 191);
        Egzemplarz discW1 = new Ksiazka(scis[2], "Disc World: Trzy Wiedźmy", 113);
        Egzemplarz ksiegEinst = new Ksiazka(scis[0], "E = mc^2", 79);
        Egzemplarz ksiegiNietschego = new Ksiazka(scis[1], "Wędrowiec i jego cień", 46);
        Egzemplarz ksiegTome = new Ksiazka(new Autor("Mark", "Twain"), "Przygody Tomka Sayera", 234);
        Egzemplarz grimm = new Ksiazka(new Autor("Wilhelm ", "Grimm"), new Autor("Jacob", "Grimm"), "Baśnie Braci Grimm", 190);

        return new Egzemplarz[] {ksieg1, koperObrot, sienk1, sienk2, sienk3, lotr1, lotr2, lotr3, silmar, bury1, lov1, lov2, lov3, ksieg2, discW1, ksiegEinst, ksiegiNietschego
                                , sienk4, sienk5, sienk6, sienk6, sienk7, ksiegTome, hobbi, grimm};
    }


    public static void pokazZbior(Egzemplarz[] zbior){
        System.out.println(zbior.length + " książek: ");
        for (int i = 0; i < zbior.length; i++) {
            System.out.println( zbior[i].tytul );
        }
        System.out.println(" ");
    }






}
