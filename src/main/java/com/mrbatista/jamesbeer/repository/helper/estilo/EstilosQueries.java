package com.mrbatista.jamesbeer.repository.helper.estilo;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mrbatista.jamesbeer.model.Estilo;
import com.mrbatista.jamesbeer.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public List<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);

}
