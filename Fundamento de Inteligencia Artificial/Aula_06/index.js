function main() {

  // Iterando sobre os padrões de treinamento
  var padroes = [
    { entrada: [0, 0], saida: 0 },
    { entrada: [0, 1], saida: 0 },
    { entrada: [1, 0], saida: 1 },
    { entrada: [1, 1], saida: 1 }
  ];

  function soma(entrada) {
    return (entrada[0] * -1) + (entrada[1] * -1) + (1 * -1);
  }

  // Função para ajuste sináptico
  function ajuste(x1, x2, yd, yo, w1, w2) {
    w1 = 0 + c * (yd - yo) * x1;
    w2 = 0 + c * (yd - yo) * x2;
    return [w1, w2];
  }

  // Função de transferência - Rampa
  function rampa(soma) {
    if (soma <= 0) {
      return 0;
    } else {
      return 1;
    }
  }

  function ativacaoNeuronio() {
    let mapaDeValores = [[]]

    let treinado = true;
    do {
      for (var i = 0; i < padroes.length; i++) {
        var entrada = padroes[i].entrada;
        var yd = padroes[i].saida;

        var soma = soma(entrada)

        var yo = rampa(soma);

        if (yo !== yd) {
          [w1, w2] = ajuste(entrada[0], entrada[1], yd, yo, w1, w2);
          console.log("Pesos ajustados (TREINADO): w1 = " + w1 + ", w2 = " + w2);
          treinado = false;
        }

      }
    } while (treinado === false)

  }

}