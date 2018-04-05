package me.libme.webseed.fn._template.ftl.ui.view;


import me.libme.webboot.Copy;
import me.libme.webseed.fn._template.ftl.Config;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;
import me.libme.webseed.fn._template.ftl.ui.Buckets;
import me.libme.webseed.fn._template.ftl.ui.FieldSpecSetter;

import java.util.ArrayList;
import java.util.List;

import static me.libme.webseed.fn._template.ftl.InternalConfig.ModelConfig;

public class UIDefaultViewFieldParser implements
		UIViewFieldParser {

	private boolean isSkip(ModelField modelField, InternalConfig.ModelConfig modelConfig){
		return "id".equals(modelField.getProperty())
				||"createId".equals(modelField.getProperty())
				||"updateId".equals(modelField.getProperty())
				||"createTime".equals(modelField.getProperty())
				||"updateTime".equals(modelField.getProperty())
				||"deleted".equals(modelField.getProperty())
				||"version".equals(modelField.getProperty());
	}
	
	private boolean isTimeAppend(UIViewField viewField,ModelConfig modelConfig){
		return isTimeAppend(viewField.getProperty(), modelConfig);
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
	
	
	@Override
	public List<UIViewField> parse(ModelConfig modelConfig)
			throws Exception {
		Config config=modelConfig.internalConfig().passConfig();
		List<UIViewField> viewFields=new ArrayList<UIViewField>();
		ModelModel modelModel=modelConfig.modelModel();
		for(ModelField modelField:modelModel.getModelFields()){
			if(!isSkip(modelField, modelConfig)){
				UIViewField viewField= Copy.simpleCopy(modelField, UIViewField.class);
				Config.FieldConfig fieldConfig=config.getUIField(viewField.getProperty());
				viewField.setLabel(fieldConfig==null?viewField.getProperty():fieldConfig.getLabel());
				
				fillinFieldSpec(viewField, modelConfig);

				if(isDesc(viewField.getProperty(), modelConfig)){
					viewField.setColNum(8);
				}
				viewFields.add(viewField);
			}
		}
		
		Buckets buckets=new Buckets();
		for(UIViewField viewField:viewFields){
			buckets.addUIField(viewField, modelConfig);
		}
		return buckets.evenCollection();
	}

	private void fillinFieldSpec(UIViewField viewField, ModelConfig modelConfig) {
		new FieldSpecSetter().setFieldSpec(viewField, modelConfig);
	}
	

}
