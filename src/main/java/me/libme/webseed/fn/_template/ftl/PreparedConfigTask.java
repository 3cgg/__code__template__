
package me.libme.webseed.fn._template.ftl;

import com.fasterxml.jackson.core.type.TypeReference;
import me.libme.kernel._c.json.JJSON;
import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.kernel._c.util.JIOUtils;
import me.libme.kernel._c.util.JStringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static me.libme.webseed.fn._template.ftl.Config.FieldConfig;

@MetadataHierarchyOnTask
@MetadataOnTask
public class PreparedConfigTask extends TemplateTask {

	@Override
	protected Object doRun() throws Exception {
		
		Config config=getConfig();

		if(JStringUtils.isNullOrEmpty(config.getUiRelativePath())){
			throw new IllegalArgumentException("ui relative path is missing ... ");
		}

		List<FieldConfig> fieldConfigs= JJSON.get().parse(
				new String(JIOUtils.getBytes(Config.class.getResourceAsStream("fieldconfig.json")),"utf-8" ),
				new TypeReference<ArrayList<FieldConfig>>() {});
		for(FieldConfig fieldConfig:fieldConfigs){
			if(config.getUIField(fieldConfig.getProperty())==null){
				config.addUIField(fieldConfig);
			}
		}
		
		Class<? extends InternalConfigStrategy> clazz= getConfig().getInternalConfigStrategyClass();
		InternalConfigStrategy configStrategy= clazz.newInstance();
		InternalConfig internalConfig=configStrategy.config(getFlowContext());
		setInternalConfig(internalConfig);
		return null;
	}
	
	
	public static void main(String[] args) throws Exception {
		List<FieldConfig> fieldConfigs=new ArrayList<>();
		fieldConfigs.add(new FieldConfig("createTimeStart", "创建时间（起）",KeyNames.FIELD_TYPE_DATE));
		fieldConfigs.add(new FieldConfig("createTimeEnd", "创建时间（止）",KeyNames.FIELD_TYPE_DATE));
		fieldConfigs.add(new FieldConfig("updateTimeStart", "更新时间（起）",KeyNames.FIELD_TYPE_DATE));
		fieldConfigs.add(new FieldConfig("updateTimeEnd", "更新时间（止）",KeyNames.FIELD_TYPE_DATE));
		fieldConfigs.add(new FieldConfig("description", "描述",KeyNames.FIELD_TYPE_STRING));
		fieldConfigs.add(new FieldConfig("status", "状态",KeyNames.FIELD_TYPE_STRING));
		fieldConfigs.add(new FieldConfig("code", "编码",KeyNames.FIELD_TYPE_STRING));
		fieldConfigs.add(new FieldConfig("name", "名称",KeyNames.FIELD_TYPE_STRING));
		fieldConfigs.add(new FieldConfig("meta", "数据结构（元数据）",KeyNames.FIELD_TYPE_STRING));
		fieldConfigs.add(new FieldConfig("recordTime", "记录时间",KeyNames.FIELD_TYPE_DATE));
		String data= JJSON.get().formatObject(fieldConfigs);
		System.out.println(JJSON.get().formatObject(data));
		
		JIOUtils.write(new File("D:\\java_\\git-project\\YouAPP\\youappweb\\youapp-webcenter\\src\\main\\java\\com\\youappcorp\\template\\ftl\\fieldconfig.json"), data.getBytes("utf-8"));
	}

}
