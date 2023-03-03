package testRunsiOS;

import org.testng.Reporter;
import org.testng.annotations.Test;
import genericFeatures.MobileCapabilities;
import pageObjectsiOS.HomescreenPageObj;

public class HomescreenTest extends HomescreenPageObj {

	@Test(priority = 1, enabled = true)
	public void verifyiOSHomeScreenElements() throws Exception {
		System.out.println("Verify home screen elements");
		MobileCapabilities.main();
		readPageObjectProperties();
		iOShomescreeninitialization();
		verifyOnlinePaymentsOptions();
		Reporter.log("Verify Home Screen Elements");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 2, enabled = true)
	public void verifyHomeScreenElements_FreeTrial() throws Exception {
		System.out.println("Verify home screen elements with free trial");
		MobileCapabilities.main();
		readPageObjectProperties();
		verifyFreeTrial();
		verifyOnlinePaymentsOptions();
		Reporter.log("Verify Home Screen Elements with free trial option");
		MobileCapabilities.quitDriver();
	}

	@Test(priority = 3, enabled = true)
	public void verifyHomeScreenElements_RecurringPayment() throws Exception {
		System.out.println("Verify home screen elements with recurring option");
		MobileCapabilities.main();
		readPageObjectProperties();
		verifyRecurringPayment();
		verifyOnlinePaymentsOptions();
		Reporter.log("Verify Home Screen Elements with recurring option");
		MobileCapabilities.quitDriver();
	}

}
