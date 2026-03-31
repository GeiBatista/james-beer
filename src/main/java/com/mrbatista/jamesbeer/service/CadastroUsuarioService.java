package com.mrbatista.jamesbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrbatista.jamesbeer.model.Estilo;
import com.mrbatista.jamesbeer.model.Usuario;
import com.mrbatista.jamesbeer.repository.Usuarios;
import com.mrbatista.jamesbeer.service.exception.estilo.NomeEstiloJaCadastradoException;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> usuarioExistente = usuarios.findByNomeIgnoreCase(usuario.getNome());
		if(usuarioExistente.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Já existe um estilo com o nome " + usuario.getNome());
		}
		return usuarios.saveAndFlush(usuario);
	}

}
