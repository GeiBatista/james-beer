package com.mrbatista.jamesbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrbatista.jamesbeer.model.Cidade;
import com.mrbatista.jamesbeer.repository.Cidades;
import com.mrbatista.jamesbeer.service.exception.cidade.NomeCidadeJaCadastradaException;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public Cidade salvar(Cidade cidade) {
		Optional<Cidade> cidadeExistente = cidades.findByNomeIgnoreCase(cidade.getNome());
		if(cidadeExistente.isPresent()) {
			throw new NomeCidadeJaCadastradaException("Já existe uma cidade cadastrada com o nome " + cidade.getNome());
		}
		return cidades.saveAndFlush(cidade);
		
	}

}
