package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class ExercisesByTypePageObject {

	public String getButtonLabel() {
		return WebDriverUtil.findText(ExercisesByTypePageElements.BUTTON_LABEL);
	}

	public String getEnduranceChartLabel() {
		return WebDriverUtil.findText(ExercisesByTypePageElements.CHART_LABEL_ENDURANCE);
	}

	public String getStrengthChartLabel() {
		return WebDriverUtil.findText(ExercisesByTypePageElements.CHART_LABEL_STRENGTH);
	}

	public String getFlexibilityChartLabel() {
		return WebDriverUtil.findText(ExercisesByTypePageElements.CHART_LABEL_FLEXIBILITY);
	}

	public String getBalanceChartLabel() {
		return WebDriverUtil.findText(ExercisesByTypePageElements.CHART_LABEL_BALANCE);
	}

}
