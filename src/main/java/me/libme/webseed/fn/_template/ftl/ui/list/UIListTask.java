package me.libme.webseed.fn._template.ftl.ui.list;

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
public class UIListTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {

		InternalConfig.ModelConfig modelConfig=getModelConfig();
		ModelModel modelModel=modelConfig.modelModel();
		
		UIListModel uiListModel=new UIListModel();
		uiListModel.setUiContext(modelConfig.uiTemplateUIContext());
		uiListModel.setFilePath(uiListModel.getUiContext().getListFilePath());
		uiListModel.setFileName(uiListModel.getUiContext().getListFileName());
		uiListModel.setCheckbox(true);
		UIListCriterialFieldParser listCriterialFieldParser=new UIDefaultListCriterialFieldParser();
		uiListModel.setCriteriaFields(listCriterialFieldParser.parse(modelConfig));

		UIListTableFieldParser tableFieldParser=new UIDefaultListTableFieldParser();
		uiListModel.setTableFields(tableFieldParser.parse(modelConfig));

		/* Create a data-model */
        Map<String,Object> root = new HashMap<String, Object>();
        root.put("modelModel", modelModel);
        root.put("modelRecordModel", modelConfig.modelRecordModel());
        root.put("criteriaModel", modelConfig.criteriaModel());
        root.put("serviceModel", modelConfig.serviceModel());
        root.put("controllerModel", modelConfig.controllerModel());
        root.put("uiListModel", uiListModel);
        
        /* Get the template (uses cache internally) */
        Template temp = FtlConfig.get().getCfg().getTemplate("ui/list/ui-model-list.ftl");
        /* Merge data-model with template */
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(byteArrayOutputStream);
        temp.process(root, out);
        FileWrapper fileWrapper=new FileWrapper();
        fileWrapper.setFile(new File(uiListModel.getUiContext().getUiRelativePath()
        		+uiListModel.getFilePath()));
        fileWrapper.setData(byteArrayOutputStream.toByteArray());
        getInternalConfig().addFile(fileWrapper);
	
        return true;
        
	}

}
