package com.jth.automation.pageobjects.dashboard;

import com.jth.automation.core.ui.WebDriverUtil;

public class HomePageObject {

	public DietPageObject clickDietMenu() {
		WebDriverUtil.click(MenuPageElements.DIET_MENU_ITEM);
		return new DietPageObject();
	}
	
	public DietPageObject clickHomeMenu() {
		WebDriverUtil.click(MenuPageElements.HOME_MENU_ITEM);
		return new DietPageObject();
	}
	
	public ExercisePageObject clickExerciseMenu() {
		WebDriverUtil.click(MenuPageElements.EXERCISE_MENU_ITEM);
		return new ExercisePageObject();
	}

	public void logout() {
		clickHomeMenu(); //TODO change this process once we have authentication
	}
}
