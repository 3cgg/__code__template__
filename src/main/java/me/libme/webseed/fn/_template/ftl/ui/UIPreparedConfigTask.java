
package me.libme.webseed.fn._template.ftl.ui;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;
import me.libme.webseed.fn._template.ftl.java.controller.ControllerModel;

@MetadataHierarchyOnTask
@MetadataOnTask
public class UIPreparedConfigTask extends TemplateTask {

	@Override
	protected Object doRun() throws Exception {
		
		InternalConfig.ModelConfig modelConfig=getModelConfig();
		UITemplateUIContext uiTemplateUIContext=new UITemplateUIContext();
		
		uiTemplateUIContext.setModuleName(getConfig().getModuleName().toLowerCase());
		uiTemplateUIContext.setUiRelativePath(getConfig().getUiRelativePath());
		
		uiTemplateUIContext.setUiRelativeMvcPath(getConfig().getUiRelativeMvcPath());
		String modelFileName=modelConfig.modelModel().getSimpleClassName().toLowerCase();
		uiTemplateUIContext.setListFileName(modelFileName+"-list.html");
		uiTemplateUIContext.setListFilePath(uiTemplateUIContext.getUiRelativeMvcPath()
				+"/"+uiTemplateUIContext.getModuleName()
				+"/"+uiTemplateUIContext.getListFileName());
		
		uiTemplateUIContext.setAddFileName(modelFileName+"-add.html");
		uiTemplateUIContext.setAddFilePath(uiTemplateUIContext.getUiRelativeMvcPath()
				+"/"+uiTemplateUIContext.getModuleName()
				+"/"+uiTemplateUIContext.getAddFileName());
		
		uiTemplateUIContext.setEditFileName(modelFileName+"-edit.html");
		uiTemplateUIContext.setEditFilePath(uiTemplateUIContext.getUiRelativeMvcPath()
				+"/"+uiTemplateUIContext.getModuleName()
				+"/"+uiTemplateUIContext.getEditFileName());
		
		uiTemplateUIContext.setViewFileName(modelFileName+"-view.html");
		uiTemplateUIContext.setViewFilePath(uiTemplateUIContext.getUiRelativeMvcPath()
				+"/"+uiTemplateUIContext.getModuleName()
				+"/"+uiTemplateUIContext.getViewFileName());
		
		ControllerModel controllerModel=modelConfig.controllerModel();
		uiTemplateUIContext.setGetMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getGetMethodName());
		uiTemplateUIContext.setPageMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getPageMethodName());
		uiTemplateUIContext.setDeleteByIdMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getDeleteByIdMethodName());
		uiTemplateUIContext.setDeleteMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getDeleteMethodName());
		
		uiTemplateUIContext.setSaveMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getSaveMethodName());
		uiTemplateUIContext.setUpdateMethodUrl(controllerModel.getControllerBaseMapping()
				+"/"+controllerModel.getUpdateMethodName());
		
		
		
		modelConfig.setUITemplateUIContext(uiTemplateUIContext);
		
		return true;
	}

}
