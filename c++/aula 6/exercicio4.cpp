#include <stdio.h>

//Faça um programa que receba duas notas, calcule e mostre a média ponderada dessas notas, considerando peso 2 para a primeira e peso 3 para a segunda.

int main(){
    float nota1, nota2, media;
    
    printf("o valor de nota1 e 2");
    scanf("%f", &nota1);

    printf("o valor de nota2 e 3");
    scanf("%f", &nota2);

    media = (nota1*2)+(nota2*3)/3+2;

    printf("o valor da media e:%.2f\n",media);
}