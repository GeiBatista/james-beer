package com.mrbatista.jamesbeer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mrbatista.jamesbeer.service.CadastroCervejaService;
import com.mrbatista.jamesbeer.service.CadastroCidadeService;
import com.mrbatista.jamesbeer.service.CadastroEstiloService;
import com.mrbatista.jamesbeer.storage.FotoStorage;
import com.mrbatista.jamesbeer.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}
