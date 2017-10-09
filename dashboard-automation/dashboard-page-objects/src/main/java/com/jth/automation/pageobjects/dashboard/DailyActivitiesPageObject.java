package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class DailyActivitiesPageObject {

	public String getPageTitle() {
		return WebDriverUtil.findText(DailyActivitiesPageElements.PAGE_TITLE);
	}
	
	public String getDietPanelHeading() {
		return WebDriverUtil.findText(DailyActivitiesPageElements.DIET_PANEL_HEADING);
	}
	
	public String getExercisePanelHeading() {
		return WebDriverUtil.findText(DailyActivitiesPageElements.EXERCISE_PANEL_HEADING);
	}

}
