package com.van.log.api.dtos.responses;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.van.log.domain.models.Veiculo;

public class VeiculoResponseDto {

	private Integer id;
	private String marca;
	private String ano;
	private String modelo;
	private BigDecimal valor;
	private String nomeUsuario;
	private String numeroDoRodizio;
	private Boolean rodizioAtivo;

	public VeiculoResponseDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.ano = ano(veiculo);
		this.modelo = veiculo.getModelo();
		this.valor = veiculo.getValor();
		this.nomeUsuario = veiculo.getUsuario().getNome();
		this.numeroDoRodizio = calculaDiaDoRodizio(this.ano);
		this.rodizioAtivo = calcularRodizioAtivo(this.ultimoDigitoDoAno(this.ano));

	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	public Integer getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getnumeroDoRodizio() {
		return numeroDoRodizio;
	}

	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}

	private String ano(Veiculo veiculo) {
		return veiculo.getAno().substring(0, 4);
	}

	private String calculaDiaDoRodizio(String ano) {
		
		Integer ultimoDigitoAno = ultimoDigitoDoAno(ano);
		String diaSemana = DiaRodizio.getValorByUltimoNumero(ultimoDigitoAno);
		
		return diaSemana;
		
	}

	private Integer ultimoDigitoDoAno(String ano) {
		return Integer.valueOf(ano.substring(3, 4));
	}

	private Boolean calcularRodizioAtivo(Integer ultimoNumeroDoAno) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//0 - domingo, 7 - sabado.
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		boolean isAtivo = DiaRodizio.isDiaRodizio(dayOfWeek, ultimoNumeroDoAno);
		
		return isAtivo;
	}

}
