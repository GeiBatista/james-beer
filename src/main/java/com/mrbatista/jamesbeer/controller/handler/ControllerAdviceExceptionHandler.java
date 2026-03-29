package com.mrbatista.jamesbeer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mrbatista.jamesbeer.service.exception.estilo.NomeEstiloJaCadastradoException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(NomeEstiloJaCadastradoException .class)
	public ResponseEntity<String> handleRegistroJaCadastradoException(NomeEstiloJaCadastradoException  e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
