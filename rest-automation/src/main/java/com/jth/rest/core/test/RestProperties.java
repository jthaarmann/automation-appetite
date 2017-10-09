package com.jth.rest.core.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum RestProperties {

	Util;
	
	private Properties properties;
	
	public void loadProperties(String env) throws IOException {
		properties = new Properties();
		if(env == null) {
			env = System.getProperty("env");
			if (env == null)
				env = "dev";//default environment to dev
		}
		properties.setProperty("env", env);
		
		InputStream data = Thread.currentThread().getContextClassLoader().getResourceAsStream(env + "/automation.data.properties");
		if(data != null) properties.load(data);
		InputStream rest = Thread.currentThread().getContextClassLoader().getResourceAsStream(env + "/automation.rest.properties");
		if(rest != null) properties.load(rest);
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
