const iserirHtml = document.getElementById('content');

const paginas = {
  home: `<div class="container">Welcome!!</div>`,
  contato: `
    <div class="container">
      <h2>Contate-nos</h2>
      <form id="form-contato">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" required><br>
        
        <label for="telefone">Telefone:</label>
        <input type="tel" id="telefone" required><br>
        
        <button type="submit">Enviar</button>
      </form>
    </div>`,
  sobre: `<div class="container">Página sobre.</div>`
};

iserirHtml.innerHTML = paginas.home;

const navLinks = document.querySelectorAll('.acessar a');
navLinks.forEach(link => {
  link.addEventListener('click', event => {
    event.preventDefault();
    const paginaAlvo = event.target.getAttribute('href').substring(1);
    iserirHtml.innerHTML = paginas[paginaAlvo];

    adicionarOuvinteAoFormulario()
  });
});

function adicionarOuvinteAoFormulario() {
    const dadosFormularioContato = document.getElementById('form-contato');
    dadosFormularioContato.addEventListener('submit', event => {
      event.preventDefault();
      const nome = document.getElementById('nome').value;
      const email = document.getElementById('email').value;
      const telefone = document.getElementById('telefone').value;
  
      const infosContato = { nome, email, telefone };
      exibirContato(infosContato);
      dadosFormularioContato.reset();
    });
}

function exibirContato(contato) {
  const table = document.createElement('div');
  table.innerHTML = `
  <h4>Valores digitados no formulário:</h4>
  <table>
    <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        </tr>
        <tr>
        <td>${contato.nome}</td>
        <td>${contato.email}</td>
        <td>${contato.telefone}</td>
        </tr>
  </table>
    
  `;
  iserirHtml.innerHTML = '';
  iserirHtml.appendChild(table);
}