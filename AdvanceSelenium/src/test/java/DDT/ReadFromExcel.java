package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		
		Workbook bk=WorkbookFactory.create(fis);
		
		Sheet sheet = bk.getSheet("Sheet1");
		
		Row row = sheet.getRow(3);
		
		Cell cell = row.getCell(4);
		
		//String excelData = cell.getStringCellValue();
		double excelData = cell.getNumericCellValue();
		System.out.println(excelData);
		
		String strdata = sheet.getRow(2).getCell(3).getStringCellValue();
		System.out.println(strdata);
		//2,5//4,1
		double doubledata=sheet.getRow(2).getCell(4).getNumericCellValue();
		
		System.out.println(doubledata);

		 java.util.Date datedata = sheet.getRow(4).getCell(1).getDateCellValue();

	
		System.out.println(datedata);

	}

}
