package ${classPackage};


import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;

import me.libme.webboot.fn._controller.exception.ClosureException;
import me.libme.webboot.ResponseModel;
import me.libme.webboot.SimplePageRequestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${modelRecordModel.className};
import ${criteriaModel.className};

import ${serviceModel.className};



@Controller
@RequestMapping("${controllerBaseMapping}")
@ClosureException
public class ${simpleClassName}  {

	@Autowired
	private ${serviceModel.simpleClassName} ${serviceModel.variableName};


	/**
	 * save
	 */
	@ResponseBody
	@RequestMapping(path="/${controllerModel.saveMethodName}",method=RequestMethod.POST)
	public ResponseModel ${controllerModel.saveMethodName} (${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}) throws Exception {
		// do something validation on the ${modelRecordModel.variableName}.
		${serviceModel.variableName}.${serviceModel.saveMethodName}( ${modelRecordModel.variableName});
		return ResponseModel.newSuccess(true);
	}
	
	/**
	 * update
	 */
	@ResponseBody
	@RequestMapping(path="/${controllerModel.updateMethodName}",method=RequestMethod.POST)
	public ResponseModel ${controllerModel.updateMethodName} (${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}) throws Exception {
		// do something validation on the ${modelRecordModel.variableName}.
		${serviceModel.variableName}.${serviceModel.updateMethodName}( ${modelRecordModel.variableName});
		return ResponseModel.newSuccess(true);
	}

	/**
	 * delete
	 */
	@ResponseBody
	@RequestMapping(path="/${controllerModel.deleteByIdMethodName}",method=RequestMethod.POST)
	public ResponseModel ${controllerModel.deleteByIdMethodName} (String id) throws Exception {
		// do something validation on the ${modelRecordModel.variableName}.
		${serviceModel.variableName}.${serviceModel.deleteByIdMethodName}( id);
		return ResponseModel.newSuccess(true);
	}

	/**
	 * get
	 */
	@ResponseBody
	@RequestMapping(path="/${controllerModel.getMethodName}",method=RequestMethod.GET)
	public ResponseModel ${controllerModel.getMethodName} (String id) throws Exception {
		${modelRecordModel.simpleClassName} ${modelRecordModel.variableName}= ${serviceModel.variableName}.${serviceModel.getMethodName}( id);
		return ResponseModel.newSuccess().setData(${modelRecordModel.variableName});
	}
	
	/**
	 * page...
	 */
	@ResponseBody
	@RequestMapping(path="/${controllerModel.pageMethodName}",method=RequestMethod.GET)
	public ResponseModel ${controllerModel.pageMethodName}(${criteriaModel.simpleClassName} ${criteriaModel.variableName}, SimplePageRequestVO simplePageRequestVO) throws Exception {
		JPage<${modelRecordModel.simpleClassName}> page=${serviceModel.variableName}.${serviceModel.pageMethodName}( ${criteriaModel.variableName},
		new SimplePageRequest(simplePageRequestVO.getPageNumber(),simplePageRequestVO.getPageSize()));
		return ResponseModel.newSuccess().setData(page);
	}

	
}
