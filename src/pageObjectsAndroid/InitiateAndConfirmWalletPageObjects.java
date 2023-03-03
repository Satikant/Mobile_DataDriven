package pageObjectsAndroid;

import java.io.IOException;
import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InitiateAndConfirmWalletPageObjects extends GlobalVariables {

	private static String SheetName = "Login";
	private static Dictionary<String, String> dataList;
	private static Assertion a = new Assertion();
	private static ConfigFileReader con = new ConfigFileReader();

	abstract class GenericDriverAbstract {    
		//protected  WebDriver driver;

		protected AppiumDriver driver;

		public GenericDriverAbstract(AppiumDriver driver)
		{
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
			pageObjectsSheetName = "InitiateWalletData";
		}
		else {  
			pageObjectsSheetName = "InitiateWalletData";
		}
		System.out.println("Page Object Sheet Name = "+pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

	public static void goToInitiateWalletScreen() throws InterruptedException {
		try {
			log.info("Click wallet button");
			InitialiseSDKPageObjects.explicitwait("walletButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("walletButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
			InitialiseSDKPageObjects.explicitwait("Mpesa");
//			InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
			commonLibrary.implicitWait();
			Thread.sleep(7000);
			InitialiseSDKPageObjects.explicitwait("walletContinue");
			commonLibrary.clickButton("walletContinue");
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletContinue"));
			Thread.sleep(7000);
//			InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
			InitialiseSDKPageObjects.explicitwait("PayINR");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the wallet screen");
		}
		
	}
	public static void goTillEnterMSISDNScreen() throws InterruptedException {
		try {
			log.info("Click wallet button");
			InitialiseSDKPageObjects.explicitwait("walletButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("walletButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
			InitialiseSDKPageObjects.explicitwait("Mpesa");
//			InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletContinue"));
			//TODO
			Thread.sleep(1000);
//			InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
//			InitialiseSDKPageObjects.explicitwait("PayINR");
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the MSISDN screen");
		}
	}

	public static void verifyAutofilledMobileNumber() throws IOException, InterruptedException {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("initiateWalletMobileNumber");
			log.info("Verify autofilled mobile number");
			String mobile = driver.findElementByXPath(dictPageObjects.get("initiateWalletMobileNumber")).getText();
			a.assertTrue(mobile.contains(dict.get("mobile")));
		} catch (Exception e) {
			System.out.println("User did not redirect to the msisdn screen");
		}
	}

	public static void verifyDisplayOfReferenceId() throws InterruptedException {
		try {
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitTillElementPresent("referenceId");
			InitialiseSDKPageObjects.explicitwait("referenceId");
		} catch (Exception e) {
			System.out.println("User did not redirect to the reference generation screen");
		}
	}

	public static void verifyReferenceIdCopy() {
		try {
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("copy"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the reference generation screen");
		}
		
	}

	public static void clickOnPay_Mpesa() {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletContinue"));
			InitialiseSDKPageObjects.waitTillElementPresent("payButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payButton"));
			
		} catch (Exception e) {
			System.out.println("User did not redirect to the wallet screen");
		}
		
	}

	public static void clickOnPay_Ecocash() throws InterruptedException {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("Ecocash");
			InitialiseSDKPageObjects.explicitwait("Ecocash");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Ecocash"));
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletContinue"));
//			InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
			InitialiseSDKPageObjects.explicitwait("PayINR");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
			
		} catch (Exception e) {
			System.out.println("User did not redirect to the wallet screen");
		}

	}

	public static void clickOnGenerate() throws InterruptedException {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("payButton");
			Thread.sleep(3000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payButton"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the reference generation screen");
		}
		
	}

	public static void clickOnSubmit() throws InterruptedException {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
			Thread.sleep(3000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("submitButton"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the submit screen");
		}
	}

	public static void confirmPayment() throws InterruptedException {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("confirmButton");
			Thread.sleep(3000);
			log.info("Click on Confirm Payment");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
		} catch (Exception e) {
			System.out.println("User did not redirect to the confirm payment screen");
		}

	}

	public static void verifyConfirmWalletScreen_ReferenceBased() {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("confirmButton");
			InitialiseSDKPageObjects.explicitwait("PayINR");
			log.info("Verify confirm wallet steps - Reference Based");
//			verifyErrorMessage("confirmButton","payplus_sdk_confirm_payment");
//			boolean buttonpresence = driver.findElementByXPath(dictPageObjects.get("PayINR")).isDisplayed();
//			a.assertTrue(buttonpresence, "Submit button is present in the payment confirmation screen");
			String actual = driver.findElementByXPath(dictPageObjects.get("PayINR")).getText();
			String expected = "SUBMIT";
			a.assertEquals(actual, expected);
		} catch (Exception e) {
			System.out.println("User did not redirect to the confirm payment screen");
		}

	}

	public static void verifyConfirmWalletScreen_PushBased() {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("confirmButton");
			log.info("Verify confirm wallet steps - Push Based");
			verifyErrorMessage("confirmButton","payplus_sdk_confirm_payment");
		} catch (Exception e) {
			System.out.println("User did not redirect to the confirm payment screen");
		}
		
	}

	public static void verifyRecurringMessage() {
		InitialiseSDKPageObjects.waitTillElementPresent("recurringText");
		log.info("Verify recurring payment message");
		verifyErrorMessage("recurringText","payplus_sdk_recur_phone_msg");
	}

	public static void invalidMobileNumber() throws IOException, InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElementByXPath(dictPageObjects.get("initiateWalletMobileNumber")).clear();
			driver.findElementByXPath(dictPageObjects.get("initiateWalletMobileNumber")).click();
