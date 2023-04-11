public class PreenchimentoAutomatico {
    public static void main(String[] args) {
        int[] numeros = new int[50];

        // preenchimento automático do vetor
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = 101 + i;
        }

        // exibição dos valores do vetor
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
