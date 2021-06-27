package Utilities;

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	private static Map<String,String> testData=new TreeMap<String,String>();
	@SuppressWarnings("resource")
	public static String getMapData(String getKey)
	{
	  
		try {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ExcelData.xlsx");
			
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int lastRowNumber=sheet.getLastRowNum();
			
			for(int i=0;i<=lastRowNumber;i++)
			{
				String key=sheet.getRow(i).getCell(0).getStringCellValue().toString();
				String value=sheet.getRow(i).getCell(1).getStringCellValue().toString();
				testData.put(key, value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String keyValue=testData.get(getKey).toString();
		return keyValue;
	}
			
}
