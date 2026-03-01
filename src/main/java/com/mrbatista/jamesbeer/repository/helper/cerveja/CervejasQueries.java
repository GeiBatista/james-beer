package com.mrbatista.jamesbeer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
