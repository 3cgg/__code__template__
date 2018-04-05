package me.libme.webseed.fn._template.ftl;

import me.libme.kernel._c.tkdd.flow.FlowContext;

public class DefaultInternalConfigStrategy implements InternalConfigStrategy {
	
	@Override
	public InternalConfig config(FlowContext flowContext) {
		Config config=TemplateUtil.getConfig(flowContext);
		InternalConfig internalConfig=new DefaultInternalConfig(config);
		return internalConfig;
	}
	
}
