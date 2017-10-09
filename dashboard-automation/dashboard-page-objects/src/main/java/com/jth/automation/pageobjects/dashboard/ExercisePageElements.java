package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum ExercisePageElements implements PageElements {
	
	EXERCISE_PAGE_TITLE("#root > div > div > div > div:nth-child(1) > div > h1"), 
	EXERCISES_PANEL_HEADING("#exercise_panel > div.panel-heading"),
	EXERCISES_BY_DAY_PANEL_HEADING("#exerciseByDay_Panel > div.panel-heading"),
	DAILY_SUMMARY_PANEL_HEADING("#daily_summary_panel > div.panel-heading")
	;	

	
	private String cssSelector;
	
	private ExercisePageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
