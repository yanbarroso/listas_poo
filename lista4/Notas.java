import java.util.Scanner;

public class Notas {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    System.out.println("Número de alunos: ");
    int numAlunos = teclado.nextInt();

    float[] notasAlunos;
    notasAlunos = new float[numAlunos];

    int somaMedia = 0;

    for (int i = 0; i < numAlunos; i++) {
      System.out.println("Nota do aluno " + (i+1));
      notasAlunos[i] = teclado.nextFloat();
      somaMedia += notasAlunos[i];
    }

    float media = somaMedia/numAlunos;
    System.out.println("Média da turma: " + media);

    for (int i = 0; i < numAlunos; i++) {
      if (notasAlunos[i] > media) {
        System.out.println("Nota acima da média: " + notasAlunos[i]);
      }
    }
  }
}