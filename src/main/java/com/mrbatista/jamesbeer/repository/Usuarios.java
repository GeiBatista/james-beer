package com.mrbatista.jamesbeer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Usuario;
import com.mrbatista.jamesbeer.repository.helper.usuario.UsuariosQueries;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {
	
	public Optional<Usuario> findByEmail(String email);

}
