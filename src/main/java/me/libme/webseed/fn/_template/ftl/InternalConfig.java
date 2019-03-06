package me.libme.webseed.fn._template.ftl;

import me.libme.webseed.fn._template.ftl.java.controller.ControllerModel;
import me.libme.webseed.fn._template.ftl.java.criteria.CriteriaModel;
import me.libme.webseed.fn._template.ftl.java.model.ModelModel;
import me.libme.webseed.fn._template.ftl.java.modelrecord.ModelRecordModel;
import me.libme.webseed.fn._template.ftl.java.repo.DataAccessRepoModel;
import me.libme.webseed.fn._template.ftl.java.repo.SingleRepoModel;
import me.libme.webseed.fn._template.ftl.java.service.ServiceModel;

import java.util.List;

public interface InternalConfig extends Iterable<InternalConfig.ModelConfig> {

	Config passConfig();
	
	String javaRelativePath();
	
	String uiRelativePath();

	String basePackage();
	
	String servicePackage();
	
	String repoPackage();
	
	String voPackage();
	
	String controllerPackage();
	
	String modelPackage();
	
	/**
	 * file without .java, example User.java => User
	 * under the directory {@link Config#getModelPath()}
	 * @return
	 */
	List<String> modelNames();
	
	String controllerBaseMapping();
	
	List<FileWrapper> files();
	
	void addFile(FileWrapper fileWrapper);
	
	interface ModelConfig{
		
		InternalConfig internalConfig();
		
		String modelName();
		
		String pageMethodName();
		
		String saveMethodName();
		
		String updateMethodName();
		
		String deleteMethodName();
		
		String deleteByIdMethodName();
		
		String getMethodName();
		
		ModelModel modelModel();
		
		void setModelModel(ModelModel modelModel);

		SingleRepoModel singleRepoModel();

		void setSingleRepoModel(SingleRepoModel singleRepoModel);

		DataAccessRepoModel dataAccessRepoModel();

		void setDataAccessRepoModel(DataAccessRepoModel dataAccessRepoModel);

		CriteriaModel criteriaModel();
		
		void setCriteriaModel(CriteriaModel criteriaModel);
		
		ModelRecordModel modelRecordModel();
		
		void setModelRecordModel(ModelRecordModel modelRecordModel);
		
		ServiceModel serviceModel();
		
		void setServiceModel(ServiceModel serviceModel);

		ControllerModel controllerModel();
		
		void setControllerModel(ControllerModel controllerModel);
		
	}

}
