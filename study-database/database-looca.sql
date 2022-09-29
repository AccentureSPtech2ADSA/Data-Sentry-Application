create database databaseLooca;
use databaseLooca;

create table Teste(
	idTeste INT PRIMARY KEY AUTO_INCREMENT,
    teste VARCHAR(50)
);

INSERT INTO Teste VALUES
(NULL, 'você entrou no banco de dados');

INSERT INTO Teste VALUES
(NULL, 'parabéns, pela conexão c:');

SELECT * FROM Teste;

TRUNCATE TABLE Teste;