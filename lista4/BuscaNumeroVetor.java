import java.util.Scanner;

public class BuscaNumeroVetor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor (n): ");
        int n = teclado.nextInt();

        int[] v = new int[n];

        System.out.println("Digite os " + n + " números inteiros:");
        for (int i = 0; i < n; i++) {
            System.out.print("v[" + i + "]: ");
            v[i] = teclado.nextInt();
        }

        System.out.print("Digite o número a ser buscado (k): ");
        int k = teclado.nextInt();

        boolean encontrado = false;
        System.out.println("\nResultado da busca por " + k + ":");

        for (int i = 0; i < n; i++) {
            if (v[i] == k) {
                System.out.println("Número " + k + " encontrado na posição " + i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Número não encontrado");
        }
    }
}
