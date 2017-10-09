package com.jth.rest.core.rest;

import com.jth.rest.core.test.RestProperties;

import io.restassured.RestAssured;

public enum Rest {
	Util;
	
	public void setup() {
		String port = RestProperties.Util.getProperty("rest.port");
		RestAssured.port = Integer.valueOf(port);

		String baseHost = RestProperties.Util.getProperty("rest.host");
		RestAssured.baseURI = baseHost;

		String basePath = RestProperties.Util.getProperty("rest.base");
		RestAssured.basePath = basePath;
	}
}
