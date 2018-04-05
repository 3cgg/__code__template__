package me.libme.webseed.fn._template.ftl.ui;

import me.libme.kernel._c._m.JModel;

import java.util.List;

public class UITemplateUIModel implements JModel {
	
	private String filePath;
	
	private String fileName;
	
	private UITemplateUIContext uiContext;
	
	private List<UIField> hiddenFields;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public UITemplateUIContext getUiContext() {
		return uiContext;
	}

	public void setUiContext(UITemplateUIContext uiContext) {
		this.uiContext = uiContext;
	}

	public List<UIField> getHiddenFields() {
		return hiddenFields;
	}

	public void setHiddenFields(List<UIField> hiddenFields) {
		this.hiddenFields = hiddenFields;
	}
	
}
