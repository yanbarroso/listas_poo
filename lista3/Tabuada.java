import java.util.Scanner;

public class Tabuada {
    public static void main(String [] args) {
      Scanner teclado = new Scanner(System.in); 

      int multiplicador = 1;
      int multiplicando = 1;

      for (multiplicador = 1; multiplicador <= 10; multiplicador++) {
        for (multiplicando = 1; multiplicando <=10; multiplicando++) {
            System.out.println(multiplicador + " x " + multiplicando + " = " + multiplicador * multiplicando);
        }
    }
  }
}