import java.util.Scanner;
import java.lang.String;
public class exercicio8 {
    public static void main(String[] args) {
        float auxiliar;
        float A;
        float B;

        Scanner tc = new Scanner(System.in);
        System.out.print("Digite o valor de A:");
        A = tc.nextInt();
        System.out.print("Digite o valor de B:");
        B = tc.nextInt();
        auxiliar = A;
        A = B;
        B = auxiliar;
        System.out.print("A =  " + A + "\nB = " + B);
    }
}

