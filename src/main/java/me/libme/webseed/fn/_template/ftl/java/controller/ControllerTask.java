package me.libme.webseed.fn._template.ftl.java.controller;


import freemarker.template.Template;
import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.webseed.fn._template.ftl.FileWrapper;
import me.libme.webseed.fn._template.ftl.FtlConfig;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


@MetadataHierarchyOnTask
@MetadataOnTask
public class ControllerTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {

		InternalConfig.ModelConfig modelConfig=getModelConfig();
		ModelModel modelModel=modelConfig.modelModel();

		ControllerModel controllerModel=new ControllerModel();
		controllerModel.setClassPackage(modelConfig.internalConfig().controllerPackage());
		controllerModel.setSimpleClassName(getConfig().getModuleName()+"Controller");
		controllerModel.setClassName(controllerModel.getClassPackage()+"."
				+controllerModel.getSimpleClassName());
		controllerModel.setControllerBaseMapping(modelConfig.internalConfig().controllerBaseMapping());
		controllerModel.setSaveMethodName(modelConfig.saveMethodName());
		controllerModel.setDeleteMethodName(modelConfig.deleteMethodName());
		controllerModel.setDeleteByIdMethodName(modelConfig.deleteByIdMethodName());
		controllerModel.setUpdateMethodName(modelConfig.updateMethodName());
		controllerModel.setGetMethodName(modelConfig.getMethodName());
		controllerModel.setPageMethodName(modelConfig.pageMethodName());

		modelConfig.setControllerModel(controllerModel);
			
			/* Create a data-model */
		Map<String,Object> root = new HashMap<String, Object>();
		root.put("modelModel", modelModel);
		root.put("modelRecordModel", modelConfig.modelRecordModel());
		root.put("criteriaModel", modelConfig.criteriaModel());
		root.put("singleRepoModel", modelConfig.singleRepoModel());
		root.put("dataAccessRepoModel", modelConfig.dataAccessRepoModel());
		root.put("serviceModel", modelConfig.serviceModel());

		root.put("controllerModel", controllerModel);

        root.put("classPackage", controllerModel.getClassPackage());
        root.put("className", controllerModel.getClassName());
        root.put("simpleClassName", controllerModel.getSimpleClassName());
        root.put("variableName", controllerModel.getVariableName());
        root.put("controllerBaseMapping", controllerModel.getControllerBaseMapping());
        
        
        /* Get the template (uses cache internally) */
        Template temp = FtlConfig.get().getCfg().getTemplate("java/controller/controller.ftl");
        /* Merge data-model with template */
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(byteArrayOutputStream);
        temp.process(root, out);
        String javaFileName=getInternalConfig().javaRelativePath()+"/"
        +controllerModel.getClassName().replace('.', '/')+".java";
        FileWrapper fileWrapper=new FileWrapper();
        fileWrapper.setFile(new File(javaFileName));
        fileWrapper.setData(byteArrayOutputStream.toByteArray());
        getInternalConfig().addFile(fileWrapper);
	
        return true;
        
	}

}
