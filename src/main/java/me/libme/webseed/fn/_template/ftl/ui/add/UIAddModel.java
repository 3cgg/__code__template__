package me.libme.webseed.fn._template.ftl.ui.add;

import me.libme.webseed.fn._template.ftl.ui.UITemplateUIModel;

import java.util.List;


public class UIAddModel extends UITemplateUIModel {
	
	private List<UIAddField> addFields;

	public List<UIAddField> getAddFields() {
		return addFields;
	}

	public void setAddFields(List<UIAddField> addFields) {
		this.addFields = addFields;
	}

}
