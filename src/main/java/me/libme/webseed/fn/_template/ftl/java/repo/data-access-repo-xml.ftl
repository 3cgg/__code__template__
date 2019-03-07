<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${classPackage}.${simpleClassName}" >

    <resultMap id="BaseResultMap" type="${modelRecordModel.className}" >

        <#list modelModel.modelFields as modelField>
            <#if  modelField.property!="id"
            &&modelField.property!="createId"
            &&modelField.property!="createTime"
            &&modelField.property!="updateId"
            &&modelField.property!="updateTime"
            &&modelField.property!="deleted"
            &&modelField.property!="version"
            >
                <result column="${modelField.column}" property="${modelField.property}" jdbcType="${modelField.mybatisColumnInfo.jdbcType}" />
            </#if>
        </#list>


        <id column="id" property="id" jdbcType="VARCHAR" />
        <result column="CREATE_ID" property="createId" jdbcType="VARCHAR" />
        <result column="UPDATE_ID" property="updateId" jdbcType="VARCHAR" />
        <result column="CREATE_TIME" property="createTime" jdbcType="TIMESTAMP" />
        <result column="UPDATE_TIME" property="updateTime" jdbcType="TIMESTAMP" />
        <result column="DELETED" property="deleted" jdbcType="VARCHAR" />
        <result column="VERSION" property="version" jdbcType="INTEGER" />
    </resultMap>

    <sql id="Base_Column_List" >
        <#list modelModel.modelFields as modelField>
            <#if  modelField.property!="id"
            &&modelField.property!="createId"
            &&modelField.property!="createTime"
            &&modelField.property!="updateId"
            &&modelField.property!="updateTime"
            &&modelField.property!="deleted"
            &&modelField.property!="version"
            >
            ${modelField.column}
            <#--<#if modelField_has_next>-->
            <#--,-->
            <#--</#if>-->
            </#if>
        </#list>
        ,ID,CREATE_ID, CREATE_TIME,UPDATE_ID,UPDATE_TIME, DELETED, VERSION
    </sql>


    <select id="${dataAccessRepoModel.pageMethodName}" resultMap="BaseResultMap" parameterType="${criteriaModel.className}" >
        select
        <include refid="Base_Column_List" />
        from ${modelModel.tableName}
        <#noparse>where id = #{id,jdbcType=VARCHAR}</#noparse>
    </select>

</mapper>