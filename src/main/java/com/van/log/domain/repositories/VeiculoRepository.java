package com.van.log.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.van.log.domain.models.Usuario;
import com.van.log.domain.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

	List<Veiculo> findByUsuario(Usuario usuario);

}
