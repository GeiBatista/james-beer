package com.mrbatista.jamesbeer.service.exception.cliente;

import com.mrbatista.jamesbeer.service.exception.RegistroJaCadastradoException;

public class CpfCnpjClienteJaCadastradoException extends RegistroJaCadastradoException {
	private static final long serialVersionUID = 1L;
	
	public CpfCnpjClienteJaCadastradoException(String message){
		super(message);
	}

}
