package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c._ref.JDefaultFieldMeta;
import me.libme.kernel._c.bean.SimpleFieldOnClassFinder;
import me.libme.webseed.fn._template.ftl.KeyNames;
import me.libme.webseed.fn._template.ftl.TemplateUtil;

import java.util.ArrayList;
import java.util.List;

public class DefaultModelFieldParser implements ModelFieldParser {

	@Override
	public List<ModelField> parse(Class<?> clazz) throws Exception {

		SimpleFieldOnClassFinder simpleFieldOnClassFinder
					=new SimpleFieldOnClassFinder(clazz);
		List<JDefaultFieldMeta> defaultFieldMetas= simpleFieldOnClassFinder.find();
		List<ModelField> modelFields=new ArrayList<ModelField>();
		for(JDefaultFieldMeta defaultFieldMeta:defaultFieldMetas){
			ModelField modelField=new ModelField();
			modelField.setProperty(defaultFieldMeta.getFieldName());
			modelField.setColumn(defaultFieldMeta.getFieldName());
			modelField.setField(defaultFieldMeta.getField());
			modelField.setSetterMethodName(defaultFieldMeta.getSetterMethodName());
			modelField.setGetterMethodName(defaultFieldMeta.getGetterMethodName());
			modelField.setFieldType(TemplateUtil.type(defaultFieldMeta.getField()));
			modelField.setSourceType(KeyNames.SOURCE_TYPE_CLASS);
			modelFields.add(modelField);
		}
		return modelFields;
	}

}
