//Crie uma classe chamada Senha que contenha um método chamado gerar que retorna uma senha contendo oito caracteres numéricos. Faça também outra classe para testar o método.

import java.util.Random;

public class Senha {
    public static void main(String[] gerar){
        for (int i = 0; i < 8; i++){
            int num = new Random().nextInt(9);
            System.out.println(num);
        }
    }
}
