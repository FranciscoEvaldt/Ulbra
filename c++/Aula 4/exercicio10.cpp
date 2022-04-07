#include <stdio.h>
int main() {
  //Imprimir acentuação no terminal
  int raio;
  float pi = 3.14;

  printf("Raio do circulo: ");
  scanf("%d%*c", &raio);

  float areaCirculo = pi *(raio*raio);
  printf("O a area do circulo é %.1f \n", areaCirculo);
}