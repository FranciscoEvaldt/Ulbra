import java.util.Random;
public class exercicio3 {
    public static void main(String[] args) {

        Random aleatorio = new Random();
       int valor = aleatorio.nextInt((10 - 5) + 1) + 5;
        System.out.println("N�mero: " + valor);
        System.out.println("-------------------");
        System.out.println("A senha � ");
        for (int i = 0; i < valor; i++) {
            int senha = (int)(Math.random() * 10 ) + 1;
            System.out.println(senha);
        }
    }
}
