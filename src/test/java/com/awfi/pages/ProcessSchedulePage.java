package com.awfi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class ProcessSchedulePage {

	private WebDriver driver;
	private ConfigReader config;

	public ProcessSchedulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(id = "btn-create")
	private WebElement createBtn;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(id = "Name")
	private WebElement processScheduleNameInput;

	@FindBy(id = "CustomerName")
	private WebElement processCustomerNameInput;

	@FindBy(xpath = "//span[text()='add ']")
	private WebElement addStepsBtn;

	@FindBy(id = "Number")
	private WebElement processScheduleNumberInput;

	
	public void goToProcessSchedule() {
		driver.navigate().to(config.getProperty("processscheduleurl"));
	}
	
	public void createNewProcessSchedule(String processschedulename,String processschedulenumber, String customername ) {
		try {
			goToCreateProcessSchedule();
			Thread.sleep(4000);
			enterProcessScheduleName(processschedulename);
			enterProcessScheduleNumber(processschedulenumber);
			enterCustomerName(customername);
			Thread.sleep(4000);
			selectAvailableStep();
			Thread.sleep(4000);
			addStep();
			saveProcessSchedule();
			Thread.sleep(4000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveProcessSchedule() {
		ElementWaitHelper.waitAndClick(saveBtn);
	}

	public void enterCustomerName(String name) {
		try {
			processCustomerNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToCreateProcessSchedule() {
		ElementWaitHelper.waitAndClick(createBtn);
	}

	public void enterProcessScheduleNumber(String number) {
		try {
			processScheduleNumberInput.sendKeys(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterProcessScheduleName(String name) {
		try {
			processScheduleNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStep() {
		try {
			ElementWaitHelper.waitAndClick(addStepsBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAvailableStep() {
		try {
			String xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[2]/div/ins";
			if (!driver.findElement(By.xpath(xpath)).isSelected()) {
				driver.findElement(By.xpath(xpath)).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean doesProcessScheduleCopied(String headerText, String value) {
		boolean isCopied = false;
		try {
			WebElement header = driver.findElement(By.xpath("//*[@id='schedules-table_wrapper']/div[2]/div[1]"));
			List<WebElement> headers = header.findElements(By.tagName("th"));
			WebElement tableData = driver.findElement(By.xpath("//*[@id='schedules-table']"));
			List<WebElement> row = tableData.findElements(By.tagName("td"));

			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(headerText)) {
					System.out.println("The value of " + headerText + " is " + row.get(index).getText());
					isCopied = true;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}
}
