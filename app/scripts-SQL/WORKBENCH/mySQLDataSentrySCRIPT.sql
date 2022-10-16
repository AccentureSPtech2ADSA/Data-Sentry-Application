drop database dataSentry;

CREATE DATABASE datasentry;
USE datasentry;
CREATE TABLE Hospital(
	_idHospital INT PRIMARY KEY AUTO_INCREMENT,
	cnpj CHAR(14),
	cep CHAR(8),
	numberAddress VARCHAR(10),
	complement VARCHAR(25),
	fantasyName VARCHAR(50),
	unit VARCHAR(25),
	corporateName VARCHAR(50),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

INSERT INTO Hospital VALUES
(NULL, '12345678901234', '12345678', '15043', 'Unidade de São Paulo 3', '33F', 'Health First', 'Albert Einstein', NULL, NULL);

SELECT * FROM Hospital;

CREATE TABLE UserHospital(
	_idUserHospital INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	password VARBINARY(150),
	contactPhone CHAR(13),
	fkHospital INT NOT NULL,
	FOREIGN KEY (fkHospital) REFERENCES Hospital(_idHospital),
	fkManager INT,
	FOREIGN KEY (fkManager) REFERENCES UserHospital(_idUserHospital),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

INSERT INTO UserHospital(name, email, password, fkHospital, fkManager) VALUES('Albert Einstein', 'albert@admin.com', 'admin', 1, NULL);
SELECT * FROM UserHospital;

CREATE TABLE Server(
	_serialServer VARCHAR(50) PRIMARY KEY, -- senão pegar serial vamos pegar outro dado único do PC
	isActive CHAR(1),
	description VARCHAR(100),
	fkHospital INT NOT NULL,
	FOREIGN KEY (fkHospital) REFERENCES Hospital(_idHospital),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

-- INSERT INTO Server(isActive, description, fkHospital) VALUES('12345', 1, "Teste",1, NULL, NULL);

CREATE TABLE Process(
	_idProcess INT PRIMARY KEY AUTO_INCREMENT, -- talvez vire o PID
	name VARCHAR(25),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE ComponentType( 
	_idComponentType INT PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(25), 
	measuramentUnit VARCHAR(5),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE ComponentServer(
	_idComponentServer INT AUTO_INCREMENT,
	serial VARCHAR(50),
	model VARCHAR(60),
	brand VARCHAR(50),
	maxUse DECIMAL(10,2),
	fkServer VARCHAR(50) NOT NULL,
	FOREIGN KEY (fkServer) REFERENCES Server(_serialServer),
	fkComponentType INT NOT NULL,
	FOREIGN KEY (fkComponentType) REFERENCES ComponentType(_idComponentType),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (_idComponentServer, fkComponentType)
);

-- INSERT INTO ComponentServer(serial, model, brand, maxUse, fkServer, fkComponentType) VALUES ('636B913AS', 'TOSHIBA DT01ACA050 ATA Device (Unidades de disco padrão)', '\\.\PHYSICALDRIVE1', 500.00, '130911703604264', 3);

CREATE TABLE LogComponentPerProcess(
	_idLogComponentPerProcess INT AUTO_INCREMENT,
	usageComponent decimal(10,2),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	fkProcess INT,
	FOREIGN KEY (fkProcess) REFERENCES Process(_idProcess),
	fkComponentType INT,
	fkComponentServer INT,
	FOREIGN KEY (fkComponentServer, fkComponentType)
	REFERENCES ComponentServer(_idComponentServer, fkComponentType),
	PRIMARY KEY (_idLogComponentPerProcess, fkComponentServer, fkComponentType, fkProcess)
);

SELECT * FROM Server;
SELECT * FROM ComponentType;
SELECT * FROM ComponentServer;