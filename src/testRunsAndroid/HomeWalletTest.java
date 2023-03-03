package testRunsAndroid;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;
import genericFeatures.MobileCapabilities;
import pageObjectsiOS.WalletscreenPageObj;

public class HomeWalletTest extends WalletscreenPageObj{
	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "WalletHomeData";
	
	@Test(priority=1,enabled=true)
	public void validatethatwalletlistisdisplayed() throws Throwable {		
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		MobileCapabilities.quitDriver();
	}
	@Test(priority=2,enabled=true)
	public void validate_that_Pay_button_is_Visible_After_WalletSelection() throws Throwable {
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		mpesaSelection();
		verify_Pay_INR_Button();
		MobileCapabilities.quitDriver();
	}
	@Test(priority=3,enabled=true)
	public void validate_wallet_success_flow() throws Throwable {
		MobileCapabilities.main();
		readPageObjectProperties();	
		walletscreeninitialization();
		Thread.sleep(3000);
		//*clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		Thread.sleep(3000);
		//*clicking on mpesa wallet*//
		mpesaSelection();
		Thread.sleep(3000);
		//*clicking on submit button*//
		transactionconfirmation();
		Thread.sleep(3000);
		successmessage();
		Thread.sleep(3000);
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	@Test(priority=4,enabled=true)
	public void back_navigation_Home_Screen() throws Throwable {
		MobileCapabilities.main();
		readPageObjectProperties();	
		walletscreeninitialization();
		Thread.sleep(3000);
		//*clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		Thread.sleep(3000);
		//*clicking on mpesa wallet*//
		mpesaSelection();
		Thread.sleep(1000);
		//*clicking on submit button*//
		redirectback();
		Thread.sleep(4000);
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 5, enabled = true)
	public void captureNewOrderId() throws Throwable{
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		Thread.sleep(1000);
		//*clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		orderidrefresh();
		MobileCapabilities.quitDriver();
		
	}
	@Test(priority = 6, enabled = true)
	public void verifyreferenceIDinWallet() throws Throwable {
		System.out.println("Verify reference id in wallet transaction confirmation screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		goToInitiateWalletScreen();
		listOfNamesDisplayedInWalletScreen();
		mpesaSelection();
		transactionconfirmation();
		MobileCapabilities.quitDriver();
	}
	@Test(priority=7,enabled=true)
	public void validate_that_only_one_Selected() throws Throwable {
		MobileCapabilities.main();
		readPageObjectProperties();
		walletscreeninitialization();
		Thread.sleep(1000);
		//*clicking on wallet option from online payments section*//
		goToInitiateWalletScreen();
		MobileCapabilities.quitDriver();
	}
}
