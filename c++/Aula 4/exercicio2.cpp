#include <stdio.h>
//Faça um programa que receba três notas, calcule e mostre a média aritmética.
int main(){
    int nota1, nota2, nota3, media, soma;
    printf("digite o valor de nota1");
    scanf("%d%*c",&nota1);
    printf("digite o valor de nota2");
    scanf("%d%*c",&nota2);
    printf("digite o valor de nota3");
    scanf("%d%*c",&nota3);
    printf("digite o valor de media");
    scanf("%d%*c",&media);
     soma=nota1+nota2+nota3+media;
    printf("soma é %d", soma);
    // printf("soma é:%d", nota1+nota2+nota3+media)
}