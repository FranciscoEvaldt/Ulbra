CREATE TABLE Pessoas (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sexo ENUM('M', 'F') NOT NULL,
  data_nascimento DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE PROCEDURE InserirPessoa (
  IN p_nome VARCHAR(50),
  IN p_sexo ENUM('M', 'F'),
  IN p_data_nascimento DATE
)
BEGIN
  DECLARE v_id INT DEFAULT 0;
  
  SELECT MAX(id) INTO v_id FROM Pessoas;
  SET v_id = v_id + 1;
  
  INSERT INTO Pessoas (id, nome, sexo, data_nascimento)
  VALUES (v_id, p_nome, p_sexo, p_data_nascimento);
END;

CREATE PROCEDURE QuantidadeHomensEMulheres ()
BEGIN
  SELECT sexo, COUNT(*) AS quantidade FROM Pessoas
  GROUP BY sexo;
END;

CREATE PROCEDURE QuantidadeMaioresEMenoresDeIdade ()
BEGIN
  SELECT
    sexo,
    SUM(CASE WHEN data_nascimento <= DATE_SUB(NOW(), INTERVAL 18 YEAR) THEN 1 ELSE 0 END) AS maiores_de_idade,
    SUM(CASE WHEN data_nascimento > DATE_SUB(NOW(), INTERVAL 18 YEAR) THEN 1 ELSE 0 END) AS menores_de_idade
  FROM Pessoas
  GROUP BY sexo;
END;


DELIMITER //
CREATE PROCEDURE OperacoesMatematicas (IN numero1 INT, IN numero2 INT)
BEGIN
    SELECT CONCAT('Soma: ', (numero1 + numero2)) AS Resultado
    UNION
    SELECT CONCAT('Subtração: ', (numero1 - numero2)) AS Resultado
    UNION
    SELECT CONCAT('Multiplicação: ', (numero1 * numero2)) AS Resultado
    UNION
    SELECT CONCAT('Divisão: ', (CASE WHEN numero2 = 0 THEN NULL ELSE (numero1 / numero2) END)) AS Resultado;
END //
DELIMITER ;

CALL OperacoesMatematicas(10, 5);
