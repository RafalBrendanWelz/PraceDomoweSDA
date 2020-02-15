package Grudzien.KolekcjeSety12;

public class ParaLiczb {
    int a;
    int b;

    public ParaLiczb(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString (){
        return "("+a+","+b+")";
    }

}
