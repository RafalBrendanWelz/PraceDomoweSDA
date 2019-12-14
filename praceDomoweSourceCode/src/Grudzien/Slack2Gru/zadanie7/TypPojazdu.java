package Grudzien.Slack2Gru.zadanie7;

public enum TypPojazdu {
    CIEZAROWKA (0.3),
    SAMOCHOD (0.19),
    MOTOCYKL (0.13);

    double oplataZaMinute;

    TypPojazdu(double oplataZaMinute) {
        this.oplataZaMinute = oplataZaMinute;
    }



}
