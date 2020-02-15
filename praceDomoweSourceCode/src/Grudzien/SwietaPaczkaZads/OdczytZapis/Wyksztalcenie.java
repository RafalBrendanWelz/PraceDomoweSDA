package Grudzien.SwietaPaczkaZads.OdczytZapis;

public enum Wyksztalcenie {
    BRAK("Brak"),
    PODST("Podstawowe"),
    SREDNIE("Średnie"),
    ZAWODOWE("Zawodowe"),
    ZAWODiSREDNIE("Zawodowe_i_Średnie"),
    LICENCJAT("Licencjat"),
    ZAWODiWYZSZE("Zawodowe_i_Wyższe"),
    MAGISTRATiPROF("Magistrat_i_Ponad");

    private String nazwa;
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    Wyksztalcenie(String nazwa) {
        this.nazwa = nazwa;
    }



}
