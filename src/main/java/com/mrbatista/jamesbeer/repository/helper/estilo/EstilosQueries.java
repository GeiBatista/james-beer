package com.mrbatista.jamesbeer.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mrbatista.jamesbeer.model.Estilo;
import com.mrbatista.jamesbeer.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);

}
