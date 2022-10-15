drop database scriptTestes;

create database scriptTestes;
use scriptTestes;

create table cpu(
	idCpu INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    fabricante VARCHAR(50),
    identificador VARCHAR(50),
    frequencia VARCHAR(50),
    microarquitetura VARCHAR(50),
    quantidadeNucleos INT
);

create table usoCpu(
	idUsoCpu INT PRIMARY KEY AUTO_INCREMENT,
    usoDeCpu DECIMAL(10,2),
    fkIdCpu INT,
    foreign key (fkIdCpu) references cpu(idCpu) 
);

INSERT INTO usoCpu VALUES (NULL, 10.5, 1);

select * from cpu;
select * from usoCpu;