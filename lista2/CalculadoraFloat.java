import java.util.Scanner;

public class CalculadoraFloat{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        float num1 = teclado.nextFloat();
        float num2 = teclado.nextFloat();
        
        System.out.println("Soma = " + (num1+num2));
        System.out.println("Subtração = " + (num1-num2));
        System.out.println("Multiplicação = " + (num1*num2));
        System.out.println("Divisão = " + (num1/num2));
    }
}