package com.jth.rest.core.test;

import org.testng.annotations.Listeners;

@Listeners(AutomationTestNGListener.class)
public class BaseTest {

	public String getTestData(String key) {
		return RestProperties.Util.getProperty(key);
	}

}
