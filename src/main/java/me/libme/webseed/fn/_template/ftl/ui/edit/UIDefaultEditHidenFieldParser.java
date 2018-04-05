package me.libme.webseed.fn._template.ftl.ui.edit;

import me.libme.webboot.Copy;
import me.libme.webseed.fn._template.ftl.Config;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;
import me.libme.webseed.fn._template.ftl.ui.FieldSpecSetter;
import me.libme.webseed.fn._template.ftl.ui.UIField;
import me.libme.webseed.fn._template.ftl.ui.UIHiddenFieldParser;

import java.util.ArrayList;
import java.util.List;

import static me.libme.webseed.fn._template.ftl.InternalConfig.ModelConfig;

public class UIDefaultEditHidenFieldParser implements
		UIHiddenFieldParser {

	private boolean isSkip(ModelField modelField, InternalConfig.ModelConfig modelConfig){
		return "createId".equals(modelField.getProperty())
				||"updateId".equals(modelField.getProperty())
				||"createTime".equals(modelField.getProperty())
				||"updateTime".equals(modelField.getProperty())
				||"deleted".equals(modelField.getProperty())
				||"version".equals(modelField.getProperty());
	}
	
	private boolean isTimeAppend(UIField uiField, InternalConfig.ModelConfig modelConfig){
		return isTimeAppend(uiField.getProperty(), modelConfig);
	}
	
	private boolean isTimeAppend(String property,ModelConfig modelConfig){
		return property.endsWith("imeStart")
				||property.endsWith("imeEnd");
	}
	
	
	private boolean isDesc(String property,ModelConfig modelConfig){
		return property.endsWith("Desc")
				||property.endsWith("Description")
				||property.endsWith("description");
	}
	
	private boolean isHidden(String property,ModelConfig modelConfig){
		return property.endsWith("id");
	}
	
	
	@Override
	public List<UIField> parse(ModelConfig modelConfig)
			throws Exception {
		Config config=modelConfig.internalConfig().passConfig();
		List<UIField> uiFields=new ArrayList<UIField>();
		ModelModel modelModel=modelConfig.modelModel();
		for(ModelField modelField:modelModel.getModelFields()){
			if(!isSkip(modelField, modelConfig)
					&&isHidden(modelField.getProperty(), modelConfig)){
				UIField uiField= Copy.simpleCopy(modelField, UIField.class);
				Config.FieldConfig fieldConfig=config.getUIField(uiField.getProperty());
				uiField.setLabel(fieldConfig==null?uiField.getProperty():fieldConfig.getLabel());
				uiField.setHidden(true);
				fillinFieldSpec(uiField, modelConfig);
				uiFields.add(uiField);
			}
		}
		
		return uiFields;
	}

	private void fillinFieldSpec(UIField uiField, ModelConfig modelConfig) {
		new FieldSpecSetter().setFieldSpec(uiField, modelConfig);
	}
	

}
