package me.libme.webseed.fn._template.ftl.ui.edit;

import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.ui.UITemplateFieldParser;

import java.util.List;

public interface UIEditFieldParser extends UITemplateFieldParser {

	List<UIEditField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
