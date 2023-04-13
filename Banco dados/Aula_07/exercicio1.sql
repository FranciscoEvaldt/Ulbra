DELIMITER //
CREATE TABLE EXERCICIOS;
CREATE PROCEDURE QuantidadeLivrosAutor(IN pCPF varchar(11))
BEGIN
    SELECT COUNT(*) as QuantidadeLivros
    FROM Livros
    WHERE CPF_Autor = pCPF;
END //

DELIMITER ;
