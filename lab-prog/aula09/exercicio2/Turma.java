package exercicio2;

public class Turma
{
    public Aluno alunos[] = new Aluno[10];
    public final int NUMERO_ALUNOS = 10;

    public void lerDadosTurma()
    {
        for (int i=0; i<NUMERO_ALUNOS; i++)
        {
            alunos[i] = new Aluno();
            alunos[i].lerDadosAluno();
            System.out.printf("O aluno %s teve como média %.1f\n\n", alunos[i].nome, alunos[i].calcularMedia());
        }
    }

    public float calcularMediaTurma()
    {
        float somaMedia = 0;
        float mediaTurma;
        for (int i=0; i<NUMERO_ALUNOS; i++)
        {
            somaMedia += alunos[i].calcularMedia();
        }
        mediaTurma = somaMedia / NUMERO_ALUNOS;
        return mediaTurma;
    }

    public Aluno melhorAluno()
    {
        int melhorAluno = 0;
        for (int i=1; i<NUMERO_ALUNOS; i++)
        {
            if (alunos[i].calcularMedia() > alunos[melhorAluno].calcularMedia())
                melhorAluno = i;
        }
        return alunos[melhorAluno];
    }

    public void listarAlunos()
    {
        System.out.println("Lista de alunos com médias:");
        for (int i=0; i<NUMERO_ALUNOS; i++)
            System.out.printf("Aluno: %s - Média: %.1f\n", alunos[i].nome, alunos[i].calcularMedia());
    }

}
