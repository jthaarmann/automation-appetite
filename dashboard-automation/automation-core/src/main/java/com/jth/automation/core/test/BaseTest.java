package com.jth.automation.core.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.jth.automation.core.ui.UiWebDriver;

@Listeners(AutomationTestNGListener.class)
public abstract class BaseTest {

	@BeforeSuite
	protected void beforeSuite() throws IOException {
		beforeSuite(null);
	}
	
	public String getTestData(String key) {
		return AutomationProperties.Util.getProperty(key);
	}

	protected void beforeSuite(String env) throws IOException {
		AutomationProperties.Util.loadProperties(env);
		for(UiWebDriver driver: UiWebDriver.values()) {
			if(StringUtils.isNotBlank(driver.getDriverFilePath())){
				System.setProperty(driver.getDriverSystemPath(), getDriverPath(driver));
			}
		}
	}

	private File extractWebDriver(UiWebDriver driver) throws IOException {
		InputStream driverStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(driver.getDriverFilePath());
		File tempFile = File.createTempFile("tempDriver_" + driver.getBrowserName(), "exe");
		tempFile.deleteOnExit();
		tempFile.setExecutable(true);
		FileUtils.copyInputStreamToFile(driverStream, tempFile);
		return tempFile;
	}

	private String getDriverPath(UiWebDriver driver) {
		String path = System.getProperty("driverLocation");
		if(path == null) {
			try {
				File driverFile = extractWebDriver(driver);
				path = driverFile.getAbsolutePath();
			} catch (IOException e) {
				e.printStackTrace();
				path = Thread.currentThread().getContextClassLoader().getResource(driver.getDriverFilePath()).getPath();
			}

		}
		return path;
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		for (UiWebDriver rfsWebDriver : UiWebDriver.values()) {
			if( rfsWebDriver.webDriverRunning() )
				rfsWebDriver.quit();
		}
	}

}