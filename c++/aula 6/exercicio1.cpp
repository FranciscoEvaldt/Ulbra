#include <stdio.h>
//Faça um programa que receba dois números, calcule e mostre a subtração do primeiro número pelo segundo.
int main(){
    float n1, n2, resultado;

    printf("digite o primeiro numero");
    scanf("%f", &n1);

    printf("digite o segundo numero");
    scanf("%f",&n2);

    resultado = (n1 - n2);

    printf("a subtracao do numero um pelo numero dois e: %.2f\n", resultado);

    return 0;
}
