import java.util.Scanner;
import static java.lang.Math.sqrt;

public class exe4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetorA = new int[15];
        int[] vetorB = new int[vetorA.length];

        for (int i = 0; i< vetorA.length; i++){
            System.out.printf("Entre com um valor na posicao: " + i + "\n");
            vetorA[i] = scan.nextInt();
            vetorB[i] = vetorA[i];
        }
        for (int i=0; i<vetorA.length; i++){
            vetorB[i] = (int) sqrt(vetorA[i]);
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
    }
}
