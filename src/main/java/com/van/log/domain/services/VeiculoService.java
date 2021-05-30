package com.van.log.domain.services;

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
		String codigoModelo = fipeMicroservice.obterCodigoDoModelo(nomeModelo, nomeMarca);
		
		String nomeAno = veiculo.getAno();
		String codigoAno = fipeMicroservice.obterCodigoDoAno(nomeAno, nomeModelo);
		
		Veiculo save = veiculoRepository.save(veiculo);
		return save;

	}

}
