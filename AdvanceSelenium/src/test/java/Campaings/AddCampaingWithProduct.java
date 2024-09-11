package Campaings;
import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utitity;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.ValidatePage;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CampaignPage;
import Object_Repository.DeleteProdPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.ProductPage;
import Object_Repository.SwitchWinCampWithProd;

public class AddCampaingWithProduct extends BaseClass{
	@Test
	public void addCampWithProd() throws Throwable {

		//ChromeDriver driver=new ChromeDriver();

		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ProductPage prod=new ProductPage(driver);
		CampaignPage cmg=new CampaignPage(driver);
		SwitchWinCampWithProd swCamp=new SwitchWinCampWithProd(driver);
		Excel_Utility elib=new Excel_Utility();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		File_Utitity flib=new File_Utitity();

		home.ClickProductLink();
		
		//Ramdom class from method
		Java_Utilities jlib=new Java_Utilities();
		int ranInt=	jlib.getRandomNum();
		
			
		String prodname=elib.getExcelData("Sheet1", 0, 0)+ranInt;
		prod.AddProduct(prodname);
		
		home.ClickCampaign(driver);
		
		String camName = elib.getExcelData("Campaings", 1, 1)+ranInt;
		cmg.AddCampaignWithProd(camName);
		cmg.getProdPlusInCmp().click();
		wlib.switchWindow(driver, "Products&action");

		SwitchWinCampWithProd sw=new SwitchWinCampWithProd(driver);
		sw.searchProdAdd(prodname);
		wlib.switchWindow(driver, "Campaigns&action");

		cmg.getSaveBtn().click();

		Thread.sleep(2000);
		//home.SignOut(driver);
		
		ValidatePage validP=new ValidatePage(driver);
		String expData=validP.validateCmpName(driver);
		Assert.assertEquals(expData, camName, "Assert failed");
		

//		//ValidatePage validP=new ValidatePage(driver);
//		String expData1=validP.validateProductName(driver);
//		Assert.assertEquals(expData1, prodname, "Assert pass");
		
	}
	
}
