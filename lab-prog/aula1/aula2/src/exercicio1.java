public class exercicio1 {
    public static void main(String[] args){
        double nota1 = 8.5;
        double nota2 = 7.5;
        double nota3 = 6.0;
        double peso1 = 3;
        double peso2 = 2;
        double peso3 = 5;
        double parcial1 = nota1 * peso1;
        double parcial2 = nota2 * peso2;
        double parcial3 = nota3 * peso3;

        System.out.println("a media eh "+ (parcial1 + parcial2 + parcial3) / (peso1 + peso2 + peso3) );
    }
}
