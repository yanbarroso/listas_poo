public class Ex5Data {
    public static void main(String[] args) {
        Data d1 = new Data(29, 2, 2020);
        Data d2 = new Data(31, 4, 2021);

        System.out.print("d1: "); d1.imprime();
        System.out.println("d1 é bissexto? " + d1.anoBissexto());

        System.out.print("d2: "); d2.imprime();
        System.out.println("d2 é bissexto? " + d2.anoBissexto());

        System.out.print("d1 com '-' : "); d1.imprime("-");
    }
}
