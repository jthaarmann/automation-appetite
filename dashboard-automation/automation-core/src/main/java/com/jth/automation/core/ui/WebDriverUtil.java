package com.jth.automation.core.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverUtil {
	private WebDriverUtil() {
	}

	private static WebDriver webDriver = null;

	private static int DEFAULT_MAX_VALIDATE_WAIT = 20;

	static {
		webDriver = UiWebDriver.fromBrowserName(System.getProperty("browser")).getWebDriver();
	}

	public static void quit() {
		webDriver.quit();
	}

	/**
	 * Close the current tab or window and return web driver control to the last tab or window that was opened
	 * (assuming the window handles are kept in a linked set in implementation of web driver).
	 */
	public static void closeCurrentTab(){
		webDriver.close();
		Set<String> handles = webDriver.getWindowHandles();
		if( handles != null && !handles.isEmpty() ) {
			webDriver.switchTo().window((String) handles.toArray()[handles.size() - 1]);
		}
	}

	/**
	 * Close the current tab or window and switch to the specified window by title or internal handle id
	 * @param switchToWindowTitle Window title for specific window
	 *                            that should receive control
	 */
	public static void closeCurrentTab(String switchToWindowTitle) throws InterruptedException {
		webDriver.close();
		if( switchToWindowTitle != null ) {
			findWindowByTitle(switchToWindowTitle);
		}
	}

	public static void navigateToUrl(String url) {
		webDriver.get(url);
	}

	public static String getUrl() {
		return webDriver.getCurrentUrl();
	}

	public static void enterText(PageElements rfsElement, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())).clear();
		webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())).sendKeys(text);
	}

	public static void enterSelectValue(PageElements rfsElement, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		Select selectElement = new Select(webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())));
		selectElement.selectByValue(text);
	}

	public static void enterSelectText(PageElements rfsElement, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		Select selectElement = new Select(webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())));
		selectElement.selectByVisibleText(text);
	}

	public static void enterSelectIndex(PageElements rfsElement, int index) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		Select selectElement = new Select(webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())));
		selectElement.selectByIndex(index);
	}

	// TODO it doesn't actually return false, just times out for now, we may
	// want to look at functionality to check if btn is greyed out versus not
	// displayed on screen
	public static boolean isClickable(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		return webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))) != null;
	}

	public static boolean isEnabled(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rfsElement.getCssSelector())));
		return webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))).isEnabled();
	}

	public static boolean isDisplayed(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rfsElement.getCssSelector())));
		return webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))).isDisplayed();
	}

	public static boolean isChecked(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rfsElement.getCssSelector())));
		String isChecked = webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))).getAttribute("checked");
		if( isChecked != null ){
			return Boolean.parseBoolean(isChecked);
		}
		return Boolean.FALSE;
	}

	public static boolean doesElementExist(PageElements rfsElements){
		try{
			WebElement element = webDriver.findElement(By.cssSelector(rfsElements.getCssSelector()));
			return Boolean.TRUE;
		}
		catch(NoSuchElementException e){
			return Boolean.FALSE;
		}
	}

	public static void click(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		WebElement element;
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		element.click();
	}

	public static void clickById(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		WebElement element;
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id(rfsElement.getCssSelector())));
		element.click();
	}

	public static String findText(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		return webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))).getText();
	}

	public static List<String> findTextAllElements(PageElements rfsElement) {
		LinkedList<String> textList = new LinkedList<>();
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		for (WebElement webElement : webDriver.findElements((By.cssSelector(rfsElement.getCssSelector())))) {
			textList.add(webElement.getText());
		}
		return textList;
	}

	public static Integer findCount(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		List<WebElement> elements = webDriver.findElements((By.cssSelector(rfsElement.getCssSelector())));
		return elements.size();
	}

	public static String getTextOfSelect(PageElements rfsElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		Select selectElement = new Select(webDriver.findElement(By.cssSelector(rfsElement.getCssSelector())));
		WebElement selectedOption = selectElement.getFirstSelectedOption();
		return selectedOption.getText();
	}

	public static void setUploadFile(PageElements rfsElement, String fileName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsElement.getCssSelector())));
		CharSequence fileNameCharSequence = fileName.subSequence(0, fileName.length());
		webDriver.findElement((By.cssSelector(rfsElement.getCssSelector()))).sendKeys(fileNameCharSequence);
	}

	public static boolean findWindowByTitle(String title) throws InterruptedException {
		Thread.sleep(1000);
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			String windowTitle = webDriver.getTitle();
			if (windowTitle.contains(title)) {
				return true;
			}
		}
		return false;
	}

	public static void switchToFrame(PageFrames rfsPageFrame) {
		switchToDefaultFrame();
		for (int framesToNavigateTo : rfsPageFrame.getFrameNumber()) {
			WebElement frame = webDriver.findElements(By.tagName("frame")).get(framesToNavigateTo);
			webDriver.switchTo().frame(frame);
		}
	}

	public static void switchToFrameById(PageFrames rfsPageFrame) {
		switchToDefaultFrame();
		List<WebElement> frameList = webDriver.findElements(By.id("ISCNavigation"));
		webDriver.switchTo().frame(frameList.get(0));
	}

	public static void switchToIFrame(PageFrames rfsPageFrame) {
		switchToDefaultFrame();
		for (int framesToNavigateTo : rfsPageFrame.getFrameNumber()) {
			WebElement frame = webDriver.findElements(By.tagName("iframe")).get(framesToNavigateTo);
			webDriver.switchTo().frame(frame);
		}
	}

	public static void switchToDefaultFrame() {
		webDriver.switchTo().defaultContent();
	}

	public static void pressDownArrowAndEnter() {
		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
	}

	public static List<String> getDropDownOptions(PageElements rfsElement) {
		WebElement selectElement = webDriver.findElement((By.cssSelector(rfsElement.getCssSelector())));
		Select select = new Select(selectElement);
		List<String> listOfOptionValues = new ArrayList<String>();
		for (WebElement option : select.getOptions()) {
			listOfOptionValues.add(option.getText());
		}
		return listOfOptionValues;
	}

	public static void selectDropDownOptionValue(PageElements rfsElement, String value) {
		WebElement selectElement = webDriver.findElement((By.cssSelector(rfsElement.getCssSelector())));
		Select select = new Select(selectElement);
		select.selectByValue(value);
	}

	public static Boolean validateWithClick(PageElements clickSafeElement, int maxWaitInSeconds) {
		int i = 0;
		Boolean clicked = Boolean.FALSE;
		maxWaitInSeconds *= 10;
		do {
			try {
				click(clickSafeElement);
				i = maxWaitInSeconds;
				clicked = Boolean.TRUE;
			} catch (Exception e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
				}
			}
			i++;

		} while (i < maxWaitInSeconds);
		return clicked;
	}

	public static Boolean validateWithClick(PageElements clickSafeElement) {
		return validateWithClick(clickSafeElement, DEFAULT_MAX_VALIDATE_WAIT);
	}

	public static void pressTab() {
		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public static void hoverOver(PageElements rfsPageElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rfsPageElement.getCssSelector())));
		Actions a1 = new Actions(webDriver);
		a1.moveToElement(webDriver.findElement(By.cssSelector(rfsPageElement.getCssSelector()))).build()
				.perform();
	}
	
	public static String hoverOver(PageElements rfsElement, PageElements dashboardPageElements){
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(dashboardPageElements.getCssSelector())));
		Actions a1 = new Actions(webDriver);
	    a1.moveToElement(webDriver.findElement(By.cssSelector(dashboardPageElements.getCssSelector()))).build().perform();
	    return findText(rfsElement);
	}

}
