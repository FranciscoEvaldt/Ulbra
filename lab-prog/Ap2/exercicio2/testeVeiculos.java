package exercicio2;

public class testeVeiculos {
    public static void main(String[] args) {
        veiculo a1 = new automovel();

        System.out.println(a1.ligar());

        veiculo b1 = new motocicleta();
        System.out.println(b1.desligar());

        veiculo c1 = new onibus();
        System.out.println(c1.ligar());
    }
}
