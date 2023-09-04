package com.awfi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.awfi.driver.DriverSetup;
import com.awfi.utilities.CommonUtils;
import com.awfi.utilities.ElementWaitHelper;

public class GroupsTestScenarios extends DriverSetup {

	private ElementWaitHelper elementWait;
	private static String apiKey;
	private static String groupfullname;

	@BeforeClass
	public void prerequisites() {
		getPageObjectManager().getLoginPage().login(getConfig().getProperty("username"),
				getConfig().getProperty("password"));
	}

	@Test(enabled = true, description = "As a user, I should be able to create a group and edit it")
	public void createAndEditGroup() {

		String updatedFullname;
		String address = "Test AWFI Address";
		String city = "New york";

		try {
			/*
			 * getPageObjectManager().getGroupPage().goToNewGroup();
			 * 
			 * //groupfullname = getPageObjectManager().getCreateGroupPage() //
			 * .enterNewGroupName(CommonUtils.generateAlphabeticalString()); //
			 * getPageObjectManager().getCreateGroupPage().uploadLogoImage(getConfig().
			 * getProperty("logo"));
			 * //getPageObjectManager().getCreateGroupPage().saveGroup();
			 * Thread.sleep(5000);
			 * getPageObjectManager().getGroupPage().search(groupfullname);
			 * Thread.sleep(5000);
			 * Assert.assertEquals(getPageObjectManager().getGroupPage().doesGroupExist(
			 * groupfullname), true); getPageObjectManager().getGroupPage().editGroup();
			 * updatedFullname = getPageObjectManager().getEditGroupPage()
			 * .enterfullName(CommonUtils.generateAlphabeticalString());
			 * getPageObjectManager().getEditGroupPage().enterAddress(address);
			 * getPageObjectManager().getEditGroupPage().enterCity(city); apiKey =
			 * getPageObjectManager().getEditGroupPage().generateAPIKey();
			 * getPageObjectManager().getEditGroupPage().updateChanges();
			 * Thread.sleep(5000);
			 * getPageObjectManager().getGroupPage().search(updatedFullname);
			 * Thread.sleep(5000);
			 * Assert.assertEquals(getPageObjectManager().getGroupPage().doesGroupExist(
			 * updatedFullname), true);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("The test case failed due to an exception");
		}

	}

}
