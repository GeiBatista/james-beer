package com.mrbatista.jamesbeer.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.mrbatista.jamesbeer.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.mrbatista.jamesbeer.thymeleaf.processor.MenuAttibuteTagProcessor;
import com.mrbatista.jamesbeer.thymeleaf.processor.MessageElementTagProcessor;
import com.mrbatista.jamesbeer.thymeleaf.processor.OrderElementTagProcessor;

public class JamesBeerDialect extends AbstractProcessorDialect {

	public JamesBeerDialect() {
		super("James Beer", "jamesbeer", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttibuteTagProcessor(dialectPrefix));
		
		return processadores;
	}

}
