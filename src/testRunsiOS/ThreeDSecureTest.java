package testRunsiOS;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import pageObjectsiOS.ThreeDSPageObj;


public class ThreeDSecureTest extends ThreeDSPageObj{
	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "CardPaymentData";
	
	
	@Test(priority = 1, enabled = true)
	public void ThreeDS_verifySuccessful_Card() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify change payment and proceed with wallet success in invalid card transaction");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiatecardScreen();
		threeDScardPayment();
		threeDSAuthentication();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 2,enabled = true)
	public void ThreeDS_verifySuccessful_EMI() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify non 3DS EMI payment");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		threeDSemiPayment();
		threeDSAuthentication();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 3, enabled = true)
	public void ThreeDS_verifydisabledSubmitBtn_InvalidOTP() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify success card transaction in retry flow");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiatecardScreen();
		threeDScardPayment();
		disabledSubmitButton();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 4, enabled = true)
	public void ThreeDS_verifyCancelAndRetry_3dSecure() throws Throwable {
//		MobileCapabilities.browserstack();
		MobileCapabilities.main();
		System.out.println("Verify success card transaction in retry flow");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiatecardScreen();
		threeDScardPayment();
		cancelthreeDSAuthentication();
		clickOnRetryButton();
		threeDScardPayment();
		threeDSAuthentication();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 5, enabled = true)
	public void ThreeDS_verifyCancelAndChangePayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify success card transaction in changepayment flow");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiatecardScreen();
		threeDScardPayment();
		cancelthreeDSAuthentication();
		clickOnChangePaymentLink();
		goToInitiatecardScreen();
		non3DSCardiOS();
//		threeDScardPayment();
//		threeDSAuthentication();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
		
	}
	
	@Test(priority = 6, enabled = false)
	public void ThreeDS_verifyTimeoutCancelTransaction() throws Throwable {
		
	}

}
