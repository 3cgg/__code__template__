package me.libme.webseed.fn._template.ftl.java.controller;


import me.libme.webseed.fn._template.ftl.java.BaseTemplateModel;

public class ControllerModel extends BaseTemplateModel {

	private String controllerBaseMapping;
	
	private String pageMethodName;
	
	private String saveMethodName;
	
	private String updateMethodName;
	
	private String deleteMethodName;
	
	private String deleteByIdMethodName;
	
	private String getMethodName;
	
	public String getControllerBaseMapping() {
		return controllerBaseMapping;
	}

	public void setControllerBaseMapping(String controllerBaseMapping) {
		this.controllerBaseMapping = controllerBaseMapping;
	}

	public String getPageMethodName() {
		return pageMethodName;
	}

	public void setPageMethodName(String pageMethodName) {
		this.pageMethodName = pageMethodName;
	}

	public String getSaveMethodName() {
		return saveMethodName;
	}

	public void setSaveMethodName(String saveMethodName) {
		this.saveMethodName = saveMethodName;
	}

	public String getUpdateMethodName() {
		return updateMethodName;
	}

	public void setUpdateMethodName(String updateMethodName) {
		this.updateMethodName = updateMethodName;
	}

	public String getDeleteMethodName() {
		return deleteMethodName;
	}

	public void setDeleteMethodName(String deleteMethodName) {
		this.deleteMethodName = deleteMethodName;
	}

	public String getGetMethodName() {
		return getMethodName;
	}

	public void setGetMethodName(String getMethodName) {
		this.getMethodName = getMethodName;
	}

	public String getDeleteByIdMethodName() {
		return deleteByIdMethodName;
	}

	public void setDeleteByIdMethodName(String deleteByIdMethodName) {
		this.deleteByIdMethodName = deleteByIdMethodName;
	}
	

}
