public class Test {
    public static void main(String args[]){
        int n,m;
        try{
            n=Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e){
            System.out.println(args[0]+" - Nieprawidłowa dana)");
            return;
        }
        if(n<0){
            System.out.println(args[0]+" - Nieprawidłowy numer wiersza");
            return;
        }


        WierszTrojkataPascala obj1=new WierszTrojkataPascala(n);
        for(int i=1; i<args.length; i++){
            try{
                m=Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e){
                System.out.println(args[i]+" - Nieprawidłowa dana");
                continue;
            }
            int x=obj1.method2(m);
            if(x==0)
                System.out.println(m+" - Liczba spoza zakresu");
            else
                System.out.println(x);
        }
    }
}
