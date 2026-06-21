public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo(double x, double y, double raio) {
        this.x = x; this.y = y; this.raio = raio;
    }

    public Circulo(Circulo outro) {
        this.x = outro.x;
        this.y = outro.y;
        this.raio = outro.raio;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRaio() { return raio; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRaio(double raio) { this.raio = raio; }

    public double area() { return Math.PI * raio * raio; }
    public double perimetro() { return 2 * Math.PI * raio; }
    
    // 5. Desenhar: representação ASCII aproximada do círculo
    public void desenhar() {
        int diam = (int)Math.round(2*raio);
        int h = Math.max(1, Math.min(40, diam));
        int w = Math.max(1, Math.min(80, diam*2)); // mais largura para manter proporção
        double cx = w/2.0;
        double cy = h/2.0;
        double rX = w/2.0;
        double rY = h/2.0;
        for (int i=0;i<h;i++) {
            for (int j=0;j<w;j++) {
                double nx = (j - cx)/rX;
                double ny = (i - cy)/rY;
                double dist = Math.sqrt(nx*nx + ny*ny);
                if (Math.abs(dist - 1.0) < 0.12) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 6. Mover: desloca o centro
    public void mover(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // 7. Redimensionar: ajusta o raio
    public void redimensionar(double novoRaio) {
        if (novoRaio > 0) this.raio = novoRaio;
    }

    // 8. Dividir: retorna dois círculos menores (metade do raio) deslocados lateralmente
    public Circulo[] dividir() {
        double novoRaio = this.raio / 2.0;
        Circulo c1 = new Circulo(this.x - novoRaio/2.0, this.y, novoRaio);
        Circulo c2 = new Circulo(this.x + novoRaio/2.0, this.y, novoRaio);
        return new Circulo[]{c1, c2};
    }

    public String toString() {
        return String.format("Circulo(center=(%.2f,%.2f), raio=%.2f)", x, y, raio);
    }
}
