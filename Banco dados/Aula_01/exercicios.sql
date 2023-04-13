/*
1- Sim, existe uma restrição quanto à ordem de execução da criação das tabelas, pois há dependências entre elas. 
  As tabelas que possuem chaves estrangeiras devem ser criadas após as tabelas às quais as chaves estrangeiras se referem.

  Uma sequência correta para a criação das tabelas do esquema acima seria:

  Cidade
  Filial
  Produto
  Empregado
  Vende
  Isso porque a tabela Empregado possui a chave estrangeira codcid que faz referência à tabela Cidade. 
  A tabela Filial possui a chave estrangeira codcid que também faz referência à tabela Cidade. 
  A tabela Produto não possui chaves estrangeiras, portanto pode ser criada em qualquer ordem. 
  A tabela Vende possui chaves estrangeiras que fazem referência às tabelas Produto e Filial, que já foram criadas. 
  Por fim, a tabela Empregado pode ser criada, pois todas as tabelas às quais possui referência já foram criadas.
*/

2- 

CREATE TABLE Cidade (
  codcid INT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  uf CHAR(2) NOT NULL
);

CREATE TABLE Filial (
  codfilial INT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  codcid INT,
  FOREIGN KEY (codcid) REFERENCES Cidade(codcid)
);

CREATE TABLE Produto (
  codprod INT PRIMARY KEY,
  descricao VARCHAR(100) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  nomecategoria VARCHAR(50) NOT NULL,
  descricaocategoria VARCHAR(100) NOT NULL
);

CREATE TABLE Empregado (
  codemp INT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  codcid INT,
  ct VARCHAR(10) NOT NULL,
  rg VARCHAR(15) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  salario DECIMAL(10,2) NOT NULL,
  codfilial INT,
  FOREIGN KEY (codcid) REFERENCES Cidade(codcid),
  FOREIGN KEY (codfilial) REFERENCES Filial(codfilial)
);

CREATE TABLE Vende (
  codprod INT,
  codfilial INT,
  PRIMARY KEY (codprod, codfilial),
  FOREIGN KEY (codprod) REFERENCES Produto(codprod),
  FOREIGN KEY (codfilial) REFERENCES Filial(codfilial)
);


3-

CREATE TABLE Vende (
  id_produto INT,
  id_filial INT,
  preco DECIMAL(10,2),
  PRIMARY KEY (id_produto, id_filial),
  FOREIGN KEY (id_produto) REFERENCES Produto(id),
  FOREIGN KEY (id_filial) REFERENCES Filial(id)
);

CREATE TABLE Filial (
  id INT PRIMARY KEY,
  nome VARCHAR(50),
  cidade VARCHAR(50),
  estado VARCHAR(2)
);

SELECT MAX(preco) AS valor_mais_caro
FROM Produto;

SELECT AVG(preco) AS media_precos
FROM Produto;

SELECT p.nome AS nome_produto
FROM Produto p
JOIN Vende v ON p.id = v.id_produto
JOIN Filial f ON v.id_filial = f.id
WHERE f.nome = 'f3';

SELECT f.nome AS nome_funcionario, f.rg AS rg_funcionario
FROM Funcionario f
JOIN Endereco e ON f.id = e.id_funcionario
WHERE e.estado = 'RS' AND f.salario > 500.00;

4-

CREATE TABLE Categoria (
  codcat INT PRIMARY KEY,
  nome VARCHAR(50),
  descricao VARCHAR(100)
);

CREATE TABLE Livro (
  codlivro INT PRIMARY KEY,
  titulo VARCHAR(100),
  codautor INT,
  nfolhas INT,
  editora VARCHAR(50),
  valor DECIMAL(10,2),
  codcat INT,
  FOREIGN KEY (codcat) REFERENCES Categoria(codcat)
    ON DELETE CASCADE
);

5-

SELECT SUM(quantidade) as total_vendas FROM Venda;


SELECT L.titulo, L.valor, C.nome
FROM Livro L
JOIN Categoria C ON L.codcat = C.codcat
WHERE C.nome = 'banco de Dados';


SELECT L.titulo, A.nome
FROM Livro L
JOIN Autor A ON L.codautor = A.codautor
WHERE L.valor > 300;


SELECT C.nome, CI.nome as cidade, CI.UF
FROM Cliente C
JOIN Cidade CI ON C.codcid = CI.codcid;


SELECT C.nome, L.titulo
FROM Cliente C
JOIN Venda V ON C.codcliente = V.codcliente
JOIN Livro L ON V.codlivro = L.codlivro;


SELECT L.codlivro, L.titulo, A.nome
FROM Livro L
JOIN Autor A ON L.codautor = A.codautor
JOIN Venda V ON L.codlivro = V.codlivro
WHERE MONTH(V.data) = 3 AND YEAR(V.data) = 2021;


SELECT L.titulo, A.nome
FROM Livro L
JOIN Autor A ON L.codautor = A.codautor
JOIN Venda V ON L.codlivro = V.codlivro
WHERE MONTH(V.data) = 1
ORDER BY V.quantidade DESC
LIMIT 5;


SELECT C.nome
FROM Cliente C
JOIN Venda V ON C.codcliente = V.codcliente
JOIN Livro L ON V.codlivro = L.codlivro
WHERE L.titulo = 'Banco de dados powerful';
