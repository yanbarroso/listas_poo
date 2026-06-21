// Exercício 4: Hierarquia de contas bancárias

abstract class Conta {
    protected int numero;
    protected double saldo;

    public Conta(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract boolean sacar(double valor);

    public String toString() {
        return String.format("Conta %d | Saldo: R$ %.2f", numero, saldo);
    }
}

class ContaComum extends Conta {
    public ContaComum(int numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(int numero, double saldoInicial, double taxaRendimento) {
        super(numero, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void render() {
        double rendimento = saldo * (taxaRendimento / 100.0);
        saldo += rendimento;
        System.out.printf("Rendimento de R$ %.2f aplicado. Novo saldo: R$ %.2f\n", rendimento, saldo);
    }
}

class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, double saldoInicial, double limite) {
        super(numero, saldoInicial);
        this.limite = limite;
    }

    public double getLimite() { return limite; }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limite)) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

public class Ex4Banco {
    public static void main(String[] args) {
        Conta contaComum = new ContaComum(1001, 1000.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(1002, 5000.0, 0.5); // 0.5% de rendimento
        ContaEspecial contaEspecial = new ContaEspecial(1003, 2000.0, 1000.0); // limite de 1000

        System.out.println("--- Contas Iniciais ---");
        System.out.println(contaComum);
        System.out.println(contaPoupanca);
        System.out.println(contaEspecial);

        System.out.println("\n--- Operações ---");
        System.out.println("Depositando R$ 500 em ContaComum...");
        contaComum.depositar(500.0);
        System.out.println(contaComum);

        System.out.println("\nSacando R$ 800 de ContaComum...");
        boolean ok = contaComum.sacar(800.0);
        System.out.println("Saque bem-sucedido? " + ok);
        System.out.println(contaComum);

        System.out.println("\nAplicando rendimento em ContaPoupanca...");
        contaPoupanca.render();
        System.out.println(contaPoupanca);

        System.out.println("\nSacando R$ 2500 de ContaEspecial (usa limite)...");
        ok = contaEspecial.sacar(2500.0);
        System.out.println("Saque bem-sucedido? " + ok);
        System.out.println(contaEspecial);

        System.out.println("\nTentando sacar R$ 3000 de ContaEspecial (não há limite)...");
        ok = contaEspecial.sacar(3000.0);
        System.out.println("Saque bem-sucedido? " + ok);
    }
}
