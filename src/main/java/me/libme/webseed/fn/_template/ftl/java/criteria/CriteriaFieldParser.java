package me.libme.webseed.fn._template.ftl.java.criteria;


import me.libme.kernel._c._i.JParser;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;

import java.util.List;

public interface CriteriaFieldParser extends JParser {

	List<ModelField> parse(InternalConfig.ModelConfig modelConfig) throws Exception;
	
}
