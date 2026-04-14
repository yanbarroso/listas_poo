import java.util.Scanner;

public class ConverteCelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a temperatura em Celsius: ");

        float celsius = teclado.nextFloat();
        
        System.out.printf("%.0fºC equivalem a %.0fºF\n", celsius, celsius*1.8+32);
    }
}
