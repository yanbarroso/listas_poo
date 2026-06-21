import java.util.Scanner;

class Calculadora {
    private double memoria = 0.0;

    public double getMemoria() { return memoria; }

    public void somar(double v) { memoria += v; }
    public void subtrair(double v) { memoria -= v; }
    public void multiplicar(double v) { memoria *= v; }
    public boolean dividir(double v) {
        if (v == 0) return false;
        memoria /= v; return true;
    }
    public void limpar() { memoria = 0.0; }
}

public class Ex1Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        boolean sair = false;

        while (!sair) {
            System.out.println("Estado da memória: " + calc.getMemoria());
            System.out.println("Opções:");
            System.out.println("(1) Somar");
            System.out.println("(2) Subtrair");
            System.out.println("(3) Multiplicar");
            System.out.println("(4) Dividir");
            System.out.println("(5) Limpar memória");
            System.out.println("(6) Sair do programa");
            System.out.print("Qual opção você deseja? ");

            int op = 0;
            try { op = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { op = 0; }

            double valor;
            switch (op) {
                case 1:
                    System.out.print("Valor para somar: ");
                    valor = Double.parseDouble(sc.nextLine());
                    calc.somar(valor);
                    break;
                case 2:
                    System.out.print("Valor para subtrair: ");
                    valor = Double.parseDouble(sc.nextLine());
                    calc.subtrair(valor);
                    break;
                case 3:
                    System.out.print("Valor para multiplicar: ");
                    valor = Double.parseDouble(sc.nextLine());
                    calc.multiplicar(valor);
                    break;
                case 4:
                    System.out.print("Valor para dividir: ");
                    valor = Double.parseDouble(sc.nextLine());
                    if (!calc.dividir(valor)) System.out.println("Erro: divisão por zero");
                    break;
                case 5:
                    calc.limpar();
                    System.out.println("Memória limpa.");
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }
}
