package me.libme.webseed.fn._template.ftl;

import me.libme.kernel._c.tkdd.MetadataHierarchyOnTask;
import me.libme.kernel._c.tkdd.MetadataOnTask;
import me.libme.kernel._c.tkdd.TaskExecutionException;
import me.libme.kernel._c.util.JIOUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@MetadataHierarchyOnTask
@MetadataOnTask
public class FileWriterTask extends TemplateTask{


	@Override
	public Object doRun() throws Exception {
		
		List<FileWrapper> fileWrappers= getInternalConfig().files();
		
		List<FileWrapper> targetFileWrappers= new ArrayList<>();
		for(FileWrapper fileWrapper:fileWrappers){
			if(getConfig().isJavaCode()){
				if(fileWrapper.getFile().getName().endsWith(".java")){
					targetFileWrappers.add(fileWrapper);
				}
			}
			if(getConfig().isMapperXmlCode()){
				if(fileWrapper.getFile().getName().endsWith(".xml")){
					targetFileWrappers.add(fileWrapper);
				}
			}
			if(getConfig().isUiCode()){
				if(fileWrapper.getFile().getName().endsWith(".html")){
					targetFileWrappers.add(fileWrapper);
				}
			}
		}
		
		for(FileWrapper fileWrapper:targetFileWrappers){
			File file=fileWrapper.getFile();
			if(file.exists()){
				throw new TaskExecutionException("file already exists.["+file.getName()+"], please change your file name to another");
			}
		}
		
		for(FileWrapper fileWrapper:targetFileWrappers){
			File file=fileWrapper.getFile();
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			JIOUtils.write(file, fileWrapper.getData());
			notify("\r\nwrite file success : "+file.getAbsolutePath());
		}
        return true;
	}

}
