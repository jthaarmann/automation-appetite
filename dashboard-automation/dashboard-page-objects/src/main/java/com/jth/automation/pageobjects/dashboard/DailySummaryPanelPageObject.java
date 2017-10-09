package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class DailySummaryPanelPageObject {

	public DailyActivitiesPageObject clickSunday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.SUNDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickMonday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.MONDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickTuesday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.TUESDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickWednesday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.WEDNESDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickThursday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.THURSDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickFriday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.FRIDAY);
		return new DailyActivitiesPageObject();
	}
	
	public DailyActivitiesPageObject clickSaturday() {
		WebDriverUtil.click(DailySummaryPanelPageElements.SATURDAY);
		return new DailyActivitiesPageObject();
	}
}
