create table usuario (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	email varchar(255) not null,
	cpf varchar(20) not null,
	datanascimento date not null,

	primary key (id)
);