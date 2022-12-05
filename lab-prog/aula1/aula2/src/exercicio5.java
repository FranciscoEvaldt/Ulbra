import java.util.Scanner;
public class exercicio5 {
    public static void main(String[] args) {
        int combustivelTotal;
        int distancia;
        Scanner tc = new Scanner(System.in);
        System.out.println("Digite a distancia percorrida: ");
        distancia= tc.nextInt();
        System.out.println("Digite a quantidade de combustivel gasto: ");
        combustivelTotal= tc.nextInt();
        System.out.println("o consumo medio de combustivel foi de: " + (distancia/combustivelTotal) + "km/l");
    }
}