//			InitialiseSDKPageObjects.enterField(dict.get("invalidMobile"), dictPageObjects.get("initiateWalletMobileNumber"));
			driver.findElementByXPath(dictPageObjects.get("initiateWalletMobileNumber")).sendKeys(dictPageObjects.get("invalidMobile"));//QA-ADG
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
			Thread.sleep(2000);
			//TODO
//			InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
//			verifyErrorMessage("invalidMobileError","Please enter valid mobile number");
			String actual = driver.findElementByXPath(dictPageObjects.get("invalidMobileError")).getText();
			String expected = con.Invalidmsisdnmessage();
			a.assertEquals(actual, expected);
		} catch (Exception e) {
			System.out.println("User did not redirect to the MSISDN screen");
		}
		
	}

	/*
	 * public static void verifyCountryCode() throws IOException,
	 * InterruptedException {
	 * InitialiseSDKPageObjects.waitTillElementPresent("walletHeader");
	 * log.info("Verify country code"); String cc =
	 * driver.findElementByName("+91").getText();
	 * a.assertTrue(cc.contains(dict.get("countryCodeWallet"))); }
	 */

	/*
	 * public static void selectCountryCode() throws IOException,
	 * InterruptedException {
	 * InitialiseSDKPageObjects.waitTillElementPresent("countryCodeSpinner");
	 * driver.findElementByXPath(dictPageObjects.get("countryCodeSpinner")).click();
	 * Thread.sleep(3000); String countryCode =
	 * driver.findElementByName("+91").getText();
	 * a.assertTrue(countryCode.contains(dict.get("countryCodeWallet")));
	 * driver.findElementByName("+91").click(); }
	 */
	public static void clickOnBackButton() throws InterruptedException {
		try {
			log.info("Click back button");
			if (dataList.get("DeviceType").equals("Android")) {
				driver.navigate().back();
				driver.navigate().back();
				driver.navigate().back();
			}
			else {  
				Thread.sleep(1000);
				InitialiseSDKPageObjects.navigateBack();
				Thread.sleep(1000);
				InitialiseSDKPageObjects.navigateBack();
				Thread.sleep(1000);
				InitialiseSDKPageObjects.navigateBack();
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to the back");
		}
		
	}

	public static void verifySuccessPopUp(String xPath){
		try {
			InitialiseSDKPageObjects.explicitwait("CardPaymenetSuccess");
//			InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
			String successMessageXPath = driver.findElementByXPath(xPath).getText();
			String successMessageString = con.getSuccessMessage();
			a.assertEquals(successMessageXPath, successMessageString);
			log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: " + successMessageString);
		} catch (Exception e) {
			System.out.println("User did not redirect to the success screen");
		}
	}

	public static void click_On_Ok_Button(String xPath){
		try {
			InitialiseSDKPageObjects.explicitwait("OKButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("OKButton");
			log.info("==== Click on OK Button ========");
			driver.findElementByXPath(xPath).click();
		} catch (Exception e) {
			System.out.println("User did not redirect to the reference generation screen");
		}
	}

	public static void successfulBankPayment() throws IOException, InterruptedException {
		try {
			InitialiseSDKPageObjects.waitTillElementPresent("selectBankFromList");
			driver.findElementByXPath(dictPageObjects.get("selectBankFromList")).click();
			String bank = driver.findElementByName("AIB Ireland").getText();
			a.assertTrue(bank.contains(dict.get("bankName")));
			driver.findElementByName("AIB Ireland").click();
			InitialiseSDKPageObjects.waitTillElementPresent("initiateButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("initiateButton"));
			/*InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");*/
		} catch (Exception e) {
			System.out.println("User did not redirect to the success screen");
		}
		
	}

	public static void verifyErrorMessage(String xPath, String errorString) {
		try {
			String errorMessageXPath = driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
			String errorMessageString = con.getErrorMessage(errorString);
			a.assertEquals(errorMessageXPath, errorMessageString);
			log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: " + errorMessageString);
		} catch (Exception e) {
			System.out.println("Error message did not verified");
		}
		
	}

}