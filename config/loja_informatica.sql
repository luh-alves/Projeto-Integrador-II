create database loja_informatica;
use loja_informatica;
create table produto
(
    id int auto_increment primary key,
    nome varchar(45) not null,
    quantidade int not null,
    valor double not null
);

create table cliente
(
    id int auto_increment primary key,
    cpf varchar(14) unique not null,
    nome varchar(45) not null,
    sexo varchar(45) not null,
    email varchar(45) not null,
    telefone varchar(30),
    telefone2 varchar(30),
    data_nascimento date,
    estado_civil varchar(45),
    rua varchar(45),
    numero varchar(10),
    bairro varchar(45),
    cidade varchar(45),
    cep varchar(15),
    nacionalidade varchar(45),
    data_cadastro datetime,
    ultima_atualizacao datetime
    
);


create table venda
(
    id int auto_increment primary key ,
    data_venda date ,
    total double not null,
    id_cliente int,
    foreign key(id_cliente) references cliente(id)
);

create table venda_produto
(
    id_venda_produto int auto_increment primary key,
    quantidade_produto int,
    id_produto int,
    id_venda int,
    foreign key(id_produto) references produto(id),
    foreign key(id_venda) references venda(id)
);