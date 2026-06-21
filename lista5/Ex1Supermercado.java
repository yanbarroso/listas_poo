import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public boolean reduzirEstoque(int qtd) {
        if (qtd <= 0 || qtd > estoque) return false;
        estoque -= qtd;
        return true;
    }
}

class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double subtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}

enum FormaPagamento { DINHEIRO, CHEQUE, CARTAO }

class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private FormaPagamento pagamento;

    public void adicionarItem(Produto p, int qtd) {
        if (qtd <= 0) return;
        if (qtd > p.getEstoque()) {
            System.out.println("Estoque insuficiente para: " + p.getNome());
            return;
        }
        itens.add(new ItemPedido(p, qtd));
        p.reduzirEstoque(qtd);
    }

    public double total() {
        double t = 0;
        for (ItemPedido ip : itens) t += ip.subtotal();
        return t;
    }

    public void pagar(FormaPagamento f) { this.pagamento = f; }

    public void imprimirResumo() {
        System.out.println("--- Resumo do Pedido ---");
        for (ItemPedido ip : itens) {
            System.out.printf("%s x%d = R$ %.2f\n", ip.getProduto().getNome(), ip.getQuantidade(), ip.subtotal());
        }
        System.out.printf("Total: R$ %.2f\n", total());
        System.out.println("Pagamento: " + (pagamento == null ? "(não informado)" : pagamento));
    }
}

public class Ex1Supermercado {
    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz 5kg", 20.0, 10);
        Produto leite = new Produto("Leite 1L", 3.5, 20);
        Produto ovo = new Produto("Ovo caixa 12", 8.0, 5);

        Pedido pedido = new Pedido();
        pedido.adicionarItem(arroz, 2);
        pedido.adicionarItem(leite, 3);
        pedido.adicionarItem(ovo, 6); // excede estoque -> será ignorado

        pedido.pagar(FormaPagamento.CARTAO);
        pedido.imprimirResumo();
    }
}
