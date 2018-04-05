package test.me.libme.webseed.autogenerator.demo.service;


import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;
import me.libme.webboot.Copy;

import me.libme.webseed.web.ClosureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import test.me.libme.webseed.autogenerator.demo.model.Car;
import test.me.libme.webseed.autogenerator.demo.vo.CarRecord;
import test.me.libme.webseed.autogenerator.demo.vo.CarCriteria;

import test.me.libme.webseed.autogenerator.demo.repo.CarRepo;
import test.me.libme.webseed.autogenerator.demo.repo.CarManagerDataAccess;


@Service
@Transactional
@ClosureException
public class CarManagerService  {

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private CarManagerDataAccess carManagerDataAccess;


    private Car toCar(CarRecord carRecord){
        Car car= Copy.simpleCopy(carRecord,Car.class);
    	return car;
    }

	/**
	 * save
	 */
	public String saveCar (CarRecord carRecord) throws Exception{
		Car car=toCar(carRecord);
		carRepo.saveOnly( car);
        return car.getId();
	}
	
	/**
	 * update
	 */
	public void updateCar (CarRecord carRecord) throws Exception{

		Car dbCar=carRepo.active(carRecord.getId());

        dbCar.setName(carRecord.getName());
        dbCar.setColor(carRecord.getColor());
        dbCar.setLog(carRecord.getLog());
        dbCar.setWeight(carRecord.getWeight());
        dbCar.setProduceTime(carRecord.getProduceTime());
        carRepo.updateOnly(dbCar);
	}

	
	/**
	 * delete
	 */
	public void deleteCarById (String id) throws Exception{
		carRepo.delete( id);
	}
	
	/**
	 * get
	 */
	public CarRecord getCarById (String id) throws Exception{
		return carRepo.active(id,CarRecord.class);
	}

	
	/**
	 * page...
	 */
	public JPage<CarRecord> getCarsByPage(CarCriteria carCriteria, SimplePageRequest simplePageRequest) throws Exception{
		return carManagerDataAccess.getCarsByPage(carCriteria,simplePageRequest);
	}

}
