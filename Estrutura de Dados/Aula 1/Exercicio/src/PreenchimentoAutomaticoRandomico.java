import java.util.Random;

public class PreenchimentoAutomaticoRandomico {
    public static void main(String[] args) {
        int[] numeros = new int[50];
        Random gerador = new Random();

        // preenchimento automático randômico do vetor
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = gerador.nextInt(100);
        }

        // exibição dos valores do vetor
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
