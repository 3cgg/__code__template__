package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c._i.JParser;

import java.util.List;

public interface ModelFieldParser extends JParser {

	List<ModelField> parse(Class<?> clazz) throws Exception;
	
}
