package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum DailyActivitiesPageElements implements PageElements {

	PAGE_TITLE("#dayPageTitle > div > h1"),
	DIET_PANEL_HEADING("#daily_foodItems > div.panel-heading"),
	EXERCISE_PANEL_HEADING("#daily_exercises > div.panel-heading")
	;	
	
	private String cssSelector;
	
	private DailyActivitiesPageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
