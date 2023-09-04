package com.awfi.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.awfi.driver.DriverSetup;

public class GroupCopyTestScenarios extends DriverSetup {

	private static final String groupname = "Alpine";

	@BeforeClass
	public void prerequisites() {

		getPageObjectManager().getLoginPage().login(getConfig().getProperty("username"),
				getConfig().getProperty("password"));

	}

	@Test
	public void copyAlpineAndCheckData() {
		try {

			int groupID = getDB().getGroupID(groupname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = true, description = "Check Alpine group and all its data")
	public void createGroupAndCopy() {
		try {
			getPageObjectManager().getGroupPage().goToGroups();
			getPageObjectManager().getGroupPage().search(groupname);
			getPageObjectManager().getGroupPage().makeGroupDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkGroupUser() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
