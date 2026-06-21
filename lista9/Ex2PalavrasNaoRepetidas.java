import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Ex2PalavrasNaoRepetidas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        // Dividir a frase em palavras
        String[] palavras = frase.split("\\s+");

        // Usar Set para armazenar palavras únicas (sem repetição)
        Set<String> conjunto = new HashSet<>();
        for (String palavra : palavras) {
            conjunto.add(palavra.toLowerCase());
        }

        System.out.println("Frase original: " + frase);
        System.out.println("Total de palavras: " + palavras.length);
        System.out.println("Número de palavras não repetidas (únicas): " + conjunto.size());
        System.out.println("Palavras únicas: " + conjunto);

        sc.close();
    }
}
