package me.libme.webseed.fn._template.ftl.ui;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.kernel._c.tkdd.flow.FlowContext;
import me.libme.kernel._c.tkdd.flow.SimpleLinkedFlow;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;
import me.libme.webseed.fn._template.ftl.TemplateUtil;
import me.libme.webseed.fn._template.ftl.ui.add.UIAddTask;
import me.libme.webseed.fn._template.ftl.ui.edit.UIEditTask;
import me.libme.webseed.fn._template.ftl.ui.list.UIListTask;
import me.libme.webseed.fn._template.ftl.ui.view.UIViewTask;

@MetadataHierarchyOnTask
@MetadataOnTask
public class UISingleModelExecutingTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {
		
		for(InternalConfig.ModelConfig modelConfig:getInternalConfig()){
			SimpleLinkedFlow simpleLinkedFlow=new SimpleLinkedFlow();

			UIPreparedConfigTask uiPreparedConfigTask=new UIPreparedConfigTask();
			simpleLinkedFlow.put(uiPreparedConfigTask);

			UIListTask uiListTask=new UIListTask();
			simpleLinkedFlow.put(uiListTask);

			UIAddTask uiAddTask=new UIAddTask();
			simpleLinkedFlow.put(uiAddTask);

			UIEditTask uiEditTask=new UIEditTask();
			simpleLinkedFlow.put(uiEditTask);

			UIViewTask uiViewTask=new UIViewTask();
			simpleLinkedFlow.put(uiViewTask);
			
			
			FlowContext flowContext=getFlowContext();
			TemplateUtil.setModelConfig(flowContext, modelConfig);

			simpleLinkedFlow.start(flowContext);
		}
        return true;
	}

}
