package com.mrbatista.jamesbeer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.repository.Cervejas;
import com.mrbatista.jamesbeer.service.event.cerveja.CervejaSalvaEvent;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
		
		publisher.publishEvent(new CervejaSalvaEvent(cerveja));
	}

}
