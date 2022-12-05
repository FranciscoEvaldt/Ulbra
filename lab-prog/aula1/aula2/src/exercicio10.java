import java.util.Scanner;
public class exercicio10 {
    public static void main(String[] args) {
        double produto;
        double acrescimo;


        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o preço de custo de um produto: ");
        produto= tc.nextDouble();
        System.out.println("Digite o percentual que voce quer ganhar em cima do produto: ");
        acrescimo= tc.nextDouble();

        System.out.println("O valor de venda do produto informado anteriormente é de: " + (produto+(produto*acrescimo)/100));
    }
}

