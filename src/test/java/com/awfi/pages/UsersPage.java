package com.awfi.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.utilities.CommonUtils;
import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class UsersPage {

	private WebDriver driver;
	private ConfigReader config;

	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(xpath = "//a[@href='/Admin/UserList'][1]")
	private WebElement usersMenuLink;

	@FindBy(xpath = "//button[@id='btn-create']")
	private WebElement createUserBtn;

	@FindBy(xpath = "//span[text()='Group']")
	private WebElement groupDropdown;

	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editLink;

	@FindBy(xpath = "//a[@title='Copy To New']")
	private WebElement copyToNewLink;

	@FindBy(id = "NewName")
	private WebElement newGroupNameInput;

	@FindBy(xpath = "//button[text()='Copy']")
	private WebElement copyLink;

	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Username")
	private WebElement usernameInput;

	@FindBy(id = "Password")
	private WebElement pswdInput;

	@FindBy(id = "RepeatPassword")
	private WebElement repeatPswdInput;

	@FindBy(id = "FirstName")
	private WebElement firstNameInput;

	@FindBy(id = "LastName")
	private WebElement lastNameInput;

	@FindBy(xpath = "//input[@id='UserRoles_0__Selected']")
	private WebElement fgProCheckbox;

	@FindBy(xpath = "//input[@id='UserRoles_1__Selected']")
	private WebElement fgProPlusCheckbox;

	@FindBy(xpath = "//input[@id='UserRoles_2__Selected']")
	private WebElement groupAdminCheckbox;

	@FindBy(className = "//input[@id='UserRoles_3__Selected']")
	private WebElement supportAgentCheckbox;

	@FindBy(className = "//input[@id='UserRoles_4__Selected']")
	private WebElement systemAdminCheckbox;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveUserBtn;

	@FindBy(id = "PhoneNumber")
	private WebElement phoneNumberInput;

	public String enterUsername(String username) {
		try {
			usernameInput.clear();
			usernameInput.sendKeys(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}

	public String enterPassword(String password) {
		try {
			pswdInput.clear();
			pswdInput.sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public void saveUserDetails() {
		saveUserBtn.click();
	}

	public void selectFGPro() {
		try {

			if (!fgProCheckbox.isSelected()) {
				fgProCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFGProPlus() {
		try {

			if (!fgProPlusCheckbox.isSelected()) {
				fgProPlusCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroupAdmin() {
		try {

			if (!groupAdminCheckbox.isSelected()) {
				groupAdminCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFGSupportAgent() {
		try {

			if (!supportAgentCheckbox.isSelected()) {
				supportAgentCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSystemAdmin() {
		try {

			if (!systemAdminCheckbox.isSelected()) {
				systemAdminCheckbox.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterFirstName(String firstname) {
		try {
			ElementWaitHelper.waitTillElementVisible(firstNameInput);
			firstNameInput.sendKeys(firstname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstname;
	}

	public String enterLastName(String lastname) {
		try {
			ElementWaitHelper.waitTillElementVisible(lastNameInput);
			lastNameInput.sendKeys(lastname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastname;
	}

	public String enterPhone(String phone) {
		try {
			phoneNumberInput.clear();
			ElementWaitHelper.waitTillElementVisible(phoneNumberInput);
			phoneNumberInput.sendKeys(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone;
	}

	public void enterRepeatPassword(String password) {
		try {
			ElementWaitHelper.waitTillElementVisible(repeatPswdInput);
			repeatPswdInput.sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroup(String group) {
		try {
			Select ddlGroup = new Select(driver.findElement(By.id("GroupID")));
			ddlGroup.selectByVisibleText(group);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroupDD(String groupname) {
		try {
			Thread.sleep(5000);
			ElementWaitHelper.waitAndClick(groupDropdown);
			WebElement searchTxtInput = driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']"));
			searchTxtInput.sendKeys(groupname);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEmail(String email) {
		try {
			ElementWaitHelper.waitTillElementVisible(emailInput);
			emailInput.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createUser(String groupname, String useremail, String username) {
		try {
			driver.navigate().to(config.getProperty("userpageurl"));
			goToCreateUserPage();
			ElementWaitHelper.implicitWait();
			Thread.sleep(3000);
			selectGroup(groupname);
			enterEmail(useremail);
			enterUsername(CommonUtils.generateAlphabeticalString());
			String password = enterPassword(CommonUtils.generatePassword());
			enterRepeatPassword(password);
			enterFirstName(CommonUtils.generateAlphabeticalString());
			enterLastName(CommonUtils.generateAlphabeticalString());
			enterPhone(CommonUtils.generateRandomPhoneNumber());
			selectGroupAdmin();
			saveUserDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void copyBtn() {
		try {
			copyLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterNewGroupName(String name) {
		try {
			newGroupNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;

	}

	public void copyGroupBtn() {
		try {
			ElementWaitHelper.waitAndClick(copyToNewLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean noRecordsDisplayed() {
		boolean isDisplayed = false;
		try {
			String xpath = "//td[text()='" + config.getProperty("norecordtext") + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isDisplayed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDisplayed;
	}

	public void goToEditUserPage() {
		try {
			ElementWaitHelper.waitAndClick(editLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToUsers() {
		try {
			driver.navigate().to(config.getProperty("userpageurl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout(String email) {
		try {
			String xpath = "//div[text()=' Hello, " + email + " ']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//a[text()=' Log Off']")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToCreateUserPage() {
		try {
			ElementWaitHelper.waitAndClick(createUserBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doesUserDataGetsCopied(String userdata) {
		boolean isDataExist = false;
		try {
			String xpath = "//td[text()='" + userdata + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isDataExist = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDataExist;
	}

	public boolean doesUserDataGetCopied(String norecordmessage) {
		boolean isCopied = true;
		try {
			String xpath = "//td[text()='" + norecordmessage + "']";

			if (driver.findElement(By.xpath(xpath)) != null) {
				isCopied = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isCopied;
	}

}
