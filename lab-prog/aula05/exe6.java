import java.util.Scanner;
import static java.lang.Math.sqrt;

public class exe6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetorA = new int[10];
        int[] vetorB = new int[10];
        int[] vetorC = new int[10];


        for (int i = 0; i< vetorA.length; i++){
            System.out.printf("Entre com um valor na posicao: " + i + "\n");
            vetorA[i] = scan.nextInt();
        }
        for (int i = 0; i< vetorA.length; i++){
            System.out.printf("Entre com um valor na posicao: " + i + "\n");
            vetorB[i] = scan.nextInt();
        }
        for (int i=0; i<vetorA.length; i++){
            vetorC[i] = vetorA[i] / vetorB[i];
        }
        System.out.printf("Vetor A = ");
        for (int i=0; i<vetorA.length; i++){
            System.out.printf(vetorA[i] + " ");
        }
        System.out.printf("\n -------------- \n");
        System.out.printf("Vetor B = ");
        for (int i=0; i<vetorB.length; i++){
            System.out.printf(vetorB[i] + " ");
        }
        System.out.printf("\n -------------- \n");
        System.out.printf("Vetor C = ");
        for (int i=0; i<vetorC.length; i++){
            System.out.printf(vetorC[i] + " ");
        }
    }
}
