import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ex1FraseInvertida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        // Dividir a frase em palavras
        String[] palavras = frase.split("\\s+");

        // Usar List para armazenar as palavras
        List<String> lista = new ArrayList<>();
        for (String palavra : palavras) {
            lista.add(palavra);
        }

        // Inverter a ordem
        System.out.println("Frase original: " + frase);
        System.out.print("Frase invertida: ");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.print(lista.get(i));
            if (i > 0) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}
