package ${classPackage};

import ${modelModel.className};

import me.libme.webboot.fn.jpa.ISingleEntityAccess;
import org.springframework.stereotype.Repository;

@Repository
public interface ${simpleClassName} extends ISingleEntityAccess<${modelModel.simpleClassName},String> {

}
