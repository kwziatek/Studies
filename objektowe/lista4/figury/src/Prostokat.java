public class Prostokat extends Czworokat{

    Prostokat(double b1,double b2, double b3, double b4, double k){
        bok1=b1;
        bok2=b2;
        bok3=b3;
        bok4=b4;
        kat=k;
    }
    public double pole(){
        if(bok2!=bok1)
            return bok1*bok2;
        return bok1*bok3;
    }
    public double obwod(){
        if(bok2!=bok1)
            return 2*(bok1+bok2);
        return 2*(bok1+bok3);
    }
    public void wypisz(){
        System.out.println("Pole Prostokata "+ pole());
        System.out.println("Obwod Prostokata "+ obwod());

    }
}
