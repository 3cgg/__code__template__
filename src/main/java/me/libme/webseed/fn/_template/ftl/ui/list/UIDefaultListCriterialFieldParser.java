package me.libme.webseed.fn._template.ftl.ui.list;


import me.libme.webboot.Copy;
import me.libme.webseed.fn._template.ftl.Config;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.java.criteria.CriteriaModel;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;
import me.libme.webseed.fn._template.ftl.ui.Buckets;
import me.libme.webseed.fn._template.ftl.ui.FieldSpecSetter;

import java.util.ArrayList;
import java.util.List;

import static me.libme.webseed.fn._template.ftl.InternalConfig.ModelConfig;

public class UIDefaultListCriterialFieldParser implements
		UIListCriterialFieldParser {

	private boolean isSkip(ModelField modelField, InternalConfig.ModelConfig modelConfig){
		return "id".equals(modelField.getProperty())
				||"createId".equals(modelField.getProperty())
				||"updateId".equals(modelField.getProperty())
				||"createTime".equals(modelField.getProperty())
				||"updateTime".equals(modelField.getProperty())
				||"deleted".equals(modelField.getProperty())
				||"version".equals(modelField.getProperty());
	}
	
	private boolean isTimeAppend(UIListCriteriaField criteriaField,ModelConfig modelConfig){
		return isTimeAppend(criteriaField.getProperty(), modelConfig);
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
	
	private void fillinFieldSpec(UIListCriteriaField criteriaField, ModelConfig modelConfig) {
		new FieldSpecSetter().setFieldSpec(criteriaField, modelConfig);
	}
	
	@Override
	public List<UIListCriteriaField> parse(ModelConfig modelConfig)
			throws Exception {
		Config config=modelConfig.internalConfig().passConfig();
		List<UIListCriteriaField> criteriaFields=new ArrayList<UIListCriteriaField>();
		CriteriaModel criteriaModel=modelConfig.criteriaModel();
		for(ModelField modelField:criteriaModel.getModelFields()){
			if(!isSkip(modelField, modelConfig)){
				UIListCriteriaField criteriaField= Copy.simpleCopy(modelField, UIListCriteriaField.class);
				Config.FieldConfig fieldConfig=config.getUIField(criteriaField.getProperty());
				criteriaField.setLabel(fieldConfig==null?criteriaField.getProperty():fieldConfig.getLabel());
				
				fillinFieldSpec(criteriaField, modelConfig);
				
				if(isDesc(criteriaField.getProperty(), modelConfig)){
					criteriaField.setColNum(8);
				}
				criteriaFields.add(criteriaField);
			}
		}
		
		Buckets buckets=new Buckets();
		
		for(UIListCriteriaField criteriaField:criteriaFields){
			buckets.addUIField(criteriaField, modelConfig);
		}
		
		return buckets.evenCollection();
	}

}
