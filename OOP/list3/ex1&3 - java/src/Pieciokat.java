public class Pieciokat extends Figura {
    double bok;
    Pieciokat(double bok){
        this.bok=bok;
    }

    public double pole(){
        return bok*bok*Math.sqrt(10*Math.sqrt(5))/4;
    }
    public double obwod(){
        return bok*5;
    }
    public void wypisz(){
        System.out.println("Pole Pieciokata: "+pole());
        System.out.println("Obwod Pieciokata: " +obwod());

    }
}
