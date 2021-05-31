package com.van.log.microservices.fipe.dtos.responses;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DadosVeiculoDto {

	@JsonAlias({"valor","Valor"})
	private String valor;
	private String Marca;
	private String Modelo;
	private Integer AnoModelo;
	private String Combustivel;
	private String CodigoFipe;
	private String MesReferencia;
	private Integer TipoVeiculo;
	private String SiglaCombustivel;

	public DadosVeiculoDto(String valor, String marca, String modelo, Integer anoModelo, String combustivel,
			String codigoFipe, String mesReferencia, Integer tipoVeiculo, String siglaCombustivel) {
		this.valor = valor;
		Marca = marca;
		Modelo = modelo;
		AnoModelo = anoModelo;
		Combustivel = combustivel;
		CodigoFipe = codigoFipe;
		MesReferencia = mesReferencia;
		TipoVeiculo = tipoVeiculo;
		SiglaCombustivel = siglaCombustivel;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public Integer getAnoModelo() {
		return AnoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		AnoModelo = anoModelo;
	}

	public String getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(String combustivel) {
		Combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return CodigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		CodigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return MesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		MesReferencia = mesReferencia;
	}

	public Integer getTipoVeiculo() {
		return TipoVeiculo;
	}

	public void setTipoVeiculo(Integer tipoVeiculo) {
		TipoVeiculo = tipoVeiculo;
	}

	public String getSiglaCombustivel() {
		return SiglaCombustivel;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		SiglaCombustivel = siglaCombustivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AnoModelo == null) ? 0 : AnoModelo.hashCode());
		result = prime * result + ((CodigoFipe == null) ? 0 : CodigoFipe.hashCode());
		result = prime * result + ((Combustivel == null) ? 0 : Combustivel.hashCode());
		result = prime * result + ((Marca == null) ? 0 : Marca.hashCode());
		result = prime * result + ((MesReferencia == null) ? 0 : MesReferencia.hashCode());
		result = prime * result + ((Modelo == null) ? 0 : Modelo.hashCode());
		result = prime * result + ((SiglaCombustivel == null) ? 0 : SiglaCombustivel.hashCode());
		result = prime * result + ((TipoVeiculo == null) ? 0 : TipoVeiculo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosVeiculoDto other = (DadosVeiculoDto) obj;
		if (AnoModelo == null) {
			if (other.AnoModelo != null)
				return false;
		} else if (!AnoModelo.equals(other.AnoModelo))
			return false;
		if (CodigoFipe == null) {
			if (other.CodigoFipe != null)
				return false;
		} else if (!CodigoFipe.equals(other.CodigoFipe))
			return false;
		if (Combustivel == null) {
			if (other.Combustivel != null)
				return false;
		} else if (!Combustivel.equals(other.Combustivel))
			return false;
		if (Marca == null) {
			if (other.Marca != null)
				return false;
		} else if (!Marca.equals(other.Marca))
			return false;
		if (MesReferencia == null) {
			if (other.MesReferencia != null)
				return false;
		} else if (!MesReferencia.equals(other.MesReferencia))
			return false;
		if (Modelo == null) {
			if (other.Modelo != null)
				return false;
		} else if (!Modelo.equals(other.Modelo))
			return false;
		if (SiglaCombustivel == null) {
			if (other.SiglaCombustivel != null)
				return false;
		} else if (!SiglaCombustivel.equals(other.SiglaCombustivel))
			return false;
		if (TipoVeiculo == null) {
			if (other.TipoVeiculo != null)
				return false;
		} else if (!TipoVeiculo.equals(other.TipoVeiculo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
