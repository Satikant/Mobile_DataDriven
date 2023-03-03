package testRunsiOS;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import genericFeatures.MobileCapabilities;
import pageObjectsiOS.WalletscreenPageObj;

public class WalletTest extends WalletscreenPageObj {
	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "WalletHomeData";
//	HomescreenPageObj homescreenpageobj = new HomescreenPageObj();

	@Test(priority = 1, enabled = false)
	public void walletSuccessFlow() throws Throwable {
		System.out.println("Verify home screen elements");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		transactionconfirmation();
		doneBtnTransactionStatus();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = false)
	public void verifyreferenceIDinWallet() throws Throwable {
		System.out.println("Verify reference id in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		transactionconfirmation();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = false)
	public void verifyOrderID() throws Throwable {
		System.out.println("Verify order id in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		verifyorderID();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 4, enabled = false)
	public void verifyPayableAmount() throws Throwable {
		System.out.println("Verify Payable amount in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		verifypayableAmount();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 5, enabled = true)
	public void verifyInvalidMSISDN() throws Throwable {
		System.out.println("Verify invalid MSISDN in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		invalidMSISDN();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 6, enabled = true)
	public void verifyEmptyMSISDN() throws Throwable {
		System.out.println("Verify empty MSISDN in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		emptyMSISDN();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 7, enabled = false)
	public void verifyOrderIdrefreshOnRedirectBack() throws Throwable {
		System.out.println("Verify empty MSISDN in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		orderidrefresh();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}
}
