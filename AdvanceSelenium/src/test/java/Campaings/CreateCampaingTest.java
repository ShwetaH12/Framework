package Campaings;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.WebDriver;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
import Object_Repository.HomePage;
import Object_Repository.LoginPage;

public class CreateCampaingTest extends BaseClass{
	//@Test(groups = "regression")
	@Test(retryAnalyzer =Generic_Utilities.RetryImp.class)
	public void createCampaign() throws Throwable {
		//utility objects
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utitity flib= new File_Utitity();
		Java_Utilities jlib=new Java_Utilities();
		Excel_Utility elib=new Excel_Utility();

		
		//using home page click on Campaings option and plus sign on home page 
		HomePage home=new HomePage(driver);
		home.ClickCampaign(driver);
		
		//generate unique name for Campaings 
		int ranInt=	jlib.getRandomNum();
		String camName = elib.getExcelData("Campaings", 1, 1)+ranInt;
	
		//add and save Campaings
		CampaignPage cmp=new CampaignPage(driver);
		cmp.AddCampaign(camName);
		
		//sign out using home page pom method
		Thread.sleep(2000);
		ValidatePage validP=new ValidatePage(driver);
		String expData=validP.validateCmpName(driver);
		Assert.assertEquals(expData, camName, "Assert failed");
	}

}
