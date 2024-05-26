public class Szesciokat extends Figura{
    double bok;
    Szesciokat(double bok){
        this.bok=bok;
    }
    public double pole(){
        return 3*bok*bok*Math.sqrt(3)/2;
    }
    public double obwod(){
        return bok*6;
    }
    public void wypisz(){
        System.out.println("Pole Szczesciokata "+ pole());
        System.out.println("Obwod Szczesciokata "+ obwod());

    }
}
