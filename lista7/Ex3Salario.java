// Exercício 3: Cálculo de salário com hierarquia de funcionários

abstract class FuncionarioSalario {
    protected String nome;
    protected double salarioBruto;

    public FuncionarioSalario(String nome, double salarioBruto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    public String getNome() { return nome; }
    public double getSalarioBruto() { return salarioBruto; }

    protected double calcularIR(double valor) {
        if (valor <= 900.0) return 0.0;
        if (valor <= 1500.0) return valor * 0.15;
        return valor * 0.20;
    }

    public abstract float salarioLiquido();
}

class FuncionarioComum extends FuncionarioSalario {
    public FuncionarioComum(String nome, double salarioBruto) {
        super(nome, salarioBruto);
    }

    @Override
    public float salarioLiquido() {
        double ir = calcularIR(salarioBruto);
        return (float)(salarioBruto - ir);
    }
}

class Estagiario extends FuncionarioSalario {
    public Estagiario(String nome, double salarioBruto) {
        super(nome, salarioBruto);
    }

    @Override
    public float salarioLiquido() {
        // Estagiários não pagam IR
        return (float)salarioBruto;
    }
}

class Vendedor extends FuncionarioSalario {
    private double percentualBonus;

    public Vendedor(String nome, double salarioBruto, double percentualBonus) {
        super(nome, salarioBruto);
        this.percentualBonus = percentualBonus;
    }

    @Override
    public float salarioLiquido() {
        double bonus = salarioBruto * (percentualBonus / 100.0);
        double totalRecebido = salarioBruto + bonus;
        double ir = calcularIR(totalRecebido);
        return (float)(totalRecebido - ir);
    }
}

public class Ex3Salario {
    public static void main(String[] args) {
        FuncionarioComum func = new FuncionarioComum("João", 1200.0);
        Estagiario estag = new Estagiario("Maria", 800.0);
        Vendedor vend = new Vendedor("Pedro", 2000.0, 10.0); // 10% de bônus

        System.out.println("--- Cálculo de Salários ---");
        System.out.printf("Funcionário: %s | Bruto: R$ %.2f | Líquido: R$ %.2f\n", 
            func.getNome(), func.getSalarioBruto(), func.salarioLiquido());
        System.out.printf("Estagiário: %s | Bruto: R$ %.2f | Líquido: R$ %.2f\n", 
            estag.getNome(), estag.getSalarioBruto(), estag.salarioLiquido());
        System.out.printf("Vendedor: %s | Bruto: R$ %.2f | Líquido: R$ %.2f\n", 
            vend.getNome(), vend.getSalarioBruto(), vend.salarioLiquido());
    }
}
