package me.libme.webseed.fn._template.ftl.java.criteria;


import me.libme.kernel._c.util.JClassUtils;
import me.libme.webboot.Copy;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.KeyNames;
import me.libme.webseed.fn._template.ftl.java.model.ModelField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CriteriaDefaultFieldParser implements CriteriaFieldParser{

	@Override
	public List<ModelField> parse(InternalConfig.ModelConfig modelConfig) throws Exception {
		List<ModelField> modelFields= modelConfig.modelModel().getModelFields();
		List<ModelField> criteriaModelFields=new ArrayList<ModelField>();
		for(ModelField modelField:modelFields){
			ModelField criteriaModelField= Copy.simpleCopy(modelField, ModelField.class);
			if(Date.class.isAssignableFrom(criteriaModelField.getField().getType())){
				//start time
				ModelField appendModelField=new ModelField();
				appendModelField.setProperty(criteriaModelField.getProperty()+"Start");
				appendModelField.setSetterMethodName(JClassUtils.getSetterMethodName(appendModelField.getProperty()));
				appendModelField.setGetterMethodName(JClassUtils.getGetterMethodName(appendModelField.getProperty(), false));
				appendModelField.setFieldType(KeyNames.FIELD_TYPE_DATE);
				appendModelField.setSourceType(KeyNames.SOURCE_TYPE_APPEND);
				appendModelField.setSource(modelField);
				appendModelField.setRelatedProperty(criteriaModelField.getProperty()+"End");
				criteriaModelFields.add(appendModelField);
				//end time
				appendModelField=new ModelField();
				appendModelField.setProperty(criteriaModelField.getProperty()+"End");
				appendModelField.setSetterMethodName(JClassUtils.getSetterMethodName(appendModelField.getProperty()));
				appendModelField.setGetterMethodName(JClassUtils.getGetterMethodName(appendModelField.getProperty(), false));
				appendModelField.setFieldType(KeyNames.FIELD_TYPE_DATE);
				appendModelField.setSourceType(KeyNames.SOURCE_TYPE_APPEND);
				appendModelField.setSource(modelField);
				appendModelField.setRelatedProperty(criteriaModelField.getProperty()+"Start");
				criteriaModelFields.add(appendModelField);
			}
			criteriaModelField.setField(null);
			criteriaModelField.setSource(modelField);
			criteriaModelFields.add(criteriaModelField);
		}
		return criteriaModelFields;
	}
	
	
}
