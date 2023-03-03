package pageObjectsAndroid;

import java.io.IOException;
import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;

import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InitialiseSDKPageObjects extends GlobalVariables {

	private static String SheetName = "Login";
	private static Dictionary<String, String> dataList;
	private static Assertion a = new Assertion();

	abstract class GenericDriverAbstract {    
		//protected  WebDriver driver;

		protected AppiumDriver driver;

		public GenericDriverAbstract(AppiumDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	}
	/*ADG- Read Test data*/
	public static void readtestdatas() throws Exception{
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
	}

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "DemoAppLocators";
		}
		else {  
			pageObjectsSheetName = "DemoAppLocators";
		}
		System.out.println("Page Object Sheet Name = "+pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static Logger log = Logger.getLogger(InitialiseSDKPageObjects.class.getName());

	public static void waitTillElementPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dictPageObjects.get(locator)))));
	}
	
	public static void waitToExecuteNextLine(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(dictPageObjects.get(locator)))));
	}
	//*QA-ADG*//
	public static void explicitwait(String locators) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dictPageObjects.get(locators))));
	}

	public static void enterField(String field, String id) throws IOException, InterruptedException {
		log.info("Enter field: " + field);
		//driver.findElementByXPath(id).click();
		driver.getKeyboard().sendKeys(field);
		driver.hideKeyboard();
	}
	//QA-ADG
