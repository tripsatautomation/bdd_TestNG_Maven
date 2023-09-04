package com.awfi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page.SetWebLifecycleStateState;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.awfi.driver.DriverSetup;
import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class FormulasPage {

	private WebDriver driver;
	private ConfigReader config;

	public FormulasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(xpath = "//a[text()=' New Formulation']")
	private WebElement newFormulationBtn;

	@FindBy(id = "Name")
	private WebElement formulaNameInput;

	@FindBy(id = "ManufacturersProductCode")
	private WebElement manufactorProducCodeInput;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createFormula;

	@FindBy(xpath = "//a[@id='btn-edit']")
	private WebElement editFormulaBtn;

	@FindBy(xpath = "//input[@id='bmGrams']")
	private WebElement baseQuantityTxtInput;

	@FindBy(xpath = "//input[@id='dyeGrams']")
	private WebElement dyeQuantityTxtInput;

	@FindBy(xpath = "//input[@id='pigGrams']")
	private WebElement pigmentQuantityTxtInput;

	@FindBy(xpath = "//button[@id='save-formula']")
	private WebElement saveFormulaBtn;

	@FindBy(id = "EmployeeName")
	private WebElement empNameInput;

	@FindBy(id = "MarkUp")
	private WebElement markupTextInput;

	@FindBy(id = "ContainerPrice")
	private WebElement containerPriceTxtInput;

	@FindBy(id = "SpexDeltaL")
	private WebElement spexDeltaLTextInput;

	@FindBy(id = "Substrate")
	private WebElement substrateTextInput;

	@FindBy(id = "Notes")
	private WebElement notesTextInput;

	@FindBy(xpath = "//h3[@id='totalWeight']")
	private WebElement totalWeight;

	public boolean doesTotalWeightCopied(String totalwt) {
		boolean totalwightCopied = false;
		try {
			if (totalWeight.getText().equals(totalwt)) {
				totalwightCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalwightCopied;
	}

	public void enterNotes(String value) {
		try {
			notesTextInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "CustomerName")
	private WebElement customerNameInput;

	public void enterCustomerName(String value) {
		try {
			customerNameInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "PurchaseOrderNumber")
	private WebElement poTxtInput;

	public void enterPurchaseOrder(String value) {
		try {
			poTxtInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterSubstrate(String value) {
		try {
			substrateTextInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterSpexDeltaL(String value) {
		try {
			spexDeltaLTextInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpexDeltaA")
	private WebElement spexDeltaATxtInput;

	public void enterSpexDeltaA(String value) {
		try {
			spexDeltaATxtInput.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpinDeltaE")
	private WebElement spinDeltaETxtInput;

	public void enterSpinDeltaE(String price) {
		try {
			spinDeltaETxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpexDeltaB")
	private WebElement spexDeltaBTxtInput;

	public void enterSpexDeltaB(String price) {
		try {
			spexDeltaBTxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpexDeltaE")
	private WebElement spexDeltaETxtInput;

	public void enterSpexDeltaE(String price) {
		try {
			spexDeltaETxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpinDeltaL")
	private WebElement spinDeltaLTxtInput;

	public void enterSpinDeltaL(String price) {
		try {
			spinDeltaLTxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpinDeltaA")
	private WebElement spinDeltaATxtInput;

	public void enterSpinDeltaA(String price) {
		try {
			spinDeltaATxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "SpinDeltaB")
	private WebElement spinDeltaBTxtInput;

	public void enterSpinDeltaB(String price) {
		try {
			spinDeltaBTxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterContainerPrice(String price) {
		try {
			containerPriceTxtInput.sendKeys(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEmployeeName(String name) {
		try {
			empNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterMarkup(String markup) {
		try {
			markupTextInput.clear();
			markupTextInput.sendKeys(markup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFormula() {
		try {
			ElementWaitHelper.waitAndClick(saveFormulaBtn);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveBaseQuantity() {
		try {
			List<WebElement> addBtns = driver.findElements(By.xpath("//*[@class='btn-move']"));
			addBtns.get(0).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveDyeQuantity() {
		try {
			List<WebElement> addBtns = driver.findElements(By.xpath("//*[@class='btn-move']"));
			addBtns.get(2).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void movePigmentQuantity() {
		try {
			List<WebElement> addBtns = driver.findElements(By.xpath("//*[@class='btn-move']"));
			addBtns.get(1).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPigmentQuantityInGrams(String grams) {
		try {
			pigmentQuantityTxtInput.sendKeys(grams);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDyeQuantityInGrams(String grams) {
		try {
			dyeQuantityTxtInput.sendKeys(grams);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterBaseQuantityInGrams(String basegrams) {
		try {
			baseQuantityTxtInput.sendKeys(basegrams);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToEditFormula() throws InterruptedException {
		editFormulaBtn.click();
		Thread.sleep(5000);
	}

	public void goToFormulas() throws InterruptedException {
		driver.navigate().to(config.getProperty("formulaurl"));
		Thread.sleep(5000);
		// DriverSetup.dismissAjaxPopup(driver);
	}

	public void createNewFormula(String formulacategory, String formulaname, String formulanumber) {
		try {
			goToCreateFormula();
			selectProductCategory(formulacategory);
			enterFormulaName(formulaname);
			enterManufacturProductCode(formulanumber);
			createFormula();
			// DriverSetup.dismissAjaxPopup(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editFormula(String basegram, String pigmentgram, String dyeGram, String employee, String markup,
			String spexDeltaL, String spexDeltaA, String spexDeltaB, String spexDeltaE, String spinDeltaL,
			String spinDeltaA, String spinDeltaB, String spinDeltaE, String substrate, String purchaseorder,
			String customername, String notes) {
		try {
			goToEditFormula();
			enterBaseQuantityInGrams(basegram);
			moveBaseQuantity();
			enterPigmentQuantityInGrams(pigmentgram);
			movePigmentQuantity();
			enterDyeQuantityInGrams(dyeGram);
			moveDyeQuantity();
			saveFormula();
			enterEmployeeName(employee);
			enterMarkup(markup);
			enterSpexDeltaL(spexDeltaL);
			enterSpexDeltaA(spexDeltaA);
			enterSpexDeltaB(spexDeltaB);
			enterSpexDeltaE(spexDeltaE);

			enterSpinDeltaL(spinDeltaL);
			enterSpinDeltaA(spinDeltaA);
			enterSpinDeltaB(spinDeltaB);
			enterSpinDeltaE(spinDeltaE);

			enterSubstrate(substrate);
			enterPurchaseOrder(purchaseorder);
			enterCustomerName(customername);
			enterNotes(notes);
			saveFormula();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createFormula() {
		try {
			ElementWaitHelper.waitAndClick(createFormula);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterManufacturProductCode(String code) {
		try {
			manufactorProducCodeInput.sendKeys(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFormulaName(String name) {
		try {
			formulaNameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectProductCategory(String category) {
		try {
			Thread.sleep(3000);
			Select productCategory = new Select(driver.findElement(By.name("CategoryId")));
			productCategory.selectByVisibleText(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToCreateFormula() {
		try {
			ElementWaitHelper.waitAndClick(newFormulationBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkFormulaCopied(String header, String value, String type) {
		boolean isCopied = false;
		try {
			// goToEditFormula();
			WebElement xpathHeader = driver
					.findElement(By.xpath("//*[@id='formulation-table_wrapper']/div[2]/div[1]/div/table"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='formulation-table']"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean isStatusComplete(String status) {
		String xpath = "//*[@id='formulation-table_wrapper']/div[2]/div[1]";
		boolean isCopied = false;
		try {
			WebElement xpathHeader = driver.findElement(By.xpath(xpath));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='formulation-table']"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals("Status") && tds.get(index).getText().equals(status)) {
					System.out.println("The value of status is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean doesBaseBatchCopiedOnEditFormula(String batch) {
		boolean isBatchCopied = false;
		try {
			// #84 - 44.89
			String xpath = "//option[text()='" + batch + " Gal']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				isBatchCopied = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isBatchCopied;
	}

	public boolean doesBatchSizeGetsCopied(String batchsize) {
		boolean batchcopied = false;
		try {
			WebElement batch = driver.findElement(By.xpath("//*[@id='grams-batch']"));
			if (batch.getText().equals(batchsize)) {
				batchcopied = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return batchcopied;
	}

	public boolean checkEditedBase(String header, String value) {
		boolean isCopied = false;
		try {
			WebElement xpathHeader = driver.findElement(By.xpath("//*[@id='table-base_wrapper']/div[2]/div[1]/div"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-base']"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of Base " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean checkEditedPigments(String header, String value) {
		boolean isCopied = false;
		try {
			WebElement xpathHeader = driver
					.findElement(By.xpath("//*[@id='table-pigments_wrapper']/div[2]/div[1]/div"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-pigments']"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of Pigments " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean checkEditedDyes(String header, String value) {
		boolean isCopied = false;
		try {
			WebElement xpathHeader = driver.findElement(By.xpath("//*[@id='table-dyes_wrapper']/div[2]/div[1]/div"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-dyes']"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of Dyes " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean checkColorFormulaCopied(String header, String value) {
		boolean isCopied = false;
		try {

			WebElement xpathHeader = driver
					.findElement(By.xpath("//*[@id='table-selected_wrapper']/div[2]/div[1]/div/table/thead/tr"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-selected']/tbody"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean checkPigmentColorFormulaCopied(String header, String value) {
		boolean isCopied = false;
		try {

			WebElement xpathHeader = driver
					.findElement(By.xpath("//*[@id='table-selected_wrapper']/div[2]/div[1]/div/table/thead/tr"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-selected']/tbody/tr[2]"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean checkDyeColorFormulaCopied(String header, String value) {
		boolean isCopied = false;
		try {

			WebElement xpathHeader = driver
					.findElement(By.xpath("//*[@id='table-selected_wrapper']/div[2]/div[1]/div/table/thead/tr"));
			List<WebElement> headers = xpathHeader.findElements(By.tagName("th"));
			WebElement row = driver.findElement(By.xpath("//*[@id='table-selected']/tbody/tr[3]"));
			List<WebElement> tds = row.findElements(By.tagName("td"));
			for (int index = 0; index < headers.size(); index++) {
				if (headers.get(index).getText().equals(header) && tds.get(index).getText().equals(value)) {
					System.out.println("The value of " + header + " is " + tds.get(index).getText());
					isCopied = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopied;
	}

	public boolean doesTotalWeightCopied(String basegram, String pigmentgram, String dyegram) {
		boolean iscopied = false;
		try {
			String actualTotalWeight = driver.findElement(By.xpath("//*[@id='totalWeight']")).getText().replace(".00",
					"");
			int actualweight = Integer.parseInt(actualTotalWeight);
			int expectedweight = Integer.parseInt(basegram) + Integer.parseInt(pigmentgram) + Integer.parseInt(dyegram);
			if (actualweight == expectedweight) {
				iscopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iscopied;
	}

	public boolean checkBatchAndInventoryCopiedOnEditFormula(String formulaNumber, String inventory) {
		boolean baseBatchCopied = false;
		try {
			// #42 - 20 Gal
			String xpath = "//*[@id='table-selected']/tbody//select/option[text()='#" + formulaNumber + " - "
					+ inventory + " Gal']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				baseBatchCopied = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return baseBatchCopied;
	}

	public boolean doesMarkupCopied(String markup) {
		boolean copied = false;
		try {
			String xpath = "//*[@id='MarkUp']";
			if (driver.findElement(By.xpath(xpath)).getAttribute("value").equals(markup)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spexDeltaLCopied(String spexDeltaL) {
		boolean copied = false;
		try {
			if (spexDeltaLTextInput.getAttribute("value").equals(spexDeltaL)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spexDeltaACopied(String spexDeltaA) {
		boolean copied = false;
		try {
			if (spexDeltaATxtInput.getAttribute("value").equals(spexDeltaA)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spexDeltaBCopied(String spexDeltaB) {
		boolean copied = false;
		try {
			if (spexDeltaBTxtInput.getAttribute("value").equals(spexDeltaB)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spexDeltaECopied(String spexDeltaE) {
		boolean copied = false;
		try {
			if (spexDeltaETxtInput.getAttribute("value").equals(spexDeltaE)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spinDeltaLCopied(String spinDeltaL) {
		boolean copied = false;
		try {
			if (spinDeltaLTxtInput.getAttribute("value").equals(spinDeltaL)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spinDeltaACopied(String spinDeltaA) {
		boolean copied = false;
		try {
			if (spinDeltaATxtInput.getAttribute("value").equals(spinDeltaA)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public void backToFormula() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Back To Formula']")).click();
		Thread.sleep(3000);
	}

	public boolean checkNotesCopied(String noteText) {
		boolean copied = false;
		try {
			if (notesTextInput.getText().equals(noteText)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spinDeltaBCopied(String spinDeltaB) {
		boolean copied = false;
		try {
			if (spinDeltaBTxtInput.getAttribute("value").equals(spinDeltaB)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean spinDeltaECopied(String spinDeltaE) {
		boolean copied = false;
		try {
			if (spinDeltaETxtInput.getAttribute("value").equals(spinDeltaE)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean substrateCopied(String substrate) {
		boolean copied = false;
		try {
			if (substrateTextInput.getAttribute("value").equals(substrate)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean materialCategoryCopied(String materialCategory) {
		boolean copied = false;
		try {
			String xpath = "//span[text()='" + materialCategory + "']";
			if (driver.findElement(By.xpath(xpath)) != null) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean employeeNameCopied(String name) {
		boolean copied = false;
		try {
			if (empNameInput.getAttribute("value").equals(name)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean formulaNameCopied(String name) {
		boolean copied = false;
		try {
			if (driver.findElement(By.xpath("//*[@id='ManufacturersProductName']")).getAttribute("value")
					.equals(name)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean formulaNumberCopied(String number) {
		boolean copied = false;
		try {
			if (driver.findElement(By.xpath("//*[@id='ManufacturersProductCode']")).getAttribute("value")
					.equals(number)) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean totalWieghtCopied(String base, String pigment, String dye) {
		boolean copied = false;
		try {
			int total = Integer.parseInt(base) + Integer.parseInt(pigment) + Integer.parseInt(dye);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String gettext = (String) js.executeScript("return arguments[0].value;",
					driver.findElement(By.id("GramsInBatch")));

			if (gettext.replace(".00", "").equals(Integer.toString(total))) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean purchaseOrderNotCopied(String name) {
		boolean copied = false;
		try {
			if (poTxtInput.getAttribute("value") == null) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}

	public boolean customerNameNotCopied(String name) {
		boolean copied = false;
		try {
			if (customerNameInput.getAttribute("value") == null) {
				copied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copied;
	}
}
