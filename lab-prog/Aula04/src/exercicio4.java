import javax.swing.JOptionPane;
public class exercicio4 {
    public static void main(String[] args) {

//        4 - Construa uma classe que receba uma frase qualquer e mostre essa
//        frase de tra?s para a frente e sem espac?os em branco,

        String frase = JOptionPane.showInputDialog( "Digite uma frase: ");
        String fraseInvertida = new StringBuilder(frase).reverse().toString();
        JOptionPane.showMessageDialog(null, fraseInvertida);
    }
}
