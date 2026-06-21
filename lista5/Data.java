public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean anoBissexto() {
        if (!dataValida()) return false;
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public boolean dataValida() {
        if (ano <= 0) return false;
        if (mes < 1 || mes > 12) return false;
        if (dia < 1) return false;

        int maxDia;
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDia = 31; break;
            case 4: case 6: case 9: case 11:
                maxDia = 30; break;
            case 2:
                maxDia = ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) ? 29 : 28;
                break;
            default:
                return false;
        }
        return dia <= maxDia;
    }

    public void imprime() { imprime("/"); }

    public void imprime(String separador) {
        if (!dataValida()) {
            System.out.println("INVÁLIDA");
            return;
        }
        System.out.printf("%02d%s%02d%s%04d\n", dia, separador, mes, separador, ano);
    }
}
