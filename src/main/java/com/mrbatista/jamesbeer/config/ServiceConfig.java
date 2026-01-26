package com.mrbatista.jamesbeer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mrbatista.jamesbeer.repository.Estilos;
import com.mrbatista.jamesbeer.service.CadastroCervejaService;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, Estilos.class})
public class ServiceConfig {

}
