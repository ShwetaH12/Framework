package TestNgPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Java_Utilities;

public class DataProviderOrg {

	@Test(dataProvider = "dataProviderOrg")
	public void Data_OrgCreateTest(String orgNm,String ph,String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgNm);
		driver.findElement(By.name("phone")).sendKeys(ph);
		
		driver.findElement(By.name("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
	
	@DataProvider
	public Object[][] dataProviderOrg()
	{
		Object[][] obj=new Object[2][3];
		Java_Utilities jlib=new Java_Utilities();
		int ranNum = jlib.getRandomNum();
		
		obj[0][0]="AAA"+ranNum;
		obj[0][1]="656758687";
		obj[0][2]="abc@gmail.com";
		
		obj[1][0]="BBB"+ranNum;
		obj[1][1]="656758687";
		obj[1][2]="abc@gmail.com";
		return obj;
		
	}
}
