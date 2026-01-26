package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.model.Origem;
import com.mrbatista.jamesbeer.model.Sabor;
import com.mrbatista.jamesbeer.repository.Cervejas;
import com.mrbatista.jamesbeer.repository.Estilos;

@Controller
public class CervejaController {
	
	private static final Logger  logger = LoggerFactory.getLogger(CervejaController.class);
	
	@Autowired Cervejas cervejas;
	@Autowired Estilos estilos;
	
	@RequestMapping("/cervejas/novo")
	private ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@PostMapping("/cervejas/novo")
	private ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
//		if(result.hasErrors()) {
//		return novo(cerveja);
//		}
		
		attributes.addFlashAttribute("mensagem", "cerveja salva com sucesso!");
		System.out.println("SKU: " +  cerveja.getSku());
		System.out.println("Sabor: " +  cerveja.getSabor());
		System.out.println("Origem: " +  cerveja.getOrigem());
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
}
