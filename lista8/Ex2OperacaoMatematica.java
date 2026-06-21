import java.util.Scanner;

public class Ex2OperacaoMatematica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Calculadora Matemática com Tratamento de Exceções ===");

        while (continuar) {
            try {
                // Ler operandos com tratador de exceção
                double op1 = 0, op2 = 0;
                boolean opValido = false;

                while (!opValido) {
                    try {
                        op1 = OperacaoMatematica.lerOperando("Digite o primeiro operando: ");
                        opValido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: você digitou um número inválido. Tente novamente.");
                    }
                }

                // Ler operação
                char operacao = ' ';
                opValido = false;
                while (!opValido) {
                    try {
                        operacao = OperacaoMatematica.lerOperacao();
                        opValido = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage() + " Tente novamente.");
                    }
                }

                // Ler segundo operando (exceto para raiz)
                if (operacao != 'R' && operacao != 'r') {
                    opValido = false;
                    while (!opValido) {
                        try {
                            op2 = OperacaoMatematica.lerOperando("Digite o segundo operando: ");
                            opValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: você digitou um número inválido. Tente novamente.");
                        }
                    }
                }

                // Criar operação e executar
                OperacaoMatematica op = new OperacaoMatematica(op1, op2, operacao);
                double resultado = op.executar();
                System.out.printf("Resultado: %.4f\n\n", resultado);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }

            // Pergunta se deseja continuar
            System.out.print("Deseja realizar outra operação? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();
            if (!resposta.equals("s") && !resposta.equals("sim")) {
                continuar = false;
            }
            System.out.println();
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
