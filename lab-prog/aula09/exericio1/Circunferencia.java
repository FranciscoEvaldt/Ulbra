package exericio1;

import static java.lang.Math.PI;

public class Circunferencia {
    double raio;
    double area;

    public double calcularArea(){
        this.area = PI * Math.pow(this.raio, 2);
        return area;
    }
}
