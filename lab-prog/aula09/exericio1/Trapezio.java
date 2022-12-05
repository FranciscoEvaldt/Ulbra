package exericio1;

public class Trapezio {

    double baseMaior;
    double baseMenor;
    double altura;
    double area;

    public double calcularArea(){
        this.area = (this.baseMaior + this.baseMenor /2) * (this.altura);
        return area;
    }
}
