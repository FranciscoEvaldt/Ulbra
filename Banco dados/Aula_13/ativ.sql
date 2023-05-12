CREATE TABLE Produto 
( 
 Id_Produto INT PRIMARY KEY,  
 Nome VARCHAR(50),
 Tempo_Validade INT,  
 Categoria INT  
); 

CREATE TABLE Ingrediente 
( 
 Id_Ingrediente INT PRIMARY KEY, 
 Nome varchar(50) 
); 

CREATE TABLE Produto_Ingrediente 
( 
 Id_Produto INT,  
 Id_Ingrediente INT,
 Quantidade INT,
 FOREIGN KEY (Id_Produto) REFERENCES Produto(Id_Produto),
 FOREIGN KEY (Id_Ingrediente) REFERENCES Ingrediente(Id_Ingrediente)
);


CREATE TABLE Lote 
( 
 Id_Lote INT PRIMARY KEY,  
 Data_Producao INT,  
 Quantidade_Produzida INT  
); 

CREATE TABLE Lote_Produto 
( 
 Id_Lote INT,  
 Id_Produto INT, 
 FOREIGN KEY (Id_Lote) REFERENCES Lote(Id_Lote),
 FOREIGN KEY (Id_Produto) REFERENCES Produto(Id_Produto)
);


INSERT INTO Produto (ID_Produto, Nome, Categoria, Tempo_Validade)
VALUES (1, 'Pão de Forma', 'Pães', 3);
INSERT INTO Produto (ID_Produto, Nome, Categoria, Tempo_Validade)
VALUES (2, 'Bolo de Chocolate', 'Bolos', 2);
INSERT INTO Ingrediente (ID_Ingrediente, Nome)
VALUES (1, 'Farinha');
INSERT INTO Ingrediente (ID_Ingrediente, Nome)
VALUES (2, 'Açúcar');
INSERT INTO Produto_Ingrediente (ID_Produto, ID_Ingrediente, Quantidade)
VALUES (1, 1, 500);
INSERT INTO Produto_Ingrediente (ID_Produto, ID_Ingrediente, Quantidade)
VALUES (1, 2, 200);
INSERT INTO Lote (ID_Lote, Data_Producao, Quantidade_Produzida)
VALUES (1, '2023-05-10', 100);
INSERT INTO Lote_Produto (ID_Lote, ID_Produto)
VALUES (1, 1);

-- Exibir quantos produtos há para cada categoria;
SELECT Categoria, COUNT(*) AS Total
FROM Produto
GROUP BY Categoria;

-- Exibir todos os produtos, quais ingredientes e em que quantidade são  utilizados para produzi-lo; 
SELECT p.Nome AS Produto, i.Nome AS Ingrediente, pi.Quantidade
FROM Produto p
INNER JOIN Produto_Ingrediente pi ON p.ID_Produto = pi.ID_Produto
INNER JOIN Ingrediente i ON pi.ID_Ingrediente = i.ID_Ingrediente;

-- Exibir qual a quantidade produzida de cada produto dos últimos 30 dias; 
SELECT p.Nome AS Produto, SUM(lp.Quantidade_Produzida) AS Total_Produzido
FROM Produto p
INNER JOIN Lote_Produto lp ON p.ID_Produto = lp.ID_Produto
INNER JOIN Lote l ON lp.ID_Lote = l.ID_Lote
WHERE l.Data_Producao >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY p.Nome;


-- Se for dobrada a produção para o próximo mês, quanto de ingrediente será  necessário.  
SELECT p.Nome AS Produto, SUM(lp.Quantidade_Produzida) * 2 AS Quantidade_Necessaria
FROM Produto p
INNER JOIN Lote_Produto lp ON p.ID_Produto = lp.ID_Produto
INNER JOIN Lote l ON lp.ID_Lote = l.ID_Lote
WHERE l.Data_Producao >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY p.Nome;

-- Mostrar os ingredientes que nunca foram utilizados; 
SELECT i.Nome AS Ingrediente
FROM Ingrediente i
LEFT JOIN Produto_Ingrediente pi ON i.ID_Ingrediente = pi.ID_Ingrediente
WHERE pi.ID_Ingrediente IS NULL;


-- Crie uma trigger para garantir o controle de estoque dos produtos fabricados. 
-- Quanto um produto for fabricado deve dar saída dos estoque dos ingredientes utilizados. 
-- Caso ocorra o estorno da fabricação, manter o estoque dos ingredientes atualizado também;
DELIMITER $$
CREATE TRIGGER controle_estoque AFTER INSERT ON Lote_Produto
FOR EACH ROW
BEGIN
-- Atualizar estoque de ingredientes para saída
UPDATE Ingrediente
INNER JOIN Produto_Ingrediente ON Ingrediente.ID_Ingrediente = Produto_Ingrediente.ID_Ingrediente
SET Ingrediente.Quantidade = Ingrediente.Quantidade - (NEW.Quantidade_Produzida * Produto_Ingrediente.Quantidade)
WHERE Produto_Ingrediente.ID_Produto = NEW.ID_Produto;
END;
DELIMITER ;

START TRANSACTION;

-- Utilizando controle de transações, atualize as receitas para reduzir em 10% a  quantidade de fermento utilizada; 
UPDATE Produto_Ingrediente
SET Quantidade = Quantidade * 0.9
WHERE ID_Ingrediente = (SELECT ID_Ingrediente FROM Ingrediente WHERE Nome = 'Fermento');

-- Confirme a transação do exercício anterior; 
COMMIT;

-- Utilizando controle de transações, exclua todos os registros de produção do  último mês; 
START TRANSACTION;

DELETE FROM Lote_Produto
WHERE ID_Lote IN (SELECT ID_Lote FROM Lote WHERE Data_Producao >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH));

COMMIT;

-- Desfaça a transação realizada no exercício anterior;
ROLLBACK; 