package pageObjectsAndroid;

import java.io.IOException;
import java.util.Dictionary;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreenPageObjects extends GlobalVariables {

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
	
	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}
	
	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "HomeScreenData";
		}
		else {  
			pageObjectsSheetName = "HomeScreenData";
		}
		System.out.println("Page Object Sheet Name = "+pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static Logger log = Logger.getLogger(HomeScreenPageObjects.class.getName());
	
	
	public static void verifyElements() throws IOException, InterruptedException {
//		InitialiseSDKPageObjects.waitTillElementPresent("orderIdHome");
		
		log.info("Verify Order Id Home");
		String orderId;
		if (dataList.get("DeviceType").equals("Android")) {
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
			System.out.println("ORDERID====>" + orderId);
		}
		else { 
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
		}		
		a.assertTrue(orderId.contains(dict.get("orderId")));

		log.info("Verify Amount");
		String amount = driver.findElementByXPath(dictPageObjects.get("amountHome")).getText();
		a.assertTrue(amount.contains(dict.get("amount")));
		
		InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");

		log.info("Verify card button");
		String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
		a.assertTrue(cardButton.contains(dict.get("cardButton")));

		log.info("Verify bank transfer button");
		String netBankingButton = driver.findElementByXPath(dictPageObjects.get("netBankingButton")).getText();
		a.assertTrue(netBankingButton.contains(dict.get("netBankingButton")));
		
		log.info("Verify wallet button");
		String walletButton = driver.findElementByXPath(dictPageObjects.get("walletButton")).getText();
		a.assertTrue(walletButton.contains(dict.get("walletButton")));

	}
	
	public static void verifyCurrencyCode() throws IOException, InterruptedException {
		log.info("Verify Currency code");
		String currencyCode = driver.findElementByXPath(dictPageObjects.get("amountHome")).getText();
		a.assertTrue(currencyCode.contains(dict.get("currencyCode")));
	}
	
	public static void verifyElementsFreeTrial() throws IOException, InterruptedException {
		InitialiseSDKPageObjects.waitTillElementPresent("orderIdHome");
		log.info("Verify mobile number");
		String orderId;
		if (dataList.get("DeviceType").equals("Android")) {
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
		}else { 
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getAttribute("value");
		}
		a.assertTrue(orderId.contains(dict.get("orderId")));

		log.info("Verify Amount");
		String amount = driver.findElementByXPath(dictPageObjects.get("amountHome")).getText();
		a.assertTrue(amount.contains(dict.get("amount")));

		log.info("Verify card button");
		String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
		a.assertTrue(cardButton.contains(dict.get("cardButton")));
	}
	
	public static void verifyElementsRecurringPayment() throws IOException, InterruptedException {
		InitialiseSDKPageObjects.waitTillElementPresent("orderIdHome");
		log.info("Verify mobile number");
		String orderId;
		if (dataList.get("DeviceType").equals("Android")) {
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getText();
		}else { 
			orderId = driver.findElementByXPath(dictPageObjects.get("orderIdHome")).getAttribute("value");
		}
		a.assertTrue(orderId.contains(dict.get("orderId")));

		log.info("Verify Amount");
		String amount = driver.findElementByXPath(dictPageObjects.get("amountHome")).getText();
		a.assertTrue(amount.contains(dict.get("amount")));

		InitialiseSDKPageObjects.waitToExecuteNextLine("cardButton");

		log.info("Verify card button");
		String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
		a.assertTrue(cardButton.contains(dict.get("cardButton")));

		log.info("Verify wallet button");
		String walletButton = driver.findElementByXPath(dictPageObjects.get("walletButton")).getText();
		a.assertTrue(walletButton.contains(dict.get("walletButton")));
	}
}