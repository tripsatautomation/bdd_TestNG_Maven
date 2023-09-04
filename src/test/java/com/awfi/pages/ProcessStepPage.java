package com.awfi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.ElementWaitHelper;

public class ProcessStepPage {

	private WebDriver driver;
	private ConfigReader config;

	public ProcessStepPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		config = new ConfigReader();
	}

	@FindBy(xpath = "//a[text()=' Create New']")
	private WebElement createBtn;

	public void goToCreateProcessStep() {
		ElementWaitHelper.waitAndClick(createBtn);
	}

	@FindBy(id = "Description")
	private WebElement nameInput;

	@FindBy(id = "ManufacturersProductCode")
	private WebElement numberInput;

	@FindBy(xpath = "//button[text()='Save Sub-step']")
	private WebElement saveStepBtn;

	public void saveSubStep() {
		try {
			ElementWaitHelper.waitAndClick(saveStepBtn);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterProcessNumber(String name) {
		try {
			numberInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public void selectIndustrySector(String industry) {
		try {
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath("//span[text()='Aerospace']")));
			String xpath = "//div[text()='" + industry + "']";
			ElementWaitHelper.waitAndClick(driver.findElement(By.xpath(xpath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToProcessSteps() throws Exception {
		driver.navigate().to(config.getProperty("processstepsurl"));
		Thread.sleep(3000);
	}

	public String getProcessStepID() {
		String processStepID = null;
		try {
			WebElement row = driver.findElement(By.xpath("//*[@id='finishing-steps']/tbody/tr"));
			processStepID = row.findElements(By.tagName("td")).get(0).getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return processStepID;
	}

	public String enterProcessName(String name) {
		try {
			nameInput.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public boolean checkProcessStepsDataDisplayedCorrectly(String headerName, String value) {
		boolean isDataCorrect = false;
		try {
			WebElement table = driver.findElement(By.xpath("//div[@class='dataTables_scroll']"));
			List<WebElement> divTags = table.findElements(By.tagName("div"));

			List<WebElement> headers = divTags.get(0).findElements(By.tagName("th"));

			WebElement tdDiv = driver.findElement(By.xpath("//*[@id='finishing-steps_wrapper']/div[2]/div[2]"));
			List<WebElement> tds = tdDiv.findElements(By.tagName("td"));

			for (int index = 0; index < headers.size(); index++) {
				System.out.println(headers.get(index).getText());
				if (headers.get(index).getText().equals(headerName)) {
					System.out.println("actual text " + tds.get(index).getText().toString());
					isDataCorrect = true;
				}
			}
			System.out.println("expected text " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDataCorrect;
	}

	public void createNewProcessSteps(String processstepname, String industrytype) {
		try {
			goToCreateProcessStep();
			enterProcessName(processstepname);
			Thread.sleep(3000);
			selectIndustrySector(industrytype);
			saveSubStep();
			goToProcessSteps();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doesProcessStepsCopied(String headerText, String value) {
		boolean isCopied = false;
		try {
			WebElement header = driver.findElement(By.xpath("//*[@id='finishing-steps_wrapper']/div[2]/div[1]"));
			List<WebElement> headers = header.findElements(By.tagName("th"));
			WebElement tableData = driver.findElement(By.xpath("//*[@id='finishing-steps_wrapper']/div[2]/div[2]"));
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

}
