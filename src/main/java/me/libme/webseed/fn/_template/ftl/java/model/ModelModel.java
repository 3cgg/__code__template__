package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.webseed.fn._template.ftl.java.BaseTemplateModel;

import java.util.List;

public class ModelModel extends BaseTemplateModel {
	
	private List<ModelField> modelFields;

	public List<ModelField> getModelFields() {
		return modelFields;
	}

	public void setModelFields(List<ModelField> modelFields) {
		this.modelFields = modelFields;
	}
	
	
}
