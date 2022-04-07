#include <stdio.h>
int main() {
  //Código para mostrar caracteries especiais no console.

  int anoNascimento, anoAtual, idade, idadeFuturo;
  printf("Digite o ano de nascimento: ");
  scanf("%d%*c", &anoNascimento);
  printf("Digite o ano atual: ");
  scanf("%d%*c", &anoAtual);

  idade = anoAtual - anoNascimento;
  idadeFuturo = 2050 - anoNascimento;
  printf("Sua idade e: %d\n.", idade);
  printf("Voce tera %d anos em 2050.\n", idadeFuturo);
  return 0;
}