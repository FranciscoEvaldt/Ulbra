function calculateLR(s) {
    return s <= 0 ? -1 : 1;
}

function calculateFR(s) {
    if (s < 0) {
        return 0;
    } else if (s <= 1) {
        return s;
    } else {
        return 1;
    }
}

function calculateFS(s) {
    if (s >= 0) {
        return 1 - 1 / (1 + s);
    } else {
        return -1 + 1 / (1 - s);
    }
}

function main() {
    const readline = require("readline");
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    console.log("Escolha a função de ativação:");
    console.log("LR - Função degrau");
    console.log("FR - Função sigmoide");
    console.log("FS - Função tangente hiperbólica");

    rl.question("Digite a sigla da função desejada: ", functionChoice => {
        const input1 = parseFloat(rl.question("Digite o valor da primeira entrada: "));
        const input2 = parseFloat(rl.question("Digite o valor da segunda entrada: "));
        const weight1 = parseFloat(rl.question("Digite o peso da primeira entrada: "));
        const weight2 = parseFloat(rl.question("Digite o peso da segunda entrada: "));

        const weightedSum = input1 * weight1 + input2 * weight2;

        let output;
        switch (functionChoice) {
            case "LR":
                output = calculateLR(weightedSum);
                break;
            case "FR":
                output = calculateFR(weightedSum);
                break;
            case "FS":
                output = calculateFS(weightedSum);
                break;
            default:
                console.log("Função de ativação não reconhecida");
                rl.close();
                return;
        }

        console.log("Saída calculada:", output);
        rl.close();
    });
}

main();

