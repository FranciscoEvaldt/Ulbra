#include <stdio.h>
int main(){

//Faça um programa que receba três números, calcule e mostre a multiplicação desses números.

float n1, n2, n3, resultado;

printf("digite o primeiro numero");
scanf("%f", &n1);

printf("digite o segundo numero");
scanf("%f",&n2);

printf("digite o terceiro numero");
scanf("%f",&n3);

resultado =(n1*n2*n3); 

printf("a multiplicacao de um numero pelo outro e:$%.2f\n", resultado);
}