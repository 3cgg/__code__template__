package me.libme.webseed.fn._template.ftl.java.criteria;


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
public class CriteriaTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {
		
		InternalConfig.ModelConfig modelConfig=getModelConfig();
		
		ModelModel modelModel=modelConfig.modelModel();
		
		CriteriaModel criteriaModel=new CriteriaModel();
		criteriaModel.setClassPackage(modelConfig.internalConfig().voPackage());
		criteriaModel.setSimpleClassName(modelModel.getSimpleClassName()+"Criteria");
		criteriaModel.setClassName(criteriaModel.getClassPackage()+"."
		+criteriaModel.getSimpleClassName());
		CriteriaFieldParser criteriaFieldParser=new CriteriaDefaultFieldParser();
		criteriaModel.setModelFields(criteriaFieldParser.parse(modelConfig));
		
		modelConfig.setCriteriaModel(criteriaModel);
		
		/* Create a data-model */
        Map<String,Object> root = new HashMap<String, Object>();
        root.put("modelModel", modelModel);
        root.put("criteriaModel", criteriaModel);
        
        /* Get the template (uses cache internally) */
        Template temp = FtlConfig.get().getCfg().getTemplate("java/criteria/criteria.ftl");
        /* Merge data-model with template */
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(byteArrayOutputStream);
        temp.process(root, out);
        String javaFileName=getInternalConfig().javaRelativePath()+"/"
        +criteriaModel.getClassName().replace('.', '/')+".java";
        FileWrapper fileWrapper=new FileWrapper();
        fileWrapper.setFile(new File(javaFileName));
        fileWrapper.setData(byteArrayOutputStream.toByteArray());
        getInternalConfig().addFile(fileWrapper);
        
        return true;
	}

}
