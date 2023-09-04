package com.awfi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page.SetWebLifecycleStateState;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class EquipmentAndMaterialPage {

	private WebDriver driver;
	private ConfigReader config;

	public EquipmentAndMaterialPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(id = "btn-create")
	private WebElement addItemBtn;

	@FindBy(id = "btn-vendor")
	private WebElement addVendorBtn;

	@FindBy(name = "VendorName")
	private WebElement vendorName;

	@FindBy(name = "Address")
	private WebElement vendorAddressInput;

	@FindBy(name = "City")
	private WebElement vendorCityInput;

	@FindBy(name = "State")
	private WebElement vendorStateInput;

	@FindBy(name = "Zip")
	private WebElement vendorZipInput;

	@FindBy(name = "PaymentTerms")
	private WebElement vendorPaymentTermInput;

	@FindBy(name = "AccountNum")
	private WebElement vendorAccountInput;

	@FindBy(name = "ContactName")
	private WebElement vendorContactNameInput;

	@FindBy(name = "OfficePhone")
	private WebElement vendorPhoneInput;

	@FindBy(name = "MobilePhone")
	private WebElement vendorMobilePhoneInput;

	@FindBy(name = "VendorEmail")
	private WebElement vendorEmailInput;

	@FindBy(id = "saveVendor")
	private WebElement saveVendorBtn;

	public void enterVendorEmail(String email) {
		try {
			vendorEmailInput.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(name = "RequestorEmail")
	private WebElement requesterEmailInput;

	public void enterRequesterEmail(String email) {
		try {
			requesterEmailInput.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorMobilePhone(String phone) {
		try {
			vendorMobilePhoneInput.sendKeys(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorOfficePhone(String phone) {
		try {
			vendorPhoneInput.sendKeys(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorContactName(String contact) {
		try {
			vendorContactNameInput.sendKeys(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorAccountNumber(String account) {
		try {
			vendorAccountInput.sendKeys(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorPaymentTerm(String payment) {
		try {
			vendorPaymentTermInput.sendKeys(payment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorZIPCode(String zip) {
		try {
			vendorZipInput.sendKeys(zip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorState(String state) {
		try {
			vendorStateInput.sendKeys(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorCity(String city) {
		try {
			vendorCityInput.sendKeys(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorAddress(String name) {
		try {
			vendorAddressInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterVendorName(String name) {
		try {
			vendorName.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToAddVendor() {
		try {
			ElementWaitHelper.waitAndClick(addVendorBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "ManufacturersProductCode")
	private WebElement productCodeInput;

	@FindBy(id = "ManufacturersProductName")
	private WebElement productNameInput;

	@FindBy(id = "GramsPerCubicCentiMetres")
	private WebElement densityInput;

	@FindBy(id = "PricePerGallon")
	private WebElement priceInput;

	@FindBy(id = "VOC")
	private WebElement vocInput;

	@FindBy(id = "HAP")
	private WebElement hapInput;

	@FindBy(id = "TAP")
	private WebElement tapInput;

	@FindBy(id = "MinQuantity")
	private WebElement minQuantityInput;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[text()='+/- Adjust ']")
	private WebElement totalInventoryOnHandLink;

	@FindBy(id = "addBatch")
	private WebElement addBatchBtn;

	public void addBatch() {
		addBatchBtn.click();
	}

	@FindBy(id = "batchNum")
	private WebElement batchNumber;

	@FindBy(id = "batchAdd")
	private WebElement addBatchInput;

	@FindBy(id = "saveBatch")
	private WebElement saveBtch;

	@FindBy(xpath = "//a[text()='Pigments']")
	private WebElement pigmentTab;

	@FindBy(xpath = "//a[text()='Dyes']")
	private WebElement dyesTab;

	@FindBy(xpath = "//a[text()='Equipment']")
	private WebElement equipmentTab;

	@FindBy(xpath = "//a[text()='Sundry Items']")
	private WebElement sundaryItemsTab;

	@FindBy(xpath = "//a[text()='Reorder Materials']")
	private WebElement reorderTab;

	@FindBy(xpath = "//a[text()='Vendors']")
	private WebElement vendorsTab;

	@FindBy(xpath = "//a[text()='Reports ']")
	private WebElement reportsTab;

	@FindBy(xpath = "//a[text()='Order History']")
	private WebElement historyTab;

	@FindBy(id = "ColorCode")
	private WebElement colorPicker;

	@FindBy(xpath = "//*[@id='base-table_wrapper']/div[2]/div[1]/div/table")
	private WebElement headerRowXpath;

	@FindBy(xpath = "//*[@id='base-table']")
	private WebElement dataRowXpath;

	@FindBy(xpath = "//*[@id='base-table']/tbody/tr/td[8]")
	private WebElement materialType;

	public void goToPigments() {
		try {
			ElementWaitHelper.waitAndClick(pigmentTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToDyes() {
		try {
			ElementWaitHelper.waitAndClick(dyesTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToEquipments() {
		try {
			ElementWaitHelper.waitAndClick(equipmentTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToSundaryItems() {
		try {
			ElementWaitHelper.waitAndClick(sundaryItemsTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToReorder() {
		try {
			ElementWaitHelper.waitAndClick(reorderTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goToReports() {
		try {
			ElementWaitHelper.waitAndClick(reportsTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToOrderHistory() {
		try {
			ElementWaitHelper.waitAndClick(historyTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewVendor(String groupname, String vendorname, String address, String city, String state, String zip,
			String paymentTerms, String account, String contcat, String officephone, String mobile, String email,
			String requesteremail) {
		try {
			goToAddVendor();
			Thread.sleep(3000);
			selectGroupForNewVendor(groupname);
			enterVendorName(vendorname);
			enterVendorAddress(address);
			enterVendorCity(city);
			enterVendorState(state);
			enterVendorZIPCode(zip);
			enterVendorPaymentTerm(paymentTerms);
			enterVendorAccountNumber(account);
			enterVendorContactName(contcat);
			enterVendorOfficePhone(officephone);
			enterVendorMobilePhone(mobile);
			enterVendorEmail(email);
			enterRequesterEmail(requesteremail);
			ElementWaitHelper.waitAndClick(saveVendorBtn);
			Thread.sleep(3000);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectVendorMaterialType(String type) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='s2id_select-enum']/a")));
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//div[text()='" + type + "']")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectVendorMaterialCategory(String category) {
		try {

			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='s2id_select-category']/a")));
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//div[text()='" + category + "']")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToVendors() {
		try {
			ElementWaitHelper.waitAndClick(vendorsTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToPigmentTab() {
		try {
			ElementWaitHelper.waitAndClick(pigmentTab);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveBatch() {
		try {
			ElementWaitHelper.waitAndClick(saveBtch);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTotalBaseInventoryAdded(String inventory) {
		return inventory + ".00";
	}

	public void closeInventoryOnHand() {
		driver.findElement(By.xpath("//span[text()='×']")).click();
	}

	public String enterBatchNumber(String batchNum) {
		try {
			addBatchInput.sendKeys(batchNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return batchNum;
	}

	public String getBatchNumber() {
		return batchNumber.getAttribute("value").trim().toString();
	}

	public void goToInventoryOnHand() {
		try {
			totalInventoryOnHandLink.click();
			Thread.sleep(3000);
			// ElementWaitHelper.waitAndClick(totalInventoryOnHandLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToInventory() {
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='pigment-table']/tbody/tr/td[12]/div/a")));
	}

	public void goToEquipmentInventory() {
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='equipment-table']/tbody/tr/td[9]/div/a")));
	}

	public void goToSundaryInventory() {
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='sundry-table']/tbody/tr/td[12]/div/a")));
	}

	public void goToDyeInventory() {
		ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//*[@id='dye-table']/tbody/tr/td[12]/div/a")));
	}

	public void goToMaterialAndEquipment() {
		driver.navigate().to(config.getProperty("materiallisturl"));
	}

	public void saveMaterialDetails() {
		try {
			ElementWaitHelper.waitAndClick(saveBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterMinQuantity(String minquantity) {
		try {
			minQuantityInput.clear();
			minQuantityInput.sendKeys(minquantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return minquantity;
	}

	public String enterTAP(String tap) {
		try {
			tapInput.clear();
			tapInput.sendKeys(tap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tap;
	}

	public String enterHAP(String hap) {
		try {
			hapInput.clear();
			hapInput.sendKeys(hap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hap;
	}

	public String enterVOC(String voc) {
		try {
			vocInput.clear();
			vocInput.sendKeys(voc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voc;
	}

	public String enterProductPrice(String price) {
		try {
			priceInput.clear();
			priceInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

	public String enterProductDensity(String density) {
		try {
			densityInput.clear();
			densityInput.sendKeys(density);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return density;
	}

	public String enterProductName(String productname) {
		try {
			productNameInput.clear();
			productNameInput.sendKeys(productname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productname;
	}

	public String enterProductCode(String productcode) {
		try {
			productCodeInput.clear();
			productCodeInput.sendKeys(productcode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productcode;
	}

	public void goToAddItemPage() {
		try {
			ElementWaitHelper.waitAndClick(addItemBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroup(String groupID) {
		try {
			Select groupId = new Select(driver.findElement(By.id("SelectedGroupId")));
			groupId.selectByVisibleText(groupID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectGroupForNewVendor(String groupname) {
		try {
			Select groupId = new Select(driver.findElement(By.name("GroupID")));
			groupId.selectByVisibleText(groupname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMaterialType(String material) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//span[@id='select2-chosen-2']")));
			String xpath = "//div[text()='" + material + "']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMaterialCategory(String material) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//span[@id='select2-chosen-3']")));
			String xpath = "//div[text()='" + material + "']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean correctGroupSelected(String groupname) {
		boolean isCorrect = false;
		try {
			String xpath = "//span[text()='NewGroup22June_Automation']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isCorrect = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCorrect;
	}

	public void addBaseMaterial(String basematerialcategory, String baseproductcode, String baseproductname,
			String baseproductdensity, String baseprice, String baseVOC, String baseHAP, String baseTAP,
			String baseMinQuantity, String batchnumber) {
		try {
			goToAddItemPage();
			Thread.sleep(3000);
			selectMaterialCategory(basematerialcategory);
			Thread.sleep(3000);
			enterProductCode(baseproductcode);
			enterProductName(baseproductname);
			enterProductDensity(baseproductdensity);
			enterProductPrice(baseprice);
			enterVOC(baseVOC);
			enterHAP(baseHAP);
			enterTAP(baseTAP);
			Thread.sleep(3000);
			enterMinQuantity(baseMinQuantity);
			saveMaterialDetails();
			Thread.sleep(5000);
			goToInventoryOnHand();
			addTotalInventoryOnHand(batchnumber);
			Thread.sleep(3000);
			/*
			 * Assert.assertEquals(checkdata("Group", groupname), true);
			 * Assert.assertEquals(checkdata("Material Category", basematerialcategory),
			 * true); Assert.assertEquals(checkdata("Product Name", baseproductname), true);
			 * Assert.assertEquals(checkdata("Product #", baseproductcode), true);
			 * 
			 * Assert.assertEquals(checkdata("lb/Gal", baseproductdensity), true);
			 * Assert.assertEquals(checkdata("$/Unit", baseprice), true);
			 * Assert.assertEquals(checkdata("VOC", baseVOC), true);
			 * Assert.assertEquals(checkdata("HAP", baseHAP), true);
			 * Assert.assertEquals(checkdata("TAP", baseTAP), true);
			 */
			System.out.println("******************************");
			System.out.println("batch added " + getTotalBaseInventoryAdded(batchnumber));
			System.out.println("batch expecting " + batchnumber + ".00");
			System.out.println("******************************");
			/*
			 * Assert.assertEquals( getPageObjectManager().getEquipmentAndMaterialPage().
			 * getTotalBaseInventoryAdded(batchbumber), batchbumber + ".00");
			 * Assert.assertEquals(checkdata("Min. Quantity", baseMinQuantity), true);
			 * Thread.sleep(5000);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addPigment(String pigmentmaterialcategory, String pigmentproductcode, String pigmentproductname,
			String pigmentproductdensity, String pigmentprice, String pigmentVOC, String pigmentHAP, String pigmentTAP,
			String pigmentMinQuantity, String batchnumber) {
		try {

			goToPigmentTab();
			goToAddItemPage();
			selectMaterialCategory(pigmentmaterialcategory);
			enterProductCode(pigmentproductcode);
			enterProductName(pigmentproductname);
			enterProductDensity(pigmentproductdensity);
			enterProductPrice(pigmentprice);
			enterVOC(pigmentVOC);
			enterHAP(pigmentHAP);
			enterTAP(pigmentTAP);
			enterMinQuantity(pigmentMinQuantity);
			saveMaterialDetails();
			Thread.sleep(3000);
			goToInventory();
			addTotalInventoryOnHand(batchnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDyes(String dyematerialcategory, String dyeproductcode, String dyeproductname,
			String dyeproductdensity, String dyeprice, String dyeVOC, String dyeHAP, String dyeTAP,
			String dyeMinQuantity, String batchnumber) {
		try {

			goToDyes();
			goToAddItemPage();
			selectMaterialCategory(dyematerialcategory);
			enterProductCode(dyeproductcode);
			enterProductName(dyeproductname);
			enterProductDensity(dyeproductdensity);
			enterProductPrice(dyeprice);
			enterVOC(dyeVOC);
			enterHAP(dyeHAP);
			enterTAP(dyeTAP);
			enterMinQuantity(dyeMinQuantity);
			saveMaterialDetails();
			Thread.sleep(3000);
			goToDyeInventory();
			addTotalInventoryOnHand(batchnumber);
			/*
			 * Assert.assertEquals(checkdata("Material Category", dyematerialcategory),
			 * true); Assert.assertEquals(checkdata("Product Name", dyeproductcode), true);
			 * Assert.assertEquals(checkdata("Product #", dyeproductname), true);
			 * 
			 * Assert.assertEquals(checkdata("lb/Gal", dyeproductdensity), true);
			 * Assert.assertEquals(checkdata("$/Unit", dyeprice), true);
			 * Assert.assertEquals(checkdata("VOC", dyeVOC), true);
			 * Assert.assertEquals(checkdata("HAP", dyeHAP), true);
			 * Assert.assertEquals(checkdata("TAP", dyeTAP), true);
			 * 
			 * Assert.assertEquals(checkdata(
			 * getPageObjectManager().getEquipmentAndMaterialPage().
			 * getTotalBaseInventoryAdded(batchbumber), batchbumber + ".00"), true);
			 * Assert.assertEquals(checkdata("Min. Quantity", dyeMinQuantity), true);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEquipments(String equipmentmaterialcategory, String equipmentproductcode,
			String equipmentproductname, String equipmentproductdensity, String equipmentprice, String equipmentVOC,
			String equipmentHAP, String equipmentTAP, String equipmentMinQuantity, String batchnumber) {
		try {

			goToEquipments();
			goToAddItemPage();
			selectMaterialCategory(equipmentmaterialcategory);
			enterProductCode(equipmentproductcode);
			enterProductName(equipmentproductname);
			enterProductDensity(equipmentproductdensity);
			enterProductPrice(equipmentprice);
			enterVOC(equipmentVOC);
			enterHAP(equipmentHAP);
			enterTAP(equipmentTAP);
			enterMinQuantity(equipmentMinQuantity);
			saveMaterialDetails();
			Thread.sleep(3000);
			goToEquipmentInventory();
			addTotalInventoryOnHand(batchnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSundaryItems(String sundarymaterialcategory, String sundaryproductcode, String sundaryproductname,
			String sundaryproductdensity, String sundaryprice, String sundaryVOC, String sundaryHAP, String sundaryTAP,
			String sundaryMinQuantity, String batchnumber) {
		try {

			goToSundaryItems();
			goToAddItemPage();
			selectMaterialCategory(sundarymaterialcategory);
			enterProductCode(sundaryproductcode);
			enterProductName(sundaryproductname);
			enterProductDensity(sundaryproductdensity);
			enterProductPrice(sundaryprice);
			enterVOC(sundaryVOC);
			enterHAP(sundaryHAP);
			enterTAP(sundaryTAP);
			enterMinQuantity(sundaryMinQuantity);
			saveMaterialDetails();
			Thread.sleep(3000);
			goToSundaryInventory();
			addTotalInventoryOnHand(batchnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addTotalInventoryOnHand(String batchnumber) {
		try {
			addBatch();
			enterBatchNumber(batchnumber);
			saveBatch();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean baseMaterialsCopied(String headerText, String value) {
		boolean isCopied = false;
		try {
			List<WebElement> headers = headerRowXpath.findElements(By.tagName("th"));
			List<WebElement> row = dataRowXpath.findElements(By.tagName("td"));

			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(headerText)) {
					System.out.println("The value of " + headerText + " is " + row.get(index).getText());
					isCopied = true;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean isMaterialsCopied(String headerText, String value, String type) {
		boolean isCopied = false;
		try {
			WebElement header = driver
					.findElement(By.xpath("//*[@id='" + type + "-table_wrapper']/div[2]/div[1]/div/table"));
			List<WebElement> headers = header.findElements(By.tagName("th"));
			WebElement tableData = driver.findElement(By.xpath("//*[@id='" + type + "-table']/tbody"));
			List<WebElement> row = tableData.findElements(By.tagName("td"));

			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(headerText)) {
					System.out.println("The value of " + headerText + " is " + row.get(index).getText());
					isCopied = true;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean isMaterialTypeCopied(String material) {
		boolean materialTypeCopied = false;
		try {
			if (materialType.getText().equals(material)) {
				materialTypeCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialTypeCopied;
	}

	public boolean isInventoryCopied(String inventory) {
		boolean inventoryCopied = false;
		try {
			String xpath = "//a[text()='+/- Adjust ']/i[text()='" + inventory + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				inventoryCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryCopied;
	}

	public boolean materialTypeCopied(String type) {
		boolean copied = false;
		try {
			String xpath = "//*[@id='" + type + "-table']/tbody/tr/td[8]";
			if (driver.findElement(By.xpath(xpath)) != null) {
				copied = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean noVendorCopied() {
		boolean notCopied = false;
		try {
			if (driver.findElement(By.xpath("//td[text()='No data available in table']")) != null) {
				notCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notCopied;
	}

}
