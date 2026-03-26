package com.mrbatista.jamesbeer.repository.helper.cliente;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mrbatista.jamesbeer.model.Cliente;
import com.mrbatista.jamesbeer.repository.filter.ClienteFilter;

public interface ClientesQueries {
	
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);

}
