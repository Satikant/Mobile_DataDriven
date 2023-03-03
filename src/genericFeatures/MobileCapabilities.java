package genericFeatures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import genericFeatures.GlobalVariables;

public class MobileCapabilities {
	public static String reportDirectory = "reports";
	public static String reportFormat = "xml";
	public static DesiredCapabilities dc = new DesiredCapabilities();
	public static String deviceOSType;
	public static Dictionary<String, String> dataList;
	public static String ANDROID = "Android";
	public static String RESETKEYBOARD = "resetkeyboard";
	public static String PLATFORM = "platformName";
	public static String UNICODEKEYBOARD = "unicodeKeyboard";
	public static String REPORTFORMAT = "unicodeKeyboard";
	public static String DEVICENAME = "deviceName";
	public static String REPORTDIRECTORY = "reportDirectory";
	public static String BUNDLEID = "bundleId";
	public static String MACHINENAME = "Machine";
	public static String PLATFORMENVIRONMENT = "Env";
	public static String BUILDVERSION = "Build";
	public static String AUTOMATION_NAME = "AutomationName";
	public static String DEVICE_NAME = "DeviceName";
	public static String PLATFORM_NAME = "DeviceType";
	public static String PLATFORM_VERSION = "PlatformVersion";
	public static String UD_ID = "DeviceIdentifier";
	public static String APP = "AppPath";

	abstract class GenericDriverAbstract {
		// protected WebDriver driver;

		protected AppiumDriver driver;

		public GenericDriverAbstract(AppiumDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	}

	// *------- Call Platform environment mobile capabilities -------*//

	public static void main() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, "Login");
		deviceOSType = dataList.get("DeviceType");
		if (deviceOSType.equals(ANDROID)) {
			System.out.println("Android device detected");
			setUp_Android_Capabilities(); // *----- Android Capability
		} else {
			System.out.println("iOS device detected");
			setUp_IOS_Capabilities(); // *------ IOS Capability
		}
	}

	// *--------- Set Android Capabilities -----------*//
	public static void setUp_Android_Capabilities() throws MalformedURLException {
		commonMobileCapability();
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, dataList.get("APPPackage"));// *------ Set Package
																								// Name for Android
																								// ----*//
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, dataList.get("AppActivity"));// *----- Set Activity
																								// for Android ----*//
		GlobalVariables.driver = new AndroidDriver(new URL(dataList.get("AppiumURL")), dc);// *---- Communicate With
																							// Appium Server using
																							// following URL and
																							// Port----*//
	}

	// *--------- Set IOS Capabilities -----------*//
	public static void setUp_IOS_Capabilities() throws Exception {
		desiredcapabilities();
//		dc.setCapability(BUNDLEID, dataList.get("APPPackage"));           //*------ App Bundle ID ----*//
//		GlobalVariables.driver = new IOSDriver(new URL(dataList.get("AppiumURL")), dc);// *---- Communicate With Appium
																						// Server using following URL																			// and Port----*//
	}

	public static void commonMobileCapability() {
		dc.setCapability(REPORTFORMAT, reportFormat);// *---- Report Format -----*//
		dc.setCapability(DEVICENAME, dataList.get("DeviceName"));// *--- Device Name ------*//
		dc.setCapability(REPORTDIRECTORY, reportDirectory); // *----- Report Directory ---*//
		dc.setCapability(PLATFORM, dataList.get("DeviceType"));// *----- Platform Environment -----*//
		dc.setCapability(UD_ID,dataList.get("DeviceIdentifier"));//*----- Set Device UDID ------*//
		dc.setCapability(RESETKEYBOARD, dataList.get("ResetKeyboard"));// *----- Reseting Keyboard Every time ----*//
		dc.setCapability(UNICODEKEYBOARD, dataList.get("KeyboardEnabled"));
		GlobalVariables.path = Paths.get(GlobalVariables.reportsPath);// *-----Set Reports Path -----*//
		GlobalVariables.reports.setSystemInfo(MACHINENAME, dataList.get("RunningMachine"));// *--- Set Machine
																							// Name----*//
		GlobalVariables.reports.setSystemInfo(PLATFORMENVIRONMENT, dataList.get("DeviceType"));// *----- Set Environment
																								// -----*//
		GlobalVariables.reports.setSystemInfo(BUILDVERSION, dataList.get("BuildVersion"));
	}

	public static void desiredcapabilities() throws Exception {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,dataList.get("AutomationName"));
//		 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dataList.get("DeviceName"));
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, dataList.get("DeviceType"));
//		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, dataList.get("PlatformVersion"));
//		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "iOS");
//		 capabilities.setCapability(MobileCapabilityType.UDID, "29A0A36A-61A2-48D3-BB0F-5DC43F4E47F3");
		 capabilities.setCapability(MobileCapabilityType.UDID, dataList.get("DeviceIdentifier"));
		 capabilities.setCapability(MobileCapabilityType.APP, dataList.get("AppPath"));
//		 capabilities.setCapability(MobileCapabilityType.APP, "/Users/qa_payplus/Documents/PAYPLUS/payplusconsumersdkdemo.app");
		 capabilities.setCapability("connectHardwareKeyboard", false);
//		 capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + "/app/paypus.app");
		 GlobalVariables.driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

	// *---- Quit Driver ----*//
	public static void quitDriver() {
		GlobalVariables.driver.quit();
	}

	// *----QA_ADG--- Swipe Screen to Down -------*//
	public static void Swipedown() {
		GlobalVariables.driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
	}
	
	public static void Action(WebElement element) {
		Actions action = new Actions(GlobalVariables.driver);
		action.moveToElement(element);
	}
	public static IOSDriver browserstack() {
		try {
		    //startAppiumServer();
		    DesiredCapabilities caps = new DesiredCapabilities();
		    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		    // Set your access credentials
		    browserstackOptions.put("userName", "satikantap_hrWRfx");
		    browserstackOptions.put("accessKey", "HM2BjxPSHhex1SzksnNZ");
		    // Set other BrowserStack capabilities
		    browserstackOptions.put("appiumVersion", "1.22.0");
		    browserstackOptions.put("projectName", "Payplus_iOS Project");
		    browserstackOptions.put("buildName", "browserstack-build-1");
		    browserstackOptions.put("sessionName", "first_test");
		    // Passing browserstack capabilities inside bstack:options
		    caps.setCapability("bstack:options", browserstackOptions);
		    // Set URL of the application under test
		    caps.setCapability("app", "bs://24014c2e28aea98c6a8b2b93183f49fa9371577b");
		    // Specify deviceName and platformName for testing
		    caps.setCapability("deviceName", "iPhone 14 Pro Max");
		    caps.setCapability("os_version", "16");
		    caps.setCapability("platformName", "ios");
		     /*Initialise the remote Webdriver using BrowserStack remote URL
		     and desired capabilities defined above*/
		    return new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
	}
}
