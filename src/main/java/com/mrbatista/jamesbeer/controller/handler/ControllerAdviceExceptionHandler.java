package com.mrbatista.jamesbeer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mrbatista.jamesbeer.service.exception.RegistroJaCadastradoException;
import com.mrbatista.jamesbeer.service.exception.estilo.NomeEstiloJaCadastradoException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(RegistroJaCadastradoException.class)
	public ResponseEntity<String> handleRegistroJaCadastradoException(RegistroJaCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
