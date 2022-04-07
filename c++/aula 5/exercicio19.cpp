#include <stdio.h>
int main(void) {
  float alturaDegrau, alturaObjetivo, quantidadeDegraus;
  printf("Digite a altura em metros do degrau da escada: ");
  scanf("%f%*c", &alturaDegrau);
  printf("Digite a altura que voce deseja alcancar: ");
  scanf("%f%*c", &alturaObjetivo);

  quantidadeDegraus = alturaObjetivo / alturaDegrau;
  printf("Voce precisa-ra subir %.0f degraus para alcançar %.0f metros de altura\n", quantidadeDegraus, alturaObjetivo);
  return 0;
}