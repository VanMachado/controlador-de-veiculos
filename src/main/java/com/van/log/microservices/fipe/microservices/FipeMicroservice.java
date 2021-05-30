package com.van.log.microservices.fipe.microservices;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.van.log.microservices.fipe.dtos.responses.AnoDtoResponse;
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

	public String obterCodigoDoModelo(String nomeModelo, String nomeMarca) {

		ModeloDtoResponse modelo = fipeEndpoint.getDadosAnoModelo(nomeMarca);

		return geCodigoDoModelo(modelo, nomeModelo);

	}

	private String geCodigoDoModelo(ModeloDtoResponse modelo, String nomeModelo) {

		for (ModeloInternoDtoResponse modeloInternoDtoReponse : modelo.getModelosInternos()) {
			if (modeloInternoDtoReponse.getNome().equals(nomeModelo)) {
				return modeloInternoDtoReponse.getCodigo();
			}
		}
		return null;
	}

	public String obterCodigoDoAno(String nomeAno, String nomeModelo) {

		ModeloDtoResponse modelo = fipeEndpoint.getDadosAnoModelo(nomeModelo);

		return getCodigoDoAno(modelo, nomeAno);

	}

	private String getCodigoDoAno(ModeloDtoResponse modelo, String nomeAno) {

		for (AnoDtoResponse anoDtoReponse : modelo.getAnos()) {
			if (anoDtoReponse.getNome().equals(nomeAno)) {
				return anoDtoReponse.getCodigo();
			}
		}
		return null;
	}

	public BigDecimal getValorDoVeiculo(String codigoMarca, String codigoModelo, String codigoAno) {

		DadosVeiculoDto dadosDoVeiculo = fipeEndpoint.getDadosDoVeiculo(codigoMarca, codigoModelo, codigoAno);

		return dadosDoVeiculo.getBigDecimalValor();

	}

}
