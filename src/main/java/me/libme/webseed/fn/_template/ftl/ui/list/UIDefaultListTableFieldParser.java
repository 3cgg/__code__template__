package me.libme.webseed.fn._template.ftl.ui.list;

import me.libme.webboot.Copy;
import me.libme.webseed.fn._template.ftl.Config;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;

import java.util.ArrayList;
import java.util.List;

import static me.libme.webseed.fn._template.ftl.InternalConfig.ModelConfig;

public class UIDefaultListTableFieldParser implements
		UIListTableFieldParser {

	private boolean isSkip(ModelField modelField, ModelConfig modelConfig){
		String property=modelField.getProperty();
		return "id".equals(property)
				||"createId".equals(property)
				||"updateId".equals(property)
				||"createTime".equals(property)
				||"updateTime".equals(property)
				||"deleted".equals(property)
				||"version".equals(property)
				||isTimeAppend(property, modelConfig);
	}
	
	private boolean isTimeAppend(String property,ModelConfig modelConfig){
		return property.endsWith("imeStart")
				||property.endsWith("imeEnd");
	}
	
	private boolean isDesc(String property,InternalConfig.ModelConfig modelConfig){
		return property.endsWith("Desc")
				||property.endsWith("Description")
				||property.endsWith("description");
	}
	
	@Override
	public List<UIListTableField> parse(ModelConfig modelConfig)
			throws Exception {
		Config config=modelConfig.internalConfig().passConfig();
		List<UIListTableField> tableFields=new ArrayList<UIListTableField>();
		ModelModel modelModel=modelConfig.modelModel();
		for(ModelField modelField:modelModel.getModelFields()){
			if(!isSkip(modelField, modelConfig)){
				UIListTableField tableField= Copy.simpleCopy(modelField, UIListTableField.class);
				Config.FieldConfig fieldConfig=config.getUIField(tableField.getProperty());
				tableField.setLabel(fieldConfig==null?tableField.getProperty():fieldConfig.getLabel());
				if(isDesc(tableField.getProperty(), modelConfig)){
					tableField.setWidth("20%");
				}
				tableFields.add(tableField);
			}
		}
		
		return tableFields;
	}

}
