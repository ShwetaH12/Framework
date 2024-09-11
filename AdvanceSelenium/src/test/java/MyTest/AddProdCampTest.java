package MyTest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utitity;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CampaignPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.ProductPage;
import Object_Repository.SwitchWinCampWithProd;

public class AddProdCampTest extends BaseClass {
	
	@Test
	public void addProdwithCamp() throws Throwable {

		//ChromeDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();
		Excel_Utility elib=new Excel_Utility();
		
//		FileInputStream fis=new FileInputStream("./src/main/resources/userDetails1.properties");
//		Properties pro=new Properties();
//		pro.load(fis);
////		
//		File_Utitity flib=new File_Utitity();
//		String url = flib.getPropertiesData("url");
////		String url = pro.getProperty("url");
//		driver.get(url);
//		wlib.maxWindow(driver);
//
//		String userNm=flib.getPropertiesData("user");
//		String pwd=flib.getPropertiesData("password");
//		
//		LoginPage login= new LoginPage(driver);
//		login.LoginApp(userNm, pwd);
		
		HomePage home= new HomePage(driver);
		home.ClickProductLink();
//		driver.findElement(By.linkText("Products")).click();
		ProductPage prod=new ProductPage(driver);
	//	prod.getProductPlusClick();
//		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		
		Java_Utilities jlib=new Java_Utilities();
		int ranInt=	jlib.getRandomNum();

		String prodname=elib.getExcelData("Sheet1", 0, 0)+ranInt;
		
		
		prod.AddProduct(prodname);
//		WebElement morelink = driver.findElement(By.linkText("More"));
//		Actions a=new Actions(driver);
//		a.moveToElement(morelink).click().perform();
//		
//		driver.findElement(By.linkText("Campaigns")).click();
//		driver.findElement(By.cssSelector("[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		
//		
		home.ClickCampaign(driver);
		String camName =elib.getExcelData("Campaings", 1, 1);

		CampaignPage cmp=new CampaignPage(driver);
//		cmp.AddCampaign(camName);
		cmp.AddCampaignWithProd(camName);
		
//		driver.findElement(By.name("campaignname")).sendKeys(camName);
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
//		String mainpage=driver.getWindowHandle();
		cmp.getProdPlusInCmp();
		wlib.switchWindow(driver, "Products&action");

		SwitchWinCampWithProd prodWin=new SwitchWinCampWithProd(driver);
		prodWin.getSearchProd().sendKeys(prodname);
		prodWin.getSearchBtn().click();
		prodWin.getSelectSearchedProd();
		cmp.getSaveBtn().click();
		
//		
//		driver.findElement(By.name("search_text")).sendKeys(prodname);
//		driver.findElement(By.name("search")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@id=\"1\"]")).click();
//		
		
		wlib.switchWindow(driver, "Campaigns&action");
//		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
	//	home.SignOut(driver);
	}
	
}
