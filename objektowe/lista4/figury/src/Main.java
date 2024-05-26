//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        try {
            Figura f;

            if(args.length<2){
                throw new Exception("Za malo argumentow");
            }
            if(args.length>6){
                throw new Exception("Za duzo argumentow");
            }

            switch (args[0].charAt(0)) {
                case 'o':
                    if(Double.parseDouble(args[1])<=0){
                        throw new Exception("Zbyt mala liczba");
                    }
                    f = new Kolo(Double.parseDouble(args[1]));
                    break;
                case 'p':
                    if(Double.parseDouble(args[1])<=0){
                        throw new Exception("Zbyt mala liczba");
                    }
                    f= new Pieciokat(Double.parseDouble(args[1]));
                    break;
                case 's':
                    if(Double.parseDouble(args[1])<=0){
                        throw new Exception("Zbyt mala liczba");
                    }
                    f= new Szesciokat(Double.parseDouble(args[1]));
                    break;
                case 'c':
                    if(args.length==6){
                        if((Double.parseDouble(args[1])<=0d)||(Double.parseDouble(args[2])<=0d)||(Double.parseDouble(args[3])<=0d)||(Double.parseDouble(args[4])<=0d)){throw new Exception("Zbyt mala liczba");}
                        else if(Double.parseDouble(args[5])==90d)
                        {
                            if(Double.parseDouble(args[1])==Double.parseDouble(args[2])&&Double.parseDouble(args[2])==Double.parseDouble(args[3])&&Double.parseDouble(args[3])==Double.parseDouble(args[4])){
                                f= new Kwadrat(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]));
                            }
                            else if((Double.parseDouble(args[1])==Double.parseDouble(args[2])&&Double.parseDouble(args[3])==Double.parseDouble(args[4]))
                                    ||(Double.parseDouble(args[1])==Double.parseDouble(args[3])&&Double.parseDouble(args[2])==Double.parseDouble(args[4]))
                                    ||(Double.parseDouble(args[1])==Double.parseDouble(args[4])&&Double.parseDouble(args[3])==Double.parseDouble(args[2]))){
                                f= new Prostokat(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]));
                            }
                            else{
                                throw new Exception("Nieprawidlowe argumenty");
                            }
                        }
                        else if(Double.parseDouble(args[1])==Double.parseDouble(args[2])&&Double.parseDouble(args[2])==Double.parseDouble(args[3])&&Double.parseDouble(args[3])==Double.parseDouble(args[4])){
                            f= new Romb(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]));
                        }
                        else{
                            throw new Exception("Nieprawidlowe argumenty");
                        }
                    }
                    else{
                        throw new Exception("Zla ilosc argumentow");
                    }
                    break;

                default:
                    throw new Exception("Zle oznaczenie figury");




            }
            f.wypisz();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}