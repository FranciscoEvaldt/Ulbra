CREATE TABLE Produtos ( 
 ID INT AUTO_INCREMENT PRIMARY KEY,  
 Descrição VARCHAR(50),  
 Preço DECIMAL,  
 Nome VARCHAR(50)  
); 

CREATE TABLE Pedidos ( 
 ID INT AUTO_INCREMENT PRIMARY KEY, 
 Quantidade INT,  
 Valor_total DECIMAL,  
 Data_pedido DATE,  
 id_Cliente INT,
 CONSTRAINT FK_Pedidos_Cliente 
 FOREIGN KEY(id_Cliente) REFERENCES Cliente (id_Cliente)
); 

CREATE TABLE Cliente ( 
 id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
 CPF CHAR(11),  
 Nome VARCHAR(50),  
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
  Id_produto INT AUTO_INCREMENT PRIMARY KEY,  
  Nome_produto VARCHAR(50),  
  endereço VARCHAR(100)
); 

INSERT INTO Produtos (Nome, Descrição, Preço) VALUES
('Celular', 'Iphone 14 Pro Max', '7990.90'),
('Notebook', 'Acer Nitro 5', '5600.99'),
('MacBook', 'MacBook Pro 13', '4560.30'),
('Monitor', 'Monitor Gamer LG 22', '1240.90'),
('Microfone', 'Microfone QuadCast S', '979.99'),
('Mouse', 'Mouse Logitech G903', '526.80'),
('Teclado', 'Teclado Mecanico Razer', '469.28'),
('Headset', 'Havit HD2002', '199.99'),
('Apple Watch', 'Apple Watch Ultra', '9299.99'),
('Console', 'Playstation 5', '4290.90')

