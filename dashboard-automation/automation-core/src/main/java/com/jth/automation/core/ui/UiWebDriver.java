package com.jth.automation.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum UiWebDriver {
	CHROME(ChromeDriver.class, "CHROME", "drivers/chromedriver.exe", "webdriver.chrome.driver"),
	IE(InternetExplorerDriver.class, "IE", "drivers/IEDriverServer.exe", "webdriver.ie.driver"),
	EDGE(InternetExplorerDriver.class, "EDGE", "", ""),	//TODO: add IE Edge driver if available
	FIREFOX(ChromeDriver.class, "SAFARI", "", ""),		//TODO: add Firefox driver if available
	SAFARI(ChromeDriver.class, "FIREFOX", "", "");			//TODO: add Safari driver if available
	
	private WebDriver webDriver = null;
	private String browserName = "";
	private String driverFilePath = "";
	private String driverSystemPath = "";
	private Class<? extends WebDriver> driverClass;
	
	UiWebDriver(Class<? extends WebDriver> driverClass, String browserName, String driverPath, String driverSystemPath){
		this.driverClass = driverClass;
		this.browserName= browserName;
		this.driverFilePath = driverPath;
		this.driverSystemPath = driverSystemPath;
	}
	
	public boolean webDriverRunning(){
		return this.webDriver != null;
	}
	
	public static UiWebDriver fromBrowserName(String browserName){
		UiWebDriver rfsWebDriver = UiWebDriver.CHROME; //default to Chrome
		for(UiWebDriver driver: UiWebDriver.values()) {
			if(driver.getBrowserName().equalsIgnoreCase(browserName)){
				rfsWebDriver = driver;
			}
		}
		return rfsWebDriver;
	}
	
	public String getBrowserName(){
		return this.browserName;
	}
	
	public WebDriver getWebDriver() {
		if( this.webDriver == null ){
			try {
				this.webDriver = this.driverClass.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.webDriver;
	}

	public String getDriverFilePath(){
		return driverFilePath;
	}

	public String getDriverSystemPath(){
		return driverSystemPath;
	}

	public void quit() {
		this.webDriver.quit();
		this.webDriver = null; 
	}
}
