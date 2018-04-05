package test.me.libme.webseed.autogenerator.demo.repo;

import me.libme.kernel._c.util.JDateUtils;
import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;
import me.libme.module.spring.jpahibernate.query2.JJpaDateParam;
import me.libme.webboot.fn.jpa.DataAccessSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TemporalType;

import test.me.libme.webseed.autogenerator.demo.vo.CarRecord;
import test.me.libme.webseed.autogenerator.demo.vo.CarCriteria;


@Component
public class CarManagerDataAccess extends DataAccessSupport {


    @Autowired
    private CarRepo carRepo;


    /**
    * page...
    */
    public JPage<CarRecord> getCarsByPage(CarCriteria carCriteria, SimplePageRequest simplePageRequest) throws Exception{
    return carRepo.singleEntityQuery2()
            .conditionDefault()
            .likes("name", carCriteria.getName())
            .likes("color", carCriteria.getColor())
            .likes("log", carCriteria.getLog())
            .equals("weight", carCriteria.getWeight())
            .larger("produceTimeStart", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getProduceTimeStart()), TemporalType.TIMESTAMP))
            .smaller("produceTimeEnd", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getProduceTimeEnd()), TemporalType.TIMESTAMP))
            .equals("produceTime", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getProduceTime()), TemporalType.DATE))
            .likes("id", carCriteria.getId())
            .likes("createId", carCriteria.getCreateId())
            .likes("updateId", carCriteria.getUpdateId())
            .larger("createTimeStart", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getCreateTimeStart()), TemporalType.TIMESTAMP))
            .smaller("createTimeEnd", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getCreateTimeEnd()), TemporalType.TIMESTAMP))
            .equals("createTime", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getCreateTime()), TemporalType.DATE))
            .larger("updateTimeStart", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getUpdateTimeStart()), TemporalType.TIMESTAMP))
            .smaller("updateTimeEnd", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getUpdateTimeEnd()), TemporalType.TIMESTAMP))
            .equals("updateTime", new JJpaDateParam(JDateUtils.parseDate(carCriteria.getUpdateTime()), TemporalType.DATE))
            .likes("deleted", carCriteria.getDeleted())
            .equals("version", carCriteria.getVersion())
            .ready()
            .order().desc("updateTime")
            .ready()
            .modelPage(simplePageRequest,CarRecord.class);
    }





}