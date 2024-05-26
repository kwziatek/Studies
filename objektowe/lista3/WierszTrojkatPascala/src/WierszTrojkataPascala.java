//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WierszTrojkataPascala {
    int t[];
    WierszTrojkataPascala(int n){
        t=new int[n+1];
    }

    private void method1(){
        int n=t.length-1;
        for(int i=0; i<=n; i++){
            if(i==0)
                t[i]=1;
            else
                t[i]=t[i-1]*(n-i+1)/i;
        }
    }
    public int method2(int m){
        if(t[0]==0)
            method1();
        if(m<0 || m>t.length-1)
            return 0;
        else
            return t[m];
    }

}