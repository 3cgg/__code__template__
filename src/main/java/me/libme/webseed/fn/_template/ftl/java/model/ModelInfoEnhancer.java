package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.webseed.fn._template.ftl.InternalConfig;

public interface ModelInfoEnhancer {

	ModelModel enhance(InternalConfig.ModelConfig modelConfig,ModelModel modelModel) throws Exception;
	
}
