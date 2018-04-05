package me.libme.webseed.fn._template.ftl.java.criteria;


import me.libme.webseed.fn._template.ftl.java.BaseTemplateModel;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;

import java.util.List;

public class CriteriaModel extends BaseTemplateModel {
	
	private List<ModelField> modelFields;

	public List<ModelField> getModelFields() {
		return modelFields;
	}

	public void setModelFields(List<ModelField> modelFields) {
		this.modelFields = modelFields;
	}
	
}
