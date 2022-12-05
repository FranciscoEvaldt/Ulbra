import javax.swing.*;
import java.util.Scanner;
public class exercicio5 {
    public static void main(String[] args) {

//      5 - Elabore uma classe que receba uma frase e verique que se essa frase
//      possui palavras impro?prias. As palavras impro?prias sa?o: sexo e sexual. Caso
//      encontre uma dessas palavras, emita em tela a mensagem �conteu?do
//      impro?prio�, caso contra?rio �conteu?do liberado�,

        Scanner ler = new Scanner(System.in);
        String frase = JOptionPane.showInputDialog( "Digite uma frase: ");

        if (frase.indexOf("sexo") != -1) {
            System.out.println("Conte�do Impr�prio");
        }else if (frase.indexOf("sexual") != -1) {
            System.out.println("Conte�do Impr�prio");
        }else {
            System.out.println(frase);
        }
    }
}
