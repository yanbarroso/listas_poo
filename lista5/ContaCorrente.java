public class ContaCorrente {
    private double saldo;
    private static final double TAXA_SAQUE = 1.5;

    public ContaCorrente(double saldoInicial) { this.saldo = saldoInicial; }

    public double getSaldo() { return saldo; }

    public void depositar(double quantia) {
        if (quantia > 0) saldo += quantia;
    }

    public boolean sacar(double quantia) {
        double total = quantia + TAXA_SAQUE;
        if (quantia <= 0 || total > saldo) return false;
        saldo -= total;
        return true;
    }
}
