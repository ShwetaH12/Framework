package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repository.HomePage;
import Object_Repository.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	@BeforeSuite(groups = {"smoke","regression"})
	public void BS()
	{
		System.out.println("Database connection open");
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void BT()
	{
		System.out.println("Parellel execution");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	//public void BC(String BROWSER) throws Throwable --when reading from xml using Parameters
	public void BC() throws Throwable
	{
		File_Utitity flib= new File_Utitity();

		String BROWSER=flib.getPropertiesData("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		System.out.println("Launch Browser ");
	}
	
	//@Parameters({"userNm","pwd"})
	@BeforeMethod(groups = {"smoke","regression"})
	//public void BM(String userNm,String pwd) throws Throwable ----when reading from xml using Parameters
	public void BM() throws Throwable
	{
		WebDriver_Utility wlib=new WebDriver_Utility();

		File_Utitity flib= new File_Utitity();
		String url=flib.getPropertiesData("url");
		String userNm=flib.getPropertiesData("user");
		String pwd=flib.getPropertiesData("password");
		driver.get(url);
		wlib.maxWindow(driver);
		
		LoginPage login= new LoginPage(driver);
		login.LoginApp(userNm, pwd);
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void AM()
	{
		HomePage home= new HomePage(driver);

		home.SignOut(driver);
		System.out.println("close application ");

	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void AC()
	{
		driver.close();
		System.out.println("close Browser ");

	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void AT()
	{
		System.out.println("Parallel execution done");

	}
	@AfterSuite(groups = {"smoke","regression"})
	public void AS()
	{
		System.out.println("database connnection close ");

	}
	
}
