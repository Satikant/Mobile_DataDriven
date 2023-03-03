package genericFeatures;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class GenericDriverAbstract {	
		//protected  WebDriver driver;

		protected AppiumDriver driver;

		public GenericDriverAbstract(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
	}

