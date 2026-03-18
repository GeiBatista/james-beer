package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Cliente;
import com.mrbatista.jamesbeer.model.TipoPessoa;
import com.mrbatista.jamesbeer.repository.Estados;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	Estados estados;
	
	@RequestMapping("/novo")
	private ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		mv.addObject("estados", estados.findAll());
		return mv;
	}
	
	@PostMapping("/novo")
	private ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result,  RedirectAttributes attributes) {
		if(result.hasErrors()) {
		return novo(cliente);
		}
		
//		cadastroClienteService.salvar(cliente);
		attributes.addFlashAttribute("mensagem", "cliente salvo com sucesso!");
		return new ModelAndView("redirect:/clientes/novo");
	}
}
