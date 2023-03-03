package pageObjectsiOS;

import static org.testng.Assert.assertFalse;

import java.util.Dictionary;
import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class CardsPageObj extends GlobalVariables {
	private static Dictionary<String, String> dataList;
	private static String SheetName = "Login";
	private static Assertion a = new Assertion();
	public static Logger log = Logger.getLogger(CardsPageObj.class.getName());
	private static String DataSheet = "CardPaymentData";

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}
//	public static void readData() throws Exception{
//		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, DataSheet);
//	}

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

	public static void cardScreeninitialization() throws Exception {
		try {
//			readData();
//			dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "CardPaymentData");
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("buyNowButton");
				commonLibrary.clickButton("buyNowButton");
				Thread.sleep(3000);
			} else {
				commonLibrary.explicitWait("iOSbuyNowButton");
				commonLibrary.clickButton("iOSbuyNowButton");
//			commonLibrary.explicitWait("iOSdefaultButton");
//			commonLibrary.clickButton("iOSdefaultButton");
//			commonLibrary.implicitWait();
//			commonLibrary.iOSswipedown();
//			commonLibrary.iOSswipedown();
//			commonLibrary.iOSswipedown();
//			commonLibrary.explicitWait("iOSpayNowButton");
//			commonLibrary.clickButton("iOSpayNowButton");
			Thread.sleep(3000);
			}
		} catch (Exception e) {
			a.assertTrue(commonLibrary.isElementPresent("iOSAuthenticationFailure"));
			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}
	}
	public static void iosPayNowBtn() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.explicitWait("payNowButton");
				commonLibrary.clickButton("payNowButton");
			}else {
				commonLibrary.explicitWait("iOSpayNowButton");
				commonLibrary.clickButton("iOSpayNowButton");
			}
			
		}catch (Exception e) {
			System.out.println("User did not redirect to the the merchant screen");
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

	public static void addcardScreen() throws Throwable {
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
				String savedcardactualText = driver.findElementByXPath(dictPageObjects.get("iOSAddCardTitle"))
						.getText();
				String exptext = dictPageObjects.get("addCardTitleText");
				a.assertEquals(savedcardactualText, exptext);
				System.out.println("Text verified in iOS screen");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}
	
	public static void enterValidCardNumberJcb() throws Exception {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("cardNumber");
				commonLibrary.sendkeys("cardNumber", "cardNumberVisa");
			} else {
				commonLibrary.clearfield("iOSCardNumber");
				commonLibrary.sendkeys("iOSCardNumber", "cardNumberJcb");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterValidCardNumberVisa() throws Exception {
		try {
//			readData();
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clearfield("cardNumber");
				commonLibrary.sendkeys("cardNumber", "cardNumberVisa");
			} else {
				commonLibrary.clearfield("iOSCardNumber");
				commonLibrary.sendkeys("iOSCardNumber", "cardNumberVisa");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterInvalidExpiry() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
				driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(dictPageObjects.get("invalidExpiry"));
			} else {
				driver.findElementByXPath(dictPageObjects.get("iOSExpiry")).clear();
				driver.findElementByXPath(dictPageObjects.get("iOSExpiry"))
						.sendKeys(dictPageObjects.get("invalidExpiry"));
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
				commonLibrary.clearfield("iOSNameonCard");
				commonLibrary.sendkeys("iOSNameonCard", "NameOnCard");
			}
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}

	public static void enterValidExpiry() throws Exception {
		try {
//			readData();
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
//			readData();
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

	public static void successfulCardPaymentVisa() throws Exception {
		try {
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidExpiry();
			enterValidCvv();
			commonLibrary.clickButton("iOSCardNumber");
			commonLibrary.clickButton("iOScardPaymentButton");
			commonLibrary.implicitWait();
			successmessage();
			doneBtnTransactionStatus();
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
		}
	}
	public static void successfulVisaCardPaymentwithFasterCheckout() throws Exception {
		try {
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidExpiry();
			enterValidCvv();
			commonLibrary.clickButton("DoneButton");
			commonLibrary.clickButton("iOSFasterCheckoutToggle");
			commonLibrary.clickButton("iOScardPaymentButton");
			successmessage();
			doneBtnTransactionStatus();
		} catch (Exception e) {
			System.out.println("User did not redirect to Add card details screen");
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

	public static void blankCardNumber() throws Throwable {
		try {
			driver.findElementByXPath(dictPageObjects.get("iOSCardNumber")).sendKeys("");
			enterValidCardHolderName();
			enterValidCvv();
			enterValidExpiry();
			commonLibrary.explicitWait("iOScardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("iOScardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("iOScardPaymentButton")).isEnabled());
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	public static void invalidCardNumber() throws Throwable {
		try {
			driver.findElementByXPath(dictPageObjects.get("iOSCardNumber"))
					.sendKeys(dictPageObjects.get("invalidCardNumber"));
			enterValidCardHolderName();
			enterValidExpiry();
			enterValidCvv();
			commonLibrary.explicitWait("iOScardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("iOScardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("iOScardPaymentButton")).isEnabled());
//			String actual = driver.findElementByXPath(dictPageObjects.get("invalidCardNumberError")).getText();
//			String expected = con.InvalidcardNumberTextmessage();
//			a.assertEquals(actual, expected);
//			log.info("Invalid Card Number : "+actual+" = "+expected);
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	public static void blankExpiry() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidCvv();
			} else {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidCvv();
				commonLibrary.clearfield("iOSExpiry");
				commonLibrary.clickButton("iOScardPaymentButton");
				assertFalse(driver.findElementByXPath(dictPageObjects.get("iOScardPaymentButton")).isEnabled());
			}
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	public static void invalidExpiry() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidCvv();
				enterInvalidExpiry();
			} else {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidCvv();
				commonLibrary.clearfield("iOSExpiry");
				InitialiseSDKPageObjects.clickButton(dictPageObjects.get("iOScardPaymentButton"));
				assertFalse(driver.findElementByXPath(dictPageObjects.get("iOScardPaymentButton")).isEnabled());
			}
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	public static void blankCvv() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidCvv();
				enterInvalidExpiry();
			} else {
				enterValidCardNumberVisa();
				enterValidCardHolderName();
				enterValidExpiry();
				commonLibrary.clearfield("iOSCVV");
				InitialiseSDKPageObjects.clickButton(dictPageObjects.get("iOScardPaymentButton"));
				assertFalse(driver.findElementByXPath(dictPageObjects.get("iOScardPaymentButton")).isEnabled());
			}
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	public static void successfulCardPaymentJcb() throws Throwable {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				enterValidCardNumberJcb();
				enterValidCardHolderName();
				enterValidCvv();
				enterInvalidExpiry();
			} else {
				enterValidCardNumberJcb();
				enterValidCardHolderName();
				enterValidCvv();
				enterValidExpiry();
				commonLibrary.clickButton("iOSPayableAmount");
				commonLibrary.explicitWait("iOScardPaymentButton");
//				InitialiseSDKPageObjects.clickButton(dictPageObjects.get("iOScardPaymentButton"));
				commonLibrary.clickButton("iOScardPaymentButton");
			}
		} catch (Exception e) {
			System.out.println("Saved Card is not present");
		}
	}

	// Need to check both device feasibilty
	public static void non3DsCard() throws Throwable {
		String MasterCard = driver.findElementByXPath(dictPageObjects.get("savedCardMaster")).getText();
		String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardMaster")).getText();
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				if (MasterCard.contains("5454")) {
					commonLibrary.clickButton(dictPageObjects.get("savedCardMaster"));
					commonLibrary.sendkeys("savedCardcvv", "CVV");
					commonLibrary.explicitWait("savedCardMakePayButton");
					commonLibrary.clickButton(dictPageObjects.get("savedCardMakePayButton"));
				} else {
					System.out.println("There is no card ending with number 5454 in android");
				}
			} else {
				if (MasterCardiOS.contains("5454")) {
					commonLibrary.clickButton("iOSsavedCardMaster");
					commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
					commonLibrary.explicitWait("iOSsavedCardMakePayButton");
					commonLibrary.clickButton("iOSsavedCardMakePayButton");
					commonLibrary.clickButton("iOSsavedCardMakePayButton");
				} else {
					System.out.println("There is no card ending with number 5454 in iOS");
				}
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
	public static void ThreeDSCardiOS() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardMaster")).getText();
			if (MasterCardiOS.contains("5454")) {
				commonLibrary.clickButton("iOSsavedCardMaster");
				commonLibrary.sendkeys("iOSsavedCardcvv", "CVV");
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
	

	public static void failureRetryButton() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clickButton("retryButton");
			} else {
				commonLibrary.clickButton("iOSretryButton");
			}
		} catch (Exception e) {
			System.out.println("User is not in the failure transaction screen");
		}
	}

	public static void failureChangepaymentlink() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				commonLibrary.clickButton("changepayment");
			} else {
				commonLibrary.clickButton("iOSchangePaymentMode");
			}
		} catch (Exception e) {
			System.out.println("User is not in the failure transaction screen");
		}
	}
	public static void captureOrderIdNon3DS() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				
			}else {
				commonLibrary.explicitWait("iOSorderID");
				String orderid1st = driver.findElementByXPath(dictPageObjects.get("iOSorderID")).getText();
				System.out.println("To capture first orderid -->" + orderid1st);
				non3DSCardiOS();
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
	public static void cancelOfDelete() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardVisa")).getText();
			if (MasterCardiOS.contains("1111")) {
				commonLibrary.clickButton("iOSsavedCardVisa");
				commonLibrary.clickButton("iOSdeleteCardButton");
				commonLibrary.explicitWait("iOSdeleteCancel");
				commonLibrary.clickButton("iOSdeleteCancel");
				Thread.sleep(3000);
			} else {
				System.out.println("There is no card ending with number 1111 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public static void deleteSavedCard() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardVisa")).getText();
			if (MasterCardiOS.contains("1111")) {
				commonLibrary.clickButton("iOSsavedCardVisa");
				commonLibrary.clickButton("iOSdeleteCardButton");
				commonLibrary.explicitWait("iOSdeleteCardOK");
				commonLibrary.clickButton("iOSdeleteCardOK");
				commonLibrary.explicitWait("iOSDeleteDone");
				commonLibrary.clickButton("iOSDeleteDone");
				Thread.sleep(3000);
			} else {
				System.out.println("There is no card ending with number 1111 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
	public static void presenceofVisaCard() {
		try {
			String MasterCardiOS = driver.findElementByXPath(dictPageObjects.get("iOSsavedCardVisa")).getText();
			if (MasterCardiOS.contains("1111")) {
				a.assertTrue(MasterCardiOS.contains("1111"));
			} else {
				System.out.println("There is no card ending with number 1111 in iOS");
			}
		} catch (Exception e) {
			System.out.println("There is no saved master card ");
		}
	}
}
