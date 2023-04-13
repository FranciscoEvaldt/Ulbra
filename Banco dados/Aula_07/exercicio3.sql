DELIMITER //

CREATE PROCEDURE InserirLivro(IN pTitulo varchar(100), IN pAutor varchar(100), IN pDataPublicacao date)
BEGIN
    INSERT INTO Livros(Titulo, Autor, DataPublicacao)
    VALUES(pTitulo, pAutor, pDataPublicacao);
END //

CREATE PROCEDURE ExcluirLivro(IN pCodigo int)
BEGIN
    DELETE FROM Livros
    WHERE Codigo = pCodigo;
END //

CREATE PROCEDURE AtualizarLivro(IN pCodigo int, IN pTitulo varchar(100), IN pAutor varchar(100), IN pDataPublicacao date)
BEGIN
    UPDATE Livros
    SET Titulo = pTitulo, Autor = pAutor, DataPublicacao = pDataPublicacao
    WHERE Codigo = pCodigo;
END //

DELIMITER ;
