package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.module.spring.jpahibernate.meta.JEntityColumnMeta;
import me.libme.module.spring.jpahibernate.meta.JEntityModelMeta;
import me.libme.module.spring.jpahibernate.meta.JEntityUtilService;
import me.libme.webseed.fn._template.ftl.KeyNames;
import me.libme.webseed.fn._template.ftl.TemplateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EntityModelFieldParser implements ModelFieldParser {

	private JEntityUtilService entityUtilService=JEntityUtilService.get();
	
	@Override
	public List<ModelField> parse(Class<?> clazz) throws Exception {
		List<ModelField> modelFields=new ArrayList<ModelField>();
		JEntityModelMeta entityModelMeta=entityUtilService.getEntityModelMeta(clazz);
		Collection<JEntityColumnMeta> entityColumnMetas=entityModelMeta.columnMetas();
		for(JEntityColumnMeta columnMeta:entityColumnMetas){
			ModelField modelField=new ModelField();
			modelField.setProperty(columnMeta.getProperty());
			modelField.setColumn(columnMeta.getColumn());
			modelField.setField(columnMeta.getField());
			modelField.setSetterMethodName(columnMeta.getSetterMethodName());
			modelField.setGetterMethodName(columnMeta.getGetterMethodName());
			modelField.setFieldType(TemplateUtil.type(columnMeta.getField()));
			modelField.setSourceType(KeyNames.SOURCE_TYPE_CLASS);
			modelFields.add(modelField);
		}
		return modelFields;
	}

}
