package com.mrbatista.jamesbeer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrbatista.jamesbeer.model.Usuario;
import com.mrbatista.jamesbeer.repository.Grupos;
import com.mrbatista.jamesbeer.repository.Usuarios;
import com.mrbatista.jamesbeer.repository.filter.UsuarioFilter;
import com.mrbatista.jamesbeer.service.CadastroUsuarioService;
import com.mrbatista.jamesbeer.service.exception.SenhaObrigatoriaUsuarioException;
import com.mrbatista.jamesbeer.service.exception.usuario.EmailUsuarioJaCadastradoException;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private Grupos grupos;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	private ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}
	
	@PostMapping("/novo")
	private ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result,  RedirectAttributes attributes) {
		if(result.hasErrors()) {
		return novo(usuario);
		}
		
		try {
			cadastroUsuarioService.salvar(usuario);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(usuario);
		}catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
		} 
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/usuarios/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter) {
		ModelAndView mv = new ModelAndView("/usuario/PesquisaUsuarios");
		mv.addObject("usuarios", usuarios.filtrar(usuarioFilter));
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}

}
