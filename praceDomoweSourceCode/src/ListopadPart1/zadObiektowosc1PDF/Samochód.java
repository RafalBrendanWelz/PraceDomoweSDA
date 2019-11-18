package ListopadPart1.zadObiektowosc1PDF;

public class Samochód {
    private static String[] marka = new String[] {"Fiat", "Toyota", "Subaru", "Honda", "Renault"};
    private static String[] model = new String[] {"126p", "Corolla", "Impreza", "Civic", "Thalia"};
    private static int ileAut;

    private int maxSpeed;
    private int id;
    String nazwa;
    int predkosc;

    protected Samochód(int typ, int maxSpeed){
        this.nazwa = (marka[typ] + " " + model[typ]);
        this.maxSpeed = maxSpeed;
        this.predkosc = 0;
        ileAut++;
        this.id = ileAut;
    }

    protected void autoInfo(){
        System.out.println("Samochód numer: " + id + " Dane:");
        System.out.println(nazwa + " max predkość = " + maxSpeed);

        if (this.predkosc>0){
            System.out.println("Aktualnie jedzie z prędkością " + this.predkosc + " km/h");
        }else if (this.predkosc==0){
            System.out.println("Aktualnie jest zaparkowany");
        }else {
            System.out.println("Aktualnie cofa się z prędkością " + this.predkosc + " km/h");
        }
    }

    protected void przyspieszO5km(){
      if (this.predkosc<=this.maxSpeed+5){
          this.predkosc+=5;
      }else if(this.nazwa.contains("126p")){
          System.out.println("Maluch szybciej już nie da rady ale za to się trzyma trasy speed= " + (this.maxSpeed+7) + " km/h");
          this.predkosc = this.maxSpeed+7;

      }else {
            System.out.println("Kraksa... samochód nr." + id + " " + this.nazwa + "wyleciał z trasy");
            this.predkosc = 0;
            this.maxSpeed /= 2;
      }
    }

    protected void zwolnijO5km(){
        if (this.predkosc> (this.maxSpeed*-1)/3){
            this.predkosc-=5;
        }else if (this.nazwa.contains("126p")){
            System.out.println("Ten samochód nr." +  id + " na wstecznym nie pojedzie szybciej niż " + (this.maxSpeed/3)+5 + " km/h");
            this.predkosc=((this.maxSpeed*-1)/3) +5;
        }else {
            System.out.println("Ten samochód nr." +  id + " na wstecznym nie pojedzie szybciej niż " + this.maxSpeed/3 + " km/h");
        }
    }


}
