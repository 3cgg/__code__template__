package me.libme.webseed.fn._template.ftl.ui;

import me.libme.webseed.fn._template.ftl.InternalConfig;

import java.util.List;

public interface UIHiddenFieldParser extends UITemplateFieldParser {

	List<UIField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
