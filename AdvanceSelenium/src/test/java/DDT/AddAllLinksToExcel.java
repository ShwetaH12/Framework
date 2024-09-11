package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//pull
public class AddAllLinksToExcel {

	public static void main(String[] args) throws Throwable, IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		
		for(int i=0; i<allLink.size() ;i++)
		{
			Row row = sheet.createRow(i);
			Cell cel = row.createCell(0);
			cel.setCellValue(allLink.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\shwet\\Documents\\Book1.xlsx");
		book.write(fos);
		book.close();
	}

}
