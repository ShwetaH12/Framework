package QuickStart;

import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utitity;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.DeleteProdPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.ProductPage;

public class CreateandDeleteProd {

public static void main(String[] args) throws Throwable {

		
	ChromeDriver driver=new ChromeDriver();
//		Excel_Utility elib = new Excel_Utility();
//		File_Utility flib = new File_Utility();
//		Java_Utility jlib = new Java_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
	Java_Utilities jlib=new Java_Utilities();
	Excel_Utility elib=new Excel_Utility();

	WebDriver_Utility wlib=new WebDriver_Utility();

	File_Utitity flib= new File_Utitity();
	
	LoginPage login=new LoginPage(driver);
	HomePage home=new HomePage(driver);
	ProductPage prod=new ProductPage(driver);
	DeleteProdPage delPrd=new DeleteProdPage(driver);

		wlib.maxWindow(driver);
		wlib.waitPageLoad(driver);

      //reading data from properties file		

		String URL = flib.getPropertiesData("url");
		String USERNAME = flib.getPropertiesData("user");
		String PASSWORD = flib.getPropertiesData("password");

		driver.get(URL);
		//using business logics
		login.LoginApp(USERNAME, PASSWORD);

		home.ClickProductLink();
		
		prod.getProductPlusClick();

		int ranNum = jlib.getRandomNum();
		
		String prdName = elib.getExcelData("Sheet1", 0, 0)+ranNum;
        System.out.println(prdName);

        prod.getProductname();
        prod.getSaveBtn();

        //Navigating to product table

         home.ClickProductLink();
        
		//Dynamic xpath
         DeleteProdPage deletePrd = new DeleteProdPage(driver);
        deletePrd.selectProdCheckBox(driver, prdName);
        
       //click on delete button
        deletePrd.deletePrdBtn(driver);

        //Hndling Alert popup(Accept)
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		deletePrd.validatePrdDeleted(driver, prdName);
		home.SignOut(driver);
	}
}