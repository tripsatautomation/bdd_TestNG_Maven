package com.awfi.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.CommonUtils;
import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class GroupPage {

	private WebDriver driver;
	private ConfigReader config;

	public GroupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		config = new ConfigReader();
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()=' New Group']")
	private WebElement newGroupBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchInput;

	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editLink;

	@FindBy(xpath = "//a[@id='btn-select']")
	private WebElement chooseDefaultLink;

	@FindBy(name = "Name")
	private WebElement nameInput;

	@FindBy(id = "Logo")
	private WebElement logoFileInput;

	@FindBy(id = "deletionEnabled")
	private WebElement deletionEnabledCheckbox;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[@title='Copy To New']")
	private WebElement copyBtn;

	@FindBy(id = "NewName")
	private WebElement newGroupNameInput;

	public void enterNewGroupCopyName(String newgroupName) {
		try {
			newGroupNameInput.sendKeys(newgroupName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void copyGroupBtn() {
		try {
			ElementWaitHelper.waitAndClick(copyBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void copyGroup(String newgroupName) {
		try {
			Thread.sleep(3000);
			copyGroupBtn();
			enterNewGroupCopyName(newgroupName);

			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//button[text()='Copy']")));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createGroup() {
		String groupname = null;
		try {
			goToNewGroup();
			groupname = enterNewGroupName(CommonUtils.generateAlphabeticalString());
			saveGroup();
			Thread.sleep(5000);
			search(groupname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupname;
	}

	public void goToGroups() throws Exception {
		driver.navigate().to(config.getProperty("grouppageurl"));
		Thread.sleep(5000);
	}

	public void makeGroupDefault() {
		try {
			chooseDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveGroup() {
		try {
			ElementWaitHelper.waitTillElementVisible(saveBtn);
			saveBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDeletionEnabled() {
		try {
			ElementWaitHelper.waitTillElementVisible(deletionEnabledCheckbox);
			if (!deletionEnabledCheckbox.isSelected()) {
				deletionEnabledCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterNewGroupName(String name) {
		try {
			ElementWaitHelper.waitTillElementVisible(nameInput);
			nameInput.sendKeys(name);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}

	public String createNewGroup(String fullname) {
		try {
			fullname = enterNewGroupName(CommonUtils.generateAlphabeticalString());
			saveGroup();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullname;
	}

	public void uploadLogoImage(String imagepath) {
		try {
			Robot robot = new Robot();
			StringSelection selection = new StringSelection(imagepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			// Simulate keypresses to navigate to the file input field and paste the file
			// path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Simulate pressing Enter to confirm the file selection
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void chooseDefault() {
		try {
			Thread.sleep(5000);
			// ElementWaitHelper.waitAndClick(chooseDefaultLink);
			chooseDefaultLink.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isLoggedIn(String emailId) {
		boolean isLogin = false;
		try {
			String xpath = "//div[text()=' Hello, " + emailId + " ']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isLogin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isLogin;
	}

	public void editGroup() {
		try {
			ElementWaitHelper.waitAndClick(editLink);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(String search) {
		try {
			ElementWaitHelper.waitTillElementVisible(searchInput);
			searchInput.clear();
			searchInput.sendKeys(search);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletGroup(String group) {
		try {
			search(group);
			String xpath = "//a[@title='Delete']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));
			Thread.sleep(3000);
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//button[text()='Yes']")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doesGroupExist(String groupname) {
		boolean exist = false;
		try {
			String xpath = "//td[text()='" + groupname + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				exist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exist;
	}

	public void goToNewGroup() {
		try {
			ElementWaitHelper.waitAndClick(newGroupBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
