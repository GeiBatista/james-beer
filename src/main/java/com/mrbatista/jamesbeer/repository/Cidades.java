package com.mrbatista.jamesbeer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Cidade;

@Repository
public interface Cidades extends JpaRepository<Cidade, Long>{
	
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
	public Optional<Cidade> findByNomeIgnoreCase(String nome);

}
