package com.mrbatista.jamesbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrbatista.jamesbeer.model.Usuario;
import com.mrbatista.jamesbeer.repository.Usuarios;
import com.mrbatista.jamesbeer.service.exception.usuario.EmailUsuarioJaCadastradoException;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> emailExistente = usuarios.findByEmail(usuario.getEmail());
		if(emailExistente.isPresent()) {
			throw new EmailUsuarioJaCadastradoException("E-mail já cadastrado");
		}
		return usuarios.saveAndFlush(usuario);
	}

}
