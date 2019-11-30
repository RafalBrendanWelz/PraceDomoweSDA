package ListopadPart2.KlasyFeudalne;


public class Zad2Feudalni {

    public static void zad2Start() {
        Town miastoPierwsze = new Town(dodajMieszkPierwsz(), "Pierwszowice Wielkie", Krolestwa.POLSKIE);
        miastoPierwsze.opiszMiasto();

    }

    private static Citizen[] dodajMieszkPierwsz() {
        Peasant Marek = new Peasant("Marek", 'M');
        Peasant Jozek = new Peasant("Józek", 'M');
        Peasant Kamila = new Peasant("Kamila", 'K');
        Peasant Basia = new Peasant("Basia", 'K');
        Peasant Patra = new Peasant("Patra", 'K');
        Peasant Kazmira = new Peasant("Kazmira", 'K');
        Peasant Halina = new Peasant("Halina", 'K');
        Peasant Romek = new Peasant("Romek", 'M');
        Peasant Halina2 = new Peasant("Halina", 'K');
        Peasant Zdisia = new Peasant("Zdisia", 'K');
        Peasant Lubomira = new Peasant("Lubomira", 'K');
        Townsman Jagoda = new Townsman("Jagoda", 'K');
        Townsman Kamila2 = new Townsman("Kamila", 'K');
        Townsman Anna = new Townsman("Anna", 'K');
        Townsman Basia2 = new Townsman("Basia", 'K');
        Townsman Tomaszek = new Townsman("Tomaszek", 'M');
        Townsman Kornelia = new Townsman("Kornelia", 'K');
        Soldier Wojmil = new Soldier("Wojmił");
        Soldier Kosmierz = new Soldier("Kośmierz");
        Soldier Bury = new Soldier("Buromir");
        Soldier Andrzej = new Soldier("Andrzej");
        Soldier Mieszek = new Soldier("Mieszek");
        Soldier Jonin = new Soldier("Jonin");
        LFamMember Roman = new LFamMember("Roman II Paskudny", 'M', Krolestwa.POLSKIE, HeirPosition.KING);
        LFamMember Matylda = new LFamMember("Matylda", 'K', Krolestwa.POLSKIE, HeirPosition.PRINCESS);
        LFamMember Grubalda = new LFamMember("Baldina Grubaśna", 'K', Krolestwa.POLSKIE, HeirPosition.QUEEN);

        return new Citizen[] {Marek, Jozek, Kamila, Basia, Patra, Kazmira, Halina, Romek, Halina2, Zdisia, Lubomira, Jagoda, Kamila2, Anna, Basia2, Tomaszek, Kornelia,
                Wojmil, Kosmierz, Bury, Andrzej, Mieszek, Jonin, Roman, Matylda, Grubalda};
    }


}
