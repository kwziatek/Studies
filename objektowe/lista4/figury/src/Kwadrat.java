public class Kwadrat extends Czworokat{
    Kwadrat(double b1,double b2, double b3, double b4, double k){
        bok1=b1;
        bok2=b2;
        bok3=b3;
        bok4=b4;
        kat=k;
    }
    public double pole(){
        return bok1*bok1;
    }
    public double obwod(){
        return bok1*4;
    }
    public void wypisz(){
        System.out.println("Pole Kwadratu"+ pole());
        System.out.println("Obwod Kwadratu"+ obwod());
    }
}
