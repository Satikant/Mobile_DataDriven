package genericFeatures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import pageObjectsAndroid.HomeScreenPageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class commonLibrary extends GlobalVariables {
	private static Assertion a = new Assertion();
	private static Properties properties;
	private final String propertyFilePath = "res//strings.properties";
	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

	public commonLibrary() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	// *----QA_ADG--- iOS -------*//
	public static void iOSswipedown() {
		HashMap<String, Object> scrollObj = new HashMap<>();
		scrollObj.put("direction", "down");
		GlobalVariables.driver.executeScript("mobile: scroll", scrollObj);
	}

	public static void clickButton(String button) {
		GlobalVariables.driver.findElementByXPath(dictPageObjects.get(button)).click();
	}

	public static void sendkeys(String element, String values) {
		GlobalVariables.driver.findElementByXPath(dictPageObjects.get(element)).sendKeys(dictPageObjects.get(values));
	}

	public static void clearfield(String element) {
		GlobalVariables.driver.findElementByXPath(dictPageObjects.get(element)).clear();
	}

	public static void explicitWait(String locator) {
		WebDriverWait wait = new WebDriverWait(GlobalVariables.driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(dictPageObjects.get(locator))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dictPageObjects.get(locator)))));
	}

	public static void implicitWait() {
		GlobalVariables.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public static boolean isElementPresent(String element) {
		try {
			GlobalVariables.driver.findElementByXPath(dictPageObjects.get(element));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

//	public static String captureExpectedText(String message) {
//		String actual = properties.getProperty(message);
//		if (actual != null)
//			return actual;
//		else
//			throw new RuntimeException("String not found");
//	}
	public static void verifysuccessmesage(String xPath, String message) {
		explicitWait("iOSBankPaymentSuccess");
		String successMessageXPath = GlobalVariables.driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
		String successMessageString = dictPageObjects.get(message);
		a.assertEquals(successMessageXPath, successMessageString);
		log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: "
				+ successMessageString);
	}

	public static void verifyfailuremesage(String xPath, String message) {
		explicitWait("iOSBankPaymentFailure");
		String successMessageXPath = GlobalVariables.driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
		String successMessageString = dictPageObjects.get(message);
		a.assertEquals(successMessageXPath, successMessageString);
		log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: "
				+ successMessageString);
	}

	public static String captureExpectedText(String message) {
		return properties.getProperty(message);
	}

	public static void waitTillElementPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dictPageObjects.get(locator)))));
	}
}
