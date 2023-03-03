package testRunsAndroid;

import java.io.File;
import java.util.Dictionary;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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
import pageObjectsAndroid.InitiateAndConfirmWalletPageObjects;

public class InitiateAndConfirmWalletTest extends InitiateAndConfirmWalletPageObjects {

	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "InititateWalletParameters";

	@Test(priority=1,enabled=true)
	public void verifyMobileNumber() throws Exception {
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
		test = reports.createTest("verifyMobileNumber"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		goToInitiateWalletScreen();
		Thread.sleep(5000);
		InitialiseSDKPageObjects.navigateBack();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=2,enabled=true)
	public void verifyInvalidMobileNumberError() throws Exception {
		System.out.println("Verify invalid mobile number error");
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
		test = reports.createTest("verifyInvalidMobileNumberError"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		goTillEnterMSISDNScreen();
		invalidMobileNumber();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=3,enabled=true)
	public void verifyInitiateWalletBackButton() throws Exception {
		System.out.println("Verify initiate wallet back button");
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
		test = reports.createTest("verifyInitiateWalletBackButton"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		goTillEnterMSISDNScreen();
		clickOnBackButton();
		MobileCapabilities.quitDriver();
	}

	
	@Test(priority=4,enabled=true)
	public void verifyConfirmWalletScreenElements_ReferenceBased() throws Exception {
		System.out.println("Verify confirm wallet screen elements");
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
		test = reports.createTest("verifyConfirmWalletScreenElements_ReferenceBased"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		log.info("Click wallet button");
		InitialiseSDKPageObjects.explicitwait("walletButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		clickOnPay_Ecocash();
		verifyConfirmWalletScreen_ReferenceBased();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=5,enabled=true)
	public void verifyReferenceId() throws Exception {
		System.out.println("Verify reference ID");
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
		test = reports.createTest("verifyReferenceId"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		InitialiseSDKPageObjects.explicitwait("walletButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		clickOnPay_Ecocash();
		verifyDisplayOfReferenceId();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=6,enabled=true)
	public void verifySuccessfulReferenceBasedWalletPayment() throws Exception {
		System.out.println("Verify successful reference based wallet payment");
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
		test = reports.createTest("verifySuccessfulReferenceBasedWalletPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		InitialiseSDKPageObjects.explicitwait("walletButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		clickOnPay_Ecocash();
		confirmPayment();
		test.log(Status.PASS, "Verify successful reference based wallet payment");
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority=7,enabled=true)
	public void verifyConfirmWalletScreenElements_PushBased() throws Exception {
		System.out.println("Verify successful push based wallet payment");
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
		test = reports.createTest("verifyConfirmWalletScreenElements_PushBased"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		InitialiseSDKPageObjects.explicitwait("walletButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		System.out.println("Select eco cash");
		clickOnPay_Ecocash();
		confirmPayment();
		System.out.println("Complete submit");
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority=8,enabled=true)
	public void verifySuccessfulPushBasedWalletPayment() throws Exception {
		System.out.println("Verify Confirm payment from Eco cash");
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
		test = reports.createTest("verifySuccessfulPushBasedWalletPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homeInitaiteAndconfirmwallet();
		InitialiseSDKPageObjects.explicitwait("walletButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
		clickOnPay_Ecocash();
		confirmPayment();
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	/*
	 * //Not in scope
	 * 
	 * @Test(priority=3,enabled=true) public void verifyDefaultCountryCode() throws
	 * Exception { System.out.println("Verify default country code");
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
	 * reports.createTest("verifyDefaultCountryCode"+"_"+userRoleType+"_"+deviceType
	 * +""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties(); //
	 * InitialiseSDKPageObjects.waitTillElementPresent("submitButton");
	 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("submitButton")); //
	 * verifyCountryCode(); test.log(Status.PASS,
	 * "Verify Default Country Code in Initiate Wallet Screen");
	 * MobileCapabilities.quitDriver(); }
	 */
	
	/*
	 * //Not in scope //@Test(priority=4,enabled=true) public void
	 * selectAndVerifyCountryCode() throws Exception {
	 * System.out.println("Verify default country code"); //
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
	 * reports.createTest("selectAndVerifyCountryCode"+"_"+userRoleType+"_"+
	 * deviceType+""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties(); // selectCountryCode(); if
	 * (dataList.get("DeviceType").equals("Android")) { clickOnBackButton(); }
	 * test.log(Status.PASS,
	 * "Select and Verify Country Code in Initiate Wallet Screen"); //
	 * MobileCapabilities.quitDriver(); }
	 */
	
	/*
	 * @Test(priority=7,enabled=true) public void verifyReferenceIdCopyButton()
	 * throws Exception { System.out.println("Verify reference ID Copy Button"); //
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
	 * reports.createTest("verifyReferenceId"+"_"+userRoleType+"_"+deviceType+""+
	 * languageType); ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties(); verifyReferenceIdCopy();
	 * click_On_Ok_Button(dictPageObjects.get("OKButton")); test.log(Status.PASS,
	 * "Verify reference ID Copy Button"); // MobileCapabilities.quitDriver(); }
	 */
	
	/*
	 * //No functionality
	 * 
	 * @Test(priority=11,enabled=true) public void
	 * verifySuccessfulRecurringPayment_Wallet() throws Exception {
	 * System.out.println("Verify successful bank payment screen");
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
	 * reports.createTest("testApp_EnterFields_InitialiseSDK"+"_"+userRoleType+"_"+
	 * deviceType+""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties();
	 * 
	 * InitialiseSDKPageObjects.waitTillElementPresent("payNowButton");
	 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
	 * InitialiseSDKPageObjects.waitTillElementPresent("walletButton");
	 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("walletButton"));
	 * clickOnPay_Ecocash(); confirmPayment();
	 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
	 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton"));
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