package me.libme.webseed.fn._template.ftl;

import me.libme.kernel._c.json.JJSON;
import me.libme.kernel._c.tkdd.BaseTask;

public abstract class TemplateTask extends BaseTask {

	private MessageStream messageStream;

	protected InternalConfig.ModelConfig getModelConfig() {
		return TemplateUtil.getModelConfig(getTaskContext().getFlowContext());
	}

	
	protected Config getConfig(){
		return TemplateUtil.getConfig(getTaskContext().getFlowContext());
	}



	protected InternalConfig getInternalConfig(){
		return TemplateUtil.getInternalConfig(getTaskContext().getFlowContext());
	}

	protected void setInternalConfig(InternalConfig internalConfig){
		TemplateUtil.setInternalConfig(getTaskContext().getFlowContext(), internalConfig);
	}



	@Override
	public final Object run() throws Exception {
		try{
			messageStream=new MessageStream();
			return doRun();
		}catch(Exception e){
			throw e;
		}finally {
			messageStream.close();
		}
	}
	
	protected abstract Object doRun() throws Exception;

	protected void notify(Object message) throws Exception{
		if(message instanceof String){
			messageStream.write(((String)message).getBytes("utf-8"));
		}else{
			messageStream.write(((String) JJSON.get().format(message)).getBytes("utf-8"));
		}
	}


}
