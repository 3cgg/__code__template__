package ${classPackage};


import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;
import me.libme.webboot.Copy;

import me.libme.webseed.web.ClosureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ${modelModel.className};
import ${modelRecordModel.className};
import ${criteriaModel.className};

import ${singleRepoModel.className};
import ${dataAccessRepoModel.className};


@Service
@Transactional
@ClosureException
public class ${simpleClassName}  {

	@Autowired
	private ${singleRepoModel.simpleClassName} ${singleRepoModel.variableName};

	@Autowired
	private ${dataAccessRepoModel.simpleClassName} ${dataAccessRepoModel.variableName};


    private ${modelModel.simpleClassName} to${modelModel.simpleClassName}(${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}){
        ${modelModel.simpleClassName} ${modelModel.variableName}= Copy.simpleCopy(${modelRecordModel.variableName},${modelModel.simpleClassName}.class);
    	return ${modelModel.variableName};
    }

	/**
	 * save
	 */
	public String ${serviceModel.saveMethodName} (${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}) throws Exception{
		${modelModel.simpleClassName} ${modelModel.variableName}=to${modelModel.simpleClassName}(${modelRecordModel.variableName});
		${singleRepoModel.variableName}.saveOnly( ${modelModel.variableName});
        return ${modelModel.variableName}.getId();
	}
	
	/**
	 * update
	 */
	public void ${serviceModel.updateMethodName} (${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}) throws Exception{

		${modelModel.simpleClassName} db${modelModel.simpleClassName}=${singleRepoModel.variableName}.active(${modelRecordModel.variableName}.getId());

        <#list modelModel.modelFields as modelField>
        <#if  modelField.property!="id"
                &&modelField.property!="createId"
                &&modelField.property!="createTime"
                &&modelField.property!="updateId"
                &&modelField.property!="updateTime"
                &&modelField.property!="deleted"
                &&modelField.property!="version"
         >
        db${modelModel.simpleClassName}.${modelField.setterMethodName}(${modelRecordModel.variableName}.${modelField.getterMethodName}());
        </#if>
        </#list>
        ${singleRepoModel.variableName}.updateOnly(db${modelModel.simpleClassName});
	}

	
	/**
	 * delete
	 */
	public void ${serviceModel.deleteByIdMethodName} (String id) throws Exception{
		${singleRepoModel.variableName}.delete( id);
	}
	
	/**
	 * get
	 */
	public ${modelRecordModel.simpleClassName} ${serviceModel.getMethodName} (String id) throws Exception{
		return ${singleRepoModel.variableName}.active(id,${modelRecordModel.simpleClassName}.class);
	}

	
	/**
	 * page...
	 */
	public JPage<${modelRecordModel.simpleClassName}> ${serviceModel.pageMethodName}(${criteriaModel.simpleClassName} ${criteriaModel.variableName}, SimplePageRequest simplePageRequest) throws Exception{
		return ${dataAccessRepoModel.variableName}.${dataAccessRepoModel.pageMethodName}(${criteriaModel.variableName},simplePageRequest);
	}

}
