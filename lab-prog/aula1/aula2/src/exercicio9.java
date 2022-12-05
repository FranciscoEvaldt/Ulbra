import java.util.Scanner;
public class exercicio9 {
    public static void main(String[] args) {
        double produto;


        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o valor da compra R$: ");
        produto= tc.nextDouble();
        System.out.println("A compra feita ficará em 5 prestações de R$ " + (produto/5) + " cada");
    }
}

