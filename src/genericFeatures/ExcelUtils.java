package genericFeatures;

import java.io.FileInputStream;
import java.util.Dictionary;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
		
	public static void main(String[] args) throws Exception {
//    	getExcelFile(Path,SheetName);
	}
	public static Dictionary<String, String> getExcelFile(String Path,String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			@SuppressWarnings("resource")
		//	System.out.println("Excel Path = "+Path);
		//	System.out.println("Excel Sheet Name = "+SheetName);
			HSSFWorkbook ExcelWBook = new HSSFWorkbook(ExcelFile);
			HSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelWSheet.getLastRowNum();
			//System.out.println("Row Count = "+rowCount);
			for(int i=0;i<rowCount;i++) {
				HSSFRow row = ExcelWSheet.getRow(i); 
				int colCount = row.getPhysicalNumberOfCells();
		//		System.out.println("Column Count = "+colCount);
				String a[]= new String[2];
				for (int j=0;j<colCount;j++) {
					HSSFCell cell = row.getCell(j);
		//			System.out.println(cell);
					String getcelldata = cell.getStringCellValue();
					a[j] = getcelldata;
				}
				String parameterName = a[0];
				String parameterValue = a[1];
//				System.out.println("TestParameter Name = "+parameterName);
//				System.out.println("TestParameter Value = "+parameterValue);
				GlobalVariables.dict.put(parameterName, parameterValue);
	//			System.out.println("Parameter Value = "+dict.get(parameterName));
			}
		} 
				catch (Exception e){
					throw (e);
				}
			return GlobalVariables.dict;
		}

	public static Dictionary<String, String> readPageProperties(String Path, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
		// Access the required test data sheet
		//	System.out.println("Excel Path = "+Path);
		//	System.out.println("Excel Sheet Name = "+SheetName);
			@SuppressWarnings("resource")
			HSSFWorkbook ExcelWBook = new HSSFWorkbook(ExcelFile);

			System.out.println("Sheet name for Page Objects "+SheetName);
			HSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelWSheet.getLastRowNum();
			//System.out.println("Row Count = "+rowCount);
			for(int i=0;i<rowCount;i++) {
				HSSFRow row = ExcelWSheet.getRow(i); 
				int colCount = row.getPhysicalNumberOfCells();
		//		System.out.println("Column Count = "+colCount);
				String a[]= new String[2];
				for (int j=0;j<colCount;j++) {
					HSSFCell cell = row.getCell(j);
		//			System.out.println(cell);
					String getcelldata = cell.getStringCellValue();
					a[j] = getcelldata;
				}
				String parameterName = a[0];
				String parameterValue = a[1];
//				System.out.println("TestParameter Name = "+parameterName);
//				System.out.println("TestParameter Value = "+parameterValue);
				GlobalVariables.dictPageObjects.put(parameterName, parameterValue);
//				System.out.println("Parameter Value = "+GlobalVariables.dictPageObjects.get(parameterName));
			}
		}
			catch (Exception e){
				throw (e);
			}
		return GlobalVariables.dictPageObjects;
	}
	
}

