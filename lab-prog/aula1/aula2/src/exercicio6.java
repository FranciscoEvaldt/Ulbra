import java.util.Scanner;
import java.lang.String;
public class exercicio6 {
    public static void main(String[] args) {
        double salario, vendas, nota3;

        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o nome do vendedor: ");
        String vendedor = tc.next();
        System.out.println("Digite o salario fixo R$: ");
        salario= tc.nextDouble();
        System.out.println("Digite o total de vendas R$: ");
        vendas= tc.nextDouble();

        System.out.println("O vendedor " + vendedor + " possui salario fixo de : " + salario + " e nesse mes teve um salario total de R$:" +(salario+(vendas*0.15)));
    }
}


