package ${classPackage};

import me.libme.kernel._c.util.JDateUtils;
import me.libme.kernel._c._m.JPage;
import me.libme.kernel._c._m.SimplePageRequest;
import me.libme.module.spring.jpahibernate.query2.JJpaDateParam;
import me.libme.webboot.fn.jpa.DataAccessSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TemporalType;

import ${modelRecordModel.className};
import ${criteriaModel.className};


@Component
public class ${simpleClassName} extends DataAccessSupport {


    @Autowired
    private ${singleRepoModel.simpleClassName} ${singleRepoModel.variableName};


    /**
    * page...
    */
    public JPage<${modelRecordModel.simpleClassName}> ${dataAccessRepoModel.pageMethodName}(${criteriaModel.simpleClassName} ${criteriaModel.variableName}, SimplePageRequest simplePageRequest) throws Exception{
    return ${singleRepoModel.variableName}.singleEntityQuery2()
            .conditionDefault()
    <#list criteriaModel.modelFields as modelField>
        <#if modelField.fieldType=="string">
            .likes("${modelField.property}", ${criteriaModel.variableName}.${modelField.getterMethodName}())
        </#if>
        <#if modelField.fieldType=="numeric">
            .equals("${modelField.property}", ${criteriaModel.variableName}.${modelField.getterMethodName}())
        </#if>
        <#if modelField.fieldType=="date">
            <#if modelField.property?ends_with("Start")>
            .larger("${modelField.property}", new JJpaDateParam(JDateUtils.parseDate(${criteriaModel.variableName}.${modelField.getterMethodName}()), TemporalType.TIMESTAMP))
            <#elseif modelField.property?ends_with("End")>
            .smaller("${modelField.property}", new JJpaDateParam(JDateUtils.parseDate(${criteriaModel.variableName}.${modelField.getterMethodName}()), TemporalType.TIMESTAMP))
            <#else>
            .equals("${modelField.property}", new JJpaDateParam(JDateUtils.parseDate(${criteriaModel.variableName}.${modelField.getterMethodName}()), TemporalType.DATE))
            </#if>
        </#if>
    </#list>
            .ready()
            .order().desc("updateTime")
            .ready()
            .modelPage(simplePageRequest,${modelRecordModel.simpleClassName}.class);
    }





}