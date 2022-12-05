package exericio1;

public class calcularAreaFiguras {

    public static void main(String[] args) {
        Triangulo a1 = new Triangulo();
        a1.base = 5;
        a1.altura = 10;
        System.out.println(a1.calcularArea());

        Quadrado b1 = new Quadrado();
        b1.lado = 5;
        System.out.println(b1.calcularArea());

        Circunferencia c1 = new Circunferencia();
        c1.raio = 5;
        System.out.println(c1.calcularArea());

        Trapezio d1 = new Trapezio();
        d1.baseMenor = 5;
        d1.baseMaior = 10;
        d1.altura = 5;
        System.out.println(d1.calcularArea());
    }
}
