package ListopadPart2.KlasyFeudalne;

public enum HeirPosition {
    KING ("Król"),
    QUEEN ("Królowa"),
    PRINCESS("Księżniczka"),
    PRINCE("Książe"),
    GOVERNOR("Gubernator");

    protected String nazwa;

    HeirPosition(String nazwa){
        this.nazwa = nazwa;
    }

}
