package me.libme.webseed.fn._template.ftl.ui.view;

import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.ui.UITemplateFieldParser;

import java.util.List;

public interface UIViewFieldParser extends UITemplateFieldParser {

	List<UIViewField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
