import java.util.Scanner;

public class OrdenacaoPessoas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int N = 4;

        String[] nomes = new String[N];
        int[] idades = new int[N];

        System.out.println("=== Cadastro de 10 Pessoas ===\n");
        for (int i = 0; i < N; i++) {
            System.out.print("Nome da pessoa " + (i + 1) + ": ");
            nomes[i] = teclado.nextLine().trim();
            System.out.print("Idade de " + nomes[i] + ": ");
            idades[i] = Integer.parseInt(teclado.nextLine().trim());
        }

        // Cria índices para ordenar sem modificar os arrays originais
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) indices[i] = i;

        // --- Ordem alfabética (Bubble Sort por nome) ---
        Integer[] indicesNome = indices.clone();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (nomes[indicesNome[j]].compareToIgnoreCase(nomes[indicesNome[j + 1]]) > 0) {
                    int temp = indicesNome[j];
                    indicesNome[j] = indicesNome[j + 1];
                    indicesNome[j + 1] = temp;
                }
            }
        }

        // --- Ordem crescente de idade (Bubble Sort por idade) ---
        Integer[] indicesIdade = indices.clone();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (idades[indicesIdade[j]] > idades[indicesIdade[j + 1]]) {
                    int temp = indicesIdade[j];
                    indicesIdade[j] = indicesIdade[j + 1];
                    indicesIdade[j + 1] = temp;
                }
            }
        }

        // --- Exibição: ordem alfabética ---
        System.out.println("\n       LISTAGEM EM ORDEM ALFABÉTICA");
        System.out.println("----------------------------------------");
        for (int i = 0; i < N; i++) {
            int idx = indicesNome[i];
            System.out.printf("%-5d %-25s %d anos%n", (i + 1), nomes[idx], idades[idx]);
        }

        // --- Exibição: ordem crescente de idade ---
        System.out.println("\n   LISTAGEM EM ORDEM CRESCENTE DE IDADE");
        System.out.println("----------------------------------------");
        for (int i = 0; i < N; i++) {
            int idx = indicesIdade[i];
            System.out.printf("%-5d %-25s %d anos%n", (i + 1), nomes[idx], idades[idx]);
        }
    }
}
