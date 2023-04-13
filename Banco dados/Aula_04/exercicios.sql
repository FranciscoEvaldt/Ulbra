SELECT clientes.nome AS nome_cliente, SUM(pedidos.valor_total) AS valor_total_compras, COUNT(pedidos.id) AS total_pedidos
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
GROUP BY clientes.nome
HAVING COUNT(pedidos.id) >=3;

--

SELECT produtos.categoria AS categoria_produto, produtos.nome AS nome_produto AVG(vendas.preco_venda) AS media_preco_venda, SUM(vendas.quantidade) AS total_unidades_vendidas
FROM produtos
LEFT JOIN vendas ON produtos.id = vendas.produto_id
GROUP BY produtos.categoria

--

SELECT fornecedores.nome AS nome_fornecedor, produtos.nome AS nome_produto, SUM(compras.quantidade) AS total_unidades_compradas
FROM fornecedores
INNER JOIN produtos ON fornecedores.id = produtos.fornecedor_id
INNER JOIN compras ON produtos.id = compras.produto_id
GROUP BY fornecedores.nome, produtos.nome
HAVING SUM(compras.quantidade) > 100;

--

SELECT departamentos.nome AS nome_departamento, funcionarios.nome AS nome_funcionario, AVG(funcionarios.salario) AS media_salario
FROM departamentos
LEFT JOIN funcionarios ON departamentos.id = funcionarios.departamento_id
GROUP BY departamentos.nome, funcionarios.nome
HAVING AVG(funcionarios.salario) > 5000;

--

SELECT clientes.nome AS nome_cliente, produtos.nome AS nome_produto, SUM(compras.valor_total) AS total_compras
FROM clientes
RIGHT JOIN compras ON clientes.id = compras.cliente_id
INNER JOIN produtos ON compras.produto_id = produtos.id
GROUP BY clientes.nome, produtos.nome;
