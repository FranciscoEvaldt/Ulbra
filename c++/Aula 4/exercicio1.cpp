#include <stdio.h>
//faça um programa que receba quatro numeros inteiros,calcule e mostre a some desses numeros.
int main() {
    int n1, n2, n3, n4, soma;
    printf("digite o valor de n1:\n");
    scanf("%d%*c",&n1);
    printf("digite o valor de n2:\n");
    scanf("%d%*c",&n2);
    printf("digite o valor de n3:\n");
    scanf("%d%*c",&n3);
    printf("digite o valor de n4:\n");
    scanf("%d%*c",&n4);
     soma=n1+n2+n3+n4;
    printf("soma é %d", soma);
    // printf("soma é:%d", n1+n2+n3+n4)
}