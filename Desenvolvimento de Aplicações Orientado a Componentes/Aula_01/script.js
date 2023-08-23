function somarDoisNumeros(numero1, numero2) {
    return numero1 + numero2;
    console.log("A soma de", numero1, "e", numero2, "é:", resultado);
  }
  
  // Exemplo de uso:
  somarDoisNumeros(5, 8); // Saída no console: "A soma de 5 e 7 é: 12"

function classificarParesEImpares(lista) {
    const pares = [];
    const impares = [];
  
    for (let i = 0; i < lista.length; i++) {
      if (typeof lista[i] === 'number' && Number.isInteger(lista[i])) {
        if (lista[i] % 2 === 0) {
          pares.push(lista[i]);
        } else {
          impares.push(lista[i]);
        }
      }
    }
  
    return { pares, impares };
  }
  
  // Exemplo de uso da função
  const listaExemplo = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  const resultado = classificarParesEImpares(listaExemplo);
  console.log("Números pares:", resultado.pares);
  console.log("Números ímpares:", resultado.impares);
    