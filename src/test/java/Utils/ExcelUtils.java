package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static String path;
	private static XSSFSheet ExcelWSheet; 
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

	public static void setupTestData(String TestCase) throws FileNotFoundException
	{
		
		try {
			path = System.getProperty("user.dir")+"//src//test//java//TestData//"+TestCase+".xlsx";
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		} 
		catch (Exception e) 
		{
			System.out.println("File not found...");
			e.printStackTrace();
		}
	}
	
	public static HashMap<String,String> getData(String sheetName, String TCName)
	{
		HashMap<String,String> data = new HashMap<String, String>();
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		for(int i=0; i<=ExcelWSheet.getLastRowNum(); i++)
		{
			XSSFRow row = ExcelWSheet.getRow(i);
			XSSFRow rowHead = ExcelWSheet.getRow(0);
			if(row.getCell(0).toString().equalsIgnoreCase(TCName))
			{
				for(int j=0;j<rowHead.getLastCellNum();j++)
				{
				
					String key = rowHead.getCell(j).toString();
					String Value = row.getCell(j).toString();
					data.put(key, Value);
				}
			}
			
			  
		}
		return data;
		
	}
	public static void tearUp(String TestCase) throws FileNotFoundException
	{
	
	}
}
