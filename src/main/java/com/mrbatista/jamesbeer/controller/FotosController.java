package com.mrbatista.jamesbeer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.mrbatista.jamesbeer.dto.FotoDTO;
import com.mrbatista.jamesbeer.storage.FotosStorageRunnable;

@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		
		Thread thread = new Thread(new FotosStorageRunnable(files, resultado));
		thread.start();
		
		return resultado;
	}

}
