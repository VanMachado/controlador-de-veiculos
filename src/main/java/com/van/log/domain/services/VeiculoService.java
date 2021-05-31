package com.van.log.domain.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.van.log.domain.models.Veiculo;
import com.van.log.domain.repositories.VeiculoRepository;
import com.van.log.microservices.fipe.microservices.FipeMicroservice;

@Service
public class VeiculoService {

	@Autowired
	private FipeMicroservice fipeMicroservice;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo cadastrar(Veiculo veiculo) {

		String nomeMarca = veiculo.getMarca();
		String codigoMarca = fipeMicroservice.obterCodigoDaMarca(nomeMarca);

		String nomeModelo = veiculo.getModelo();
		String codigoModelo = fipeMicroservice.obterCodigoDoModelo(nomeModelo, codigoMarca);

		String codigoAno = veiculo.getAno();

		BigDecimal valorVeiculo = fipeMicroservice.getValorDoVeiculo(codigoMarca, codigoModelo, codigoAno);

		veiculo.setValor(valorVeiculo);

		Veiculo save = veiculoRepository.save(veiculo);
		return save;

	}

}
