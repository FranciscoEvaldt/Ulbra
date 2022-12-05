import javax.swing.*;

public class Main {

    public static void main(String args[]) {

        String aux = JOptionPane.showInputDialog("");
        String resp = ("");
        for (int i = 0; i < aux.length(); i++) {
            resp = resp + aux.charAt(aux.length() - i - 1);
        }
        JOptionPane.showMessageDialog(null, resp);
        }

    }

