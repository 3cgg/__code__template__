package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.webseed.fn._template.ftl.java.BaseTemplateModel;

import java.util.List;

public class ModelModel extends BaseTemplateModel {

	private String tableName;
	
	private List<ModelField> modelFields;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<ModelField> getModelFields() {
		return modelFields;
	}

	public void setModelFields(List<ModelField> modelFields) {
		this.modelFields = modelFields;
	}
	
	
}
