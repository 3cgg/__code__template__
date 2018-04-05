package me.libme.webseed.fn._template.ftl.ui;

import me.libme.kernel._c._m.JModel;
import me.libme.kernel._c.util.JStringUtils;


public class UITemplateUIContext implements JModel {
	
	private String listFileName;
	
	private String listFilePath;
	
	private String addFileName;
	
	private String addFilePath;
	
	private String editFileName;
	
	private String editFilePath;
	
	private String viewFileName;
	
	private String viewFilePath;
	
	private String moduleName;
	
	private String uiRelativePath;
	
	private String uiRelativeMvcPath;
	
	private String pageMethodUrl;
	
	private String saveMethodUrl;
	
	private String updateMethodUrl;
	
	private String deleteMethodUrl;
	
	private String deleteByIdMethodUrl;
	
	private String getMethodUrl;

	public String getListFileName() {
		return listFileName;
	}

	public void setListFileName(String listFileName) {
		this.listFileName = listFileName;
	}

	public String getAddFileName() {
		return addFileName;
	}

	public void setAddFileName(String addFileName) {
		this.addFileName = addFileName;
	}

	public String getEditFileName() {
		return editFileName;
	}

	public void setEditFileName(String editFileName) {
		this.editFileName = editFileName;
	}

	public String getViewFileName() {
		return viewFileName;
	}

	public void setViewFileName(String viewFileName) {
		this.viewFileName = viewFileName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getUiRelativePath() {
		return uiRelativePath;
	}

	public void setUiRelativePath(String uiRelativePath) {
		this.uiRelativePath = uiRelativePath;
	}

	public String getListFilePath() {
		if(JStringUtils.isNotNullOrEmpty(listFilePath)){
			listFilePath=uiRelativeMvcPath+"/"+moduleName+"/"+listFileName;
		}
		return listFilePath;
	}

	public void setListFilePath(String listFilePath) {
		this.listFilePath = listFilePath;
	}

	public String getAddFilePath() {
		if(JStringUtils.isNotNullOrEmpty(addFilePath)){
			addFilePath=uiRelativeMvcPath+"/"+moduleName+"/"+addFileName;
		}
		return addFilePath;
	}

	public void setAddFilePath(String addFilePath) {
		this.addFilePath = addFilePath;
	}

	public String getEditFilePath() {
		if(JStringUtils.isNotNullOrEmpty(editFilePath)){
			editFilePath=uiRelativeMvcPath+"/"+moduleName+"/"+editFileName;
		}
		return editFilePath;
	}

	public void setEditFilePath(String editFilePath) {
		this.editFilePath = editFilePath;
	}

	public String getViewFilePath() {
		if(JStringUtils.isNotNullOrEmpty(viewFilePath)){
			viewFilePath=uiRelativeMvcPath+"/"+moduleName+"/"+viewFileName;
		}
		return viewFilePath;
	}

	public void setViewFilePath(String viewFilePath) {
		this.viewFilePath = viewFilePath;
	}

	public String getPageMethodUrl() {
		return pageMethodUrl;
	}

	public void setPageMethodUrl(String pageMethodUrl) {
		this.pageMethodUrl = pageMethodUrl;
	}

	public String getSaveMethodUrl() {
		return saveMethodUrl;
	}

	public void setSaveMethodUrl(String saveMethodUrl) {
		this.saveMethodUrl = saveMethodUrl;
	}

	public String getUpdateMethodUrl() {
		return updateMethodUrl;
	}

	public void setUpdateMethodUrl(String updateMethodUrl) {
		this.updateMethodUrl = updateMethodUrl;
	}

	public String getDeleteMethodUrl() {
		return deleteMethodUrl;
	}

	public void setDeleteMethodUrl(String deleteMethodUrl) {
		this.deleteMethodUrl = deleteMethodUrl;
	}

	public String getDeleteByIdMethodUrl() {
		return deleteByIdMethodUrl;
	}

	public void setDeleteByIdMethodUrl(String deleteByIdMethodUrl) {
		this.deleteByIdMethodUrl = deleteByIdMethodUrl;
	}

	public String getGetMethodUrl() {
		return getMethodUrl;
	}

	public void setGetMethodUrl(String getMethodUrl) {
		this.getMethodUrl = getMethodUrl;
	}

	public String getUiRelativeMvcPath() {
		return uiRelativeMvcPath;
	}

	public void setUiRelativeMvcPath(String uiRelativeMvcPath) {
		this.uiRelativeMvcPath = uiRelativeMvcPath;
	}

}
