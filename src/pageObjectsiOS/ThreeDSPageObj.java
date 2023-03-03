package pageObjectsiOS;

import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;

import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;

public class ThreeDSPageObj extends GlobalVariables{
	private static Dictionary<String, String> dataList;
	private static String SheetName = "Login";
	private static Assertion a = new Assertion();
	public static Logger log = Logger.getLogger(CardsPageObj.class.getName());
//	private static String DataSheet = "CardPaymentData";
	
	
	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "CardPaymentDataAndroid";
		} else {
			pageObjectsSheetName = "CardPaymentData";
		}
		System.out.println("Page Object Sheet Name = " + pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}
	public static void iOShomescreeninitialization() throws Exception {
		try {
//			readData();
//			dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "CardPaymentData");
			if (dataList.get("Testing").equals("true")) {
				commonLibrary.explicitWait("iOSbuyNowButton");
				commonLibrary.clickButton("iOSbuyNowButton");
				Thread.sleep(3000);
			} else {
				commonLibrary.waitTillElementPresent("payNowButton");
				commonLibrary.clickButton("payNowButton");
			}
		} catch (Exception e) {
			a.assertTrue(commonLibrary.isElementPresent("iOSAuthenticationFailure"));
			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}
	}
	public static void goToInitiatecardScreen() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clickButton("cardButton");
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("savedCardsText")).getText();
				String exptext = dictPageObjects.get("SavedCards");
				a.assertEquals(savedcardactualText, exptext);
			} else {
				commonLibrary.clickButton("iOScardButton");
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardsText"))
						.getText();
				String exptext = dictPageObjects.get("SavedCards");
				a.assertEquals(savedcardactualText, exptext);
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to card screen");
		}
	}
	public void goToInitiateEMIScreen() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clickButton("cardButton");
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("savedCardsText")).getText();
				String exptext = dictPageObjects.get("SavedCards");
				a.assertEquals(savedcardactualText, exptext);
			} else {
				commonLibrary.clickButton("iOSemi_credit_Debit_cards");
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardsText"))
						.getText();
				String exptext = dictPageObjects.get("SavedCards");
				a.assertEquals(savedcardactualText, exptext);
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to card screen");
		}
	}
	public void threeDSemiPayment() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardMaster")).getText();
			if (MasterCardiOS.contains("5454")) {
				commonLibrary.clickButton("iOSsavedCardMaster");
				commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
				Thread.sleep(3000);
				commonLibrary.clickButton("DoneButton");
				commonLibrary.explicitWait("iOSviewEMIPlansBtnLink");
				commonLibrary.clickButton("iOSviewEMIPlansBtnLink");
				viewEMIPayment();
			} else {
				System.out.println("There is no card ending with number 5454 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public void threeDScardPayment() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardMaster")).getText();
			if (MasterCardiOS.contains("5454")) {
				commonLibrary.clickButton("iOSsavedCardMaster");
				commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
				Thread.sleep(3000);
				commonLibrary.clickButton("DoneButton");
				commonLibrary.explicitWait("iOSsavedCardMakePayButton");
				commonLibrary.clickButton("iOSsavedCardMakePayButton");
			} else {
				System.out.println("There is no card ending with number 5454 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public static void non3DSCardiOS() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardVisa")).getText();
			if (MasterCardiOS.contains("1111")) {
				commonLibrary.clickButton("iOSsavedCardVisa");
				commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
//				commonLibrary.clickButton("iOSsavedCardVisa");
				Thread.sleep(3000);
				commonLibrary.clickButton("DoneButton");
				commonLibrary.explicitWait("iOSsavedCardMakePayButton");
				commonLibrary.clickButton("iOSsavedCardMakePayButton");
				Thread.sleep(3000);
			} else {
				System.out.println("There is no card ending with number 1111 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public void disabledSubmitButton() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				
			}else {
				commonLibrary.explicitWait("iOSThreeDSSubmit");
				boolean submitbutton = driver.findElementByXPath(dictPageObjects.get("iOSThreeDSSubmit")).isEnabled();
				a.assertFalse(submitbutton);
			}
		}catch (Exception e) {
			System.out.println("User did not redirect to 3DS screen");
		}
		
	}
	public static void viewEMIPayment() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("emiTenure");
				commonLibrary.clickButton("emiTenure");
				commonLibrary.clickButton("emiPayBtn");
				
			}else {
				commonLibrary.explicitWait("iOSemiTenure");
				commonLibrary.clickButton("iOSemiTenure");
				commonLibrary.clickButton("iOSemiPayBtn");
			}
			
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}
	
	public void threeDSAuthentication() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				
			} else {
				
				Thread.sleep(5000);
				System.out.println("bank payment ios");
				commonLibrary.explicitWait("iOSThreeDSOTP");
				commonLibrary.sendkeys("iOSThreeDSOTP", "ThreeDSOTPValue");
				commonLibrary.clickButton("iOSThreeDSSubmit");
			}
			
		}catch (Exception e) {
			System.out.println("User did not redirect bank payment screen");
		}
	}
	public void cancelthreeDSAuthentication() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				
			} else {
				Thread.sleep(5000);
				System.out.println("bank payment ios");
				commonLibrary.explicitWait("iOSThreeDSOTP");
				commonLibrary.sendkeys("iOSThreeDSOTP", "ThreeDSOTPValue");
				commonLibrary.explicitWait("iOSThreeDSCancel");
				commonLibrary.clickButton("iOSThreeDSCancel");
			}
			
		}catch (Exception e) {
			System.out.println("User did not redirect bank payment screen ");
		}
	}
	public static void doneBtnTransactionStatus() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("successDoneBtn");
				commonLibrary.clickButton("successDoneBtn");
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
				String successmessageActual = driver.findElementByXPath(dictPageObjects.get("Transaction")).getText();
				String successmessageExpected = dictPageObjects.get("SuccessMessage");
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
	public static void clickOnRetryButton() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				
			}else {
				commonLibrary.explicitWait("iOSretryButton");
				commonLibrary.clickButton("iOSretryButton");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void clickOnChangePaymentLink() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
			
		} else {
			commonLibrary.explicitWait("iOSchangePaymentMode");
			commonLibrary.clickButton("iOSchangePaymentMode");
		}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
