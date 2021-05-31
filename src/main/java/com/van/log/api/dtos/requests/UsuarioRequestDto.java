package com.van.log.api.dtos.requests;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.van.log.domain.models.Usuario;

public class UsuarioRequestDto {

	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@CPF
	@NotBlank
	private String cpf;
	
	@Past
	private Date dataNascimento;

	public UsuarioRequestDto(@NotBlank String nome, @Email @NotBlank String email, @CPF @NotBlank String cpf,
			@Past Date dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario toModel() {
		
		Usuario usuario = new Usuario(nome, email, cpf, dataNascimento);

		return usuario;
		
	}
	
}
