package app.demo;

public class Generator {
    public static String generator(int n){
        String res="";

        for(int i=0; i<=n; i++){
            WierszTrojkataPascala wierszTrojkataPascala= new WierszTrojkataPascala(i);

            for(int j=0; j<=i; j++){

                res+=wierszTrojkataPascala.method2(j)+ " ";
            }
            res+="\n";
        }
        return res;
    }
}
