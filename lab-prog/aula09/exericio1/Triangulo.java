package exericio1;

public class Triangulo {
    double base;
    double altura;
    double area;

    public double calcularArea(){
        this.area = this.base * this.altura / 2;
        return area;
    }
}
