package com.mrbatista.jamesbeer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long>{

	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

}
