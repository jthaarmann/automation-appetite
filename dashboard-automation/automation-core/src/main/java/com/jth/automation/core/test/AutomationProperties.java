package com.jth.automation.core.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum AutomationProperties {

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
		
		InputStream user = Thread.currentThread().getContextClassLoader().getResourceAsStream(env + "/automation.user.properties");
		if(user != null) properties.load(user);
		InputStream data = Thread.currentThread().getContextClassLoader().getResourceAsStream(env + "/automation.data.properties");
		if(data != null) properties.load(data);
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
