package genericFeatures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;

public class ConfigFileReader extends GlobalVariables {

	private static String Sheet = "Login";
	private static Dictionary<String, String> dataList;
	private Properties properties;
	private final String propertyFilePath = "res//strings.properties";

	public static void readTestData() throws Exception {
		dataList = ExcelUtils.getExcelFile(GlobalVariables.DataFilePath, Sheet);
	}

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getErrorMessage(String errorMessage) {
		String error = properties.getProperty(errorMessage);
		if (error != null)
			return error;
		else
			throw new RuntimeException("String not found");
	}
	
	public String getSuccessMessage() {
		String error = properties.getProperty("successMessage");
		if (error != null)
			return error;
		else
			throw new RuntimeException("String not found");
	}
	
	public String getSaveCardSuccessMessage() {
		String error = properties.getProperty("saveCardSuccessMessage");
		if (error != null)
			return error;
		else
			throw new RuntimeException("String not found");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getMpesaText() {
		String mpesa = properties.getProperty("Mpesa");
		if (mpesa != null)
			return mpesa;
		else
			throw new RuntimeException("Mpesa Text Not gettting");
	}
	
	public String getEcoCashText() {
		String ecoCash = properties.getProperty("Ecocash");
		if (ecoCash != null)
			return ecoCash;
		else
			throw new RuntimeException("EcoCash Text Not gettting");
	}
	//*****************************QA-ADG************************************//
	public String getpayINRText() {
		String payINR = properties.getProperty("PayINR");
		if (payINR != null)
			return payINR;
		else
			throw new RuntimeException("Not gettting Submit button in the screen");
	}
	public String InvalidcardNumberTextmessage() {
		String invalidcardnum = properties.getProperty("errorString");
		if (invalidcardnum != null)
			return invalidcardnum;
		else
			throw new RuntimeException("Not gettting Submit button in the screen");
	}
	public String Invalidmsisdnmessage() {
		String Invalidmsisdn = properties.getProperty("InvalidMSISDN");
		if (Invalidmsisdn != null)
			return Invalidmsisdn;
		else
			throw new RuntimeException("Not gettting Submit button in the screen");
	}
	public String getEMITitleText() {
		String EMIcards = properties.getProperty("EMI on Cards");
		if (EMIcards != null)
			return EMIcards;
		else
			throw new RuntimeException("Not gettting EMI title Text");
	}
}
