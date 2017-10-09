package com.jth.rest.core.test;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.jth.rest.core.rest.Rest;

import io.restassured.specification.RequestSpecification;

@Listeners(AutomationTestNGListener.class)
public class RestTest extends BaseTest {
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		beforeSuite(null);
	}

	protected void beforeSuite(String env) throws IOException {
		RestProperties.Util.loadProperties(env);
		Rest.Util.setup();
	}
	
}
