package pageObjectsAndroid;

import java.io.IOException;
import java.time.Duration;
import java.util.Dictionary;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BankTransferPageObjects extends GlobalVariables {

	private static String SheetName = "Login";
	private static Dictionary<String, String> dataList;
	private static Assertion a = new Assertion();
	private static ConfigFileReader con = new ConfigFileReader();

	abstract class GenericDriverAbstract {
		// protected WebDriver driver;

		protected AppiumDriver driver;

		public GenericDriverAbstract(AppiumDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	}

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "BankTransferData";
		} else {
			pageObjectsSheetName = "BankTransferData"; // this sheet is used for ids
		}
		System.out.println("Page Object Sheet Name = " + pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

	public static void goToBankPaymentScreen() throws InterruptedException {
		try {
			log.info("Click bank button");
//			InitialiseSDKPageObjects.waitToExecuteNextLine("netBankingButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("netBankingButton");
			InitialiseSDKPageObjects.explicitwait("netBankingButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("netBankingButton"));
//			InitialiseSDKPageObjects.waitTillElementPresent("bank");
			InitialiseSDKPageObjects.explicitwait("bank");
			String bank = driver.findElementByXPath(dictPageObjects.get("bank")).getText();
			a.assertTrue(bank.contains(dict.get("bankText")));
		} catch (Exception e) {
			System.out.println("User did not redirect to bank payment screen");
		}
		
	}

	public static WebElement scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
		return driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().id(\"checkSumPaymentET\"));"));
	}

	public static void invalidCheckSum() throws IOException, InterruptedException {

		scrollToAnElementByText(driver, "");
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textContains(\""+text+"\").instance(0))")
		driver.findElementByXPath(dictPageObjects.get("checkSumPayment"));
		InitialiseSDKPageObjects.enterField(dict.get("invalidCheckSum"), dictPageObjects.get("checkSumPayment"));
		for (int i = 0; i <= 3; i++) {
			driver.executeScript("seetest:client.swipe(\"Down\", 100, 500)");
		}
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
		goToBankPaymentScreen();
		InitialiseSDKPageObjects.waitTillElementPresent("selectBankFromList");
		driver.findElementByXPath(dictPageObjects.get("bottomSheetCloseButton")).click();

	}

	public static void clickButton(String button) {
		driver.findElementByXPath(button).click();
	}

	public static void verifySuccessPopUp(String xPath) {
//		InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
//		InitialiseSDKPageObjects.waitTillElementPresent("BankPaymenetSuccess");
		InitialiseSDKPageObjects.explicitwait("BankPaymenetSuccess");
		String successMessageXPath = driver.findElementByXPath(xPath).getText();
		String successMessageString = con.getSuccessMessage();
		a.assertEquals(successMessageXPath, successMessageString);
		log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: "
				+ successMessageString);
	}

	public static void click_On_Ok_Button(String xPath) {
		log.info("==== Click on OK Button ========");
		driver.findElementByXPath(xPath).click();
	}

	/*
	 * public static void successfulBankPayment() throws IOException,
	 * InterruptedException { //
	 * InitialiseSDKPageObjects.waitTillElementPresent("selectBankFromList");
	 * InitialiseSDKPageObjects.explicitwait("selectBankFromList");
	 * driver.findElementByXPath(dictPageObjects.get("selectBankFromList")).click();
	 * Thread.sleep(1000); String bank =
	 * driver.findElementByXPath(dictPageObjects.get("bankName")).getText();
	 * a.assertTrue(bank.contains(dict.get("bankName"))); //
	 * driver.findElementByName("AIB Ireland").click();
	 * driver.findElementByXPath(dictPageObjects.get("bankName")).click(); for (int
	 * i = 0; i <= 1 ; i++) {
	 * driver.executeScript("seetest:client.swipe(\"Down\", 100, 500)"); }
	 * Thread.sleep(1000); InitialiseSDKPageObjects.explicitwait("initiateButton");
	 * // InitialiseSDKPageObjects.waitTillElementPresent("initiateButton");
	 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("initiateButton"));
	 * InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); }
	 */
	//QA-ADG
	public static void successfulBankPayment() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("selectBankFromList");
			InitialiseSDKPageObjects.explicitwait("selectBankFromList");
			driver.findElementByXPath(dictPageObjects.get("selectBankFromList")).click();
			Thread.sleep(1000);
//			driver.findElementByXPath(dictPageObjects.get("AIBIrelandbankName")).getText();
//			a.assertTrue(bank.contains(dict.get("bankName")));
//			driver.findElementByName("AIB Ireland").click();
			driver.findElementByXPath(dictPageObjects.get("AIBIrelandbankName")).click();
			Thread.sleep(1000);
//			MobileCapabilities.Swipedown();
			Thread.sleep(1000);
			InitialiseSDKPageObjects.explicitwait("initiateButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("initiateButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("initiateButton"));
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void verifyErrorMessage(String xPath, String errorString) {
		String errorMessageXPath = driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
		String errorMessageString = con.getErrorMessage(errorString);
		a.assertEquals(errorMessageXPath, errorMessageString);
		log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: " + errorMessageString);
	}
}