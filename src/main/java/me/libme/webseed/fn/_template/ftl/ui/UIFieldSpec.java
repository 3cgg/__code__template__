package me.libme.webseed.fn._template.ftl.ui;

import me.libme.kernel._c._m.JModel;

public class UIFieldSpec implements JModel {

	/**
	 * {@link KeyNames#FIELD_SPEC_DATE} or {@link KeyNames#FIELD_SPEC_DATETIME} or 
	 * {@link KeyNames#FIELD_SPEC_TEXTAREA} or {@link KeyNames#FIELD_SPEC_SELECT}  ...   ;
	 */
	private String fieldType;
	
	private String required="true";
	
	private int maxLength=64;
	
	public static class UITextFieldSpec extends UIFieldSpec{
		
		
	}
	
	public static class UIHiddenFieldSpec extends UIFieldSpec{
		
		
	}
	
	public static class UISelectFieldSpec extends UIFieldSpec{
		
		
	}


	public static class UITextareaFieldSpec extends UIFieldSpec{
		
		
	}
	
	public static class UIDateFieldSpec extends UIFieldSpec{
		
		
	}
	
	public static class UIEmailFieldSpec extends UIFieldSpec{
		
		
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
}
