package testRunsAndroid;

import java.io.File;
import java.util.Dictionary;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import pageObjectsAndroid.BankTransferPageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;
import pageObjectsiOS.NetbankingPageObj;

public class BankTransferScreenTest extends BankTransferPageObjects {

	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "BankTransferParameters"; //here we data params excel is read

	@Test(priority=1,enabled=true)
	public void verifyBankPaymentScreen() throws Exception {
		System.out.println("Verify bank payment screen");
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyBankPaymentScreen"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.bankinitialization();//QA-ADG
		goToBankPaymentScreen();
		test.log(Status.PASS, "Verify Bank Payment Screen");
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=2,enabled=true)
	public void verifyBankPaymentBackButton() throws Exception {
		System.out.println("Verify bank payment back button");
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyBankPaymentBackButton"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.bankinitialization();//QA-ADG
		goToBankPaymentScreen();
		Thread.sleep(10000);
		InitialiseSDK.navigateBack();
		Thread.sleep(7000);
		test.log(Status.PASS, "Verify Back Button in Bank Payment");
		MobileCapabilities.quitDriver();
	}
	
	//these are test case classes	
	@Test(priority=3,enabled=true)
	public void verifySuccessfulPaymentBankPayment() throws Exception {
		System.out.println("Verify successful bank payment screen");
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifySuccessfulPaymentBankPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.bankinitialization();//QA-ADG
		Thread.sleep(1000);
		goToBankPaymentScreen();
		Thread.sleep(1000);
		successfulBankPayment();
		Thread.sleep(1000);
		verifySuccessPopUp(dictPageObjects.get("BankPaymenetSuccess"));
		Thread.sleep(1000);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		test.log(Status.PASS, "Verify Successful Bank Payment");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 4, enabled = true)
	public static void orderidrefreshNetbank() throws Throwable{
		System.out.println("Verify successful bank payment screen");
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifySuccessfulPaymentBankPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.bankinitialization();//QA-ADG
		Reporter.log("Verify the orderid should get refresh on redirecting back");
		MobileCapabilities.quitDriver();
		
	}
	
	/*
	 * @Test(priority=2,enabled=true) public void
	 * verifyTransactionFailsBankPayment_Due_NoInternet() throws Exception {
	 * System.out.println("Verify No Internet fetch bank List payment screen"); //
	 * MobileCapabilities.main(); Dictionary<String, String> dataList =
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
	 * userRoleType = dataList.get("UserRole"); String languageType =
	 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
	 * System.out.println(userRoleType); System.out.println(languageType);
	 * htmlreporter = new
	 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
	 * languageType+".html"); reports.attachReporter(htmlreporter);
	 * htmlreporter.setAppendExisting(true); test =
	 * reports.createTest("verifySuccessfulPaymentBankPayment"+"_"+userRoleType+"_"+
	 * deviceType+""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties(); driver.hideKeyboard(); // initialiseSDK();
	 * InitialiseSDKPageObjects.setAirPlaneModeOn(enable); goToBankPaymentScreen();
	 * successfulBankPayment();
	 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
	 * click_On_Ok_Button(dictPageObjects.get("OKButton")); test.log(Status.PASS,
	 * "Verify Successful Bank Payment"); // MobileCapabilities.quitDriver(); }
	 */
	

	/*
	 * @Test(priority=3,enabled=true) public void verifyNoBankList() throws
	 * Exception { System.out.println("Verify successful bank payment screen"); //
	 * MobileCapabilities.main(); Dictionary<String, String> dataList =
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
	 * userRoleType = dataList.get("UserRole"); String languageType =
	 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
	 * System.out.println(userRoleType); System.out.println(languageType);
	 * htmlreporter = new
	 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
	 * languageType+".html"); reports.attachReporter(htmlreporter);
	 * htmlreporter.setAppendExisting(true); test =
	 * reports.createTest("verifySuccessfulPaymentBankPayment"+"_"+userRoleType+"_"+
	 * deviceType+""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties(); driver.hideKeyboard(); // initialiseSDK();
	 * 
	 * invalidCheckSum(); InitialiseSDKPageObjects.navigateBack();
	 * test.log(Status.PASS, "Verify Banklist empty"); //
	 * MobileCapabilities.quitDriver(); }
	 */

	/*
	 * @AfterMethod(alwaysRun = true) public void endtest(ITestResult result) throws
	 * Exception { Dictionary<String, String> dataList =
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName); String
	 * deviceType = dataList.get("DeviceType"); if
	 * (deviceType.equalsIgnoreCase("Android")) { if (driver != null) { if
	 * (ITestResult.FAILURE == result.getStatus()) { TakesScreenshot ts =
	 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(source, new File("./FailedScreenshots/" + result.getName()
	 * + ".png")); test.addScreenCaptureFromPath(System.getProperty("user.dir")+
	 * "//FailedScreenshots//" + result.getName() + ".png"); test.log(Status.FAIL,
	 * "screenshot"); System.out.println("Screenshot taken"); } //driver.quit();
	 * reports.flush(); } } else if(deviceType.equalsIgnoreCase("IOS")) { if (driver
	 * != null) { if (ITestResult.FAILURE == result.getStatus()) { TakesScreenshot
	 * ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(source, new
	 * File("./Screenshots/" + result.getName() + ".png"));
	 * test.addScreenCaptureFromPath(System.getProperty("user.dir")+
	 * "//Screenshots//" + result.getName() + ".png");
	 * //logger.addScreenCapture("./FailedScreenshots/" + result.getName() +
	 * ".png"); test.log(Status.FAIL, "screenshot");
	 * System.out.println("Screenshot taken"); } //driver.quit(); reports.flush(); }
	 * } }
	 */
}