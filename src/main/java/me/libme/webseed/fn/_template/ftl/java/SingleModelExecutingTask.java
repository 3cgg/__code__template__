package me.libme.webseed.fn._template.ftl.java;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.kernel._c.tkdd.flow.FlowContext;
import me.libme.kernel._c.tkdd.flow.SimpleLinkedFlow;
import me.libme.webseed.fn._template.ftl.InternalConfig;
import me.libme.webseed.fn._template.ftl.TemplateTask;
import me.libme.webseed.fn._template.ftl.TemplateUtil;
import me.libme.webseed.fn._template.ftl.java.controller.ControllerTask;
import me.libme.webseed.fn._template.ftl.java.criteria.CriteriaTask;
import me.libme.webseed.fn._template.ftl.java.model.ModelTask;
import me.libme.webseed.fn._template.ftl.java.modelrecord.ModelRecordTask;
import me.libme.webseed.fn._template.ftl.java.repo.DataAccessRepoTask;
import me.libme.webseed.fn._template.ftl.java.repo.SingleRepoTask;
import me.libme.webseed.fn._template.ftl.java.service.ServiceTask;

@MetadataHierarchyOnTask
@MetadataOnTask
public class SingleModelExecutingTask extends TemplateTask {

	@Override
	public Object doRun() throws Exception {
		
		for(InternalConfig.ModelConfig modelConfig:getInternalConfig()){
			FlowContext flowContext=getFlowContext();
			TemplateUtil.setModelConfig(flowContext, modelConfig);

			SimpleLinkedFlow simpleLinkedFlow=new SimpleLinkedFlow();
			
			ModelTask modelTask=new ModelTask();
			simpleLinkedFlow.put(modelTask);

			ModelRecordTask modelRecordTask=new ModelRecordTask();
			simpleLinkedFlow.put(modelRecordTask);

			CriteriaTask criteriaTask=new CriteriaTask();
			simpleLinkedFlow.put(criteriaTask);

			SingleRepoTask singleRepoTask=new SingleRepoTask();
			simpleLinkedFlow.put(singleRepoTask);

			DataAccessRepoTask dataAccessRepoTask=new DataAccessRepoTask();
			simpleLinkedFlow.put(dataAccessRepoTask);

			ServiceTask serviceTask=new ServiceTask();
			simpleLinkedFlow.put(serviceTask);

			ControllerTask controllerTask=new ControllerTask();
			simpleLinkedFlow.put(controllerTask);

			simpleLinkedFlow.start(flowContext);
		}
        return true;
	}

}
