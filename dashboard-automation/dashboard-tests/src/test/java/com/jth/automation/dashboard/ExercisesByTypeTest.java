package com.jth.automation.dashboard;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jth.automation.core.test.BaseTest;
import com.jth.automation.pageobjects.dashboard.ExercisePageObject;
import com.jth.automation.pageobjects.dashboard.ExercisesByTypePageObject;
import com.jth.automation.pageobjects.dashboard.HomePageObject;
import com.jth.automation.pageobjects.dashboard.LoginPageObject;

public class ExercisesByTypeTest extends BaseTest {

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ExercisePageObject exercisePage;
	private ExercisesByTypePageObject exercisesByTypePage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPageObject();
		homePage = loginPage.login(getTestData(LoginTestData.DASHBOARD_URL));
	}

	private ExercisesByTypePageObject navigateToExercisesByTypePage() {
		exercisePage = homePage.clickExerciseMenu();
		exercisesByTypePage = exercisePage.getExercisesByTypePanel();
		return exercisesByTypePage;
	}
	
	@Test
	public void testExercisesByTypePage_rendersEnduranceChartLabel() throws InterruptedException {
		// given
		
		// when
		exercisesByTypePage = navigateToExercisesByTypePage();
		
		// then
		assertEquals("Endurance - 6", exercisesByTypePage.getEnduranceChartLabel());
	}
	@Test
	public void testExercisesByTypePage_rendersStrengthChartLabel() throws InterruptedException {
		// given
		
		// when
		exercisesByTypePage = navigateToExercisesByTypePage();
		
		// then
		assertEquals("Strength - 2", exercisesByTypePage.getStrengthChartLabel());
	}
	@Test
	public void testExercisesByTypePage_rendersFlexibilityChartLabel() throws InterruptedException {
		// given
		
		// when
		exercisesByTypePage = navigateToExercisesByTypePage();
		
		// then
		assertEquals("Flexibility - 7", exercisesByTypePage.getFlexibilityChartLabel());
	}

	@Test
	public void testExercisesByTypePage_rendersBalanceChartLabel() throws InterruptedException {
		// given
		
		// when
		exercisesByTypePage = navigateToExercisesByTypePage();
		
		// then
		assertEquals("Balance - 3", exercisesByTypePage.getBalanceChartLabel());
	}
	
	@Test
	public void testExercisesByTypePage_rendersButton() throws InterruptedException {
		// given
		
		// when
		exercisesByTypePage = navigateToExercisesByTypePage();
		
		// then
		assertEquals("Total Count: 18", exercisesByTypePage.getButtonLabel());
	}
}
