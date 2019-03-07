package ${classPackage};

import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.JPageable;
import me.libme.module.spring.mybatis.IMybatisSingleEntityAccess;

import ${modelRecordModel.className};
import ${criteriaModel.className};


public interface ${simpleClassName}{

    /**
    * page...
    */
    public JPage<${modelRecordModel.simpleClassName}> ${dataAccessRepoModel.pageMethodName}(${criteriaModel.simpleClassName} ${criteriaModel.variableName}, JPageable pageable);

}