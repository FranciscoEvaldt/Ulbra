import java.util.Arrays;
import java.util.Scanner;

public class Estatistica {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[5][5];

        // leitura da matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor da posição [" + i + "][" + j + "]: ");
                matriz[i][j] = input.nextInt();
            }
        }

        // cálculo da moda
        int[] vetor = new int[25];
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                vetor[contador] = matriz[i][j];
                contador++;
            }
        }
        Arrays.sort(vetor);
        int moda = vetor[0];
        int maiorFrequencia = 1;
        int frequencia = 1;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] == vetor[i-1]) {
                frequencia++;
            } else {
                if (frequencia > maiorFrequencia) {
                    moda = vetor[i-1];
                    maiorFrequencia = frequencia;
                }
                frequencia = 1;
            }
        }
        if (frequencia > maiorFrequencia) {
            moda = vetor[vetor.length-1];
        }

        // cálculo da mediana
        Arrays.sort(vetor);
        int mediana;
        if (vetor.length % 2 == 0) {
            mediana = (vetor[vetor.length/2] + vetor[vetor.length/2-1])/2;
        } else {
            mediana = vetor[vetor.length/2];
        }

        // cálculo da média
        double soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
        }
        double media = soma / (matriz.length * matriz[0].length);

        // exibição dos resultados
        System.out.println("Moda: " + moda);
        System.out.println("Mediana: " + mediana);
        System.out.println("Média: " + media);
    }
}
