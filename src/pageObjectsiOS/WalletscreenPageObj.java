package pageObjectsiOS;

import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;
import pageObjectsAndroid.InitialiseSDKPageObjects;


public class WalletscreenPageObj extends GlobalVariables{
	private static Dictionary<String, String> dataList;
	private static String SheetName = "Login";
	private static Assertion a = new Assertion();
	public static Logger log = Logger.getLogger(WalletscreenPageObj.class.getName());
	private static ConfigFileReader con = new ConfigFileReader();
	

	
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
	public static void walletscreeninitialization() throws Exception {
//		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "WalletHomeData");
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				Thread.sleep(5000);
				commonLibrary.explicitWait("buyNowButton");
				commonLibrary.clickButton("buyNowButton");
			}else {
				commonLibrary.explicitWait("iOSbuyNowButton");
				commonLibrary.clickButton("iOSbuyNowButton");
				Thread.sleep(5000);
			}
			
		} catch (Exception e) {
			System.out.println("There is an internet issue");
		}
	}
	public static void goToInitiateWalletScreen() throws Throwable{
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				Thread.sleep(5000);
				log.info("===== Click on Wallet Button in Android =====");
				commonLibrary.explicitWait("walletButton");
				commonLibrary.clickButton("walletButton");
			} else {
				log.info("===== Click on Wallet Button in iOS =====");
				commonLibrary.explicitWait("iOSwalletButton");
				commonLibrary.clickButton("iOSwalletButton");
				Thread.sleep(3000);
			}
			
		} catch (Exception e) {
			System.out.println("User did not redirected to wallet screen");
		}
	}
	public static void listOfNamesDisplayedInWalletScreen()
	{
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				InitialiseSDKPageObjects.explicitwait("Mpesa");
				String actual = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
				String expected = con.getMpesaText();
				a.assertEquals(actual, expected);
				log.info("Wallet Mpesa : "+actual+" = "+expected);

				String actual1 = driver.findElementByXPath(dictPageObjects.get("Ecocash")).getText();
				String expected1 = con.getEcoCashText();
				a.assertEquals(actual1, expected1);
				log.info("Wallet Ecocash :"+actual1+" = "+expected1);
				
			} else {
				commonLibrary.explicitWait("iOSMpesa");
				String mepsaactual = driver.findElementByXPath(dictPageObjects.get("iOSMpesa")).getText();
				String exptext = dictPageObjects.get("payplus_iOSsdk_Mpesa");
				a.assertEquals(mepsaactual, exptext);
			}
			
		} catch (Exception e) {
			System.out.println("User did not redirected to wallet selection screen");
		}
	}
	public static void mpesaSelection() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				Thread.sleep(5000);
				commonLibrary.explicitWait("Mpesa");
				commonLibrary.clickButton("Mpesa");
