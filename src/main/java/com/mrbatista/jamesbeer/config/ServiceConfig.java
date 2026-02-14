package com.mrbatista.jamesbeer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mrbatista.jamesbeer.repository.Estilos;
import com.mrbatista.jamesbeer.service.CadastroCervejaService;
import com.mrbatista.jamesbeer.service.CadastroEstiloService;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, CadastroEstiloService.class})
public class ServiceConfig {

}
