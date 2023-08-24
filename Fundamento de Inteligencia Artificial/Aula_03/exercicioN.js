var entradas_pesos = [
    [1, -1],
    [-1, 1],
    [0, 0]
];

//escolha a função desejada (LR, FR, FS)
var funcao = 'LR'

//variaveis para uso 
var y 

if(funcao == 'LR'){
    y = limiteRapido(soma(entradas_pesos))

}else if(funcao == 'FR'){
    y = rampa(soma(entradas_pesos))

}else if(funcao == 'FS'){
    y = sigmoid(soma(entradas_pesos))
}

console.log("Saída: "+ y + ", Função utilizada: "+funcao)

//funções utilizadas para aprimorar a estrutura
function soma(_entradas_pesos) {
    var soma = 0, i
    for(i=0; i < _entradas_pesos.length; i++){
        soma = soma + (_entradas_pesos[i][0] * _entradas_pesos[i][1])

    }
    //um métodos mais práticos para se percorrer uma array
    //_entradas_pesos.forEach(element => {
    //  soma = soma + (element [0]*element[1])  
    // });
    console.log("Soma: "+ soma)
    return soma 
}

function limiteRapido(_soma){
    if(_soma <= 0){
        return -1
    }else{
        return 1
    }
}

function rampa(_soma){
    if(_soma < 0){
        return 0
    }else if(_soma > 1){
        return 1 
    }else{
        return _soma
    }
}

function sigmoid(_soma){
    if(_soma >= 0){
        return 1 - 1/(1 + _soma)
    }else{
        return -1 + 1/(1 - _soma)
    }
}