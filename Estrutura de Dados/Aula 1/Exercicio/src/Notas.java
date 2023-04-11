import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // leitura da quantidade de notas
        System.out.print("Digite a quantidade de notas: ");
        int n = sc.nextInt();

        double[] notas = new double[n];
        double soma = 0;

        // leitura das notas
        for (int i = 0; i < n; i++) {
            System.out.print("Digite a nota " + (i+1) + ": ");
            notas[i] = sc.nextDouble();
            soma += notas[i];
        }

        // cálculo da média das notas
        double media = soma / n;
        System.out.println("A média das notas é: " + media);

        // exibição das notas maiores do que a média
        System.out.println("Notas maiores do que a média:");
        for (int i = 0; i < n; i++) {
            if (notas[i] > media) {
                System.out.println(notas[i]);
            }
        }

        // exibição das notas menores do que a média
        System.out.println("Notas menores do que a média:");
        for (int i = 0; i < n; i++) {
            if (notas[i] < media) {
                System.out.println(notas[i]);
            }
        }
    }
}
