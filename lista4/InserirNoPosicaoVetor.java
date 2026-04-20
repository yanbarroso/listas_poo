import java.util.Scanner;

public class InserirNoPosicaoVetor {
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

        System.out.print("Digite o número a ser inserido (k): ");
        int k = teclado.nextInt();

        System.out.print("Digite a posição de inserção (p): ");
        int p = teclado.nextInt();

        if (p < 0 || p >= n) {
            System.out.println("Posição inválida");
        } else {
            // Desloca os elementos da posição p em diante para a direita (o último é perdido)
            for (int i = n - 1; i > p; i--) {
                v[i] = v[i - 1];
            }

            // Insere k na posição p
            v[p] = k;

            System.out.println("\nVetor resultante:");
            for (int i = 0; i < n; i++) {
                System.out.print("v[" + i + "] = " + v[i]);
                if (i < n - 1) System.out.print("  |  ");
            }
            System.out.println();
        }
    }
}
