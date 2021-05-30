package com.van.log.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.van.log.domain.exceptions.NegocioException;
import com.van.log.domain.models.Usuario;
import com.van.log.domain.repositories.UsuarioRepository;

@Service
public class CatalagoService {

	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

		if (cpfEmUso) {
			throw new NegocioException("Já existe um Usuário cadastrado com esse CPF");
		}

		return usuarioRepository.save(usuario);

	}
}
