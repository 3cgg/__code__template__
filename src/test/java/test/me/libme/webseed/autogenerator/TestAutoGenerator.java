package test.me.libme.webseed.autogenerator;

import static me.libme.webseed.fn._template.ftl.Config.FieldConfig;

import junit.framework.TestCase;
import me.libme.webseed.fn._template.ftl.Config;
import me.libme.webseed.fn._template.ftl.TemplateRunner;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestAutoGenerator extends TestCase {

	
	@Test
	public void testAutoGenerate() throws Exception{
		Config config=new Config();
		config.setModelPath("C:\\java_\\git\\__code__template__\\src\\test\\java\\test\\me\\libme\\webseed\\autogenerator\\demo\\model");

		config.setModuleName("CarManager");

		config.addUIField(new Config.FieldConfig("color", "颜色"));
		config.addUIField(new FieldConfig("name", "品牌"));
		config.addUIField(new FieldConfig("weight", "重量"));
		config.addUIField(new FieldConfig("produceTime","出厂时间"));

		TemplateRunner.start(config);
	}
	
	
}
