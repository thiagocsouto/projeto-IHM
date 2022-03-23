create table produto(id integer auto_increment, nome varchar(50), preço varchar(20), categoria varchar(50), quantidade integer);

create table cliente(id integer auto_increment, nome varchar(50), cpf varchar(18), sexo varchar(15), idade integer);   
 
create table funcionario(id integer auto_increment, nome varchar(50), matricula varchar(20), cpf varchar(20), sexo varchar(20), cargo varchar(20), admissao varchar(10));

create table usuario(id integer auto_increment, username varchar(30), password varchar(60));