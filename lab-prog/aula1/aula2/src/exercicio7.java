import java.util.Scanner;
import java.lang.String;
public class exercicio7 {
    public static void main(String[] args) {
        double nota1, nota2, nota3;

        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String aluno = tc.next();
        System.out.println("Digite a primeira nota: ");
        nota1= tc.nextDouble();
        System.out.println("Digite a segunda nota: ");
        nota2= tc.nextDouble();
        System.out.println("Digite a terceira nota: ");
        nota3= tc.nextDouble();
        System.out.println("O aluno " + aluno + " teve media: " + ((nota1+nota2+nota3)/3));
    }
}

