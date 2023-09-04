package com.awfi.utilities;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.awfi.driver.DriverSetup;

public class CommonUtils {
	private WebDriver driver;

	public CommonUtils(WebDriver driver) {

		this.driver = driver;
	}

	public static void reload() {
		DriverSetup.driver.navigate().refresh();
	}

	public static String generateAlphabeticalString() {
		int length = 7;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomAscii = random.nextInt(26) + 65;
			char randomChar = (char) randomAscii;
			sb.append(randomChar);
		}
		String randomstring = sb.toString();
		return randomstring;

	}

	public static String generateSSN() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			int randomNumber = random.nextInt(10);
			sb.append(randomNumber);
		}
		return sb.toString();
	}

	public static String generateRandomInteger() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int randomNumber = random.nextInt(10);
			sb.append(randomNumber);
		}
		return sb.toString();
	}

	public static String enterValue() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		// Generate the random numbers
		for (int i = 0; i < 2; i++) {
			int randomNumber = random.nextInt(10);
			sb.append(randomNumber);
		}

		// Remove leading zeros if present
		String result = sb.toString();
		result = result.replaceFirst("^0+(?!$)", "");

		return result;
	}

	public static void scroll() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverSetup.driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	public void goToSideMenu(String menu) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String generateRandomPhoneNumber() {
		Random random = new Random();

		// Generate random numbers
		int firstPart = random.nextInt(900) + 100; // Generates a number between 100 and 999
		int secondPart = random.nextInt(900) + 100;
		int thirdPart = random.nextInt(9000) + 1000;

		// Format the numbers as a phone number
		String phoneNumber = String.format("%d-%d-%d", firstPart, secondPart, thirdPart);

		return phoneNumber;
	}

	public static String generatePassword() {
		int minLength = 8;
		int maxLength = 15;

		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";

		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		// Generate a random length between minLength and maxLength
		int length = random.nextInt(maxLength - minLength + 1) + minLength;

		// Generate at least one number
		char randomDigit = numbers.charAt(random.nextInt(numbers.length()));
		stringBuilder.append(randomDigit);

		// Generate remaining characters (alphabets)
		for (int i = 1; i < length; i++) {
			char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
			stringBuilder.append(randomChar);
		}

		return stringBuilder.toString();
	}

	public static String generateRandomEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
		int length = 4;
		StringBuilder email = new StringBuilder();

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(allowedChars.length());
			email.append(allowedChars.charAt(index));
		}

		email.append("@gmail.com");
		return email.toString();
	}

	public void scrollRight() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(1000, 0);");
	}

}
