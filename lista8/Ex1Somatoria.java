import java.util.Scanner;

public class Ex1Somatoria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int somatoria = 0;
        boolean continuar = true;

        System.out.println("Leia números inteiros positivos. Digite <= 0 para parar.");

        while (continuar) {
            try {
                System.out.print("Digite um número: ");
                String entrada = sc.nextLine();
                int numero = Integer.parseInt(entrada);

                if (numero <= 0) {
                    continuar = false;
                    System.out.println("Programa encerrado.");
                } else {
                    somatoria += numero;
                    System.out.printf("Número adicionado. Somatório até agora: %d\n", somatoria);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: você não digitou um número válido. Tente novamente.");
            }
        }

        System.out.printf("\nSomatório final: %d\n", somatoria);
        sc.close();
    }
}
