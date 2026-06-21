// Exercício 2: Animal com herança - Homem, Cão, Gato

abstract class Animal {
    protected String nome;

    public Animal(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    public abstract String fala();
}

class Homem extends Animal {
    public Homem(String nome) { super(nome); }
    @Override
    public String fala() { return "Oi"; }
}

class Cao extends Animal {
    public Cao(String nome) { super(nome); }
    @Override
    public String fala() { return "Au au"; }
}

class Gato extends Animal {
    public Gato(String nome) { super(nome); }
    @Override
    public String fala() { return "Miau"; }
}

public class Ex2Animais {
    public static void main(String[] args) {
        Animal[] animais = new Animal[10];
        
        // Instancia aleatoriamente Homens, Cães e Gatos
        for (int i = 0; i < animais.length; i++) {
            int tipo = (int)(Math.random() * 3);
            switch (tipo) {
                case 0:
                    animais[i] = new Homem("Homem" + i);
                    break;
                case 1:
                    animais[i] = new Cao("Cão" + i);
                    break;
                case 2:
                    animais[i] = new Gato("Gato" + i);
                    break;
            }
        }

        System.out.println("--- Todos os animais falando ---");
        for (Animal a : animais) {
            System.out.println(a.getNome() + ": " + a.fala());
        }
    }
}
