package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class DietPageObject {

	public String getPageTitle() {
		return WebDriverUtil.findText(DietPageElements.DIET_PAGE_TITLE);
	}
	
	public String getPortionsPanelHeading() {
		return WebDriverUtil.findText(DietPageElements.PORTIONS_PANEL_HEADING);
	}
	
	public String getVegetablesPanelHeading() {
		return WebDriverUtil.findText(DietPageElements.VEGETABLES_PANEL_HEADING);
	}
	
	public String getDailySummaryPanelHeading() {
		return WebDriverUtil.findText(DietPageElements.DAILY_SUMMARY_PANEL_HEADING);
	}
	
	public DailySummaryPanelPageObject getDailySummaryPanel() {
		WebDriverUtil.findText(DietPageElements.DAILY_SUMMARY_PANEL_HEADING);
		return new DailySummaryPanelPageObject();
	}

}
