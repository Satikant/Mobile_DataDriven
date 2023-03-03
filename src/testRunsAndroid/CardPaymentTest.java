package testRunsAndroid;

import java.util.Dictionary;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;


import genericFeatures.ConfigFileReader;
import genericFeatures.MobileCapabilities;
import pageObjectsAndroid.InitialiseSDKPageObjects;
import pageObjectsiOS.CardsPageObj;

public class CardPaymentTest extends CardsPageObj{
	public Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "CardPaymentParameters";
	public InitialiseSDKPageObjects initialiseSDKPageObjects = new InitialiseSDKPageObjects();
	private static ConfigFileReader con = new ConfigFileReader();
	

	@Test(priority=1,enabled=false)
	public void verifyCardPaymentScreen() throws Throwable {
		System.out.println("Verify card payment screen");
		MobileCapabilities.main();
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		MobileCapabilities.quitDriver();
	}
	@Test(priority= 2,enabled=true)
	public void verifyAddSuccessfulCardPaymentVisa() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify successful card payment - VISA");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulCardPaymentVisa();
		MobileCapabilities.quitDriver();
	}

}
