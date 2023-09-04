package com.awfi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.awfi.driver.DriverSetup;
import com.awfi.utilities.CommonUtils;

public class ExistingGroupTestScenarios extends DriverSetup {

	private static String groupname;
	private static String useremail;
	private static String username;

	// Base test data
	private String basematerialcategory = "Additives";
	private static String baseproductcode;
	private static String baseproductname;
	private static String baseproductdensity;
	private static String baseVOC;
	private static String baseHAP;
	private static String baseTAP;
	private static String baseMinQuantity;
	private static String baseprice;
	private static String basebatchnumber;

	// Pigments test data
	private static String pigmentmaterialcategory = "824 Pigments";
	private static String pigmentproductcode;
	private static String pigmentproductname;
	private static String pigmentproductdensity;
	private static String pigmentprice;
	private static String pigmentHAP;
	private static String pigmentVOC;
	private static String pigmentTAP;
	private static String pigmentMinQuantity;
	private static String pigmentbatchnumber;

	// Dye Test Data
	private static String dyematerialcategory = "Rudd";
	private static String dyeproductcode;
	private static String dyeproductname;
	private static String dyeproductdensity;
	private static String dyeprice;
	private static String dyeHAP;
	private static String dyeVOC;
	private static String dyeTAP;
	private static String dyeMinQuantity;
	private static String dyebatchnumber;

	// Equipment Test Data
	private static String equipmentmaterialcategory = "Auto AA Gun";
	private static String equipmentproductcode;
	private static String equipmentproductname;
	private static String equipmentproductdensity;
	private static String equipmentprice;
	private static String equipmentHAP;
	private static String equipmentVOC;
	private static String equipmentTAP;
	private static String equipmentMinQuantity;
	private static String equipmentbatchnumber;

	// Equipment Test Data
	private static String sundrymaterialcategory = "Belt Abrasives";
	private static String sundryproductcode;
	private static String sundryproductname;
	private static String sundryproductdensity;
	private static String sundryprice;
	private static String sundryHAP;
	private static String sundryVOC;
	private static String sundryTAP;
	private static String sundryMinQuantity;
	private static String sundrybatchnumber;

	// Vendor
	private static String vendorname;
	private static String vendoraddress;
	private static String vendorcity;
	private static String vendorstate;
	private static String vendorzip;
	private static String vendorpaymentterm;
	private static String vendoraccount;
	private static String vendorcontact;
	private static String vendorofficephone;
	private static String vendormobilephone;
	private static String vendoremail;
	private static String requesteremail;

	// Formula Test Data
	private static String formulacategory = "Alkyd Primer";
	private static String formulaName;
	private static String formulaNumber;

	// Edit Formula Test Data
	String basegram = "1";
	String pigmentgram = "2";
	String dyeGram = "3";
	String employee;
	String markup = "4";
	String spexDeltaL = "5";
	String spexDeltaA = "6";
	String spexDeltaB = "7";
	String spexDeltaE = "8";
	String spinDeltaL = "9";
	String spinDeltaA = "10";
	String spinDeltaB = "11";
	String spinDeltaE = "12";
	String substrate = "Test Substrate";
	String purchaseorder;
	String formulacustomername;
	String formulanotes;
	private static boolean formulastatus;

	// ProcessSteps test data
	private static String processstepname;
	private static String processnumber;
	private static String industrytype = "Aerospace";

	// Process schedule Test data
	private static String processschedulename;
	private static String processschedulenumber;
	private static String customername;

	// Work test data
	private static String departmentname;
	private static String docname;
	private static String docnumber;

	// Device test data
	private static String devicename;
	private static String devicedescription;
	private static String devicetype = "Camera";

	// Copy Group Test Data
	private static String copiedGroupName;
	private static String copiedUserMessage = "No matching records found";

