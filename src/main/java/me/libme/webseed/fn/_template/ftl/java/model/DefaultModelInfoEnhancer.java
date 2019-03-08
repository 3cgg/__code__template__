package me.libme.webseed.fn._template.ftl.java.model;

import me.libme.kernel._c.util.Assert;
import me.libme.kernel._c.util.JClassUtils;
import me.libme.module.spring.mybatis.fn.mark.Table;
import me.libme.webseed.fn._template.ftl.InternalConfig;

import java.util.List;

/**
 * Created by J on 2019/3/7.
 */
public class DefaultModelInfoEnhancer implements ModelInfoEnhancer {

    @Override
    public ModelModel enhance(InternalConfig.ModelConfig modelConfig, ModelModel modelModel) throws Exception {

        Class modelClass=JClassUtils.load(modelModel.getClassName());
        ModelFieldParser modelFieldParser=new DefaultModelFieldParser();
        List<ModelField> modelFields= modelFieldParser.parse(modelClass);
        modelModel.setModelFields(modelFields);

        Table infoTable= (Table) modelClass.getDeclaredAnnotation(Table.class);
        Assert.isTrue(infoTable!=null,"table name is empty.");

        modelModel.setTableName(infoTable.name());

        return modelModel;
    }


}
