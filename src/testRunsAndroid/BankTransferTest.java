package testRunsAndroid;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import pageObjectsiOS.NetbankingPageObj;

public class BankTransferTest extends NetbankingPageObj {
	private static Assertion a = new Assertion();
	public static String SheetName = "Login";
//	public static String Data = "BankTransferParameters";

	@Test(priority = 1, enabled = true)
	public void verifyBankPaymentScreen() throws Exception {
		System.out.println("Verify bank payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = true)
	public void verifyBankPaymentBackButton() throws Exception {
		System.out.println("Verify bank payment back button");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		Thread.sleep(5000);
		commonLibrary.clickButton("backButton");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = true)
	public void verifySuccessfulPaymentBankPayment() throws Exception {
		System.out.println("Verify successful bank payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		successfulBankPayment();
		successmessage();
		Thread.sleep(6000);
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 4, enabled = true)
	public static void orderidrefreshNetbank() throws Throwable {
		System.out.println("Verify successful bank payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		orderidrefresh();
		Reporter.log("Verify the orderid should get refresh on redirecting back");
		MobileCapabilities.quitDriver();

	}
}
