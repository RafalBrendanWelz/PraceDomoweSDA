package Grudzien.Slack2Gru.zadanie4;

public abstract class Wielokat implements IFigura{
        int[] boki;

        @Override
        public double obliczObwod(){
            double sumaBok = 0;
            for (int bok: this.boki) {
                sumaBok += bok;
            }
            return sumaBok;
        }






}
