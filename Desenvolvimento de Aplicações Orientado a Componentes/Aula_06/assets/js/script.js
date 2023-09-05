// Array de objetos de pessoas
const data = [
    { nome: 'Francisco', idade: 19 },
    { nome: 'Maria', idade: 11 },
    { nome: 'Pedro', idade: 55 }
];

// Função para criar a lista de pessoas e exibi-la na <ul>
function exibirListaDePessoas() {
    // Recupere o elemento <ul> pelo seu id
    const listaPessoas = document.getElementById('listaPessoas');

    // Chame a função para exibir a lista de pessoas e defina o conteúdo da <ul>
    listaPessoas.innerHTML = MinhaListaDePessoasComponente(data);
}

// Use o método map para criar uma lista de <li> com os dados das pessoas
function MinhaListaDePessoasComponente(data) {
    return data.map(item => {
        return `<li>${item.nome} - ${item.idade} anos</li>`;
    }).join("");
}

// Chame a função para exibir a lista de pessoas
exibirListaDePessoas();