	@BeforeClass
	public void prerequisites() {
		useremail = CommonUtils.generateRandomEmail();
		basebatchnumber = CommonUtils.enterValue();
		equipmentbatchnumber = CommonUtils.enterValue();
		dyebatchnumber = CommonUtils.enterValue();
		pigmentbatchnumber = CommonUtils.enterValue();
		equipmentbatchnumber = CommonUtils.enterValue();
		sundrybatchnumber = CommonUtils.enterValue();
		baseproductcode = CommonUtils.enterValue();
		baseproductname = "Base" + CommonUtils.generateAlphabeticalString();
		baseproductdensity = CommonUtils.enterValue();
		baseMinQuantity = CommonUtils.enterValue();
		baseprice = CommonUtils.enterValue();
		baseVOC = CommonUtils.enterValue();
		baseHAP = CommonUtils.enterValue();
		baseTAP = CommonUtils.enterValue();
		employee = "Employee_" + CommonUtils.generateAlphabeticalString();
		pigmentproductcode = CommonUtils.enterValue();
		pigmentproductname = "Pigment" + CommonUtils.generateAlphabeticalString();
		pigmentproductdensity = CommonUtils.enterValue();
		pigmentprice = CommonUtils.enterValue();
		pigmentHAP = CommonUtils.enterValue();
		pigmentVOC = CommonUtils.enterValue();
		pigmentTAP = CommonUtils.enterValue();
		pigmentMinQuantity = CommonUtils.enterValue();
		purchaseorder = CommonUtils.generateRandomInteger();
		dyeproductcode = CommonUtils.enterValue();
		dyeproductname = "Dye" + CommonUtils.generateAlphabeticalString();
		dyeproductdensity = CommonUtils.enterValue();
		dyeprice = CommonUtils.enterValue();
		dyeHAP = CommonUtils.enterValue();
		dyeVOC = CommonUtils.enterValue();
		dyeTAP = CommonUtils.enterValue();
		dyeMinQuantity = CommonUtils.enterValue();

		equipmentproductcode = CommonUtils.enterValue();
		equipmentproductname = "Equipment" + CommonUtils.generateAlphabeticalString();
		equipmentproductdensity = CommonUtils.enterValue();
		equipmentprice = CommonUtils.enterValue();
		equipmentHAP = CommonUtils.enterValue();
		equipmentVOC = CommonUtils.enterValue();
		equipmentTAP = CommonUtils.enterValue();
		equipmentMinQuantity = CommonUtils.enterValue();

		sundryproductcode = CommonUtils.enterValue();
		sundryproductname = "Sundary" + CommonUtils.generateAlphabeticalString();
		sundryproductdensity = CommonUtils.enterValue();
		sundryprice = CommonUtils.enterValue();
		sundryHAP = CommonUtils.enterValue();
		sundryVOC = CommonUtils.enterValue();
		sundryTAP = CommonUtils.enterValue();
		sundryMinQuantity = CommonUtils.enterValue();

		vendorname = "Vendor_" + CommonUtils.generateAlphabeticalString();
		vendoraddress = "Vendor_Address" + CommonUtils.generateAlphabeticalString();
		vendorcity = "New York";
		vendorstate = "United Satates";
		vendorzip = "3234324";
		vendorpaymentterm = "PaymemntTerm" + CommonUtils.generateAlphabeticalString();
		vendoraccount = CommonUtils.generateRandomInteger();
		vendorcontact = CommonUtils.generateRandomPhoneNumber();
		vendorofficephone = CommonUtils.generateRandomPhoneNumber();
		vendormobilephone = CommonUtils.generateRandomPhoneNumber();
		vendoremail = CommonUtils.generateRandomEmail();
		requesteremail = CommonUtils.generateRandomEmail();
		formulanotes = "Formaula notes" + CommonUtils.generateAlphabeticalString();
		formulaName = "Formula" + CommonUtils.generateAlphabeticalString();
		formulaNumber = CommonUtils.generateRandomInteger();
		formulacustomername = "FormulaCustomer" + CommonUtils.generateAlphabeticalString();

		processstepname = "Process" + CommonUtils.generateAlphabeticalString() + System.currentTimeMillis();
		processnumber = CommonUtils.generateRandomInteger();

		processschedulename = "ProcessSchedule" + CommonUtils.generateAlphabeticalString() + System.currentTimeMillis();
		processschedulenumber = CommonUtils.generateRandomInteger();
		customername = "Customer" + CommonUtils.generateAlphabeticalString();

		departmentname = "TestDepartment" + CommonUtils.generateAlphabeticalString() + System.currentTimeMillis();
		docname = "TestDocument" + CommonUtils.generateAlphabeticalString() + System.currentTimeMillis();
		docnumber = CommonUtils.generateRandomInteger();

		devicename = "TestDevice" + CommonUtils.generateAlphabeticalString() + System.currentTimeMillis();
		devicedescription = "Device Description" + CommonUtils.generateAlphabeticalString();

		copiedGroupName = "CopyGroup_" + CommonUtils.generateAlphabeticalString();
		getPageObjectManager().getLoginPage().login(getConfig().getProperty("username"),
				getConfig().getProperty("password"));

	}

