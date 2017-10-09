package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum MenuPageElements implements PageElements {
	HOME_MENU_ITEM("#menu_home_link"),
	DIET_MENU_ITEM("#menu_diet_link"),
	EXERCISE_MENU_ITEM("#menu_exercise_link"),
	;

	private String cssSelector;
	
	private MenuPageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
