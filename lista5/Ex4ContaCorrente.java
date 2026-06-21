public class Ex4ContaCorrente {
    public static void main(String[] args) {
        ContaCorrente c = new ContaCorrente(50.0);
        System.out.println("Saldo inicial: R$ " + c.getSaldo());
        c.depositar(25.0);
        System.out.println("Após depósito: R$ " + c.getSaldo());

        boolean saque1 = c.sacar(30.0);
        System.out.println("Saque R$30, sucesso? " + saque1 + " | Saldo: R$ " + c.getSaldo());

        boolean saque2 = c.sacar(50.0);
        System.out.println("Saque R$50, sucesso? " + saque2 + " | Saldo: R$ " + c.getSaldo());
    }
}
