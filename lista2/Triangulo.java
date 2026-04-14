import java.util.Scanner;

public class Triangulo {
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        
        //Pontos
        System.out.println("Ponto 1 (x1, y1): ");
        double x1 = teclado.nextDouble();
        double y1 = teclado.nextDouble();
        
        System.out.println("Ponto 2 (x2, y2): ");
        double x2 = teclado.nextDouble();
        double y2 = teclado.nextDouble();
        
        System.out.println("Ponto 3 (x3, y3): ");
        double x3 = teclado.nextDouble();
        double y3 = teclado.nextDouble();
        
        
        //Lados
        double ladoA = Math.sqrt((Math.pow((x2-x1),2)) + (Math.pow((y2-y1),2)));
        ladoA = Math.round(ladoA * 100.0) / 100.0; 
        double ladoB = Math.sqrt((Math.pow((x3-x2),2)) + (Math.pow((y3-y2),2)));
        ladoB = Math.round(ladoB * 100.0) / 100.0; 
        double ladoC = Math.sqrt((Math.pow((x1-x3),2)) + (Math.pow((y1-y3),2)));
        ladoC = Math.round(ladoC * 100.0) / 100.0; 

        
        System.out.println("LadoA: " + ladoA + "LadoB: " + ladoB + "LadoC: " + ladoC);
        
        // A soma de dois lados deve ser maior que o terceiro
        if (ladoA + ladoB > ladoC && ladoB + ladoC > ladoA && ladoA+ladoC > ladoB){
            System.out.println("Formam um triângulo");
            
            if (ladoA == ladoB && ladoB == ladoC){
                System.out.println("Triângulo equilátero");
            }
            else if (ladoA == ladoB  || ladoB == ladoC || ladoA == ladoC){
                System.out.println("Triângulo isósceles");
            }
            else{
                System.out.println("Triângulo escaleno");
            }
        }
        else{
            System.out.println("Não formam um triângulo");
        }
    }
}
