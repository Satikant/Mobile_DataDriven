package testRunsiOS;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import pageObjectsiOS.NetbankingPageObj;

public class NetbankingTest extends NetbankingPageObj {
	private static Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "BankTransferParameters";

	@Test(priority = 1, enabled = true)
	public void verifyBankPaymentScreen() throws Exception {
		System.out.println("Verify bank payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
//		test.log(Status.PASS, "Verify Bank Payment Screen");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = true)
	public void verifyBankPaymentBackredirection() throws Exception {
		System.out.println("Verify bank payment back button");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		commonLibrary.explicitWait("iOSbackButton");
		commonLibrary.clickButton("iOSbackButton");
		Thread.sleep(3000);
//		test.log(Status.PASS, "Verify Back Button in Bank Payment");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = true)
	public void verifySuccessfulPaymentBankPayment() throws Exception {
		System.out.println("Verify successful bank payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		Thread.sleep(1000);
		goToBankPaymentScreen();
		Thread.sleep(1000);
		successfulBankPayment();
		commonLibrary.explicitWait("iOSBankPaymentSuccess");
		commonLibrary.verifysuccessmesage("iOSBankPaymentSuccess", "successMessage");
		commonLibrary.explicitWait("iOSOKButton");
		commonLibrary.clickButton("iOSOKButton");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 4, enabled = true)
	public void verifyOrderID() throws Throwable {
		System.out.println("Verify order id in netbanking screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		verifyorderID();
		Reporter.log("Verify order id in netbanking screen");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 5, enabled = true)
	public void verifyPayableAmount() throws Throwable {
		System.out.println("Verify payble Amount in netbanking screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		goToBankPaymentScreen();
		verifypayableAmount();
		Reporter.log("Verify payble Amount in netbanking screen");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 6, enabled = true)
	public static void orderidrefreshNetbank() throws Throwable{
		System.out.println("Verify capturing the new orderid");
		MobileCapabilities.main();
		readPageObjectProperties();
		bankinitialization();
		orderidrefresh();
		Reporter.log("Verify the orderid should get refresh on redirecting back");
		MobileCapabilities.quitDriver();
		
	}
}
