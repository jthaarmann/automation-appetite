package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class LoginPageObject {

	public HomePageObject login(String url) {
		navigateToUrl(url);
		return new HomePageObject();
	}
	
	public void navigateToUrl(String url) {
		WebDriverUtil.navigateToUrl(url);		
	}
}
