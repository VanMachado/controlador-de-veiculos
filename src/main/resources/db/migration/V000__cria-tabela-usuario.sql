create table usuario (
	id bigint not null auto_increment,
	nome varchar(255) not null,
	email varchar(255) not null,
	cpf varchar(14) not null,
	data_nascimento date not null,

	primary key (id)
);