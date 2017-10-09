package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class ExercisePageObject {

	public String getPageTitle() {
		return WebDriverUtil.findText(ExercisePageElements.EXERCISE_PAGE_TITLE);
	}
	
	public String getExercisesByTypePanelHeading() {
		return WebDriverUtil.findText(ExercisePageElements.EXERCISES_PANEL_HEADING);
	}
	
	public String getExercisesByDayPanelHeading() {
		return WebDriverUtil.findText(ExercisePageElements.EXERCISES_BY_DAY_PANEL_HEADING);
	}
	
	public String getDailySummaryPanelHeading() {
		return WebDriverUtil.findText(ExercisePageElements.DAILY_SUMMARY_PANEL_HEADING);
	}

}
