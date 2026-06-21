public class Retangulo {
    private int largura;
    private int altura;
    private int x;
    private int y;

    public Retangulo(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public Retangulo(Retangulo outro) {
        this.x = outro.x;
        this.y = outro.y;
        this.largura = outro.largura;
        this.altura = outro.altura;
    }

    public int getLargura() { return largura; }
    public int getAltura() { return altura; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void setLargura(int largura) { this.largura = largura; }
    public void setAltura(int altura) { this.altura = altura; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    // 5. Desenhar: imprime uma representação simples em texto
    public void desenhar() {
        System.out.printf("Retângulo em (%d,%d) largura=%d altura=%d\n", x, y, largura, altura);
        int h = Math.max(1, Math.min(20, altura));
        int w = Math.max(1, Math.min(60, largura));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == h-1 || j == 0 || j == w-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 6. Mover: desloca o retângulo
    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // 7. Redimensionar: define nova largura/altura
    public void redimensionar(int novaLargura, int novaAltura) {
        if (novaLargura > 0) this.largura = novaLargura;
        if (novaAltura > 0) this.altura = novaAltura;
    }

    // 8. Dividir: divide o retângulo verticalmente em dois retângulos e retorna um array
    public Retangulo[] dividir() {
        int metade = largura / 2;
        Retangulo r1 = new Retangulo(x, y, metade, altura);
        Retangulo r2 = new Retangulo(x + metade, y, largura - metade, altura);
        return new Retangulo[]{r1, r2};
    }

    public String toString() {
        return String.format("Retangulo(x=%d,y=%d,largura=%d,altura=%d)", x, y, largura, altura);
    }
}
