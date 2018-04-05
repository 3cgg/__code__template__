package me.libme.webseed.fn._template.ftl.java.service;

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
public class ServiceTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {

		InternalConfig.ModelConfig modelConfig=getModelConfig();

		ModelModel modelModel=modelConfig.modelModel();

		ServiceModel serviceModel=new ServiceModel();
		serviceModel.setClassPackage(modelConfig.internalConfig().servicePackage());
		serviceModel.setSimpleClassName(getConfig().getModuleName()+"Service");
		serviceModel.setClassName(serviceModel.getClassPackage()+"."
				+serviceModel.getSimpleClassName());
		serviceModel.setSaveMethodName(modelConfig.saveMethodName());
		serviceModel.setDeleteMethodName(modelConfig.deleteMethodName());
		serviceModel.setDeleteByIdMethodName(modelConfig.deleteByIdMethodName());
		serviceModel.setUpdateMethodName(modelConfig.updateMethodName());
		serviceModel.setGetMethodName(modelConfig.getMethodName());
		serviceModel.setPageMethodName(modelConfig.pageMethodName());

		modelConfig.setServiceModel(serviceModel);

			/* Create a data-model */
		Map<String,Object> root = new HashMap<String, Object>();
		root.put("modelModel", modelModel);
		root.put("modelRecordModel", modelConfig.modelRecordModel());
		root.put("criteriaModel", modelConfig.criteriaModel());
		root.put("singleRepoModel", modelConfig.singleRepoModel());
		root.put("dataAccessRepoModel", modelConfig.dataAccessRepoModel());

		root.put("serviceModel", serviceModel);

        root.put("classPackage", serviceModel.getClassPackage());
        root.put("className", serviceModel.getClassName());
        root.put("simpleClassName", serviceModel.getSimpleClassName());
        root.put("variableName", serviceModel.getVariableName());

        
        /* Get the template (uses cache internally) */
        Template temp = FtlConfig.get().getCfg().getTemplate("java/service/service.ftl");
        /* Merge data-model with template */
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(byteArrayOutputStream);
        temp.process(root, out);
        String javaFileName=getInternalConfig().javaRelativePath()+"/"
        +serviceModel.getClassName().replace('.', '/')+".java";
        FileWrapper fileWrapper=new FileWrapper();
        fileWrapper.setFile(new File(javaFileName));
        fileWrapper.setData(byteArrayOutputStream.toByteArray());
        getInternalConfig().addFile(fileWrapper);
	
        return true;
        
	}

}
