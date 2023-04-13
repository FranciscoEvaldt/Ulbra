DELIMITER //

CREATE PROCEDURE AtualizarDataLancamento(IN pCodigo int, IN pDataPublicacao date)
BEGIN
    UPDATE Livros
    SET DataLancamento = pDataPublicacao
    WHERE Codigo = pCodigo;
END //

DELIMITER ;
