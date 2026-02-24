package com.mrbatista.jamesbeer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.mrbatista.jamesbeer.dto.FotoDTO;

public class FotosStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;
	
	public FotosStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.resultado = resultado;
	}
	
	@Override
	public void run() {
		System.out.println("Quantidade de fotos recebidas: " + files[0].getSize());
		// TODO Auto-generated method stub
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		resultado.setResult(new FotoDTO(nomeFoto, contentType));

	}

}
