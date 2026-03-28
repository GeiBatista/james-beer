package com.mrbatista.jamesbeer.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mrbatista.jamesbeer.model.Cidade;
import com.mrbatista.jamesbeer.repository.filter.CidadeFilter;

public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
}
