package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum DietPageElements implements PageElements {
	
	DIET_PAGE_TITLE("#root > div > div > div > div:nth-child(1) > div > h1"), 
	PORTIONS_PANEL_HEADING("#portions_panel > div.panel-heading"),
	VEGETABLES_PANEL_HEADING("#vegetables_panel > div.panel-heading"),
	DAILY_SUMMARY_PANEL_HEADING("#daily_summary_panel > div.panel-heading")
	;	

	
	private String cssSelector;
	
	private DietPageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
