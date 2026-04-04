package com.mrbatista.jamesbeer.repository.helper.usuario;

import java.util.Optional;

import com.mrbatista.jamesbeer.model.Usuario;

public interface UsuariosQueries {
	
	public Optional<Usuario> porEmailEAtivo(String email);

}
