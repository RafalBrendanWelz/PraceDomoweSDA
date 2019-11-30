package ListopadPart2.Komputery;

public class Komputer {
    int potrzebnaMoc;
    String producent;
    String model;
    typyProcesora procesor ;

    Komputer(int potrzebnaMoc, String producent, String model, typyProcesora typ){
        this.producent = producent;
        this.model = model;
        this.potrzebnaMoc = potrzebnaMoc;
        this.procesor = typ;

    }

    public String opis(){
        return this.producent + " " + this.model + " " + this.procesor + " Wymagana moc Akulumator = " + this.potrzebnaMoc + "W ";
    }


}
