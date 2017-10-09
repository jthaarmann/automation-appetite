package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.PageElements;

public enum ExercisesByTypePageElements implements PageElements {
	
	BUTTON_LABEL("#exercise_panel > div.panel-body > a > button"), 
	CHART_LABEL_ENDURANCE("#exercise_panel > div.panel-body > div > svg > g > g.recharts-layer.recharts-pie-labels > g:nth-child(3) > text"), 
	CHART_LABEL_STRENGTH("#exercise_panel > div.panel-body > div > svg > g > g.recharts-layer.recharts-pie-labels > g:nth-child(2) > text"), 
	CHART_LABEL_FLEXIBILITY("#exercise_panel > div.panel-body > div > svg > g > g.recharts-layer.recharts-pie-labels > g:nth-child(4) > text"), 
	CHART_LABEL_BALANCE("#exercise_panel > div.panel-body > div > svg > g > g.recharts-layer.recharts-pie-labels > g:nth-child(1) > text")
	;	
	
	private String cssSelector;
	
	private ExercisesByTypePageElements(String cssSelector){
		this.cssSelector = cssSelector;
	}
	
	public String getCssSelector(){
		return cssSelector;
	}

}
