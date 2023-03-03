package genericFeatures;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GlobalVariables {

	public static String DataFilePath = System.getProperty("user.dir")+"//TestData//PayplusData.xls//";
	//	public static String SheetName;
	public static Dictionary<String, String> dict = new Hashtable<String, String>();
	public static Dictionary<String, String> dictPageObjects = new Hashtable<String, String>();//Locators
	public static String filePath = System.getProperty("user.dir")+"//Screenshots//";
	public static ExtentReports reports = new ExtentReports();
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlreporter;
	public static String date1;
	public static AppiumDriver <WebElement> driver;
//	public static IOSDriver <IOSElement> IOSDriver;
//	public static AndroidDriver<AndroidElement> AndroidDriver;
	public static String propertyiOSFilePath = "D:\\Git\\payplussdk-automation\\src\\pageObjects\\pageObjectProperties.properties";
	public static String propertyAndroidFilePathEnglish = "D:\\Git\\payplussdk-automation\\src\\pageObjects\\pageObjectAndroidProperties.properties";
	public static String reportsPath= System.getProperty("user.dir")+"\\ExtentReports\\";
	public static String propertyAndroidFilePathArabic = "D:\\Git\\payplussdk-automation\\src\\pageObjects\\ConfigProperties_Arabic.properties";
	public static Properties properties;
	public static java.nio.file.Path path;
	//	public static String pageObjectsSheetName = "";

	abstract class Logsdd
	{
		protected  AppiumDriver driver;
		public Logsdd(AppiumDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	}
}
