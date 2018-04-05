package me.libme.webseed.fn._template.ftl.ui;

import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.KeyNames;

import static me.libme.webseed.fn._template.ftl.InternalConfig.ModelConfig;
import static me.libme.webseed.fn._template.ftl.ui.UIFieldSpec.UIHiddenFieldSpec;

public class FieldSpecSetter {
	
	private boolean isDesc(String property,InternalConfig.ModelConfig modelConfig){
		return property.endsWith("Desc")
				||property.endsWith("Description")
				||property.endsWith("description");
	}

	public void setFieldSpec(UIField uiField, ModelConfig modelConfig) {
		
		if(uiField.isHidden()){
			UIHiddenFieldSpec hiddenFieldSpec=new UIHiddenFieldSpec();
			hiddenFieldSpec.setFieldType(KeyNames.FIELD_SPEC_HIDDEN);
			uiField.setFieldSpec(hiddenFieldSpec);
			return ;
		}
		
		if(KeyNames.FIELD_TYPE_NUMERIC.equals(uiField.getFieldType())){
			UIFieldSpec.UITextFieldSpec textFieldSpec=new UIFieldSpec.UITextFieldSpec();
			textFieldSpec.setFieldType(KeyNames.FIELD_SPEC_TEXT);
			uiField.setFieldSpec(textFieldSpec);
		}else if(KeyNames.FIELD_TYPE_DATE.equals(uiField.getFieldType())){
			UIFieldSpec.UIDateFieldSpec dateFieldSpec=new UIFieldSpec.UIDateFieldSpec();
			dateFieldSpec.setFieldType(KeyNames.FIELD_SPEC_DATE);
			uiField.setFieldSpec(dateFieldSpec);
		}else if(KeyNames.FIELD_TYPE_STRING.equals(uiField.getFieldType())){
			if(isDesc(uiField.getProperty(), modelConfig)){
				UIFieldSpec.UITextareaFieldSpec textareaFieldSpec=new UIFieldSpec.UITextareaFieldSpec();
				textareaFieldSpec.setFieldType(KeyNames.FIELD_SPEC_TEXTAREA);
				textareaFieldSpec.setMaxLength(2000);
				textareaFieldSpec.setRequired("false");
				uiField.setFieldSpec(textareaFieldSpec);
			}else {
				UIFieldSpec.UITextFieldSpec textFieldSpec=new UIFieldSpec.UITextFieldSpec();
				textFieldSpec.setFieldType(KeyNames.FIELD_SPEC_TEXT);
				uiField.setFieldSpec(textFieldSpec);
			}
		}
	}
	
}
