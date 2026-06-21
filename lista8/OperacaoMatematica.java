// Classe OperacaoMatematica com tratamento de exceções

class OperacaoMatematica {
    private double operando1;
    private double operando2;
    private char operacao;

    public OperacaoMatematica(double operando1, double operando2, char operacao) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacao = operacao;
    }

    public double executar() throws IllegalArgumentException {
        switch (operacao) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                if (operando2 == 0) {
                    throw new IllegalArgumentException("Erro: divisão por zero não é permitida!");
                }
                return operando1 / operando2;
            case 'r':
            case 'R':
                // Raiz quadrada do operando1
                if (operando1 < 0) {
                    throw new IllegalArgumentException("Erro: não é possível calcular raiz de número negativo!");
                }
                return Math.sqrt(operando1);
            default:
                throw new IllegalArgumentException("Operação '" + operacao + "' não é válida!");
        }
    }

    public static double lerOperando(String mensagem) throws NumberFormatException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print(mensagem);
        String entrada = sc.nextLine();
        return Double.parseDouble(entrada);
    }

    public static char lerOperacao() throws IllegalArgumentException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Digite a operação (+, -, *, /, R para raiz): ");
        String entrada = sc.nextLine().trim();
        if (entrada.length() != 1) {
            throw new IllegalArgumentException("Erro: operação deve conter exatamente um caractere!");
        }
        return entrada.charAt(0);
    }
}
