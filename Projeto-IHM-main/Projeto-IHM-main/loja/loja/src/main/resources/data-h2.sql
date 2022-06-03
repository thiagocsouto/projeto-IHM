insert into produto(id, nome, preço, categoria, quantidade) values
(1,'Relogio Technos','200,00', 'RELÓGIO', 16),
(2,'Samsung S10','2.600,00', 'SMARTPHONE', 10),
(3,'Ace Next','5.000,00', 'COMPUTADOR', 5),
(4,'TV Smart Philco 46','2.400,00', 'TV', 10)
;

insert into cliente(id, nome, cpf, sexo, idade) values
(1, 'Amaral Rocha', '006.248.673-10', 'MASCULINO', 19),
(2, 'Carlos Marinho', '062.588.103-56', 'MASCULINO', 33), 
(3, 'Ana Aldilha', '002.288.603-23', 'FEMININO', 20)
;  

insert into funcionario(id, nome, matricula, cpf, sexo, cargo, admissao) values
(1, 'Thiago Antonio', 'F06469', '042.588.103-56', 'MASCULINO', 'GERENTE' ,'01/11/2021'),  
(2, 'Fernando Lima', 'F0212', '032.274.403-15', 'MASCULINO', 'TI' ,'01/09/2020'),
(3, 'Livia Silver', 'F013015', '002.088.208-12', 'FEMININO', 'RH' ,'01/03/2020')
;   

INSERT INTO usuario(id, username, password) VALUES
(1,'thiago','$2a$10$3bBtLVKnR2IQoAYd/eJxz.J2VCtwIdlCAmFGnOQiK.GC9q7jyRvEa'),
(2,'lucas','$2a$10$2f9qA8KFD3ucYPnmj6PCQe4.tUdiU0xdc2iM1dcdt02kCBztSj0HS')
;  