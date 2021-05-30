package com.van.log.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.van.log.domain.models.Veiculo;
import com.van.log.domain.repositories.VeiculoRepository;


@RestController
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculos")
	public List<Veiculo> listar() {
		return veiculoRepository.findAll();
	}

	public VeiculoController(VeiculoRepository veiculoRepository) {
		super();
		this.veiculoRepository = veiculoRepository;
	}
	
	@PostMapping("/veiculos")
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@Valid @RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
}
