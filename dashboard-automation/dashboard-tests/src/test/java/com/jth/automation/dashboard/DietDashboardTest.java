package com.jth.automation.dashboard;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jth.automation.core.test.BaseTest;
import com.jth.automation.pageobjects.dashboard.DietPageObject;
import com.jth.automation.pageobjects.dashboard.HomePageObject;
import com.jth.automation.pageobjects.dashboard.LoginPageObject;

public class DietDashboardTest extends BaseTest{
	private LoginPageObject loginPage;
	private DietPageObject dietPage;
	private HomePageObject homePage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPageObject();
		homePage = loginPage.login(getTestData(LoginTestData.DASHBOARD_URL));
	}
	
	@Test
	public void testDietPage_renders() throws InterruptedException {
		// given

		// when
		dietPage = homePage.clickDietMenu();

		// then
		assertEquals("Diet (Past Week)", dietPage.getPageTitle());
	}
	
	@Test
	public void testDietPage_containsPortionsPanel() throws InterruptedException {
		// given
		
		// when
		dietPage = homePage.clickDietMenu();
		
		// then
		assertEquals("Portions By Food Group", dietPage.getPortionsPanelHeading());
	}
	
	@Test
	public void testDietPage_containsVegetablesPanel() throws InterruptedException {
		// given
		
		// when
		dietPage = homePage.clickDietMenu();
		
		// then
		assertEquals("Vegetables", dietPage.getVegetablesPanelHeading());
	}
	
	@Test
	public void testDietPage_containsDailySummaryPanel() throws InterruptedException {
		// given
		
		// when
		dietPage = homePage.clickDietMenu();
		
		// then
		assertEquals("Daily Summary", dietPage.getDailySummaryPanelHeading());
	}
		
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage.logout();
	}
	
}
