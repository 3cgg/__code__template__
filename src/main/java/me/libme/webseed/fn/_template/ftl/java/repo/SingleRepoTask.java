package me.libme.webseed.fn._template.ftl.java.repo;

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
public class SingleRepoTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {

		InternalConfig.ModelConfig modelConfig=getModelConfig();

		ModelModel modelModel=modelConfig.modelModel();

		SingleRepoModel singleRepoModel=new SingleRepoModel();
		singleRepoModel.setClassPackage(modelConfig.internalConfig().repoPackage());
		singleRepoModel.setSimpleClassName(modelModel.getSimpleClassName()+"Repo");
		singleRepoModel.setClassName(singleRepoModel.getClassPackage()+"."
				+singleRepoModel.getSimpleClassName());

		modelConfig.setSingleRepoModel(singleRepoModel);

			/* Create a data-model */
		Map<String,Object> root = new HashMap<>();
		root.put("modelModel", modelModel);
		root.put("modelRecordModel", modelConfig.modelRecordModel());
		root.put("criteriaModel", modelConfig.criteriaModel());
		root.put("singleRepoModel", singleRepoModel);

		root.put("classPackage", singleRepoModel.getClassPackage());
		root.put("className", singleRepoModel.getClassName());
		root.put("simpleClassName", singleRepoModel.getSimpleClassName());
		root.put("variableName", singleRepoModel.getVariableName());


        /* Get the template (uses cache internally) */
		Template temp = FtlConfig.get().getCfg().getTemplate("java/repo/single-repo.ftl");
        /* Merge data-model with template */
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(byteArrayOutputStream);
		temp.process(root, out);
		String javaFileName=getInternalConfig().javaRelativePath()+"/"
				+singleRepoModel.getClassName().replace('.', '/')+".java";
		FileWrapper fileWrapper=new FileWrapper();
		fileWrapper.setFile(new File(javaFileName));
		fileWrapper.setData(byteArrayOutputStream.toByteArray());
		getInternalConfig().addFile(fileWrapper);

		return true;
        
	}

}
