package com.awfi.driver;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.awfi.utilities.CommonUtils;
import com.awfi.utilities.ConfigReader;
import com.awfi.utilities.DataAccess;
import com.awfi.utilities.ElementWaitHelper;

public class DriverSetup {

	public static WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	private static ConfigReader config;
	private static CommonUtils common;
	private PageObjectManager pageObjectManager;
	private ElementWaitHelper waitHelper;
	private DataAccess db;

	@BeforeSuite
	public void setUp() {
		config = new ConfigReader();
		String workingDir = System.getProperty("user.dir");

		// Set the path to chromedriver.exe relative to the working directory
		String driverPath = Paths.get(workingDir, "chromedriver.exe").toString();

		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.navigate().to(config.getProperty("url"));
		common = new CommonUtils(driver);
		db = new DataAccess();
		pageObjectManager = new PageObjectManager(driver);
		waitHelper = new ElementWaitHelper(driver);
		@SuppressWarnings("deprecation")
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(config.getProperty("reportoutput"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	public DataAccess getDB() {
		return db;
	}

	public static void dismissAjaxPopup(WebDriver driver) {
		// Wait for the popup to appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		// Switch to the alert and dismiss it
		alert.dismiss();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CommonUtils getUtils() {
		return common;
	}

	public ElementWaitHelper getWaitHelper() {
		return waitHelper;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ConfigReader getConfig() {
		return config;
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void s(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
		} else {
			test.log(Status.PASS, "Test Passed");
		}

	}

	@AfterSuite
	public void tearDown() {

		extent.flush();
	}

	public boolean checkdata(String headerName, String value) {
		boolean isDataCorrect = false;
		try {
			WebElement table = driver.findElement(By.xpath("//*[@id='base-table_wrapper']/div[2]"));
			List<WebElement> divTags = table.findElements(By.tagName("div"));

			List<WebElement> headers = divTags.get(0).findElements(By.tagName("th"));
			WebElement tdDiv = driver.findElement(By.xpath("//*[@id='base-table_wrapper']/div[2]/div[2]"));
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

}
