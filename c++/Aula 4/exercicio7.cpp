#include <stdio.h>
int main() {
  //Imprimir acentuação no terminal

  float salarioBase, salarioAreceber;

  printf("Informe o salario base do colaborador: $");
  scanf("%f%*c", &salarioBase);

  float imposto = salarioBase - (salarioBase - (salarioBase*10/100));
  salarioAreceber = salarioBase + 50 - imposto;
  printf("Salario a receber: $%.2f \n", salarioAreceber);
  return 0;
}