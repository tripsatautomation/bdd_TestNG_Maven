package com.awfi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class AWFILoginPage {

	private WebDriver driver;
	private ElementWaitHelper elementWait;

	public AWFILoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		elementWait = new ElementWaitHelper(driver);
	}

	@FindBy(id = "UserName")
	private WebElement usernameInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn;

	public void login(String username, String password) {
		try {
			ElementWaitHelper.waitTillElementVisible(usernameInput);
			usernameInput.clear();
			usernameInput.sendKeys(username);
			ElementWaitHelper.waitTillElementVisible(passwordInput);
			passwordInput.clear();
			passwordInput.sendKeys(password);
			ElementWaitHelper.waitAndClick(signInBtn);
			elementWait.implicitWait();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
