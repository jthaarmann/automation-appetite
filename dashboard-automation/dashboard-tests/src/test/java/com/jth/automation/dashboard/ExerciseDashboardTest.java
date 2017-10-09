package com.jth.automation.dashboard;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jth.automation.core.test.BaseTest;
import com.jth.automation.pageobjects.dashboard.ExercisePageObject;
import com.jth.automation.pageobjects.dashboard.HomePageObject;
import com.jth.automation.pageobjects.dashboard.LoginPageObject;

public class ExerciseDashboardTest extends BaseTest{
	private LoginPageObject loginPage;
	private ExercisePageObject exercisePage;
	private HomePageObject homePage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPageObject();
		homePage = loginPage.login(getTestData(LoginTestData.DASHBOARD_URL));
	}
	
	@Test
	public void testExercisePage_renders() throws InterruptedException {
		// given

		// when
		exercisePage = homePage.clickExerciseMenu();

		// then
		assertEquals("Exercise (Past Week)", exercisePage.getPageTitle());
	}
	
	@Test
	public void testExercisePage_containsExercisesByDay() throws InterruptedException {
		// given
		
		// when
		exercisePage = homePage.clickExerciseMenu();
		
		// then
		assertEquals("Exercise By Day", exercisePage.getExercisesByDayPanelHeading());
	}
	
	@Test
	public void testExercisePage_containsExerciseByTypePanel() throws InterruptedException {
		// given
		
		// when
		exercisePage = homePage.clickExerciseMenu();
		
		// then
		assertEquals("Exercise By Types", exercisePage.getExercisesByTypePanelHeading());
	}
	
	@Test
	public void testExercisePage_containsDailySummaryPanel() throws InterruptedException {
		// given
		
		// when
		exercisePage = homePage.clickExerciseMenu();
		
		// then
		assertEquals("Daily Summary", exercisePage.getDailySummaryPanelHeading());
	}
		
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage.logout();
	}
	
}
