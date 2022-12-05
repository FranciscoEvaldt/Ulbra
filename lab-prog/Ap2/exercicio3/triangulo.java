public class triangulo implements areaCalculavel {

        private double lado , altura;

        @Override
        public double calcularArea() {
            this.altura = 5;
            this.lado = 5;
            return (lado* altura)/2 ;
        }
}
