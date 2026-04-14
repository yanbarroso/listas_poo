import java.util.Scanner;

public class BoasVindas
{
	public static void main(String[] args) {
	    Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome = teclado.nextLine().trim();
		System.out.printf("Olá, %s! Bem-vindo ao Java!\n", nome);
	}
}