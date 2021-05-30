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

import com.van.log.domain.models.Usuario;
import com.van.log.domain.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// ajeitar o path
	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public UsuarioController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

}
