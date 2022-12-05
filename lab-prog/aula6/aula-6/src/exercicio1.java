import java.util.Random;

public class exercicio1 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int num = new Random().nextInt(7) + 1;
            System.out.println(num);
        }
    }
}
