// Hierarquia de usuários de uma loja

abstract class Usuario {
    protected String nome;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public void setSenha(String senha) { this.senha = senha; }
    public abstract String getTipo();
}

class Cliente extends Usuario {
    private String email;
    private String endereco;
    private String telefone;


    public Cliente(String nome, String senha, String email, String endereco, String telefone) {
        super(nome, senha);
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }

    @Override
    public String getTipo() { return "Cliente"; }
}

class Funcionario extends Usuario {
    public Funcionario(String nome, String senha) {
        super(nome, senha);
    }

    public void venderProduto(String produto, double preco) {
        System.out.printf("Funcionário %s vendeu %s por R$ %.2f\n", nome, produto, preco);
    }

    @Override
    public String getTipo() { return "Funcionário"; }
}

class Gerente extends Funcionario {
    public Gerente(String nome, String senha) {
        super(nome, senha);
    }

    public void fecharCaixa(double valor) {
        System.out.printf("Gerente %s fechou caixa com R$ %.2f\n", nome, valor);
    }

    @Override
    public String getTipo() { return "Gerente"; }
}

public class Ex1Usuarios {
    public static void main(String[] args) {
        Usuario cliente = new Cliente("Ana", "123456", "ana@mail.com", "Rua A, 123", "11999999999");
        Usuario funcionario = new Funcionario("Bruno", "senha789");
        Usuario gerente = new Gerente("Carlos", "supersenha");

        System.out.println("--- Usuários ---");
        System.out.println(cliente.getNome() + " (" + cliente.getTipo() + ")");
        System.out.println(funcionario.getNome() + " (" + funcionario.getTipo() + ")");
        System.out.println(gerente.getNome() + " (" + gerente.getTipo() + ")");

        System.out.println("\n--- Operações ---");
        ((Cliente)cliente).getEndereco();
        ((Funcionario)funcionario).venderProduto("Notebook", 3000.0);
        ((Gerente)gerente).venderProduto("Monitor", 800.0);
        ((Gerente)gerente).fecharCaixa(5000.0);
    }
}
