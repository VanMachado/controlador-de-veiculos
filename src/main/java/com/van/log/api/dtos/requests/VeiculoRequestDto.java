package com.van.log.api.dtos.requests;

import javax.validation.constraints.NotBlank;

import com.van.log.domain.models.Veiculo;

public class VeiculoRequestDto {

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;

	public VeiculoRequestDto(@NotBlank String marca, @NotBlank String modelo, @NotBlank String ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Veiculo toModel() {
		return new Veiculo(modelo, ano, marca);
	}

}
