create table usuario (
	id_usuario int not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    senha varchar(15) not null,

    primary key (id_usuario));


    INSERT INTO usuario (nome, email, senha) VALUES ('Valdir','valdir@mail.com','123');
    INSERT INTO usuario (nome, email, senha) VALUES ('Kakachi','kaka@mail.com','123');