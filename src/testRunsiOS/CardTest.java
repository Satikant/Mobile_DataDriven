package testRunsiOS;



import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import genericFeatures.MobileCapabilities;
import pageObjectsiOS.CardsPageObj;
import pageObjectsiOS.WalletscreenPageObj;

public class CardTest extends CardsPageObj{
	Assertion a = new Assertion();
	public static String SheetName = "Login";
	public static String Data = "CardPaymentData";
	WalletscreenPageObj walletobj = new WalletscreenPageObj();
	
	@Test(priority= 1,enabled=true)
	public void verifyCardSaveScreenLaunch() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify card payment screen");
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
	@Test(priority = 3, enabled = true)
	public void verifyEmptycardNumber() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify empty card number");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		blankCardNumber();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 4, enabled = true)
	public void verifyInvalidcardNumber() throws Throwable{
		MobileCapabilities.main();
		System.out.println("Verify invalid card number");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		invalidCardNumber();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 5, enabled = true)
	public void verifyEmptyExpiryDate() throws Throwable{
		MobileCapabilities.main();
		System.out.println("Verify empty expiry date");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		blankExpiry();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 6, enabled = true)
	public void verifyInvalidExpiryDate() throws Throwable{
		MobileCapabilities.main();
		System.out.println("Verify invalid expiry date");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		invalidExpiry();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 7, enabled = true)
	public void verifyEmptyCVV() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify empty CVV");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		blankCvv();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 8, enabled = true)
	public void verifyJCBcard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify JCB card");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulCardPaymentJcb();
		failuremessage();
		MobileCapabilities.quitDriver();
	}
	//redirect issue
	@Test(priority = 9, enabled = true)
	public void verifyTransaction_SavedCard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify transaction in saved card");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		non3DSCardiOS();
		successmessage();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 10, enabled = true)
	public void verifyAddInvalidcard_changepayment_Walletsuccesspayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify change payment and proceed with wallet success in invalid card transaction");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulCardPaymentJcb();
		failuremessage();
		failureChangepaymentlink();
		WalletscreenPageObj.goToInitiateWalletScreen();
		WalletscreenPageObj.mpesaSelection();
		WalletscreenPageObj.transactionconfirmation();
		doneBtnTransactionStatus();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 11, enabled = true)
	public void verifyAddInvalidcard_Retry_Validcardsuccesspayment() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify retry and proceed with wallet success in invalid card transaction");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulCardPaymentJcb();
		failuremessage();
		failureRetryButton();
		successfulCardPaymentVisa();
		MobileCapabilities.quitDriver();
	}
	//redirect issue
	@Test(priority = 12, enabled = true)
	public void verifyUniqueOrderId_Retry_transaction() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify unique order id in retry transaction");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulCardPaymentVisa();
		iosPayNowBtn();
		goToInitiatecardScreen();
		captureOrderIdNon3DS();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 13, enabled = true)
	public void verify_Cancel_DeleteCard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify canceling in delete card");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		cancelOfDelete();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 14, enabled = true)
	public void verify_DeleteCard() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify deleting a card");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		deleteSavedCard();
		MobileCapabilities.quitDriver();
	}
	@Test(priority = 15, enabled = true)
	public void verify_CardonSave() throws Throwable {
		MobileCapabilities.main();
		System.out.println("Verify adding a new card and check it in card");
		readPageObjectProperties();
		cardScreeninitialization();
		goToInitiatecardScreen();
		addcardScreen();
		successfulVisaCardPaymentwithFasterCheckout();
		cardScreeninitialization();
		goToInitiatecardScreen();
		presenceofVisaCard();
		MobileCapabilities.quitDriver();
	}
	
}
