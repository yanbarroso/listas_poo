import java.util.Scanner;

public class Intervalo {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = teclado.nextInt();

        System.out.println("Digite outro número maior ou menor que " + numero);
        int numero2 = teclado.nextInt();

        System.out.println("Digite outro número maior ou menor que " + numero2 + " e " + numero);
        int numero3 = teclado.nextInt();

        int menor = Math.min(numero2, numero3);
        int maior = Math.max(numero2, numero3);

        if (numero > menor && numero < maior) {
            System.out.println("O número está dentro do intervalo");
        } else if (numero < menor) {
            System.out.println("O número está antes do intervalo");
        } else if (numero > maior) {
            System.out.println("O número está depois do intervalo");
        } else {
            System.out.println("O número está nos limites do intervalo");
        }
    }
}