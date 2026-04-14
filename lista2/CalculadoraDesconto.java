import java.util.Scanner;

public class CalculadoraDesconto {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o nome do produto ou deixe em branco para sair: ");
        String nome = teclado.nextLine();
        
        while (!nome.isEmpty()) {
        
            System.out.print("Digite o preço do produto: ");
            float preco = teclado.nextFloat();
        
            System.out.print("Digite a quantidade do produto: ");
            int quantidade = teclado.nextInt();
            teclado.nextLine(); 
        
            float total = preco * quantidade;
        
            if (quantidade <= 10) {
                // sem desconto
            } else if (quantidade <= 20) {
                total *= 0.9;
            } else if (quantidade <= 50) {
                total *= 0.8;
            } else {
                total *= 0.75;
            }
        
            System.out.println("Produto: " + nome);
            System.out.println("Valor total: " + total);
        
            // lê o próximo nome no final do loop
            System.out.print("\nDigite o nome do produto ou deixe em branco para sair: ");
            nome = teclado.nextLine();
        }
    }
}