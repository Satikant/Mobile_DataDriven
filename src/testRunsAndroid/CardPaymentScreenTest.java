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
import pageObjectsAndroid.CardPaymentPageObjects;
import pageObjectsAndroid.InitialiseSDKPageObjects;

public class CardPaymentScreenTest extends CardPaymentPageObjects{
	public Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "CardPaymentParameters";
	public InitialiseSDKPageObjects initialiseSDKPageObjects = new InitialiseSDKPageObjects();
	private static ConfigFileReader con = new ConfigFileReader();

	@Test(priority = 1, enabled = true)
	public void verifyCardPaymentScreen() throws Throwable {
		System.out.println("Verify card payment screen");
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
				.createTest("verifyCardPaymentScreen" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		test.log(Status.PASS, "Initialise SDK");
		goToCardPaymentScreen();
		test.log(Status.PASS, "Verify Card Payment Screen");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = true)
	public void verifyEmptyCardNumberError() throws Throwable {
		System.out.println("Verify empty card number error");
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
				.createTest("verifyEmptyCardNumberError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		blankCardNumber();
		test.log(Status.PASS, "Verify Blank Card Number Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = true)
	public void verifyInvalidCardNumberError() throws Throwable {
		System.out.println("Verify invalid card number error");
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
				.createTest("verifyInvalidCardNumberError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();// QA-ADG
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		invalidCardNumber();
		test.log(Status.PASS, "Verify Invalid Card Number Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 4, enabled = true)
	public void verifyEmptyExpiryDateError() throws Throwable {
		System.out.println("Verify empty expiry date error");
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
				.createTest("verifyEmptyExpiryDateError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		blankExpiry();
		test.log(Status.PASS, "Verify Blank Expiry Date Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 5, enabled = true)
	public void verifyInvalidExpiryDateError() throws Throwable {
		System.out.println("Verify invalid expiry date error");
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
				.createTest("verifyInvalidExpiryDateError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();// QA-ADG
		goToInitiatecardScreen();// QA-ADG
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		invalidExpiry();
		test.log(Status.PASS, "Verify Invalid Expiry Date Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 6, enabled = true)
	public void verifyEmptyCvvError() throws Throwable {
		System.out.println("Verify empty card CVV error");
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
		test = reports.createTest("verifyEmptyCvvError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();// QA-ADG
		goToInitiatecardScreen();// QA-ADG
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		blankCvv();
		test.log(Status.PASS, "Verify Blank CVV Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 7, enabled = true)
	public void verifyInvalidCvvError() throws Throwable {
		System.out.println("Verify empty card number error");
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
		test = reports.createTest("verifyInvalidCvvError" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();// QA-ADG
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		invalidCvv();
		test.log(Status.PASS, "Verify Invalid CVV Error");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 8, enabled = true)
	public void verifySuccessfulCardPaymentJcb() throws Throwable {
		System.out.println("Verify successful card payment - JCB");
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
				"verifySuccessfulCardPaymentJcb" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();// QA-ADG
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		successfulCardPaymentJcb();
		test.log(Status.PASS, "Verify Successful Card Payment - JCB");
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(500);
		click_On_Ok_Button(dictPageObjects.get("OKButton"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 9, enabled = true)
	public void verifySavedCard() throws Throwable {
		System.out.println("Verify save card feature");
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
		test = reports.createTest("verifySavedCard" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();

		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		saveCard();
		Thread.sleep(5000);
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(5000);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		test.log(Status.PASS, "Save Card");
		Thread.sleep(1000);
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("buyNowButton"));
		goToSavedCard();
		checkIfCardIsSaved();
		test.log(Status.PASS, "Verify Saved Card");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 10, enabled = true)
	public void verifySuccessfulCardPaymentSavedCard() throws Throwable {
		System.out.println("Verify doing a payment from save card feature");
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
				"verifySuccessfulCardPaymentSavedCard" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToInitiatecardScreen();
		successfulCardPaymentSavedCard();
		test.log(Status.PASS, "Verify Successful Card Payment - Saved Card");
		Thread.sleep(5000);
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(3000);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 11, enabled = true)
	public void cancelDeleteOfSavedCard() throws Throwable {
		System.out.println("Cancel deletion of a saved card");
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
				.createTest("cancelDeleteOfSavedCard" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		Thread.sleep(4000);
		goToSavedCard();
		cancelCardDeletion();
		test.log(Status.PASS, "Cancel deletion of a saved card");
		MobileCapabilities.quitDriver();
	}
	

	@Test(priority = 12, enabled = true)
	public void verifyCardWithInvalidCardPaymentScreen() throws Exception {
		System.out.println("Verify card payment screen");
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
				"verifyCardWithInvalidCardPaymentScreen" + "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		failureCardPaymentVisa();
		test.log(Status.PASS, "Verify Card Payment Failed Screen");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 13, enabled = true)
	public void verifyCard_paymentfailed_click_otherpayment_wallet_pay_success() throws Exception {
		System.out.println("Verify card payment screen");
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
		test = reports.createTest("verifyCard_paymentfailed_click_otherpayment_wallet_pay_success" + "_" + userRoleType
				+ "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		failCardPaymentVisaPassWalletPayment();
		test.log(Status.PASS, "Verify Wallet Payment Success Screen");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 14, enabled = true)
	public void verifyCardWithInvalidCard_Click_On_Retry_to_Make_successfull_payemnt() throws Exception {
		System.out.println("Verify card payment screen");
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
		test = reports.createTest("verifyCardWithInvalidCard_Click_On_Retry_withvalidcard_to_Make_successfull_payemnt"
				+ "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		successfulCardPaymentJcb();
		Thread.sleep(20000);
		RetryCardPaymentusingVisa();
		Thread.sleep(3000);
		verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
		Thread.sleep(3000);
		click_On_Ok_Button(dictPageObjects.get("successDoneButton"));
		test.log(Status.PASS, "Verify Card Payment Failed transaction, click on retry");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 15, enabled = true)
	public void verifyCardPaymentFailureOrderIdRefreshOnClickOfRetry() throws Exception {
		System.out.println("Verify card payment screen");
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
		test = reports.createTest("verify_PaymentFaile_Refresh_OrderId_on_click_of_retry" + "_" + userRoleType + "_"
				+ deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));
		checkForOrderIdRefresh();
		test.log(Status.PASS, "Verify Card Payment Failed Screen and Order Id Refreshs");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 16, enabled = true)
	public void verifyCardPaymentFailureOrderIdRefreshOnClickOfChangePaymentModeOnWalletPaymentSuccess()
			throws Exception {
		System.out.println("Verify card payment screen");
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
		test = reports.createTest("verify_PaymentFaile_Refresh_OrderId_on_click_of_changem_Payment_Mode_wallet_success"
				+ "_" + userRoleType + "_" + deviceType + "" + languageType);
		ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
		readPageObjectProperties();
		InitialiseSDKPageObjects.homecardinitialization();
		goToCardPaymentScreen();
		checkForOrderIdRefreshWalletSuccess();
		test.log(Status.PASS, "Verify Card Payment Failed Screen order id refresh and make success wallet payment");
		MobileCapabilities.quitDriver();
	}
}
/*
 * // No need to execute
 * 
 * @Test(priority = 12, enabled = true) public void deleteSavedCard() throws
 * Throwable { System.out.println("Delete a saved card"); //
 * MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new ExtentHtmlReporter( FileUtilities.Android_SuitePath + "_"
 * + userRoleType + "_" + languageType + ".html");
 * reports.attachReporter(htmlreporter); htmlreporter.setAppendExisting(true);
 * test = reports.createTest("deleteSavedCard" + "_" + userRoleType + "_" +
 * deviceType + "" + languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
 * readPageObjectProperties();
 * InitialiseSDKPageObjects.homecardinitialization();// QA-ADG
 * goToInitiatecardScreen();// QA-ADG // driver.hideKeyboard(); //
 * initialiseSDK(); // goToCardPaymentScreen(); deleteCard();
 * Thread.sleep(1000); InitialiseSDKPageObjects.navigateBack();
 * Thread.sleep(1000); InitialiseSDKPageObjects.navigateBack();
 * test.log(Status.PASS, "Delete a saved card"); test.log(Status.PASS,
 * "Verify deletion"); // MobileCapabilities.quitDriver(); }
 */

/*
 * // No functionality
 * 
 * @Test(priority = 5, enabled = true) public void
 * verifyEmptyCardHolderNameError() throws Throwable {
 * System.out.println("Verify empty card holder name error");
 * MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new ExtentHtmlReporter( FileUtilities.Android_SuitePath + "_"
 * + userRoleType + "_" + languageType + ".html");
 * reports.attachReporter(htmlreporter); htmlreporter.setAppendExisting(true);
 * test = reports.createTest( "verifyEmptyCardHolderNameError" + "_" +
 * userRoleType + "_" + deviceType + "" + languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
 * readPageObjectProperties();
 * InitialiseSDKPageObjects.homecardinitialization();// QA-ADG
 * goToInitiatecardScreen();// QA-ADG
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));//
 * QA-ADG // driver.hideKeyboard(); // initialiseSDK(); //
 * goToCardPaymentScreen(); blankCardHolder(); test.log(Status.PASS,
 * "Verify Blank Card Holder Name Error"); MobileCapabilities.quitDriver(); }
 */

/*
 * // No functionality
 * 
 * @Test(priority = 6, enabled = true) public void
 * verifyInvalidCardHolderNameError() throws Throwable {
 * System.out.println("Verify invalid card holder name error");
 * MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new ExtentHtmlReporter( FileUtilities.Android_SuitePath + "_"
 * + userRoleType + "_" + languageType + ".html");
 * reports.attachReporter(htmlreporter); htmlreporter.setAppendExisting(true);
 * test = reports.createTest( "verifyInvalidCardHolderNameError" + "_" +
 * userRoleType + "_" + deviceType + "" + languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Data);
 * readPageObjectProperties();
 * InitialiseSDKPageObjects.homecardinitialization();// QA-ADG
 * goToInitiatecardScreen();// QA-ADG
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("addCardButton"));//
 * QA-ADG // driver.hideKeyboard(); // initialiseSDK(); //
 * goToCardPaymentScreen(); invalidCardHolder(); test.log(Status.PASS,
 * "Verify Invalid Card Holder Name Error"); MobileCapabilities.quitDriver(); }
 */

/*
 * @Test(priority=13,enabled=true) public void
 * verifySuccessfulCardPaymentDinersClub() throws Exception {
 * System.out.println("Verify successful card payment - Diner's Club");
 * //MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new
 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
 * languageType+".html"); reports.attachReporter(htmlreporter);
 * htmlreporter.setAppendExisting(true); test =
 * reports.createTest("verifySuccessfulCardPaymentDinersClub"+"_"+userRoleType+
 * "_"+deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * //readPageObjectProperties(); driver.hideKeyboard(); //initialiseSDK();
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen(); successfulCardPaymentDinersClub();
 * test.log(Status.PASS, "Verify Successful Card Payment - Diner's Club");
 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton"));
 * //MobileCapabilities.quitDriver(); }
 */

/*
 * @Test(priority=14,enabled=true) public void
 * verifySuccessfulCardPaymentDiscover() throws Exception {
 * System.out.println("Verify successful card payment - Discover");
 * //MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new
 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
 * languageType+".html"); reports.attachReporter(htmlreporter);
 * htmlreporter.setAppendExisting(true); test =
 * reports.createTest("verifySuccessfulCardPaymentDiscover"+"_"+userRoleType+"_"
 * +deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * //readPageObjectProperties(); driver.hideKeyboard(); //initialiseSDK();
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen(); successfulCardPaymentDiscover();
 * test.log(Status.PASS, "Verify Successful Card Payment - Discover");
 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton")); //
 * MobileCapabilities.quitDriver(); }
 */
/*
 * @Test(priority=9,enabled=true) public void verifySuccessfulCardPaymentVisa()
 * throws Exception {
 * System.out.println("Verify successful card payment - VISA"); //
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
 * reports.createTest("verifySuccessfulCardPaymentVisa"+"_"+userRoleType+"_"+
 * deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * readPageObjectProperties(); driver.hideKeyboard(); // initialiseSDK(); //
 * goToCardPaymentScreen(); successfulCardPaymentVisa(); test.log(Status.PASS,
 * "Verify Successful Card Payment - VISA");
 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton"));
 * //MobileCapabilities.quitDriver(); }
 */ 

/*
 * @Test(priority=10,enabled=true) public void
 * verifySuccessfulCardPaymentMastercard() throws Exception {
 * System.out.println("Verify successful card payment - Mastercard");
 * //MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new
 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
 * languageType+".html"); reports.attachReporter(htmlreporter);
 * htmlreporter.setAppendExisting(true); test =
 * reports.createTest("verifySuccessfulCardPaymentMastercard"+"_"+userRoleType+
 * "_"+deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * //readPageObjectProperties(); driver.hideKeyboard(); //initialiseSDK();
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen(); successfulCardPaymentMastercard();
 * test.log(Status.PASS, "Verify Successful Card Payment - Mastercard");
 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton"));
 * //MobileCapabilities.quitDriver(); }
 */
/*
 * //No functionality
 * 
 * @Test(priority=22,enabled=true) public void
 * verifyCardPaymentRecurringPayment() throws Exception {
 * System.out.println("Verify card payment screen - Recurring Payment");
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
 * reports.createTest("verifyCardPaymentRecurringPayment"+"_"+userRoleType+"_"+
 * deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * readPageObjectProperties();
 * InitialiseSDKPageObjects.initialiseSDKRecurringPayment1(); //
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("recurringPayment"))
 * ; //
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen() ; successfulCardPaymentVisa(); //
 * InitialiseSDKPageObjects.waitToExecuteNextLine("OKButton"); //
 * InitialiseSDKPageObjects.waitTillElementPresent("OKButton");
 * InitialiseSDKPageObjects.explicitwait("OKButton");
 * click_On_Ok_Button(dictPageObjects.get("OKButton")); Thread.sleep(1000);
 * InitialiseSDKPageObjects.explicitwait("recurringPayment"); //
 * InitialiseSDKPageObjects.waitTillElementPresent("recurringPayment"); //
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("recurringPayment"))
 * ; MobileCapabilities.quitDriver(); }
 */
/*
 * @Test(priority=11,enabled=true) public void
 * verifySuccessfulCardPaymentAmex() throws Exception {
 * System.out.println("Verify successful card payment - AMEX");
 * //MobileCapabilities.main(); Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data); String
 * userRoleType = dataList.get("UserRole"); String languageType =
 * dataList.get("Language"); String deviceType = dataList.get("DeviceType");
 * System.out.println(userRoleType); System.out.println(languageType);
 * htmlreporter = new
 * ExtentHtmlReporter(FileUtilities.Android_SuitePath+"_"+userRoleType+"_"+
 * languageType+".html"); reports.attachReporter(htmlreporter);
 * htmlreporter.setAppendExisting(true); test =
 * reports.createTest("verifySuccessfulCardPaymentAmex"+"_"+userRoleType+"_"+
 * deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * //readPageObjectProperties(); driver.hideKeyboard(); //initialiseSDK();
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen(); successfulCardPaymentAmex(); test.log(Status.PASS,
 * "Verify Successful Card Payment - American Express");
 * verifySuccessPopUp(dictPageObjects.get("CardPaymenetSuccess"));
 * Thread.sleep(500); click_On_Ok_Button(dictPageObjects.get("OKButton"));
 * //MobileCapabilities.quitDriver(); }
 */
/*
 * //No functionality
 * 
 * @Test(priority=23,enabled=true) public void verifyCardPaymentFreeTrial()
 * throws Exception {
 * System.out.println("Verify card payment screen - Free Trial");
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
 * reports.createTest("verifyCardPaymentFreeTrial"+"_"+userRoleType+"_"+
 * deviceType+""+languageType);
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath,Data);
 * readPageObjectProperties();
 * InitialiseSDKPageObjects.initialiseSDKFreeTrial1(); // driver.hideKeyboard();
 * // InitialiseSDKPageObjects.clickButton(dictPageObjects.get("freeTrial")); //
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("payNowButton"));
 * goToCardPaymentScreen(); successfulCardPaymentVisa(); //
 * InitialiseSDKPageObjects.waitToExecuteNextLine("OKButton"); //
 * InitialiseSDKPageObjects.waitTillElementPresent("OKButton");
 * InitialiseSDKPageObjects.explicitwait("OKButton"); Thread.sleep(1000);
 * click_On_Ok_Button(dictPageObjects.get("OKButton")); Thread.sleep(1000); //
 * InitialiseSDKPageObjects.waitTillElementPresent("freeTrial"); //
 * InitialiseSDKPageObjects.clickButton(dictPageObjects.get("freeTrial"));
 * MobileCapabilities.quitDriver(); }
 */


//	@AfterMethod(alwaysRun = true)
/*
 * // public void endtest(ITestResult result) throws Exception { //
 * Dictionary<String, String> dataList =
 * ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName); // String
 * deviceType = dataList.get("DeviceType"); // if
 * (deviceType.equalsIgnoreCase("Android")) { // if (driver != null) { // if
 * (ITestResult.FAILURE == result.getStatus()) { // TakesScreenshot ts =
 * (TakesScreenshot) driver; // File source =
 * ts.getScreenshotAs(OutputType.FILE); // FileUtils.copyFile(source, new
 * File("./Screenshots/" + result.getName() + ".png")); //
 * test.addScreenCaptureFromPath(System.getProperty("user.dir")+
 * "//Screenshots//" + result.getName() + ".png"); // test.log(Status.FAIL,
 * "screenshot"); // System.out.println("Screenshot taken"); // } ////
 * AndroidDriver.quit(); // reports.flush(); // } // } else
 * if(deviceType.equalsIgnoreCase("IOS")) { // if (driver != null) { // if
 * (ITestResult.FAILURE == result.getStatus()) { // TakesScreenshot ts =
 * (TakesScreenshot) driver; // File source =
 * ts.getScreenshotAs(OutputType.FILE); // FileUtils.copyFile(source, new
 * File("./Screenshots/" + result.getName() + ".png")); //
 * test.addScreenCaptureFromPath(System.getProperty("user.dir")+
 * "//Screenshots//" + result.getName() + ".png"); //
 * //logger.addScreenCapture("./FailedScreenshots/" + result.getName() +
 * ".png"); // test.log(Status.FAIL, "screenshot"); //
 * System.out.println("Screenshot taken"); // } //// IOSDriver.quit(); //
 * reports.flush(); // } // } // } }
 */