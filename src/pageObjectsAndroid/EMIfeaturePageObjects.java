package pageObjectsAndroid;

import java.io.IOException;
import java.util.Dictionary;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EMIfeaturePageObjects extends GlobalVariables {
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

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void clickButton(String button) {
		driver.findElementByXPath(button).click();//QA-ADG
	}
	public static void sendValues(String element, String value) {
		driver.findElementByXPath(dictPageObjects.get(element)).sendKeys(dictPageObjects.get(value));//QA-ADG
	}

	public static void explicitwait(String locators) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dictPageObjects.get(locators))));
	}
	public static void enterValidCardNumberVisa() throws Exception {
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).clear();
		driver.findElementByXPath(dictPageObjects.get("cardNumber")).sendKeys(dictPageObjects.get("cardNumberVisa"));//QA-ADG
	}
	public static void enterValidCardHolderName() throws IOException, InterruptedException {
		driver.findElementByXPath(dictPageObjects.get("nameOnCard")).clear();
		driver.findElementByXPath(dictPageObjects.get("nameOnCard")).sendKeys(dictPageObjects.get("NameOnCard"));//QA-ADG
	}
	public static void enterValidExpiry() throws IOException, InterruptedException {
		driver.findElementByXPath(dictPageObjects.get("expiry")).clear();
		driver.findElementByXPath(dictPageObjects.get("expiry")).sendKeys(dictPageObjects.get("Expiry"));//QA-ADG
	}
	public static void enterValidCvv() throws IOException, InterruptedException {
		driver.findElementByXPath(dictPageObjects.get("cvv")).clear();
		driver.findElementByXPath(dictPageObjects.get("cvv")).sendKeys(dictPageObjects.get("CVV"));//QA-ADG
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

	public static void goToEMICardsScreen() throws Throwable {
		try {
			log.info("===== Click on EMI on Credit/Debit cards menu =====");
			Thread.sleep(1000);
			clickButton(dictPageObjects.get("emi_credit_Debit_cards"));
		} catch (Exception e) {
			System.out.println("User did not redirected to EMI card screen");
		}
		
	}

	public static void captureTitleOfEMIcard() throws Throwable {
		try {
			log.info("===== Verify EMI title =====");
			Thread.sleep(1000);
			// explicitwait("EMI_On_Cards_Title");
			String Title = driver.findElementByXPath(dictPageObjects.get("emi_On_Cards_Title")).getText();
			a.assertTrue(Title.contains("EMI"));
			
		} catch (Exception e) {
			System.out.println("EMI title is not verified");
		}
	}

	public static void verifydisbaledcard() throws Throwable {
		log.info("===== Verify disabled saved card =====");
		Thread.sleep(1000);
		try {
			explicitwait("disabled_Savedcards");
			clickButton(dictPageObjects.get("disabled_Savedcards"));
			explicitwait("oKBtn_EMInotAvailable_popup");
//			String cardText = driver.findElementByXPath(dictPageObjects.get("text_EMInotAvailable_popup")).getText();
//			a.assertTrue(cardText.contains("EMI not available for this card"));
			clickButton(dictPageObjects.get("oKBtn_EMInotAvailable_popup"));
		} catch (Exception e) {
			System.out.println("Disabled Savedcard is not present");
		}
	}

	public static void payEMI_savedcard() throws Throwable {
		String cardText = driver.findElementByXPath(dictPageObjects.get("savedCardVisa")).getText();
		System.out.println(cardText);
		if (cardText.contains("1111")) {
			try {
				clickButton(dictPageObjects.get("savedCardVisa"));
				sendValues("cvvSavedCard", "cvv");
				Thread.sleep(7000);
				clickButton(dictPageObjects.get("viewEMIPlansBtnText"));
				Thread.sleep(10000);
				explicitwait("emiTenure");
				clickButton(dictPageObjects.get("emiTenure"));
				clickButton(dictPageObjects.get("emiPay"));
				explicitwait("doneBtnFinalTransaction");
				clickButton(dictPageObjects.get("doneBtnFinalTransaction"));
				System.out.println("EMI Transaction is successful from saved card and user is in homescreen");
			} catch (Exception e) {
				System.out.println("There is no saved card");
			}
		} else {
			goToEMICardsScreen();
			clickButton(cardText);
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidExpiry();
			enterValidCvv();
			explicitwait("viewEMIPlanBtn");
			Thread.sleep(6000);
			clickButton(dictPageObjects.get("viewEMIPlanBtn"));
			explicitwait("emiTenure");
			clickButton(dictPageObjects.get("emiTenure"));
			clickButton(dictPageObjects.get("emiPay"));
			explicitwait("doneBtnFinalTransaction");
			clickButton(dictPageObjects.get("doneBtnFinalTransaction"));
		}
	}
	public static void addAnotherCard_payment() throws Throwable {
		try {
			enterValidCardNumberVisa();
			enterValidCardHolderName();
			enterValidExpiry();
			enterValidCvv();
			Thread.sleep(6000);
			clickButton(dictPageObjects.get("viewEMIPlansBtnText"));
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("User did not get redirected to add another cad payment");
		}
		
	}
	public static void viewAllEMIPlans() {
	try {
		explicitwait("view_All_EMI_Plans");
		clickButton(dictPageObjects.get("view_All_EMI_Plans"));
//		Thread.sleep(6000);
		explicitwait("selectBankDropdown");
		clickButton(dictPageObjects.get("selectBankDropdown"));
		clickButton(dictPageObjects.get("iDFCcreditCard"));
		explicitwait("monthTenure");
		String cardText = driver.findElementByXPath(dictPageObjects.get("monthTenure")).getText();
		a.assertTrue(cardText.contains("months"));
//		InitialiseSDKPageObjects.isElementPresent("monthTenure");
	} catch (Exception e) {
		explicitwait("oKBtnTimeoutError");
		clickButton(dictPageObjects.get("oKBtnTimeoutError"));
		System.out.println("Transaction timed out");
	}
		
	}

}
