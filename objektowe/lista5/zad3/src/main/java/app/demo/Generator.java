package app.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generator {

    public static String generator(int j, String s) throws IOException {
        String res="";
        try{
            int i=Integer.parseInt(s);

            ProcessBuilder pb=new ProcessBuilder();
            pb.command("C:\\Users\\wziat\\IdeaProjects\\lista5\\demo1\\src\\main\\java\\app\\demo\\main.exe",""+j,""+i);
            Process process=pb.start();
            BufferedReader bf=new BufferedReader(new InputStreamReader(process.getInputStream()));
            res+=bf.readLine()+" ";

            res+=" ";
        }
        catch (NumberFormatException e){
            res=s+" - Nieprawidłowa kolumna";
            return res;
        }


        return res;
    }
}
