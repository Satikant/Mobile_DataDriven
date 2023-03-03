package testRunsAndroid;

import java.util.Dictionary;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import pageObjectsAndroid.EMIfeaturePageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;


public class EMIfeatureTest extends EMIfeaturePageObjects{
	
	Assertion a = new Assertion();
	public static String SheetName = "EMIData";
	public static String Data = "EMIData";
	
	@Test(priority=1,enabled=true)
	public void verifyPresenseOfEMI() throws Throwable {
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		captureTitleOfEMIcard();
		test.log(Status.PASS, "Validate that EMI on credit card menu is clicked and user redirected to EMI saved card screen");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 2, enabled=true)
	public void verifyDisbaledSavedCreditCard() throws Throwable {
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		verifydisbaledcard();
		test.log(Status.PASS, "Disbaled SavedCreditCard is verified in the EMI on cards screen");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 3, enabled=true)
	public void verifyAddanotherCard_EMIPayment() throws Throwable {
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		commonLibrary.explicitWait("addCardButton");
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		addAnotherCard_payment();
		test.log(Status.PASS, "EMI payment after adding another card");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 4, enabled = true)
	public void savedcard_payment() throws Throwable {
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
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		payEMI_savedcard();
		test.log(Status.PASS, "EMI transaction from saved card");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 5, enabled = true)
	public void viewAllEMIPlans_Savedcard() throws Throwable {
		System.out.println("Verify all EMI Plans in Savedcard screen");
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
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		viewAllEMIPlans();
		test.log(Status.PASS, "Verified all EMI Plans in Savedcard screen");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 6, enabled =true)
	public void viewAllEMIPlans_Addcard() throws Throwable {
		System.out.println("Verify all EMI Plans in add card screen");
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
		test = reports.createTest("verifyHomeScreenElements"+"_"+userRoleType+"_"+deviceType+""+languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homescreeninitialization();
		Thread.sleep(5000);
		goToEMICardsScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		viewAllEMIPlans();
		test.log(Status.PASS, "Verified all EMI Plans in add card screen");
		MobileCapabilities.quitDriver();
	}
	

}
