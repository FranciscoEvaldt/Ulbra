import java.util.Scanner;
import java.lang.String;
public class exercicio3 {
    public static void main(String[] args) {
        int num1 = 1, num2 = 0;

        for(int i = 0; i <=15; i++){
            num1 = num1 + num2;
            num2 = num1 - num2;
            System.out.println(i + "- " + num1);
        }
    }
}

