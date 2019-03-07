package me.libme.webseed.fn._template.ftl.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by J on 2019/3/7.
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoColumn {


    String value();

    String lable() default "";

    String jdbcType() default "VARCHAR";



}
