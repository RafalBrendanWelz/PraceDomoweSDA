package ListopadPart2.Robot;

public enum RuchRobota {
    KROK_LEWA (15),
    KROK_PRAWA (15),
    RUCH_REKA_LEWA (2),
    RUCH_REKA_PRAWA (3),
    SKOK (25);

    protected int wymogiBaterii;

    RuchRobota(int wymogiBaterii) {
        this.wymogiBaterii = wymogiBaterii;
    }
}
