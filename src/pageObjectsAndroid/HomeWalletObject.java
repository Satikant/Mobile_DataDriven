package pageObjectsAndroid;

import java.io.IOException;
import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeWalletObject extends GlobalVariables{

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
			pageObjectsSheetName = "WalletHomeData";
		}
		else {  
			pageObjectsSheetName = "WalletHomeData";
		}
		System.out.println("Page Object Sheet Name = "+pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

	public static void click_on_Paynow() throws IOException, InterruptedException {
		log.info("=== Click on Pay Now Button ======");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));				
	}
	/*QA ADG*/
	public static void homewalletinitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "WalletHomeData");
		if (dataList.get("Testing").equals("true")) {
			commonLibrary.explicitWait("buyNowButton");
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("buyNowButton"));
			commonLibrary.clickButton("buyNowButton");
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
//			//waitTillElementPresent("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
//			enterSDKFields();
//			waitTillElementPresent("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		}
	}

	public static void select_Recurring_Payment_Checkbox() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.waitTillElementPresent("recurringPayment");
		log.info("=== Select Recurring Payment Checkbox ======");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("recurringPayment"));				
	}

	public static void goToInitiateWalletScreen() throws Throwable
	{
//		InitialiseSDKPageObjects.waitToExecuteNextLine("walletButton");
		log.info("===== Click on Wallet Button =====");
		commonLibrary.explicitWait("walletButton");
//		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		commonLibrary.clickButton("walletButton");
//		driver.findElementByXPath(dictPageObjects.get("walletButton")).click();
	}
	
	public static void msisdnSubmit()
	{
		log.info("===== Click on Wallet submit Button in MSISDN screen=====");
//		driver.findElementByXPath(dictPageObjects.get("PayINR")).click();
		commonLibrary.explicitWait("MSISDNSubmit");
		commonLibrary.clickButton("MSISDNSubmit");
	}
	public static void walletContinue() {
		log.info("===== Click on continue Button =====");
		commonLibrary.explicitWait("walletContinue");
		commonLibrary.clickButton("walletContinue");
	}
	
	public static void click_on_confirm_button() throws Throwable {
		log.info("===== Click on Wallet Confirm Button =====");
//		InitialiseSDKPageObjects.waitTillElementPresent("confirmWalletPayment");
//		driver.findElementByXPath(dictPageObjects.get("confirmWalletPayment")).click();
		Thread.sleep(1000);
		commonLibrary.explicitWait("PayINR");
//		driver.findElementByXPath(dictPageObjects.get("PayINR")).click();//ADG-QA
		commonLibrary.clickButton("PayINR");
	}

	public static void listOfNamesDisplayedInWalletScreen()
	{
//		InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
		InitialiseSDKPageObjects.explicitwait("Mpesa");
		String actual = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
		String expected = con.getMpesaText();
		a.assertEquals(actual, expected);
		log.info("Wallet Mpesa : "+actual+" = "+expected);

//		InitialiseSDKPageObjects.waitTillElementPresent("Ecocash");
		String actual1 = driver.findElementByXPath(dictPageObjects.get("Ecocash")).getText();
		String expected1 = con.getEcoCashText();
		a.assertEquals(actual1, expected1);
		log.info("Wallet Ecocash :"+actual1+" = "+expected1);
	}

	public static void validateOnly_Push_Notification_based_wallets_are_displayed()
	{		
//		InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
		InitialiseSDKPageObjects.explicitwait("Mpesa");
		String actual1 = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
		String expected1 = con.getMpesaText();
		a.assertEquals(actual1, expected1);
		log.info("Wallet Ecocash :"+actual1+" = "+expected1+" =====");
	}

	public static void validate_NavigateBack_HomeScreen() throws InterruptedException
	{		
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
			//InitialiseSDKPageObjects.navigateBack();
		}
	}

	public static void validate_that_only_one_wallet_is_selected() throws InterruptedException
	{
		log.info("=== Select Mpesa ===");
//		InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
		driver.findElementByXPath(dictPageObjects.get("Mpesa")).click();
		String actual = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
		String expected = con.getMpesaText();
		a.assertEquals(actual, expected);
		log.info("Wallet Mpesa : "+actual+" = "+expected+" ===");
		
		Thread.sleep(1000);
		InitialiseSDKPageObjects.navigateBack();
		
		Thread.sleep(1000);
		log.info("=== Select Ecocash ===");
//		InitialiseSDKPageObjects.waitTillElementPresent("Ecocash");
		driver.findElementByXPath(dictPageObjects.get("Ecocash")).click();
		String actual1 = driver.findElementByXPath(dictPageObjects.get("Ecocash")).getText();
		String expected1 = con.getEcoCashText();
		a.assertEquals(actual1, expected1);
		log.info("Wallet Ecocash :"+actual1+" = "+expected1+" =====");
	}

	public static void validate_that_mpesa_wallet_is_selected()
	{
		log.info("=== Select Mpesa ===");
//		InitialiseSDKPageObjects.waitTillElementPresent("Mpesa");
//		driver.findElementByXPath(dictPageObjects.get("Mpesa")).click();
//		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
		commonLibrary.clickButton("Mpesa");
		String actual = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
		String expected = con.getMpesaText();
		a.assertEquals(actual, expected);
		log.info("Wallet Mpesa : "+actual+" = "+expected+" ===");
		commonLibrary.explicitWait("walletContinue");
		commonLibrary.clickButton("walletContinue");
	}
	
	public static void verify_Pay_INR_Button() throws Throwable
	{
		log.info("===== Verify PayINR Button  =====");
//		InitialiseSDKPageObjects.waitToExecuteNextLine("PayINR");
//		log.error(dictPageObjects);
		Thread.sleep(10000);
		String PayINRactual = driver.findElementByXPath(dictPageObjects.get("PayINR")).getText();
		String PayINRactualexpected = con.getpayINRText();
		a.assertEquals(PayINRactual, PayINRactualexpected);
		log.info("SUBMIT Button : "+PayINRactual+" = "+PayINRactualexpected+" ===");
//		driver.findElementByXPath(dictPageObjects.get("PayINR")).isDisplayed();
	}

	public static void goToBankPaymentScreen() throws InterruptedException {
		log.info("Click bank button");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("netBankingButton"));
		InitialiseSDKPageObjects.waitTillElementPresent("bank");
		String bank = driver.findElementByXPath(dictPageObjects.get("bank")).getText();
		a.assertTrue(bank.contains(dict.get("bank")));
	}

	public static void clickOnBackButton() throws InterruptedException {
		log.info("Click back button");
		//		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("backButton"));
		//		InitialiseSDKPageObjects.waitTillElementPresent("mobileHome");
		driver.navigate().back();
	}

	public static void verifySuccessPopUp(String xPath)
	{
//		InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
		String successMessageXPath = driver.findElementByXPath(xPath).getText();
		String successMessageString = con.getSuccessMessage();
		a.assertEquals(successMessageXPath, successMessageString);
		log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: " + successMessageString);
	}

	public static void click_On_Ok_Button(String xPath)
	{
		log.info("==== Click on OK Button ========");
		driver.findElementByXPath(xPath).click();
	}
	public static void captureWalletOrderId() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("walletOrderID");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("walletOrderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				//*clicking on mpesa wallet*//
				validate_that_mpesa_wallet_is_selected();
				//*clicking on submit button*//
				msisdnSubmit();
				GlobalVariables.driver.navigate().back();
				GlobalVariables.driver.navigate().back();
//				commonLibrary.explicitWait("backbutton");
//				commonLibrary.clickButton("backbutton");
//				commonLibrary.explicitWait("backbutton");
//				commonLibrary.clickButton("backbutton");
				String orderid2nd = driver.findElementByXPath(dictPageObjects.get("walletOrderID")).getText();
				System.out.println("To capture first orderid -->" + orderid2nd);
				a.assertNotEquals(orderid1st, orderid2nd);
				
			}else {
				commonLibrary.explicitWait("iOSorderID");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
//				non3DSCardiOS();
				if (driver.findElementByXPath(dictPageObjects.get("iOSretryButton")) != null) {
					commonLibrary.clickButton("iOSretryButton");
					String orderid2nd = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
					System.out.println("To capture second orderid -->" + orderid2nd);
					a.assertNotEquals(orderid1st, orderid2nd);
				} else {
					System.out.println("User did not redirect tocard screen");
				}
			}
			
		}catch (Exception e) {
			System.out.println("User not in the online payment screen ");
		}
	}
	public static void successfulBankPayment() throws IOException, InterruptedException { 
		InitialiseSDKPageObjects.waitTillElementPresent("selectBankFromList");
		driver.findElementByXPath(dictPageObjects.get("selectBankFromList")).click();
		String bank = driver.findElementByName("AIB Ireland").getText();
		a.assertTrue(bank.contains(dict.get("bankName")));
		driver.findElementByName("AIB Ireland").click();
		InitialiseSDKPageObjects.waitTillElementPresent("initiateButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("initiateButton"));
		/*InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");*/
	}

	public static void verifyErrorMessage(String xPath, String errorString) {
		String errorMessageXPath = driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
		String errorMessageString = con.getErrorMessage(errorString);
		a.assertEquals(errorMessageXPath, errorMessageString);
		log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: " + errorMessageString);
	}
}