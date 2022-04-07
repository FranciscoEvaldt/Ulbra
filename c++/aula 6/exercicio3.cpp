#include <stdio.h>

//Faça um programa que receba dois números, calcule e mostre a divisão do primeiro número pelo segundo. Sabe-se que o segundo número não pode ser zero, portanto, não é necessário se preocupar com validações.

int main(){
    float n1, n2, resultado;
     
    printf("digite o primeiro numero");
    scanf("%f", &n1);

    printf("digite o segundo numero");
    scanf("%f",&n2);

    resultado =(n1/n2);

    printf("a divisao de um numero pelo outro e:$%.2f\n", resultado);
}