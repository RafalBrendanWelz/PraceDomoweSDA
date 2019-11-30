package ListopadPart2.Komputery;

public class Laptop extends Komputer {
   double wielkoscMatrycy;
   boolean posiadaGownoWartomRetine;   // (Retina = na polski Siatkówka - część oka odpowiedzialna za odbieranie bodźców wzrokowych znajduje się wewnątrz oka na tylne powierzchni
                            // i znajdują się w niej komórki nerwowe posiadające światłoczułe neurony - źródło Wiki)

                            // ( Retina jako specyfikacja laptopa oznacza: Retina is an Apple marketing term for which there's no concrete definition:
                            // put simply, a Retina display is any screen Apple has decided to call that.
                            // There are however, features which set Retina displays apart from non-Retina screens  - źródło https://www.macworld.co.uk/feature/apple/retina-display-3466732/

                            //" "Retina display" is a proprietary marketing term from Apple. There is no
                            //"INDUSTRY standard". It's a brand name. "  best answer from:
                            // - https://answers.microsoft.com/en-us/surface/forum/surfstudio-surfdrivers/does-surface-laptop-have-a-retina-display/142845ad-2da4-46ae-899b-abbc84d406cc


    public Laptop(int potrzebnaMoc, String producent, String model, typyProcesora typ, double wielkoscMatrycy, boolean posiadaGownoWartomRetine) {
        super(potrzebnaMoc, producent, model, typ);
        this.wielkoscMatrycy = wielkoscMatrycy;
        this.posiadaGownoWartomRetine = posiadaGownoWartomRetine;
    }


    @Override
    public String opis(){
        if (posiadaGownoWartomRetine){
            return this.producent + " " + this.model + " " + this.procesor + " Wymagana moc Akulumator = "
                    + this.potrzebnaMoc + "W " + " Wielkosc Matrycy = " + this.wielkoscMatrycy + " nie nadaje się do kupna";
        }else {
            return this.producent + " " + this.model + " " + this.procesor + " Wymagana moc Akulumator = "
                    + this.potrzebnaMoc + "W " + " Wielkosc Matrycy = " + this.wielkoscMatrycy + " jest ok";
        }

    }





}
