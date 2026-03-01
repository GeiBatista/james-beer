package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.model.Origem;
import com.mrbatista.jamesbeer.model.Sabor;
import com.mrbatista.jamesbeer.repository.Cervejas;
import com.mrbatista.jamesbeer.repository.Estilos;
import com.mrbatista.jamesbeer.repository.filter.CervejaFilter;
import com.mrbatista.jamesbeer.service.CadastroCervejaService;

@Controller
@RequestMapping("/cervejas")
public class CervejaController {
	
	private static final Logger  logger = LoggerFactory.getLogger(CervejaController.class);
	
	@Autowired 
	CadastroCervejaService cadastroCervejaService;

	@Autowired
	private Cervejas cervejas;
	
	@Autowired 
	private Estilos estilos;
	
	@RequestMapping("/novo")
	private ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@PostMapping("/novo")
	private ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
		return novo(cerveja);
		}
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "cerveja salva com sucesso!");
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result, @PageableDefault(size = 2) Pageable pageable) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		mv.addObject("cervejas", cervejas.filtrar(cervejaFilter, pageable));
		return mv;
	}
	
}
