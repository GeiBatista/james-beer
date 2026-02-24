package com.mrbatista.jamesbeer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotosStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<String> resultado;
	
	public FotosStorageRunnable(MultipartFile[] files, DeferredResult<String> resultado) {
		this.files = files;
		this.resultado = resultado;
	}
	
	@Override
	public void run() {
		System.out.println("Quantidade de fotos recebidas: " + files[0].getSize());
		// TODO Auto-generated method stub
		resultado.setResult("Upload finalizado");

	}

}
