package com.awfi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.awfi.driver.DriverSetup;
import com.awfi.utilities.CommonUtils;
import com.awfi.utilities.ElementWaitHelper;

public class UserTestScenarios extends DriverSetup {

	private static String email;
	private static String username;
	private static String password;

	@BeforeClass
	public void prerequisites() {
		getPageObjectManager().getLoginPage().login(getConfig().getProperty("username"),
				getConfig().getProperty("password"));
	}

	@Test(enabled = true, description = "As a user, I can create a group, add a user and can login with the new user")
	public void createAndUpdateUserForAGroup() {
		email = CommonUtils.generateRandomEmail();
		username = null;
		password = null;
		String userFirstName;
		String userLastName;

		try {
			getPageObjectManager().getGroupPage().goToNewGroup();
			// String groupname = getPageObjectManager().getCreateGroupPage()
			// .createNewGroup(CommonUtils.generateAlphabeticalString());
			getPageObjectManager().getUsersPage().goToUsers();
			getWaitHelper().implicitWait();

			Assert.assertEquals(getPageObjectManager().getUsersPage().noRecordsDisplayed(), true);

			getPageObjectManager().getUsersPage().goToCreateUserPage();
			getWaitHelper().implicitWait();
			// getPageObjectManager().getNewUserPage().selectGroup(groupname);
			getPageObjectManager().getNewUserPage().enterEmail(email);
			username = getPageObjectManager().getNewUserPage().enterUsername(CommonUtils.generateAlphabeticalString());
			password = getPageObjectManager().getNewUserPage().enterPassword(CommonUtils.generatePassword());
			getPageObjectManager().getNewUserPage().enterRepeatPassword(password);

			userFirstName = getPageObjectManager().getNewUserPage()
					.enterFirstName(CommonUtils.generateAlphabeticalString());
			userLastName = getPageObjectManager().getNewUserPage()
					.enterLastName(CommonUtils.generateAlphabeticalString());
			getPageObjectManager().getNewUserPage().enterPhone(CommonUtils.generateRandomPhoneNumber());
			getPageObjectManager().getNewUserPage().selectGroupAdmin();
			getPageObjectManager().getNewUserPage().saveUserDetails();
			getWaitHelper().implicitWait();
			// getPageObjectManager().getUsersPage().selectGroup(groupname);
			getWaitHelper().implicitWait();

			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(userFirstName), true);
			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(userLastName), true);
			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(email), true);

			getPageObjectManager().getUsersPage().goToEditUserPage();
			getWaitHelper().implicitWait();
			Thread.sleep(5000);
			password = getPageObjectManager().getNewUserPage().enterPassword(CommonUtils.generatePassword());
			Thread.sleep(5000);
			getPageObjectManager().getNewUserPage().enterRepeatPassword(password);

			userFirstName = getPageObjectManager().getNewUserPage()
					.enterFirstName(CommonUtils.generateAlphabeticalString());
			userLastName = getPageObjectManager().getNewUserPage()
					.enterLastName(CommonUtils.generateAlphabeticalString());
			getPageObjectManager().getNewUserPage().enterPhone(CommonUtils.generateRandomPhoneNumber());
			getPageObjectManager().getNewUserPage().saveUserDetails();
			getWaitHelper().implicitWait();

			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(userFirstName), true);
			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(userLastName), true);
			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(email), true);
			getPageObjectManager().getUsersPage().logout(getConfig().getProperty("email"));

			getPageObjectManager().getLoginPage().login(username, password);
			Assert.assertEquals(getPageObjectManager().getGroupPage().isLoggedIn(email), true);
			getPageObjectManager().getUsersPage().logout(email);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("The test case failed due to an exception");
		}

	}

	@Test(enabled = true, dependsOnMethods = "createAndUpdateUserForAGroup", description = "As a user, I should be able to login with the newly created user account")
	public void checkLoginWithNewUser() {
		try {
			prerequisites();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("The test case failed due to an exception");
		}

	}

}
