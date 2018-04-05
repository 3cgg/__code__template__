package ${criteriaModel.classPackage};

public class ${criteriaModel.simpleClassName} {

<#list criteriaModel.modelFields as modelField>
	private String ${modelField.property};
	
</#list>

<#list criteriaModel.modelFields as modelField>
	public String ${modelField.getterMethodName}() {
		return ${modelField.property};
	}

	public void ${modelField.setterMethodName}(String ${modelField.property}) {
		this.${modelField.property} = ${modelField.property};
	}
	
</#list>
	
}
