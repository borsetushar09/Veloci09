package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String getDataFromExcelsheet(int a,int b) throws EncryptedDocumentException, IOException
	{
		//public static void add();
	
	String path = "C:\\Users\\HP\\Desktop\\New Microsoft Office Excel Worksheet.xlsx";
			
			FileInputStream file = new FileInputStream(path);
	
	      Sheet s= WorkbookFactory.create(file).getSheet("Velocity");
		 // double d=	s.getRow(a).getCell(b).getNumericCellValue();
	
	String data ="";
	
	try {
		data  =s.getRow(a).getCell(b).getStringCellValue();
	}
	catch(IllegalStateException e)
	{
	double value=s.getRow(a).getCell(b).getNumericCellValue();
	 data = String.valueOf(value);
	}
	catch (NullPointerException f)
	{
		f.printStackTrace();
	}
	
	return data;
}


	

	public static void  saveScreenshot(WebDriver driver123, int testID) throws IOException {
		
		
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File src =((TakesScreenshot)driver123).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Scrrenshot"+testID+""+timestamp+".jpg");
		
		FileHandler.copy(src,dest);
		

		

	}




	
	}


