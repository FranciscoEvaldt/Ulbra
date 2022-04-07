#include <stdio.h>
int main() {
  //Imprimir acentuação no terminal

  float salarioBase, salarioAreceber;
  //recebe dados usuário
  printf("Digite o salário base do colaborador: $");
  scanf("%f%*c", &salarioBase);
  //Calculo do salario a receber
  float gratificacao = salarioBase * 5/100;
  float imposto = salarioBase - (salarioBase - salarioBase * 7/100);
  salarioAreceber = salarioBase + gratificacao - imposto;
  //Imprime o resultado
  printf("Salario a receber: $%.2f \n", salarioAreceber);
  return 0;
}