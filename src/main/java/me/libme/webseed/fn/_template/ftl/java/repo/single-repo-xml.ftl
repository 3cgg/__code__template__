<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${classPackage}.${simpleClassName}" >

    <resultMap id="BaseResultMap" type="${modelModel.className}" >

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
            ${modelField.column},
            <#--<#if modelField_has_next>-->
                <#--,-->
            <#--</#if>-->
        </#if>
    </#list>
        ID,CREATE_ID, CREATE_TIME,UPDATE_ID,UPDATE_TIME, DELETED, VERSION
    </sql>


    <select id="getById" resultMap="BaseResultMap" parameterType="java.lang.String" >
        select
        <include refid="Base_Column_List" />
        from ${modelModel.tableName}
        <#noparse>where id = #{id,jdbcType=VARCHAR}</#noparse>
    </select>


    <delete id="deletePermanently" parameterType="java.lang.String" >
        delete from ${modelModel.tableName}
        <#noparse>where id = #{id,jdbcType=VARCHAR}</#noparse>
    </delete>

    <insert id="saveOnly">
        insert into ${modelModel.tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >

            <#list modelModel.modelFields as modelField>
                <#if  modelField.property!="id"
                &&modelField.property!="createId"
                &&modelField.property!="createTime"
                &&modelField.property!="updateId"
                &&modelField.property!="updateTime"
                &&modelField.property!="deleted"
                &&modelField.property!="version"
                >
                    <if test="${modelField.property} != null" >
                        ${modelField.column},
                    </if>
                </#if>
            </#list>

            <if test="id != null" >
                id,
            </if>
            <if test="createId != null" >
                CREATE_ID,
            </if>
            <if test="updateId != null" >
                UPDATE_ID,
            </if>
            <if test="createTime != null" >
                CREATE_TIME,
            </if>
            <if test="updateTime != null" >
                UPDATE_TIME,
            </if>
            <if test="deleted != null" >
                DELETED,
            </if>
            <if test="version != null" >
                VERSION,
            </if>

        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >

            <#list modelModel.modelFields as modelField>
                <#if  modelField.property!="id"
                &&modelField.property!="createId"
                &&modelField.property!="createTime"
                &&modelField.property!="updateId"
                &&modelField.property!="updateTime"
                &&modelField.property!="deleted"
                &&modelField.property!="version"
                >
                    <if test="${modelField.property}  != null" >
                    <#noparse>#{</#noparse> ${modelField.property} ,jdbcType=${modelField.mybatisColumnInfo.jdbcType}<#noparse>}</#noparse>,
                    </if>
                </#if>
            </#list>
            <#noparse>
            <if test="id != null" >
                #{id,jdbcType=VARCHAR},
            </if>
            <if test="createId != null" >
                #{createId,jdbcType=VARCHAR},
            </if>
            <if test="updateId != null" >
                #{updateId,jdbcType=VARCHAR},
            </if>
            <if test="createTime != null" >
                #{createTime,jdbcType=TIMESTAMP},
            </if>
            <if test="updateTime != null" >
                #{updateTime,jdbcType=TIMESTAMP},
            </if>
            <if test="deleted != null" >
                #{deleted,jdbcType=VARCHAR},
            </if>
            <if test="version != null" >
                #{version,jdbcType=INTEGER},
            </if>
            </#noparse>
        </trim>
    </insert>

    <update id="updateOnly" >
        update ${modelModel.tableName}
        <set >

        <#list modelModel.modelFields as modelField>
            <#if  modelField.property!="id"
            &&modelField.property!="createId"
            &&modelField.property!="createTime"
            &&modelField.property!="updateId"
            &&modelField.property!="updateTime"
            &&modelField.property!="deleted"
            &&modelField.property!="version"
            >
                <if test="${modelField.property} != null" >
                    ${modelField.column} = <#noparse>#{</#noparse>${modelField.property},jdbcType=${modelField.mybatisColumnInfo.jdbcType}<#noparse>}</#noparse>,
                </if>
            </#if>
        </#list>
        <#noparse>
            <if test="updateId != null" >
                UPDATE_ID = #{updateId,jdbcType=VARCHAR},
            </if>
            <if test="updateTime != null" >
                UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},
            </if>

        </set>
        where id = #{id,jdbcType=VARCHAR}
        </#noparse>
    </update>

    <update id="delete" parameterType="java.lang.String" >
        update ${modelModel.tableName}  set DELETED = 'Y'
        <#noparse>where id = #{id,jdbcType=VARCHAR}</#noparse>
    </update>

</mapper>