package com.jth.automation.dashboard;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jth.automation.core.test.BaseTest;
import com.jth.automation.pageobjects.dashboard.DailyActivitiesPageObject;
import com.jth.automation.pageobjects.dashboard.DailySummaryPanelPageObject;
import com.jth.automation.pageobjects.dashboard.DietPageObject;
import com.jth.automation.pageobjects.dashboard.HomePageObject;
import com.jth.automation.pageobjects.dashboard.LoginPageObject;

public class DailyActivitiesTest extends BaseTest {

	private LoginPageObject loginPage;
	private DietPageObject dietPage;
	private HomePageObject homePage;
	private DailySummaryPanelPageObject dailySummaryPanel;
	private DailyActivitiesPageObject dailyActivitiesPage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPageObject();
		homePage = loginPage.login(getTestData(LoginTestData.DASHBOARD_URL));
	}

	private DailyActivitiesPageObject navigateToDailyActivitiesPage() {
		dietPage = homePage.clickDietMenu();
		dailySummaryPanel = dietPage.getDailySummaryPanel();
		dailyActivitiesPage = dailySummaryPanel.clickSaturday();
		return dailyActivitiesPage;
	}
	
	@Test
	public void testDailyActivitiesPage_renders() throws InterruptedException {
		// given

		// when
		dailyActivitiesPage = navigateToDailyActivitiesPage();
		
		// then
		assertEquals("Saturday", dailyActivitiesPage.getPageTitle());
	}
	
	@Test
	public void testDailyActivitiesPage_rendersDietPanel() throws InterruptedException {
		// given
		
		// when
		dailyActivitiesPage = navigateToDailyActivitiesPage();
		
		// then
		assertEquals("Diet", dailyActivitiesPage.getDietPanelHeading());
	}
	
	@Test
	public void testDailyActivitiesPage_rendersExercisePanel() throws InterruptedException {
		// given
		
		// when
		dailyActivitiesPage = navigateToDailyActivitiesPage();
		
		// then
		assertEquals("Exercises", dailyActivitiesPage.getExercisePanelHeading());
	}
}
