package com.mrbatista.jamesbeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CidadeController {
	
	@RequestMapping("/cidades/nova")
	private String novo() {
		return "cidade/CadastroCidade";
	}

}
