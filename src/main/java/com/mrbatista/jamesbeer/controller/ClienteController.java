package com.mrbatista.jamesbeer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mrbatista.jamesbeer.model.TipoPessoa;
import com.mrbatista.jamesbeer.repository.Estados;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	Estados estados;
	
	@RequestMapping("/novo")
	private ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		mv.addObject("estados", estados.findAll());
		return mv;
	}
}
