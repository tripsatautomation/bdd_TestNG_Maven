package com.awfi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class ReportsPage {

	private WebDriver driver;
	private ConfigReader config;

	public ReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}


	@FindBy(xpath = "//a[text()='Reports ']")
	private WebElement reportLink;

	@FindBy(xpath = "//a[text()='Equipment Inventory Report']")
	private WebElement equipmentInventoryReportLink;
	
	@FindBy(xpath="//a[text()='Sundry Inventory Report']")
	private WebElement sundryInventoryReportLink;
	
	@FindBy(xpath="//a[text()='Environmental Report']")
	private WebElement environmentalReportLink;

	public void goToEnvironmentalInventoryReport() {
		try {
			goToReport();
			ElementWaitHelper.waitAndClick(environmentalReportLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToEquipmentInventoryReport() {
		try {
			goToReport();
			ElementWaitHelper.waitAndClick(equipmentInventoryReportLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToSundryInventoryReport() {
		try {
			goToReport();
			ElementWaitHelper.waitAndClick(sundryInventoryReportLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void goToReport() {
		ElementWaitHelper.waitAndClick(reportLink);
	}

	@FindBy(xpath = "//a[text()='+/- Adjust ']")
	private WebElement totalInventoryOnHandLink;

	

	
	public boolean correctGroupSelected(String groupname) {
		boolean isCorrect = false;
		try {
			String xpath = "//span[text()='" + groupname + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isCorrect = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCorrect;
	}

}
