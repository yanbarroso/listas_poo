import java.util.ArrayList;
import java.util.List;

class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    public String toString() {
        return String.format("%s - %s - %s", nome, telefone, email);
    }
}

class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato c) { contatos.add(c); }

    public boolean removerPorNome(String nome) {
        return contatos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    public Contato buscaPorNome(String nome) {
        for (Contato c : contatos) if (c.getNome().equalsIgnoreCase(nome)) return c;
        return null;
    }

    public void listar() {
        System.out.println("--- Contatos ---");
        for (Contato c : contatos) System.out.println(c);
    }
}

public class Ex2Agenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.adicionar(new Contato("Ana", "98765-4321", "ana@mail.com"));
        agenda.adicionar(new Contato("Bruno", "91234-5678", "bruno@mail.com"));
        agenda.adicionar(new Contato("Carlos", "91111-2222", "carlos@mail.com"));

        agenda.listar();

        System.out.println("\nBusca por 'Bruno': " + agenda.buscaPorNome("Bruno"));
        agenda.removerPorNome("Ana");
        System.out.println("\nApós remover Ana:");
        agenda.listar();
    }
}
