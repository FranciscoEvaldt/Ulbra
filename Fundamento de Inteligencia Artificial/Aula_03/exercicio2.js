//preencha com os valores desejados
var x0 = 1, x1 = -1
var w0 = -1, w1 = 1

//escolha a função desejada (LR, FR ou FS)
var funcao = 'FS'

//variaveis para uso
var y

if (funcao == 'LR'){
    y = limiteRapido(soma(x0, x1, w0, w1))

}else if(funcao == 'FR'){
    y = rampa(soma(x0, x1, w0, w1))

}else if(funcao == 'FS'){
    y = sigmoid(soma(x0, x1, w0, w1))

}

console.log("Saída: "+ y + ", Função utilizada: "+funcao)

function soma(_x0, _x1, _w0, _w1){
    var soma
    soma = (_x0*_w0) + (_x1*_w1)
    console.log("Soma: "+ soma)
    return soma
}

function limiteRapido(_soma){
    if(_soma <= 0){
        return 0 
    }else if(_soma > 1){
        return 1
    }else{
        return _soma
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

