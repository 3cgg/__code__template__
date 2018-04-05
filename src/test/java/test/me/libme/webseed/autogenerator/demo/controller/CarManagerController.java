package test.me.libme.webseed.autogenerator.demo.controller;


import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;

import me.libme.webseed.web.ClosureException;
import me.libme.webboot.ResponseModel;
import me.libme.webseed.web.SimplePageRequestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.me.libme.webseed.autogenerator.demo.vo.CarRecord;
import test.me.libme.webseed.autogenerator.demo.vo.CarCriteria;

import test.me.libme.webseed.autogenerator.demo.service.CarManagerService;



@Controller
@RequestMapping("/carmanager")
@ClosureException
public class CarManagerController  {

	@Autowired
	private CarManagerService carManagerService;


	/**
	 * save
	 */
	@ResponseBody
	@RequestMapping(path="/saveCar",method=RequestMethod.POST)
	public ResponseModel saveCar (CarRecord carRecord) throws Exception {
		// do something validation on the carRecord.
		carManagerService.saveCar( carRecord);
		return ResponseModel.newSuccess(true);
	}
	
	/**
	 * update
	 */
	@ResponseBody
	@RequestMapping(path="/updateCar",method=RequestMethod.POST)
	public ResponseModel updateCar (CarRecord carRecord) throws Exception {
		// do something validation on the carRecord.
		carManagerService.updateCar( carRecord);
		return ResponseModel.newSuccess(true);
	}

	/**
	 * delete
	 */
	@ResponseBody
	@RequestMapping(path="/deleteCarById",method=RequestMethod.POST)
	public ResponseModel deleteCarById (String id) throws Exception {
		// do something validation on the carRecord.
		carManagerService.deleteCarById( id);
		return ResponseModel.newSuccess(true);
	}

	/**
	 * get
	 */
	@ResponseBody
	@RequestMapping(path="/getCarById",method=RequestMethod.GET)
	public ResponseModel getCarById (String id) throws Exception {
		CarRecord carRecord= carManagerService.getCarById( id);
		return ResponseModel.newSuccess().setData(carRecord);
	}
	
	/**
	 * page...
	 */
	@ResponseBody
	@RequestMapping(path="/getCarsByPage",method=RequestMethod.GET)
	public ResponseModel getCarsByPage(CarCriteria carCriteria, SimplePageRequestVO simplePageRequestVO) throws Exception {
		JPage<CarRecord> page=carManagerService.getCarsByPage( carCriteria,
		new SimplePageRequest(simplePageRequestVO.getPageNumber(),simplePageRequestVO.getPageSize()));
		return ResponseModel.newSuccess().setData(page);
	}

	
}
