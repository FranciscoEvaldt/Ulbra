import java.util.Scanner;

public class InversaoDeValores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // leitura da quantidade de valores
        System.out.print("Digite a quantidade de valores: ");
        int n = sc.nextInt();

        int[] valores = new int[n];

        // leitura dos valores
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor " + (i+1) + ": ");
            valores[i] = sc.nextInt();
        }

        // exibição dos valores na ordem inversa
        System.out.println("Valores na ordem inversa:");
        for (int i = n-1; i >= 0; i--) {
            System.out.println(valores[i]);
        }
    }
}
