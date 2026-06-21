import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Ex3OcorrenciasPalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        // Dividir a frase em palavras
        String[] palavras = frase.split("\\s+");

        // Usar Map para contar ocorrências de cada palavra
        Map<String, Integer> mapa = new HashMap<>();
        for (String palavra : palavras) {
            palavra = palavra.toLowerCase();
            mapa.put(palavra, mapa.getOrDefault(palavra, 0) + 1);
        }

        System.out.println("Frase original: " + frase);
        System.out.println("\nOcorrências de cada palavra:");
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.printf("'%s': %d vez(es)\n", entrada.getKey(), entrada.getValue());
        }

        sc.close();
    }
}
