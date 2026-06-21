import java.time.LocalDate;

class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isEmprestado() { return emprestado; }

    void marcarEmprestado() { emprestado = true; }
    void marcarDevolvido() { emprestado = false; }
}

class Pessoa {
    private String nome;

    public Pessoa(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
}

class Emprestimo {
    private Livro livro;
    private Pessoa pessoa;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public boolean emprestar() {
        if (livro.isEmprestado()) return false;
        livro.marcarEmprestado();
        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusWeeks(2);
        return true;
    }

    public boolean devolver() {
        if (!livro.isEmprestado()) return false;
        livro.marcarDevolvido();
        dataDevolucao = LocalDate.now();
        return true;
    }

    public String resumo() {
        return String.format("Livro: %s | Pessoa: %s | Emprestado: %s | Data empréstimo: %s | Data devolução prevista: %s",
                livro.getTitulo(), pessoa.getNome(), livro.isEmprestado(), dataEmprestimo, dataDevolucao);
    }
}

public class Ex3Emprestimo {
    public static void main(String[] args) {
        Livro livro = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Pessoa pessoa = new Pessoa("Mariana");

        Emprestimo emp = new Emprestimo(livro, pessoa);
        boolean ok = emp.emprestar();
        System.out.println("Empréstimo realizado? " + ok);
        System.out.println(emp.resumo());

        boolean devolveu = emp.devolver();
        System.out.println("Devolução realizada? " + devolveu);
        System.out.println(emp.resumo());
    }
}
