import java.util.ArrayList;
public class LiczbyPierwsze {
    ArrayList<Integer> ListaPierwszych = new ArrayList<>();
    public LiczbyPierwsze(int n, String... args){}

    public void metoda1(int n, String... args) {
        if (n < 2) {
            System.out.println(n + " - nieprawidłowy zakres");
        } else {
            for (int i = 2; i <= n; i++) {
                int dzielniki = 0;
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        dzielniki++;
                    }
                }
                if (dzielniki == 1) {
                    ListaPierwszych.add(i);
                }
            }

            for (String argument : args) {
                try {
                    int x = Integer.parseInt(argument); //zamiana na liczbę
                    System.out.println(x + " - " + liczba(x));
                } catch (NumberFormatException e) { //wyjątek, gdy danej nie da sie zamienic na liczbę
                    System.out.println(argument + " - nieprawidłowa dana");
                } catch (IndexOutOfBoundsException e) { //wyjątek, gdy indeks przekracza rozmiar listy
                    System.out.println(argument + " - liczba spoza zakresu");
                }
            }
        }
    }

    int liczba(int m) {
        return ListaPierwszych.get(m);
    }



}