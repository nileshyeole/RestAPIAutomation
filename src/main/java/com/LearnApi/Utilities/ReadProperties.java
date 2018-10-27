package com.LearnApi.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.LearnApi.TestBase.IBasePathInterface;

public class ReadProperties {

	public static Properties prop;

	public File loadFile() {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		return new File(classLoader.getResource(IBasePathInterface.CONFIG_FILE).getFile());
	}

	static {
		
		try{
			
			File file = new ReadProperties().loadFile();
			
			prop=new Properties();
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
		}catch(Exception e){
			System.out.println("File not found exception: "+e.getMessage());
		}
		
	}
	
	public static String getProperty(String key){
		return prop.getProperty(key);
	}

}
