package test.me.libme.webseed.autogenerator.demo.repo;

import test.me.libme.webseed.autogenerator.demo.model.Car;

import me.libme.webboot.fn.jpa.ISingleEntityAccess;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends ISingleEntityAccess<Car,String> {

}
