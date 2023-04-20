CREATE TABLE Produtos ( 
 id_Produto INT AUTO_INCREMENT PRIMARY KEY,
 Quantidade INT, 
 Descrição VARCHAR(100),  
 Preco DECIMAL,  
 Nome_produto VARCHAR(50)
); 

CREATE TABLE Pedidos ( 
 ID INT AUTO_INCREMENT PRIMARY KEY, 
 Quantidade INT,  
 Valor_total DECIMAL,  
 Data_pedido DATE,  
 id_Cliente INT,
 Nome_cliente VARCHAR(50),
 Nome_produto VARCHAR(50),
 Telefone VARCHAR(20),  
 Email VARCHAR(50),  
 Endereço VARCHAR(100),
 CONSTRAINT FK_Pedidos_Cliente 
 FOREIGN KEY(id_Cliente) REFERENCES Cliente (id_Cliente)
); 

CREATE TABLE Cliente ( 
 id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
 CPF CHAR(11),  
 Nome_cliente VARCHAR(50),  
 Telefone VARCHAR(20),  
 Email VARCHAR(50),  
 Endereço VARCHAR(100)
); 

CREATE TABLE Forma_pagamento ( 
 Boleto INT,  
 Cartão INT,  
 Pix INT  
); 

CREATE TABLE Carrinho ( 
  id_Produtos INT AUTO_INCREMENT PRIMARY KEY,  
  Nome_produto VARCHAR(50),  
  endereço VARCHAR(100)
);

CREATE TABLE Estoque(
	ID INT AUTO_INCREMENT PRIMARY KEY, 
    Nome_produto VARCHAR(50),
    quantidade INT,
    id_Produto INT,
    Descrição VARCHAR(100),
	Preco DECIMAL, 
    CONSTRAINT Fk_Estoque_Produtos 
    FOREIGN KEY(id_Produto) REFERENCES Produtos (id_Produto)
);    

INSERT INTO Estoque (id_Produto, quantidade, Nome_produto, Descrição, Preco) VALUES
('1', '5', 'Celular', 'Iphone 14 Pro Max', 7990),
('2' ,'10', 'Notebook', 'Acer Nitro 5', 5600),
('3' ,'7', 'MacBook', 'MacBook Pro 13', 4560),
('4' ,'8', 'Monitor', 'Monitor Gamer LG 22', 1240),
('5' ,'28', 'Microfone', 'Microfone QuadCast S', 979),
('6' ,'90', 'Mouse', 'Mouse Logitech G903', 526),
('7' ,'69', 'Teclado', 'Teclado Mecanico Razer', 469),
('8' ,'32', 'Headset', 'Havit HD2002', 199),
('9' ,'54', 'Apple Watch', 'Apple Watch Ultra', 9299),
('10' ,'9', 'Console', 'Playstation 5', 4290);

INSERT INTO Pedidos (Quantidade, Nome_produto, Nome_cliente, Endereço, Telefone, Email) VALUES
('2', 'Celular', 'João Silva', 'Av. Paulista, 1000', '(11) 9999-8888', 'joao.silva@email.com'),
('3', 'Notebook', 'Maria Santos', 'Rua Augusta, 200', '(11) 9888-7777', 'maria.santos@email.com'),
('1', 'MacBook', 'Pedro Souza', 'Rua da Consolação, 500', '(11) 9777-6666', 'pedro.souza@email.com'),
('5', 'Monitor', 'Ana Rodrigues', 'Av. Brigadeiro Faria Lima, 2000', '(11) 9697-0799', 'ana.rodrigues@email.com'),
('12', 'Microfone', 'José Almeida', 'Rua Oscar Freire, 800', '(11) 9555-4444', 'jose.almeida@email.com'),
('43', 'Mouse', 'Maria Silva', 'Rua A, 123', '(11) 99999-9999', 'maria.silva@email.com'),
('24', 'Teclado', 'João Santos', 'Rua B, 456', '(11) 88888-8888', 'joao.santos@email.com'),
('16', 'Headset', 'Pedro Oliveira', 'Rua C, 789', '(11) 77777-7777', 'pedro.oliveira@email.com'),
('32', 'Apple Watch', 'Carla Souza', 'Rua D, 1010', '(11) 66666-6666', 'carla.souza@email.com'),
('4', 'Console', 'Fernando Santos', 'Rua E, 1111', '(11) 55555-5555', 'fernando.santos@email.com');

select * from Pedidos;

CREATE VIEW vw_produto_estoque AS
SELECT e.id_Produto, e.Nome_produto, e.Quantidade, e.Descrição, e.Preco, p.id_Produto AS id_produto_pedido, SUM(p.Quantidade) AS Quantidade_pedidos
FROM Estoque e
LEFT JOIN Pedidos p ON e.id_Produto = p.id_Produto
GROUP BY e.id_Produto;

CREATE VIEW vw_pedido_cliente AS
SELECT p.ID, p.Nome_produto, p.Quantidade, p.Valor_total, p.Data_pedido, c.id_Cliente, c.Nome_cliente, c.Telefone, c.Email, c.Endereço
FROM Pedidos p
INNER JOIN Cliente c ON p.id_Cliente = c.id_Cliente;

CREATE VIEW vw_pedido_estoque AS
SELECT p.ID, p.Nome_produto, p.Quantidade, e.Quantidade AS Quantidade_estoque, e.Preco AS Preco_unitario, e.Preco * p.Quantidade AS Valor_total_estoque
FROM Pedidos p
INNER JOIN Estoque e ON p.id_Produto = e.id_Produto;

DELIMITER $$
CREATE PROCEDURE SP_INSERIR_PEDIDO 
(
    IN id_Cliente INT, 
    IN id_Produto INT, 
    IN Quantidade INT, 
    IN Data_pedido DATE, 
    IN Valor_total DECIMAL(10, 2)
)
BEGIN
    INSERT INTO Pedidos (id_Cliente, id_Produto, Quantidade, Data_pedido, Valor_total) 
    VALUES (id_Cliente, id_Produto, Quantidade, Data_pedido, Valor_total);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SP_ATUALIZAR_ESTOQUE (
    IN p_id_Produto INT, 
    IN p_Quantidade INT
)
BEGIN
    UPDATE Estoque 
    SET quantidade = quantidade - p_Quantidade 
    WHERE id_Produto = p_id_Produto;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SP_CALCULAR_TOTAL_PEDIDO (
    IN id_Cliente INT, 
    IN Data_pedido DATE 
)
BEGIN
    SELECT SUM(Valor_total) AS Total_pedidos 
    FROM Pedidos 
    WHERE id_Cliente = id_Cliente AND Data_pedido = Data_pedido;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SP_LISTAR_CLIENTES_PEDIDOS() 
BEGIN
    SELECT Cliente.Nome, COUNT(Pedidos.ID) AS Qtd_pedidos, SUM(Pedidos.Quantidade) AS Qtd_total_produtos, SUM(Pedidos.Valor_total) AS Valor_total_pedidos
    FROM Cliente 
    JOIN Pedidos ON Cliente.id_Cliente = Pedidos.id_Cliente
    GROUP BY Cliente.Nome;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SP_LISTAR_PRODUTOS_ESTOQUE() 
BEGIN
    SELECT Produtos.Nome_produto, Produtos.Quantidade, Estoque.quantidade AS Estoque_atual
    FROM Produtos 
    JOIN Estoque ON Produtos.id_Produto = Estoque.id_Produto;
END $$
DELIMITER ;

