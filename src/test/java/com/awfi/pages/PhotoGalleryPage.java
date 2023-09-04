package com.awfi.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class PhotoGalleryPage {

	private WebDriver driver;
	private ConfigReader config;

	public PhotoGalleryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(id = "btn-create-photo")
	private WebElement newPhotoBtn;

	@FindBy(id = "PhotoName")
	private WebElement photoNameInput;

	public void enterPhotoName(String name) {
		try {
			photoNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToNewPhoto() {
		try {
			newPhotoBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
