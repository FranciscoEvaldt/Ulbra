package exercicio2;
import java.util.Scanner;
public class Aluno
{
    public Scanner teclado = new Scanner(System.in);
    public String nome;
    public float primeiraNota;
    public float segundaNota;

    public void lerDadosAluno()
    {
        System.out.println("Digite o nome do aluno: ");
        nome = teclado.nextLine();
        System.out.println("Digite a primeira nota: ");
        primeiraNota = teclado.nextFloat();
        System.out.println("Digite a segunda nota: ");
        segundaNota = teclado.nextFloat();
    }

    public float calcularMedia()
    {
        return (primeiraNota+segundaNota)/2;
    }

}

