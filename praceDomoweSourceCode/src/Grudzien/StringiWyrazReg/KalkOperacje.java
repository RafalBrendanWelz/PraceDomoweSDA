package Grudzien.StringiWyrazReg;

public enum KalkOperacje {
    DODAJ('+'),
    ODEJM('-'),
    DZIEL('/'),
    MNOZ('*'),
    RESZTAZDZIEL('r'),
    PROCENTZ('%'),
    DOPOTEG('^');

    private char znak;

    public char getZnak() {
        return znak;
    }

    KalkOperacje(char znak) {
        this.znak = znak;
    }



}
