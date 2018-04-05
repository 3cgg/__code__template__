package me.libme.webseed.fn._template.ftl.ui.add;

import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.ui.UITemplateFieldParser;

import java.util.List;

public interface UIAddFieldParser extends UITemplateFieldParser {

	List<UIAddField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
