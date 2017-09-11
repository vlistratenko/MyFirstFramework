package com.vitalii.vitaliiFramework2.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configurations {
	
	public static final String PROPERTIES_FILE_NAME = "Configuration.properties";
	static Properties properties  = new Properties();
	static String defaultEnvironment = System.getProperty("environment");
	private Logger logger; 
		 
	public Configurations () {
		this.logger = Logger.getLogger(Configurations.class);
		try {
			InputStream locator = new FileInputStream(System.getProperty("user.dir") + "\\" + PROPERTIES_FILE_NAME);
			properties.load(locator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public static String getProperty(String propertyName) {
		Configurations conf = new Configurations(); //created just for initialization of the constructor above. TODO: move to @before method
		return properties.getProperty(propertyName);
	}
	
	public static String getEnvironmentUrl() {
			switch (defaultEnvironment) {
			case "dev":
				return getProperty("DevEnvironmentUrl");
			case "test":
				return getProperty("TestEnvironmentUrl");
			case "uat":
				return getProperty("UatEnvironmentUrl");
			case "prod":
				return getProperty("ProdEnvironmentUrl");
			default: return getProperty("TestEnvironmentUrl");
			}
	}
}
