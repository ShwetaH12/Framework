package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.Format;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelUsingDataFormater {

public static void main(String[] args) throws Throwable {
		
		//Step1:- give Connection between the physical file and test script
	FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");

				//step2:-keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
			
			   //step3:-taking Control of the excel sheet
				Sheet sheet = book.getSheet("Sheet1");
			
				//step4:-taking Control of the rows
				Row row = sheet.getRow(0);
			
				//step5:-taking Control of the cell
				Cell cel = row.getCell(0);
				
				DataFormatter format = new DataFormatter();
				String ExcelData = format.formatCellValue(cel);
				System.out.println(ExcelData);

	}

}
