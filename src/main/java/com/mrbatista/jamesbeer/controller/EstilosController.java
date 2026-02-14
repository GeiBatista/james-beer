package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Estilo;
import com.mrbatista.jamesbeer.service.CadastroEstiloService;
import com.mrbatista.jamesbeer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstilosController {
	
	@Autowired
	CadastroEstiloService cadastroEstiloService;

	@RequestMapping("/estilos/novo")
	public String novo(Estilo estilo) {
		return "estilo/CadastroEstilo";
	}
	
	@PostMapping("/estilos/novo")
	public String cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso!");
		return "redirect:/estilos/novo";
	}
	
}
