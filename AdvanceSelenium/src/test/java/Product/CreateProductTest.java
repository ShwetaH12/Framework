package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utitity;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.ValidatePage;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.ProductPage;

public class CreateProductTest extends BaseClass{

	//@Test(groups = {"smoke","regression"})
	@Test(retryAnalyzer =Generic_Utilities.RetryImp.class)
	public void createProduct() throws Throwable  {

		WebDriver_Utility wlib=new WebDriver_Utility();

		File_Utitity flib= new File_Utitity();
		String url=flib.getPropertiesData("url");
		String userNm=flib.getPropertiesData("user");
		String pwd=flib.getPropertiesData("password");
		String browser=flib.getPropertiesData("browser");
		
		
		HomePage home=new HomePage(driver);
		home.ClickProductLink();
		
		ProductPage prod=new ProductPage(driver);
						
		Java_Utilities jlib=new Java_Utilities();
		int ranInt=	jlib.getRandomNum();

		Excel_Utility elib=new Excel_Utility();
		String prodname = elib.getExcelData("Sheet1", 0, 0)+ranInt;
		prod.AddProduct(prodname);
		
		Thread.sleep(2000);

		ValidatePage validP=new ValidatePage(driver);
		String expData=validP.validateProductName(driver);
		Assert.assertEquals(expData+ranInt, prodname, "Assert pass");
		
	}

}
