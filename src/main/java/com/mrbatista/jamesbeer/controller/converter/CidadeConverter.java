package com.mrbatista.jamesbeer.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mrbatista.jamesbeer.model.Cidade;
import com.mrbatista.jamesbeer.model.Estilo;

public class CidadeConverter implements Converter<String, Cidade> {

	@Override
	public Cidade convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Cidade cidade = new Cidade();
			cidade.setCodigo(Long.valueOf(codigo));
			return cidade;			
		}
		
		return null;
	}

}
