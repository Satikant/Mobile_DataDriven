package pageObjectsAndroid;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.Dictionary;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CardPaymentPageObjects extends GlobalVariables {

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

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

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

	// *QA-ADG*//
	public static void goToInitiatecardScreen() throws Throwable {
		try {
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");
			log.info("===== Click on Cards options from Online payments menu =====");
			Thread.sleep(1000);
			driver.findElementByXPath(dictPageObjects.get("cardButton")).click();
		} catch (Exception e) {
			System.out.println("User did not redirect to online payment screen");
		}
	}

	public static void goToSavedCard() throws Exception {
		try {
			log.info("Click card button");
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("cardButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardButton"));
		} catch (Exception e) {
			System.out.println("User did not redirect to online payment screen");
		}

	}

	public static void goToCardPaymentScreen() throws InterruptedException {
		try {
			log.info("Click card button");
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("cardButton");
			Thread.sleep(3000);
			commonLibrary.clickButton("cardButton");
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardButton"));
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");
//			Thread.sleep(1000);
//			InitialiseSDKPageObjects.waitToExecuteNextLine("addCardButton");
//			InitialiseSDKPageObjects.waitTillElementPresent("addCardButton");
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitTillElementPresent("card");
			String card = driver.findElementByXPath(dictPageObjects.get("card")).getText();
//			a.assertTrue(card.contains(dict.get("card")));
			a.assertEquals(card, "Card");

		} catch (Exception e) {
			System.out.println("User did not redirect to saved card screen");
		}

	}

	public static void verifyErrorMessage(String xPath, String errorString) {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent(xPath);
			InitialiseSDKPageObjects.explicitwait(xPath);
			String errorMessageXPath = driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
			System.out.println("CHECK MESSGE" + errorMessageXPath);
			String errorMessageString = con.getErrorMessage(errorString);
			a.assertEquals(errorMessageXPath, errorMessageString);
			log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: "
					+ errorMessageString);
		} catch (Exception e) {
			System.out.println("Validation message is not verified");
		}
	}

	public static void enterValidCardNumberVisa() throws IOException {
		try {
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).clear();
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberVisa"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("cardNumberVisa"));// QA-ADG
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).click();
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCardHolderName() throws IOException {
		try {
			driver.findElementByXPath(dictPageObjects.get("nameOnCard")).clear();
//			InitialiseSDKPageObjects.enterField(dict.get("nameOnCard"), dictPageObjects.get("nameOnCard"));
			driver.findElementByXPath(dictPageObjects.get("nameOnCard")).click();
			driver.findElementByXPath(dictPageObjects.get("nameOnCard")).sendKeys(dictPageObjects.get("NameOnCard"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void enterValidExpiry() throws IOException {
		try {
			driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(dictPageObjects.get("Expiry"));// QA-ADG
//			if (!dataList.get("DeviceType").equals("Android")) {
//				InitialiseSDKPageObjects.enterField(dict.get("expiry").replace("/", ""), dictPageObjects.get("expiry"));
//			}else {		
//				driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
//				InitialiseSDKPageObjects.enterField(dict.get("expiry").replace("/", ""), dictPageObjects.get("expiry"));
//			}
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void enterInvalidExpiry() {
		try {
			driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(dictPageObjects.get("invalidExpiry"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCvv() throws IOException, InterruptedException {
		try {
			driver.findElementByXPath(dictPageObjects.get("cvv")).sendKeys(dictPageObjects.get("CVV"));// QA-ADG
//			driver.findElementByXPath(dictPageObjects.get("cvv")).clear();
//			InitialiseSDKPageObjects.enterField(dict.get("cvv"), dictPageObjects.get("cvv"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCardNumberMastercard() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberMastercard"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("cardNumberMastercard"));// QA-ADG

		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCardNumberAmex() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberAmex"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("cardNumberAmex"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCardNumberDinersClub() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberDinersClub"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("cardNumberDinnersclub"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void enterValidCardNumberDiscover() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberDiscover"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("cardNumberDiscover"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void enterValidCardNumberJcb() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("cardNumberJcb"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberJcb"));// QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void blankCardNumber() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField("", dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys("");// QA-ADG
			enterValidCardHolderName();
			enterValidCvv();
			enterValidExpiry();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
			// verifyErrorMessage("emptyCardNumberError","payplus_sdk_empty_card_number");

		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void invalidCardNumber() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCardNumber"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber"))
					.sendKeys(dictPageObjects.get("invalidCardNumber"));// QA-ADG
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			Thread.sleep(10000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
			Thread.sleep(10000);

			String actual = driver.findElementByXPath(dictPageObjects.get("invalidCardNumberError")).getText();
			String expected = con.InvalidcardNumberTextmessage();
			a.assertEquals(actual, expected);
			log.info("Invalid Card Number : " + actual + " = " + expected);

//			InitialiseSDKPageObjects.hideKeyboard();
			// InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
//			verifyErrorMessage("invalidCardNumberError","payplus_sdk_invalid_card_number");

		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void blankExpiry() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidCvv();
			if (dataList.get("DeviceType").equals("Android")) {
				driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			} else {
				driver.findElementByXPath(dictPageObjects.get("expiry")).click();
				InitialiseSDKPageObjects.clickKeyboardBackButton();
				InitialiseSDKPageObjects.clickKeyboardBackButton();
				InitialiseSDKPageObjects.clickKeyboardBackButton();
				InitialiseSDKPageObjects.clickKeyboardBackButton();
				InitialiseSDKPageObjects.clickKeyboardBackButton();
			}
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
			// verifyErrorMessage("emptyExpiryError","payplus_sdk_empty_expiry_date");
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void invalidExpiry() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidCvv();
			enterInvalidExpiry();
//			InitialiseSDKPageObjects.waitTillElementPresent("expiry");
			/*
			 * InitialiseSDKPageObjects.explicitwait("expiry"); if
			 * (!dataList.get("DeviceType").equals("Android")) { //
			 * InitialiseSDKPageObjects.enterField(dict.get("invalidExpiry").replace("/",
			 * ""), dictPageObjects.get("expiry"));
			 * driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(
			 * dictPageObjects.get("invalidExpiry"));//QA-ADG }else {
			 * driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			 * InitialiseSDKPageObjects.enterField(dict.get("invalidExpiry"),
			 * dictPageObjects.get("expiry")); }
			 */
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
//			verifyErrorMessage("invalidExpiryError","payplus_sdk_invalid_expiry");
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void blankCardHolder() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCvv();
			driver.findElementByXPath(dictPageObjects.get("nameOnCard")).clear();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
			// verifyErrorMessage("emptyNameOnCardError","payplus_sdk_empty_card_name");
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void invalidCardHolder() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCvv();
//			InitialiseSDKPageObjects.enterField(dict.get("invalidNameOnCard"), dictPageObjects.get("nameOnCard"));
			driver.findElementByXPath(dictPageObjects.get("nameOnCard"))
					.sendKeys(dictPageObjects.get("invalidNameOnCard"));// QA-ADG
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
//			verifyErrorMessage("invalidNameOnCardError","payplus_sdk_invalid_card_holder_name");
			/*
			 * String actual =
			 * driver.findElementByXPath(dictPageObjects.get("invalidCardNumberError")).
			 * getText(); String expected = ""; a.assertEquals(actual, expected);
			 * log.info("Invalid Card Number : "+actual+" = "+expected);
			 */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void blankCvv() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCardHolderName();
			driver.findElementByXPath(dictPageObjects.get("cvv")).clear();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
			// verifyErrorMessage("emptyCvvError","payplus_sdk_empty_cvv");
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void invalidCvv() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCardHolderName();
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCvv"), dictPageObjects.get("cvv"));
			driver.findElementByXPath(dictPageObjects.get("cvv")).sendKeys(dictPageObjects.get("invalidCVV"));// QA-ADG
			assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
//			InitialiseSDKPageObjects.hideKeyboard();
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
//			verifyErrorMessage("invalidCvvError","payplus_sdk_invalid_cvv");
			/*
			 * assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton"
			 * )).isEnabled());
			 */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void verifySuccessfulTransactionToast() {
		String txnMessage = driver.findElementByXPath("//android.widget.Toast[@text='Transaction successful']")
				.getText();
		a.assertTrue(txnMessage.contains(dict.get("transactionSuccessful")));
	}

	public static void verifySuccessPopUp(String xPath) {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
			log.info("===== Verify Transaction Successfull Popup Message ======");
			String successMessageXPath = driver.findElementByXPath(xPath).getText();
			String successMessageString = con.getSuccessMessage();
			a.assertEquals(successMessageXPath, successMessageString);
			log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: "
					+ successMessageString);
		} catch (Exception e) {
			System.out.println("Success Message did not present");
		}

	}

	public static void click_On_Ok_Button(String xPath) throws InterruptedException {
		try {
			log.info("==== Click on Ok Button ======");
			Thread.sleep(2000);
			driver.findElementByXPath(xPath).click();
		} catch (Exception e) {
			System.out.println("OK button is not clicked");
		}
	}

	public static void successfulCardPaymentVisa() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void successfulCardPaymentMastercard() throws IOException, InterruptedException {
		try {
			enterValidCardNumberMastercard();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void successfulCardPaymentAmex() throws IOException, InterruptedException {
		try {
			enterValidCardNumberAmex();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void successfulCardPaymentJcb() throws IOException, InterruptedException {
		try {
			enterValidCardNumberJcb();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(10000);
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void successfulCardPaymentDinersClub() throws IOException, InterruptedException {
		try {
			enterValidCardNumberDinersClub();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void successfulCardPaymentDiscover() throws IOException, InterruptedException {
		try {
			enterValidCardNumberDiscover();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			/* InitialiseSDKPageObjects.waitTillElementPresent("payNowButton"); */
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}

	}

	public static void saveCard() throws IOException, InterruptedException {
		try {
			enterValidCardNumberVisa();
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("saveCardCheckbox"));
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void checkIfCardIsSaved() throws IOException, InterruptedException {
		try {
			// initialiseSDK();
			// goToCardPaymentScreen();
//			InitialiseSDKPageObjects.waitToExecuteNextLine("savedCardChild");
//			InitialiseSDKPageObjects.waitTillElementPresent("savedCardChild");
//			driver.findElementByXPath(dictPageObjects.get("selectSavedCard")).click();
			Thread.sleep(20000);
			String savedCard = driver.findElementByXPath(dictPageObjects.get("savedCardChild")).getText();
			System.out.println("SAVED CARDS " + savedCard);
			System.out.println("saved card number: = " + savedCard.contains(dict.get("cardNumberVisaLast4")));
			a.assertTrue(savedCard.contains(dict.get("cardNumberVisaLast4")));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void successfulCardPaymentSavedCard() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("selectSavedCard");
//			driver.findElementByXPath(dictPageObjects.get("selectSavedCard")).click();
//			String savedCard = driver.findElementByName("411111XXXXXX1111").getText();
//			a.assertTrue(savedCard.contains(dict.get("cardNumberVisaLast4")));
			driver.findElementByXPath(dictPageObjects.get("savedCardChild")).click();
			// TODO
			// driver.findElementByXPath(dictPageObjects.get("savedCardcvv")).click();
			// driver.findElementByXPath(dictPageObjects.get("savedCardcvv")).clear();
			Thread.sleep(2000);
//			InitialiseSDKPageObjects.enterField(dict.get("CVV"), dictPageObjects.get("savedCardcvv"));
			driver.findElementByXPath(dictPageObjects.get("savedCardcvv")).sendKeys(dictPageObjects.get("CVV"));// QA-ADG
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("savedCardMakePayButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void deleteCard() throws IOException, InterruptedException {
		try {
			InitialiseSDKPageObjects.explicitwait("savedCardChild");
//			InitialiseSDKPageObjects.waitTillElementPresent("savedCardChild");
			driver.findElementByXPath(dictPageObjects.get("savedCardChild")).click();
//			InitialiseSDKPageObjects.waitTillElementPresent("deleteCardButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("deleteCardButton"));
//			InitialiseSDKPageObjects.waitToExecuteNextLine("deleteCardPopUpTitle");
//			InitialiseSDKPageObjects.waitTillElementPresent("deleteCardPopUpTitle");
			Thread.sleep(3000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("deleteCardOk"));
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitTillElementPresent("cardDeletedSuccessfully");
//			verifyErrorMessage("cardDeletedSuccessfully","payplus_sdk_card_deleted");
			String successTextActual = driver
					.findElementById(
							"//*[@resource-id='com.mahidracomviva.payplus.sdkdemo:id/payplus_sdk_error_heading']")
					.getText();
			String successTextExpected = "Card Deleted Successfully";
			a.assertEquals(successTextActual, successTextExpected);
			log.info("Expected message: " + successTextActual + "\n" + "Actual message displayed: "
					+ successTextExpected);
			Thread.sleep(5000);
			driver.findElementByXPath(dictPageObjects.get("deleteSuccessButton")).click();
//			InitialiseSDKPageObjects.waitTillElementPresent("addCardButton");
			InitialiseSDKPageObjects.explicitwait("addCardButton");
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void cancelCardDeletion() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.waitTillElementPresent("savedCardChild");
			Thread.sleep(3000);
			driver.findElementByXPath(dictPageObjects.get("savedCardChild")).click();
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitTillElementPresent("deleteCardButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("deleteCardButton"));
			Thread.sleep(3000);
//			InitialiseSDKPageObjects.waitTillElementPresent("deleteCardPopUpTitle");

			Thread.sleep(3000);
			if (dataList.get("DeviceType").equals("Android")) {
				driver.navigate().back();
				System.out.println("CLicked on back button");
			} else {
				InitialiseSDKPageObjects.clickButton(dictPageObjects.get(" "));
			}
//			InitialiseSDKPageObjects.waitTillElementPresent("addCardButton");
			InitialiseSDKPageObjects.explicitwait("addCardButton");
			System.out.println("Verify that Add card button is present");
			driver.navigate().back();
//			driver.findElementByXPath(dictPageObjects.get("addCardButton")).isDisplayed();
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void cardRecurringPayment() throws InterruptedException {
		try {
			log.info("Click card button");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardButton"));
			String errorMessageXPath;
			if (dataList.get("DeviceType").equals("Android")) {
				InitialiseSDKPageObjects.waitTillElementPresent("recurringPaymentText");
				errorMessageXPath = driver.findElementByXPath(dictPageObjects.get("recurringPaymentText")).getText();
			} else {
				InitialiseSDKPageObjects.waitTillElementPresent("recurringPaymentTextIOS");
				errorMessageXPath = driver.findElementByXPath(dictPageObjects.get("recurringPaymentTextIOS")).getText();
			}
			String errorMessageString = con.getErrorMessage("payplus_sdk_recurring_text");
			a.assertEquals(errorMessageXPath, errorMessageString);
			log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: "
					+ errorMessageString);
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void cardFreeTrial() throws InterruptedException {
		log.info("Click card button");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardButton"));
		String errorMessageXPath;
		if (dataList.get("DeviceType").equals("Android")) {
			InitialiseSDKPageObjects.waitTillElementPresent("recurringPaymentText");
			errorMessageXPath = driver.findElementByXPath(dictPageObjects.get("recurringPaymentText")).getText();
		} else {
			InitialiseSDKPageObjects.waitTillElementPresent("recurringPaymentTextIOS");
			errorMessageXPath = driver.findElementByXPath(dictPageObjects.get("recurringPaymentTextIOS")).getText();
		}
		String errorMessageString = con.getErrorMessage("payplus_sdk_free_trial_text");
		a.assertEquals(errorMessageXPath, errorMessageString);
		log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: " + errorMessageString);
	}

	public static void failureCardPaymentVisa() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCardNumber"), dictPageObjects.get("cardNumber"));
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("invalidCard"));// QA-ADG
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			Thread.sleep(3000);
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.explicitwait("cardPaymentButton");
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(3000);
			InitialiseSDKPageObjects.explicitwait("retryButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
			Thread.sleep(1000);
			enterValidCvv();
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.explicitwait("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			InitialiseSDKPageObjects.explicitwait("changePaymentMode");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("changePaymentMode"));

			Thread.sleep(3000);
			InitialiseSDKPageObjects.navigateBack();
//			InitialiseSDKPageObjects.explicitwait("PaymentErrorInvalidCard");
//			InitialiseSDKPageObjects.waitTillElementPresent("PaymentErrorInvalidCard");
			Thread.sleep(5000);
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("OKButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void checkForOrderIdRefresh() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCardNumber"), dictPageObjects.get("cardNumber"));
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("invalidCard"));// QA-ADG
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//			driver.hideKeyboard();
//			InitialiseSDKPageObjects.hideKeyboard();
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(7000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
			Thread.sleep(1000);
			log.info("Verify Order Id Home");
			String orderId;
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
			a.assertFalse(orderId.contains(dict.get("orderId")));
			System.out.println(orderId);
			Thread.sleep(1000);
			InitialiseSDKPageObjects.navigateBack();
			Thread.sleep(1000);
			InitialiseSDKPageObjects.navigateBack();
			Thread.sleep(1000);
			InitialiseSDKPageObjects.navigateBack();
			Thread.sleep(1000);
//			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("OKButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void checkForOrderIdRefreshWalletSuccess() throws IOException, InterruptedException {
		try {
			// InitialiseSDKPageObjects.enterField(dict.get("invalidCardNumber"),
			// dictPageObjects.get("cardNumber"));
//					InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("invalidCard"));// QA-ADG
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//					driver.hideKeyboard();
//					InitialiseSDKPageObjects.hideKeyboard();

//					InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(7000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("changePaymentMode"));
			Thread.sleep(1000);
			log.info("Verify Order Id Home");
			String orderId;
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();

			a.assertFalse(orderId.contains(dict.get("orderId")));
			Thread.sleep(1000);
//					InitialiseSDKPageObjects.waitTillElementPresent("walletButton");
//					InitialiseSDKPageObjects.waitToExecuteNextLine("walletButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
			Thread.sleep(1000);
//					InitialiseSDKPageObjects.waitToExecuteNextLine("Mpesa");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
			Thread.sleep(1000);
//					InitialiseSDKPageObjects.waitTillElementPresent("PayINR");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
			Thread.sleep(1000);
//					InitialiseSDKPageObjects.waitTillElementPresent("confirmWalletPayment");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("confirmWalletPayment"));
			Thread.sleep(10000);
//					InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
			Thread.sleep(1000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("successDoneButton"));

		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void failCardPaymentVisaPassWalletPayment() throws IOException, InterruptedException {
		try {
//			InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("invalidCard"));// QA-ADG
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
//			InitialiseSDKPageObjects.hideKeyboard();
//			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");

			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(7000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("changePaymentMode"));
			Thread.sleep(1000);
//			InitialiseSDKPageObjects.waitTillElementPresent("walletButton");
//			InitialiseSDKPageObjects.waitToExecuteNextLine("walletButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
			Thread.sleep(1000);
//			InitialiseSDKPageObjects.waitToExecuteNextLine("Mpesa");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("Mpesa"));
			Thread.sleep(5000);
//			InitialiseSDKPageObjects.waitTillElementPresent("PayINR");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("PayINR"));
			Thread.sleep(5000);
//			InitialiseSDKPageObjects.waitTillElementPresent("confirmWalletPayment");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("confirmWalletPayment"));
			Thread.sleep(10000);
//			InitialiseSDKPageObjects.waitTillElementPresent("CardPaymenetSuccess");
			InitialiseSDKPageObjects.explicitwait("successDoneButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("successDoneButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	public static void RetryCardPaymentVisa() throws IOException, InterruptedException {
		try {
			InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
			enterValidExpiry();
			enterValidCardHolderName();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
			Thread.sleep(3000);
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
			Thread.sleep(500);
			enterValidCardNumberVisa();
			enterValidCvv();
			driver.hideKeyboard();
			InitialiseSDKPageObjects.hideKeyboard();
			InitialiseSDKPageObjects.waitToExecuteNextLine("cardPaymentButton");
			InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		} catch (Exception e) {
			System.out.println("User did not redirected to Add card detail screen");
		}
	}

	// *****QA-ADG******//
	public static void RetryCardPaymentusingVisa() throws Exception {
		Thread.sleep(2000);
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
		Thread.sleep(2000);
		enterValidCardNumberVisa();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
		// InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.explicitwait("cardPaymentButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
	}

}