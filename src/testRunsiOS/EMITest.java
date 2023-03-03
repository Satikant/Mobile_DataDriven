package testRunsiOS;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import genericFeatures.MobileCapabilities;
import genericFeatures.commonLibrary;
import pageObjectsiOS.EMIPageObj;

public class EMITest extends EMIPageObj{
	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "EMIData";
	
	@Test(priority=1,enabled = true)
	public void verifyPresenseOfEMI() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify presense of EMI options in online payment screen");
		readPageObjectProperties();
		iOShomescreeninitialization();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 2,enabled = false)
	public void verifyDisbaledSavedCreditCard() throws Throwable {
		
	}
	
	@Test(priority = 3,enabled = true)
	public void verifyAddanotherCard_EMIPayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify performing EMI payment after adding another card");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		addEMIcard();
		addAnotherEMICard();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 4,enabled = true)
	public void savedcard_non3DSEMIpayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify non 3DS EMI payment");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		non3DSemiPayment();
		commonLibrary.implicitWait();
		successmessage();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 5,enabled = true)
	public void viewAllEMIPlans_Savedcard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify view all EMI plans in saved card screen");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		viewAllEMIPlans();
		MobileCapabilities.quitDriver();
	}
	
	@Test(priority = 6,enabled = true)
	public void viewAllEMIPlans_Addcard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify view all EMI plans in add card screen");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		addEMIcard();
		viewAllEMIPlans();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 7,enabled = true)
	public void savedcard_non3DS_ConsecutivePayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify non 3DS consecutive EMI payment");
		readPageObjectProperties();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		non3DSemiPayment();
		commonLibrary.implicitWait();
		successmessage();
		doneBtnTransactionStatus();
		iOShomescreeninitialization();
		goToInitiateEMIScreen();
		non3DSemiPayment();
		commonLibrary.implicitWait();
		successmessage();
		MobileCapabilities.quitDriver();
	}
	
}
