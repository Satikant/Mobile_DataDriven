package testRunsAndroid;

import java.util.Dictionary;


import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFeatures.ExcelUtils;
import genericFeatures.FileUtilities;
import genericFeatures.GlobalVariables;
import genericFeatures.MobileCapabilities;
import pageObjectsAndroid.HomeWalletObject;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class HomeWalletScreenTest extends HomeWalletObject {

	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "WalletHomeParameters";

	@Test(priority = 1, enabled = true)
	public void validatethatwalletlistisdisplayed() throws Throwable {
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports.createTest(
				"validatethatwalletlistisdisplayed" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homewalletinitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = true)
	public void validate_that_Pay_button_is_Visible_After_WalletSelection() throws Throwable {
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports.createTest("validate_that_Pay_button_is_Visible_After_WalletSelection" + "_" + userRoleType + "_"
				+ deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homewalletinitialization();
		Thread.sleep(1000);
		goToInitiateWalletScreen();
		Thread.sleep(1000);
		validate_that_mpesa_wallet_is_selected();
		Thread.sleep(1000);
		verify_Pay_INR_Button();
		Thread.sleep(10000);
		InitialiseSDKPageObjects.navigateBack();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = true)
	public void validate_that_only_one_Selected() throws Throwable {
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports.createTest(
				"validate_that_only_one_Selected" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homewalletinitialization();// QA-ADG
		Thread.sleep(1000);
		goToInitiateWalletScreen();
		Thread.sleep(10000);
		validate_that_only_one_wallet_is_selected();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 4, enabled = true)
	public void validate_wallet_success_flow() throws Throwable {
		MobileCapabilities.main();
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports
				.createTest("back_navigation_Home_Screen" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homewalletinitialization();
		Thread.sleep(1000);
		// *clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		Thread.sleep(1000);
		// *clicking on mpesa wallet*//
		validate_that_mpesa_wallet_is_selected();
		Thread.sleep(1000);
		// *clicking on submit button*//
		msisdnSubmit();
		Thread.sleep(1000);
		// *click on submit button for payment confirmation*//
		click_on_confirm_button();
		Thread.sleep(1000);
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		click_On_Ok_Button(dictPageObjects.get("OKButton"));
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("recurringPayment"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 5, enabled = true)
	public void back_navigation_Home_Screen() throws Throwable {
		MobileCapabilities.main();// QA-ADG
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports
				.createTest("back_navigation_Home_Screen" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();

		InitialiseSDKPageObjects.homewalletinitialization();// QA-ADG
		Thread.sleep(1000);
		// *clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		Thread.sleep(1000);
		// *clicking on mpesa wallet*//
		validate_that_mpesa_wallet_is_selected();
		Thread.sleep(1000);
		// *clicking on submit button*//
		Thread.sleep(1000);
		validate_NavigateBack_HomeScreen();
		select_Recurring_Payment_Checkbox();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 6, enabled = true)
	public void captureNewOrderId() throws Throwable {
		MobileCapabilities.main();// QA-ADG
		Dictionary<String, String> dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		String userRoleType = dataList.get("UserRole");
		String languageType = dataList.get("Language");
		String deviceType = dataList.get("DeviceType");
		System.out.println(userRoleType);
		System.out.println(languageType);
		htmlreporter = new ExtentHtmlReporter(
				FileUtilities.Android_SuitePath + "_" + userRoleType + "_" + languageType + ".html");
		reports.attachReporter(htmlreporter);
		htmlreporter.setAppendExisting(true);
		test = reports
				.createTest("back_navigation_Home_Screen" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		homewalletinitialization();
		Thread.sleep(1000);
		// *clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		captureWalletOrderId();
		MobileCapabilities.quitDriver();
	}
	/*
	 * //No functionality
	 * 
	 * @Test(priority=3,enabled=true) public void
	 * validate_that_only_Push_Notification_Based_Wallets_are_shown_if_Recurring_Payment_is_selected
	 * () throws Throwable { MobileCapabilities.main(); Dictionary<String, String>
	 * dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
	 * userRoleType = dataList.get("UserRole"); String languageType =
	 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
	 * System.out.println(userRoleType); System.out.println(languageType);
	 * htmlreporter = new
	 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
	 * languageType+".html"); reports.attachReporter(htmlreporter);
	 * htmlreporter.setAppendExisting(true); test = reports.createTest(
	 * "validate_that_only_Push_Notification_Based_Wallets_are_shown_if_Recurring_Payment_is_selected"
	 * +"_"+userRoleType+"_"+deviceType+""+languageType);
	 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
	 * readPageObjectProperties();
	 * InitialiseSDKPageObjects.homewalletinitialization();//QA-ADG //
	 * driver.hideKeyboard(); validate_NavigateBack_HomeScreen(); //initialiseSDK();
	 * select_Recurring_Payment_Checkbox(); click_on_Paynow();
	 * goToInitiateWalletScreen();
	 * validateOnly_Push_Notification_based_wallets_are_displayed();
	 * test.log(Status.PASS,
	 * "Validate that only push notification based wallets are shown if recurring payment is selected"
	 * ); MobileCapabilities.quitDriver(); }
	 */
}
