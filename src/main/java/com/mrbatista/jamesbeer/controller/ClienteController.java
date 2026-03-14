package com.mrbatista.jamesbeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mrbatista.jamesbeer.model.TipoPessoa;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping("/novo")
	private ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		return mv;
	}
}
