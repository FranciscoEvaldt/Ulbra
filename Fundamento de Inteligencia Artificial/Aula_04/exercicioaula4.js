function main() {
    // Função de transferência - Limite Rápido
    function limiteRapido(soma) {
      return soma <= 0 ? -1 : 1;
    }
    
    // Função de transferência - Rampa
    function rampa(soma) {
      if (soma < 0) {
        return 0;
      } else if (soma > 1) {
        return 1
      } else {
        return soma
      }
    }
    
    // Função de transferência - Sigmoid
    function sigmoid(soma) {
      return soma >= 0 ? 1 - 1 / (1 + soma) : -1 + 1 / (1 - soma);
    }
    
    // Variáveis iniciais
    var w1 = -1, w2 = -1;
    
    // Escolha a função desejada (LR, FR, FS)
    var funcao = 'FR';
    
    // Constante de aprendizado
    var c = 1;
    
    // Função para ajuste sináptico
    function ajuste(x1, x2, yd, yo, w1, w2) {
      w1 = w1 + c * (yd - yo) * x1;
      w2 = w2 + c * (yd - yo) * x2;
      return [w1, w2];
    }
    
    // Iterando sobre os padrões de treinamento
    var padroes = [
      { entrada: [1, 1], saida: 1 },
      { entrada: [1, 0], saida: 1 },
      { entrada: [0, 1], saida: 0 },
      { entrada: [0, 0], saida: 0 }
    ];
    
    // Iterações de treinamento
    var treinado = false;
    while (!treinado) {
      treinado = true;
    
      for (var i = 0; i < padroes.length; i++) {
        var entrada = padroes[i].entrada;
        var yd = padroes[i].saida;
    
        var soma = (entrada[0] * w1) + (entrada[1] * w2);
    
        var yo;
        if (funcao === 'LR') {
          yo = limiteRapido(soma);
          // !NÃO USAR! vai calcular infinitamente (necessário corrigir)        
        } else if (funcao === 'FR') {
          yo = rampa(soma);
        } else if (funcao === 'FS') {
          yo = sigmoid(soma);
        } 
    
        if (yo !== yd) {
          [w1, w2] = ajuste(entrada[0], entrada[1], yd, yo, w1, w2);
          console.log("Pesos ajustados (TREINADO): w1 = " + w1 + ", w2 = " + w2);
          treinado = false;
        }
      }
    }
    
    console.log("Pesos ajustados: w1 = " + w1 + ", w2 = " + w2);
  }
  
  main()
