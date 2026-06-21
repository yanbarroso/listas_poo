import java.util.Scanner;

public class Ex4Circulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x do centro: "); double x = Double.parseDouble(sc.nextLine());
        System.out.print("y do centro: "); double y = Double.parseDouble(sc.nextLine());
        System.out.print("raio: "); double r = Double.parseDouble(sc.nextLine());
        Circulo c = new Circulo(x, y, r);
        System.out.println(c);
        System.out.printf("Área: %.4f\n", c.area());
        System.out.printf("Perímetro: %.4f\n", c.perimetro());
        sc.close();
    }
}
