package me.libme.webseed.fn._template.ftl.ui.view;

import me.libme.webseed.fn._template.ftl.ui.UITemplateUIModel;

import java.util.List;


public class UIViewModel extends UITemplateUIModel {
	
	private List<UIViewField> viewFields;

	public List<UIViewField> getViewFields() {
		return viewFields;
	}

	public void setViewFields(List<UIViewField> viewFields) {
		this.viewFields = viewFields;
	}


}
