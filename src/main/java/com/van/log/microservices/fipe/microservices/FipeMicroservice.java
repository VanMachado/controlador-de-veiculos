package com.van.log.microservices.fipe.microservices;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.van.log.microservices.fipe.dtos.responses.DadosVeiculoDto;
import com.van.log.microservices.fipe.dtos.responses.MarcaDtoReponse;
import com.van.log.microservices.fipe.dtos.responses.ModeloDtoResponse;
import com.van.log.microservices.fipe.dtos.responses.ModeloInternoDtoResponse;
import com.van.log.microservices.fipe.endpoints.FipeEndpoint;

@Service
public class FipeMicroservice {

	@Autowired
	private FipeEndpoint fipeEndpoint;

	private String getCodigoDaMarca(List<MarcaDtoReponse> marcas, String nomeMarca) {

		for (MarcaDtoReponse marcaDtoReponse : marcas) {
			if (marcaDtoReponse.getNome().equals(nomeMarca)) {
				return marcaDtoReponse.getCodigo();
			}

		}

		return null;
	}

	public String obterCodigoDaMarca(String nomeMarca) {

		List<MarcaDtoReponse> marcas = fipeEndpoint.getMarcas();

		return getCodigoDaMarca(marcas, nomeMarca);

	}

	public String obterCodigoDoModelo(String nomeModelo, String codigoMarca) {

		ModeloDtoResponse modelo = fipeEndpoint.getDadosAnoModelo(codigoMarca);

		return getCodigoDoModelo(modelo, nomeModelo);

	}

	private String getCodigoDoModelo(ModeloDtoResponse modelo, String nomeModelo) {

		for (ModeloInternoDtoResponse modeloInternoDtoReponse : modelo.getModelos()) {

			if (modeloInternoDtoReponse.getNome().equals(nomeModelo)) {
				return modeloInternoDtoReponse.getCodigo();
			}

		}

		return null;

	}

	public BigDecimal getValorDoVeiculo(String codigoMarca, String codigoModelo, String codigoAno) {

		DadosVeiculoDto dadosDoVeiculo = fipeEndpoint.getDadosDoVeiculo(codigoMarca, codigoModelo, codigoAno);

		String valorString = dadosDoVeiculo.getValor();

		System.out.println("1 - valor: " + dadosDoVeiculo.getValor());
		System.out.println("2 - valor: " + dadosDoVeiculo.getMarca());
		System.out.println("4 - valor: " + dadosDoVeiculo.getModelo());
		System.out.println("3 - valor: " + dadosDoVeiculo.getAnoModelo());
		System.out.println("5 - valor: " + dadosDoVeiculo.getCombustivel());
		System.out.println("6 - valor: " + dadosDoVeiculo.getCodigoFipe());

		BigDecimal valorVeiculo = getBigDecimalValor(valorString);

		return valorVeiculo;

	}

	private BigDecimal getBigDecimalValor(String valorString) {
		String removeSigla = valorString.substring(3);

		String limpaNumero = removeSigla.replace(".", "");
		String padronizaNumero = limpaNumero.replace(",", ".");

		BigDecimal valorFinal = new BigDecimal(padronizaNumero);

		return valorFinal;
	}

}