//	public static void enterField1(String field, String id) throws IOException, InterruptedException {
//		log.info("Enter field: " + field);
//		driver.find
//		driver.getKeyboard().sendKeys(field);
//		driver.hideKeyboard();
//	}

	public static void clickButton (String button) {
		driver.findElementByXPath(button).click();
	}
	
	public static void hideKeyboard() throws InterruptedException {
		if (dataList.get("DeviceType").equals("Android")) {
			driver.hideKeyboard();        
		}else { 
			driver.tap(1, 150, 40, 500);
		}
	}
	
	public static void clickKeyboardBackButton() {
		if (!dataList.get("DeviceType").equals("Android")) {
			driver.findElementByXPath("//*[@id='Delete']").click();
		}
	}

	public static void enterFieldWithNext(String field, String id) throws IOException, InterruptedException {
		log.info("Enter field: " + field);
		driver.findElementByXPath(id).click();
		driver.getKeyboard().sendKeys(field);
		if (dataList.get("DeviceType").equals("Android")) {
			((AndroidDriver) driver).pressKeyCode(66);        
		}
		else { 
			driver.findElementByXPath("//*[@id='Return']").click();
		}
	}

	public static void navigateBack()
	{	
		if (dataList.get("DeviceType").equals("Android")) {
			driver.navigate().back();
		}
		else {
			driver.findElementByXPath(dictPageObjects.get("iOSbackButton")).click();
		}
	}

	public static void enterSDKFields() throws IOException, InterruptedException {
		enterFieldWithNext(dict.get("merchantName"), dictPageObjects.get("merchantName"));
		enterFieldWithNext(dict.get("productName"), dictPageObjects.get("productName"));
		enterFieldWithNext(dict.get("mobileNumber"), dictPageObjects.get("mobileNumber"));
		enterFieldWithNext(dict.get("email"), dictPageObjects.get("email"));
		enterFieldWithNext(dict.get("amount"), dictPageObjects.get("amount"));
		enterFieldWithNext(dict.get("taxAmount"), dictPageObjects.get("taxAmount"));
		enterFieldWithNext(dict.get("appColor"), dictPageObjects.get("appColor"));
		enterFieldWithNext(dict.get("fontColor"), dictPageObjects.get("fontColor"));
		enterFieldWithNext(dict.get("statusBarColor"), dictPageObjects.get("statusBarColor"));
		enterFieldWithNext(dict.get("currency"), dictPageObjects.get("currency"));
		enterFieldWithNext(dict.get("countryCode"), dictPageObjects.get("countryCode"));
		enterFieldWithNext(dict.get("endPoint"), dictPageObjects.get("endPoint"));
		enterFieldWithNext(dict.get("orderId"), dictPageObjects.get("orderId"));
		enterFieldWithNext(dict.get("customerCode"), dictPageObjects.get("customerCode"));
		enterFieldWithNext(dict.get("checkSum"), dictPageObjects.get("checkSum"));
		enterFieldWithNext(dict.get("checkSumPayment"), dictPageObjects.get("checkSumPayment"));
		enterFieldWithNext(dict.get("taxIncluded"), dictPageObjects.get("taxIncluded"));
		enterFieldWithNext(dict.get("hierarchyLabelIDReference"), dictPageObjects.get("hierarchyLabelIDReference"));
		enterFieldWithNext(dict.get("paymentChannel"), dictPageObjects.get("paymentChannel"));
		enterFieldWithNext(dict.get("hierarchyCriteria"), dictPageObjects.get("hierarchyCriteria"));
		enterFieldWithNext(dict.get("electronicGoodsIndicator"), dictPageObjects.get("electronicGoodsIndicator"));
		enterFieldWithNext(dict.get("shippingDate"), dictPageObjects.get("shippingDate"));
		enterFieldWithNext(dict.get("billingZipCode"), dictPageObjects.get("billingZipCode"));
		enterFieldWithNext(dict.get("billingAddressLine1"), dictPageObjects.get("billingAddressLine1"));
		enterFieldWithNext(dict.get("billingAddressLine2"), dictPageObjects.get("billingAddressLine2"));
		enterFieldWithNext(dict.get("billingCountry"), dictPageObjects.get("billingCountry"));
		enterFieldWithNext(dict.get("billingState"), dictPageObjects.get("billingState"));
		enterFieldWithNext(dict.get("billingCity"), dictPageObjects.get("billingCity"));
		enterFieldWithNext(dict.get("shipAddressLine1"), dictPageObjects.get("shipAddressLine1"));
		enterFieldWithNext(dict.get("shipAddressLine2"), dictPageObjects.get("shipAddressLine2"));
		enterFieldWithNext(dict.get("shipToCity"), dictPageObjects.get("shipToCity"));
		enterFieldWithNext(dict.get("shipToCountry"), dictPageObjects.get("shipToCountry"));
		enterFieldWithNext(dict.get("shipToState"), dictPageObjects.get("shipToState"));
		enterFieldWithNext(dict.get("shipToZipCode"), dictPageObjects.get("shipToZipCode"));
		enterFieldWithNext(dict.get("customerDialCode"), dictPageObjects.get("customerDialCode"));
		enterFieldWithNext(dict.get("customerLastName"), dictPageObjects.get("customerLastName"));
		enterFieldWithNext(dict.get("customerFirstName"), dictPageObjects.get("customerFirstName"));
		driver.hideKeyboard();
		
	}
	
	public static void enterCustomCodeForRecurringFreetrail() throws IOException, InterruptedException {
		enterFieldWithNext(dict.get("merchantName"), dictPageObjects.get("merchantName"));
		enterFieldWithNext(dict.get("productName"), dictPageObjects.get("productName"));
		enterFieldWithNext(dict.get("mobileNumber"), dictPageObjects.get("mobileNumber"));
		enterFieldWithNext(dict.get("email"), dictPageObjects.get("email"));
		enterFieldWithNext(dict.get("amount"), dictPageObjects.get("amount"));
		enterFieldWithNext(dict.get("taxAmount"), dictPageObjects.get("taxAmount"));
		enterFieldWithNext(dict.get("appColor"), dictPageObjects.get("appColor"));
		enterFieldWithNext(dict.get("fontColor"), dictPageObjects.get("fontColor"));
		enterFieldWithNext(dict.get("statusBarColor"), dictPageObjects.get("statusBarColor"));
		enterFieldWithNext(dict.get("currency"), dictPageObjects.get("currency"));
		enterFieldWithNext(dict.get("countryCode"), dictPageObjects.get("countryCode"));
		enterFieldWithNext(dict.get("endPoint"), dictPageObjects.get("endPoint"));
		enterFieldWithNext(dict.get("orderId"), dictPageObjects.get("orderId"));
		enterFieldWithNext(dict.get("customerCodeRecurring"), dictPageObjects.get("customerCode"));
		enterFieldWithNext(dict.get("checkSum"), dictPageObjects.get("checkSum"));
		enterFieldWithNext(dict.get("checkSumPayment"), dictPageObjects.get("checkSumPayment"));
		enterFieldWithNext(dict.get("taxIncluded"), dictPageObjects.get("taxIncluded"));
		enterFieldWithNext(dict.get("hierarchyLabelIDReference"), dictPageObjects.get("hierarchyLabelIDReference"));
		enterFieldWithNext(dict.get("paymentChannel"), dictPageObjects.get("paymentChannel"));
		enterFieldWithNext(dict.get("hierarchyCriteria"), dictPageObjects.get("hierarchyCriteria"));
		enterFieldWithNext(dict.get("electronicGoodsIndicator"), dictPageObjects.get("electronicGoodsIndicator"));
		enterFieldWithNext(dict.get("shippingDate"), dictPageObjects.get("shippingDate"));
		enterFieldWithNext(dict.get("billingZipCode"), dictPageObjects.get("billingZipCode"));
		enterFieldWithNext(dict.get("billingAddressLine1"), dictPageObjects.get("billingAddressLine1"));
		enterFieldWithNext(dict.get("billingAddressLine2"), dictPageObjects.get("billingAddressLine2"));
		enterFieldWithNext(dict.get("billingCountry"), dictPageObjects.get("billingCountry"));
		enterFieldWithNext(dict.get("billingState"), dictPageObjects.get("billingState"));
		enterFieldWithNext(dict.get("billingCity"), dictPageObjects.get("billingCity"));
		enterFieldWithNext(dict.get("shipAddressLine1"), dictPageObjects.get("shipAddressLine1"));
		enterFieldWithNext(dict.get("shipAddressLine2"), dictPageObjects.get("shipAddressLine2"));
		enterFieldWithNext(dict.get("shipToCity"), dictPageObjects.get("shipToCity"));
		enterFieldWithNext(dict.get("shipToCountry"), dictPageObjects.get("shipToCountry"));
		enterFieldWithNext(dict.get("shipToState"), dictPageObjects.get("shipToState"));
		enterFieldWithNext(dict.get("shipToZipCode"), dictPageObjects.get("shipToZipCode"));
		enterFieldWithNext(dict.get("customerDialCode"), dictPageObjects.get("customerDialCode"));
		enterFieldWithNext(dict.get("customerLastName"), dictPageObjects.get("customerLastName"));
		enterFieldWithNext(dict.get("customerFirstName"), dictPageObjects.get("customerFirstName"));
		driver.hideKeyboard();
	}
	
	public static void enterSDKFieldsWithInValidValues() throws IOException, InterruptedException {
		enterFieldWithNext(dict.get("merchantName"), dictPageObjects.get("merchantName"));
		enterFieldWithNext(dict.get("productName"), dictPageObjects.get("productName"));
		enterFieldWithNext(dict.get("mobileNumber"), dictPageObjects.get("mobileNumber"));
		enterFieldWithNext(dict.get("email"), dictPageObjects.get("email"));
		enterFieldWithNext(dict.get("amount"), dictPageObjects.get("amount"));
		enterFieldWithNext(dict.get("taxAmount"), dictPageObjects.get("taxAmount"));
		enterFieldWithNext(dict.get("appColor"), dictPageObjects.get("appColor"));
		enterFieldWithNext(dict.get("fontColor"), dictPageObjects.get("fontColor"));
		enterFieldWithNext(dict.get("statusBarColor"), dictPageObjects.get("statusBarColor"));
		enterFieldWithNext(dict.get("currency"), dictPageObjects.get("currency"));
		enterFieldWithNext(dict.get("countryCode"), dictPageObjects.get("countryCode"));
		enterFieldWithNext(dict.get("endPoint"), dictPageObjects.get("endPoint"));
		enterFieldWithNext(dict.get("orderId"), dictPageObjects.get("orderId"));
		enterFieldWithNext(dict.get("customerCode"), dictPageObjects.get("customerCode"));
		enterFieldWithNext(dict.get("checkSum"), dictPageObjects.get("checkSum"));
		enterFieldWithNext(dict.get("checkSumPaymentInvalid"), dictPageObjects.get("checkSumPayment"));
		enterFieldWithNext(dict.get("taxIncluded"), dictPageObjects.get("taxIncluded"));
		enterFieldWithNext(dict.get("hierarchyLabelIDReference"), dictPageObjects.get("hierarchyLabelIDReference"));
		enterFieldWithNext(dict.get("paymentChannel"), dictPageObjects.get("paymentChannel"));
		enterFieldWithNext(dict.get("hierarchyCriteria"), dictPageObjects.get("hierarchyCriteria"));
		enterFieldWithNext(dict.get("electronicGoodsIndicator"), dictPageObjects.get("electronicGoodsIndicator"));
		enterFieldWithNext(dict.get("shippingDate"), dictPageObjects.get("shippingDate"));
		enterFieldWithNext(dict.get("billingZipCode"), dictPageObjects.get("billingZipCode"));
		enterFieldWithNext(dict.get("billingAddressLine1"), dictPageObjects.get("billingAddressLine1"));
		enterFieldWithNext(dict.get("billingAddressLine2"), dictPageObjects.get("billingAddressLine2"));
		enterFieldWithNext(dict.get("billingCountry"), dictPageObjects.get("billingCountry"));
		enterFieldWithNext(dict.get("billingState"), dictPageObjects.get("billingState"));
		enterFieldWithNext(dict.get("billingCity"), dictPageObjects.get("billingCity"));
		enterFieldWithNext(dict.get("shipAddressLine1"), dictPageObjects.get("shipAddressLine1"));
		enterFieldWithNext(dict.get("shipAddressLine2"), dictPageObjects.get("shipAddressLine2"));
		enterFieldWithNext(dict.get("shipToCity"), dictPageObjects.get("shipToCity"));
		enterFieldWithNext(dict.get("shipToCountry"), dictPageObjects.get("shipToCountry"));
		enterFieldWithNext(dict.get("shipToState"), dictPageObjects.get("shipToState"));
		enterFieldWithNext(dict.get("shipToZipCode"), dictPageObjects.get("shipToZipCode"));
		enterFieldWithNext(dict.get("customerDialCode"), dictPageObjects.get("customerDialCode"));
		enterFieldWithNext(dict.get("customerLastName"), dictPageObjects.get("customerLastName"));
		enterFieldWithNext(dict.get("customerFirstName"), dictPageObjects.get("customerFirstName"));
		driver.hideKeyboard();
		
	}

	public static void initialiseSDK() throws IOException, InterruptedException {
		if (dataList.get("Testing").equals("true")) {
			clickButton(dictPageObjects.get("defaultButton"));
			for (int i = 0; i <= 4; i++) {
				driver.executeScript("seetest:client.swipe(\"Down\", 100, 500)");
			}
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}

	public static void initialiseSDKWithInvalidValues() throws IOException, InterruptedException {
		    enterSDKFieldsWithInValidValues();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
	}
	
	public static void initialiseSDKFreeTrial() throws IOException, InterruptedException {
		if (dataList.get("Testing").equals("true")) {
			driver.hideKeyboard();	
			clickButton(dictPageObjects.get("defaultButton"));
			for (int i = 0; i <= 2 ; i++) {
				driver.executeScript("seetest:client.swipe(\"Down\", 100, 500)");
			}
			waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	//*QA-ADG*//
	public static void initialiseSDKFreeTrial1() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
		if (dataList.get("Testing").equals("true")) {
			//driver.hideKeyboard();	
			clickButton(dictPageObjects.get("defaultButton"));
			MobileCapabilities.Swipedown();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			Thread.sleep(1000);
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}

	public static void initialiseSDKRecurringPayment() throws IOException, InterruptedException {
		if (dataList.get("Testing").equals("true")) {
			driver.hideKeyboard();
			clickButton(dictPageObjects.get("defaultButton"));
			for (int i = 0; i <= 2 ; i++) {
				driver.executeScript("seetest:client.swipe(\"Down\", 100, 500)");
			}

			waitTillElementPresent("recurringPayment");
			clickButton(dictPageObjects.get("recurringPayment"));
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			waitTillElementPresent("recurringPayment");
			clickButton(dictPageObjects.get("recurringPayment"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	//*QA-ADG*//
	public static void initialiseSDKRecurringPayment1() throws Exception {
		//readtestdatas();
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
		if (dataList.get("Testing").equals("true")) {
			//driver.hideKeyboard();
			clickButton(dictPageObjects.get("defaultButton"));
			MobileCapabilities.Swipedown();
			//waitTillElementPresent("recurringPayment");
			clickButton(dictPageObjects.get("recurringPayment"));
			Thread.sleep(1000);
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			waitTillElementPresent("recurringPayment");
			clickButton(dictPageObjects.get("recurringPayment"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}

	public static void verifyHomeScreen() throws IOException, InterruptedException {
//		waitTillElementPresent("orderIdHome");
		InitialiseSDKPageObjects.explicitwait("orderIdHome");
		Thread.sleep(1000);
		String orderId;
		if (dataList.get("DeviceType").equals("Android")) {
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
		}
		else { 
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
		}
		System.out.println(orderId);
		System.out.println(dict.get("orderId"));
		test.log(Status.PASS, orderId);
		test.log(Status.PASS, dict.get("orderId"));
		a.assertTrue(orderId.contains(dict.get("orderId")));
	}
	//QA-ADG
	public static void HomescreenVerification() {
		InitialiseSDKPageObjects.explicitwait("orderIdHome");
		String Onlinemethods = driver.findElementByXPath(dictPageObjects.get("onlinepayments")).getText();
		a.assertEquals(Onlinemethods, "Online Payments");
	}
	/*QA ADG*/
	public static void homescreeninitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
		if (dataList.get("Testing").equals("true")) {
			clickButton(dictPageObjects.get("buyNowButton"));
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	
	/*QA ADG*/
	public static void sdkinitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "DemoAppLocators");
		if (dataList.get("Testing").equals("true")) {
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
			//waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("buyNowButton"));
			Thread.sleep(3000);
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	public static void initialiseFreeTrial() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "DemoAppLocators");
		if (dataList.get("Testing").equals("true")) {
			//driver.hideKeyboard();	
			clickButton(dictPageObjects.get("defaultButton"));
			MobileCapabilities.Swipedown();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			Thread.sleep(1000);
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	public static void initialiseRecurring() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "DemoAppLocators");
		if (dataList.get("Testing").equals("true")) {
			//driver.hideKeyboard();	
			clickButton(dictPageObjects.get("defaultButton"));
			MobileCapabilities.Swipedown();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("recurringPayment"));
			Thread.sleep(1000);
			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			//enterSDKFields();
			//waitTillElementPresent("freeTrial");
			clickButton(dictPageObjects.get("freeTrial"));
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	/*QA ADG*/
	public static void homewalletinitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "WalletHomeData");
		if (dataList.get("Testing").equals("true")) {
			commonLibrary.explicitWait("buyNowButton");
			clickButton(dictPageObjects.get("buyNowButton"));
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
//			//waitTillElementPresent("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	/*QA ADG*/
	public static void homeInitaiteAndconfirmwallet() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "InitiateWalletData");
		if (dataList.get("Testing").equals("true")) {
			commonLibrary.explicitWait("buyNowButton");
			commonLibrary.clickButton("buyNowButton");
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
//			//waitTillElementPresent("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	/*QA ADG*/
	public static void homecardinitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "CardPaymentDataAndroid");
		if (dataList.get("Testing").equals("true")) {
			Thread.sleep(2000);;
			commonLibrary.explicitWait("buyNowButton");
			commonLibrary.clickButton("buyNowButton");
//			explicitwait("defaultButton");
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
////			waitTillElementPresent("payNowButton");
//			explicitwait("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	/*QA ADG*/
	public static void bankinitialization() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "BankTransferData");
		if (dataList.get("Testing").equals("true")) {
			commonLibrary.explicitWait("buyNowButton");
			commonLibrary.clickButton("buyNowButton");
//			explicitwait("defaultButton");
//			clickButton(dictPageObjects.get("defaultButton"));
//			MobileCapabilities.Swipedown();
////			waitTillElementPresent("payNowButton");
//			explicitwait("payNowButton");
//			clickButton(dictPageObjects.get("payNowButton"));
		} else {
			enterSDKFields();
			waitTillElementPresent("payNowButton");
			clickButton(dictPageObjects.get("payNowButton"));
		}
	}
	public static void isElementPresent(String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dictPageObjects.get(element))));
		}catch (NoSuchElementException e) {
			System.out.println("Element not present");
		}
	}

//	public static void setAirPlaneModeOn(Boolean enable) {
//		if (dataList.get("DeviceType").equals("Android")) {
//			if(GlobalVariables.driver instanceof AndroidDriver) {
//				ConnectionState connection = new ConnectionState(ConnectionState.WIFI_MASK);
//				if(enable) {
//				connection = new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
//				}
//				((AndroidDriver)driver).setConnection(connection );
//			}
//		} else {
//			//handle ios airplane mode 
//		}
//	}
}