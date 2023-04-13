DELIMITER //
CREATE PROCEDURE aumentar_preco_editora(
    IN editora_id INT,
    IN percentual_aumento DECIMAL(5,2)
)
BEGIN
    UPDATE livros
    SET preco = preco * (1 + (percentual_aumento / 100))
    WHERE editora_id = editora_id;
END//
DELIMITER ;
