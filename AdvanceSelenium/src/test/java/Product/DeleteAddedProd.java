package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utitity;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.DeleteProdPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.ProductPage;

public class DeleteAddedProd {

	public static void main(String[] args) throws Throwable  {

		ChromeDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();

		File_Utitity flib = new File_Utitity();
		
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ProductPage prod=new ProductPage(driver);
		DeleteProdPage delPrd=new DeleteProdPage(driver);
		
		String url=flib.getPropertiesData("url");
		String userNm=flib.getPropertiesData("user");
		String pwd=flib.getPropertiesData("password");
		
		
		driver.get(url);
		
		wlib.maxWindow(driver);
		
		
		
		login.LoginApp(userNm, pwd);
		
		home.ClickProductLink();		
		
		
		Java_Utilities jlib=new Java_Utilities();
		int ranInt=	jlib.getRandomNum();

		Excel_Utility elib=new Excel_Utility();
		String prodname = elib.getExcelData("Sheet1", 0, 0)+ranInt;
		
		prod.AddProduct(prodname);

		prod.ClickProductList();
		delPrd.selectProdCheckBox(driver, prodname);
		delPrd.deletePrdBtn(driver);
		delPrd.validateProdDel(driver, prodname);
		Thread.sleep(2000);
		home.SignOut(driver);
		
	}
}
