public class circunferencia implements areaCalculavel {

    private double raio;

    @Override
    public double calcularArea() {
       this.raio = 5;
       return Math.round(Math.PI * Math.pow(raio,2)) ;
    }
}