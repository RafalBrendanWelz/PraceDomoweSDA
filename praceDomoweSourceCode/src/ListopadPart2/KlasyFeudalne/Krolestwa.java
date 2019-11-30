package ListopadPart2.KlasyFeudalne;

public enum Krolestwa {
    POLSKIE ("Królestwo Polskie"),
    NIEMIECKIE ("Święte Cesarstwo Rzymskie Narodu Niemieckiego"),
    LOKALNE ("Miasto Autonomiczne"),
    WEGIERSKIE ("Królestwo Węgier"),
    FRANC ("Królestwo Francuzkie"),
    HORDA ("Zjednoczona Horda Plemion"),
    BANDYCI ("Ziemie Bandyckie/Sił Niezależnych");

    protected LFamMember krol;
    protected String pelnaNazwa;

    Krolestwa(String pelnaNazwa){
        this.pelnaNazwa = pelnaNazwa;
    }



}
