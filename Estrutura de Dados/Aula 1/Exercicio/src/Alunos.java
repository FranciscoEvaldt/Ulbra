import java.util.Scanner;

public class Alunos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // leitura da quantidade de alunos
        System.out.print("Digite a quantidade de alunos: ");
        int n = sc.nextInt();

        String[] nomes = new String[n];
        double[] notas = new double[n];
        double soma = 0;

        // leitura dos nomes e notas
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do aluno " + (i+1) + ": ");
            nomes[i] = sc.next();
            System.out.print("Digite a nota do aluno " + (i+1) + ": ");
            notas[i] = sc.nextDouble();
            soma += notas[i];
        }

        // cálculo da média da turma
        double media = soma / n;

        // exibição dos nomes dos alunos com nota maior do que a média
        System.out.println("Alunos com nota maior do que a média:");
        for (int i = 0; i < n; i++) {
            if (notas[i] > media) {
                System.out.println(nomes[i]);
            }
        }
    }
}
