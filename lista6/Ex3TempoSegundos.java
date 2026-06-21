import java.util.Scanner;

class ConversorTempo {
    public static int horas(int segundos) { return segundos / 3600; }
    public static int minutos(int segundos) { return (segundos % 3600) / 60; }
    public static int segundosRestantes(int segundos) { return segundos % 60; }
}

public class Ex3TempoSegundos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o tempo em segundos: ");
        int s = Integer.parseInt(sc.nextLine());
        int h = ConversorTempo.horas(s);
        int m = ConversorTempo.minutos(s);
        int sec = ConversorTempo.segundosRestantes(s);
        System.out.printf("%d segundos = %d horas, %d minutos e %d segundos\n", s, h, m, sec);
        sc.close();
    }
}
