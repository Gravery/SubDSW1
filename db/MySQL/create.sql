drop database if exists Veiculos;

create database Veiculos;

use Veiculos

create table Usuario(
id bigint not null auto_increment, 
nome varchar(256) not null, 
email varchar(128) not null unique, 
cpf varchar(13) not null unique, 
senha varchar(64) not null, 
sexo varchar(1),
nascimento date,
telefone varchar(11),
papel varchar(3) not null,
primary key (id));

create table Loja(
id bigint not null auto_increment, 
cnpj varchar(16) not null unique, 
nome varchar(256) not null, 
email varchar(128) not null unique, 
senha varchar(64) not null, 
descricao varchar(256),
primary key (id));

create table Carro(
id bigint not null auto_increment, 
idLoja bigint not null,
cnpj varchar(16) not null, 
placa varchar(256) not null unique, 
modelo varchar(256) not null, 
chassi varchar(256) not null, 
ano int not null, 
quilometragem float not null,
valor double not null,
descricao varchar(256),
primary key (id),
foreign key (idLoja) references Loja (id) ON DELETE CASCADE ON UPDATE CASCADE);


create table Proposta(
    id bigint not null auto_increment,
    idUsuario bigint not null,
    idLoja bigint not null,
    idCarro bigint not null,
    dataProposta date not null,
    valor float,
    pagamento varchar(50) not null,
    statusProposta int not null,
    primary key (id),
    foreign key (idUsuario) references Usuario (id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (idLoja) references Loja (id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (idCarro) references Carro (id) ON DELETE CASCADE ON UPDATE CASCADE);

insert into Usuario(nome, email, cpf, senha, nascimento, papel) values ('Administrador', 'admin@email.com', '123456789-10', 'admin', "2000-11-11" ,'ADM');

insert into Usuario(nome, email, cpf, senha, sexo, nascimento, telefone, papel) values ('Usuario', 'usuario@email.com', '123456789-20', 'user', 'F', "1999-12-12" , '123456789' ,'USR');

insert into Loja(cnpj, nome, email, senha, descricao) values ('1234567890/1234','Loja 1', 'loja1@email.com', '12345', 'Loja de Venda de Carros 1');

insert into Loja(cnpj, nome, email, senha, descricao) values ('0987654321/1234','Loja 2', 'loja2@email.com', '12345', 'Loja de Venda de Carros 2');

insert into Carro(idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao) values (1, '1234567890/1234', 'H1234E', 'Uno', '12345', 1990, 30000, 15000, 'Uno usado');

insert into Carro(idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao) values (1, '1234567890/1234', 'P2LM4', 'Fox', '12345', 2005, 20000, 30000, 'Fox usado');

insert into Carro(idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao) values (1, '1234567890/1234', 'A9O08F', 'Fusca', '12345', 1980, 15000, 10000, 'Fusca usado');

insert into Carro(idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao) values (1, '1234567890/1234', 'A5JM45', 'Palio', '12345', 2021, 0, 38000, 'Palio 0');

insert into Proposta(idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta) values (1, 1, 1, "2022-09-26", 10000, 'Cheque', 1);

insert into Proposta(idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta) values (2, 3, 1, "2022-09-26", 12000, 'A vista', 1);

insert into Proposta(idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta) values (3, 2, 1, "2022-09-26", 13000, 'Cartao', 0);

