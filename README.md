# __code__template__
jui code template 

Config config=new Config();
config.setModelPath("C:\\java_\\git\\__code__template__\\src\\test\\java\\test\\me\\libme\\webseed\\autogenerator\\demo\\model");
config.setUiRelativePath("C:\\java_\\git\\__code__template__\\src\\test\\java\\test\\me\\libme\\webseed\\autogenerator\\demo\\file");

config.setModuleName("CarManager");

config.addUIField(new Config.FieldConfig("color", "颜色"));
config.addUIField(new FieldConfig("name", "品牌"));
config.addUIField(new FieldConfig("weight", "重量"));
config.addUIField(new FieldConfig("produceTime","出厂时间"));

TemplateRunner.start(config);