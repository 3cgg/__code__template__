package me.libme.webseed.fn._template.ftl;

import me.libme.kernel._c.tkdd.flow.FlowContext;
import me.libme.kernel._c.tkdd.flow.SimpleLinkedFlow;
import me.libme.webseed.fn._template.ftl.java.SingleModelExecutingTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateRunner {
	
	private final static Logger LOGGER= LoggerFactory.getLogger(TemplateRunner.class);

	public static void start(Config config) throws Exception {
		SimpleLinkedFlow simpleLinkedFlow=new SimpleLinkedFlow();
		
		PreparedConfigTask preparedConfigTask= new PreparedConfigTask();
		simpleLinkedFlow.put(preparedConfigTask);
		
		SingleModelExecutingTask singleModelExecutingTask=new SingleModelExecutingTask();
		simpleLinkedFlow.put(singleModelExecutingTask);
		
		FileWriterTask fileWriterTask=new FileWriterTask();
		simpleLinkedFlow.put(fileWriterTask);
		
		FlowContext  flowContext =new FlowContext();
		TemplateUtil.setConfig(flowContext, config);

		simpleLinkedFlow.start(flowContext);
		LOGGER.info("template is processed completely.");
	}
	
}
