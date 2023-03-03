package testRunsAndroid;

import java.io.File;
import java.util.Dictionary;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import pageObjectsAndroid.HomeScreenPageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class HomeScreenTest extends HomeScreenPageObjects {

	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "HomeScreenData";

	@Test(priority=1,enabled=true)
	public void verifyHomeScreenElements() throws Exception {
		System.out.println("Verify home screen elements");
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
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		test.log(Status.PASS, "Initialise SDK");
		Thread.sleep(10000);
		InitialiseSDKPageObjects.navigateBack();
		test.log(Status.PASS, "Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority=2,enabled=true)
	public void verifyHomeScreenElements_FreeTrial() throws Exception {
		System.out.println("Verify home screen elements for free trial");
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
		test = reports.createTest("verifyHomeScreenElements_FreeTrial"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		test.log(Status.PASS, "Initialise SDK - Free Trial");
		InitialiseSDKPageObjects.navigateBack();
		Thread.sleep(1000);
		test.log(Status.PASS, "Verify Home Screen Elements - Free Trial");
		MobileCapabilities.quitDriver();
	}

	@Test(priority=3,enabled=true)
	public void verifyHomeScreenElements_RecurringPayment() throws Exception {
		System.out.println("Verify home screen elements for recurring payment");
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
		test = reports.createTest("verifyHomeScreenElements_RecurringPayment"+"_"+userRoleType+"_"+deviceType+""+languageType);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();//QA_ADG
		test.log(Status.PASS, "Initialise SDK - Recurring Payment");
		InitialiseSDKPageObjects.navigateBack();
		Thread.sleep(1000);
		test.log(Status.PASS, "Verify Home Screen Elements - Recurring Payment");
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
//                        //driver.quit();
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
//                        //driver.quit();
//                        reports.flush();
//                  }
//           }
//    }
}
