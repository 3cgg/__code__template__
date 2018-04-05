package me.libme.webseed.fn._template.ftl.java.repo;

import me.libme.webseed.fn._template.ftl.java.BaseTemplateModel;

public class DataAccessRepoModel extends BaseTemplateModel {

    private String pageMethodName;

    public String getPageMethodName() {
        return pageMethodName;
    }

    public void setPageMethodName(String pageMethodName) {
        this.pageMethodName = pageMethodName;
    }
}
