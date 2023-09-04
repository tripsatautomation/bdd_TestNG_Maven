package com.awfi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;

public class MaterialQuantityPage {

	private WebDriver driver;

	public MaterialQuantityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "btn-create")
	private WebElement createBtn;

	@FindBy(id = "Save")
	private WebElement saveBtn;

	@FindBy(id = "OneSidedArea")
	private WebElement oneSidedFinishingTextInput;

	@FindBy(id = "TwoSidedArea")
	private WebElement twoSidedFinishingTextInput;

	public void enterTwoSidedFinishingSqFt(String sqft) {
		try {
			twoSidedFinishingTextInput.sendKeys(sqft);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterOneSidedFinishingSqFt(String sqft) {
		try {
			oneSidedFinishingTextInput.sendKeys(sqft);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectProcessSystem(String process) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//span[text='Process System (Name or #)']")));
			String xpath = "//div[text()='" + process + "']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveSubStep() {
		try {
			ElementWaitHelper.waitAndClick(saveBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
