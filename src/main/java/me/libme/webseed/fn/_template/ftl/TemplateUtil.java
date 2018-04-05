package me.libme.webseed.fn._template.ftl;

import me.libme.kernel._c.tkdd.flow.FlowContext;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

public class TemplateUtil {

	public static Config getConfig(FlowContext flowContext){
		Config config= (Config) flowContext.get(KeyNames.TEMPLATE_CONFIG_KEY);
		return config;
	}
	
	public static void setConfig(FlowContext flowContext,Config config){
		flowContext.put(KeyNames.TEMPLATE_CONFIG_KEY, config);
	}

	public static InternalConfig.ModelConfig getModelConfig(FlowContext flowContext){
		InternalConfig.ModelConfig modelConfig= (InternalConfig.ModelConfig) flowContext.get(KeyNames.TEMPLATE_MODEL_CONFIG_KEY);
		return modelConfig;
	}
	public static InternalConfig getInternalConfig(FlowContext flowContext){
		InternalConfig internalConfig= (InternalConfig) flowContext.get(KeyNames.TEMPLATE_INTERNAL_CONFIG_KEY);
		return internalConfig;
	}

	static void setInternalConfig(FlowContext flowContext,InternalConfig internalConfig){
		flowContext.put(KeyNames.TEMPLATE_INTERNAL_CONFIG_KEY, internalConfig);
	}



	public static void setModelConfig(FlowContext flowContext,InternalConfig.ModelConfig modelConfig){
		flowContext.put(KeyNames.TEMPLATE_MODEL_CONFIG_KEY, modelConfig);
	}
	
	public static String variableName(String className){
		return Introspector.decapitalize(className);
	}
	
	public static String type(Field field){
		String type=KeyNames.FIELD_TYPE_STRING;
		Class<?> fieldType=field.getType();
		if(fieldType==String.class){
			type=KeyNames.FIELD_TYPE_STRING;
		}else if(fieldType==byte.class
				||fieldType==short.class
				||fieldType==int.class	
				||fieldType==long.class
				||fieldType==float.class
				||fieldType==double.class
				||fieldType==Byte.class
				||fieldType==Short.class
				||fieldType==Integer.class
				||fieldType==Long.class
				||fieldType==Float.class
				||fieldType==Double.class
				||fieldType==BigDecimal.class
				){
			type=KeyNames.FIELD_TYPE_NUMERIC;
		}else if(Date.class.isAssignableFrom(fieldType)){
			type=KeyNames.FIELD_TYPE_DATE;
		}
		return type;
	}
	
	
}
