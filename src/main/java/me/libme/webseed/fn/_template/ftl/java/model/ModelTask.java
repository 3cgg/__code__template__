package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.kernel._c.util.JClassUtils;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;

import java.util.List;

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
		
		ModelFieldParser modelFieldParser=(ModelFieldParser)
				getConfig().getModelFieldParserClass().newInstance();
		List<ModelField> modelFields= modelFieldParser.parse(JClassUtils.load(modelModel.getClassName()));
		modelModel.setModelFields(modelFields);

        return true;
        
	}

}
