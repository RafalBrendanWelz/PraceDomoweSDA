package ListopadPart2.Komputery;

public class Zad1Komputery {

    public static void zad1Start() {        //? czy chodziło o jakiś zupełnie inny sposób wykonania? Ten jaki dałem wydaje mi się logiczny, krótki i dobry
        Komputer[] listaKompow = stworzKomputeryiLaptopy();         // ale kilka elementów z treści zadania są tu zbyteczne i to może działać bez nich

        wypiszAll(listaKompow);

    }

    private static void wypiszAll(Komputer[] listaKompow) {
        int i = 0;

        while (i<listaKompow.length){
            if (listaKompow[i] instanceof Laptop){      //? niepotrzebne jest tu użycie instanceof bo chyba najkrócej je wypisywać przez odwołanie do ich własnej metody opisu
                System.out.println(listaKompow[i].opis());      //więc dodane dla treści zadania
            }else {
                System.out.println(listaKompow[i].opis());
            }
            i++;
        }

    }


    private static Komputer[] stworzKomputeryiLaptopy() {
        Laptop[] laptopy = stworzLaptopy();     //? oddzielne tabele połączone później bo w zadaniu: "... .Umieść je w tabelach, a następnie wypisz ..."
        Komputer[] komputery = stworzKomputery();       //można by też krócej te dwie metody wstawić tutaj zamiast pętli poniżej


        Komputer[] listaWynik = new Komputer[laptopy.length + komputery.length];
        for (int i = 0; i < laptopy.length+komputery.length; i++) {
            if (i<laptopy.length){
                listaWynik[i] = laptopy[i];
            }else {
                listaWynik[i] = komputery[i-laptopy.length];
            }
        }

        return listaWynik;
    }

    private static Laptop[] stworzLaptopy() {
        Laptop pierwszy = new Laptop(400, "Producent", "Model", typyProcesora.WIELORDZENIOWY, 17.5, false);
        Laptop drugi = new Laptop(350, "Lenovo", "C-d32", typyProcesora.WIELORDZENIOWY, 19, false);
        Laptop trzeci = new Laptop(400, "HP", "Model", typyProcesora.WIELORDZENIOWY, 23, false);
        Laptop czwarty = new Laptop(300, "Producent", "Model2", typyProcesora.WIELORDZENIOWY, 17.5, false);
        Laptop piaty = new Laptop(250, "Producent", "Towo", typyProcesora.WIELORDZENIOWY, 15, false);


        return new Laptop[] {pierwszy, drugi, trzeci, czwarty, piaty};
    }

    private static Komputer[] stworzKomputery() {
        Komputer taki = new Komputer(500, "Producent", "Model", typyProcesora.WIELORDZENIOWY);
        Komputer sraki = new Komputer(400, "Lenovo", "C-d32", typyProcesora.WIELORDZENIOWY);
        Komputer maki = new Komputer(200, "HP", "Model", typyProcesora.JEDNORDZENIOWY);
        Komputer powaki = new Komputer(300, "Producent", "Model2", typyProcesora.WIELORDZENIOWY);
        Komputer iToki = new Komputer(300, "Producent", "Towo", typyProcesora.WIELORDZENIOWY);

        return new Komputer[] {taki, sraki, maki, powaki, iToki};
    }


}