//				String actual = driver.findElementByXPath(dictPageObjects.get("Mpesa")).getText();
//				String expected = con.getMpesaText();
//				a.assertEquals(actual, expected);
//				log.info("Wallet Mpesa : "+actual+" = "+expected+" ===");
				Thread.sleep(5000);
				commonLibrary.explicitWait("walletContinue");
				commonLibrary.clickButton("walletContinue");
			} else {
				commonLibrary.explicitWait("iOSMpesa");
				commonLibrary.clickButton("iOSMpesa");
				commonLibrary.clickButton("iOSWalletContinue");
			}
			
		} catch (Exception e) {
			System.out.println("User did not redirected to wallet selection screen");
		}
	}
	public static void redirectback() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.implicitWait();
				commonLibrary.explicitWait("backbutton");
				commonLibrary.clickButton("backbutton");
			} else {
				commonLibrary.explicitWait("iOSbackButton");
				commonLibrary.clickButton("iOSbackButton");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect back");
		}
	}
	public static void verify_Pay_INR_Button() throws Throwable
	{
		log.info("===== Verify PayINR Button  =====");
		String PayINRactual = driver.findElementByXPath(dictPageObjects.get("PayINR")).getText();
		String PayINRactualexpected = con.getpayINRText();
		a.assertEquals(PayINRactual, PayINRactualexpected);
		log.info("SUBMIT Button : "+PayINRactual+" = "+PayINRactualexpected+" ===");
	}
    public static void ecocashSelection() {
    	commonLibrary.explicitWait("iOSEcocash");
		commonLibrary.clickButton("iOSEcocash");
	}
	public static void transactionconfirmation() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				Thread.sleep(5000);
				log.info("===== Click on Wallet submit Button in MSISDN screen=====");
				commonLibrary.explicitWait("MSISDNSubmit");
				commonLibrary.clickButton("MSISDNSubmit");
				log.info("===== Click on Wallet Confirm Button =====");
				Thread.sleep(2000);
				commonLibrary.explicitWait("referenceID");
				a.assertTrue(commonLibrary.isElementPresent("referenceID"));
				commonLibrary.explicitWait("confirmWalletPayment");
				commonLibrary.clickButton("confirmWalletPayment");
				
			} else {
				commonLibrary.explicitWait("iOSwalletMSISDNsubmission");
				commonLibrary.clickButton("iOSwalletMSISDNsubmission");
				commonLibrary.explicitWait("iOSreferenceID");
				a.assertTrue(commonLibrary.isElementPresent("iOSreferenceID"));
				commonLibrary.explicitWait("iOSwalletconfirmation");
				commonLibrary.clickButton("iOSwalletconfirmation");
			}
			
		} catch (Exception e) {
			System.out.println("User did not redirected wallet transaction screen");
		}
		
	}
	public static void verifyorderID() {
		commonLibrary.explicitWait("iOSwalletMSISDNsubmission");
		commonLibrary.clickButton("iOSwalletMSISDNsubmission");
		commonLibrary.explicitWait("iOSreferenceID");
		a.assertTrue(commonLibrary.isElementPresent("iOSorderID"));
	}
	public static void verifypayableAmount() {
		commonLibrary.explicitWait("iOSwalletMSISDNsubmission");
		commonLibrary.clickButton("iOSwalletMSISDNsubmission");
		commonLibrary.explicitWait("iOSreferenceID");
		a.assertTrue(commonLibrary.isElementPresent("iOSPayableAmount"));
	}
	public static void invalidMSISDN() {
		commonLibrary.explicitWait("iOSMSISDNTextbox");
		commonLibrary.clearfield("iOSMSISDNTextbox");
		commonLibrary.sendkeys("iOSMSISDNTextbox", "invalidMSISDN");
		commonLibrary.clickButton("iOSwalletMSISDNsubmission");
		a.assertTrue(commonLibrary.isElementPresent("invalidMSISDN"));
	}
	public static void emptyMSISDN() {
		commonLibrary.explicitWait("iOSMSISDNTextbox");
		commonLibrary.clearfield("iOSMSISDNTextbox");
		commonLibrary.clickButton("iOSwalletMSISDNsubmission");
		a.assertTrue(commonLibrary.isElementPresent("enterValidmobilevalidation"));
	}
	
	public static void orderidrefresh() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("walletOrderID");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("walletOrderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				Thread.sleep(5000);
				mpesaSelection();
				log.info("===== Click on Wallet submit Button in MSISDN screen=====");
				commonLibrary.explicitWait("MSISDNSubmit");
				commonLibrary.clickButton("MSISDNSubmit");
				Thread.sleep(4000);
				commonLibrary.explicitWait("backbutton");
				commonLibrary.clickButton("backbutton");
				String orderid2nd = driver.findElementByXPath(dictPageObjects.get("walletOrderID")).getText();
				System.out.println("To capture first orderid -->" + orderid2nd);
				a.assertNotEquals(orderid1st, orderid2nd);
				
			} else {
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				verifypayableAmount();
				commonLibrary.clickButton("iOSbackButton");
				commonLibrary.clickButton("iOSbackButton");
				String orderid2nd = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture second orderid -->" + orderid2nd);
				a.assertNotEquals(orderid1st, orderid2nd);
			}
			
		} catch (Exception e) {
			System.out.println("OrderId did not get catured");
		}
		
	}
	public static void doneBtnTransactionStatus() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("SuccessDone");
				commonLibrary.clickButton("SuccessDone");
				System.out.println("Done button clicked in Android");
			}else {
				commonLibrary.explicitWait("iOSsuccessfailureDoneBtn");
				commonLibrary.clickButton("iOSsuccessfailureDoneBtn");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to transaction success screen");
		}
	}
	
	public static void successmessage() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				Thread.sleep(4000);
				String successmessageActual = driver.findElementByXPath(dictPageObjects.get("BankPaymenetSuccess")).getText();
				String successmessageExpected = dictPageObjects.get("successMessage");
				a.assertEquals(successmessageActual, successmessageExpected);
				System.out.println("Success message verified in android");
			} else {
				String successmessageActual = driver.findElementByXPath(dictPageObjects.get("iOSTransactionSuccess"))
						.getText();
				String successmessageExpected = dictPageObjects.get("SuccessMessage");
				a.assertEquals(successmessageActual, successmessageExpected);
				System.out.println("Success message verified in iOS");
			}
		} catch (Exception e) {
			System.out.println("User did not redirected to success screen");
		}
	}

	public static void failuremessage() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				String successmessageActual = driver.findElementByXPath(dictPageObjects.get("Transaction")).getText();
				String successmessageExpected = dictPageObjects.get("SuccessMessage");
				a.assertEquals(successmessageActual, successmessageExpected);
				System.out.println("Success message verified");
			} else {
				String successmessageActual = driver.findElementByXPath(dictPageObjects.get("iOSTransactionFailure"))
						.getText();
				String successmessageExpected = dictPageObjects.get("FailureMessage");
				a.assertEquals(successmessageActual, successmessageExpected);
				System.out.println("Failure message verified in iOS");
			}
		} catch (Exception e) {
			System.out.println("User did not redirected to success screen");
		}
	}


}
