package ${classPackage};

import ${modelModel.className};

import me.libme.module.spring.mybatis.IMybatisSingleEntityAccess;
import org.springframework.stereotype.Repository;

@Repository
public interface ${simpleClassName} extends IMybatisSingleEntityAccess<${modelModel.simpleClassName},String> {

}
