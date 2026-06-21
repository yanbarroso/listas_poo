import java.util.Scanner;

class ContadorPrimos extends Thread {
    private int inicio;
    private int fim;
    private int resultado = 0;
    private String nome;

    public ContadorPrimos(String nome, int inicio, int fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    private boolean ehPrimo(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int getResultado() {
        return resultado;
    }

    @Override
    public void run() {
        System.out.println(nome + " iniciou - verificando de " + inicio + " a " + fim);
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                resultado++;
            }
        }
        System.out.println(nome + " terminou - encontrou " + resultado + " primos");
    }
}

public class Ex1ContadorPrimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número n para contar primos de 0 a n: ");
        int n = Integer.parseInt(sc.nextLine());

        long inicio = System.currentTimeMillis();

        // Dividir o esforço em duas threads
        int meio = n / 2;
        ContadorPrimos thread1 = new ContadorPrimos("Thread 1", 0, meio);
        ContadorPrimos thread2 = new ContadorPrimos("Thread 2", meio + 1, n);

        // Iniciar as threads
        thread1.start();
        thread2.start();

        // Aguardar a conclusão das threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        long fim = System.currentTimeMillis();
        int totalPrimos = thread1.getResultado() + thread2.getResultado();
        System.out.printf("\nTotal de números primos entre 0 e %d: %d\n", n, totalPrimos);
        System.out.printf("Tempo decorrido: %d ms\n", fim - inicio);

        sc.close();
    }
}
