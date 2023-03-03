package testRunsAndroid;

import java.io.File;
import java.util.Dictionary;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.SwipeElementDirection;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class InitialiseSDK extends InitialiseSDKPageObjects {

	public static String SheetName = "Login";
	public static String Data = "InitParameters";
	
	//Descoped after merchant screen addition
	@Test(priority=0,enabled=true)
	public void testApp_EnterFields_InitialiseSDK() throws Exception {
		System.out.println("Enter parameters and initialise SDK");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("testApp_EnterFields_InitialiseSDK"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.sdkinitialization();
		HomescreenVerification();
		navigateBack();
		MobileCapabilities.quitDriver();
	}
	//Descoped after merchant screen addition
	@Test(priority=2,enabled=true)
	public void testApp_EnterFields_InitialiseSDK_FreeTrial() throws Exception {
		System.out.println("Enter parameters and initialise SDK");
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+languageType+".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(false);
		test = reports.createTest("testApp_EnterFields_InitialiseSDK_FreeTrial"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		initialiseFreeTrial();
		HomescreenVerification();
		navigateBack();
		Thread.sleep(1000);
		InitialiseSDKPageObjects.explicitwait("freeTrial");
		MobileCapabilities.quitDriver();
	}
	
	//Descoped after merchant screen addition
	@Test(priority=1,enabled=true)
	public void testApp_EnterFields_InitialiseSDK_RecurringPayment() throws Exception {
		System.out.println("Enter parameters and initialise SDK");
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
		test = reports.createTest("testApp_EnterFields_InitialiseSDK_RecurringPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		initialiseRecurring();
		HomescreenVerification();
		navigateBack();
		Thread.sleep(1000);
		InitialiseSDKPageObjects.explicitwait("freeTrial");
		MobileCapabilities.quitDriver();
	}
	
	/*
	 * @AfterMethod(alwaysRun = true) public void endtest(ITestResult result) throws
	 * Exception { Dictionary<String, String> dataList =
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName); String
	 * deviceType = dataList.get("DeviceType"); if
	 * (deviceType.equalsIgnoreCase("Android")) { if (driver != null) { if
	 * (ITestResult.FAILURE == result.getStatus()) { TakesScreenshot ts =
	 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() +
	 * ".png")); test.addScreenCaptureFromPath(System.getProperty("user.dir")+
	 * "//Screenshots//" + result.getName() + ".png"); test.log(Status.FAIL,
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