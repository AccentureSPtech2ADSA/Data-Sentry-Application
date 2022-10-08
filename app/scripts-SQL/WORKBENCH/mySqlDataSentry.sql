<<<<<<< HEAD
=======
drop database dataSentry;

>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
CREATE DATABASE datasentry;
USE datasentry;
 
CREATE TABLE Hospital(
	_idHospital INT PRIMARY KEY AUTO_INCREMENT,
	cnpj CHAR(14),
	cep CHAR(8),
	numberAddress VARCHAR(5),
    unit VARCHAR(50),
	complement VARCHAR(25),
	fantasyName VARCHAR(50),
	corporateName VARCHAR(50),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

INSERT INTO Hospital VALUES
(NULL, '12345678901234', '12345678', '15043', 'Unidade de São Paulo 3', '33F', 'Health First', 'Albert Einstein', NULL, NULL);

SELECT * FROM Hospital;

CREATE TABLE contactPhoneHospital(
	_idContactPhoneHospital INT AUTO_INCREMENT,
	contactPhone CHAR(13),
	fkHospital INT NOT NULL,
	FOREIGN KEY (fkHospital) REFERENCES Hospital(_idHospital),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(_idContactPhoneHospital, fkHospital)
);

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

CREATE TABLE Server(
<<<<<<< HEAD
	_serialServer VARCHAR(30) PRIMARY KEY, -- senão pegar serial vamos pegar outro dado único do PC
=======
	_serialServer VARCHAR(30) PRIMARY KEY, -- senão pegar serial vamos pegar outro dado único do PC -- SERIAL DO SO
>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
	isActive CHAR(1),
	fkHospital INT NOT NULL,
	FOREIGN KEY (fkHospital) REFERENCES Hospital(_idHospital),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

<<<<<<< HEAD
=======
INSERT INTO Server VALUES('12345', 1, 1, NULL, NULL);
SELECT * FROM SERVER;

>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
CREATE TABLE UserHasServer(
	_idUserHasServer INT AUTO_INCREMENT,
	isActive CHAR(1),
	fkServer VARCHAR(30) NOT NULL,
	FOREIGN KEY (fkServer) REFERENCES Server(_serialServer),
	fkUserHospital INT NOT NULL,
	FOREIGN KEY (fkUserHospital) REFERENCES UserHospital(_idUserHospital),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (_idUserHasServer, fkServer, fkUserHospital)
);

CREATE TABLE Process(
	_idProcess INT PRIMARY KEY AUTO_INCREMENT, -- talvez vire o PID
	name VARCHAR(25),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE ComponentType( 
	_idComponentType INT PRIMARY KEY AUTO_INCREMENT,
<<<<<<< HEAD
	description VARCHAR(25), 
	measuramentUnit VARCHAR(5),
=======
	description VARCHAR(25), -- colocar o tipo exemplo: CPU, MEMORIA RAM, HD
	measuramentUnit VARCHAR(6), -- Ghz/Gb/Mhz
>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE ComponentServer(
	_idComponentServer INT AUTO_INCREMENT,
<<<<<<< HEAD
	serial VARCHAR(30),
	model VARCHAR(25),
	yearManufatured CHAR(4),
	brand VARCHAR(25),
	fkServer VARCHAR(30) NOT NULL,
=======
	serial VARCHAR(30), -- SERIAL DO PROCESSADOR É O ID / memoria ram deixar null
	model VARCHAR(50), -- NOME COMPONENTE
	brand VARCHAR(25), -- MARCA/FABRICANTE (INTEL, AMD)
	fkServer VARCHAR(30) NOT NULL, -- VALOR DA FK DO 
>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
	FOREIGN KEY (fkServer) REFERENCES Server(_serialServer),
	fkComponentType INT NOT NULL,
	FOREIGN KEY (fkComponentType) REFERENCES ComponentType(_idComponentType),
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (_idComponentServer, fkComponentType)
);

CREATE TABLE LogComponentPerProcess(
	_idLogComponentPerProcess INT AUTO_INCREMENT,
<<<<<<< HEAD
	usageComponent decimal(10,2),
=======
	usageComponent decimal(10,2), -- UTILIZAÇÃO DO COMPONENTE -- ADICIONAR TOTAL
>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	fkProcess INT,
	FOREIGN KEY (fkProcess) REFERENCES Process(_idProcess),
	fkComponentType INT,
	fkComponentServer INT,
	FOREIGN KEY (fkComponentServer, fkComponentType)
	REFERENCES ComponentServer(_idComponentServer, fkComponentType),
	PRIMARY KEY (_idLogComponentPerProcess, fkComponentServer, fkComponentType, fkProcess)
<<<<<<< HEAD
);
=======
);

SELECT * FROM ComponentType;
SELECT * FROM ComponentServer;
>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb
