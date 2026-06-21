import java.util.Scanner;

class MediaAluno {
    public static double calcularMedia(double t1, double p1, double t2, double p2) {
        return (t1 + p1 + t2 + p2) / 4.0;
    }

    public static String status(double media) {
        if (media > 6.0) return "Aprovado";
        if (media >= 4.0) return "Verificação Suplementar";
        return "Reprovado";
    }
}

public class Ex2MediaAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Trabalho 1: "); double t1 = Double.parseDouble(sc.nextLine());
        System.out.print("P1: "); double p1 = Double.parseDouble(sc.nextLine());
        System.out.print("Trabalho 2: "); double t2 = Double.parseDouble(sc.nextLine());
        System.out.print("P2: "); double p2 = Double.parseDouble(sc.nextLine());

        double media = MediaAluno.calcularMedia(t1, p1, t2, p2);
        System.out.printf("Média: %.2f\n", media);
        System.out.println("Status: " + MediaAluno.status(media));
        sc.close();
    }
}
