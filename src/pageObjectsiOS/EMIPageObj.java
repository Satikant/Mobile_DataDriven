package pageObjectsiOS;

import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;

import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;

public class EMIPageObj extends GlobalVariables {
	private static Dictionary<String, String> dataList;
	private static String SheetName = "Login";
	private static Assertion a = new Assertion();
	public static Logger log = Logger.getLogger(EMIPageObj.class.getName());
	private static String DataSheet = "EMIData";

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "EMIData";
		} else {
			pageObjectsSheetName = "EMIData";
		}
		System.out.println("Page Object Sheet Name = " + pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static void enterValidCardNumberVisa() throws Exception {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("cardNumber");
				commonLibrary.sendkeys("cardNumber", "cardNumberVisa");
			} else {
				commonLibrary.explicitWait("iOSCardNumber");
				commonLibrary.clearfield("iOSCardNumber");
				commonLibrary.sendkeys("iOSCardNumber", "cardNumberVisa");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterValidCardHolderName() throws Exception {
		try {
//			readData();
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("nameOnCard");
				commonLibrary.sendkeys("nameOnCard", "NameOnCard");
			} else {
				commonLibrary.explicitWait("iOSNameonEMICard");
				commonLibrary.clearfield("iOSNameonEMICard");
				commonLibrary.sendkeys("iOSNameonEMICard", "NameOnCard");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterValidExpiry() throws Exception {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("expiry");
				commonLibrary.sendkeys("expiry", "Expiry");
			} else {
				commonLibrary.clearfield("iOSExpiry");
				commonLibrary.sendkeys("iOSExpiry", "Expiry");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterValidCvv() throws Exception {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("cvv");
				commonLibrary.sendkeys("cvv", "CVV");
			} else {
				commonLibrary.clearfield("iOSCVV");
				commonLibrary.sendkeys("iOSCVV", "CVV");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}

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

	public static void addEMIcard() throws Throwable {
		try {
//			readData();
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clickButton("addCardButton");
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardsText"))
						.getText();
				String exptext = dictPageObjects.get("SavedCards");
				a.assertEquals(savedcardactualText, exptext);
			} else {
				commonLibrary.explicitWait("iOSaddCardButton");
				commonLibrary.clickButton("iOSaddCardButton");
//				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("iOSsavedcardTitle"))
//						.getText();
//				String exptext = dictPageObjects.get("savedCardstitleText");
//				a.assertEquals(savedcardactualText, exptext);
//				System.out.println("Text verified in iOS screen");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}

	}

	public static void verifyEMIOnlinePaymentsOption() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				log.info("Verify card button in Android");
				String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
				String expected = dictPageObjects.get("payplus_iOSsdk_card");
//				String expected = commonLibrary.captureExpectedText("payplus_iOSsdk_card");
				a.assertEquals(cardButton, expected);
				log.info("Verify EMI credit/debit card");
				String walletButton = driver.findElementByXPath(dictPageObjects.get("emiDebitandCrdit")).getText();
//				a.assertEquals(walletButton, commonLibrary.captureExpectedText("payplus_iOSsdk_emicreditdebitcard"));
				a.assertEquals(walletButton, dictPageObjects.get("payplus_iOSsdk_emicreditdebitcard"));
			} else {
				log.info("Verify EMI option in iOS");
				String EMIoption = driver.findElementByXPath(dictPageObjects.get("iOSemi_credit_Debit_cards"))
						.getText();
				String expected = dictPageObjects.get("iOSpayplussdkemi");
//				String expected = commonLibrary.captureExpectedText("payplus_iOSsdk_card");
				a.assertEquals(EMIoption, expected);
			}
		} catch (Exception e) {
			System.out.println("User did not redirected to online payment screen");
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

	public static void non3DSemiPayment() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardVisa")).getText();
			if (MasterCardiOS.contains("1111")) {
				commonLibrary.clickButton("iOSsavedCardVisa");
				commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
//				commonLibrary.clickButton("iOSsavedCardVisa");
				commonLibrary.clickButton("DoneButton");
				commonLibrary.clickButton("iOSviewEMIPlansBtnLink");
				viewEMIPayment();
//				commonLibrary.explicitWait("iOSviewEMIPlansBtnLink");
//				commonLibrary.clickButton("iOSviewEMIPlansBtnLink");
//				commonLibrary.explicitWait("iOSemiTenure");
//				commonLibrary.clickButton("iOSemiTenure");
//				commonLibrary.clickButton("iOSemiPayBtn");

			} else {
				System.out.println("There is no card ending with number 1111 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public void ThreeDSemiPayment() {
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

	public static void viewAllEMIPlans() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("view_All_EMI_Plans");
				commonLibrary.clickButton("view_All_EMI_Plans");
				commonLibrary.explicitWait("selectBankDropdown");
				commonLibrary.clickButton("selectBankDropdown");
				commonLibrary.clickButton("iDFCcreditCard");
				commonLibrary.explicitWait("monthTenure");
				String cardText = driver.findElementByXPath(dictPageObjects.get("monthTenure")).getText();
				a.assertTrue(cardText.contains("months"));

			} else {
				commonLibrary.explicitWait("iOSviewEMIPlansBtnText");
				commonLibrary.clickButton("iOSviewEMIPlansBtnText");
				commonLibrary.explicitWait("iOSselectBankDropdown");
				commonLibrary.clickButton("iOSselectBankDropdown");
				commonLibrary.clickButton("iOSiDFCcreditCard");
				commonLibrary.explicitWait("iOSemiTenure");
				String cardText = driver.findElementByXPath(dictPageObjects.get("iOSemiTenure")).getText();
				a.assertTrue(cardText.contains("months"));
			}

		} catch (Exception e) {
			System.out.println("User did not redirected to success screen");
		}
	}

	public static void addAnotherEMICard() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				System.out.println("Android - Add EMI card");
//				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidExpiry();
				enterValidCvv();
				commonLibrary.explicitWait("iOSviewEMIPlansBtnLink");
				commonLibrary.clickButton("iOSviewEMIPlansBtnLink");
				Thread.sleep(2000);
			} else {
				System.out.println("iOS - Add EMI card");
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidExpiry();
				enterValidCvv();
				commonLibrary.clickButton("DoneButton");
				commonLibrary.explicitWait("iOSviewEMIPlansBtnLink");
				commonLibrary.clickButton("iOSviewEMIPlansBtnLink");
				Thread.sleep(2000);
				viewEMIPayment();
			}

		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
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
	public static void doneBtnTransactionStatus() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("successDoneBtn");
				commonLibrary.clickButton("successDoneBtn");
			}else {
			commonLibrary.explicitWait("iOSsuccessDoneBtn");
			commonLibrary.clickButton("iOSsuccessDoneBtn");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to transaction success screen");
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

}
