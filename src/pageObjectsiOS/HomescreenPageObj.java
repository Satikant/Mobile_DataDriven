package pageObjectsiOS;

import java.util.Dictionary;
import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;
import genericFeatures.ExcelUtils;
import genericFeatures.GlobalVariables;
import genericFeatures.commonLibrary;

public class HomescreenPageObj extends GlobalVariables {
	private static Dictionary<String, String> dataList;
	private static String SheetName = "Login";
	private static Assertion a = new Assertion();
	public static Logger log = Logger.getLogger(HomescreenPageObj.class.getName());

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, SheetName);
	}

	public static void readPageObjectProperties() throws Exception {
		String pageObjectsSheetName = "";
		readTestData();
		System.out.println(dataList.get("DeviceType"));
		if (dataList.get("DeviceType").equals("Android")) {
			pageObjectsSheetName = "HomeScreenData";
		} else {
			pageObjectsSheetName = "HomeScreenData";
		}
		System.out.println("Page Object Sheet Name = " + pageObjectsSheetName);
		ExcelUtils.readPageProperties(GlobalVariables.DataFilePath, pageObjectsSheetName);
	}

	public static void iOShomescreeninitialization() throws Exception {
		try {
			dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
			if (dataList.get("Testing").equals("true")) {
				commonLibrary.explicitWait("iOSbuyNowButton");
				commonLibrary.clickButton("iOSbuyNowButton");
				Thread.sleep(10000);
			} else {
				commonLibrary.waitTillElementPresent("payNowButton");
				commonLibrary.clickButton(dictPageObjects.get("payNowButton"));
			}
		} catch (Exception e) {

			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}
	}

	public static void verifyOnlinePaymentsOptions() {
		try {
			if (dataList.get("DeviceType").equals("Android")) {
				log.info("Verify card button in Android");
				String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
				String expected = dictPageObjects.get("payplus_iOSsdk_card");
//				String expected = commonLibrary.captureExpectedText("payplus_iOSsdk_card");
				a.assertEquals(cardButton, expected);
				log.info("Verify EMI credit/debit card");
				String walletButton = driver.findElementByXPath(dictPageObjects.get("emiDebitandCrdit")).getText();
//				a.assertEquals(walletButton, commonLibrary.captureExpectedText("payplus_iOSsdk_emicreditdebitcard"));
				a.assertEquals(walletButton, dictPageObjects.get("payplus_iOSsdk_emicreditdebitcard"));
			} else {
				log.info("Verify card button in iOS");
				String cardButton = driver.findElementByXPath(dictPageObjects.get("cardButton")).getText();
				String expected = dictPageObjects.get("payplus_iOSsdk_card");
//				String expected = commonLibrary.captureExpectedText("payplus_iOSsdk_card");
				a.assertEquals(cardButton, expected);

//				log.info("Verify bank transfer button");
//				String netBankingButton = driver.findElementByXPath(dictPageObjects.get("netBankingButton")).getText();
//				a.assertTrue(netBankingButton.equalsIgnoreCase("Netbanking"));

				log.info("Verify EMI credit/debit card");
				String walletButton = driver.findElementByXPath(dictPageObjects.get("emiDebitandCrdit")).getText();
//				a.assertEquals(walletButton, commonLibrary.captureExpectedText("payplus_iOSsdk_emicreditdebitcard"));
				a.assertEquals(walletButton, dictPageObjects.get("payplus_iOSsdk_emicreditdebitcard"));
			}

		} catch (Exception e) {
			System.out.println("User did not redirected to online payment screen");
		}
	}

	public static void verifyFreeTrial() throws Exception {
		try {
			dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
			if (dataList.get("Testing").equals("true")) {
				commonLibrary.explicitWait("iOSdefaultButton");
				commonLibrary.clickButton("iOSdefaultButton");
				commonLibrary.implicitWait();
				commonLibrary.iOSswipedown();
				commonLibrary.iOSswipedown();
				commonLibrary.iOSswipedown();
				commonLibrary.clickButton("iOSFreeTrialCheckbox");
				commonLibrary.clickButton("iOSpayNowButton");
				Thread.sleep(10000);
			} else {
				commonLibrary.clickButton("iOSFreeTrialCheckbox");
				commonLibrary.clickButton("iOSpayNowButton");
			}

		} catch (Exception e) {
			a.assertTrue(commonLibrary.isElementPresent("iOSAuthenticationFailure"));
			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}
	}

	public static void verifyRecurringPayment() throws Exception {
		try {
			dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "HomeScreenData");
			if (dataList.get("Testing").equals("true")) {
				commonLibrary.explicitWait("iOSdefaultButton");
				commonLibrary.clickButton("iOSdefaultButton");
				commonLibrary.implicitWait();
				commonLibrary.iOSswipedown();
				commonLibrary.iOSswipedown();
				commonLibrary.iOSswipedown();
				commonLibrary.clickButton("iOSRecurringCheckbox");
				commonLibrary.clickButton("iOSpayNowButton");
				Thread.sleep(10000);
			} else {
				commonLibrary.waitTillElementPresent("iOSRecurringCheckbox");
				commonLibrary.clickButton("iOSRecurringCheckbox");
				commonLibrary.clickButton("iOSpayNowButton");
			}

		} catch (Exception e) {
			a.assertTrue(commonLibrary.isElementPresent("iOSAuthenticationFailure"));
			System.out.println("Authorization token could not be retrieved");
			commonLibrary.clickButton("OKButton");
		}

	}

}
