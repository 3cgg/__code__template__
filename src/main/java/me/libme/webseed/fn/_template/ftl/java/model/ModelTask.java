package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;

@MetadataHierarchyOnTask
@MetadataOnTask
public class ModelTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {
		
		InternalConfig.ModelConfig modelConfig=getModelConfig();
		
		ModelModel modelModel=new ModelModel();
	
		modelModel.setSimpleClassName(modelConfig.modelName());
		modelModel.setClassPackage(modelConfig.internalConfig().modelPackage());
		modelModel.setClassName(modelModel.getClassPackage()+"."
		+modelModel.getSimpleClassName());
		modelConfig.setModelModel(modelModel);

		ModelInfoEnhancer modelInfoEnhancer=
				getConfig().getModelInfoEnhancerClass().newInstance();
		modelInfoEnhancer.enhance(modelConfig,modelModel);

        return true;
        
	}

}
