package com.mrbatista.jamesbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrbatista.jamesbeer.model.Estilo;
import com.mrbatista.jamesbeer.repository.Estilos;
import com.mrbatista.jamesbeer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo) {
		Optional<Estilo> estiloExistente = estilos.findByNomeIgnoreCase(estilo.getNome());
		if(estiloExistente.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Já existe um estilo com o nome " + estilo.getNome());
		}
		estilos.save(estilo);
	}

}
