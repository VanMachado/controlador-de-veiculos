package com.van.log.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.van.log.domain.models.Usuario;
import com.van.log.domain.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

		if (cpfEmUso) {
			throw new IllegalStateException("Já existe um Usuário cadastrado com esse CPF");
		}

		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail()).stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

		if (emailEmUso) {
			throw new IllegalStateException("Já existe um Usuário cadastrado com esse Email");
		}
		
		return usuarioRepository.save(usuario);

	}
}
