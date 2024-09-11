package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		 Workbook w = WorkbookFactory.create(fis);
		 w.getSheet("Sheet2").createRow(0).createCell(0).setCellValue("shweta");
		 w.getSheet("Sheet2").createRow(0).createCell(1).setCellValue("zagade");
		w.getSheet("Sheet2").createRow(7).createCell(6).setCellValue(12.89);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		w.write(fos);
		w.close();
		}
}
