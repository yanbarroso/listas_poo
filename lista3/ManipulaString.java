import java.util.Scanner;

public class ManipulaString {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    System.out.println("Digite a frase:");
    String frase = teclado.nextLine();

    System.out.println("Total caracteres: " + frase.length());
    System.out.println("Maiúsculo: " + frase.toUpperCase());
    System.out.println("Minúsculo: " + frase.toLowerCase());
    int cont = 0;

    for (int i = 0; i < frase.length(); i++) {
      if ((frase.charAt(i)) == 'a' || frase.charAt(i) == 'A') {
        cont++;
      }
    }
    System.out.println("Quantidade de A's: " + cont);
  }
}