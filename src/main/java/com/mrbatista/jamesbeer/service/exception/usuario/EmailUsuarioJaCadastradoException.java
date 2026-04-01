package com.mrbatista.jamesbeer.service.exception.usuario;

import com.mrbatista.jamesbeer.service.exception.RegistroJaCadastradoException;

public class EmailUsuarioJaCadastradoException extends RegistroJaCadastradoException {
	
	private static final long serialVersionUID = 1L;
	
	public EmailUsuarioJaCadastradoException(String message) {
		super(message);
	}

}
