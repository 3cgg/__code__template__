package me.libme.webseed.fn._template.ftl.ui.edit;

import freemarker.template.Template;
import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.webseed.fn._template.ftl.FileWrapper;
import me.libme.webseed.fn._template.ftl.FtlConfig;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;
import me.libme.webseed.fn._template.ftl.ui.UIHiddenFieldParser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@MetadataHierarchyOnTask
@MetadataOnTask
public class UIEditTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {

		InternalConfig.ModelConfig modelConfig=getModelConfig();
		ModelModel modelModel=modelConfig.modelModel();
		
		UIEditModel uiEditModel=new UIEditModel();
		uiEditModel.setUiContext(modelConfig.uiTemplateUIContext());
		uiEditModel.setFilePath(uiEditModel.getUiContext().getEditFilePath());
		uiEditModel.setFileName(uiEditModel.getUiContext().getEditFileName());
		
		UIEditFieldParser editFieldParser=new UIDefaultEditFieldParser();
		uiEditModel.setEditFields(editFieldParser.parse(modelConfig));

		UIHiddenFieldParser hiddenFieldParser=new UIDefaultEditHidenFieldParser();
		uiEditModel.setHiddenFields(hiddenFieldParser.parse(modelConfig));
		
		/* Create a data-model */
        Map<String,Object> root = new HashMap<String, Object>();
        root.put("modelModel", modelModel);
        root.put("modelRecordModel", modelConfig.modelRecordModel());
        root.put("criteriaModel", modelConfig.criteriaModel());
        root.put("serviceModel", modelConfig.serviceModel());
        root.put("controllerModel", modelConfig.controllerModel());
        root.put("uiEditModel", uiEditModel);
        
        /* Get the template (uses cache internally) */
        Template temp = FtlConfig.get().getCfg().getTemplate("ui/edit/ui-model-edit.ftl");
        /* Merge data-model with template */
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(byteArrayOutputStream);
        temp.process(root, out);
        FileWrapper fileWrapper=new FileWrapper();
        fileWrapper.setFile(new File(uiEditModel.getUiContext().getUiRelativePath()
        		+uiEditModel.getFilePath()));
        fileWrapper.setData(byteArrayOutputStream.toByteArray());
        getInternalConfig().addFile(fileWrapper);
	
        return true;
        
	}

}