	@Test(enabled = true, description = "Check Group creation, addtion of all data and copy")
	public void createGroupAndCopy() {
		try {

			// Create Group and make it default
			groupname = getPageObjectManager().getGroupPage().createGroup();
			System.out.println("Group Name " + groupname);
			getPageObjectManager().getGroupPage().makeGroupDefault();

			// Create User
			getPageObjectManager().getUsersPage().createUser(groupname, useremail, username);

			getPageObjectManager().getEquipmentAndMaterialPage().goToMaterialAndEquipment();

			// Add Document is pending

			// Add Base
			getPageObjectManager().getEquipmentAndMaterialPage().addBaseMaterial(basematerialcategory, baseproductcode,
					baseproductname, baseproductdensity, baseprice, baseVOC, baseHAP, baseTAP, baseMinQuantity,
					basebatchnumber);
			// Add Pigment
			getPageObjectManager().getEquipmentAndMaterialPage().addPigment(pigmentmaterialcategory, pigmentproductcode,
					pigmentproductname, pigmentproductdensity, pigmentprice, pigmentVOC, pigmentHAP, pigmentTAP,
					pigmentMinQuantity, pigmentbatchnumber);

			// Add Dyes
			getPageObjectManager().getEquipmentAndMaterialPage().addDyes(dyematerialcategory, dyeproductcode,
					dyeproductname, dyeproductdensity, dyeprice, dyeVOC, dyeHAP, dyeTAP, dyeMinQuantity,
					dyebatchnumber);

			// Add Equipments
			getPageObjectManager().getEquipmentAndMaterialPage().addEquipments(equipmentmaterialcategory,
					equipmentproductcode, equipmentproductname, equipmentproductdensity, equipmentprice, equipmentVOC,
					equipmentHAP, equipmentTAP, equipmentMinQuantity, equipmentbatchnumber);

			// Add Sundry
			getPageObjectManager().getEquipmentAndMaterialPage().addSundaryItems(sundrymaterialcategory,
					sundryproductcode, sundryproductname, sundryproductdensity, sundryprice, sundryVOC, sundryHAP,
					sundryTAP, sundryMinQuantity, sundrybatchnumber);

			// Add Vendor
			getPageObjectManager().getEquipmentAndMaterialPage().goToVendors();
			getPageObjectManager().getEquipmentAndMaterialPage().addNewVendor(groupname, vendorname, vendoraddress,
					vendorcity, vendorstate, vendorzip, vendorpaymentterm, vendoraccount, vendorcontact,
					vendorofficephone, vendormobilephone, vendoremail, requesteremail);

			// Create formula
			getPageObjectManager().getFormulasPage().goToFormulas();
			getPageObjectManager().getFormulasPage().createNewFormula(formulacategory, formulaName, formulaNumber);

			// Edit formula to add further details
			getPageObjectManager().getFormulasPage().editFormula(basegram, pigmentgram, dyeGram, employee, markup,
					spexDeltaL, spexDeltaA, spexDeltaB, spexDeltaE, spinDeltaL, spinDeltaA, spinDeltaB, spinDeltaE,
					substrate, purchaseorder, customername, formulanotes);

			formulastatus = getPageObjectManager().getFormulasPage().isStatusComplete("Complete");

			// Create new process steps
			getPageObjectManager().getProcessStepsPage().goToProcessSteps();
			getPageObjectManager().getProcessStepsPage().createNewProcessSteps(processstepname, industrytype);

			// Create process schedule
			getPageObjectManager().getProcessSchedulePage().goToProcessSchedule();
			getPageObjectManager().getProcessSchedulePage().createNewProcessSchedule(processschedulename,
					processschedulenumber, customername);
			getPageObjectManager().getProcessSchedulePage().goToProcessSchedule();

			// Add department and device
			getPageObjectManager().getDashboardPage().goToDashboard();
			getPageObjectManager().getDashboardPage().addDepartment(groupname, departmentname);
			getPageObjectManager().getDashboardPage().addNewDevice(devicename, devicedescription, devicetype);

			// Create a new process
			getPageObjectManager().getMyWorkPage().goToMyWork();
			getPageObjectManager().getMyWorkPage().createNewProcess(groupname, departmentname, processnumber,
					CommonUtils.generateAlphabeticalString(), processstepname);
			getPageObjectManager().getProcessSchedulePage().goToProcessSchedule();
			getPageObjectManager().getMyWorkPage().goToMyWork();
			Thread.sleep(10000);

			// Start process
			getPageObjectManager().getMyWorkPage().startProcess(processschedulename,
					CommonUtils.generateAlphabeticalString());
			getPageObjectManager().getMyWorkPage().goToMyWork();
			getPageObjectManager().getWorkInstructionPage().goToWorkInstruction();

			// Add new work instructions
			getPageObjectManager().getWorkInstructionPage().addNewWorkInstruction(groupname, docnumber, docname);

			getPageObjectManager().getGroupPage().goToGroups();
			getPageObjectManager().getGroupPage().search(groupname);
			getPageObjectManager().getGroupPage().copyGroup(copiedGroupName);
			System.out.println("Copied Group Name " + copiedGroupName);
			getPageObjectManager().getGroupPage().search(copiedGroupName);
			getPageObjectManager().getGroupPage().makeGroupDefault();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = true, dependsOnMethods = "createGroupAndCopy", description = "Check Equipment and Materials get copied")
	public void checkEquipmentMaterialGetsCopied() {
		try {

			// Verify no user should get copied
			getPageObjectManager().getUsersPage().goToUsers();
			Assert.assertEquals(getPageObjectManager().getUsersPage().doesUserDataGetsCopied(copiedUserMessage), true);

			// Verify Base Material gets copied
			getPageObjectManager().getEquipmentAndMaterialPage().goToMaterialAndEquipment();

			// getPageObjectManager().getEquipmentAndMaterialPage().isMaterialTypeCopied("");

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.baseMaterialsCopied("Material Category", basematerialcategory), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("Group", copiedGroupName),
					true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("Product Name",
					baseproductname), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("Product #",
					baseproductcode), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("lb/Gal",
					baseproductdensity), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("$/Unit", baseprice),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialTypeCopied("Base"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("VOC", baseVOC), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("HAP", baseHAP), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().baseMaterialsCopied("TAP", baseTAP), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isInventoryCopied(basebatchnumber + ".00"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.baseMaterialsCopied("Min. Quantity", baseMinQuantity), true);

			// Verify Pigments Material gets copied
			getPageObjectManager().getEquipmentAndMaterialPage().goToPigmentTab();
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Group",
					copiedGroupName, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isMaterialsCopied("Material Category", pigmentmaterialcategory, "pigment"), true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product Name",
					pigmentproductname, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product #",
					pigmentproductcode, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("lb/Gal",
					pigmentproductdensity, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("$/Unit",
					baseprice, "pigment"), true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().materialTypeCopied("pigment"),
					true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("VOC",
					pigmentVOC, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("HAP",
					pigmentHAP, "pigment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("TAP",
					pigmentTAP, "pigment"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isInventoryCopied(pigmentbatchnumber + ".00"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Min. Quantity",
					pigmentMinQuantity, "pigment"), true);

			// Verify Dyes Material gets copied

			getPageObjectManager().getEquipmentAndMaterialPage().goToDyes();
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isMaterialsCopied("Material Category", dyematerialcategory, "dye"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Group",
					copiedGroupName, "dye"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product Name",
					dyeproductname, "dye"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product #",
					dyeproductcode, "dye"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("lb/Gal",
					dyeproductdensity, "dye"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("$/Unit", dyeprice, "dye"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().materialTypeCopied("dye"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("VOC", dyeVOC, "dye"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("HAP", dyeHAP, "dye"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("TAP", dyeTAP, "dye"), true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isInventoryCopied(dyebatchnumber + ".00"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Min. Quantity",
					dyeMinQuantity, "dye"), true);

			// Verify Equipment Material gets copied

			getPageObjectManager().getEquipmentAndMaterialPage().goToEquipments();
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isMaterialsCopied("Material Category", equipmentmaterialcategory, "equipment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Group",
					copiedGroupName, "equipment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product Name",
					equipmentproductname, "equipment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product #",
					equipmentproductcode, "equipment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("lb/Gal",
					equipmentproductdensity, "equipment"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("$/Unit",
					equipmentprice, "equipment"), true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().materialTypeCopied("equipment"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isInventoryCopied(equipmentbatchnumber + ".00"), true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Min. Quantity",
					equipmentMinQuantity, "equipment"), true);

			// Verify Sundry Material gets copied

			getPageObjectManager().getEquipmentAndMaterialPage().goToSundaryItems();
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isMaterialsCopied("Material Category", sundrymaterialcategory, "sundry"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Group",
					copiedGroupName, "sundry"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product Name",
					sundryproductname, "sundry"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Product #",
					sundryproductcode, "sundry"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("lb/Gal",
					sundryproductdensity, "sundry"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("$/Unit",
					sundryprice, "sundry"), true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().materialTypeCopied("sundry"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("VOC", sundryVOC, "sundry"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("HAP", sundryHAP, "sundry"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("TAP", sundryTAP, "sundry"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getEquipmentAndMaterialPage().isInventoryCopied(sundrybatchnumber + ".00"),
					true);

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Min. Quantity",
					sundryMinQuantity, "sundry"), true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, dependsOnMethods = "checkEquipmentMaterialGetsCopied", description = "Check Vendor data should be copied ")
	public void checkVendorCopied() {
		try {

			getPageObjectManager().getEquipmentAndMaterialPage().goToVendors();

			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Vendor Name",
					vendorname, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Payment Terms",
					vendorpaymentterm, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Account #",
					vendoraccount, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Contact Name",
					vendorcontact, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Office Phone",
					vendorofficephone, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Mobile Phone",
					vendormobilephone, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Vendor Email",
					vendoremail, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage()
					.isMaterialsCopied("Requestor Email", requesteremail, "Vendor"), true);
			Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().isMaterialsCopied("Address",
					vendoraddress, "Vendor"), true);
			getUtils().scrollRight();
			/*
			 * Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().
			 * isMaterialsCopied("State", vendorstate, "Vendor"), true);
			 * Assert.assertEquals(getPageObjectManager().getEquipmentAndMaterialPage().
			 * isMaterialsCopied("City", vendorcity, "Vendor"), true);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = false, dependsOnMethods = "createGroupAndCopy", description = "Check reports should not get copied")
	public void checkReportShouldNotBeCopied() {
		try {

			getPageObjectManager().getEquipmentAndMaterialPage().goToReports();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, dependsOnMethods = "checkVendorCopied", description = "Check Formula should get copied ")
	public void checkFormulaCopied() {
		try {

			getPageObjectManager().getFormulasPage().goToFormulas();
			Thread.sleep(3000);
			getPageObjectManager().getFormulasPage().checkFormulaCopied("Group", copiedGroupName, "formulation");
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkFormulaCopied("Group", copiedGroupName,
					"formulation"), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkFormulaCopied("Category", formulacategory,
					"formulation"), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkFormulaCopied("Formula Name", formulaName,
					"formulation"), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkFormulaCopied("Formula Number",
					formulaNumber, "formulation"), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkFormulaCopied("Formula Number",
					formulaNumber, "formulation"), true);

			Assert.assertEquals(formulastatus, true);

			getPageObjectManager().getFormulasPage().goToEditFormula();

			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkEditedBase("Material Category", basematerialcategory),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkEditedBase("Product Name", baseproductname), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkEditedBase("Product #", baseproductcode),
					true);

			Assert.assertEquals(getPageObjectManager().getFormulasPage()
					.checkBatchAndInventoryCopiedOnEditFormula(baseproductcode, basebatchnumber), true);

			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkEditedPigments("Product Name", pigmentproductname),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkEditedPigments("Product #", pigmentproductcode),
					true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage()
					.checkBatchAndInventoryCopiedOnEditFormula(pigmentproductcode, pigmentbatchnumber), true);
			Thread.sleep(3000);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkEditedDyes("Product Name", dyeproductname), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkEditedDyes("Product #", dyeproductcode),
					true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage()
					.checkBatchAndInventoryCopiedOnEditFormula(dyeproductcode, dyebatchnumber), true);
			CommonUtils.scroll();

			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod Name", baseproductname),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod #", baseproductcode), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Grams", basegram),
					true);
			CommonUtils.scroll();
			/*
			 * Assert.assertEquals(
			 * getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod Name",
			 * pigmentproductname), true); Assert.assertEquals(
			 * getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod #",
			 * pigmentproductcode), true);
			 * Assert.assertEquals(getPageObjectManager().getFormulasPage().
			 * checkColorFormulaCopied("Grams", pigmentgram), true);
			 * 
			 * Assert.assertEquals(
			 * getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod Name",
			 * dyeproductname), true); Assert.assertEquals(
			 * getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Prod #",
			 * dyeproductcode), true);
			 * Assert.assertEquals(getPageObjectManager().getFormulasPage().
			 * checkColorFormulaCopied("Grams", dyeGram), true);
			 * 
			 */
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().doesTotalWeightCopied(basegram, pigmentgram, dyeGram),
					true);
			getPageObjectManager().getFormulasPage().saveFormula();

			Assert.assertEquals(getPageObjectManager().getFormulasPage().doesMarkupCopied(markup), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spexDeltaLCopied(spexDeltaL), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spexDeltaACopied(spexDeltaA), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spexDeltaBCopied(spexDeltaB), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spexDeltaECopied(spexDeltaE), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spinDeltaLCopied(spinDeltaL), true);
			CommonUtils.scroll();
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spinDeltaACopied(spinDeltaA), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spinDeltaBCopied(spinDeltaB), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().spinDeltaECopied(spinDeltaE), true);

			Assert.assertEquals(getPageObjectManager().getFormulasPage().substrateCopied(substrate), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().materialCategoryCopied(formulacategory), true);

			Assert.assertEquals(getPageObjectManager().getFormulasPage().employeeNameCopied(employee), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().formulaNameCopied(formulaName), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().formulaNumberCopied(formulaNumber), true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().totalWieghtCopied(basegram, pigmentgram, dyeGram), true);

			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Material Category", "Base"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Product Name", baseproductname),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkColorFormulaCopied("Product #", baseproductcode),
					true);

			Assert.assertEquals(getPageObjectManager().getFormulasPage()
					.checkPigmentColorFormulaCopied("Material Category", "Pigment"), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkPigmentColorFormulaCopied("Product Name",
					pigmentproductname), true);
			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkPigmentColorFormulaCopied("Product #",
					pigmentproductcode), true);

			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkDyeColorFormulaCopied("Material Category", "Dye"),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkDyeColorFormulaCopied("Product Name", dyeproductname),
					true);
			Assert.assertEquals(
					getPageObjectManager().getFormulasPage().checkDyeColorFormulaCopied("Product #", dyeproductcode),
					true);

			Assert.assertEquals(getPageObjectManager().getFormulasPage().checkNotesCopied(formulanotes), true);
			getPageObjectManager().getFormulasPage().backToFormula();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, dependsOnMethods = "checkFormulaCopied", description = "Check Process steps copied ")
	public void checkProcessStepsCopiedCorrectly() {
		try {

			getPageObjectManager().getProcessStepsPage().goToProcessSteps();

			Assert.assertEquals(getPageObjectManager().getProcessStepsPage().doesProcessStepsCopied("Group", groupname),
					true);
			Assert.assertEquals(getPageObjectManager().getProcessStepsPage().doesProcessStepsCopied("Process Step Name",
					processstepname), true);
			Assert.assertEquals(getPageObjectManager().getProcessStepsPage().doesProcessStepsCopied("Industry Sector",
					industrytype), true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, dependsOnMethods = "checkProcessStepsCopiedCorrectly", description = "Check Process schedule copied ")
	public void checkProcessScheduleCopiedCorrectly() {
		try {

			getPageObjectManager().getProcessSchedulePage().goToProcessSchedule();
			Assert.assertEquals(
					getPageObjectManager().getProcessSchedulePage().doesProcessScheduleCopied("Group", groupname),
					true);
			Assert.assertEquals(getPageObjectManager().getProcessSchedulePage().doesProcessScheduleCopied("Name",
					processschedulename), true);
			Assert.assertEquals(getPageObjectManager().getProcessSchedulePage().doesProcessScheduleCopied("Number",
					processschedulenumber), true);
			Assert.assertEquals(getPageObjectManager().getProcessSchedulePage()
					.doesProcessScheduleCopied("Customer Name", customername), true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, dependsOnMethods = "checkProcessScheduleCopiedCorrectly", description = "My Work should not get copied")
	public void checkMyWorkNotCopied() {
		try {
			getPageObjectManager().getMyWorkPage().goToMyWork();
			Assert.assertEquals(getPageObjectManager().getMyWorkPage().myworkDataNotCopiedFromTheGroup(), true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	

	@AfterClass
	public void after() {
		
		getPageObjectManager().getGroupPage().deletGroup(groupname);
		getPageObjectManager().getGroupPage().deletGroup(copiedGroupName);
		
		System.out.println("Group Name is " + groupname);
		System.out.println("User created inside " + groupname + "username");
		System.out.println("Base Material Category selected " + basematerialcategory);
		System.out.println("Base Product Code is " + baseproductcode);
		System.out.println("Base Product Name is " + baseproductname);
		System.out.println("Base Product Density is " + baseproductdensity);
		System.out.println("Base VOC is " + baseVOC);
		System.out.println("Base HAP is " + baseHAP);
		System.out.println("Base TAP is " + baseTAP);
		System.out.println("Base Minimum quantity is " + baseMinQuantity);
		System.out.println("Base Price is " + baseprice);
		System.out.println("Base Batch Number is " + basebatchnumber);

		System.out.println("Pigment Material Category selected " + pigmentmaterialcategory);
		System.out.println("Pigment Product Code is " + pigmentproductcode);
		System.out.println("Pigment Product Name is " + pigmentproductname);
		System.out.println("Pigment Product Density is " + pigmentproductdensity);
		System.out.println("Pigment VOC is " + pigmentVOC);
		System.out.println("Pigment HAP is " + pigmentHAP);
		System.out.println("Pigment TAP is " + pigmentTAP);
		System.out.println("Pigment Minimum quantity is " + pigmentMinQuantity);
		System.out.println("Pigment Price is " + pigmentprice);
		System.out.println("Pigment Batch Number is " + pigmentbatchnumber);

		System.out.println("Dye Material Category selected " + dyematerialcategory);
		System.out.println("Dye Product Code is " + dyeproductcode);
		System.out.println("Dye Product Name is " + dyeproductname);
		System.out.println("Dye Product Density is " + dyeproductdensity);
		System.out.println("Dye VOC is " + dyeVOC);
		System.out.println("Dye HAP is " + dyeHAP);
		System.out.println("Dye TAP is " + dyeTAP);
		System.out.println("Dye Minimum quantity is " + dyeMinQuantity);
		System.out.println("Dye Price is " + dyeprice);
		System.out.println("Dye Batch Number is " + dyebatchnumber);

		System.out.println("Equipment Material Category selected " + equipmentmaterialcategory);
		System.out.println("Equipment Product Code is " + equipmentproductcode);
		System.out.println("Equipment Product Name is " + equipmentproductname);
		System.out.println("Equipment Product Density is " + equipmentproductdensity);
		System.out.println("Equipment VOC is " + equipmentVOC);
		System.out.println("Equipment HAP is " + equipmentHAP);
		System.out.println("Equipment TAP is " + equipmentTAP);
		System.out.println("Equipment Minimum quantity is " + equipmentMinQuantity);
		System.out.println("Equipment Price is " + equipmentprice);
		System.out.println("Equipment Batch Number is " + equipmentbatchnumber);

		// Equipment Test Data
		System.out.println("Sundry Material Category selected " + sundrymaterialcategory);
		System.out.println("Sundry Product Code is " + sundryproductcode);
		System.out.println("Sundry Product Name is " + sundryproductname);
		System.out.println("Sundry Product Density is " + sundryproductdensity);
		System.out.println("Sundry VOC is " + sundryVOC);
		System.out.println("Sundry HAP is " + sundryHAP);
		System.out.println("Sundry TAP is " + sundryTAP);
		System.out.println("Sundry Minimum quantity is " + sundryMinQuantity);
		System.out.println("Sundry Price is " + sundryprice);
		System.out.println("Sundry Batch Number is " + sundrybatchnumber);

		System.out.println("Vendor name " + vendorname);
		System.out.println("Vendor Address " + vendoraddress);
		System.out.println("Vendor city is " + vendorcity);
		System.out.println("Vendor state is " + vendorstate);
		System.out.println("Vendor ZIP " + vendorzip);
		System.out.println("Vendor Payement Term " + vendorpaymentterm);
		System.out.println("Vendor Account number is " + vendoraccount);
		System.out.println("Vendor Contact " + vendorcontact);
		System.out.println("Vendor office phone" + vendorofficephone);

		System.out.println("Vendor Mobile Phone is " + vendormobilephone);
		System.out.println("Vendor Email " + vendoremail);
		System.out.println("Requester Email " + requesteremail);

		// Formula Test Data

		System.out.println("Formula Category is  " + formulacategory);
		System.out.println("Formula Name " + formulaName);
		System.out.println("Formaula Number " + formulaNumber);

		// ProcessSteps test data

		System.out.println("Process Step name is  " + processstepname);
		System.out.println("Process Number is " + processnumber);
		System.out.println("Industry Type is " + industrytype);

		// Process schedule Test data

		System.out.println("Process Schedule name is  " + processschedulename);
		System.out.println("Process Schedule Number is " + processschedulenumber);
		System.out.println("Customer name  is " + customername);

		// Work test data

		System.out.println("Department name is  " + departmentname);
		System.out.println("Document Name is " + docname);
		System.out.println("Document Number is " + docnumber);

		System.out.println("Device name is  " + devicename);
		System.out.println("Device description is " + devicedescription);
		System.out.println("Device Type is " + devicetype);

		System.out.println("Copied Group Name is " + copiedGroupName);
		System.out.println("Device Type is " + devicetype);

	}

}
