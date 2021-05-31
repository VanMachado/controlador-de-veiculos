package com.van.log.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.van.log.api.dtos.requests.UsuarioRequestDto;
import com.van.log.api.dtos.requests.VeiculoRequestDto;
import com.van.log.api.dtos.responses.VeiculoResponseDto;
import com.van.log.domain.models.Usuario;
import com.van.log.domain.models.Veiculo;
import com.van.log.domain.repositories.UsuarioRepository;
import com.van.log.domain.repositories.VeiculoRepository;
import com.van.log.domain.services.VeiculoService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping("/usuarios")
	public ResponseEntity<?> adicionar(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto,
			UriComponentsBuilder uriComponentsBuilder) {

		Usuario usuario = usuarioRequestDto.toModel();

		Usuario salvo = usuarioRepository.save(usuario);

		return ResponseEntity.created(uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(salvo.getId()).toUri())
				.body(salvo);
	}

	@GetMapping("/usuarios/{idUsuario}/veiculos")
	public ResponseEntity<List<VeiculoResponseDto>> listar(@PathVariable Integer idUsuario) {

		Optional<Usuario> findById = usuarioRepository.findById(idUsuario);

		if (findById.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Usuario usuario = findById.get();

		List<Veiculo> veiculos = veiculoRepository.findByUsuario(usuario);
		
		List<VeiculoResponseDto> veiculosDto = new ArrayList<>();
		
		veiculos.forEach(veiculo -> {
			
			veiculosDto.add(new VeiculoResponseDto(veiculo));
			
		});
		
		return ResponseEntity.status(HttpStatus.OK).body(veiculosDto);

	}

	@PostMapping("/usuarios/{idUsuario}/veiculos")
	public ResponseEntity<VeiculoResponseDto> cadastrarVeiculo(@PathVariable Integer idUsuario,
			@Valid @RequestBody VeiculoRequestDto veiculoRequestDto, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Usuario> findById = usuarioRepository.findById(idUsuario);

		if (findById.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Usuario usuario = findById.get();

		Veiculo veiculo = veiculoRequestDto.toModel();

		veiculo.setUsuario(usuario);

		Veiculo cadastrado = veiculoService.cadastrar(veiculo);

		VeiculoResponseDto veiculoResponseDto = new VeiculoResponseDto(cadastrado);

		return ResponseEntity.created(uriComponentsBuilder.path("/usuarios/{idUsuario}/veiculos/{idVeiculo}")
				.buildAndExpand(usuario.getId(), cadastrado.getId()).toUri()).body(veiculoResponseDto);

	}
}
