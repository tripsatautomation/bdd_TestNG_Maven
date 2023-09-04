package com.awfi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.utilities.ElementWaitHelper;

public class NewUserPage {

	private WebDriver driver;

	public NewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

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

	public void enterEmail(String email) {
		try {
			ElementWaitHelper.waitTillElementVisible(emailInput);
			emailInput.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
