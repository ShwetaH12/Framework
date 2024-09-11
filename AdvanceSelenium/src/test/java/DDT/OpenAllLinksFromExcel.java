package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAllLinksFromExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		Sheet sheet = w.getSheet("Sheet2");
		int rowcount = sheet.getLastRowNum();

		for(int i=0 ; i<rowcount;i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
			Cell cel = row.getCell(j);
			String url = cel.getStringCellValue();
			System.out.println(url);
			}
		}
		w.close();
		
	}

}
