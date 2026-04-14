import java.util.Scanner;

public class QtdMoedas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor em centavos: ");

        int valor = teclado.nextInt();

        int[] moedas = {100, 50, 25, 10, 5, 2, 1};
        String[] nomes = {"1 real", "50 centavos", "25 centavos", "10 centavos", "5 centavos", "2 centavos", "1 centavo"};

        for (int i = 0; i < moedas.length; i++){
            int quantidade = valor/moedas[i];
            valor %= moedas[i];

            if (quantidade > 0){
            System.out.println(quantidade + " moedas de " + nomes[i]);
            }
        }
        
    }
}
