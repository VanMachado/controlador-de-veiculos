create table veiculo (
	id bigint not null auto_increment,
	modelo varchar(255) not null,
	ano varchar(255) not null,
	marca varchar(2550) not null,
	valor decimal(10,2) not null,
	usuario_id bigint,
	primary key (id),
    
	constraint fk_usuario FOREIGN KEY (usuario_id) references usuario(id)
		 
);