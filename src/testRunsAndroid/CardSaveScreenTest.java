package testRunsAndroid;


import java.util.Dictionary;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import genericFeatures.ConfigFileReader;
import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import pageObjectsAndroid.CardSavePageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class CardSaveScreenTest extends CardSavePageObjects{
	public Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "CardPaymentParameters";
	public InitialiseSDKPageObjects initialiseSDKPageObjects = new InitialiseSDKPageObjects();
	private static ConfigFileReader con = new ConfigFileReader();

	
	@Test(priority=1,enabled=true)
	public void verifyCardSaveScreenLaunch() throws Throwable {
		System.out.println("Verify card payment screen");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardCardPaymentScreen"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		test.log(Status.PASS, "Initialise SDK");
		verifyCardSaveScreen();
		test.log(Status.PASS, "Verify Card Payment Screen");
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=2,enabled=true)
	public void verifySuccessfulCardPaymentVisa() throws Throwable {
		System.out.println("Verify successful card payment - VISA");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardSuccessfulCardPaymentVisa"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		Thread.sleep(3000);
		successfulCardPaymentVisa();
		Thread.sleep(3000);
		test.log(Status.PASS, "Verify Successful Card Save - VISA");
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=3,enabled=true)
	public void verifySuccessfulCardPaymentMastercard() throws Throwable {
		System.out.println("Verify successful card payment - Mastercard");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardSuccessfulCardPaymentMastercard"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		Thread.sleep(3000);
		successfulCardPaymentMastercard();
		Thread.sleep(20000);
		test.log(Status.PASS, "Verify Successful Card Payment - Mastercard");
		RetryCardPaymentusingVisa();
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority=4,enabled=true)
	public void verifySuccessfulCardPaymentAmex() throws Throwable {
		System.out.println("Verify successful card payment - AMEX");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardSuccessfulCardPaymentAmex"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		Thread.sleep(20000);
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		Thread.sleep(3000);
		successfulCardPaymentAmex();
		Thread.sleep(20000);
		test.log(Status.PASS, "Verify Successful Card Payment - American Express");
		RetryCardPaymentusingVisa();
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	
	@Test(priority=5,enabled=true)
	public void verifySuccessfulCardPaymentDinersClub() throws Throwable {
		System.out.println("Verify successful card payment - Diner's Club");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardSuccessfulCardPaymentDinersClub"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		Thread.sleep(3000);
		successfulCardPaymentDinersClub();
		Thread.sleep(20000);
		test.log(Status.PASS, "Verify Successful Card Payment - Diner's Club");
		RetryCardPaymentusingVisa();
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=6,enabled=true)
	public void verifySuccessfulCardPaymentDiscover() throws Throwable {
		System.out.println("Verify successful card payment - Discover");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardSuccessfulCardPaymentDiscover"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		Thread.sleep(3000);
		successfulCardPaymentDiscover();
		Thread.sleep(20000);
		test.log(Status.PASS, "Verify Successful Card Payment - Discover");
		RetryCardPaymentusingVisa();
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority=7,enabled=true)
	public void verifyCardWithInvalidCard_Click_On_Retry_to_Make_successfull_payemnt() throws Throwable {
		System.out.println("Verify card payment screen");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("verifySaveCardWithInvalidCard_Click_On_Retry_to_Make_successfull_payemnt"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		successfulCardPaymentJcb();
		Thread.sleep(10000);
		RetryCardPaymentusingVisa();
		Thread.sleep(5000);
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(1000);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		test.log(Status.PASS, "Verify Card Payment Failed transaction, click on retry");
		MobileCapabilities.quitDriver();
	}
	
//	@AfterMethod(alwaysRun = true)
//    public void endtest(ITestResult result) throws Exception {                 
//           Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
//           String deviceType = dataList.get("DeviceType"); 
//           if (deviceType.equalsIgnoreCase("Android")) {
//                  if (driver != null) {
//                        if (ITestResult.FAILURE == result.getStatus()) {
//                               TakesScreenshot ts = (TakesScreenshot) driver;
//                               File source = ts.getScreenshotAs(OutputType.FILE);
//                               FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
//                               test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//Screenshots//" + result.getName() + ".png");
//                               test.log(Status.FAIL, "screenshot");
//                               System.out.println("Screenshot taken");
//                        }
////                        AndroidDriver.quit();
//                        reports.flush();
//                  }
//           } else if(deviceType.equalsIgnoreCase("IOS")) {
//                  if (driver != null) {
//                        if (ITestResult.FAILURE == result.getStatus()) {
//                               TakesScreenshot ts = (TakesScreenshot) driver;
//                               File source = ts.getScreenshotAs(OutputType.FILE);
//                               FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
//                               test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//Screenshots//" + result.getName() + ".png");
//                               //logger.addScreenCapture("./FailedScreenshots/" + result.getName() + ".png");
//                               test.log(Status.FAIL, "screenshot");
//                               System.out.println("Screenshot taken");
//                        }
////                        IOSDriver.quit();
//                        reports.flush();
//                  }
//           }
//    }
}