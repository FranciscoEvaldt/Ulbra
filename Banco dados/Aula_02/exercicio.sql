CREATE TABLE produtos (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    custo DECIMAL(10,2),
    preco DECIMAL(10,2),
    estoque INT,
    CHECK (preco >= custo)
);

SELECT clientes.nome_cliente, pedidos.valor_pedido
FROM clientes
INNER JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente;

SELECT clientes.nome_cliente, pedidos.valor_pedido
FROM clientes
LEFT JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente;

SELECT clientes.nome_cliente, pedidos.valor_pedido
FROM clientes
RIGHT JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente;

SELECT clientes.cidade_cliente, SUM(pedidos.valor_pedido) as total_pedidos
FROM clientes
INNER JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente
GROUP BY clientes.cidade_cliente;

SELECT clientes.cidade_cliente, SUM(pedidos.valor_pedido) as total_pedidos
FROM clientes
INNER JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente
GROUP BY clientes.cidade_cliente
HAVING SUM(pedidos.valor_pedido) > 100;

tabela cliente 
vendas
produtos
formas de pagamento 
