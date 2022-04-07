#include <stdio.h>
int main() {
  //Código para mostrar caracteries especiais no console.
  
  int numero1, numero2;

  printf("digite um numero maior que zero: ");
  scanf("%d%*c", &numero1);
  //Validando numero recebido
  while(numero1 <= 0) {
    printf("Numero invalido\n");
    printf("digite um numero maior que zero: ");
    scanf("%d%*c", &numero1);
  }
  printf("digite outro numero: ");
  scanf("%d%*c", &numero2);
  //Validando numero recebido
  while(numero2 <= 0) {
    printf("Numero invalido\n");
    printf("digite um numero maior que zero: ");
    scanf("%d%*c", &numero2);
  }
  
  int resultado =(numero1, numero2);
  printf("Os numero %d elevado ao numero %d e igual a: %d\n", numero1, numero2, resultado);
  return 0;
}