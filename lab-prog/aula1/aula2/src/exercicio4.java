import java.util.Scanner;
public class exercicio4 {
    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner tc = new Scanner(System.in);
        System.out.println("Digite um numero");
        num1= tc.nextInt();
        System.out.println("Digite outro numero para ser somado com o primeiro:");
        num2= tc.nextInt();
        System.out.println("A soma do primeiro numero com o segundo é igual a: " + (num1+num2));
    }
}

