package pageObjectsAndroid;

import static org.testng.Assert.assertFalse;


import java.io.IOException;
import java.util.Dictionary;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CardSavePageObjects extends GlobalVariables {

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
			pageObjectsSheetName = "CardPaymentDataAndroid";
		}
		else {  
			pageObjectsSheetName = "CardPaymentData";
		}
		System.out.println("Page Object Sheet Name = "+pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}
	//*QA-ADG*//
	public static void goToInitiatecardScreen() throws Throwable
	{
//		InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");
		log.info("===== Click on Cards options from Online payments menu =====");
		Thread.sleep(1000);
		driver.findElementByXPath(dictPageObjects.get("cardButton")).click();
	}
	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());


	public static void verifyCardSaveScreen() throws InterruptedException {
		log.info("Click card button");
//		InitialiseSDKPageObjects.waitTillElementPresent("savecard");
//		String card = driver.findElementByXPath(dictPageObjects.get("savecard")).getText();
//		a.assertTrue(card.contains(dict.get("savecard")));
		String card = driver.findElementByXPath(dictPageObjects.get("savedCards")).getText();
		a.assertEquals(card, "Saved cards");
//		a.assertTrue(card.contains(dict.get("savedCards")));
		InitialiseSDKPageObjects.navigateBack();
	}
	

	public static void verifyErrorMessage(String xPath, String errorString) {
		InitialiseSDKPageObjects.waitTillElementPresent(xPath);
		String errorMessageXPath = driver.findElementByXPath(dictPageObjects.get(xPath)).getText();
		String errorMessageString = con.getErrorMessage(errorString);
		a.assertEquals(errorMessageXPath, errorMessageString);
		log.info("Expected message: " + errorMessageString + "\n" + "Actual message displayed: " + errorMessageString);
	}

	public static void enterValidCardNumberVisa() throws Exception {
		try {
			//dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, cardparmeters);
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).clear();
//			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys("1234456778");
			//InitialiseSDKPageObjects.enterField(dict.get("cardNumberVisa"), dictPageObjects.get("cardNumber"));
			driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberVisa"));//QA-ADG
		} catch (Exception e) {
			System.out.println("User did not redirected to online payment screen");
		}
	}

	public static void enterValidCardHolderName() throws IOException, InterruptedException {
		driver.findElementByXPath(dictPageObjects.get("nameOnCard")).clear();
//		InitialiseSDKPageObjects.enterField(dict.get("nameOnCard"), dictPageObjects.get("nameOnCard"));
		driver.findElementByXPath(dictPageObjects.get("nameOnCard")).sendKeys(dictPageObjects.get("NameOnCard"));//QA-ADG
	}

	public static void enterValidExpiry() throws IOException, InterruptedException {
		try {
			driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(dictPageObjects.get("Expiry"));//QA-ADG
//			if (!dataList.get("DeviceType").equals("Android")) {
//				InitialiseSDKPageObjects.enterField(dict.get("expiry").replace("/", ""), dictPageObjects.get("Expiry"));
//			}else {		
//				driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
//				InitialiseSDKPageObjects.enterField(dict.get("expiry").replace("/", ""), dictPageObjects.get("expiry"));
//			}
		} catch (Exception e) {
			System.out.println("User did not redirected to online payment screen");
		}
		
	}

	public static void enterValidCvv() throws IOException, InterruptedException {
			driver.findElementByXPath(dictPageObjects.get("cvv")).clear();
			//InitialiseSDKPageObjects.enterField(dict.get("cvv"), dictPageObjects.get("CVV"));
			driver.findElementByXPath(dictPageObjects.get("cvv")).sendKeys(dictPageObjects.get("CVV"));//QA-ADG
	}
	
	public static void enterValidCardNumberMastercard() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.enterField(dict.get("cardNumberMastercard"), dictPageObjects.get("cardNumber"));
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberMastercard"));//QA-ADG
	}
	
	public static void enterValidCardNumberAmex() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.enterField(dict.get("cardNumberAmex"), dictPageObjects.get("cardNumber"));
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberAmex"));//QA-ADG
	}
	
	public static void enterValidCardNumberDinersClub() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.enterField(dict.get("cardNumberDinersClub"), dictPageObjects.get("cardNumber"));
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberDinnersclub"));//QA-ADG
	}
	
	public static void enterValidCardNumberDiscover() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.enterField(dict.get("cardNumberDiscover"), dictPageObjects.get("cardNumber"));
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberDiscover"));//QA-ADG
	}
	
	public static void enterValidCardNumberJcb() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.enterField(dict.get("cardNumberJcb"), dictPageObjects.get("cardNumber"));
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberJcb"));//QA-ADG
	}

	public static void blankCardNumber() throws IOException, InterruptedException {
		InitialiseSDKPageObjects.enterField("", dictPageObjects.get("cardNumber"));
		enterValidCardHolderName();
		enterValidCvv();
		enterValidExpiry();
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
		
	}

	public static void invalidCardNumber() throws IOException, InterruptedException {
		InitialiseSDKPageObjects.enterField(dict.get("invalidCardNumber"), dictPageObjects.get("cardNumber"));
		enterValidExpiry();
		enterValidCardHolderName();
		enterValidCvv();
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		verifyErrorMessage("invalidCardNumberError","payplus_sdk_invalid_card_number");
	}

	public static void blankExpiry() throws Exception {
		enterValidCardNumberVisa();
		enterValidCardHolderName();
		enterValidCvv();
		
		if (dataList.get("DeviceType").equals("Android")) {
			driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
		}else {
			driver.findElementByXPath(dictPageObjects.get("expiry")).click();
			InitialiseSDKPageObjects.clickKeyboardBackButton();
			InitialiseSDKPageObjects.clickKeyboardBackButton();
			InitialiseSDKPageObjects.clickKeyboardBackButton();
			InitialiseSDKPageObjects.clickKeyboardBackButton();
			InitialiseSDKPageObjects.clickKeyboardBackButton();
		}
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
		//verifyErrorMessage("emptyExpiryError","payplus_sdk_empty_expiry_date");
	}

	public static void invalidExpiry() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidCardHolderName();
		enterValidCvv();
		InitialiseSDKPageObjects.waitTillElementPresent("expiry");
		if (!dataList.get("DeviceType").equals("Android")) {
			InitialiseSDKPageObjects.enterField(dict.get("invalidExpiry").replace("/", ""), dictPageObjects.get("expiry"));
		}else {
			driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
			InitialiseSDKPageObjects.enterField(dict.get("invalidExpiry"), dictPageObjects.get("expiry"));
		}
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		verifyErrorMessage("invalidExpiryError","payplus_sdk_invalid_expiry");
	}

	public static void blankCardHolder() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidExpiry();
		enterValidCvv();
		driver.findElementByXPath(dictPageObjects.get("nameOnCard")).clear();
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
		
	}

	public static void invalidCardHolder() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidExpiry();
		enterValidCvv();
		InitialiseSDKPageObjects.enterField(dict.get("invalidNameOnCard"), dictPageObjects.get("nameOnCard"));
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		verifyErrorMessage("invalidNameOnCardError","payplus_sdk_invalid_card_holder_name");
	}

	public static void blankCvv() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidExpiry();
		enterValidCardHolderName();
		driver.findElementByXPath(dictPageObjects.get("cvv")).clear();
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		assertFalse(driver.findElementByXPath(dictPageObjects.get("cardPaymentButton")).isEnabled());
		
	}

	public static void invalidCvv() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidExpiry();
		enterValidCardHolderName();
		InitialiseSDKPageObjects.enterField(dict.get("invalidCvv"), dictPageObjects.get("cvv"));
		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		verifyErrorMessage("invalidCvvError","payplus_sdk_invalid_cvv");
	}
	
	public static void verifySuccessfulTransactionToast() {
		String txnMessage = driver.findElementByXPath("//android.widget.Toast[@text='Transaction successful']").getText();
		a.assertTrue(txnMessage.contains(dict.get("transactionSuccessful")));
	}
	
	public static void verifySuccessPopUp(String xPath)
	{
//		InitialiseSDKPageObjects.waitTillElementPresent("CardSaveSuccess");
		log.info("===== Verify Transaction Successfull Popup Message ======");
			String successMessageXPath = driver.findElementByXPath(xPath).getText();
			String successMessageString = con.getSuccessMessage();
			a.assertEquals(successMessageXPath, successMessageString);
			log.info("Expected message: " + successMessageXPath + "\n" + "Actual message displayed: " + successMessageString);
	}
	
	public static void click_On_Ok_Button(String xPath)
	{
		log.info("==== Click on Ok Button ======");
		driver.findElementByXPath(xPath).click();
	}

	public static void successfulCardPaymentVisa() throws Exception, InterruptedException {
		enterValidCardNumberVisa();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
		//InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
	}
	
	public static void successfulCardPaymentMastercard() throws IOException, InterruptedException {
		enterValidCardNumberMastercard();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
//		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
	}
	
	public static void successfulCardPaymentAmex() throws IOException, InterruptedException {
		enterValidCardNumberAmex();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
//		InitialiseSDKPageObjects.hideKeyboard();
		
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
	}
	
	public static void successfulCardPaymentDinersClub() throws IOException, InterruptedException {
		enterValidCardNumberDinersClub();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
//		InitialiseSDKPageObjects.hideKeyboard();
		
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		/*InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");*/

	}
	
	public static void successfulCardPaymentDiscover() throws IOException, InterruptedException {
		enterValidCardNumberDiscover();
		enterValidExpiry();
		enterValidCardHolderName();
		enterValidCvv();
//		InitialiseSDKPageObjects.hideKeyboard();
		
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		/*InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");*/

	}
	
	public static void RetryCardPaymentVisa() throws Exception, InterruptedException {
		InitialiseSDKPageObjects.enterField(dict.get("invalidCard"), dictPageObjects.get("cardNumber"));
		enterValidExpiry();
		enterValidCardHolderName();
		enterValidCvv();
		InitialiseSDKPageObjects.hideKeyboard();
		
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		Thread.sleep(3000);
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
		Thread.sleep(500);
		enterValidCardNumberVisa();
		enterValidCvv();
		InitialiseSDKPageObjects.hideKeyboard();
		
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
	}
	//*****QA-ADG******//
	public static void RetryCardPaymentusingVisa() throws Exception {
		Thread.sleep(2000);
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("retryButton"));
		Thread.sleep(20000);
		enterValidCardNumberVisa();
		enterValidCardHolderName();
		enterValidExpiry();
		enterValidCvv();
		//InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.explicitwait("cardPaymentButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		Thread.sleep(2000);
	}
	public static void successfulCardPaymentJcb() throws IOException, InterruptedException {
		enterValidCardNumberJcb();
		enterValidExpiry();
		enterValidCardHolderName();
		enterValidCvv();
//		driver.hideKeyboard();
//		InitialiseSDKPageObjects.hideKeyboard();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("cardPaymentButton"));
		/*InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");*/
	}
	
}