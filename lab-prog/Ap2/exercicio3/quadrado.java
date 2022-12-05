public class quadrado implements areaCalculavel {

    private double lado;

    @Override
    public double calcularArea() {
        this.lado = 10;
        return lado*lado;
    }
}
