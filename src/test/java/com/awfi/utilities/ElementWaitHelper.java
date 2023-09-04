package com.awfi.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.awfi.driver.DriverSetup;

public class ElementWaitHelper {
	private static WebDriverWait wait;
	private WebDriver driver;

	public ElementWaitHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public static void waitAndClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		element.click();
	}

	public static void waitTillElementIsVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void waitForPageToLoad() {
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

	}

	public static void waitTillElementVisibleAndEnterText(By locator, String textInput) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textInput);
	}

	public static void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String waitForElementAndGetText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText().toString();
	}

	public static void implicitWait() {
		DriverSetup.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
