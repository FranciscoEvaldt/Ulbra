package exercicio2;
import javax.swing.JOptionPane;
public class ProgramaPrincipal
{
    public static void main(String[] args)
    {
        Turma turmaAlunos = new Turma();
        Aluno melhorAluno;

        JOptionPane.showMessageDialog(null, "Iniciando o programa Java.");

        turmaAlunos.lerDadosTurma();

        System.out.println("\n>>>A média da turma foi " + turmaAlunos.calcularMediaTurma());

        melhorAluno = turmaAlunos.melhorAluno();

        System.out.printf("\nO melhor aluno da turma foi %s com media igual a %.1f\n", melhorAluno.nome, melhorAluno.calcularMedia());

        turmaAlunos.listarAlunos();
    }
}
