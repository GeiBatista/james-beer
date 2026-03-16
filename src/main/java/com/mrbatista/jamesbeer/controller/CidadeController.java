package com.mrbatista.jamesbeer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrbatista.jamesbeer.model.Cidade;
import com.mrbatista.jamesbeer.repository.Cidades;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private Cidades cidades;
	
	@RequestMapping("/nova")
	private String novo() {
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado){		
		return cidades.findByEstadoCodigo(codigoEstado);
	}

}
