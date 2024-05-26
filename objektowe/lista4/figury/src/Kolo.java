public class Kolo extends Figura {
    double r;
    Kolo(double r){
        this.r=r;
    }
    public double obwod(){
        return(2*r*Math.PI);
    }
    public double pole(){
        return(r*r*Math.PI);
    }
    public void wypisz(){
        System.out.println("Pole kola: "+pole());
        System.out.println("Obwod kola: "+obwod());

    }
}
