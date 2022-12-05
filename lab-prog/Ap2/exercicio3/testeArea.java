public class testeArea {
    public static void main(String[] args) {

        areaCalculavel a1 = new quadrado();
            System.out.println("Area Quadrado = " + a1.calcularArea());

        areaCalculavel b1 = new circunferencia();
            System.out.println("Cicunferencia = " + b1.calcularArea());

        areaCalculavel c1 = new triangulo();
            System.out.println("Area Triangulo = " + c1.calcularArea());
    }
}
