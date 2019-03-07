package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c._m.JModel;

/**
 * Created by J on 2019/3/7.
 */
public class MybatisColumnInfo implements JModel {

    /**
     * VARCHAR,TIMESTAMP,INTEGER
     */
    private String jdbcType;

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }
}
