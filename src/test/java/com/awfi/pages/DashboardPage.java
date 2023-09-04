package com.awfi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class DashboardPage {

	private WebDriver driver;
	private ConfigReader config;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		config = new ConfigReader();
		this.driver = driver;
	}

	@FindBy(xpath = "//a[text()='Devices']")
	private WebElement deviceTab;

	@FindBy(id = "btn-add-device")
	private WebElement addDevice;

	@FindBy(name = "Name")
	private WebElement deviceNameInput;

	@FindBy(name = "GroupID")
	private WebElement selectGroup;

	@FindBy(name = "Description")
	private WebElement deviceDescriptionInput;

	@FindBy(id = "btn-add-department")
	private WebElement addDepartment;

	@FindBy(id = "DocumentNumber")
	private WebElement documentNumberInput;

	@FindBy(xpath = "//button[text()=' New Work Instruction']")
	private WebElement newWorkInstructionBtn;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[text()='Department Management']")
	private WebElement departmentManagementTab;

	public void addDepartment(String groupname, String departmentname) {
		try {
			goToDepartmentManagementTab();
			goToAddDepartment();
			Select GroupId = new Select(driver.findElement(By.name("GroupId")));
			GroupId.selectByVisibleText(groupname);
			driver.findElement(By.name("Name")).sendKeys(departmentname);
			ElementWaitHelper.waitAndClick(saveBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroupType(String type) {
		Select groupType = new Select(driver.findElement(By.name("GroupID")));
		groupType.selectByVisibleText(type);
	}

	public void goToAddnewWorkInstruction(String name) {
		ElementWaitHelper.waitAndClick(newWorkInstructionBtn);
	}

	public void enterDocName(String docname) {
		WebElement docNameInput = driver.findElement(By.name("name"));
		docNameInput.sendKeys(docname);
	}

	public void enterDocumentNumber(String docNumber) {
		documentNumberInput.sendKeys(docNumber);
	}

	public void goToAddDepartment() {
		ElementWaitHelper.waitAndClick(addDepartment);
	}

	public void goToDepartmentManagementTab() {
		ElementWaitHelper.waitAndClick(departmentManagementTab);
	}

	public void selectDeviceType(String type) {
		Select executionType = new Select(driver.findElement(By.name("DeviceTypeID")));
		executionType.selectByVisibleText(type);
	}

	public void enterDeviceDescription(String description) {
		ElementWaitHelper.waitAndClick(deviceDescriptionInput);
		deviceDescriptionInput.sendKeys(description);
	}

	public void enterDeviceName(String devicename) {
		ElementWaitHelper.waitAndClick(deviceNameInput);
		deviceNameInput.sendKeys(devicename);
	}

	public void goToAddDevice() {
		ElementWaitHelper.waitAndClick(addDevice);
	}

	public void goToDeviceTab() {
		ElementWaitHelper.waitAndClick(deviceTab);
	}
	public void goToDashboard() {
		driver.navigate().to(config.getProperty("dashboardurl"));
	}

	
	public void addNewDevice(String devicename,String description,String devicetype) {
		try {
			goToDeviceTab();
			goToAddDevice();
			enterDeviceName(devicename);
			enterDeviceDescription(description);
			selectDeviceType(devicetype);
			saveBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
