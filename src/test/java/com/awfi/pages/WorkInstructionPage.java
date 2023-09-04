package com.awfi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.tests.GroupCopyTestScenarios;
import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class WorkInstructionPage {

	private WebDriver driver;
	private ConfigReader config;

	public WorkInstructionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		config = new ConfigReader();
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()=' New Work Instruction']")
	private WebElement newWorkInstructionBtn;

	@FindBy(name = "GroupID")
	private WebElement groupDropdown;

	@FindBy(id = "DocumentNumber")
	private WebElement docNumberInput;

	@FindBy(id = "Name")
	private WebElement docNameInput;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	public void addNewWorkInstruction(String groupname, String documentNumber, String docName) {
		try {
			goToCreateWorkInstruction();
			Thread.sleep(5000);
			selectGroup(groupname);
			enterDocumentNumber(documentNumber);
			enterDocumentName(docName);
			saveBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDocumentName(String name) {
		try {
			docNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDocumentNumber(String number) {
		try {
			docNumberInput.sendKeys(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroup(String group) {
		try {
			Select groupdd = new Select(driver.findElement(By.name("GroupID")));
			groupdd.selectByVisibleText(group);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToCreateWorkInstruction() {
		try {
			ElementWaitHelper.waitAndClick(newWorkInstructionBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToWorkInstruction() {
		driver.navigate().to(config.getProperty("workinstructionurl"));
	}

}
