#include <stdio.h>
int main() {
   //Código para mostrar caracteries especiais no console.
  
  int numero;
  printf("Digite um numero: ");
  scanf("%d%*c", &numero);
  //Validando número recebido do usuário
  while(numero <= 0) {
   printf("Numero invalido\n");
   printf("digite um numero maior que zero: ");
   scanf("%d%*c", &numero);
  }
  int aoQuadrado =(numero, 2);
  int aoCubo =(numero, 3);
  float raizQuadrada =(numero);
  float raizCubica =(numero);

  printf("O numero %d ao quadrado e: %d\n", numero, aoQuadrado);
  printf("O numero %d ao cubo e: %d\n", numero, aoCubo);
  printf("A raiz quadrada do numero %d e: %.2f\n", numero, raizQuadrada);
  printf("A raiz cubica do numero %d e: %.2f\n", numero, raizCubica);
  return 0;
}