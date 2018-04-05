package me.libme.webseed.fn._template.ftl.ui.list;

import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.ui.UITemplateFieldParser;

import java.util.List;

public interface UIListCriterialFieldParser extends UITemplateFieldParser {

	List<UIListCriteriaField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
