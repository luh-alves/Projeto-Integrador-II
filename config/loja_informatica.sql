create database loja_informatica;
use loja_informatica;
create table produto
(
    id int auto_increment primary key,
    nome varchar(45) not null,
    quantidade int not null,
    valor double not null
);
create table endereco
(
    id int  auto_increment primary key,
    rua varchar(45),
    complemento varchar(45),
    cep varchar(10),
    bairro varchar(45),
    cidade varchar(10),
    uf char(2)
);

create table cliente
(
    id int auto_increment primary key,
    cpf varchar(14) unique not null,
    nome varchar(45) not null,
    sexo varchar(45) not null,
    email varchar(45) not null,
    telefone varchar(30),
    data_nascimento date,
    estado_civil varchar(45),
    endereco int,
    foreign key(endereco) references endereco(id)
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
    quantidade_produto int,
    id_produto int,
    id_venda int,
    foreign key(id_produto) references produto(id),
    foreign key(id_venda) references venda(id)
);