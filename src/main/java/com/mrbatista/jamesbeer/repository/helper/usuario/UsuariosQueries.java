package com.mrbatista.jamesbeer.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.mrbatista.jamesbeer.model.Usuario;
import com.mrbatista.jamesbeer.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	
	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
	
	public List<Usuario> filtrar(UsuarioFilter filtro);
	
}