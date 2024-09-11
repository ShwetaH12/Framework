package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {
	/**
	 * This method is used to read the Excel data
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 * @author shweta
	 */
	public String getExcelData(String sheetname,int rowNo,int cellNo) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\OneDrive\\Documents\\Products.xlsx");
		Workbook w1 = WorkbookFactory.create(fis);
		Sheet sheet = w1.getSheet(sheetname);
		Cell cell = sheet.getRow(rowNo).getCell(cellNo);
		DataFormatter format = new DataFormatter();

		String excelData = format.formatCellValue(cell);
		return excelData;
		
	}
	
	public Object[][] getEntireRowData(String sheetname) throws Throwable  
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\OneDrive\\Documents\\Products.xlsx");
		Workbook w1 = WorkbookFactory.create(fis);
		Sheet sheet = w1.getSheet(sheetname);	
		int lastRow=sheet.getLastRowNum();
		int lastCol=sheet.getRow(0).getLastCellNum();
		
		Object[][] obj =new  Object[lastRow][lastCol];
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<lastCol;j++)
			{
				
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
				
				
			}
			
		}
		
		return obj;
	}
}
