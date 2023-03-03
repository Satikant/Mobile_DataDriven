package genericFeatures;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;

public class FileUtilities extends GlobalVariables {
	static String extentReportfilePath = System.getProperty("user.dir")+"//ExtentReports";
    static DateFormat dateFormat = new SimpleDateFormat("MM_DD_YYYY_HH");
   static Date testRunDate = new Date();
   static String dateStr = dateFormat.format(testRunDate);
   static DateFormat dateFormat1 = new SimpleDateFormat("MM_DD_YYYY_HH_MM");
   static Date testRunDate1 = new Date();
   static String dateStr1 = dateFormat1.format(testRunDate1);
   public static String suiteReportFilePath = extentReportfilePath+"//SuiteReport_"+dateStr;
   public static String IOS_SuitePath = FileUtilities.suiteReportFilePath+"//"+"ExtentReport_IOS_Suite_"+dateStr1; //+".html";
   public static String Android_SuitePath = FileUtilities.suiteReportFilePath+"//"+"ExtentReport_Android_Suite"; //+".html";
//   public static String Android_SuitePath = FileUtilities.suiteReportFilePath+"\\"+"ExtentReport_Android_Suite_"+dateStr1; //+".html";

 @Test
 public void createFolder() {
      File directory = new File(suiteReportFilePath);
          if (!directory.exists()) {
              new File(suiteReportFilePath).mkdir();
              System.out.println("Folder Created");
          }
 }
}
