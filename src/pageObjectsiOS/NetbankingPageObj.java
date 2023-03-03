package pageObjectsiOS;

import java.io.IOException;
import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;
import pageObjectsAndroid.HomeScreenPageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class NetbankingPageObj extends GlobalVariables {
	private static String SheetName = "Login";
	private static Dictionary<String, String> dataList;
	private static Assertion a = new Assertion();
//	private static ConfigFileReader con = new ConfigFileReader();

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

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

	public static void bankinitialization() throws Exception {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				System.out.println("Execution started for Android");
				commonLibrary.explicitWait("buyNowButton");
				commonLibrary.clickButton("buyNowButton");
			} else {
				System.out.println("Execution started for iOS");
				commonLibrary.explicitWait("iOSbuyNowButton");
				commonLibrary.clickButton("iOSbuyNowButton");
//				commonLibrary.explicitWait("iOSdefaultButton");
//				commonLibrary.clickButton("iOSdefaultButton");
//				commonLibrary.iOSswipedown();
//				commonLibrary.iOSswipedown();
//				commonLibrary.iOSswipedown();
//				commonLibrary.explicitWait("iOSpayNowButton");
//				commonLibrary.clickButton("iOSpayNowButton");
			}

		} catch (Exception e) {
			a.assertTrue(commonLibrary.isElementPresent("iOSAuthenticationFailure"));
			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}
	}

	public static void goToBankPaymentScreen() throws InterruptedException {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				log.info("Click bank menu in Android");
				commonLibrary.explicitWait("netBankingButton");
				commonLibrary.clickButton("netBankingButton");
				commonLibrary.explicitWait("bank");
				String bank = driver.findElementByXPath(dictPageObjects.get("bank")).getText();
				a.assertEquals(bank,(dictPageObjects.get("bankText")));
				Thread.sleep(4000);
			} else {
				log.info("Click bank menu in iOS");
				commonLibrary.explicitWait("iOSnetBankingButton");
				commonLibrary.clickButton("iOSnetBankingButton");
				commonLibrary.explicitWait("iOSselectBanktext");
				String bank = driver.findElementByXPath(dictPageObjects.get("iOSselectBanktext")).getText();
				a.assertEquals(bank, dictPageObjects.get("bankText"));
			}

		} catch (Exception e) {
			System.out.println("User did not redirected to net banking screen");
		}

	}

	public static void successfulBankPayment() throws IOException, InterruptedException {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("selectBankFromList");
				commonLibrary.clickButton("selectBankFromList");
				commonLibrary.explicitWait("AIBIrelandbankName");
				commonLibrary.clickButton("AIBIrelandbankName");
				commonLibrary.explicitWait("initiateButton");
				commonLibrary.clickButton("initiateButton");
			} else {
				commonLibrary.explicitWait("iOSselectBankFromList");
				commonLibrary.clickButton("iOSselectBankFromList");
				Thread.sleep(1000);
				commonLibrary.clickButton("iOSAIBIrelandbank");
				Thread.sleep(1000);
				commonLibrary.explicitWait("iOSinitiateButton");
				commonLibrary.clickButton("iOSinitiateButton");
			}

		} catch (Exception e) {
			System.out.println("User did not redirected to net banking screen");
		}
	}

	public static void verifyorderID() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("orderID");
				a.assertTrue(commonLibrary.isElementPresent("orderID"));
			} else {
				commonLibrary.explicitWait("iOSorderID");
				a.assertTrue(commonLibrary.isElementPresent("iOSorderID"));
			}

		} catch (Exception e) {
			System.out.println("OrderID is not present");
		}

	}

	public static void verifypayableAmount() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("PayableAmount");
				a.assertTrue(commonLibrary.isElementPresent("PayableAmount"));
			} else {
				commonLibrary.explicitWait("iOSPayableAmount");
				a.assertTrue(commonLibrary.isElementPresent("iOSPayableAmount"));
			}

		} catch (Exception e) {
			System.out.println("Payableamount is not generated is not present");
		}
	}
	public static void orderidrefresh() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("orderId");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("orderId")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				goToBankPaymentScreen();
				commonLibrary.explicitWait("backButton");
				commonLibrary.clickButton("backButton");
				String orderid2nd = driver.findElementByXPath(dictPageObjects.get("orderId")).getText();
				System.out.println("To capture second orderid -->" + orderid2nd);
				a.assertNotEquals(orderid1st, orderid2nd);
			} else {
				commonLibrary.explicitWait("iOSorderID");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				goToBankPaymentScreen();
				commonLibrary.clickButton("iOSbackButton");
				String orderid2nd = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture second orderid -->" + orderid2nd);
				a.assertNotEquals(orderid1st, orderid2nd);
			}
			
		}catch (Exception e) {
			
		}
	}
	public static void doneBtnTransactionStatus() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("SuccessDone");
				commonLibrary.clickButton("SuccessDone");
				System.out.println("Done button clicked in Android");
			}
			commonLibrary.explicitWait("iOSsuccessDoneBtn");
			commonLibrary.clickButton("iOSsuccessDoneBtn");
		} catch (Exception e) {
			System.out.println("User did not redirect to transaction success screen");
		}
	}
	
	public static void successmessage() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
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
