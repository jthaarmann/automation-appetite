package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum DailySummaryPanelPageElements implements PageElements {

	SUNDAY("#sunday_link"), 
	MONDAY("#monday_link"), 
	TUESDAY("#tuesday_link"), 
	WEDNESDAY("#wednesday_link"), 
	THURSDAY("#thursday_link"), 
	FRIDAY("#friday_link"), 
	SATURDAY("#saturday_link")
	;	
	
	private String cssSelector;
	
	private DailySummaryPanelPageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
