import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " - nieprawidłowy zakres");
            return;
        }
        String[] tablicaarg = Arrays.copyOfRange(args, 1, args.length);//kopiujemy argumenty do nowej tablicy, oprocz pierwszego
        LiczbyPierwsze liczby = new LiczbyPierwsze(n, tablicaarg);
        liczby.metoda1(n,tablicaarg);
    }
}
