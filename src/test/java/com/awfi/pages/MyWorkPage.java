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

public class MyWorkPage {

	private WebDriver driver;
	private ConfigReader config;

	public MyWorkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		config = new ConfigReader();
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Process Schedule Name']")
	private WebElement processScheduleInput;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(id = "btn-start-process")
	private WebElement startProcessBtn;

	@FindBy(id = "notes")
	private WebElement notesInput;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//a[text()='Processes Management']")
	private WebElement processManagementTab;

	@FindBy(id = "btn-create-process")
	private WebElement createProcessBtn;

	@FindBy(id = "ProcessNumber")
	private WebElement processNumberInput;

	@FindBy(name = "Name")
	private WebElement processStepNameInput;

	@FindBy(xpath = "//*[@id='s2id_create-select-step']/a/span[2]")
	private WebElement selectProcessStep;

	@FindBy(xpath = "//*[@id='s2id_autogen5_search']")
	private WebElement processStepInput;

	@FindBy(xpath = "//a[text()='Devices']")
	private WebElement deviceTab;

	@FindBy(id = "btn-add-device")
	private WebElement addDeviceBtn;

	@FindBy(id = "Description")
	private WebElement deviceDescriptionInput;

	public void enterDeviceDescription(String description) {
		try {
			deviceDescriptionInput.sendKeys(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDeviceType(String deviceType) {
		try {
			Select selectdevicetype = new Select(driver.findElement(By.id("select-device-type")));
			selectdevicetype.selectByVisibleText(deviceType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToAddDevices() {
		try {
			ElementWaitHelper.waitAndClick(addDeviceBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDeviceName(String devicename) {
		try {
			driver.findElement(By.id("Name")).sendKeys(devicename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToDevices() {
		try {
			ElementWaitHelper.waitAndClick(deviceTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewDevice(String devicename, String deviceDescription, String deviceType) {
		try {

			goToDevices();
			goToAddDevices();
			enterDeviceName(devicename);
			enterDeviceDescription(deviceDescription);
			selectDeviceType(deviceType);
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterProcessStepName(String step) {
		// ElementWaitHelper.waitAndClick(processStepNameInput);
		driver.findElement(By.id("Name")).sendKeys(step);
	}

	public void selectProcessStep(String process) {
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='s2id_create-select-step']/a")));
		driver.findElement(By.xpath("//*[@id='s2id_autogen5_search']")).sendKeys(process);
		String xpath = "//span[contains(text(),'" + process + "')]";
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));
	}

	public void selectExecutionType(String type) {
		Select executionType = new Select(driver.findElement(By.name("ExecutionType")));
		executionType.selectByVisibleText(type);
	}

	public void enterProcessNumber(String number) {
		processNumberInput.sendKeys(number);
	}

	public void selectDepartment(String departmenName) throws InterruptedException {
		Thread.sleep(5000);
		Select department = new Select(driver.findElement(By.name("DepartmentID")));
		department.selectByVisibleText(departmenName);
	}

	public void goToCreateNewProcess() {
		ElementWaitHelper.waitAndClick(createProcessBtn);
	}

	public void save() {
		ElementWaitHelper.waitAndClick(saveBtn);
	}

	public void goToProcessManagement() {
		ElementWaitHelper.waitAndClick(processManagementTab);
	}

	public void selectProcessSchedule(String name) {
		try {
			ElementWaitHelper.waitAndClick(processScheduleInput);
			String xpath = "//div[text()='" + name + "']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));

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

	public void startProcess(String procecssName, String note) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//a[text()='My Work Progress']")));
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='s2id_ddl-start-process']/a")));
			WebElement processInput = driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']"));
			processInput.sendKeys(procecssName);
			// MNCPFMS: testschuledname26june (#324234)
			String xpath = "//span[contains(text(),'" + procecssName + "')]";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));
			ElementWaitHelper.waitAndClick(startProcessBtn);
			notesInput.sendKeys(note);
			submitBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNewProcess(String groupname, String department, String processNumber, String processStepName,
			String processStep) {
		try {
			goToProcessManagement();
			goToCreateNewProcess();
			selectDepartment(department + " (" + groupname + ")");
			enterProcessNumber(processNumber);
			enterProcessStepName(processStepName);
			selectProcessStep(processStep);
			save();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToMyWork() {
		driver.navigate().to(config.getProperty("myworkurl"));
	}

	public boolean myworkDataNotCopiedFromTheGroup() {
		boolean copied = false;
		try {
			if (driver.findElement(By.xpath("//td[text()='No matching records found']")) != null) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

}
