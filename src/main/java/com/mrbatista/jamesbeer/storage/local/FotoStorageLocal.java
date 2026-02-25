package com.mrbatista.jamesbeer.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.mrbatista.jamesbeer.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {
	
	private static final Logger logger = LoggerFactory.getLogger(FotoStorageLocal.class);

	private Path local;
	private Path localTemporario;
	
	public FotoStorageLocal() {
		this.local = getDefault().getPath(System.getProperty("user.home"), ".jamesbeerfotos");
	}
	
	public FotoStorageLocal(Path path) {
		this.local = path;
		
		criarPastas();
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);
			
			if (logger.isDebugEnabled()) {
				logger.debug("Pasta para salvar as fotos criada com sucesso!");
				logger.debug("Pasta default: " + this.local.toAbsolutePath());
				logger.debug("Pasta temporária: " + this.localTemporario.toAbsolutePath());
			}
		} catch (IOException e) {
			throw new RuntimeException("Problemas criando pasta para salvar as fotos", e);
		}
		
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] files) {
		System.out.println("Salvando as fotos temporariamente em " + this.localTemporario.toAbsolutePath());
		
	}
}
