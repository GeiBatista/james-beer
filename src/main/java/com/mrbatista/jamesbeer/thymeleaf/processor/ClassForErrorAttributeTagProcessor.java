package com.mrbatista.jamesbeer.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.util.FieldUtils;
import org.thymeleaf.templatemode.TemplateMode;

public class ClassForErrorAttributeTagProcessor extends AbstractAttributeTagProcessor {

	private static final String ATTR_NAME = "classforerror";
	private static final int PRECEDENCE = 1000;

	public ClassForErrorAttributeTagProcessor(final String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
			String attributeValue, IElementTagStructureHandler structureHandler) {
		
		boolean temErro = FieldUtils.hasErrors(context, attributeValue);
		
		if (temErro) {
			String classesExistentes = tag.getAttributeValue("class");
			if (classesExistentes == null) {
				classesExistentes = "error";
			} else {
				classesExistentes += " error";
			}
			structureHandler.setAttribute("class", classesExistentes + " has-error");
		}
		
	}

}
