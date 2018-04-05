package me.libme.webseed.fn._template.ftl.ui.edit;

import me.libme.webseed.fn._template.ftl.ui.UITemplateUIModel;

import java.util.List;

public class UIEditModel extends UITemplateUIModel {
	
	private List<UIEditField> editFields;

	public List<UIEditField> getEditFields() {
		return editFields;
	}

	public void setEditFields(List<UIEditField> editFields) {
		this.editFields = editFields;
	}

	
	

}
