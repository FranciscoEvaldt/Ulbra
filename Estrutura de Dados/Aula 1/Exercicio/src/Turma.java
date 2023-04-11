import java.util.Scanner;

    public class Turma {
        public static void main(String[] args) {
            String[] nomes = new String[5];
            double[] notas = new double[5];
            double soma = 0;
            Scanner sc = new Scanner(System.in);

            // leitura dos nomes e notas da turma
            for (int i = 0; i < 5; i++) {
                System.out.print("Digite o nome do aluno " + (i+1) + ": ");
                nomes[i] = sc.nextLine();
                System.out.print("Digite a nota do aluno " + (i+1) + ": ");
                notas[i] = Double.parseDouble(sc.nextLine());
                soma += notas[i];
            }

            // cálculo da média das notas da turma
            double media = soma / 5;
            System.out.println("A média das notas da turma é: " + media);

            // exibição dos nomes com nota superior à média
            System.out.println("Alunos com nota superior à média:");
            for (int i = 0; i < 5; i++) {
                if (notas[i] > media) {
                    System.out.println(nomes[i] + ": " + notas[i]);
                }
            }
        }
    }

