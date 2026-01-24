package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Cerveja;

@Controller
public class CervejaController {
	
	private static final Logger  logger = LoggerFactory.getLogger(CervejaController.class);
	
	@RequestMapping("/cervejas/novo")
	private String novo(Cerveja cerveja) {
		logger.error("Log nivel error!");
		logger.info("Log nivel info!");
		
		
		return "cerveja/CadastroCerveja";
	}
	
	@PostMapping("/cervejas/novo")
	private String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
//			model.addAttribute(cerveja);
//			model.addAttribute("mensagem", "Campo obrigatório");			
		return novo(cerveja);
		}
		
		attributes.addFlashAttribute("mensagem", "cerveja salva com sucesso!");
		System.out.println("SKU: " +  cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
}
